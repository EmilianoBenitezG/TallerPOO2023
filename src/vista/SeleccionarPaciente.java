package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Paciente;
import dao.daoPacientes;

public class SeleccionarPaciente extends JDialog {
    private JList<Paciente> pacienteList;
    private JButton selectButton;
    private JTextField searchField;
    private JButton searchButton;
    private daoPacientes dao;
    private Paciente selectedPaciente;

    public Paciente getSelectedPaciente() {
        return selectedPaciente;
    }

    public SeleccionarPaciente(Frame owner, DefaultListModel<Paciente> pacienteListModel) {
        super(owner, "Seleccionar Paciente", true);
        dao = new daoPacientes();
        

        pacienteList = new JList<>(pacienteListModel);
        JScrollPane listScrollPane = new JScrollPane(pacienteList);

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

        searchField = new JTextField(15);
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = searchField.getText().trim();
                if (!dni.isEmpty()) {
                    ArrayList<Paciente> pacientes = dao.buscarPacientesPorDNI(dni);
                    DefaultListModel<Paciente> updatedModel = new DefaultListModel<>();
                    for (Paciente paciente : pacientes) {
                        updatedModel.addElement(paciente);
                    }
                    pacienteList.setModel(updatedModel);
                } else {
                    pacienteList.setModel(pacienteListModel);
                }
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Buscar por DNI:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(searchPanel, BorderLayout.NORTH);
        contentPane.add(listScrollPane, BorderLayout.CENTER);
        contentPane.add(selectButton, BorderLayout.SOUTH);
        setContentPane(contentPane);

        setLocationRelativeTo(owner);
        pack();
    }
}
