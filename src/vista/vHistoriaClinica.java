package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.HistoriaClinicaPaciente;
import dao.daoHistorial;

import java.util.ArrayList;
import java.util.Date;

public class vHistoriaClinica extends JFrame {

    private JPanel contentPane;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JComboBox<String> cmbLugarAtencion;
    private JEditorPane txtTextoMedico;
    private JTextField txtHistorialDiagnostico;
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
        lblHistorial.setBounds(100, 13, 280, 33);
        contentPane.add(lblHistorial);

        // Campos de ingreso de datos
        // Fecha
        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtFecha.setBounds(116, 83, 170, 22);
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha: ");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFecha.setBounds(45, 83, 81, 22);
        contentPane.add(lblFecha);

        // Hora
        txtHora = new JTextField();
        txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtHora.setColumns(10);
        txtHora.setBounds(411, 83, 170, 22);
        contentPane.add(txtHora);

        JLabel lblHora = new JLabel("Hora: ");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHora.setBounds(346, 83, 81, 22);
        contentPane.add(lblHora);

        // Lugar de Atenci�n (usando JComboBox)
        String[] lugaresAtencion = {"CONSULTORIO", "EMERGENCIA", "INTERNACIONES"};
        cmbLugarAtencion = new JComboBox<>(lugaresAtencion);
        cmbLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cmbLugarAtencion.setBounds(808, 83, 170, 22);
        contentPane.add(cmbLugarAtencion);

        JLabel lblLugarAtencion = new JLabel("Lugar de Atenci�n: ");
        lblLugarAtencion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLugarAtencion.setBounds(639, 83, 170, 22);
        contentPane.add(lblLugarAtencion);

        // Texto M�dico (JEditorPane)
        txtTextoMedico = new JEditorPane();
        txtTextoMedico.setBounds(296, 134, 170, 74);
        contentPane.add(txtTextoMedico);

        JLabel lblTextoMedico = new JLabel("Texto M�dico: ");
        lblTextoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTextoMedico.setBounds(160, 134, 190, 22);
        contentPane.add(lblTextoMedico);

        // Historial de Diagn�stico
        txtHistorialDiagnostico = new JTextField();
        txtHistorialDiagnostico.setColumns(10);
        txtHistorialDiagnostico.setBounds(705, 134, 170, 22);
        contentPane.add(txtHistorialDiagnostico);

        JLabel lblHistorialDiagnostico = new JLabel("Historial Diagn�stico: ");
        lblHistorialDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHistorialDiagnostico.setBounds(520, 134, 185, 22);
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
                        JOptionPane.showMessageDialog(null, "Error al modificar el historial: " );
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un historial para modificar.");
                }
            }
        });
        btnModificar.setBounds(450, 225, 140, 33);
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
        btnAgregar.setBounds(210, 225, 140, 33);
        contentPane.add(btnAgregar);
        
     // Boton para volver limpiar campos de entrada
     		JButton btnLimpiar = new JButton("Limpiar");
     		btnLimpiar.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				limpiarCampos();
     			}
     		});
     		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
     		btnLimpiar.setBounds(690, 225, 140, 33);
     		contentPane.add(btnLimpiar);
     		
        // Bot�n Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // C�digo para volver al men� principal
                menuPrincipal menu = new menuPrincipal();
                menu.transferirDatos(lblRol.getText());
                menu.setVisible(true);
                vHistoriaClinica.this.dispose(); // Cierra la ventana actual
            }
        });
        btnVolver.setBounds(10, 11, 85, 36);
        contentPane.add(btnVolver);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(83, 276, 853, 239);
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
                "Fecha", "Hora", "Lugar de Atenci�n", "Texto M�dico", "Historial Diagn�stico",
            }
        ));
        scrollPane.setViewportView(tlbHistorial);
        
        JLabel lblCaptionRol = new JLabel("Rol:");
        lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
        lblCaptionRol.setBounds(928, 13, 25, 18);
        contentPane.add(lblCaptionRol);

        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Lugar de Atenci�n");
        modelo.addColumn("Texto M�dico");
        modelo.addColumn("Historial Diagn�stico");
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
        
        colocarHoraActual();
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
    
    public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
    
    private void colocarHoraActual() {
		Date todayDate = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String fechaActual = fecha.format(todayDate);
        String horaActual = hora.format(todayDate);
        txtFecha.setText(fechaActual);
        txtHora.setText(horaActual);
	}
}