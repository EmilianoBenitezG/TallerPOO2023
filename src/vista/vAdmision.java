package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class vAdmision extends JFrame {
	
	private JTextField txtfecha;
	private JTextField txthora;
	private JComboBox comboBox_3;
	private JPanel contentPane;
	private JTextField textField;
	private JTable tblAdmision;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vAdmision frame = new vAdmision();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public vAdmision() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(415, 11, 470, 470);
		contentPane.add(panel);
		
		tblAdmision.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null },

				}, new String[] { "Nombre", "DNI", "Motivo Consulta", "Fecha", "Hora"}));
		scrollPane.setViewportView(tblAdmision);
		
		JLabel lblPacientes = new JLabel("Admision");
		lblPacientes.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblPacientes.setBounds(122, 13, 178, 33);
		contentPane.add(lblPacientes);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(204, 126, 170, 22);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);

		JLabel lblNombre = new JLabel("Hora: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(35, 195, 81, 22);
		contentPane.add(lblNombre);

		txthora = new JTextField();
		txthora.setColumns(10);
		txthora.setBounds(204, 162, 170, 22);
		contentPane.add(txthora);

		JLabel lblApellido = new JLabel("Fecha: ");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(35, 162, 81, 22);
		contentPane.add(lblApellido);
		
		JLabel lblPaciente = new JLabel("Paciente: ");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaciente.setBounds(35, 91, 81, 22);
		contentPane.add(lblPaciente);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setToolTipText("Seleccione una opcion");
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Aca va la lista de pacientes"}));
		comboBox_3.setSelectedIndex(0);
		comboBox_3.setMaximumRowCount(4);
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_3.setBounds(142, 93, 232, 22);
		contentPane.add(comboBox_3);
		
		JLabel lblMotivoConsulta = new JLabel("Motivo Consulta: ");
		lblMotivoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMotivoConsulta.setBounds(35, 129, 139, 22);
		contentPane.add(lblMotivoConsulta);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(204, 195, 170, 22);
		contentPane.add(textField);
	}
}
