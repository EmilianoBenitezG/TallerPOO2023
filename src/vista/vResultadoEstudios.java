package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import modelo.ResultadosEstudios;
import java.awt.Font;

public class vResultadoEstudios extends JDialog {

    public vResultadoEstudios(ResultadosEstudios resultadosEstudios) {
        setTitle("Resultados de Estudios");
        setSize(450, 307);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblFecha = new JLabel("Fecha: " + resultadosEstudios.getFecha());
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFecha.setBounds(38, 40, 354, 20);
        panel.add(lblFecha);

        JLabel lblHora = new JLabel("Hora: " + resultadosEstudios.getHora());
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHora.setBounds(38, 80, 354, 20);
        panel.add(lblHora);

        JLabel lblTipoEstudio = new JLabel("Tipo de Estudio: " + resultadosEstudios.getTipoEstudio());
        lblTipoEstudio.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTipoEstudio.setBounds(38, 120, 354, 20);
        panel.add(lblTipoEstudio);

        JLabel lblInforme = new JLabel("Informe: " + resultadosEstudios.getInforme());
        lblInforme.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblInforme.setBounds(38, 160, 354, 20);
        panel.add(lblInforme);
    }
}
