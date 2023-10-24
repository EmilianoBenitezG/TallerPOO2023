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

public class vGestores extends JFrame {
	JLabel lblRol = new JLabel("Rol");
	private JPanel contentPane;

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
		lblCanti.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblCanti.setBounds(148, 113, 473, 16);
		contentPane.add(lblCanti);
		
		JLabel lblCantidadDePacientes = new JLabel("Cantidad de pacientes atendidos en un rango de fechas y edades dadas:");
		lblCantidadDePacientes.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblCantidadDePacientes.setBounds(148, 146, 434, 16);
		contentPane.add(lblCantidadDePacientes);
		
		JLabel lblGestores = new JLabel("Gestores");
		lblGestores.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblGestores.setBounds(337, 23, 164, 33);
		contentPane.add(lblGestores);
		
		JLabel lblPacientesQueMs = new JLabel("Paciente/s que m\u00E1s consultaron en un rango de fechas:");
		lblPacientesQueMs.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblPacientesQueMs.setBounds(148, 179, 343, 16);
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
		lblMdicosQueMs.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblMdicosQueMs.setBounds(148, 212, 405, 16);
		contentPane.add(lblMdicosQueMs);
		
		JLabel lblTriageRealizadoEn = new JLabel("Triage realizado en un rango de fechas, indicandose la cantidad de cada color:");
		lblTriageRealizadoEn.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblTriageRealizadoEn.setBounds(148, 245, 473, 16);
		contentPane.add(lblTriageRealizadoEn);
		
		JLabel lblCantidadDeTriage = new JLabel("Cantidad de triage que fueron cambiados por quien efectu\u00F3 el traigado indicando");
		lblCantidadDeTriage.setVerticalAlignment(SwingConstants.TOP);
		lblCantidadDeTriage.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeTriage.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblCantidadDeTriage.setBounds(148, 278, 505, 18);
		contentPane.add(lblCantidadDeTriage);
		
		JLabel lblColorPropuestoPor = new JLabel("color propuesto por el sistema y el color asignado por el funcionario:");
		lblColorPropuestoPor.setVerticalAlignment(SwingConstants.TOP);
		lblColorPropuestoPor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColorPropuestoPor.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		lblColorPropuestoPor.setBounds(148, 297, 422, 18);
		contentPane.add(lblColorPropuestoPor);
		
		JButton btnOpcion1 = new JButton("-");
		btnOpcion1.setVerticalAlignment(SwingConstants.TOP);
		btnOpcion1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpcion1.setBounds(620, 107, 37, 22);
		contentPane.add(btnOpcion1);
		
		JButton btnOpcion2 = new JButton("-");
		btnOpcion2.setVerticalAlignment(SwingConstants.TOP);
		btnOpcion2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpcion2.setBounds(584, 140, 37, 22);
		contentPane.add(btnOpcion2);
		
		JButton btnOpcion3 = new JButton("-");
		btnOpcion3.setVerticalAlignment(SwingConstants.TOP);
		btnOpcion3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpcion3.setBounds(482, 173, 37, 22);
		contentPane.add(btnOpcion3);
		
		JButton btnOpcion4 = new JButton("-");
		btnOpcion4.setVerticalAlignment(SwingConstants.TOP);
		btnOpcion4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpcion4.setBounds(548, 207, 37, 22);
		contentPane.add(btnOpcion4);
		
		JButton btnOpcion5 = new JButton("-");
		btnOpcion5.setVerticalAlignment(SwingConstants.TOP);
		btnOpcion5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpcion5.setBounds(620, 239, 37, 22);
		contentPane.add(btnOpcion5);
		
		JButton btnOpcion6 = new JButton("-");
		btnOpcion6.setVerticalAlignment(SwingConstants.TOP);
		btnOpcion6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpcion6.setBounds(567, 294, 37, 22);
		contentPane.add(btnOpcion6);
	}

	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
