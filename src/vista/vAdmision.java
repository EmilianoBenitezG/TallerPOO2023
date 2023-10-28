package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import dao.daoPacientes;
import dao.daoAdmision;
import modelo.Paciente;
import modelo.Admision;
import javax.swing.JEditorPane;
import java.awt.Color;

public class vAdmision extends JFrame {

	private JTextField txtFecha;
	private JTextField txtHora;
	private JPanel contentPane;
	private JTable tblAdmision;
	private JTextField txtNombreApellido;
	private JTextField txtDNI;
	private JEditorPane txtMotivoConsulta;
	private Paciente pacienteSeleccionado;
	JLabel lblRol = new JLabel("Rol");

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultTableModel tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.addColumn("Nombre");
		tableModel.addColumn("DNI");
		tableModel.addColumn("Motivo Consulta");
		tableModel.addColumn("Fecha");
		tableModel.addColumn("Hora");

		// Crear la tabla y agregar al contenido
		tblAdmision = new JTable(tableModel);
		tblAdmision.setBounds(25, 273, 745, 237);
		actualizarTablaAdmisiones();
		contentPane.add(tblAdmision);

		// Crear un JScrollPane para la tabla
		JScrollPane scrollPane = new JScrollPane(tblAdmision);
		scrollPane.setBounds(41, 280, 940, 270);
		contentPane.add(scrollPane);

		// Configurar el titulo
		JLabel lblAdmision = new JLabel("Admisión");
		lblAdmision.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblAdmision.setBounds(116, 14, 178, 33);
		contentPane.add(lblAdmision);

