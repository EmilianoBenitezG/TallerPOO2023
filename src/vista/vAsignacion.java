package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.daoMedico;
import dao.daoPacientes;
import modelo.Medico;
import modelo.Paciente;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class vAsignacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreApellido;
	private JTextField txtDNI;
	private Paciente pacienteSeleccionado;
	private JTextField txtMedico;
	private JTextField txtMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vAsignacion frame = new vAsignacion();
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
	public vAsignacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsignacion = new JLabel("Asignacion");
		lblAsignacion.setBounds(328, 28, 195, 51);
		lblAsignacion.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		contentPane.add(lblAsignacion);
		
		JButton btnBuscarPaciente = new JButton("Seleccionar Paciente");
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoPacientes dao = new daoPacientes();
				ArrayList<Paciente> pacientes = dao.buscarPacientesEnTriage();
				DefaultListModel<Paciente> pacienteListModel = new DefaultListModel<>();
				for (Paciente paciente : pacientes) {
					pacienteListModel.addElement(paciente);
				}
				SeleccionarPaciente dialog = new SeleccionarPaciente(vAsignacion.this, pacienteListModel);
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
		btnBuscarPaciente.setBounds(533, 142, 182, 30);
		contentPane.add(btnBuscarPaciente);
		
		JLabel lblNombreApellido = new JLabel("Paciente:");
		lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellido.setBounds(102, 146, 81, 22);
		contentPane.add(lblNombreApellido);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setEnabled(false);
		txtNombreApellido.setBounds(182, 144, 170, 22);
		contentPane.add(txtNombreApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(374, 144, 40, 22);
		contentPane.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setBounds(419, 144, 97, 22);
		contentPane.add(txtDNI);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.setVisible(true);
				vAsignacion.this.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 28, 85, 36);
		contentPane.add(btnAtras);
		
		JButton btnSeleccionarMedico = new JButton("Seleccionar Medico");
		btnSeleccionarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 daoMedico dao = new daoMedico();
			        ArrayList<Medico> medicos = dao.consultarMedicos();
			        DefaultListModel<Medico> medicoListModel = new DefaultListModel<>();
			        for (Medico medico : medicos) {
			            medicoListModel.addElement(medico);
			        }
			        SeleccionarMedico dialog = new SeleccionarMedico(vAsignacion.this, medicoListModel);
			        dialog.setVisible(true);
			        Medico medicoSeleccionado = dialog.getSelectedMedico();
			        if (medicoSeleccionado != null) {
			        	txtMedico.setText(medicoSeleccionado.getApellido() + " " + medicoSeleccionado.getNombre());
			        	txtMatricula.setText(medicoSeleccionado.getMatricula());
			        }
			}
		});
		btnSeleccionarMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSeleccionarMedico.setBounds(533, 205, 182, 30);
		contentPane.add(btnSeleccionarMedico);
		
		JLabel lblMedico = new JLabel("Medico:");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedico.setBounds(111, 209, 61, 22);
		contentPane.add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setEnabled(false);
		txtMedico.setBounds(182, 211, 150, 22);
		contentPane.add(txtMedico);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatricula.setBounds(339, 209, 70, 22);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setEnabled(false);
		txtMatricula.setBounds(419, 211, 97, 22);
		contentPane.add(txtMatricula);
		setLocationRelativeTo(null);
	}
}
