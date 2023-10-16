package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.daoLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

public class vLogin extends JFrame {

	private JPanel contentPane;
	private final JLabel lblTitulo = new JLabel("Sistema de Triaje");
	private JTextField txtUsuario;
	daoLogin dao = new daoLogin();
	private JPasswordField txtContraseña;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vLogin login = new vLogin();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTitulo.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblTitulo.setBounds(268, 125, 314, 51);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD | Font.ITALIC, 22));
		lblUsuario.setBounds(309, 199, 98, 39);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:\r\n");
		lblContrasea.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD | Font.ITALIC, 22));
		lblContrasea.setBounds(272, 249, 122, 39);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(407, 209, 130, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				if(!txtUsuario.getText().isEmpty() && !txtContraseña.getText().isEmpty()) {
					String rol = dao.login(txtUsuario.getText().toUpperCase(), txtContraseña.getText().toUpperCase());
					if (!rol.isEmpty()) {
						//abro ventana principal
						menuPrincipal.setVisible(true);
						//cierro ventana login
						vLogin.this.dispose();
					}else {
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta");
					}
				}else {
					limpiarCampos();
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				}
			}

		});
		btnIngresar.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 15));
		btnIngresar.setBounds(370, 314, 122, 31);
		contentPane.add(btnIngresar);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(407, 261, 130, 23);
		contentPane.add(txtContraseña);
		setLocationRelativeTo(null);
	}
	
	private void limpiarCampos() {
		txtUsuario.setText("");
		txtContraseña.setText("");
	}
}
