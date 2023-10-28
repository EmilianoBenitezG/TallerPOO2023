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

    // Constructor para la ventana de seleccion de medico
    public SeleccionarMedico(Frame owner, DefaultListModel<Medico> medicoListModel) {
        super(owner, "Seleccionar M�dico", true);
        dao = new daoMedico();
        
        // Consultar la lista de medicos desde el DAO
        ArrayList<Medico> medicos = dao.consultarMedicos();
        DefaultListModel<Medico> initialModel = new DefaultListModel<>();
        for (Medico medico : medicos) {
            initialModel.addElement(medico);
        }

        // Crear una lista desplegable para mostrar los medicos
        medicoList = new JList<>(initialModel);
        JScrollPane listScrollPane = new JScrollPane(medicoList);

        // Boton para seleccionar un medico
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

        // Campo de busqueda y boton para buscar medicos por matricula
        searchField = new JTextField(15);
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = searchField.getText().trim();
                if (!matricula.isEmpty()) {
                    // Buscar medicos por matricula y actualizar la lista
                    ArrayList<Medico> medicos = dao.buscarMedicosPorMatricula(matricula);
                    DefaultListModel<Medico> updatedModel = new DefaultListModel<>();
                    for (Medico medico : medicos) {
                        updatedModel.addElement(medico);
                    }
                    medicoList.setModel(updatedModel);
                } else {
                    // Restaurar la lista original si el campo de busqueda este vacio
                    medicoList.setModel(initialModel);
                }
            }
        });

        // Panel para la busqueda
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Buscar por Matricula:"));
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

    // Metodo para obtener el medico seleccionado
    public Medico getSelectedMedico() {
        return selectedMedico;
    }
}
