package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import modelo.Paciente;
import dao.daoPacientes;

public class SeleccionarPaciente extends JDialog {
    private JList<Paciente> pacienteList;
    private JButton selectButton;
    private JTextField searchField;
    private JButton searchButton;
    private daoPacientes daoPacientes;
    private Paciente selectedPaciente;

    // Constructor para la ventana de seleccion de paciente
    public SeleccionarPaciente(Frame owner, DefaultListModel<Paciente> pacienteListModel) {
        super(owner, "Seleccionar Paciente", true);
        daoPacientes = new daoPacientes();

        // Crear una lista desplegable para mostrar los pacientes
        pacienteList = new JList<>(pacienteListModel);
        JScrollPane listScrollPane = new JScrollPane(pacienteList);

        // Boton para seleccionar un paciente
        selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPaciente = pacienteList.getSelectedValue();
                if (selectedPaciente != null) {
                    dispose();
                }
            }
        });

        // Campo de busqueda y boton para buscar pacientes por DNI
        searchField = new JTextField(15);
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = searchField.getText().trim();
                if (!dni.isEmpty()) {
                    // Realiza la busqueda en un hilo separado para evitar bloquear la interfaz de usuario
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            ArrayList<Paciente> pacientes = daoPacientes.buscarPacientesPorDNI(dni);
                            DefaultListModel<Paciente> updatedModel = new DefaultListModel<>();
                            for (Paciente paciente : pacientes) {
                                updatedModel.addElement(paciente);
                            }
                            pacienteList.setModel(updatedModel);
                        }
                    });
                } else {
                    // Restaurar la lista original si el campo de busqueda este vacio
                    pacienteList.setModel(pacienteListModel);
                }
            }
        });

        // Panel para la busqueda
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Buscar por DNI:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Panel principal
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(searchPanel, BorderLayout.NORTH);
        contentPane.add(listScrollPane, BorderLayout.CENTER);
        contentPane.add(selectButton, BorderLayout.SOUTH);
        setContentPane(contentPane);

        // Configurar la ubicacion de la ventana
        setLocationRelativeTo(owner);
        pack();
    }

    // Metodo para obtener el paciente seleccionado
    public Paciente getSelectedPaciente() {
        return selectedPaciente;
    }
}
