package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.HistoriaClinicaPaciente;
import dao.daoHistorial;

import java.util.ArrayList;

public class vHistoriaClinica extends JFrame {

    private JPanel contentPane;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JComboBox<String> cmbLugarAtencion;
    private JTextField txtTextoMedico;
    private JTextField txtHistorialDiagnostico;

    int fila = -1;
    DefaultTableModel modelo = new DefaultTableModel();
    daoHistorial dao = new daoHistorial();
    ArrayList<HistoriaClinicaPaciente> lista = new ArrayList<>(); // Inicializa la lista
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
        lblHistorial.setBounds(100, 13, 280, 33);
        contentPane.add(lblHistorial);

        // Campos de ingreso de datos
        // Fecha
        txtFecha = new JTextField();
        txtFecha.setBounds(200, 80, 170, 22);
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha: ");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFecha.setBounds(25, 83, 81, 22);
        contentPane.add(lblFecha);

        // Hora
        txtHora = new JTextField();
        txtHora.setColumns(10);
        txtHora.setBounds(200, 132, 170, 22);
        contentPane.add(txtHora);

        JLabel lblHora = new JLabel("Hora: ");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHora.setBounds(25, 129, 73, 22);
        contentPane.add(lblHora);

        // Lugar de Atención (usando JComboBox)
        String[] lugaresAtencion = {"CONSULTORIO", "EMERGENCIA", "INTERNACIONES"};
        cmbLugarAtencion = new JComboBox<>(lugaresAtencion);
        cmbLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cmbLugarAtencion.setBounds(200, 180, 170, 22);
        contentPane.add(cmbLugarAtencion);

        JLabel lblLugarAtencion = new JLabel("Lugar de Atención: ");
        lblLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLugarAtencion.setBounds(25, 179, 176, 22);
        contentPane.add(lblLugarAtencion);

        // Texto Médico
        txtTextoMedico = new JTextField();
        txtTextoMedico.setColumns(10);
        txtTextoMedico.setBounds(200, 230, 170, 22);
        contentPane.add(txtTextoMedico);

        JLabel lblTextoMedico = new JLabel("Texto Médico: ");
        lblTextoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTextoMedico.setBounds(25, 230, 185, 22);
        contentPane.add(lblTextoMedico);

        // Historial de Diagnóstico
        txtHistorialDiagnostico = new JTextField();
        txtHistorialDiagnostico.setColumns(10);
        txtHistorialDiagnostico.setBounds(200, 282, 170, 22);
        contentPane.add(txtHistorialDiagnostico);

        JLabel lblHistorialDiagnostico = new JLabel("Historial Diagnóstico: ");
        lblHistorialDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHistorialDiagnostico.setBounds(25, 282, 181, 22);
        contentPane.add(lblHistorialDiagnostico);

        // Botones en pantalla
        // Botón Modificar
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
                            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar el historial");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al modificar el historial: " );
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un historial para modificar.");
                }
            }
        });
        btnModificar.setBounds(200, 461, 125, 33);
        contentPane.add(btnModificar);

        // Botón Agregar
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
                        JOptionPane.showMessageDialog(null, "Se agregó correctamente");
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
        btnAgregar.setBounds(50, 461, 125, 33);
        contentPane.add(btnAgregar);
        
        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para volver al menú principal
                menuPrincipal menu = new menuPrincipal();
                menu.setVisible(true);
                vHistoriaClinica.this.dispose(); // Cierra la ventana actual
            }
        });
        btnVolver.setBounds(900, 13, 89, 23);
        contentPane.add(btnVolver);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(380, 46, 629, 469);
        contentPane.add(scrollPane);

        tlbHistorial = new JTable(modelo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tlbHistorial.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null},
            },
            new String[] {
                "Fecha", "Hora", "Lugar de Atención", "Texto Médico", "Historial Diagnóstico",
            }
        ));
        scrollPane.setViewportView(tlbHistorial);

        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Lugar de Atención");
        modelo.addColumn("Texto Médico");
        modelo.addColumn("Historial Diagnóstico");
        actualizarTabla();
        setLocationRelativeTo(null);

        tlbHistorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fila = tlbHistorial.getSelectedRow();
                if (fila >= 0) {
                    // El usuario ha seleccionado una fila
                } else {
                    // No se ha seleccionado ninguna fila
                }
            }
        });

        tlbHistorial.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tlbHistorial.getSelectedRow();
                    if (selectedRow >= 0) {
                        HistoriaClinicaPaciente historial = lista.get(selectedRow);
                        txtFecha.setText(historial.getFecha());
                        txtHora.setText(historial.getHora());
                        cmbLugarAtencion.setSelectedItem(historial.getLugarDeAtencion());
                        txtTextoMedico.setText(historial.getTextoMedico());
                        txtHistorialDiagnostico.setText(historial.getHistorialDiagnostico());
                    }
                }
            }
        });
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);
        try {
            lista = dao.consultarHistorial();
            if (lista == null) {
                lista = new ArrayList<>();
            }

            for (HistoriaClinicaPaciente u : lista) {
                Object historialData[] = new Object[5];
                historialData[0] = u.getFecha();
                historialData[1] = u.getHora();
                historialData[2] = u.getLugarDeAtencion();
                historialData[3] = u.getTextoMedico();
                historialData[4] = u.getHistorialDiagnostico();
                modelo.addRow(historialData);
            }
            tlbHistorial.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar el historial: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtFecha.setText("");
        txtHora.setText("");
        cmbLugarAtencion.setSelectedIndex(0);
        txtTextoMedico.setText("");
        txtHistorialDiagnostico.setText("");
    }
}
