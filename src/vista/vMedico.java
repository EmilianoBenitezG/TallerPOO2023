package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.daoAdmision;
import dao.daoEspecialidad;
import dao.daoMedico;
import modelo.Admision;
import modelo.DetallesEspecialidad;
import modelo.Especialidad;
import modelo.Medico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vMedico extends JFrame {

	private JTextField txtNombre;
	private JTextField txtApellido;

	private JPanel contentPane;
	private JTable tblMedico;
	JLabel lblRol = new JLabel("Rol");
	private JTextField txtMatricula;
	private JComboBox<String> boxEspecialidad;
	private JTextField txtFechaObtencion;
	private JTextField txtUniversidad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vMedico frame = new vMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vMedico() {
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
		tableModel.addColumn("Apellido");
		tableModel.addColumn("Matrícula");
		tableModel.addColumn("Especialidad");
		tableModel.addColumn("Fecha Obtención");
		tableModel.addColumn("Universidad");
		
		// Crear la tabla y agregar al contenido
		tblMedico = new JTable(tableModel);
		tblMedico.setBounds(25, 273, 745, 237);
		actualizarTablaMedicos();
		contentPane.add(tblMedico);

		// Crear un JScrollPane para la tabla
		JScrollPane scrollPane = new JScrollPane(tblMedico);
		scrollPane.setBounds(41, 280, 940, 270);
		contentPane.add(scrollPane);

		JLabel lblMedico = new JLabel("Médicos");
		lblMedico.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblMedico.setBounds(432, 6, 150, 33);
		contentPane.add(lblMedico);

		// Campos de ingreso de datos
		// Nombre
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(229, 115, 130, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(131, 115, 68, 22);
		contentPane.add(lblNombre);

		// Apellido
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(499, 115, 130, 22);
		contentPane.add(txtApellido);

		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(376, 115, 81, 22);
		contentPane.add(lblApellido);
		setLocationRelativeTo(null);
		// Matricula
		JLabel lblMatricula = new JLabel("Matricula: ");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatricula.setBounds(655, 115, 81, 22);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setEditable(false);
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(747, 115, 130, 22);
		contentPane.add(txtMatricula);

		// Especialidad
        JLabel lblEspecialidad = new JLabel("Especialidad: ");
        lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEspecialidad.setBounds(131, 150, 101, 22);
        contentPane.add(lblEspecialidad);

        boxEspecialidad = new JComboBox<>();
        boxEspecialidad.setBounds(229, 150, 130, 22);
		contentPane.add(boxEspecialidad);

		// Fecha obtencion de especialidad
		JLabel lblFechaObtencion = new JLabel("Fecha obtencion: ");
		lblFechaObtencion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaObtencion.setBounds(376, 150, 128, 22);
		contentPane.add(lblFechaObtencion);

		txtFechaObtencion = new JTextField();
		txtFechaObtencion.setColumns(10);
		txtFechaObtencion.setBounds(499, 150, 130, 22);
		contentPane.add(txtFechaObtencion);
		
		// Universidad
		JLabel lblUniversidad = new JLabel("Universidad: ");
		lblUniversidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUniversidad.setBounds(655, 150, 94, 22);
		contentPane.add(lblUniversidad);

		txtUniversidad = new JTextField();
		txtUniversidad.setColumns(10);
		txtUniversidad.setBounds(747, 150, 130, 22);
		contentPane.add(txtUniversidad);

		// Botones en pantalla
		// Seleccionar medico
		JButton btnBuscarMedico = new JButton("Seleccionar Médico");
		btnBuscarMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarMedico.setBounds(41, 75, 201, 30);
		contentPane.add(btnBuscarMedico);

		// Manejar la selección de médicos al hacer clic en el botón "Buscar Médico"
		btnBuscarMedico.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        daoMedico dao = new daoMedico();
		        ArrayList<Medico> medicos = dao.buscarMedicosPorMatricula(txtMatricula.getText());
		        DefaultListModel<Medico> medicoListModel = new DefaultListModel<>();
		        for (Medico medico : medicos) {
		            medicoListModel.addElement(medico);
		        }

		        SeleccionarMedico dialog = new SeleccionarMedico(vMedico.this, medicoListModel);
		        dialog.setVisible(true);

		        Medico medicoSeleccionado = dialog.getSelectedMedico();

		        if (medicoSeleccionado != null) {
		        	txtNombre.setText(medicoSeleccionado.getNombre());
		            txtApellido.setText(medicoSeleccionado.getApellido());
		            txtMatricula.setText(medicoSeleccionado.getMatricula());
		        }
		    }
		});

		// Botón para agregar admisión
		JButton btnAgregarMedico = new JButton("Agregar");
        btnAgregarMedico.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAgregarMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String matricula = txtMatricula.getText();
                String especialidad = boxEspecialidad.getSelectedItem().toString();
                String fechaObtencion = txtFechaObtencion.getText();
                String universidad = txtUniversidad.getText();

                if (nombre.isEmpty() || apellido.isEmpty() || matricula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa los campos requeridos.");
                } else {
                    Medico medico = new Medico();
                    medico.setNombre(nombre);
                    medico.setApellido(apellido);
                    medico.setMatricula(matricula);
                    
                    if (!especialidad.isEmpty() && !fechaObtencion.isEmpty() && !universidad.isEmpty()) {
                        DetallesEspecialidad detalles = new DetallesEspecialidad();
                        detalles.setEspecialidad(especialidad);
                        detalles.setFechaObtencion(fechaObtencion);
                        detalles.setUniversidad(universidad);
                        medico.setDetallesEspecialidad(detalles);
                    }
                    
                    daoMedico dao = new daoMedico();
                    if (dao.insertarMedico(medico, medico.getDetallesEspecialidad())) {
                        actualizarTablaMedicos();
                        JOptionPane.showMessageDialog(null, "Médico agregado correctamente.");
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar el médico.");
                    }
                }
            }
        });
		btnAgregarMedico.setBounds(442, 200, 125, 22);
		contentPane.add(btnAgregarMedico);

		// Boton para volver al menú principal
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vMedico.this.setVisible(false);
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
		btnLimpiar.setBounds(619, 200, 163, 22);
		contentPane.add(btnLimpiar);

		// Llamamos a una funcion para cargar las especialidades
		cargarEspecialidades();
	}

	private void actualizarTablaMedicos() {
		DefaultTableModel model = (DefaultTableModel) tblMedico.getModel();
		model.setRowCount(0);

		daoMedico dao = new daoMedico();
		ArrayList<Medico> medicos = dao.consultarMedicos();

		for (Medico medico : medicos) {
			DetallesEspecialidad detalles = medico.getDetallesEspecialidad();

			if (detalles != null) {
				model.addRow(new Object[] { medico.getNombre(), medico.getApellido(), medico.getMatricula(),
						detalles.getEspecialidad(), detalles.getFechaObtencion(), detalles.getUniversidad() });
			} else {
				model.addRow(
						new Object[] { medico.getNombre(), medico.getApellido(), medico.getMatricula(), "", "", "" });
			}
		}
	}
	
	// Funcion para cargar combobox con datos de tabla especialidad
	private void cargarEspecialidades() {
	    daoEspecialidad daoEsp = new daoEspecialidad();
	    ArrayList<Especialidad> especialidades = daoEsp.consultarEspecialidades();
	    
	    for (Especialidad especialidad : especialidades) {
	        boxEspecialidad.addItem(especialidad.getNombreEspecialidad());
	    }
	}


	private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtMatricula.setText("");
        boxEspecialidad.setSelectedIndex(0);
        txtFechaObtencion.setText("");
        txtUniversidad.setText("");
    }

	// Método para transferir el rol del usuario a la ventana
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
