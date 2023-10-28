package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTextField;

public class vInfoGestor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JLabel lblRol = new JLabel("Rol");

	
	public vInfoGestor(DefaultTableModel modelo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 60, 407, 133);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Codigo para volver al menu principal
                vGestores vGestores = new vGestores();
                vGestores.transferirDatos(lblRol.getText());
                vGestores.setVisible(true);
                vInfoGestor.this.dispose(); // Cierra la ventana actual
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(10, 13, 85, 36);
		contentPane.add(btnVolver);
		
		lblRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblRol.setBounds(299, 13, 98, 18);
		contentPane.add(lblRol);
		
		JLabel lblCaptionRol = new JLabel("Rol:");
		lblCaptionRol.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 12));
		lblCaptionRol.setBounds(274, 13, 25, 18);
		contentPane.add(lblCaptionRol);
		setLocationRelativeTo(null);
	}
	
	// Metodo para transferir el rol del usuario a la ventana
	public void transferirDatos(String rol) {
		lblRol.setText(rol);
	}
}
