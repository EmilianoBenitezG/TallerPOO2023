package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
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

import dao.daoHistorial;
import dao.daoPacientes;
import dao.daoResultadosEstudios;
import modelo.HistoriaClinicaPaciente;
import modelo.Paciente;
import modelo.ResultadosEstudios;

public class vHistoriaClinica extends JFrame {

	private JPanel contentPane;

	private JTextField txtNombreApellido;
	private JTextField txtDNI;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JComboBox<String> cmbLugarAtencion;
	private JEditorPane txtTextoMedico;
	private JTextField txtHistorialDiagnostico;
	private JTable tlbResultados;

	private Paciente pacienteSeleccionado;
	JLabel lblRol = new JLabel("Rol");

	int fila = -1;
	DefaultTableModel modelo = new DefaultTableModel();
	daoHistorial dao = new daoHistorial();
	ArrayList<HistoriaClinicaPaciente> lista = new ArrayList<>();
	HistoriaClinicaPaciente historial;

	private JTable tlbHistorial;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vHistoriaClinica frame = new vHistoriaClinica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vHistoriaClinica() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHistorial = new JLabel("Historia Clinica");
		lblHistorial.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblHistorial.setBounds(327, 4, 280, 33);
		contentPane.add(lblHistorial);

		// Campos de ingreso de datos
		// Nombre y apellido
		JLabel lblNombreApellido = new JLabel("Nombre y apellido:");
		lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellido.setBounds(232, 60, 140, 22);
		contentPane.add(lblNombreApellido);

		txtNombreApellido = new JTextField();
		txtNombreApellido.setEditable(false);
		txtNombreApellido.setBounds(370, 60, 170, 22);
		contentPane.add(txtNombreApellido);
		setLocationRelativeTo(null);

		// DNI
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(552, 60, 40, 22);
		contentPane.add(lblDni);

		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(591, 60, 97, 22);
		contentPane.add(txtDNI);

		// Fecha
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setBounds(148, 107, 85, 22);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(97, 107, 57, 22);
		contentPane.add(lblFecha);

		// Hora
		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHora.setColumns(10);
		txtHora.setBounds(287, 107, 49, 22);
		contentPane.add(txtHora);

		JLabel lblHora = new JLabel("Hora: ");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(243, 107, 49, 22);
		contentPane.add(lblHora);

		// Lugar de Atenci�n (usando JComboBox)
		String[] lugaresAtencion = { "CONSULTORIO", "EMERGENCIA", "INTERNACIONES" };
		cmbLugarAtencion = new JComboBox<>(lugaresAtencion);
		cmbLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbLugarAtencion.setBounds(493, 107, 131, 22);
		contentPane.add(cmbLugarAtencion);

		JLabel lblLugarAtencion = new JLabel("Lugar de Atenci�n: ");
		lblLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLugarAtencion.setBounds(353, 107, 140, 22);
		contentPane.add(lblLugarAtencion);

		// Texto M�dico (JEditorPane)
		txtTextoMedico = new JEditorPane();
		txtTextoMedico.setBounds(293, 144, 298, 62);
		contentPane.add(txtTextoMedico);

		JLabel lblTextoMedico = new JLabel("Texto M�dico: ");
		lblTextoMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTextoMedico.setBounds(186, 144, 105, 22);
		contentPane.add(lblTextoMedico);

		// Historial de Diagn�stico
		txtHistorialDiagnostico = new JTextField();
		txtHistorialDiagnostico.setColumns(10);
		txtHistorialDiagnostico.setBounds(743, 107, 170, 22);
		contentPane.add(txtHistorialDiagnostico);

		JLabel lblHistorialDiagnostico = new JLabel("Diagn\u00F3stico: ");
		lblHistorialDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHistorialDiagnostico.setBounds(651, 107, 93, 22);
		contentPane.add(lblHistorialDiagnostico);

		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(955, 13, 98, 18);
		contentPane.add(lblRol);

