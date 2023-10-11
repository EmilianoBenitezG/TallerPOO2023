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
	vUsuario vusuario = new vUsuario();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoles = new JLabel("Menu Principal");
		lblRoles.setBounds(282, 45, 275, 51);
		lblRoles.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		contentPane.add(lblRoles);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vusuario.setVisible(true);
				menuPrincipal.this.dispose();
			}
		});
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUsuarios.setBounds(147, 145, 129, 51);
		contentPane.add(btnUsuarios);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPacientes.setBounds(340, 145, 129, 51);
		contentPane.add(btnPacientes);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalir.setBounds(699, 454, 109, 39);
		contentPane.add(btnSalir);
		setLocationRelativeTo(null);
	}
}
