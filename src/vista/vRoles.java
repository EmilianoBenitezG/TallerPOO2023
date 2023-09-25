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
import modelo.Roles;
import dao.daoRoles;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class vRoles extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrase�a;
	DefaultTableModel modelo = new DefaultTableModel();
	daoRoles dao = new daoRoles();
	ArrayList<Roles> lista;
	private JTable tblRoles;
	private JComboBox cbxNivelAcceso;
	int fila=-1;
	Roles roles = new Roles();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vRoles frame = new vRoles();
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
	public vRoles() {
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
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a:");
		lblContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrase�a.setBounds(43, 164, 103, 14);
		contentPane.add(lblContrase�a);
		
		txtContrase�a = new JTextField();
		txtContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContrase�a.setColumns(10);
		txtContrase�a.setBounds(144, 160, 156, 28);
		contentPane.add(txtContrase�a);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Roles roles = new Roles();
					roles.setUsuario(txtUsuario.getText());
					roles.setContrase�a(txtContrase�a.getText());
					roles.setNivelAcceso(cbxNivelAcceso.getSelectedItem().toString());
					daoRoles daoroles = new daoRoles();
					if(daoroles.insertarRoles(roles)) {
						actualizarTabla();
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
		
		tblRoles.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int item = 0;
				fila=tblRoles.getSelectedRow();
				roles=lista.get(fila);
				//lblId.setText
				txtUsuario.setText(roles.getUsuario());
				txtContrase�a.setText(roles.getContrase�a());
				if (roles.getNivelAcceso().equals("FUNCIONARIO")) {
					item = 1;
				}
				cbxNivelAcceso.setSelectedIndex(item);
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
		modelo.addColumn("Usuario");
		modelo.addColumn("Contrase�a");
		modelo.addColumn("Nivel de Acceso");
		actualizarTabla();
		setLocationRelativeTo(null);
		JLabel lblNivelAcceso = new JLabel("Nivel de Acceso:\r\n");
		lblNivelAcceso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNivelAcceso.setBounds(10, 206, 134, 14);
		contentPane.add(lblNivelAcceso);
		
		cbxNivelAcceso = new JComboBox();
		cbxNivelAcceso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxNivelAcceso.setModel(new DefaultComboBoxModel(new String[] {"Medico", "Funcionario"}));
		cbxNivelAcceso.setBounds(144, 199, 156, 28);
		contentPane.add(cbxNivelAcceso);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(94, 285, 125, 36);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(94, 332, 125, 36);
		contentPane.add(btnEliminar);
		
		JLabel lblRoles = new JLabel("Roles");
		lblRoles.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblRoles.setBounds(362, 29, 103, 51);
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(95, 88, 28, 17);
		lblId.setVisible(false);
		contentPane.add(lblId);
	}
	
	private void limpiarCampos() {
		txtUsuario.setText("");
		txtContrase�a.setText("");
	}
	
	public void actualizarTabla() {
		//elimina los registros para volverlos a crear
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		
		lista=dao.ConsultaRoles();
		
		for (Roles u:lista) {
			Object roles[]= new Object[3];
			roles[0]=u.getUsuario();
			roles[1]=u.getContrase�a();
			roles[2]=u.getNivelAcceso();
			modelo.addRow(roles);
		}
		tblRoles.setModel(modelo);
	}
}
