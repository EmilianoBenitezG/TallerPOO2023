package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import dao.daoTriage;
import modelo.Triage;
import modelo.Usuario;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

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
	private JComboBox comboBox_12;
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
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public vTriage() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Nombre de cada Variable Triage
		
		lblRespiracion = new JLabel("Respiraci\u00F3n");
		lblRespiracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRespiracion.setBounds(10, 169, 85, 24);
		contentPane.add(lblRespiracion);
		
		lblFiebre = new JLabel("Fiebre");
		lblFiebre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiebre.setBounds(10, 229, 49, 24);
		contentPane.add(lblFiebre);
		
		lblSignosDeShock = new JLabel("Signos de Shock");
		lblSignosDeShock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSignosDeShock.setBounds(417, 229, 128, 24);
		contentPane.add(lblSignosDeShock);
		
		lblLesionesLeves = new JLabel("Lesiones Leves");
		lblLesionesLeves.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLesionesLeves.setBounds(557, 229, 120, 24);
		contentPane.add(lblLesionesLeves);
		
		lblLesionesGraves = new JLabel("Lesiones Graves");
		lblLesionesGraves.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLesionesGraves.setBounds(687, 169, 120, 24);
		contentPane.add(lblLesionesGraves);
		
		lblDolorAbdominal = new JLabel("Dolor Abdominal");
		lblDolorAbdominal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDolorAbdominal.setBounds(270, 229, 137, 24);
		contentPane.add(lblDolorAbdominal);
		
		lblSangrado = new JLabel("Sangrado");
		lblSangrado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSangrado.setBounds(687, 229, 73, 24);
		contentPane.add(lblSangrado);
		
		lblEstadoMental = new JLabel("Estado Mental\r\n");
		lblEstadoMental.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoMental.setBounds(270, 169, 109, 24);
		contentPane.add(lblEstadoMental);
		
		lblDolorDePecho = new JLabel("Dolor de Pecho");
		lblDolorDePecho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDolorDePecho.setBounds(557, 169, 120, 24);
		contentPane.add(lblDolorDePecho);
		
		lblVomitos = new JLabel("Vomitos");
		lblVomitos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVomitos.setBounds(140, 229, 73, 24);
		contentPane.add(lblVomitos);
		
		lblPulso = new JLabel("Pulso");
		lblPulso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPulso.setBounds(140, 169, 53, 24);
		contentPane.add(lblPulso);
		
		// Hora
        JLabel lblHora = new JLabel("Hora");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHora.setBounds(694, 100, 45, 22);
        contentPane.add(lblHora);

        txtHora = new JTextField();
        txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtHora.setColumns(10);
        txtHora.setBounds(694, 125, 121, 22);
        contentPane.add(txtHora);

        // Fecha
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFecha.setBounds(512, 100, 56, 22);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtFecha.setBounds(510, 125, 102, 22);
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        // Nombre y apellido
        JLabel lblNombreApellido = new JLabel("Nombre y apellido");
        lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNombreApellido.setBounds(68, 100, 152, 22);
        contentPane.add(lblNombreApellido);

        txtNombreApellido = new JTextField();
        txtNombreApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtNombreApellido.setEditable(false);
        txtNombreApellido.setBounds(68, 125, 170, 22);
        contentPane.add(txtNombreApellido);
        setLocationRelativeTo(null);
        
        
        // DNI
        JLabel lblDni = new JLabel("DNI");
        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDni.setBounds(319, 100, 40, 22);
        contentPane.add(lblDni);

        txtDNI = new JTextField();
        txtDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtDNI.setEditable(false);
        txtDNI.setBounds(319, 125, 109, 22);
        contentPane.add(txtDNI);
        
        // Botón para buscar pacientes
        JButton btnBuscarPaciente = new JButton("Seleccionar Paciente");
        btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBuscarPaciente.setBounds(65, 59, 201, 30);
        contentPane.add(btnBuscarPaciente);
        btnBuscarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el paciente seleccionado en el ComboBox
                String seleccion = comboBox_12.getSelectedItem().toString();

                // Dividir la selección en NombreApellido y DNI
                String[] partes = seleccion.split(" - ");
                if (partes.length == 2) {
                    String nombreApellido = partes[0];
                    String dni = partes[1];

                    // Establecer el nombre y DNI en los campos de texto
                    txtNombreApellido.setText(nombreApellido);
                    txtDNI.setText(dni);
                } else {
                    // Manejar el caso en el que no se pudo obtener la información
                    JOptionPane.showMessageDialog(vTriage.this, "No se pudo obtener la información del paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

      

		BoxRespiracion = new JComboBox();
		BoxRespiracion.setForeground(new Color(0, 0, 0));
		BoxRespiracion.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Dificultad respiratoria moderada", "Dificultad respiratoria grave"}));
		BoxRespiracion.setSelectedIndex(0);
		BoxRespiracion.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxRespiracion.setToolTipText("Seleccione una opcion");
		BoxRespiracion.setMaximumRowCount(4);
		BoxRespiracion.setBounds(10, 193, 120, 22);
		contentPane.add(BoxRespiracion);
		// ActionListener para el ComboBox de Respiracion
	    BoxRespiracion.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Obtener el indice de la opcion seleccionada
	            int seleccion = BoxRespiracion.getSelectedIndex();

	            // Establecer la puntuacion de Respiracion en daoTriage
	            dao.setPuntuacionRespiracion(seleccion);

	        }
	    });
		
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
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(319, 286, 89, 23);
		contentPane.add(btnGuardar);
		

		btnGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el nombre del paciente seleccionado en el ComboBox
		        String seleccion = comboBox_12.getSelectedItem().toString();
		        String[] partes = seleccion.split(" - ");
		        String nombrePacienteSeleccionado = partes[0];
		        String dniPaciente = txtDNI.getText();
		        String horaTriage = txtHora.getText();
		        String fechaTriage = txtFecha.getText();

		        // Obtener las selecciones de los ComboBox
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

		        // Calcular la puntuación total
		        int puntuaciónTotal = respiracion + fiebre + pulso + dolorPecho + dolorAbdominal + lesionesGraves + lesionesLeves
		                + estadoMental + sangrado + vomitos + signosShock + conciencia + edad;

		        // Calcular el color del resultado
		        String colorResultado;
		        if (puntuaciónTotal > 15) {
		            colorResultado = "Rojo";
		        } else if (puntuaciónTotal >= 10) {
		            colorResultado = "Naranja";
		        } else if (puntuaciónTotal >= 5) {
		            colorResultado = "Amarillo";
		        } else {
		            colorResultado = "Verde";
		        }

		        // Almacenar el color del resultado en la base de datos utilizando daoTriage
		        boolean resultadoGuardado = dao.almacenarResultadoTriage(nombrePacienteSeleccionado, colorResultado, fechaTriage, horaTriage, dniPaciente);

		        // Mostrar un mensaje con el color del paciente y la confirmación de la base de datos
		        actualizarTabla();
		    }
		});


		BoxFiebre = new JComboBox();
		BoxFiebre.setForeground(new Color(0, 0, 0));
		BoxFiebre.setToolTipText("Seleccione una opcion");
		BoxFiebre.setModel(new DefaultComboBoxModel(new String[] {"Sin fiebre", "Fiebre moderada", "Fiebre alta"}));
		BoxFiebre.setSelectedIndex(0);
		BoxFiebre.setMaximumRowCount(4);
		BoxFiebre.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxFiebre.setBounds(10, 253, 120, 22);
		contentPane.add(BoxFiebre);
		BoxFiebre.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el indice de la opcion seleccionada
		        int seleccion = BoxFiebre.getSelectedIndex();

		        // Establecer la puntuacion de Fiebre en daoTriage
		        dao.setPuntuacionFiebre(seleccion);

		    }
		});

		
		
		BoxPulso = new JComboBox();
		BoxPulso.setToolTipText("Seleccione una opcion");
		BoxPulso.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Anormal (rapido o lento)"}));
		BoxPulso.setSelectedIndex(0);
		BoxPulso.setMaximumRowCount(4);
		BoxPulso.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxPulso.setBounds(140, 193, 120, 22);
		contentPane.add(BoxPulso);
		
		// ActionListener para el ComboBox de Pulso
		BoxPulso.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el ï¿½ndice de la opciï¿½n seleccionada
		        int seleccion = BoxPulso.getSelectedIndex();

		        // Establecer la puntuaciï¿½n de Pulso en daoTriage
		        dao.setPuntuacionPulso(seleccion);

		    }
		});

		
		BoxDolorDePecho = new JComboBox();
		BoxDolorDePecho.setToolTipText("Seleccione una opcion");
		BoxDolorDePecho.setModel(new DefaultComboBoxModel(new String[] {"No presente", "Presente"}));
		BoxDolorDePecho.setSelectedIndex(0);
		BoxDolorDePecho.setMaximumRowCount(4);
		BoxDolorDePecho.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxDolorDePecho.setBounds(557, 193, 120, 22);
		contentPane.add(BoxDolorDePecho);
		
		BoxDolorDePecho.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el indice de la opcion seleccionada
		        int seleccion = BoxDolorDePecho.getSelectedIndex();

		        // Establecer la puntuacion de Dolor de Pecho en daoTriage
		        dao.setPuntuacionDolorPecho(seleccion);

		    }
		});
		
		
		BoxDolorAbdominal = new JComboBox();
		BoxDolorAbdominal.setToolTipText("Seleccione una opcion");
		BoxDolorAbdominal.setModel(new DefaultComboBoxModel(new String[] {"No presente", "Dolor abdominal moderado", "Dolor abdominal severo"}));
		BoxDolorAbdominal.setSelectedIndex(0);
		BoxDolorAbdominal.setMaximumRowCount(4);
		BoxDolorAbdominal.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxDolorAbdominal.setBounds(270, 253, 128, 22);
		contentPane.add(BoxDolorAbdominal);
		
		BoxLesionesGraves = new JComboBox();
		BoxLesionesGraves.setToolTipText("Seleccione una opcion");
		BoxLesionesGraves.setModel(new DefaultComboBoxModel(new String[] {"No Presente", "Presentes"}));
		BoxLesionesGraves.setSelectedIndex(0);
		BoxLesionesGraves.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxLesionesGraves.setBounds(687, 193, 120, 22);
		contentPane.add(BoxLesionesGraves);

		
		// ActionListener para el ComboBox de Lesiones Graves
		BoxLesionesGraves.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el indice de la opcion seleccionada
		        int seleccion = BoxLesionesGraves.getSelectedIndex();
		        int puntuacion = 0; // Valor predeterminado para la opcion 0

		        // Actualizar la puntuacion en funcion  de la seleccion 
		        if (seleccion == 1) {
		            puntuacion = 2; // Cambiar el valor a 2 si se selecciona la opcion "Presentes"
		        } 
		        // Establecer la puntuacion de Lesiones Graves en daoTriage
		        dao.setPuntuacionLesionesGraves(puntuacion);

		    }
		});

		
		BoxLesionesLeves = new JComboBox();
		BoxLesionesLeves.setToolTipText("Seleccione una opcion");
		BoxLesionesLeves.setModel(new DefaultComboBoxModel(new String[] {"No presentes", "Presentes"}));
		BoxLesionesLeves.setSelectedIndex(0);
		BoxLesionesLeves.setMaximumRowCount(4);
		BoxLesionesLeves.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxLesionesLeves.setBounds(557, 253, 120, 22);
		contentPane.add(BoxLesionesLeves);
		
		BoxLesionesLeves.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = BoxLesionesLeves.getSelectedIndex();
		        dao.setPuntuacionLesionesLeves(seleccion);

		    }
		});
		
		BoxEstadoMental = new JComboBox();
		BoxEstadoMental.setToolTipText("Seleccione una opcion");
		BoxEstadoMental.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Confusion leve", "Confusion grave o somnolencia"}));
		BoxEstadoMental.setSelectedIndex(0);
		BoxEstadoMental.setMaximumRowCount(4);
		BoxEstadoMental.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxEstadoMental.setBounds(270, 193, 128, 22);
		contentPane.add(BoxEstadoMental);
		
		BoxEstadoMental.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = BoxEstadoMental.getSelectedIndex();
		        
		        // Al igual que con otros sintomas, decide si deseas almacenar esta puntuacionn en tu objeto `daoTriage`
		        dao.setPuntuacionEstadoMental(seleccion);

		    }
		});

		
		BoxSangrado = new JComboBox();
		BoxSangrado.setToolTipText("Seleccione una opcion");
		BoxSangrado.setModel(new DefaultComboBoxModel(new String[] {"No presente", "Sangrado moderado", "Sangrado intenso"}));
		BoxSangrado.setSelectedIndex(0);
		BoxSangrado.setMaximumRowCount(4);
		BoxSangrado.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxSangrado.setBounds(687, 253, 120, 22);
		contentPane.add(BoxSangrado);
		
		BoxSangrado.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = BoxSangrado.getSelectedIndex();
		        
		        
		        dao.setPuntuacionSangrado(seleccion);

		    }
		});
		
		BoxVomitos = new JComboBox();
		BoxVomitos.setToolTipText("Seleccione una opcion");
		BoxVomitos.setModel(new DefaultComboBoxModel(new String[] {"Sin Vomitos", "Vomitos moderados", "Vomitos intensos"}));
		BoxVomitos.setSelectedIndex(0);
		BoxVomitos.setMaximumRowCount(4);
		BoxVomitos.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxVomitos.setBounds(140, 253, 120, 22);
		contentPane.add(BoxVomitos);
		
		BoxVomitos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = BoxVomitos.getSelectedIndex();
		        
		        dao.setPuntuacionVomitos(seleccion);

		    }
		});
		
		
		BoxSignosDeShock = new JComboBox();
		BoxSignosDeShock.setToolTipText("Seleccione una opcion");
		BoxSignosDeShock.setModel(new DefaultComboBoxModel(new String[] {"No presentes", "Presentes"}));
		BoxSignosDeShock.setSelectedIndex(0);
		BoxSignosDeShock.setMaximumRowCount(4);
		BoxSignosDeShock.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxSignosDeShock.setBounds(417, 253, 123, 22);
		contentPane.add(BoxSignosDeShock);		
		BoxSignosDeShock.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = BoxSignosDeShock.getSelectedIndex();
		        
		        dao.setPuntuacionSignosdeShock(seleccion);

		    }
		});
		
		
		
		lblConciencia = new JLabel("Conciencia\r\n:");
		lblConciencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConciencia.setBounds(415, 169, 89, 24);
		contentPane.add(lblConciencia);
		
		BoxConciencia = new JComboBox();
		BoxConciencia.setToolTipText("Seleccione una opcion");
		BoxConciencia.setModel(new DefaultComboBoxModel(new String[] {"Consciente y alerta", "Perdida de conciencia"}));
		BoxConciencia.setSelectedIndex(0);
		BoxConciencia.setMaximumRowCount(4);
		BoxConciencia.setFont(new Font("Arial", Font.PLAIN, 14));
		BoxConciencia.setBounds(415, 193, 123, 22);
		contentPane.add(BoxConciencia);		
		BoxConciencia.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = BoxConciencia.getSelectedIndex();
		        
		        dao.setPuntuacionConciencia(seleccion);

		    }
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 320, 944, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nombre Paciente", "Color Sugerido","Motivo Cambio","Color Final","Hora","Fecha"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.setDefaultRenderer(Object.class, new ColorRenderer());
		actualizarTabla();
		
		scrollPane.setViewportView(table);
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(915, 10, 83, 18);
		contentPane.add(lblRol);
		
		lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(880, 10, 25, 18);
		contentPane.add(lblCaptionRol);
		
		comboBox_12 = new JComboBox<String>();
		comboBox_12.setToolTipText("Seleccione un paciente");
		comboBox_12.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_12.setMaximumRowCount(10);
		comboBox_12.setBounds(293, 65, 228, 24);
		contentPane.add(comboBox_12);
		
        
		cargarNombreApellidoPacientes();
		setLocationRelativeTo(null);
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(817, 170, 49, 22);
		contentPane.add(lblEdad);
		
		JLabel lblTriage = new JLabel("Triage");
		lblTriage.setFont(new Font("Dialog", Font.PLAIN, 35));
		lblTriage.setBounds(415, 11, 106, 45);
        contentPane.add(lblTriage);		
        
        BoxEdad = new JComboBox();
        BoxEdad.setToolTipText("Seleccione una opcion");
        BoxEdad.setModel(new DefaultComboBoxModel(new String[] {"Adulto", "Ni\u00F1o/Anciano"}));
        BoxEdad.setSelectedIndex(0);
        BoxEdad.setFont(new Font("Arial", Font.PLAIN, 14));
        BoxEdad.setBounds(817, 193, 109, 22);
        contentPane.add(BoxEdad);
        colocarHoraActual();
        
        JButton btnmodificar = new JButton("Modificar");
        btnmodificar.setBounds(523, 286, 89, 23);
        contentPane.add(btnmodificar);
        btnmodificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre del paciente seleccionado en el ComboBox
                String seleccion = comboBox_12.getSelectedItem().toString();
                String nombrePacienteSeleccionado = null;
                for (String paciente : obtenerNombreApellidoPacientesDesdeAdmision()) {
                    if (paciente.startsWith(seleccion)) {
                        String[] partes = paciente.split(" - "); // Suponiendo que el nombre y apellido están separados por una coma y un espacio
                        if (partes.length == 2) {
                            nombrePacienteSeleccionado = partes[0];
                        }
                        break;
                    }
                }

                // Crear un JComboBox con las opciones de color
                String[] colores = {"Verde", "Amarillo", "Naranja", "Rojo"};
                JComboBox<String> colorComboBox = new JComboBox<>(colores);

                // Crear un JTextArea para ingresar el nuevo resultado
                JTextArea resultadoTextArea = new JTextArea(5, 20);
                
                // Ajustar el número de filas y columnas del JTextArea para cambiar su tamaño
                resultadoTextArea.setRows(2); // Aumentar el número de filas
                resultadoTextArea.setColumns(5); // Ajustar el número de columnas

                // Crear un panel para contener los componentes
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Seleccione un color:"));
                panel.add(colorComboBox);
                panel.add(new JLabel("Motivo:"));
                panel.add(new JScrollPane(resultadoTextArea));

                int result = JOptionPane.showConfirmDialog(null, panel, "Modificar Resultado", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String nuevoResultado = resultadoTextArea.getText();
                    String colorSeleccionado = (String) colorComboBox.getSelectedItem();

                    // Actualizar los campos "color_final" y "motivo_cambio" en la base de datos utilizando daoTriage
                    boolean resultadoActualizado = dao.actualizarColorFinalYMotivoCambio(nombrePacienteSeleccionado, nuevoResultado, colorSeleccionado);
                    actualizarTabla();
                }
            }
        });
        
     // Agrega un ActionListener al JComboBox
        comboBox_12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // El código aquí se ejecutará cuando cambie la selección en el JComboBox
                // Puedes acceder al elemento seleccionado con comboBox.getSelectedItem()
                String elementoSeleccionado = (String) comboBox_12.getSelectedItem();
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
            // Elimina cualquier elemento existente en el ComboBox
            comboBox_12.removeAllItems();
            String primerElemento = nombreApellidos.get(0);
            String[] partes = primerElemento.split(" - ");
            txtNombreApellido.setText(partes[0]);
            txtDNI.setText(partes[1]);
            for (String nombreApellido : nombreApellidos) {
                comboBox_12.addItem(nombreApellido);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los nombres y apellidos de los pacientes desde Admisión.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ArrayList<String> obtenerNombreApellidoPacientesDesdeAdmision() {
        return dao.obtenerNombreYDNIPacientesDesdeAdmision();
    }
	

	public void actualizarTabla() {
		//elimina los registros para volverlos a crear
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