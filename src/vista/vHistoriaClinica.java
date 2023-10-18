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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.HistoriaClinicaPaciente;
import dao.daoHistorial;

import java.util.ArrayList;

public class vHistoriaClinica extends JFrame {

    private JPanel contentPane;
    private JTextField txtFecha;
    private JTextField txtHistorialDiagnostico;
    private JTextField txtLugarAtencion;
    private JTextField txtUltimoDiagnostico;
    private JTextField txtResultadosEstudios;
    private JTextField txtHora;

    int fila = -1;
    DefaultTableModel modelo = new DefaultTableModel();
    daoHistorial dao = new daoHistorial();
    ArrayList<HistoriaClinicaPaciente> lista;
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

        // Historial de Diagnóstico
        txtHistorialDiagnostico = new JTextField();
        txtHistorialDiagnostico.setColumns(10);
        txtHistorialDiagnostico.setBounds(200, 129, 170, 22);
        contentPane.add(txtHistorialDiagnostico);

        JLabel lblHistorialDiagnostico = new JLabel("Historial Diagnóstico: ");
        lblHistorialDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHistorialDiagnostico.setBounds(25, 126, 181, 22);
        contentPane.add(lblHistorialDiagnostico);

        // Lugar de Atención
        txtLugarAtencion = new JTextField();
        txtLugarAtencion.setColumns(10);
        txtLugarAtencion.setBounds(200, 178, 170, 22);
        contentPane.add(txtLugarAtencion);

        JLabel lblLugarAtencion = new JLabel("Lugar de Atención: ");
        lblLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLugarAtencion.setBounds(25, 175, 176, 22);
        contentPane.add(lblLugarAtencion);

        // Último Diagnóstico
        txtUltimoDiagnostico = new JTextField();
        txtUltimoDiagnostico.setColumns(10);
        txtUltimoDiagnostico.setBounds(200, 229, 170, 22);
        contentPane.add(txtUltimoDiagnostico);

        JLabel lblUltimoDiagnostico = new JLabel("Último Diagnóstico: ");
        lblUltimoDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUltimoDiagnostico.setBounds(25, 226, 185, 22);
        contentPane.add(lblUltimoDiagnostico);

        // Resultados de Estudios
        txtResultadosEstudios = new JTextField();
        txtResultadosEstudios.setColumns(10);
        txtResultadosEstudios.setBounds(200, 279, 170, 22);
        contentPane.add(txtResultadosEstudios);

        JLabel lblResultadosEstudios = new JLabel("Resultado Estudios: ");
        lblResultadosEstudios.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblResultadosEstudios.setBounds(25, 276, 214, 22);
        contentPane.add(lblResultadosEstudios);

        // Hora
        txtHora = new JTextField();
        txtHora.setColumns(10);
        txtHora.setBounds(200, 327, 170, 22);
        contentPane.add(txtHora);

        JLabel lblHora = new JLabel("Hora: ");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHora.setBounds(25, 324, 73, 22);
        contentPane.add(lblHora);

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
                        historial.setHistorialDiagnostico(txtHistorialDiagnostico.getText());
                        String lugarAtencionText = txtLugarAtencion.getText();
                        HistoriaClinicaPaciente.LugarDeAtencion lugarAtencion = HistoriaClinicaPaciente.LugarDeAtencion.valueOf(lugarAtencionText);
                        historial.setLugarDeAtencion(lugarAtencion);
                        historial.setUltimoDiagnostico(txtUltimoDiagnostico.getText());
                        historial.setResEstudios(txtResultadosEstudios.getText());
                        historial.setHora(txtHora.getText());

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
        btnModificar.setBounds(50, 479, 125, 22);
        contentPane.add(btnModificar);

        // Botón agregar
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    HistoriaClinicaPaciente historial = new HistoriaClinicaPaciente();
                    historial.setFecha(txtFecha.getText());
                    historial.setHistorialDiagnostico(txtHistorialDiagnostico.getText());
                    historial.setLugarDeAtencion(HistoriaClinicaPaciente.LugarDeAtencion.valueOf(txtLugarAtencion.getText()));
                    historial.setUltimoDiagnostico(txtUltimoDiagnostico.getText());
                    historial.setResEstudios(txtResultadosEstudios.getText());
                    historial.setHora(txtHora.getText());

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
        btnAgregar.setBounds(196, 479, 125, 22);
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

        tlbHistorial = new JTable();
        tlbHistorial.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Fecha", "Historial Diagnóstico", "Lugar de Atención", "Último Diagnóstico", "Resultado Estudios", "Hora",
                }
        ));
        scrollPane.setViewportView(tlbHistorial);

        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Historial Diagnóstico");
        modelo.addColumn("Lugar de Atención");
        modelo.addColumn("Último Diagnóstico");
        modelo.addColumn("Resultado Estudios");
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
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);

        try {
            lista = dao.ConsultaHistorial();

            for (HistoriaClinicaPaciente u : lista) {
                Object historialData[] = new Object[7];
                historialData[0] = u.getFecha();
                historialData[1] = u.getHora();
                historialData[2] = u.getUltimoDiagnostico();
                historialData[3] = u.getLugarDeAtencion().name();
                historialData[4] = u.getHistorialDiagnostico();
                historialData[5] = u.getResEstudios();
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
        txtHistorialDiagnostico.setText("");
        txtLugarAtencion.setText("");
        txtUltimoDiagnostico.setText("");
        txtResultadosEstudios.setText("");
        txtHora.setText("");
    }
}