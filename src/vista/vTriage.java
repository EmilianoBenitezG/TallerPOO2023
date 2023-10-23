package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

import dao.daoTriage;
import modelo.Triage;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class vTriage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblFiebre;
	private JLabel lblVomitos_2_1;
	private JLabel lblDolorDePecho;
	private JLabel lblDolorAbdominal;
	private JLabel lblLesionesGraves;
	private JLabel lblLesionesLeves;
	private JLabel lblVomitos;
	private JLabel lblSangrado;
	private JLabel lblVomitos_1;
	private JLabel lblSignosDeShock;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JComboBox comboBox_8;
	private JComboBox comboBox_9;
	private JComboBox comboBox_10;
	private JTextField textField_1;
	private JLabel lblConciencia;
	private JComboBox comboBox_11;
	private JComboBox<String> comboBox_12;
	private JTable table;
	private JScrollPane scrollPane;
	private daoTriage dao = new daoTriage();
	String[] columnNames = {"Nombre Paciente", "Color Sugerido","Hora"};
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
		setBounds(100, 100, 827, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Hora");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 66, 137, 24);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Respiraci\u00F3n");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 101, 137, 24);
		contentPane.add(lblNewLabel_2);
		
		lblFiebre = new JLabel("Fiebre");
		lblFiebre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFiebre.setBounds(10, 135, 137, 24);
		contentPane.add(lblFiebre);
		
		lblSignosDeShock = new JLabel("Signos de Shock");
		lblSignosDeShock.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSignosDeShock.setBounds(10, 450, 137, 24);
		contentPane.add(lblSignosDeShock);
		
		lblLesionesLeves = new JLabel("Lesiones Leves");
		lblLesionesLeves.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLesionesLeves.setBounds(10, 310, 137, 24);
		contentPane.add(lblLesionesLeves);
		
		lblLesionesGraves = new JLabel("Lesiones Graves");
		lblLesionesGraves.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLesionesGraves.setBounds(10, 275, 137, 24);
		contentPane.add(lblLesionesGraves);
		
		lblDolorAbdominal = new JLabel("Dolor Abdominal");
		lblDolorAbdominal.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDolorAbdominal.setBounds(10, 240, 137, 24);
		contentPane.add(lblDolorAbdominal);
		
		lblSangrado = new JLabel("Sangrado");
		lblSangrado.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSangrado.setBounds(10, 380, 137, 24);
		contentPane.add(lblSangrado);
		
		lblVomitos = new JLabel("Estado Mental\r\n");
		lblVomitos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVomitos.setBounds(10, 345, 137, 24);
		contentPane.add(lblVomitos);
		
		lblDolorDePecho = new JLabel("Dolor de Pecho");
		lblDolorDePecho.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDolorDePecho.setBounds(10, 205, 137, 24);
		contentPane.add(lblDolorDePecho);
		
		lblVomitos_1 = new JLabel("Vomitos");
		lblVomitos_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVomitos_1.setBounds(10, 415, 137, 24);
		contentPane.add(lblVomitos_1);
		
		lblVomitos_2_1 = new JLabel("Pulso");
		lblVomitos_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVomitos_2_1.setBounds(10, 170, 137, 24);
		contentPane.add(lblVomitos_2_1);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Dificultad respiratoria moderada", "Dificultad respiratoria grave"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setToolTipText("Seleccione una opcion");
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(157, 101, 287, 22);
		contentPane.add(comboBox);
		// ActionListener para el ComboBox de Respiracion
	    comboBox.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Obtener el indice de la opcion seleccionada
	            int seleccion = comboBox.getSelectedIndex();

	            // Establecer la puntuacion de Respiracion en daoTriage
	            dao.setPuntuacionRespiracion(seleccion);

	        }
	    });
	  

		lblNewLabel_1 = new JLabel("Nombre del Paciente: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 222, 44);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vTriage.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(712, 486, 89, 23);
		contentPane.add(btnNewButton);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(613, 486, 89, 23);
		contentPane.add(btnGuardar);
		

		btnGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener la edad ingresada por el usuario
		        String edad = textField_1.getText();
		        String nombrePacienteSeleccionado = comboBox_12.getSelectedItem().toString();

		        // Obtener las selecciones de los ComboBox
		        int respiracion = comboBox.getSelectedIndex();
		        int fiebre = comboBox_1.getSelectedIndex();
		        int pulso = comboBox_2.getSelectedIndex();
		        int dolorPecho = comboBox_3.getSelectedIndex();
		        int dolorAbdominal = comboBox_4.getSelectedIndex();
		        int lesionesGraves = comboBox_5.getSelectedIndex();
		        int lesionesLeves = comboBox_6.getSelectedIndex();
		        int estadoMental = comboBox_7.getSelectedIndex();
		        int sangrado = comboBox_8.getSelectedIndex();
		        int vomitos = comboBox_9.getSelectedIndex();
		        int signosShock = comboBox_10.getSelectedIndex();
		        int conciencia = comboBox_11.getSelectedIndex();

		        // Calcular la puntuacion total
		        int puntuacionTotal = respiracion + fiebre + pulso + dolorPecho + dolorAbdominal + lesionesGraves + lesionesLeves 
		            + estadoMental + sangrado + vomitos + signosShock + conciencia;

		        // Calcular el color del resultado
		        String colorResultado;
		        if (puntuacionTotal > 15) {
		            colorResultado = "Rojo";
		        } else if (puntuacionTotal >= 10) {
		            colorResultado = "Naranja";
		        } else if (puntuacionTotal >= 5) {
		            colorResultado = "Amarillo";
		        } else {
		            colorResultado = "Verde";
		        }

		        // Almacenar el color del resultado en la base de datos utilizando daoTriage
		        boolean resultadoGuardado = dao.almacenarResultadoTriage(nombrePacienteSeleccionado, colorResultado);

		        // Mostrar un mensaje con el color del paciente y la confirmación de la base de datos
		        String mensaje = "Nombre del Paciente: " + nombrePacienteSeleccionado + "\nColor del Resultado: " + colorResultado;
		        actualizarTabla();

		    }
		});

		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(0, 0, 0));
		comboBox_1.setToolTipText("Seleccione una opcion");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Sin fiebre", "Fiebre moderada", "Fiebre alta"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setMaximumRowCount(4);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_1.setBounds(157, 138, 287, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el indice de la opcion seleccionada
		        int seleccion = comboBox_1.getSelectedIndex();

		        // Establecer la puntuacion de Fiebre en daoTriage
		        dao.setPuntuacionFiebre(seleccion);

		    }
		});

		
		
		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Seleccione una opcion");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Anormal (rapido o lento)"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setMaximumRowCount(4);
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_2.setBounds(157, 173, 287, 22);
		contentPane.add(comboBox_2);
		
		// ActionListener para el ComboBox de Pulso
		comboBox_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el ï¿½ndice de la opciï¿½n seleccionada
		        int seleccion = comboBox_2.getSelectedIndex();

		        // Establecer la puntuaciï¿½n de Pulso en daoTriage
		        dao.setPuntuacionPulso(seleccion);

		    }
		});

		
		comboBox_3 = new JComboBox();
		comboBox_3.setToolTipText("Seleccione una opcion");
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"No presente", "Presente"}));
		comboBox_3.setSelectedIndex(0);
		comboBox_3.setMaximumRowCount(4);
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_3.setBounds(157, 208, 287, 22);
		contentPane.add(comboBox_3);
		
		comboBox_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el indice de la opcion seleccionada
		        int seleccion = comboBox_3.getSelectedIndex();

		        // Establecer la puntuacion de Dolor de Pecho en daoTriage
		        dao.setPuntuacionDolorPecho(seleccion);

		    }
		});
		
		
		comboBox_4 = new JComboBox();
		comboBox_4.setToolTipText("Seleccione una opcion");
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"No presente", "Dolor abdominal moderado", "Dolor abdominal severo"}));
		comboBox_4.setSelectedIndex(0);
		comboBox_4.setMaximumRowCount(4);
		comboBox_4.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_4.setBounds(157, 243, 287, 22);
		contentPane.add(comboBox_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setToolTipText("Seleccione una opcion");
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"No Presente", "Presentes"}));
		comboBox_5.setSelectedIndex(0);
		comboBox_5.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_5.setBounds(157, 278, 287, 22);
		contentPane.add(comboBox_5);

		
		// ActionListener para el ComboBox de Lesiones Graves
		comboBox_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el indice de la opcion seleccionada
		        int seleccion = comboBox_5.getSelectedIndex();
		        int puntuacion = 0; // Valor predeterminado para la opcion 0

		        // Actualizar la puntuacion en funcion  de la seleccion 
		        if (seleccion == 1) {
		            puntuacion = 2; // Cambiar el valor a 2 si se selecciona la opcion "Presentes"
		        } 
		        // Establecer la puntuacion de Lesiones Graves en daoTriage
		        dao.setPuntuacionLesionesGraves(puntuacion);

		    }
		});

		
		comboBox_6 = new JComboBox();
		comboBox_6.setToolTipText("Seleccione una opcion");
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"No presentes", "Presentes"}));
		comboBox_6.setSelectedIndex(0);
		comboBox_6.setMaximumRowCount(4);
		comboBox_6.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_6.setBounds(157, 313, 287, 22);
		contentPane.add(comboBox_6);
		
		comboBox_6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = comboBox_6.getSelectedIndex();
		        dao.setPuntuacionLesionesLeves(seleccion);

		    }
		});
		
		comboBox_7 = new JComboBox();
		comboBox_7.setToolTipText("Seleccione una opcion");
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Confusion leve", "Confusion grave o somnolencia"}));
		comboBox_7.setSelectedIndex(0);
		comboBox_7.setMaximumRowCount(4);
		comboBox_7.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_7.setBounds(157, 348, 287, 22);
		contentPane.add(comboBox_7);
		
		comboBox_7.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = comboBox_7.getSelectedIndex();
		        
		        // Al igual que con otros sintomas, decide si deseas almacenar esta puntuacionn en tu objeto `daoTriage`
		        dao.setPuntuacionEstadoMental(seleccion);

		    }
		});

		
		comboBox_8 = new JComboBox();
		comboBox_8.setToolTipText("Seleccione una opcion");
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"No presente", "Sangrado moderado", "Sangrado intenso"}));
		comboBox_8.setSelectedIndex(0);
		comboBox_8.setMaximumRowCount(4);
		comboBox_8.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_8.setBounds(157, 383, 287, 22);
		contentPane.add(comboBox_8);
		
		comboBox_8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = comboBox_8.getSelectedIndex();
		        
		        
		        dao.setPuntuacionSangrado(seleccion);

		    }
		});
		
		comboBox_9 = new JComboBox();
		comboBox_9.setToolTipText("Seleccione una opcion");
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Sin Vomitos", "Vomitos moderados", "Vomitos intensos"}));
		comboBox_9.setSelectedIndex(0);
		comboBox_9.setMaximumRowCount(4);
		comboBox_9.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_9.setBounds(157, 418, 287, 22);
		contentPane.add(comboBox_9);
		
		comboBox_9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = comboBox_9.getSelectedIndex();
		        
		        dao.setPuntuacionVomitos(seleccion);

		    }
		});
		
		
		comboBox_10 = new JComboBox();
		comboBox_10.setToolTipText("Seleccione una opcion");
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"No presentes", "Presentes"}));
		comboBox_10.setSelectedIndex(0);
		comboBox_10.setMaximumRowCount(4);
		comboBox_10.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_10.setBounds(157, 453, 287, 22);
		contentPane.add(comboBox_10);
		
		comboBox_10.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = comboBox_10.getSelectedIndex();
		        
		        dao.setPuntuacionSignosdeShock(seleccion);

		    }
		});
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Edad del Paciente");
		textField_1.setBounds(157, 70, 60, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		lblConciencia = new JLabel("Conciencia\r\n");
		lblConciencia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConciencia.setBounds(10, 485, 137, 24);
		contentPane.add(lblConciencia);
		
		comboBox_11 = new JComboBox();
		comboBox_11.setToolTipText("Seleccione una opcion");
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Consciente y alerta", "Perdida de conciencia"}));
		comboBox_11.setSelectedIndex(0);
		comboBox_11.setMaximumRowCount(4);
		comboBox_11.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_11.setBounds(157, 486, 287, 22);
		contentPane.add(comboBox_11);
		
		comboBox_11.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int seleccion = comboBox_11.getSelectedIndex();
		        
		        dao.setPuntuacionConciencia(seleccion);

		    }
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(484, 101, 317, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre Paciente", "Resultado"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		
		actualizarTabla();
		scrollPane.setViewportView(table);
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(703, 11, 98, 18);
		contentPane.add(lblRol);
		
		lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(678, 11, 25, 18);
		contentPane.add(lblCaptionRol);
		
		
		comboBox_12 = new JComboBox<String>();
		comboBox_12.setToolTipText("Seleccione un paciente");
		comboBox_12.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_12.setMaximumRowCount(10);
		comboBox_12.setBounds(205, 11, 287, 36);
		contentPane.add(comboBox_12);
		cargarNombreApellidoPacientes();		
	}
	
	private void cargarNombreApellidoPacientes() {
        ArrayList<String> nombreApellidos = obtenerNombreApellidoPacientesDesdeAdmision();

        if (nombreApellidos != null) {
            // Elimina cualquier elemento existente en el ComboBox
            comboBox_12.removeAllItems();

            for (String nombreApellido : nombreApellidos) {
                comboBox_12.addItem(nombreApellido);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los nombres y apellidos de los pacientes desde Admisión.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ArrayList<String> obtenerNombreApellidoPacientesDesdeAdmision() {
        return dao.obtenerNombreApellidoPacientesDesdeAdmision();
    }
	

	public void actualizarTabla() {
		//elimina los registros para volverlos a crear
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		
		lista=dao.ConsultaTriage();
		
		for (Triage u:lista) {
			Object triage[]= new Object[3];
			triage[0]=u.getNombre_paciente();
			triage[1]=u.getResultado_triage();
			modelo.addRow(triage);
		}
		table.setModel(modelo);
	}
	
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
	
}