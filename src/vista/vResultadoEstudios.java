package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

// Importación de la clase ResultadosEstudios del paquete modelo
import modelo.ResultadosEstudios;

import java.awt.Font;

// Definición de la clase vResultadoEstudios, que extiende JDialog
public class vResultadoEstudios extends JDialog {

    // Constructor de la clase vResultadoEstudios que recibe un objeto ResultadosEstudios
    public vResultadoEstudios(ResultadosEstudios resultadosEstudios) {
        // Configuración del título de la ventana
        setTitle("Resultados de Estudios");

        // Configuración del tamaño de la ventana
        setSize(450, 307);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Creación de un panel para colocar los componentes
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);

        // Configuración del diseño del panel como nulo (para colocar componentes manualmente)
        panel.setLayout(null);

        // Creación y configuración de una etiqueta para mostrar la fecha de los resultados de estudios
        JLabel lblFecha = new JLabel("Fecha: " + resultadosEstudios.getFecha());
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFecha.setBounds(38, 40, 354, 20);
        panel.add(lblFecha);

        // Creación y configuración de una etiqueta para mostrar la hora de los resultados de estudios
        JLabel lblHora = new JLabel("Hora: " + resultadosEstudios.getHora());
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHora.setBounds(38, 80, 354, 20);
        panel.add(lblHora);


        // Creación y configuración de una etiqueta para mostrar el tipo de estudio
        JLabel lblTipoEstudio = new JLabel("Tipo de Estudio: " + resultadosEstudios.getTipoEstudio());
        lblTipoEstudio.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTipoEstudio.setBounds(38, 120, 354, 20);
        panel.add(lblTipoEstudio);

        // Creación y configuración de una etiqueta para mostrar el informe de los resultados de estudios
        JLabel lblInforme = new JLabel("Informe: " + resultadosEstudios.getInforme());
        lblInforme.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblInforme.setBounds(38, 160, 354, 20);
        panel.add(lblInforme);
    }
}
