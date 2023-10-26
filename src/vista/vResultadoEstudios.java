package vista;

import vista.menuPrincipal;
import modelo.ResultEstudios;
import dao.daoResEstudios;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class vResultadoEstudios extends JFrame {

    private JPanel contentPane;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtTipoEstudio;
    private JEditorPane txtInformeEstudios;
    JLabel lblRol = new JLabel("Rol");

    int fila = -1;
    DefaultTableModel modelo = new DefaultTableModel();
    daoResEstudios dao = new daoResEstudios();
    ArrayList<ResultEstudios> lista = new ArrayList<>();
    ResultEstudios resultado;

    private JTable tlbResultadoEstudios;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    vResultadoEstudios frame = new vResultadoEstudios();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public vResultadoEstudios() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1035, 565);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblResultadoEstudios = new JLabel("Resultado Estudios");
        lblResultadoEstudios.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
        lblResultadoEstudios.setBounds(100, 13, 481, 33);
        contentPane.add(lblResultadoEstudios);

        // Campos de ingreso de datos
        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtFecha.setBounds(116, 83, 170, 22);
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFecha.setBounds(45, 83, 81, 22);
        contentPane.add(lblFecha);

        txtHora = new JTextField();
        txtHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtHora.setColumns(10);
        txtHora.setBounds(411, 83, 170, 22);
        contentPane.add(txtHora);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHora.setBounds(346, 83, 81, 22);
        contentPane.add(lblHora);

        txtTipoEstudio = new JTextField();
        txtTipoEstudio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTipoEstudio.setBounds(808, 83, 170, 22);
        contentPane.add(txtTipoEstudio);

        JLabel lblTipoEstudio = new JLabel("Tipo de Estudio:");
        lblTipoEstudio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTipoEstudio.setBounds(639, 83, 170, 22);
        contentPane.add(lblTipoEstudio);

        txtInformeEstudios = new JEditorPane();
        txtInformeEstudios.setBounds(529, 134, 170, 74);
        contentPane.add(txtInformeEstudios);

        JLabel lblInformeEstudios = new JLabel("Informe de Estudios:");
        lblInformeEstudios.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblInformeEstudios.setBounds(315, 134, 190, 22);
        contentPane.add(lblInformeEstudios);

        lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
        lblRol.setBounds(955, 13, 98, 18);
        contentPane.add(lblRol);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fila != -1) {
                    try {
                        resultado = lista.get(fila);
                        resultado.setFecha(txtFecha.getText());
                        resultado.setHora(txtHora.getText());
                        resultado.setTipoEstudio(txtTipoEstudio.getText());
                        resultado.setInformeEstudios(txtInformeEstudios.getText());

                        if (dao.modificarResultado(resultado)) {
                            actualizarTabla();
                            limpiarCampos();
                            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar el resultado de estudios");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al modificar el resultado de estudios: " + e2.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un resultado de estudios para modificar.");
                }
            }
        });

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultado = new ResultEstudios();
                    resultado.setFecha(txtFecha.getText());
                    resultado.setHora(txtHora.getText());
                    resultado.setTipoEstudio(txtTipoEstudio.getText());
                    resultado.setInformeEstudios(txtInformeEstudios.getText());

                    if (dao.insertarResultado(resultado)) {
                        actualizarTabla();
                        JOptionPane.showMessageDialog(null, "Se agregó correctamente");
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar el resultado de estudios");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
                }
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPrincipal menu = new menuPrincipal();
                menu.transferirDatos(lblRol.getText());
                menu.setVisible(true);
                vResultadoEstudios.this.dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(83, 276, 853, 239);
        contentPane.add(scrollPane);

        tlbResultadoEstudios = new JTable(modelo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Component tlbResEstudios;
        tlbResultadoEstudios.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                },
                new String[] {
                    "Fecha", "Hora", "Tipo Estudio", "Informe Estudios",
                }
            ));
            scrollPane.setViewportView(tlbResultadoEstudios);
            
            JLabel lblCaptionRol = new JLabel("Rol:");
            lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
            lblCaptionRol.setBounds(928, 13, 25, 18);
            contentPane.add(lblCaptionRol);

            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Tipo de Estudio");
            modelo.addColumn("Informe de Estudios");
            actualizarTabla();
            setLocationRelativeTo(null);

            tlbResultadoEstudios.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    fila = ((JTable) tlbResultadoEstudios).getSelectedRow();
                    if (fila >= 0) {
                        // El usuario ha seleccionado una fila
                    } else {
                        // No se ha seleccionado ninguna fila
                    }
                }
            });

        tlbResultadoEstudios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tlbResultadoEstudios.getSelectedRow();
                    if (selectedRow >= 0) {
                        ResultEstudios resultado = lista.get(selectedRow);
                        txtFecha.setText(resultado.getFecha());
                        txtHora.setText(resultado.getHora());
                        txtTipoEstudio.setText(resultado.getTipoEstudio());
                        txtInformeEstudios.setText(resultado.getInformeEstudios());
                    }
                }
            }
        });

        setLocationRelativeTo(null);
        actualizarTabla();
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);
        try {
            lista = dao.consultarResultados();
            if (lista == null) {
                lista = new ArrayList<>();
            }

            for (ResultEstudios resultado : lista) {
                Object resultadoData[] = new Object[4];
                resultadoData[0] = resultado.getFecha();
                resultadoData[1] = resultado.getHora();
                resultadoData[2] = resultado.getTipoEstudio();
                resultadoData[3] = resultado.getInformeEstudios();
                modelo.addRow(resultadoData);
            }
            tlbResultadoEstudios.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar los resultados de estudios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtFecha.setText("");
        txtHora.setText("");
        txtTipoEstudio.setText("");
        txtInformeEstudios.setText("");
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
