package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Medico;
import dao.daoMedico;

public class SeleccionarMedico extends JDialog {
    private JList<Medico> medicoList;
    private JButton selectButton;
    private JTextField searchField;
    private JButton searchButton;
    private daoMedico dao;
    private Medico selectedMedico;

    public Medico getSelectedMedico() {
        return selectedMedico;
    }

    public SeleccionarMedico(Frame owner, DefaultListModel<Medico> medicoListModel) {
        super(owner, "Seleccionar Médico", true);
        dao = new daoMedico();
        
        ArrayList<Medico> medicos = dao.consultarMedicos();
        DefaultListModel<Medico> initialModel = new DefaultListModel<>();
        for (Medico medico : medicos) {
            initialModel.addElement(medico);
        }

        medicoList = new JList<>(initialModel);
        JScrollPane listScrollPane = new JScrollPane(medicoList);

        selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMedico = medicoList.getSelectedValue();
                if (selectedMedico != null) {
                    dispose();
                }
            }
        });

        searchField = new JTextField(15);
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = searchField.getText().trim();
                if (!matricula.isEmpty()) {
                    ArrayList<Medico> medicos = dao.buscarMedicosPorMatricula(matricula);
                    DefaultListModel<Medico> updatedModel = new DefaultListModel<>();
                    for (Medico medico : medicos) {
                        updatedModel.addElement(medico);
                    }
                    medicoList.setModel(updatedModel);
                } else {
                    medicoList.setModel(initialModel);
                }
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Buscar por Matrícula:"));
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
