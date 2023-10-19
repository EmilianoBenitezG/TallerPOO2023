package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import dao.daoPacientes;
import dao.daoAdmision;
import modelo.Paciente;
import modelo.Admision;

public class vAdmision extends JFrame {

    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtMotivoConsulta;
    private JPanel contentPane;
    private JTable tblAdmision;
    private JTextField txtNombreApellido;
    private JTextField txtDNI;
    private Paciente pacienteSeleccionado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    vAdmision frame = new vAdmision();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public vAdmision() {
    	setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(493, 41, 527, 445);
        contentPane.add(panel);

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("Nombre");
        tableModel.addColumn("DNI");
        tableModel.addColumn("Motivo Consulta");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Hora");
        tblAdmision = new JTable(tableModel);
        tblAdmision.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        actualizarTablaAdmisiones();
        
        JScrollPane scrollPane = new JScrollPane(tblAdmision);
        scrollPane.setBounds(10, 10, 855, 305);
        panel.add(scrollPane);

        JLabel lblAdmision = new JLabel("Admision");
        lblAdmision.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
        lblAdmision.setBounds(122, 13, 178, 33);
        contentPane.add(lblAdmision);

        JButton btnAtras = new JButton("Volver");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPrincipal menuPrincipal = new menuPrincipal();
                menuPrincipal.setVisible(true);
                vAdmision.this.setVisible(false);
            }
        });

        JButton btnAgregarAdmision = new JButton("Agregar");
        btnAgregarAdmision.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAgregarAdmision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para agregar una admisión
                String nombreApellido = txtNombreApellido.getText();
                String dni = txtDNI.getText();
                String motivoConsulta = txtMotivoConsulta.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();

                if (pacienteSeleccionado != null) {
                    Admision admision = new Admision();
                    admision.setPaciente(pacienteSeleccionado);
                    admision.setMotivoConsulta(motivoConsulta);
                    admision.setFecha(fecha);
                    admision.setHora(hora);

                    daoAdmision dao = new daoAdmision();
                    if (dao.insertarAdmision(admision)) {
                        actualizarTablaAdmisiones();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar la admisión");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un paciente antes de agregar la admisión");
                }
            }
        });
        btnAgregarAdmision.setBounds(41, 472, 178, 36);
        contentPane.add(btnAgregarAdmision);

        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAtras.setBounds(10, 11, 85, 36);
        contentPane.add(btnAtras);

        txtFecha = new JTextField();
        txtFecha.setBounds(102, 215, 102, 22);
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblHora = new JLabel("Hora: ");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHora.setBounds(41, 245, 45, 22);
        contentPane.add(lblHora);

        txtHora = new JTextField();
        txtHora.setColumns(10);
        txtHora.setBounds(96, 245, 121, 22);
        contentPane.add(txtHora);

        JLabel lblFecha = new JLabel("Fecha: ");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFecha.setBounds(41, 215, 56, 22);
        contentPane.add(lblFecha);

        JLabel lblNombreApellido = new JLabel("Nombre y apellido:");
        lblNombreApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNombreApellido.setBounds(41, 155, 152, 22);
        contentPane.add(lblNombreApellido);

        txtMotivoConsulta = new JTextField();
        txtMotivoConsulta.setBounds(41, 299, 286, 61);
        contentPane.add(txtMotivoConsulta);

        JButton btnBuscarPaciente = new JButton("Buscar Paciente");
        btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBuscarPaciente.setBounds(41, 105, 232, 30);
        contentPane.add(btnBuscarPaciente);

        JLabel lblMotivoConsulta = new JLabel("Motivo consulta:");
        lblMotivoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMotivoConsulta.setBounds(41, 275, 139, 14);
        contentPane.add(lblMotivoConsulta);

        txtNombreApellido = new JTextField();
        txtNombreApellido.setBounds(179, 155, 170, 22);
        contentPane.add(txtNombreApellido);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDni.setBounds(41, 185, 40, 22);
        contentPane.add(lblDni);

        txtDNI = new JTextField();
        txtDNI.setBounds(83, 185, 97, 22);
        contentPane.add(txtDNI);

        btnBuscarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoPacientes dao = new daoPacientes();
                ArrayList<Paciente> pacientes = dao.buscarPacientesPorDNI(txtDNI.getText());
                DefaultListModel<Paciente> pacienteListModel = new DefaultListModel<>();
                for (Paciente paciente : pacientes) {
                    pacienteListModel.addElement(paciente);
                }

                SeleccionarPaciente dialog = new SeleccionarPaciente(vAdmision.this, pacienteListModel);
                dialog.setVisible(true);

                pacienteSeleccionado = dialog.getSelectedPaciente();

                if (pacienteSeleccionado != null) {
                    txtDNI.setText(pacienteSeleccionado.getDNI());
                    txtNombreApellido.setText(pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido());
                }
            }
        });
    }
    
    private void actualizarTablaAdmisiones() {
        DefaultTableModel model = (DefaultTableModel) tblAdmision.getModel();
        model.setRowCount(0);
        daoAdmision dao = new daoAdmision();
        ArrayList<Admision> admisiones = dao.consultarAdmisiones();
        for (Admision admision : admisiones) {
            model.addRow(new Object[]{
                    admision.getPaciente().getNombreApellido(),
                    admision.getPaciente().getDNI(),
                    admision.getMotivoConsulta(),
                    admision.getFecha(),
                    admision.getHora()
            });
        }
    }
}
