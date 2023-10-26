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
	JLabel lblRol = new JLabel("Rol");
	JButton btnUsuarios = new JButton("Usuarios");
	JButton btnPacientes = new JButton("Pacientes");
	JButton btnHistoriaClinica = new JButton("Historia Clinica");
	JButton btnAdmision = new JButton("Admision");
	JButton btnTriage = new JButton("Triage");
	JButton btnGestor = new JButton("Gestores");
	JButton btnFuncionario = new JButton("Funcionarios");

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
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vUsuario vusuario = new vUsuario();
				vusuario.transferirDatos(lblRol.getText());
				vusuario.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUsuarios.setBounds(94, 145, 141, 51);
		contentPane.add(btnUsuarios);

		// Botón "Funcionario" que abre la vista de usuarios
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vFuncionarios vfuncionarios = new vFuncionarios();
				vfuncionarios.transferirDatos(lblRol.getText());
				vfuncionarios.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnFuncionario.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFuncionario.setBounds(416, 231, 141, 51);
		contentPane.add(btnFuncionario);

		// Botón "Pacientes" que abre la vista de pacientes
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPaciente vpaciente = new vPaciente();
				vpaciente.transferirDatos(lblRol.getText());
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
				login.transferirDatos(lblRol.getText());
				login.setVisible(true);
			}
		});
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrarSesion.setBounds(556, 454, 129, 39);
		contentPane.add(btnCerrarSesion);

		// Botón "Historia Clínica" que abre la vista de historias clínicas
		btnHistoriaClinica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vHistoriaClinica historiaClinica = new vHistoriaClinica();
				historiaClinica.transferirDatos(lblRol.getText());
				historiaClinica.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnHistoriaClinica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHistoriaClinica.setBounds(580, 231, 141, 51);
		contentPane.add(btnHistoriaClinica);

		// Botón "Admision" que abre la vista de la pantalla admision
		btnAdmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vAdmision admision = new vAdmision();
				admision.transferirDatos(lblRol.getText());
				admision.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnAdmision.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdmision.setBounds(416, 145, 141, 51);
		contentPane.add(btnAdmision);

		// Botón "Triage" que abre la vista de triage
		btnTriage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vTriage vTriage = new vTriage();
				vTriage.transferirDatos(lblRol.getText());
				vTriage.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnTriage.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTriage.setBounds(580, 145, 141, 51);
		contentPane.add(btnTriage);

		JLabel lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(727, 11, 25, 18);
		contentPane.add(lblCaptionRol);
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(752, 11, 98, 18);
		contentPane.add(lblRol);

		btnGestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vGestores gestores = new vGestores();
				gestores.transferirDatos(lblRol.getText());
				gestores.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnGestor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestor.setBounds(255, 231, 129, 51);
		contentPane.add(btnGestor);
		
		JButton btnAtencion = new JButton("Atencion");
		btnAtencion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vAtencion admision = new vAtencion();
				admision.setVisible(true);
				menuPrincipal.this.setVisible(false);
			}
		});
		btnAtencion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtencion.setBounds(94, 231, 141, 51);
		contentPane.add(btnAtencion);
		setLocationRelativeTo(null);
	}

	public void transferirDatos(String rol) {
		lblRol.setText(rol);
		ocultarPantallasByRol(rol);
	}

	public void ocultarPantallasByRol(String rol) {
		ocultarBotones();
		switch (rol) {
		case "ADMINISTRADOR":
			btnUsuarios.setVisible(true);
			break;
		case "MEDICO":
			btnPacientes.setVisible(true);
			btnHistoriaClinica.setVisible(true);
			btnAdmision.setVisible(true);
			btnTriage.setVisible(true);
			btnGestor.setVisible(true);
			break;
		case "FUNCIONARIO":
			btnPacientes.setVisible(true);
			btnHistoriaClinica.setVisible(true);
			btnAdmision.setVisible(true);
			btnTriage.setVisible(true);
			btnGestor.setVisible(true);
			break;
		case "GESTOR":
			btnPacientes.setVisible(true);
			btnHistoriaClinica.setVisible(true);
			btnAdmision.setVisible(true);
			btnTriage.setVisible(true);
			btnGestor.setVisible(true);
			break;
		default:
		}
	}

	private void ocultarBotones() {
		/*btnUsuarios.setVisible(false);
		btnPacientes.setVisible(false);
		btnHistoriaClinica.setVisible(false);
		btnAdmision.setVisible(false);
		btnTriage.setVisible(false);
		btnGestor.setVisible(false);*/
	}
}
