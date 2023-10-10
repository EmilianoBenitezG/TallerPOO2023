package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
    private JCheckBox chkEstado;
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
        lblPacientes.setBounds(100, 13, 178, 33);
        contentPane.add(lblPacientes);

        // Campos de ingreso de datos
        // Nombre
        txtnombre = new JTextField();
        txtnombre.setBounds(200, 80, 170, 22);
        contentPane.add(txtnombre);
        txtnombre.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre: ");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNombre.setBounds(25, 83, 81, 22);
        contentPane.add(lblNombre);

        // Apellido
        txtapellido = new JTextField();
        txtapellido.setColumns(10);
        txtapellido.setBounds(200, 113, 170, 22);
        contentPane.add(txtapellido);

        JLabel lblApellido = new JLabel("Apellido: ");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblApellido.setBounds(25, 116, 81, 22);
        contentPane.add(lblApellido);

        // Fecha de nacimiento
        txtfechaNacimiento = new JTextField();
        txtfechaNacimiento.setColumns(10);
        txtfechaNacimiento.setBounds(200, 146, 170, 22);
        contentPane.add(txtfechaNacimiento);

        JLabel lblfechaNacimiento = new JLabel("Fecha de nacimiento: ");
        lblfechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblfechaNacimiento.setBounds(25, 149, 178, 22);
        contentPane.add(lblfechaNacimiento);

        // Domicilio
        txtdomicilio = new JTextField();
        txtdomicilio.setColumns(10);
        txtdomicilio.setBounds(200, 179, 170, 22);
        contentPane.add(txtdomicilio);

        JLabel lblDomicilio = new JLabel("Domicilio: ");
        lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDomicilio.setBounds(25, 182, 134, 22);
        contentPane.add(lblDomicilio);

        // DNI
        txtnroDNI = new JTextField();
        txtnroDNI.setColumns(10);
        txtnroDNI.setBounds(200, 212, 170, 22);
        contentPane.add(txtnroDNI);

        JLabel lblDni = new JLabel("DNI: ");
        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDni.setBounds(25, 214, 71, 22);
        contentPane.add(lblDni);

        // Tel fijo
        txttelFijo = new JTextField();
        txttelFijo.setColumns(10);
        txttelFijo.setBounds(200, 245, 170, 22);
        contentPane.add(txttelFijo);

        JLabel lblTelFijo = new JLabel("Tel Fijo: ");
        lblTelFijo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTelFijo.setBounds(25, 247, 71, 22);
        contentPane.add(lblTelFijo);

        // Tel celular
        txttelCelular = new JTextField();
        txttelCelular.setColumns(10);
        txttelCelular.setBounds(200, 278, 170, 22);
        contentPane.add(txttelCelular);

        JLabel lblTelCelular = new JLabel("Tel Celular: ");
        lblTelCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTelCelular.setBounds(25, 280, 95, 22);
        contentPane.add(lblTelCelular);

        // Estado civil
        txtestadoCivil = new JTextField();
        txtestadoCivil.setColumns(10);
        txtestadoCivil.setBounds(200, 311, 170, 22);
        contentPane.add(txtestadoCivil);

        JLabel lblEstadoCivil = new JLabel("Estado civil: ");
        lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEstadoCivil.setBounds(25, 313, 110, 22);
        contentPane.add(lblEstadoCivil);

        // Email
        txtemail = new JTextField();
        txtemail.setColumns(10);
        txtemail.setBounds(200, 346, 170, 22);
        contentPane.add(txtemail);

        JLabel lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(25, 346, 71, 22);
        contentPane.add(lblEmail);

        // Persona de contacto
        txtpersonaContacto = new JTextField();
        txtpersonaContacto.setColumns(10);
        txtpersonaContacto.setBounds(200, 379, 170, 22);
        contentPane.add(txtpersonaContacto);

        JLabel lblPersonaContacto = new JLabel("Persona Contacto: ");
        lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPersonaContacto.setBounds(25, 379, 150, 22);
        contentPane.add(lblPersonaContacto);
        
     // Campo de filtro de DNI
        JTextField txtFiltroDNI = new JTextField();
        txtFiltroDNI.setColumns(10);
        txtFiltroDNI.setBounds(521, 13, 203, 22);
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
        btnBuscarPorDNI.setBounds(734, 13, 125, 22);
        contentPane.add(btnBuscarPorDNI);
        
        // Checkbox para el estado "vivo/muerto"
        chkEstado = new JCheckBox("¿Está vivo?");
        chkEstado.setFont(new Font("Tahoma", Font.BOLD, 15));
        chkEstado.setBounds(134, 437, 125, 22);
        contentPane.add(chkEstado);
        
        // Botones en pantalla
        // Boton Modificar
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
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
                    
                    boolean estaVivo = chkEstado.isSelected();
                    paciente.setEstado(estaVivo);
                    
                    if (dao.modificarPacientes(paciente)) {
                        actualizarTabla();
                        limpiarCampos();
                        JOptionPane.showMessageDialog(null, "Se modificó correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar paciente");
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Error al modificar paciente: " + e2.getMessage());
                }
            }
        });
        btnModificar.setBounds(50, 479, 125, 22);
        contentPane.add(btnModificar);
        

        // Boton agregar
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String dni = txtnroDNI.getText().trim();
                    // Verificar si el DNI ya existe en la base de datos
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
                        boolean estaVivo = chkEstado.isSelected();
                        paciente.setEstado(estaVivo);
                        
                        if (dao.insertarPacientes(paciente)) {
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
        btnAgregar.setBounds(196, 479, 125, 22);
        contentPane.add(btnAgregar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(380, 46, 629, 469);
        contentPane.add(scrollPane);

        
        tlbPacientes = new JTable();
        
        lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(25, 50, 28, 22);
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
                        "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "DNI", "Tel Fijo", "Tel Celular", "Estado civil", "Email", "Persona Contacto", "Estado"
                }
        ));
        scrollPane.setViewportView(tlbPacientes);
        
        JLabel lblBuscarPorDni = new JLabel("Buscar por DNI:");
        lblBuscarPorDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBuscarPorDni.setBounds(380, 13, 150, 22);
        contentPane.add(lblBuscarPorDni);
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

    public void actualizarTabla() {
        modelo.setRowCount(0);

        lista = dao.ConsultaPacientes();

        for (Paciente u : lista) {
            Object pacientes[] = new Object[11];
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
            pacientes[10] = u.isEstado() ? "Vivo" : "Fallecido";
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
        chkEstado.setSelected(false);
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