		// Botones en pantalla
		// Bot�n Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fila != -1) {
					try {
						historial = lista.get(fila);
						historial.setFecha(txtFecha.getText());
						historial.setHora(txtHora.getText());
						historial.setLugarDeAtencion((String) cmbLugarAtencion.getSelectedItem());
						historial.setTextoMedico(txtTextoMedico.getText());
						historial.setHistorialDiagnostico(txtHistorialDiagnostico.getText());

						if (dao.modificarHistorial(historial)) {
							actualizarTabla();
							limpiarCampos();
							JOptionPane.showMessageDialog(null, "Se modific� correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "Error al modificar el historial");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error al modificar el historial: " + e2.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona un historial para modificar.");
				}
			}
		});
		btnModificar.setBounds(232, 240, 125, 22);
		contentPane.add(btnModificar);

		// Bot�n Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HistoriaClinicaPaciente historial = new HistoriaClinicaPaciente();
					historial.setFecha(txtFecha.getText());
					historial.setHora(txtHora.getText());
					historial.setLugarDeAtencion((String) cmbLugarAtencion.getSelectedItem());
					historial.setTextoMedico(txtTextoMedico.getText());
					historial.setHistorialDiagnostico(txtHistorialDiagnostico.getText());

					if (dao.insertarHistorial(historial)) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "Se agreg� correctamente");
						limpiarCampos();
					} else {
						JOptionPane.showMessageDialog(null, "Error al agregar el historial");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
				}
			}
		});
		btnAgregar.setBounds(400, 240, 125, 22);
		contentPane.add(btnAgregar);

		// Boton para volver limpiar campos de entrada
		JButton btnLimpiar = new JButton("Limpiar campos");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLimpiar.setBounds(565, 240, 164, 22);
		contentPane.add(btnLimpiar);

		// Bot�n Volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menu = new menuPrincipal();
				menu.transferirDatos(lblRol.getText());
				menu.setVisible(true);
				vHistoriaClinica.this.dispose();
			}
		});
		btnVolver.setBounds(10, 11, 85, 36);
		contentPane.add(btnVolver);

		// Bot�n para buscar pacientes
		JButton btnBuscarPaciente = new JButton("Seleccionar Paciente");
		btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarPaciente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        daoPacientes dao = new daoPacientes();
		        ArrayList<Paciente> pacientes = dao.buscarPacientes();
		        DefaultListModel<Paciente> pacienteListModel = new DefaultListModel<>();

		        for (Paciente paciente : pacientes) {
		            pacienteListModel.addElement(paciente);
		        }

		        SeleccionarPaciente dialog = new SeleccionarPaciente(vHistoriaClinica.this, pacienteListModel);
		        dialog.setVisible(true);
		        pacienteSeleccionado = dialog.getSelectedPaciente();
		        if (pacienteSeleccionado != null) {
		            txtDNI.setText(pacienteSeleccionado.getDNI());
		            txtNombreApellido.setText(pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido());
		            cargarHistorialPorPaciente(pacienteSeleccionado.getId());
		            actualizarTabla();
		        }
		    }
		});

		btnBuscarPaciente.setBounds(20, 60, 201, 30);
		contentPane.add(btnBuscarPaciente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 299, 999, 216);
		contentPane.add(scrollPane);

		tlbHistorial = new JTable(modelo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tlbHistorial.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Fecha", "Hora", "Lugar de Atenci�n", "Texto M�dico", "Diagn�stico", }));
		scrollPane.setViewportView(tlbHistorial);

		JLabel lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(928, 13, 25, 18);
		contentPane.add(lblCaptionRol);

		// Bot�n para ver resultados de estudios
		JButton btnVerResultados = new JButton("Ver Resultados de Estudios");
		btnVerResultados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVerResultados.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (pacienteSeleccionado != null) {
		            cargarResultadosEstudios(pacienteSeleccionado.getId());
		        } else {
		            // Manejar la situaci�n en la que no se ha seleccionado un paciente.
		        }
		    }
		});
		btnVerResultados.setBounds(615, 144, 182, 23);
		contentPane.add(btnVerResultados);

		tlbResultados = new JTable(new DefaultTableModel(
		    new Object[]{"Fecha", "Hora", "Tipo de Estudio", "Informe"}, 0));
		tlbResultados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tlbResultados.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPaneResultados = new JScrollPane(tlbResultados);
		scrollPaneResultados.setBounds(10, 333, 999, 182);
		contentPane.add(scrollPaneResultados);

		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Lugar de Atenci�n");
		modelo.addColumn("Diagn�stico");
		modelo.addColumn("Texto M�dico");
		setLocationRelativeTo(null);

		tlbHistorial.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        fila = tlbHistorial.getSelectedRow();
		        if (fila >= 0) {
		        } else {
		        }
		    }
		});

		tlbHistorial.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            if (tlbHistorial.getSelectedRow() != -1) {
		                int selectedRow = tlbHistorial.getSelectedRow();
		                HistoriaClinicaPaciente historial = lista.get(selectedRow);
		                cargarResultadosEstudios(historial.getId());
		            }
		        }
		    }
		});

	}
	
	private void cargarDatosPacienteSeleccionado(Paciente paciente) {
	    txtDNI.setText(paciente.getDNI());
	    txtNombreApellido.setText(paciente.getNombre() + " " + paciente.getApellido());
	}

	private void cargarResultadosEstudios(int pacienteId) {
	    DefaultTableModel resultadosModel = (DefaultTableModel) tlbResultados.getModel();
	    resultadosModel.setRowCount(0);

	    daoResultadosEstudios dao = new daoResultadosEstudios();
	    ArrayList<ResultadosEstudios> resultados = dao.buscarResultadosEstudiosPorPaciente(pacienteId);

	    for (ResultadosEstudios resultado : resultados) {
	        resultadosModel.addRow(new Object[] {
	            resultado.getFecha(),
	            resultado.getHora(),
	            resultado.getTipoEstudio(),
	            resultado.getInforme()
	        });
	    }
	}

	private void cargarHistorial(HistoriaClinicaPaciente historia) {
		txtFecha.setText(historia.getFecha());
		txtHora.setText(historia.getHora());
		cmbLugarAtencion.setSelectedItem(historia.getLugarDeAtencion());
		txtTextoMedico.setText(historia.getTextoMedico());
		txtHistorialDiagnostico.setText(historia.getHistorialDiagnostico());
	}
	
	private void cargarHistorialPorPaciente(int pacienteId) {
	    modelo.setRowCount(0);

	    lista = dao.buscarHistorialPorPaciente(pacienteId);

	    for (HistoriaClinicaPaciente historial : lista) {
	        modelo.addRow(new Object[] {
	            historial.getFecha(),
	            historial.getHora(),
	            historial.getLugarDeAtencion(),
	            historial.getHistorialDiagnostico(),
	            historial.getTextoMedico()
	        });
	    }
	}
	private void actualizarTabla() {
	    modelo.setRowCount(0);
	    if (pacienteSeleccionado != null) {
	        lista = dao.buscarHistorialPorPaciente(pacienteSeleccionado.getId()); 
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        for (HistoriaClinicaPaciente historial : lista) {
	            modelo.addRow(new Object[] { 
	                historial.getFecha(), 
	                historial.getHora(), 
	                historial.getLugarDeAtencion(),
	                historial.getHistorialDiagnostico(), 
	                historial.getTextoMedico() 
	            });
	        }
	    }
	}

	private void limpiarCampos() {
		txtFecha.setText("");
		txtHora.setText("");
		cmbLugarAtencion.setSelectedIndex(0);
		txtTextoMedico.setText("");
		txtHistorialDiagnostico.setText("");
		pacienteSeleccionado = null;
		txtNombreApellido.setText("");
		txtDNI.setText("");
	}
	
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}