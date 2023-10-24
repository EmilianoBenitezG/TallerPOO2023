package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
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

import dao.daoFuncionario;
import modelo.Funcionario;
import modelo.Paciente;

public class vFuncionarios extends JFrame {

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
	private JTextField txtpuesto;
	private String filtroActual = "";
	private JTable tlbFuncionarios;
	private JLabel lblId;

	int filaSeleccionada = -1;

	JLabel lblRol = new JLabel("Rol");

	Funcionario funcionario;

	ArrayList<Funcionario> lista;
	daoFuncionario dao = new daoFuncionario();

	DefaultTableModel modelo=new DefaultTableModel(){@Override public boolean isCellEditable(int row,int column){return false;}};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vFuncionarios frame = new vFuncionarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vFuncionarios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setFont(new Font("Dialog", Font.PLAIN, 35));
		lblFuncionarios.setBounds(122, 13, 203, 33);
		contentPane.add(lblFuncionarios);

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
		txtemail.setBounds(853, 96, 140, 22);
		contentPane.add(txtemail);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(802, 96, 54, 22);
		contentPane.add(lblEmail);

		// Puesto de trabajo
		txtpuesto = new JTextField();
		txtpuesto.setColumns(10);
		txtpuesto.setBounds(85, 129, 170, 22);
		contentPane.add(txtpuesto);

		JLabel lblPuesto = new JLabel("Puesto: ");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuesto.setBounds(20, 129, 140, 22);
		contentPane.add(lblPuesto);

		// Campo de filtro de DNI
		JTextField txtFiltroDNI = new JTextField();
		txtFiltroDNI.setColumns(10);
		txtFiltroDNI.setBounds(420, 247, 203, 22);
		contentPane.add(txtFiltroDNI);

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

		// Botones en pantalla
		// Boton para volver al menú principal
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.transferirDatos(lblRol.getText());
				menuPrincipal.setVisible(true);
				vFuncionarios.this.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 13, 85, 36);
		contentPane.add(btnAtras);

		// Boton agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dni = txtnroDNI.getText().trim();
					if (!dao.existeFuncionarioConDNI(dni)) {
						Funcionario funcionario = new Funcionario();
						funcionario.setNombre(txtnombre.getText());
						funcionario.setApellido(txtapellido.getText());
						funcionario.setFechaNacimiento(txtfechaNacimiento.getText());
						funcionario.setDomicilio(txtdomicilio.getText());
						funcionario.setDNI(dni);
						funcionario.setTelFijo(txttelFijo.getText());
						funcionario.setTelCelular(txttelCelular.getText());
						funcionario.setEstadoCivil(txtestadoCivil.getText());
						funcionario.setEmail(txtemail.getText());
						funcionario.setPuesto(txtpuesto.getText());

						if (dao.insertarFuncionario(funcionario)) {
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

		// Boton Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (filaSeleccionada != -1) {
						funcionario = lista.get(filaSeleccionada);
						int idFuncionario = funcionario.getId();
						funcionario.setNombre(txtnombre.getText());
						funcionario.setApellido(txtapellido.getText());
						funcionario.setFechaNacimiento(txtfechaNacimiento.getText());
						funcionario.setDomicilio(txtdomicilio.getText());
						funcionario.setDNI(txtnroDNI.getText());
						funcionario.setTelFijo(txttelFijo.getText());
						funcionario.setTelCelular(txttelCelular.getText());
						funcionario.setEstadoCivil(txtestadoCivil.getText());
						funcionario.setEmail(txtemail.getText());
						funcionario.setPuesto(txtpuesto.getText());

						if (dao.modificarFuncionario(funcionario)) {
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
		tlbFuncionarios = new JTable();

		// Crear modelo de datos para la tabla
		tlbFuncionarios.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null },

				}, new String[] { "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "DNI", "Tel Fijo",
						"Tel Celular", "Estado civil", "Email", "Puesto" }));
		scrollPane.setViewportView(tlbFuncionarios);

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
		modelo.addColumn("Puesto");
		actualizarTabla();
		setLocationRelativeTo(null);
	}

	// Actualizar la tabla de funcionarios
	public void actualizarTabla() {
		modelo.setRowCount(0);

		if (filtroActual.isEmpty()) {
			lista = dao.consultarFuncionarios();
		} else {
			buscarPorDNI(filtroActual);
		}
		modelo.setRowCount(0);

		// Llenar la tabla con los datos de los funcionarios
		for (Funcionario funcionario : lista) {
			Object[] rowData = { funcionario.getNombre(), funcionario.getApellido(), funcionario.getFechaNacimiento(),
					funcionario.getDomicilio(), funcionario.getDNI(), funcionario.getTelFijo(),
					funcionario.getTelCelular(), funcionario.getEstadoCivil(), funcionario.getEmail(),
					funcionario.getPuesto() };
			modelo.addRow(rowData);
		}
		tlbFuncionarios.setModel(modelo);
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
		txtpuesto.setText("");
	}

	// Buscar pacientes por DNI
	private void buscarPorDNI(String dni) {
		modelo.setRowCount(0);

		lista = dao.buscarFuncionarioPorDNI(dni);

		if (lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encontraron funcionarios con ese DNI");
		} else {
			for (Funcionario u : lista) {
				Object funcionario[] = new Object[10];
				funcionario[0] = u.getNombre();
				funcionario[1] = u.getApellido();
				funcionario[2] = u.getFechaNacimiento();
				funcionario[3] = u.getDomicilio();
				funcionario[4] = u.getDNI();
				funcionario[5] = u.getTelFijo();
				funcionario[6] = u.getTelCelular();
				funcionario[7] = u.getEstadoCivil();
				funcionario[8] = u.getEmail();
				funcionario[9] = u.getPuesto();
				modelo.addRow(funcionario);
			}
			tlbFuncionarios.setRowSelectionInterval(0, 0);
		}
		tlbFuncionarios.setModel(modelo);

		// Crear una etiqueta "ID"
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(25, 26, 28, 22);
		lblId.setVisible(false);
		contentPane.add(lblId);

		// Manejar selección en tabla de funcionarios
		tlbFuncionarios.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int item = 0;
			filaSeleccionada = tlbFuncionarios.getSelectedRow();
			funcionario = lista.get(filaSeleccionada);
			lblId.setText(String.valueOf(funcionario.getId()));
			txtnombre.setText(funcionario.getNombre());
			txtapellido.setText(funcionario.getApellido());
			txtfechaNacimiento.setText(funcionario.getFechaNacimiento());
			txtdomicilio.setText(funcionario.getDomicilio());
			txtnroDNI.setText(funcionario.getDNI());
			txttelFijo.setText(funcionario.getTelFijo());
			txttelCelular.setText(funcionario.getTelCelular());
			txtestadoCivil.setText(funcionario.getEstadoCivil());
			txtemail.setText(funcionario.getEmail());
			txtpuesto.setText(funcionario.getPuesto());
		}
	});}
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
