package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal menuPrincipal = new menuPrincipal();
					menuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta que muestra el título "Menu Principal"
		JLabel lblRoles = new JLabel("Menu Principal");
		lblRoles.setBounds(282, 45, 275, 51);
		lblRoles.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		contentPane.add(lblRoles);

		// Botón "Usuarios" que abre la vista de usuarios
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vUsuario vusuario = new vUsuario();
				vusuario.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUsuarios.setBounds(94, 145, 129, 51);
		contentPane.add(btnUsuarios);

		// Botón "Pacientes" que abre la vista de pacientes
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPaciente vpaciente = new vPaciente();
				vpaciente.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPacientes.setBounds(255, 145, 129, 51);
		contentPane.add(btnPacientes);

		// Botón "Salir" que cierra la aplicación
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.this.dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalir.setBounds(699, 454, 118, 39);
		contentPane.add(btnSalir);

		// Botón "Cerrar Sesión" que cierra la sesión actual
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.this.setVisible(false);
				vLogin login = new vLogin();
				login.setVisible(true);
			}
		});
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrarSesion.setBounds(556, 454, 129, 39);
		contentPane.add(btnCerrarSesion);

		// Botón "Historia Clínica" que abre la vista de historias clínicas
		JButton btnHistoriaClinica = new JButton("Historia Clinica");
		btnHistoriaClinica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vHistoriaClinica historiaClinica = new vHistoriaClinica();
				historiaClinica.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnHistoriaClinica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHistoriaClinica.setBounds(416, 145, 141, 51);
		contentPane.add(btnHistoriaClinica);

		// Botón "Admision" que abre la vista de la pantalla admision
		JButton btnAdmision = new JButton("Admision");
		btnAdmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vAdmision admision = new vAdmision();
				admision.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnAdmision.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdmision.setBounds(94, 231, 141, 51);
		contentPane.add(btnAdmision);

		// Botón "Triage" que abre la vista de triage
		JButton btnTriage = new JButton("Triage");
		btnTriage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vTriage vTriage = new vTriage();
				vTriage.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnTriage.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTriage.setBounds(580, 145, 118, 51);
		contentPane.add(btnTriage);
		setLocationRelativeTo(null);
	}
}
