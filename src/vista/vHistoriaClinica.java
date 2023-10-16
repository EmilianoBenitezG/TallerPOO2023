package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.HistoriaClinicaPaciente;
import dao.daoHistorial;

import java.util.ArrayList;
import javax.swing.JTextField;

public class vHistoriaClinica extends JFrame {

    private JPanel contentPane;
    
    DefaultTableModel modelo = new DefaultTableModel();
    daoHistorial dao = new daoHistorial();
    ArrayList<HistoriaClinicaPaciente> lista;
    private JTable tlbHistorial;
    private JButton btnAtras;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    vHistoriaClinica historiaClinica = new vHistoriaClinica();
                    historiaClinica.setVisible(true);
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
        lblHistorial.setFont(new Font("Dialog", Font.PLAIN, 25));
        lblHistorial.setBounds(113, 11, 175, 65);
        contentPane.add(lblHistorial);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(426, 11, 583, 504);
        contentPane.add(scrollPane);

        tlbHistorial = new JTable();
        tlbHistorial.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null},
            },
            new String[] {
                "Fecha", "Historial Diagnostico", "Lugar de Atencion", "Ultimo Diagnostico", "Resultado Estudios", "Hora"
            }
        ));
        scrollPane.setViewportView(tlbHistorial);
        
        btnAtras = new JButton("Volver");
        btnAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.setVisible(true);
				vHistoriaClinica.this.setVisible(false);
        	}
        });
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAtras.setBounds(10, 53, 85, 36);
        contentPane.add(btnAtras);
        
        
        modelo.addColumn("Fecha");
        modelo.addColumn("Historial Diagnostico");
        modelo.addColumn("Lugar de Atencion");
        modelo.addColumn("Ultimo Diagnostico");
        modelo.addColumn("Resultado Estudios");
        modelo.addColumn("Hora");
        actualizarTabla();
        setLocationRelativeTo(null);
    }
    
    public void actualizarTabla() {
        modelo.setRowCount(0);

        try {
            lista = dao.ConsultaHistorial();
            
            for (HistoriaClinicaPaciente u : lista) {
                Object historial[] = new Object[6];
                historial[0] = u.getFecha();
                historial[1] = u.getId();
                historial[2] = u.getHistorialDiagnostico();
                historial[3] = u.getLugarDeAtencion();
                historial[4] = u.getUltimoDiagnostico();
                historial[5] = u.getResEstudios();
                modelo.addRow(historial);
            }
            tlbHistorial.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar el historial: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}