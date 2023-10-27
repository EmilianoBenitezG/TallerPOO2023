package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.daoTriage;
import modelo.Triage;

public class vTriage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreApellido;
    private JTextField txtDNI;
	private JTextField txtFecha;
    private JTextField txtHora;    
	private JPanel contentPane;
	private JLabel lblRespiracion;
	private JLabel lblFiebre;
	private JLabel lblPulso;
	private JLabel lblDolorDePecho;
	private JLabel lblDolorAbdominal;
	private JLabel lblLesionesGraves;
	private JLabel lblLesionesLeves;
	private JLabel lblEstadoMental;
	private JLabel lblSangrado;
	private JLabel lblVomitos;
	private JLabel lblSignosDeShock;
	private JComboBox BoxRespiracion;
	private JButton btnVolver;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JComboBox BoxFiebre;
	private JComboBox BoxPulso;
	private JComboBox BoxDolorDePecho;
	private JComboBox BoxDolorAbdominal;
	private JComboBox BoxLesionesGraves;
	private JComboBox BoxLesionesLeves;
	private JComboBox BoxEstadoMental;
	private JComboBox BoxSangrado;
	private JComboBox BoxVomitos;
	private JComboBox BoxSignosDeShock;
	private JLabel lblConciencia;
	private JComboBox BoxConciencia;
	private JComboBox boxPacientes;
	private JTextField textField_1;
	private JTable table;
	private JScrollPane scrollPane;
	private daoTriage dao = new daoTriage();
	String[] columnNames = {"Nombre Paciente", "Color Sugerido","Motivo Cambio","Color Final","Fecha","Hora"};
	Object[][] data = {};
	DefaultTableModel modelo = new DefaultTableModel(data, columnNames) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    ArrayList<Triage> lista;
    private JLabel lblRol;
    private JLabel lblCaptionRol;
    private JComboBox BoxEdad;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vTriage frame = new vTriage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vTriage() {

		setBackground(new Color(255, 255, 255));

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Nombre de cada Variable Triage
		// Nombre y apellido
		JLabel lblNombreApellido = new JLabel("Nombre y apellido");
		lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellido.setBounds(65, 125, 152, 22);
		contentPane.add(lblNombreApellido);

		txtNombreApellido = new JTextField();
		txtNombreApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombreApellido.setEditable(false);
		txtNombreApellido.setBounds(65, 150, 170, 22);
		contentPane.add(txtNombreApellido);
		setLocationRelativeTo(null);

		// DNI
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(316, 125, 40, 22);
		contentPane.add(lblDni);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDNI.setEditable(false);
		txtDNI.setBounds(316, 150, 109, 22);
		contentPane.add(txtDNI);

		// Fecha
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(651, 125, 56, 22);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setBounds(651, 150, 102, 22);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		// Hora
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(833, 125, 45, 22);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHora.setColumns(10);
		txtHora.setBounds(833, 150, 121, 22);
		contentPane.add(txtHora);
		
		// Respiracion
		lblRespiracion = new JLabel("Respiraci\u00F3n");
		lblRespiracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRespiracion.setBounds(10, 183, 85, 24);
		contentPane.add(lblRespiracion);
		
		BoxRespiracion = new JComboBox();
		BoxRespiracion.setForeground(new Color(0, 0, 0));
		BoxRespiracion.setModel(new DefaultComboBoxModel(new String[] { "Normal", "Moderada", "Grave" }));
		BoxRespiracion.setSelectedIndex(0);
		BoxRespiracion.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxRespiracion.setToolTipText("Seleccione una opcion");
		BoxRespiracion.setMaximumRowCount(4);
		BoxRespiracion.setBounds(10, 207, 150, 22);
		contentPane.add(BoxRespiracion);
		BoxRespiracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxRespiracion.getSelectedIndex();
				dao.setPuntuacionRespiracion(seleccion);

			}
		});

		// Fiebre
		lblFiebre = new JLabel("Fiebre");
		lblFiebre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiebre.setBounds(10, 260, 49, 24);
		contentPane.add(lblFiebre);
		
		BoxFiebre = new JComboBox();
		BoxFiebre.setForeground(new Color(0, 0, 0));
		BoxFiebre.setToolTipText("Seleccione una opcion");
		BoxFiebre.setModel(new DefaultComboBoxModel(new String[] { "Sin fiebre", "Baja", "Alta" }));
		BoxFiebre.setSelectedIndex(0);
		BoxFiebre.setMaximumRowCount(4);
		BoxFiebre.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxFiebre.setBounds(10, 284, 150, 22);
		contentPane.add(BoxFiebre);
		BoxFiebre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxFiebre.getSelectedIndex();
				dao.setPuntuacionFiebre(seleccion);

			}
		});

		// Signos de shock
		lblSignosDeShock = new JLabel("Signos de Shock");
		lblSignosDeShock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSignosDeShock.setBounds(491, 260, 128, 24);
		contentPane.add(lblSignosDeShock);
		
		BoxSignosDeShock = new JComboBox();
		BoxSignosDeShock.setToolTipText("Seleccione una opcion");
		BoxSignosDeShock.setModel(new DefaultComboBoxModel(new String[] { "No presentes", "Presentes" }));
		BoxSignosDeShock.setSelectedIndex(0);
		BoxSignosDeShock.setMaximumRowCount(4);
		BoxSignosDeShock.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxSignosDeShock.setBounds(491, 284, 150, 22);
		contentPane.add(BoxSignosDeShock);
		BoxSignosDeShock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxSignosDeShock.getSelectedIndex();

				dao.setPuntuacionSignosdeShock(seleccion);

			}
		});

		// Lesiones leves
		lblLesionesLeves = new JLabel("Lesiones Leves");
		lblLesionesLeves.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLesionesLeves.setBounds(651, 260, 120, 24);
		contentPane.add(lblLesionesLeves);
		
		BoxLesionesLeves = new JComboBox();
		BoxLesionesLeves.setToolTipText("Seleccione una opcion");
		BoxLesionesLeves.setModel(new DefaultComboBoxModel(new String[] { "Sin lesiones", "Lesiones ligeras" }));
		BoxLesionesLeves.setSelectedIndex(0);
		BoxLesionesLeves.setMaximumRowCount(4);
		BoxLesionesLeves.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxLesionesLeves.setBounds(651, 284, 150, 22);
		contentPane.add(BoxLesionesLeves);
		BoxLesionesLeves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxLesionesLeves.getSelectedIndex();
				dao.setPuntuacionLesionesLeves(seleccion);

			}
		});

		// Lesiones graves
		lblLesionesGraves = new JLabel("Lesiones Graves");
		lblLesionesGraves.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLesionesGraves.setBounds(811, 183, 120, 24);
		contentPane.add(lblLesionesGraves);
		
		BoxLesionesGraves = new JComboBox();
		BoxLesionesGraves.setToolTipText("Seleccione una opcion");
		BoxLesionesGraves.setModel(new DefaultComboBoxModel(new String[] { "Sin lesiones", "Con graves lesiones" }));
		BoxLesionesGraves.setSelectedIndex(0);
		BoxLesionesGraves.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxLesionesGraves.setBounds(811, 207, 143, 22);
		contentPane.add(BoxLesionesGraves);
		BoxLesionesGraves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxLesionesGraves.getSelectedIndex();
				int puntuacion = 0;
				if (seleccion == 1) {
					puntuacion = 2;
				}
				dao.setPuntuacionLesionesGraves(puntuacion);

			}
		});

		// Dolor abdominal
		lblDolorAbdominal = new JLabel("Dolor Abdominal");
		lblDolorAbdominal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDolorAbdominal.setBounds(332, 260, 137, 24);
		contentPane.add(lblDolorAbdominal);
		
		BoxDolorAbdominal = new JComboBox();
		BoxDolorAbdominal.setToolTipText("Seleccione una opcion");
		BoxDolorAbdominal.setModel(new DefaultComboBoxModel(new String[] { "No presente", "Moderado", "Severo" }));
		BoxDolorAbdominal.setSelectedIndex(0);
		BoxDolorAbdominal.setMaximumRowCount(4);
		BoxDolorAbdominal.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxDolorAbdominal.setBounds(332, 284, 149, 22);
		contentPane.add(BoxDolorAbdominal);

		// Sangrado
		lblSangrado = new JLabel("Sangrado");
		lblSangrado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSangrado.setBounds(811, 260, 73, 24);
		contentPane.add(lblSangrado);
		
		BoxSangrado = new JComboBox();
		BoxSangrado.setToolTipText("Seleccione una opcion");
		BoxSangrado.setModel(new DefaultComboBoxModel(new String[] { "No presente", "Ligero", "Intenso" }));
		BoxSangrado.setSelectedIndex(0);
		BoxSangrado.setMaximumRowCount(4);
		BoxSangrado.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxSangrado.setBounds(811, 284, 137, 22);
		contentPane.add(BoxSangrado);
		BoxSangrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxSangrado.getSelectedIndex();
				dao.setPuntuacionSangrado(seleccion);

			}
		});

		// Estado mental
		lblEstadoMental = new JLabel("Estado Mental\r\n");
		lblEstadoMental.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoMental.setBounds(332, 183, 109, 24);
		contentPane.add(lblEstadoMental);
		
		BoxEstadoMental = new JComboBox();
		BoxEstadoMental.setToolTipText("Seleccione una opcion");
		BoxEstadoMental
				.setModel(new DefaultComboBoxModel(new String[] { "Normal", "Confusion ligera", "Somnolencia" }));
		BoxEstadoMental.setSelectedIndex(0);
		BoxEstadoMental.setMaximumRowCount(4);
		BoxEstadoMental.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxEstadoMental.setBounds(332, 207, 149, 22);
		contentPane.add(BoxEstadoMental);

		BoxEstadoMental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxEstadoMental.getSelectedIndex();
				dao.setPuntuacionEstadoMental(seleccion);
			}
		});

		// Dolor de pecho
		lblDolorDePecho = new JLabel("Dolor de Pecho");
		lblDolorDePecho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDolorDePecho.setBounds(651, 183, 120, 24);
		contentPane.add(lblDolorDePecho);
		
		BoxDolorDePecho = new JComboBox();
		BoxDolorDePecho.setToolTipText("Seleccione una opcion");
		BoxDolorDePecho.setModel(new DefaultComboBoxModel(new String[] { "No presente", "Presente" }));
		BoxDolorDePecho.setSelectedIndex(0);
		BoxDolorDePecho.setMaximumRowCount(4);
		BoxDolorDePecho.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxDolorDePecho.setBounds(651, 207, 150, 22);
		contentPane.add(BoxDolorDePecho);

		BoxDolorDePecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxDolorDePecho.getSelectedIndex();
				dao.setPuntuacionDolorPecho(seleccion);

			}
		});
		
		// Vomitos
		lblVomitos = new JLabel("Vomitos");
		lblVomitos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVomitos.setBounds(170, 260, 73, 24);
		contentPane.add(lblVomitos);
		
		BoxVomitos = new JComboBox();
		BoxVomitos.setToolTipText("Seleccione una opcion");
		BoxVomitos.setModel(new DefaultComboBoxModel(new String[] { "Sin vomitos", "Leves", "Intensos" }));
		BoxVomitos.setSelectedIndex(0);
		BoxVomitos.setMaximumRowCount(4);
		BoxVomitos.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxVomitos.setBounds(170, 284, 152, 22);
		contentPane.add(BoxVomitos);
		BoxVomitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxVomitos.getSelectedIndex();
				dao.setPuntuacionVomitos(seleccion);
			}
		});

		// Pulso
		lblPulso = new JLabel("Pulso");
		lblPulso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPulso.setBounds(170, 183, 53, 24);
		contentPane.add(lblPulso);
		
		BoxPulso = new JComboBox();
		BoxPulso.setToolTipText("Seleccione una opcion");
		BoxPulso.setModel(new DefaultComboBoxModel(new String[] { "Normal", "Anormal" }));
		BoxPulso.setSelectedIndex(0);
		BoxPulso.setMaximumRowCount(4);
		BoxPulso.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxPulso.setBounds(170, 207, 152, 22);
		contentPane.add(BoxPulso);
		BoxPulso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxPulso.getSelectedIndex();
				dao.setPuntuacionPulso(seleccion);

			}
		});
		
		// Conciencia
		lblConciencia = new JLabel("Conciencia\r\n");
		lblConciencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConciencia.setBounds(491, 183, 89, 24);
		contentPane.add(lblConciencia);

		BoxConciencia = new JComboBox();
		BoxConciencia.setToolTipText("Seleccione una opcion");
		BoxConciencia.setModel(new DefaultComboBoxModel(new String[] { "Consciente", "Perdida de conciencia" }));
		BoxConciencia.setSelectedIndex(0);
		BoxConciencia.setMaximumRowCount(4);
		BoxConciencia.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxConciencia.setBounds(491, 207, 150, 22);
		contentPane.add(BoxConciencia);
		BoxConciencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = BoxConciencia.getSelectedIndex();

				dao.setPuntuacionConciencia(seleccion);

			}
		});
		
		// Botones en pantalla
		// Boton para buscar pacientes
		JButton btnBuscarPaciente = new JButton("Seleccionar Paciente");
		btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarPaciente.setBounds(65, 59, 201, 30);
		contentPane.add(btnBuscarPaciente);
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = boxPacientes.getSelectedItem().toString();
				String[] partes = seleccion.split(" - ");
				if (partes.length == 2) {
					String nombreApellido = partes[0];
					String dni = partes[1];
					txtNombreApellido.setText(nombreApellido);
					txtDNI.setText(dni);
				} else {
					JOptionPane.showMessageDialog(vTriage.this, "No se pudo obtener la información del paciente.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// Boton para volver al menu principal
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vTriage.this.setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(10, 11, 85, 36);
		contentPane.add(btnVolver);
		
		// Boton para guardar paciente triado
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(361, 328, 89, 23);
		contentPane.add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = boxPacientes.getSelectedItem().toString();
				String[] partes = seleccion.split(" - ");
				String nombrePacienteSeleccionado = partes[0];
				String dniPaciente = txtDNI.getText();
				String horaTriage = txtHora.getText();
				String fechaTriage = txtFecha.getText();

				int respiracion = BoxRespiracion.getSelectedIndex();
				int fiebre = BoxFiebre.getSelectedIndex();
				int pulso = BoxPulso.getSelectedIndex();
				int dolorPecho = BoxDolorDePecho.getSelectedIndex();
				int dolorAbdominal = BoxDolorAbdominal.getSelectedIndex();
				int lesionesGraves = BoxLesionesGraves.getSelectedIndex() * 2;
				int lesionesLeves = BoxLesionesLeves.getSelectedIndex();
				int estadoMental = BoxEstadoMental.getSelectedIndex();
				int sangrado = BoxSangrado.getSelectedIndex();
				int vomitos = BoxVomitos.getSelectedIndex();
				int signosShock = BoxSignosDeShock.getSelectedIndex() * 3;
				int conciencia = BoxConciencia.getSelectedIndex() * 3;
				int edad = BoxEdad.getSelectedIndex();

				int puntuacionTotal = respiracion + fiebre + pulso + dolorPecho + dolorAbdominal + lesionesGraves
						+ lesionesLeves + estadoMental + sangrado + vomitos + signosShock + conciencia + edad;

				String colorResultado;
				if (puntuacionTotal >= 15) {
					colorResultado = "Rojo";
				} else if (puntuacionTotal >= 10) {
					colorResultado = "Naranja";
				} else if (puntuacionTotal >= 5) {
					colorResultado = "Amarillo";
				} else if (puntuacionTotal >= 1) {
					colorResultado = "Verde";
				} else {
					colorResultado = "Azul";
				}

				boolean resultadoGuardado = dao.almacenarResultadoTriage(nombrePacienteSeleccionado, colorResultado,
						fechaTriage, horaTriage, dniPaciente);
				actualizarTabla();
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 362, 944, 288);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre Paciente", "Color Sugerido", "Motivo Cambio", "Color Final", "Hora", "Fecha" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.setDefaultRenderer(Object.class, new ColorRenderer());
		actualizarTabla();

		scrollPane.setViewportView(table);

		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(991, 11, 83, 18);
		contentPane.add(lblRol);

		lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(956, 11, 25, 18);
		contentPane.add(lblCaptionRol);

		boxPacientes = new JComboBox<String>();
		boxPacientes.setToolTipText("Seleccione un paciente");
		boxPacientes.setFont(new Font("Arial", Font.PLAIN, 14));
		boxPacientes.setMaximumRowCount(10);
		boxPacientes.setBounds(361, 64, 319, 24);
		contentPane.add(boxPacientes);

		cargarNombreApellidoPacientes();
		setLocationRelativeTo(null);
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(965, 184, 49, 22);
		contentPane.add(lblEdad);

		JLabel lblTriage = new JLabel("Triage");
		lblTriage.setFont(new Font("Dialog", Font.PLAIN, 35));
		lblTriage.setBounds(474, 11, 106, 45);
		contentPane.add(lblTriage);

		BoxEdad = new JComboBox();
		BoxEdad.setToolTipText("Seleccione una opcion");
		BoxEdad.setModel(new DefaultComboBoxModel(new String[] { "Adulto", "Infante/Anciano" }));
		BoxEdad.setSelectedIndex(0);
		BoxEdad.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxEdad.setBounds(965, 207, 109, 22);
		contentPane.add(BoxEdad);
		colocarHoraActual();

		JButton btnmodificar = new JButton("Modificar");
		btnmodificar.setBounds(591, 328, 89, 23);
		contentPane.add(btnmodificar);
		btnmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = boxPacientes.getSelectedItem().toString();
				String nombrePacienteSeleccionado = null;
				for (String paciente : obtenerNombreApellidoPacientesDesdeAdmision()) {
					if (paciente.startsWith(seleccion)) {
						String[] partes = paciente.split(" - ");
						if (partes.length == 2) {
							nombrePacienteSeleccionado = partes[0];
						}
						break;
					}
				}
				String colorActual = dao.getColorActualPaciente(nombrePacienteSeleccionado);

				// Crear un JComboBox con las opciones de color
				String[] colores = { "Azul", "Verde", "Amarillo", "Naranja", "Rojo" };
				JComboBox<String> colorComboBox = new JComboBox<>(colores);

				// Obtener el indice del color actual en la lista
				int indiceColorActual = obtenerIndiceColorEnLista(colores, colorActual);
				// Establecer el color actual como seleccion predeterminada
				colorComboBox.setSelectedIndex(indiceColorActual);

				// Crear un JTextArea para ingresar el nuevo resultado
				JTextArea resultadoTextArea = new JTextArea(5, 20);

				// Ajustar el numero de filas y columnas del JTextArea
				resultadoTextArea.setRows(2); // Aumentar el numero de filas
				resultadoTextArea.setColumns(5); // Ajustar el numero de columnas

				// Crear un panel para contener los componentes
				JPanel panel = new JPanel(new GridLayout(0, 1));
				panel.add(new JLabel("Seleccione un color:"));
				panel.add(colorComboBox);
				panel.add(new JLabel("Motivo:"));
				panel.add(new JScrollPane(resultadoTextArea));

				int result = JOptionPane.showConfirmDialog(null, panel, "Modificar Resultado",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {
					String nuevoResultado = resultadoTextArea.getText();
					String colorSeleccionado = (String) colorComboBox.getSelectedItem();

					// Verificar si se está sobrepasando en más de 2 niveles
					if (!puedeCambiarColor(colorActual, colorSeleccionado)) {
						JOptionPane.showMessageDialog(null,
								"El cambio de color no puede ser superior/inferior a 2 niveles", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					} else {
						boolean resultadoActualizado = dao.actualizarColorFinalYMotivoCambio(nombrePacienteSeleccionado,
								nuevoResultado, colorSeleccionado);
						actualizarTabla();
					}
				}
			}

			private boolean puedeCambiarColor(String colorActual, String colorSeleccionado) {
				String[] colores = { "Azul", "Verde", "Amarillo", "Naranja", "Rojo" };

				int indiceColorActual = obtenerIndiceColorEnLista(colores, colorActual);
				int indiceColorSeleccionado = obtenerIndiceColorEnLista(colores, colorSeleccionado);

				return Math.abs(indiceColorActual - indiceColorSeleccionado) <= 2;
			}

			private int obtenerIndiceColorEnLista(String[] colores, String color) {
				for (int i = 0; i < colores.length; i++) {
					if (colores[i].equals(color)) {
						return i;
					}
				}
				return -1;
			}
		});

		// Agrega un ActionListener al JComboBox
		boxPacientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String elementoSeleccionado = (String) boxPacientes.getSelectedItem();
				String[] partes = elementoSeleccionado.split(" - ");
				txtNombreApellido.setText(partes[0]);
				txtDNI.setText(partes[1]);
			}
		});

	}
	
	private void colocarHoraActual() {
		Date todayDate = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String fechaActual = fecha.format(todayDate);
        String horaActual = hora.format(todayDate);
        txtFecha.setText(fechaActual);
        txtHora.setText(horaActual);
	}

	private void cargarNombreApellidoPacientes() {
        ArrayList<String> nombreApellidos = obtenerNombreApellidoPacientesDesdeAdmision();

        if (nombreApellidos != null) {
            boxPacientes.removeAllItems();
            String primerElemento = nombreApellidos.get(0);
            String[] partes = primerElemento.split(" - ");
            txtNombreApellido.setText(partes[0]);
            txtDNI.setText(partes[1]);
            for (String nombreApellido : nombreApellidos) {
                boxPacientes.addItem(nombreApellido);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los nombres y apellidos de los pacientes desde Admisión.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ArrayList<String> obtenerNombreApellidoPacientesDesdeAdmision() {
        return dao.obtenerNombreYDNIPacientesDesdeAdmision();
    }
	
	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		
		lista=dao.ConsultaTriage();
		
		for (Triage u:lista) {
			Object triage[]= new Object[6];
			triage[0]=u.getNombre_paciente();
			triage[1]=u.getResultado_triage();
			triage[2]=u.getMotivo_cambio();
			triage[3]=u.getColor_final();
			triage[4]=u.getFecha_triage();
			triage[5]=u.getHora_triage();
			
			modelo.addRow(triage);
		}
		table.setModel(modelo);
	}
	
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}