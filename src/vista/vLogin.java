// Declaraci�n de las importaciones necesarias para las bibliotecas requeridas
package vista;

// Varias importaciones para diferentes componentes de Swing y la clase DAO
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

// Definici�n de la clase principal vLogin, que extiende JFrame
public class vLogin extends JFrame {

	// Declaraci�n de variables a nivel de clase
	private JPanel contentPane;
	private final JLabel lblTitulo = new JLabel("Sistema de Triage");
	private JTextField txtUsuario;
	daoLogin dao = new daoLogin();
	private JPasswordField txtContrasenia;
	JLabel lblRol = new JLabel("Rol");

	// M�todo principal para iniciar la aplicaci�n
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

	// Constructor de la clase vLogin
	public vLogin() {
		// Configuraci�n de varias propiedades para el JFrame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creaci�n y configuraci�n de la etiqueta de t�tulo
		lblTitulo.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblTitulo.setBounds(268, 125, 314, 51);
		contentPane.add(lblTitulo);

		// Creaci�n y configuraci�n de etiquetas para usuario y Contrasenia
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD | Font.ITALIC, 22));
		lblUsuario.setBounds(309, 199, 98, 39);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD | Font.ITALIC, 22));
		lblContrasea.setBounds(277, 249, 130, 39);
		contentPane.add(lblContrasea);

		// Campo de texto para ingresar el nombre de usuario
		txtUsuario = new JTextField();
		txtUsuario.setBounds(407, 209, 130, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		// Bot�n para iniciar el proceso de inicio de sesi�n
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				if (!txtUsuario.getText().isEmpty() && !txtContrasenia.getText().isEmpty()) {
					String rol = dao.login(txtUsuario.getText().toUpperCase(), txtContrasenia.getText().toUpperCase());
					if (!rol.isEmpty()) {
						// Abrir el men� principal
						menuPrincipal.transferirDatos(rol);
						menuPrincipal.setVisible(true);
						// Cerrar la ventana de inicio de sesi�n
						vLogin.this.dispose();
					} else {
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "Usuario y/o Contrasenia incorrecta");
					}
				} else {
					limpiarCampos();
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				}
			}
		});
		btnIngresar.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 15));
		btnIngresar.setBounds(370, 314, 122, 31);
		contentPane.add(btnIngresar);

		// Campo de Contrasenia para ingresar la Contrasenia
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(407, 261, 130, 23);
		contentPane.add(txtContrasenia);

		// Bot�n para salir de la aplicaci�n
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vLogin.this.dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalir.setBounds(687, 451, 118, 39);
		contentPane.add(btnSalir);

		// Etiqueta para mostrar el rol del usuario
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(727, 11, 98, 18);
		contentPane.add(lblRol);

		// Etiqueta "Rol:" (inicialmente oculta)
		JLabel lblCaptionRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(702, 11, 25, 18);
		lblCaptionRol.setVisible(false);
		lblRol.setVisible(false);
		contentPane.add(lblCaptionRol);

		// Centrar la ventana en la pantalla
		setLocationRelativeTo(null);
	}

	// M�todo para borrar los campos de texto
	private void limpiarCampos() {
		txtUsuario.setText("");
		txtContrasenia.setText("");
	}

	// M�todo para transferir la informaci�n del rol del usuario
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
