package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class vGestores extends JFrame {
	JLabel lblRol = new JLabel("Rol");
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vGestores frame = new vGestores();
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
	public vGestores() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JLabel lblCaptionRol = new JLabel("Rol:");
		contentPane.setLayout(null);
		lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(723, 10, 20, 16);
		contentPane.add(lblCaptionRol);
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(745, 10, 94, 16);
		contentPane.add(lblRol);
		
		JLabel lblCanti = new JLabel("Cantidad de pacientes atendidos por un m\u00E9dico en un rango de fechas dadas:");
		lblCanti.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblCanti.setBounds(133, 86, 523, 22);
		contentPane.add(lblCanti);
		
		JLabel lblCantidadDePacientes = new JLabel("Cantidad de pacientes atendidos en un rango de fechas y edades dadas:");
		lblCantidadDePacientes.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblCantidadDePacientes.setBounds(133, 154, 523, 22);
		contentPane.add(lblCantidadDePacientes);
		
		JLabel lblGestores = new JLabel("Gestores");
		lblGestores.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblGestores.setBounds(337, 23, 164, 33);
		contentPane.add(lblGestores);
		
		JLabel lblPacientesQueMs = new JLabel("Paciente/s que m\u00E1s consultaron en un rango de fechas:");
		lblPacientesQueMs.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblPacientesQueMs.setBounds(133, 208, 535, 22);
		contentPane.add(lblPacientesQueMs);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Código para volver al menú principal
                menuPrincipal menu = new menuPrincipal();
                menu.transferirDatos(lblRol.getText());
                menu.setVisible(true);
                vGestores.this.dispose(); // Cierra la ventana actual
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(10, 23, 85, 36);
		contentPane.add(btnVolver);
		
		JLabel lblMdicosQueMs = new JLabel("M\u00E9dico/s que m\u00E1s pacientes haya atendido en un rango de fechas:");
		lblMdicosQueMs.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblMdicosQueMs.setBounds(133, 283, 523, 22);
		contentPane.add(lblMdicosQueMs);
		
		JLabel lblTriageRealizadoEn = new JLabel("Triage realizado en un rango de fechas, indicandose la cantidad de cada color:");
		lblTriageRealizadoEn.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblTriageRealizadoEn.setBounds(133, 342, 523, 22);
		contentPane.add(lblTriageRealizadoEn);
		
		JLabel lblCantidadDeTriage = new JLabel("Cantidad de triage que fueron cambiados por quien efectu\u00F3 el traigado");
		lblCantidadDeTriage.setVerticalAlignment(SwingConstants.TOP);
		lblCantidadDeTriage.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeTriage.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblCantidadDeTriage.setBounds(133, 409, 523, 30);
		contentPane.add(lblCantidadDeTriage);
		
		JLabel lblColorPropuestoPor = new JLabel("indicando color propuesto por el sistema y el color asignado por el funcionario:");
		lblColorPropuestoPor.setVerticalAlignment(SwingConstants.TOP);
		lblColorPropuestoPor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColorPropuestoPor.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblColorPropuestoPor.setBounds(133, 427, 535, 22);
		contentPane.add(lblColorPropuestoPor);
		
		JButton btnConsultar = new JButton("Consultar\r\n");
		btnConsultar.setVerticalAlignment(SwingConstants.TOP);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(511, 112, 102, 24);
		contentPane.add(btnConsultar);
		
		textField = new JTextField();
		textField.setText("26/10/2023");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(228, 111, 85, 22);
		contentPane.add(textField);
		
		JLabel lblFechaDesde = new JLabel("Fecha desde:");
		lblFechaDesde.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaDesde.setBounds(133, 113, 85, 16);
		contentPane.add(lblFechaDesde);
		
		JLabel lblFechaHasta = new JLabel("Fecha hasta:");
		lblFechaHasta.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaHasta.setBounds(326, 113, 85, 16);
		contentPane.add(lblFechaHasta);
		
		textField_1 = new JTextField();
		textField_1.setText("26/10/2023");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(416, 111, 85, 22);
		contentPane.add(textField_1);
		
		JLabel lblFechaDesde1 = new JLabel("Fecha desde:");
		lblFechaDesde1.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaDesde1.setBounds(133, 181, 85, 16);
		contentPane.add(lblFechaDesde1);
		
		textField_2 = new JTextField();
		textField_2.setText("26/10/2023");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(228, 181, 85, 22);
		contentPane.add(textField_2);
		
		JLabel lblFechaHasta1 = new JLabel("Fecha hasta:");
		lblFechaHasta1.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaHasta1.setBounds(326, 181, 85, 16);
		contentPane.add(lblFechaHasta1);
		
		textField_3 = new JTextField();
		textField_3.setText("26/10/2023");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(416, 181, 85, 22);
		contentPane.add(textField_3);
		
		JButton btnConsultar1 = new JButton("Consultar\r\n");
		btnConsultar1.setVerticalAlignment(SwingConstants.TOP);
		btnConsultar1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar1.setBounds(511, 181, 102, 22);
		contentPane.add(btnConsultar1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(133, 146, 535, 9);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(141, 208, 527, 9);
		contentPane.add(separator_1);
		
		textField_4 = new JTextField();
		textField_4.setText("26/10/2023");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(228, 241, 85, 22);
		contentPane.add(textField_4);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(133, 274, 535, 9);
		contentPane.add(separator_1_1);
		
		textField_5 = new JTextField();
		textField_5.setText("26/10/2023");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(416, 241, 85, 22);
		contentPane.add(textField_5);
		
		JButton btnConsultar2 = new JButton("Consultar\r\n");
		btnConsultar2.setVerticalAlignment(SwingConstants.TOP);
		btnConsultar2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar2.setBounds(511, 228, 102, 22);
		contentPane.add(btnConsultar2);
		
		textField_6 = new JTextField();
		textField_6.setText("26/10/2023");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(228, 309, 85, 22);
		contentPane.add(textField_6);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(133, 338, 523, 9);
		contentPane.add(separator_1_2);
		
		textField_7 = new JTextField();
		textField_7.setText("26/10/2023");
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(416, 309, 85, 22);
		contentPane.add(textField_7);
		
		JButton btnConsultar3 = new JButton("Consultar\r\n");
		btnConsultar3.setVerticalAlignment(SwingConstants.TOP);
		btnConsultar3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar3.setBounds(511, 310, 102, 22);
		contentPane.add(btnConsultar3);
		
		textField_8 = new JTextField();
		textField_8.setText("26/10/2023");
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(228, 369, 85, 22);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("26/10/2023");
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(416, 369, 85, 22);
		contentPane.add(textField_9);
		
		JButton btnConsultar4 = new JButton("Consultar\r\n");
		btnConsultar4.setVerticalAlignment(SwingConstants.TOP);
		btnConsultar4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar4.setBounds(511, 370, 102, 22);
		contentPane.add(btnConsultar4);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(133, 406, 535, 9);
		contentPane.add(separator_1_2_1);
		
		JButton btnConsultar5 = new JButton("Consultar\r\n");
		btnConsultar5.setVerticalAlignment(SwingConstants.TOP);
		btnConsultar5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar5.setBounds(511, 450, 102, 22);
		contentPane.add(btnConsultar5);
		
		JLabel lblFechaDesde2 = new JLabel("Fecha desde:");
		lblFechaDesde2.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaDesde2.setBounds(133, 241, 85, 16);
		contentPane.add(lblFechaDesde2);
		
		JLabel lblFechaHasta2 = new JLabel("Fecha hasta:");
		lblFechaHasta2.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaHasta2.setBounds(326, 241, 85, 16);
		contentPane.add(lblFechaHasta2);
		
		JLabel lblFechaDesde3 = new JLabel("Fecha desde:");
		lblFechaDesde3.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaDesde3.setBounds(133, 309, 85, 16);
		contentPane.add(lblFechaDesde3);
		
		JLabel lblFechaHasta3 = new JLabel("Fecha hasta:");
		lblFechaHasta3.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaHasta3.setBounds(326, 309, 85, 16);
		contentPane.add(lblFechaHasta3);
		
		JLabel lblFechaDesde4 = new JLabel("Fecha desde:");
		lblFechaDesde4.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaDesde4.setBounds(133, 369, 85, 16);
		contentPane.add(lblFechaDesde4);
		
		JLabel lblFechaHasta4 = new JLabel("Fecha hasta:");
		lblFechaHasta4.setFont(new Font("Gadugi", Font.PLAIN, 15));
		lblFechaHasta4.setBounds(326, 369, 85, 16);
		contentPane.add(lblFechaHasta4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(128, 76, 540, 9);
		contentPane.add(separator_2);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(128, 477, 540, 9);
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_2_1 = new JSeparator();
		separator_1_2_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_2_1.setBounds(128, 76, 13, 403);
		contentPane.add(separator_1_2_2_1);
		
		JSeparator separator_1_2_2_1_1 = new JSeparator();
		separator_1_2_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_2_1_1.setBounds(669, 76, 13, 403);
		contentPane.add(separator_1_2_2_1_1);
	}

	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
