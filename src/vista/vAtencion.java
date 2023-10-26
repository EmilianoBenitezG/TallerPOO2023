package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.daoPacientes;
import modelo.Paciente;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class vAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreApellido;
	private JTextField txtDNI;
	private Paciente pacienteSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vAtencion frame = new vAtencion();
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
	public vAtencion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtencion = new JLabel("Atencion");
		lblAtencion.setBounds(340, 28, 150, 51);
		lblAtencion.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		contentPane.add(lblAtencion);
		
		JButton btnBuscarPaciente = new JButton("Seleccionar Paciente");
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoPacientes dao = new daoPacientes();
				ArrayList<Paciente> pacientes = dao.buscarPacientesEnTriage();
				DefaultListModel<Paciente> pacienteListModel = new DefaultListModel<>();
				for (Paciente paciente : pacientes) {
					pacienteListModel.addElement(paciente);
				}
				SeleccionarPaciente dialog = new SeleccionarPaciente(vAtencion.this, pacienteListModel);
				dialog.setVisible(true);
				pacienteSeleccionado = dialog.getSelectedPaciente();
				if (pacienteSeleccionado != null) {
					txtDNI.setText(pacienteSeleccionado.getDNI());
					txtNombreApellido
							.setText(pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido());
				}
			}
		});
		btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarPaciente.setBounds(42, 94, 184, 30);
		contentPane.add(btnBuscarPaciente);
		
		JLabel lblNombreApellido = new JLabel("Nombre y apellido:");
		lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellido.setBounds(45, 135, 152, 22);
		contentPane.add(lblNombreApellido);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setEnabled(false);
		txtNombreApellido.setBounds(207, 135, 170, 22);
		contentPane.add(txtNombreApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(394, 135, 40, 22);
		contentPane.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setBounds(439, 135, 97, 22);
		contentPane.add(txtDNI);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.setVisible(true);
				vAtencion.this.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 28, 85, 36);
		contentPane.add(btnAtras);
		setLocationRelativeTo(null);
	}
}
