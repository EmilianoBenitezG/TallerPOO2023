package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.daoAsignacion;
import dao.daoMedico;
import dao.daoPacientes;
import modelo.Admision;
import modelo.Asignacion;
import modelo.Medico;
import modelo.Paciente;
import modelo.Triage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class vAsignacion extends JFrame {
    private JPanel contentPane;
    private JTextField txtNombreApellido;
    private JTextField txtDNI;
    private Paciente pacienteSeleccionado;
    private JTextField txtMedico;
    private JTextField txtMatricula;
    private JTextField txtFecha;
    private JTextField txtHora;
    ArrayList<Asignacion> lista;
    String[] columnNames = {"Nombre Paciente", "DNI", "Medico", "Matricula", "Fecha", "Box"};
    Object[][] data = {};
    DefaultTableModel modelo = new DefaultTableModel(data, columnNames) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    private JTable table;
    private daoAsignacion dao = new daoAsignacion();

    // M�todo principal para ejecutar la aplicaci�n
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
		setBounds(100, 100, 909, 537);
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
		txtNombreApellido.setEditable(false);
		txtNombreApellido.setBounds(182, 144, 170, 22);
		contentPane.add(txtNombreApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(374, 144, 40, 22);
		contentPane.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
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
		btnSeleccionarMedico.setBounds(533, 187, 182, 30);
		contentPane.add(btnSeleccionarMedico);
		
		JLabel lblMedico = new JLabel("Medico:");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedico.setBounds(112, 179, 61, 22);
		contentPane.add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setEditable(false);
		txtMedico.setBounds(183, 189, 150, 22);
		contentPane.add(txtMedico);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatricula.setBounds(340, 187, 70, 22);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setEditable(false);
		txtMatricula.setBounds(420, 189, 97, 22);
		contentPane.add(txtMatricula);
		
		JComboBox<String> comboBox_12 = new JComboBox<String>();
		comboBox_12.setModel(new DefaultComboBoxModel(new String[] {"Box 1", "Box 2", "Box 3", "Box 4", "Box 5", "Box 6", "Box 7", "Box 8", "Box 9", "Box 10"}));
		comboBox_12.setToolTipText("Seleccione un paciente");
		comboBox_12.setMaximumRowCount(10);
		comboBox_12.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_12.setBounds(243, 232, 195, 24);
		contentPane.add(comboBox_12);
		
		JLabel lblBox = new JLabel("Box:");
		lblBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBox.setBounds(193, 232, 40, 22);
		contentPane.add(lblBox);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(182, 111, 102, 22);
		contentPane.add(txtFecha);
		
		JLabel lblFecha_1 = new JLabel("Fecha:");
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha_1.setBounds(119, 113, 56, 22);
		contentPane.add(lblFecha_1);
		
		JLabel lblHora_1 = new JLabel("Hora:");
		lblHora_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora_1.setBounds(323, 111, 45, 22);
		contentPane.add(lblHora_1);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHora.setColumns(10);
		txtHora.setBounds(378, 111, 121, 22);
		contentPane.add(txtHora);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombrePaciente = txtNombreApellido.getText();
				String dniPaciente = txtDNI.getText();
				String medicoNombre = txtMedico.getText();
				String matricula = txtMatricula.getText();
				String fecha = txtFecha.getText();
				String hora = txtMatricula.getText();
				String box = comboBox_12.getSelectedItem().toString();
				Paciente paciente = new Paciente();
				paciente.setNombre(nombrePaciente);
				paciente.setDNI(dniPaciente);
				Medico medico = new Medico();
				medico.setNombre(medicoNombre);
				medico.setMatricula(matricula);
				Asignacion asignacion = new Asignacion();
				asignacion.setPaciente(paciente);
				asignacion.setMedico(medico);
				asignacion.setBox(box);
				asignacion.setFecha(fecha);
				asignacion.setHora(hora);
		        if (dao.insertarAsignacion(asignacion)) {
		        	actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Se agreg� correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar la asignaci�n");
                }
            }
        });
        btnAsignar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAsignar.setBounds(465, 232, 121, 24);
        contentPane.add(btnAsignar);

        // JScrollPane para mostrar la tabla de asignaciones
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 267, 865, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre Paciente","DNI","Medico","Matricula","Fecha","Box"
				}
			));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);
		actualizarTabla();
		colocarHoraActual();
	}
	
	public void actualizarTabla() {
		//elimina los registros para volverlos a crear
				while (modelo.getRowCount() > 0) {
					modelo.removeRow(0);
				}
				
				lista=dao.ConsultaAsignaciones();
				
				for (Asignacion u:lista) {
					Object asignacion[]= new Object[6];
					asignacion[0]=u.getPaciente().getNombre();
					asignacion[1]=u.getPaciente().getDNI();
					asignacion[2]=u.getMedico().getNombre();
					asignacion[3]=u.getMedico().getMatricula();
					asignacion[4]=u.getFecha();
					asignacion[5]=u.getBox();
					
					modelo.addRow(asignacion);
				}
		table.setModel(modelo);
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
