package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Paciente;
import dao.daoPacientes;

import java.util.ArrayList;
import javax.swing.JTextField;

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
    private JLabel lblId;
    
    int fila=-1;
    DefaultTableModel modelo = new DefaultTableModel();
    daoPacientes dao = new daoPacientes();
    ArrayList<Paciente> lista;
    private JTable tlbPacientes;
    Paciente paciente;

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
        setBounds(100, 100, 1035, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPacientes = new JLabel("Pacientes");
        lblPacientes.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
        lblPacientes.setBounds(24, 11, 178, 51);
        contentPane.add(lblPacientes);

        // Campos de ingreso de datos
        // Nombre
        txtnombre = new JTextField();
        txtnombre.setBounds(196, 79, 203, 28);
        contentPane.add(txtnombre);
        txtnombre.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre: ");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNombre.setBounds(24, 85, 81, 17);
        contentPane.add(lblNombre);

        // Apellido
        txtapellido = new JTextField();
        txtapellido.setColumns(10);
        txtapellido.setBounds(196, 118, 203, 28);
        contentPane.add(txtapellido);

        JLabel lblApellido = new JLabel("Apellido: ");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblApellido.setBounds(24, 121, 81, 17);
        contentPane.add(lblApellido);

        // Fecha de nacimiento
        txtfechaNacimiento = new JTextField();
        txtfechaNacimiento.setColumns(10);
        txtfechaNacimiento.setBounds(196, 157, 203, 28);
        contentPane.add(txtfechaNacimiento);

        JLabel lblfechaNacimiento = new JLabel("Fecha de nacimiento: ");
        lblfechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblfechaNacimiento.setBounds(24, 157, 178, 14);
        contentPane.add(lblfechaNacimiento);

        // Domicilio
        txtdomicilio = new JTextField();
        txtdomicilio.setColumns(10);
        txtdomicilio.setBounds(196, 196, 203, 28);
        contentPane.add(txtdomicilio);

        JLabel lblDomicilio = new JLabel("Domicilio: ");
        lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDomicilio.setBounds(24, 203, 134, 14);
        contentPane.add(lblDomicilio);

        // DNI
        txtnroDNI = new JTextField();
        txtnroDNI.setColumns(10);
        txtnroDNI.setBounds(196, 235, 203, 28);
        contentPane.add(txtnroDNI);

        JLabel lblDni = new JLabel("DNI: ");
        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDni.setBounds(24, 241, 71, 17);
        contentPane.add(lblDni);

        // Tel fijo
        txttelFijo = new JTextField();
        txttelFijo.setColumns(10);
        txttelFijo.setBounds(196, 272, 203, 28);
        contentPane.add(txttelFijo);

        JLabel lblTelFijo = new JLabel("Tel Fijo: ");
        lblTelFijo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTelFijo.setBounds(24, 278, 71, 17);
        contentPane.add(lblTelFijo);

        // Tel celular
        txttelCelular = new JTextField();
        txttelCelular.setColumns(10);
        txttelCelular.setBounds(196, 311, 203, 28);
        contentPane.add(txttelCelular);

        JLabel lblTelCelular = new JLabel("Tel Celular: ");
        lblTelCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTelCelular.setBounds(24, 317, 95, 17);
        contentPane.add(lblTelCelular);

        // Estado civil
        txtestadoCivil = new JTextField();
        txtestadoCivil.setColumns(10);
        txtestadoCivil.setBounds(196, 350, 203, 28);
        contentPane.add(txtestadoCivil);

        JLabel lblEstadoCivil = new JLabel("Estado civil: ");
        lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEstadoCivil.setBounds(25, 356, 110, 17);
        contentPane.add(lblEstadoCivil);

        // Email
        txtemail = new JTextField();
        txtemail.setColumns(10);
        txtemail.setBounds(196, 389, 203, 28);
        contentPane.add(txtemail);

        JLabel lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(24, 395, 71, 17);
        contentPane.add(lblEmail);

        // Persona de contacto
        txtpersonaContacto = new JTextField();
        txtpersonaContacto.setColumns(10);
        txtpersonaContacto.setBounds(196, 429, 203, 28);
        contentPane.add(txtpersonaContacto);

        JLabel lblPersonaContacto = new JLabel("Persona Contacto: ");
        lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPersonaContacto.setBounds(25, 435, 150, 17);
        contentPane.add(lblPersonaContacto);
        
     // Campo de filtro de DNI
        JTextField txtFiltroDNI = new JTextField();
        txtFiltroDNI.setColumns(10);
        txtFiltroDNI.setBounds(640, 11, 203, 28);
        contentPane.add(txtFiltroDNI);

        // Botón de búsqueda por DNI
        JButton btnBuscarPorDNI = new JButton("Buscar");
        btnBuscarPorDNI.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBuscarPorDNI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filtroDNI = txtFiltroDNI.getText().trim();
                if (!filtroDNI.isEmpty()) {
                    buscarPorDNI(filtroDNI);
                    
                } else {
                	actualizarTabla();
                }
            }
        });
        btnBuscarPorDNI.setBounds(850, 11, 125, 28);
        contentPane.add(btnBuscarPorDNI);

        
        // Botones en pantalla
        // Boton Modificar
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						String acceso = null;
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
						if(dao.modificarPacientes(paciente)) {
							actualizarTabla();
							limpiarCampos();
							JOptionPane.showMessageDialog(null, "Se modifico correctamente");
						}else {
							JOptionPane.showMessageDialog(null, "Error al modificar paciente");
						}
					}catch (Exception e2) {
			            JOptionPane.showMessageDialog(null, "Error al modificar paciente: " + e2.getMessage());
			        }
			}
		});
        btnModificar.setBounds(25, 479, 125, 28);
        contentPane.add(btnModificar);
        

        // Boton agregar
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente paciente = new Paciente();
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
                    daoPacientes daopacientes = new daoPacientes();
                    if (daopacientes.insertarPacientes(paciente)) {
                        actualizarTabla();
                        JOptionPane.showMessageDialog(null, "Se agregó correctamente");
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar paciente");
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        btnAgregar.setBounds(178, 479, 125, 28);
        contentPane.add(btnAgregar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(426, 46, 583, 469);
        contentPane.add(scrollPane);

        
        tlbPacientes = new JTable();
        
        lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(95, 88, 28, 17);
		lblId.setVisible(false);
		contentPane.add(lblId);
		
		tlbPacientes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int item = 0;
				fila=tlbPacientes.getSelectedRow();
				paciente=lista.get(fila);
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
			}
			
		});
		
        tlbPacientes.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null, null, null},

                },
                new String[] {
                        "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "DNI", "Tel Fijo", "Tel Celular", "Estado civil", "Email", "Persona Contacto"
                }
        ));
        scrollPane.setViewportView(tlbPacientes);
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
        actualizarTabla();
        setLocationRelativeTo(null);
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);

        lista = dao.ConsultaPacientes();

        for (Paciente u : lista) {
            Object pacientes[] = new Object[10];
            pacientes[0] = u.getNombre();
            pacientes[1] = u.getApellido();
            pacientes[2] = u.getFechaNacimiento();
            pacientes[3] = u.getDomicilio();
            pacientes[4] = u.getDNI();
            pacientes[5] = u.getTelFijo();
            pacientes[6] = u.getTelCelular();
            pacientes[7] = u.getEstadoCivil();
            pacientes[8] = u.getEmail();
            pacientes[9] = u.getPersonaContacto();
            modelo.addRow(pacientes);
        }
        tlbPacientes.setModel(modelo);
    }
    
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
		lblId.setText("");
	}
    
    private void buscarPorDNI(String dni) {
        modelo.setRowCount(0);

        ArrayList<Paciente> pacientesFiltrados = dao.buscarPacientesPorDNI(dni);

        if (pacientesFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron pacientes con ese DNI");
            return;
        }

        for (Paciente u : pacientesFiltrados) {
            Object paciente[] = new Object[10];
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
            modelo.addRow(paciente);
        }

        tlbPacientes.setModel(modelo);
    }

}
