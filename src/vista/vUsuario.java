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

public class vUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JLabel lblId;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vUsuario frame = new vUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsuario.setBounds(144, 121, 156, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(72, 127, 71, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraseña.setBounds(43, 164, 103, 14);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(144, 160, 156, 28);
		contentPane.add(txtContraseña);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario usuario = new Usuario();
					usuario.setUsuario(txtUsuario.getText());
					usuario.setContraseña(txtContraseña.getText());
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 109, 518, 300);
		contentPane.add(scrollPane);
		
		tblRoles = new JTable();
		tblRoles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(95, 88, 28, 17);
		lblId.setVisible(false);
		contentPane.add(lblId);
		
		tblRoles.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int item = 0;
				fila=tblRoles.getSelectedRow();
				usuario=lista.get(fila);
				lblId.setText(String.valueOf(usuario.getId()));
				txtUsuario.setText(usuario.getUsuario());
				txtContraseña.setText(usuario.getContraseña());
				if (usuario.getRol().getNombreRol().equals("FUNCIONARIO")) {
					item = 1;
				}
				cbxNombreRol.setSelectedIndex(item);
			}
			
		});
		
		
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
		JLabel lblRol = new JLabel("Rol:\r\n");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRol.setBounds(105, 205, 85, 17);
		contentPane.add(lblRol);
		
		cbxNombreRol = new JComboBox();
		cbxNombreRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxNombreRol.setModel(new DefaultComboBoxModel(new String[] {"Medico", "Funcionario"}));
		cbxNombreRol.setBounds(144, 199, 156, 28);
		contentPane.add(cbxNombreRol);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getId() != 1) {
					try {
						usuario.setUsuario(txtUsuario.getText());
						usuario.setContraseña(txtContraseña.getText());
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
		
		JLabel lblRoles = new JLabel("Usuarios");
		lblRoles.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblRoles.setBounds(352, 29, 156, 51);
		contentPane.add(lblRoles);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar.setBounds(94, 379, 125, 36);
		contentPane.add(btnLimpiar);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vUsuario.this.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 29, 85, 36);
		contentPane.add(btnAtras);
		
		
	}
	
	private void limpiarCampos() {
		txtUsuario.setText("");
		txtContraseña.setText("");
		lblId.setText("");
	}
	
	public void actualizarTabla() {
		//elimina los registros para volverlos a crear
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		
		lista=dao.ConsultaUsuario();
		
		for (Usuario u:lista) {
			Object usuario[]= new Object[3];
			usuario[0]=u.getUsuario();
			usuario[1]=u.getContraseña();
			usuario[2]=u.getRol().getNombreRol();
			modelo.addRow(usuario);
		}
		tblRoles.setModel(modelo);
	}
}
