package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Paciente;
import dao.daoPacientes;
import java.util.ArrayList;

public class vPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtfechaNacimiento;
	private JTextField txtdomicilio;
	private JTextField txtnroDNI;
	private JTextField txttelFijo;
	private JTextField txttelCelular;
	private JTextField txtestadoCivil;
	private JTextField txtemail;
	private JTextField txtpersonaContacto;
	private JCheckBox chkEstado;
	private JLabel lblId;
	private String filtroActual = "";

	int filaSeleccionada = -1;
	DefaultTableModel modelo = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	daoPacientes dao = new daoPacientes();
	ArrayList<Paciente> lista;
	private JTable tlbPacientes;
	Paciente paciente;
	Paciente pacienteSeleccionado;
	JLabel lblRol = new JLabel("Rol");
	private JTextField txtEdad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPaciente frame = new vPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vPaciente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblPacientes.setBounds(122, 13, 178, 33);
		contentPane.add(lblPacientes);

		// Campos de ingreso de datos
		// Nombre
		txtnombre = new JTextField();
		txtnombre.setBounds(85, 63, 170, 22);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(20, 63, 68, 22);
		contentPane.add(lblNombre);

		// Apellido
		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(333, 63, 170, 22);
		contentPane.add(txtapellido);

		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(265, 63, 81, 22);
		contentPane.add(lblApellido);

		// Fecha de nacimiento
		txtfechaNacimiento = new JTextField();
		txtfechaNacimiento.setColumns(10);
		txtfechaNacimiento.setBounds(667, 63, 125, 22);
		contentPane.add(txtfechaNacimiento);

		JLabel lblfechaNacimiento = new JLabel("Fecha de nacimiento: ");
		lblfechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblfechaNacimiento.setBounds(513, 63, 178, 22);
		contentPane.add(lblfechaNacimiento);

		// Domicilio
		txtdomicilio = new JTextField();
		txtdomicilio.setColumns(10);
		txtdomicilio.setBounds(877, 63, 156, 22);
		contentPane.add(txtdomicilio);

		JLabel lblDomicilio = new JLabel("Domicilio: ");
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDomicilio.setBounds(802, 63, 81, 22);
		contentPane.add(lblDomicilio);

		// DNI
		txtnroDNI = new JTextField();
		txtnroDNI.setColumns(10);
		txtnroDNI.setBounds(60, 96, 110, 22);
		contentPane.add(txtnroDNI);

		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(20, 96, 39, 22);
		contentPane.add(lblDni);

		// Tel fijo
		txttelFijo = new JTextField();
		txttelFijo.setColumns(10);
		txttelFijo.setBounds(243, 96, 115, 22);
		contentPane.add(txttelFijo);

		JLabel lblTelFijo = new JLabel("Tel Fijo: ");
		lblTelFijo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelFijo.setBounds(180, 96, 71, 22);
		contentPane.add(lblTelFijo);

		// Tel celular
		txttelCelular = new JTextField();
		txttelCelular.setColumns(10);
		txttelCelular.setBounds(454, 96, 125, 22);
		contentPane.add(txttelCelular);

		JLabel lblTelCelular = new JLabel("Tel Celular: ");
		lblTelCelular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelCelular.setBounds(368, 96, 95, 22);
		contentPane.add(lblTelCelular);

		// Estado civil
		txtestadoCivil = new JTextField();
		txtestadoCivil.setColumns(10);
		txtestadoCivil.setBounds(677, 96, 115, 22);
		contentPane.add(txtestadoCivil);

		JLabel lblEstadoCivil = new JLabel("Estado civil: ");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoCivil.setBounds(589, 96, 95, 22);
		contentPane.add(lblEstadoCivil);

		// Email
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(405, 129, 140, 22);
		contentPane.add(txtemail);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(354, 129, 54, 22);
		contentPane.add(lblEmail);

		// Persona de contacto
		txtpersonaContacto = new JTextField();
		txtpersonaContacto.setColumns(10);
		txtpersonaContacto.setBounds(156, 129, 170, 22);
		contentPane.add(txtpersonaContacto);

		JLabel lblPersonaContacto = new JLabel("Persona Contacto: ");
		lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPersonaContacto.setBounds(20, 129, 140, 22);
		contentPane.add(lblPersonaContacto);

		// Campo de filtro de DNI
		JTextField txtFiltroDNI = new JTextField();
		txtFiltroDNI.setColumns(10);
		txtFiltroDNI.setBounds(420, 247, 203, 22);
		contentPane.add(txtFiltroDNI);

		// Botón de búsqueda por DNI
		JButton btnBuscarPorDNI = new JButton("Buscar");
		btnBuscarPorDNI.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBuscarPorDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroActual = txtFiltroDNI.getText().trim();
				if (!filtroActual.isEmpty()) {
					buscarPorDNI(filtroActual);
				} else {
					actualizarTabla();
				}
			}
		});
		btnBuscarPorDNI.setBounds(627, 247, 125, 22);
		contentPane.add(btnBuscarPorDNI);

		// Checkbox para el estado "vivo/muerto"
		chkEstado = new JCheckBox("¿Está vivo?");
		chkEstado.setSelected(true);
		chkEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkEstado.setBounds(566, 127, 125, 22);
		contentPane.add(chkEstado);

		// Botones en pantalla
		// Boton Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (filaSeleccionada != -1) {
						paciente = lista.get(filaSeleccionada);
						int idPaciente = paciente.getId();
						paciente.setNombre(txtnombre.getText());
						paciente.setApellido(txtapellido.getText());
						paciente.setFechaNacimiento(txtfechaNacimiento.getText());
						paciente.setDomicilio(txtdomicilio.getText());
						paciente.setDNI(txtnroDNI.getText());
						paciente.setTelFijo(txttelFijo.getText());
						paciente.setTelCelular(txttelCelular.getText());
						paciente.setEstadoCivil(txtestadoCivil.getText());
						paciente.setEmail(txtemail.getText());
						paciente.setPersonaContacto(txtpersonaContacto.getText());
						paciente.setEdad(Integer.parseInt(txtEdad.getText()));
						boolean estaVivo = chkEstado.isSelected();
						paciente.setEstado(estaVivo);

						if (dao.modificarPaciente(paciente)) {
							actualizarTabla();
							limpiarCampos();
							JOptionPane.showMessageDialog(null, "Se modificó correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "Error al modificar paciente");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione un paciente para modificar.");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al modificar paciente: " + e2.getMessage());
				}
			}
		});
		btnModificar.setBounds(233, 176, 125, 22);
		contentPane.add(btnModificar);

		// Boton agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dni = txtnroDNI.getText().trim();
					if (!dao.existePacienteConDNI(dni)) {
						Paciente paciente = new Paciente();
						paciente.setNombre(txtnombre.getText());
						paciente.setApellido(txtapellido.getText());
						paciente.setFechaNacimiento(txtfechaNacimiento.getText());
						paciente.setDomicilio(txtdomicilio.getText());
						paciente.setDNI(dni);
						paciente.setTelFijo(txttelFijo.getText());
						paciente.setTelCelular(txttelCelular.getText());
						paciente.setEstadoCivil(txtestadoCivil.getText());
						paciente.setEmail(txtemail.getText());
						paciente.setPersonaContacto(txtpersonaContacto.getText());
						paciente.setEdad(Integer.parseInt(txtEdad.getText()));
						boolean estaVivo = chkEstado.isSelected();
						paciente.setEstado(estaVivo);

						if (dao.insertarPaciente(paciente)) {
							actualizarTabla();
							JOptionPane.showMessageDialog(null, "Se agregó correctamente");
							limpiarCampos();
						} else {
							JOptionPane.showMessageDialog(null, "Error al agregar paciente");
						}
					} else {
						JOptionPane.showMessageDialog(null, "El paciente con este DNI ya existe en la base de datos.");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
				}
			}
		});
		btnAgregar.setBounds(428, 176, 125, 22);
		contentPane.add(btnAgregar);

		// Boton para volver al menú principal
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vPaciente.this.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 13, 85, 36);
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

		// Crea un JScrollPane para agregar barras de desplazamiento a la tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 273, 1025, 306);
		contentPane.add(scrollPane);

		// Crear una tabla de pacientes
		tlbPacientes = new JTable();

		// Crear una etiqueta "ID"
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(25, 26, 28, 22);
		lblId.setVisible(false);
		contentPane.add(lblId);

		// Manejar selección en tabla de pacientes
		tlbPacientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					filaSeleccionada = tlbPacientes.getSelectedRow();
					if (filaSeleccionada >= 0) {
						paciente = lista.get(filaSeleccionada);
						lblId.setText(String.valueOf(paciente.getId()));
						txtnombre.setText(paciente.getNombre());
						txtapellido.setText(paciente.getApellido());
						txtfechaNacimiento.setText(paciente.getFechaNacimiento());
						txtdomicilio.setText(paciente.getDomicilio());
						txtnroDNI.setText(paciente.getDNI());
						txttelFijo.setText(paciente.getTelFijo());
						txttelCelular.setText(paciente.getTelCelular());
						txtestadoCivil.setText(paciente.getEstadoCivil());
						txtemail.setText(paciente.getEmail());
						txtpersonaContacto.setText(paciente.getPersonaContacto());
						chkEstado.setSelected(paciente.isEstado());
					}
				}
			}
		});

		// Crear modelo de datos para la tabla
		tlbPacientes.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null },

				}, new String[] { "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "DNI", "Tel Fijo",
						"Tel Celular", "Estado civil", "Email", "Persona Contacto", "Estado" }));
		scrollPane.setViewportView(tlbPacientes);

		// Etiqueta para buscar por DNI
		JLabel lblBuscarPorDni = new JLabel("Buscar por DNI:");
		lblBuscarPorDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarPorDni.setBounds(287, 247, 150, 22);
		contentPane.add(lblBuscarPorDni);
		
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(952, 13, 98, 18);
		contentPane.add(lblRol);
		
		JLabel lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(927, 13, 25, 18);
		contentPane.add(lblCaptionRol);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(868, 96, 59, 22);
		contentPane.add(txtEdad);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(812, 94, 46, 22);
		contentPane.add(lblEdad);

		// Agregar columnas al modelo de datos de la tabla
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha de nacimiento");
		modelo.addColumn("Domicilio");
		modelo.addColumn("DNI");
		modelo.addColumn("Tel Fijo");
		modelo.addColumn("Tel Celular");
		modelo.addColumn("Estado civil");
		modelo.addColumn("Email");
		modelo.addColumn("Persona Contacto");
		modelo.addColumn("Estado");
		actualizarTabla();
		setLocationRelativeTo(null);
	}

	// Actualizar la tabla de pacientes
	public void actualizarTabla() {
		modelo.setRowCount(0);

		if (filtroActual.isEmpty()) {
			lista = dao.consultarPacientes();
		} else {
			buscarPorDNI(filtroActual);
		}

		modelo.setRowCount(0);
		
		for (Paciente paciente : lista) {
			Object[] rowData = { 
					paciente.getNombre(), 
					paciente.getApellido(), 
					paciente.getFechaNacimiento(),
					paciente.getDomicilio(), 
					paciente.getDNI(), 
					paciente.getTelFijo(), 
					paciente.getTelCelular(),
					paciente.getEstadoCivil(), 
					paciente.getEmail(), 
					paciente.getPersonaContacto(),
					paciente.isEstado() ? "Vivo" : "Fallecido" };
			modelo.addRow(rowData);
		}
		tlbPacientes.setModel(modelo);
	}

	// Limpiar campos de entrada
	private void limpiarCampos() {
		txtnombre.setText("");
		txtapellido.setText("");
		txtfechaNacimiento.setText("");
		txtdomicilio.setText("");
		txtnroDNI.setText("");
		txttelFijo.setText("");
		txttelCelular.setText("");
		txtestadoCivil.setText("");
		txtemail.setText("");
		txtpersonaContacto.setText("");
		txtEdad.setText("");
		lblId.setText("");
		chkEstado.setSelected(false);
	}

	// Buscar pacientes por DNI
	private void buscarPorDNI(String dni) {
		modelo.setRowCount(0);

		lista = dao.buscarPacientesPorDNI(dni);

		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encontraron pacientes con ese DNI");
		} else {
			for (Paciente u : lista) {
				Object paciente[] = new Object[11];
				paciente[0] = u.getNombre();
				paciente[1] = u.getApellido();
				paciente[2] = u.getFechaNacimiento();
				paciente[3] = u.getDomicilio();
				paciente[4] = u.getDNI();
				paciente[5] = u.getTelFijo();
				paciente[6] = u.getTelCelular();
				paciente[7] = u.getEstadoCivil();
				paciente[8] = u.getEmail();
				paciente[9] = u.getPersonaContacto();
				paciente[10] = u.isEstado() ? "Vivo" : "Fallecido";
				modelo.addRow(paciente);
			}
			tlbPacientes.setRowSelectionInterval(0, 0);
		}
		tlbPacientes.setModel(modelo);
	}
	
	// Método para transferir el rol del usuario a la ventana
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