		// Boton para volver al menu principal
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vAdmision.this.setVisible(false);
			}
		});

		// Campo de texto para motivo de consulta
		txtMotivoConsulta = new JEditorPane();
		txtMotivoConsulta.setForeground(new Color(0, 0, 0));
		txtMotivoConsulta.setBounds(225, 160, 358, 64);
		contentPane.add(txtMotivoConsulta);

		// Boton para agregar admisi�n
		JButton btnAgregarAdmision = new JButton("Agregar");
		btnAgregarAdmision.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregarAdmision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreApellido = txtNombreApellido.getText();
				String dni = txtDNI.getText();
				String motivoConsulta = txtMotivoConsulta.getText();
				String fecha = txtFecha.getText();
				String hora = txtHora.getText();

				if (pacienteSeleccionado != null) {
					Admision admision = new Admision();
					admision.setPaciente(pacienteSeleccionado);
					admision.setMotivoConsulta(motivoConsulta);
					admision.setFecha(fecha);
					admision.setHora(hora);

					daoAdmision dao = new daoAdmision();
					if (dao.insertarAdmision(admision)) {
						actualizarTablaAdmisiones();
						JOptionPane.showMessageDialog(null, "Se agreg� correctamente");
						limpiarCampos();
					} else {
						JOptionPane.showMessageDialog(null, "Error al agregar la admisi�n");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes seleccionar un paciente antes de agregar la admisi�n");
				}
			}
		});
		btnAgregarAdmision.setBounds(439, 239, 125, 22);
		contentPane.add(btnAgregarAdmision);

		// Boton para volver al menu principal
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 11, 85, 36);
		contentPane.add(btnAtras);

		// Boton para volver limpiar campos de entrada
		JButton btnLimpiar = new JButton("Limpiar campos");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar.setBounds(618, 176, 163, 22);
		contentPane.add(btnLimpiar);

		// Hora
		JLabel lblHora = new JLabel("Hora: ");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(770, 120, 45, 22);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHora.setColumns(10);
		txtHora.setBounds(820, 120, 121, 22);
		contentPane.add(txtHora);

		// Fecha
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(595, 120, 56, 22);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setBounds(650, 120, 102, 22);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		// Nombre y apellido
		JLabel lblNombreApellido = new JLabel("Nombre y apellido:");
		lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellido.setBounds(76, 120, 152, 22);
		contentPane.add(lblNombreApellido);

		txtNombreApellido = new JTextField();
		txtNombreApellido.setEditable(false);
		txtNombreApellido.setBounds(238, 120, 170, 22);
		contentPane.add(txtNombreApellido);
		setLocationRelativeTo(null);

		// Boton para buscar pacientes
		JButton btnBuscarPaciente = new JButton("Seleccionar Paciente");
		btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoPacientes dao = new daoPacientes();
				ArrayList<Paciente> pacientes = dao.buscarPacientes();
				DefaultListModel<Paciente> pacienteListModel = new DefaultListModel<>();
				for (Paciente paciente : pacientes) {
					pacienteListModel.addElement(paciente);
				}
				SeleccionarPaciente dialog = new SeleccionarPaciente(vAdmision.this, pacienteListModel);
				dialog.setVisible(true);
				pacienteSeleccionado = dialog.getSelectedPaciente();
				if (pacienteSeleccionado != null) {
					txtDNI.setText(pacienteSeleccionado.getDNI());
					txtNombreApellido
							.setText(pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido());
				}
			}
		});
		btnBuscarPaciente.setBounds(41, 75, 201, 30);
		contentPane.add(btnBuscarPaciente);

		// DNI
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(425, 120, 40, 22);
		contentPane.add(lblDni);

		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(470, 120, 97, 22);
		contentPane.add(txtDNI);

		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(900, 14, 98, 18);
		contentPane.add(lblRol);

		JLabel lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(875, 14, 25, 18);
		contentPane.add(lblCaptionRol);

		JLabel lblMotivoConsulta = new JLabel("Motivo de consulta:");
		lblMotivoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMotivoConsulta.setBounds(76, 160, 152, 22);
		contentPane.add(lblMotivoConsulta);

		// Manejar seleccion en tabla de admisiones
		tblAdmision.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = tblAdmision.getSelectedRow();
				if (filaSeleccionada >= 0) {
					DefaultTableModel model = (DefaultTableModel) tblAdmision.getModel();
					String nombreApellido = model.getValueAt(filaSeleccionada, 0).toString();
					String dni = model.getValueAt(filaSeleccionada, 1).toString();
					String motivoConsulta = model.getValueAt(filaSeleccionada, 2).toString();
					String fecha = model.getValueAt(filaSeleccionada, 3).toString();
					String hora = model.getValueAt(filaSeleccionada, 4).toString();
					txtNombreApellido.setText(nombreApellido);
					txtDNI.setText(dni);
					txtMotivoConsulta.setText(motivoConsulta);
					txtFecha.setText(fecha);
					txtHora.setText(hora);
				}
			}
		});
		colocarHoraActual();
	}

	// Metodo para actualizar la tabla de admisiones
	private void actualizarTablaAdmisiones() {
		DefaultTableModel model = (DefaultTableModel) tblAdmision.getModel();
		model.setRowCount(0);
		daoAdmision dao = new daoAdmision();
		ArrayList<Admision> admisiones = dao.consultarAdmisiones();
		for (Admision admision : admisiones) {
			model.addRow(new Object[] { admision.getPaciente().getNombreApellido(), admision.getPaciente().getDNI(),
					admision.getMotivoConsulta(), admision.getFecha(), admision.getHora() });
		}
	}

	// Metodo para transferir el rol del usuario a la ventana
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
	
	// Limpiar campos de entrada
	private void limpiarCampos() {
		txtNombreApellido.setText("");
		txtDNI.setText("");
		txtMotivoConsulta.setText("");
		txtFecha.setText("");
		txtHora.setText("");
		colocarHoraActual();
	}
	
	// Funcion que agrega fecha y hora actual del equipo
	private void colocarHoraActual() {
		Date todayDate = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String fechaActual = fecha.format(todayDate);
        String horaActual = hora.format(todayDate);
        
        txtFecha.setText(fechaActual);
        txtHora.setText(horaActual);
	}

}
