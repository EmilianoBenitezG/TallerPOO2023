package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modelo.Usuario;
import modelo.Rol;
import dao.daoUsuario;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;

public class vUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblId;
	JLabel lblRol = new JLabel("Rol");
	String[] columnNames = {"Usuario", "Contraseña", "Nivel acceso"};
	Object[][] data = {};
	 DefaultTableModel modelo = new DefaultTableModel(data, columnNames) {
         @Override
         public boolean isCellEditable(int row, int col) {
             return false;
         }
     };
	daoUsuario dao = new daoUsuario();
	ArrayList<Usuario> lista;
	private JTable tblRoles;
	private JComboBox cbxNombreRol;
	int fila=-1;
	Usuario usuario = new Usuario();
	private JPasswordField txtContrasenia;
	
	/**
	 * Create the frame.
	 */
	public vUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Componentes para ingresar el usuario.
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsuario.setBounds(127, 121, 173, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		// Etiqueta para "Usuario".
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(58, 125, 71, 17);
		contentPane.add(lblUsuario);
		
		// Etiqueta para "Contrasenia".
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(28, 164, 103, 14);
		contentPane.add(lblContrasenia);
		
		// Boton para "Agregar".
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario usuario = new Usuario();
					usuario.setUsuario(txtUsuario.getText());
					usuario.setContrasenia(txtContrasenia.getText());
					Integer idRol = cbxNombreRol.getSelectedIndex();
					String nombreRol = cbxNombreRol.getSelectedItem().toString();
					Rol rol = new Rol(idRol,nombreRol);
					usuario.setRol(rol);
					daoUsuario daousuario = new daoUsuario();
					if(daousuario.insertarUsuario(usuario)) {
						actualizarTabla();
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "Se agrego correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "Error al agregar rol");
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnAgregar.setBounds(94, 238, 125, 36);
		contentPane.add(btnAgregar);
		
		// Panel de desplazamiento para mostrar la tabla de roles.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 109, 518, 300);
		contentPane.add(scrollPane);
		
		tblRoles = new JTable();
		tblRoles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Etiqueta oculta para "ID".
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(95, 88, 28, 17);
		lblId.setVisible(false);
		contentPane.add(lblId);
		
		// Manejador de eventos cuando se hace clic en la tabla de roles.
		tblRoles.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int item = 0;
				fila=tblRoles.getSelectedRow();
				usuario=lista.get(fila);
				lblId.setText(String.valueOf(usuario.getId()));
				txtUsuario.setText(usuario.getUsuario());
				txtContrasenia.setText(usuario.getContrasenia());
				if (usuario.getRol().getNombreRol().equals("FUNCIONARIO")) {
					item = 1;
				}
				cbxNombreRol.setSelectedIndex(item);
			}
			
		});
		
		// Creacion de la tabla de roles.
		tblRoles.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblRoles);
		actualizarTabla();
		setLocationRelativeTo(null);
		// Etiqueta para "Rol".
		JLabel lblRol_1 = new JLabel("Rol:\r\n");
		lblRol_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRol_1.setBounds(89, 205, 35, 17);
		contentPane.add(lblRol_1);
		
		// Lista desplegable para seleccionar el rol.
		cbxNombreRol = new JComboBox();
		cbxNombreRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxNombreRol.setModel(new DefaultComboBoxModel(new String[] {"Medico", "Funcionario", "Licenciado en Enfermeria", "Gestor"}));
		cbxNombreRol.setBounds(127, 199, 173, 28);
		contentPane.add(cbxNombreRol);
		
		// Boton para "Modificar".
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getId() != 1) {
					try {
						usuario.setUsuario(txtUsuario.getText());
						usuario.setContrasenia(txtContrasenia.getText());
						Integer idRol = cbxNombreRol.getSelectedIndex();
						String nombreRol = cbxNombreRol.getSelectedItem().toString();
						Rol rol = new Rol(idRol,nombreRol);
						usuario.setRol(rol);
						if(dao.modificarUsuario(usuario)) {
							actualizarTabla();
							limpiarCampos();
							JOptionPane.showMessageDialog(null, "Se modifico correctamente");
						}else {
							JOptionPane.showMessageDialog(null, "Error al modificar rol");
						}
					}catch(Exception e2){
						JOptionPane.showMessageDialog(null, "Error");
					}
				}else {
					JOptionPane.showMessageDialog(null, "No se puede modificar al rol Administrador");
				}
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(94, 285, 125, 36);
		contentPane.add(btnModificar);
		
		// Boton para "Eliminar".
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getId() != 1) {
					try {
						if(dao.eliminarUsuario(usuario.getId())) {
							actualizarTabla();
							limpiarCampos();
							JOptionPane.showMessageDialog(null, "Se elimino correctamente");
						}else {
							JOptionPane.showMessageDialog(null, "Error al eliminar rol");
						}
					}catch(Exception e2){
						JOptionPane.showMessageDialog(null, "Error");
					}
				}else {
					JOptionPane.showMessageDialog(null, "No se puede elimiar al rol Administrador");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(94, 332, 125, 36);
		contentPane.add(btnEliminar);
		
		// Etiqueta para mostrar "Usuarios".
		JLabel lblRoles = new JLabel("Usuarios");
		lblRoles.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblRoles.setBounds(352, 29, 156, 51);
		contentPane.add(lblRoles);
		
		// Boton para "Limpiar" los campos.
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar.setBounds(94, 379, 125, 36);
		contentPane.add(btnLimpiar);
		
		// Boton para "Volver" al menu principal.
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vUsuario.this.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 29, 85, 36);
		contentPane.add(btnAtras);
		
		// Campo de contrasenia oculto para el usuario.
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(127, 160, 173, 28);
		contentPane.add(txtContrasenia);
		
		// Etiqueta para mostrar el rol del usuario (etiqueta oculta al principio).
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(729, 11, 98, 18);
		contentPane.add(lblRol);
		
		// Etiqueta para "Rol" (etiqueta oculta al principio).
		JLabel lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(704, 11, 25, 18);
		contentPane.add(lblCaptionRol);
	}
	
	private void limpiarCampos() {
		txtUsuario.setText("");
		txtContrasenia.setText("");
		lblId.setText("");
	}
	
	public void actualizarTabla() {
		// Elimina los registros para volverlos a crear.
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		
		lista=dao.ConsultaUsuario();
		
		for (Usuario u:lista) {
			Object usuario[]= new Object[3];
			usuario[0]=u.getUsuario();
			usuario[1]="****************";
			usuario[2]=u.getRol().getNombreRol();
			modelo.addRow(usuario);
		}
		tblRoles.setModel(modelo);
	}
	
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
