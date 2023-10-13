package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;

public class vTriage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblFiebre;
	private JLabel lblVomitos_2_1;
	private JLabel lblDolorDePecho;
	private JLabel lblDolorAbdominal;
	private JLabel lblLesionesGraves;
	private JLabel lblLesionesLeves;
	private JLabel lblVomitos;
	private JLabel lblSangrado;
	private JLabel lblVomitos_1;
	private JLabel lblSignosDeShock;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JComboBox comboBox_8;
	private JComboBox comboBox_9;
	private JComboBox comboBox_10;
	private JTextField textField_1;
	private JTextPane txtpnElPacienteSe;
	private JLabel lblConciencia;
	private JComboBox comboBox_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vTriage frame = new vTriage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vTriage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Edad");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 66, 137, 24);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Respiraci\u00F3n");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 101, 137, 24);
		contentPane.add(lblNewLabel_2);
		
		lblFiebre = new JLabel("Fiebre");
		lblFiebre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFiebre.setBounds(10, 135, 137, 24);
		contentPane.add(lblFiebre);
		
		lblSignosDeShock = new JLabel("Signos de Shock");
		lblSignosDeShock.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSignosDeShock.setBounds(10, 450, 137, 24);
		contentPane.add(lblSignosDeShock);
		
		lblLesionesLeves = new JLabel("Lesiones Leves");
		lblLesionesLeves.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLesionesLeves.setBounds(10, 310, 137, 24);
		contentPane.add(lblLesionesLeves);
		
		lblLesionesGraves = new JLabel("Lesiones Graves");
		lblLesionesGraves.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLesionesGraves.setBounds(10, 275, 137, 24);
		contentPane.add(lblLesionesGraves);
		
		lblDolorAbdominal = new JLabel("Dolor Abdominal");
		lblDolorAbdominal.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDolorAbdominal.setBounds(10, 240, 137, 24);
		contentPane.add(lblDolorAbdominal);
		
		lblSangrado = new JLabel("Sangrado");
		lblSangrado.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSangrado.setBounds(10, 380, 137, 24);
		contentPane.add(lblSangrado);
		
		lblVomitos = new JLabel("Estado Mental\r\n");
		lblVomitos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVomitos.setBounds(10, 345, 137, 24);
		contentPane.add(lblVomitos);
		
		lblDolorDePecho = new JLabel("Dolor de Pecho");
		lblDolorDePecho.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDolorDePecho.setBounds(10, 205, 137, 24);
		contentPane.add(lblDolorDePecho);
		
		lblVomitos_1 = new JLabel("Vomitos");
		lblVomitos_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVomitos_1.setBounds(10, 415, 137, 24);
		contentPane.add(lblVomitos_1);
		
		lblVomitos_2_1 = new JLabel("Pulso");
		lblVomitos_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVomitos_2_1.setBounds(10, 170, 137, 24);
		contentPane.add(lblVomitos_2_1);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Normal: 0 puntos", "Dificultad respiratoria moderada: 1 punto", "Dificultad respiratoria grave: 2 puntos"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setToolTipText("Seleccione una opcion");
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(157, 101, 287, 22);
		contentPane.add(comboBox);
		
		lblNewLabel_1 = new JLabel("Nombre del Paciente: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 222, 44);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBounds(211, 11, 184, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(712, 486, 89, 23);
		contentPane.add(btnNewButton);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(613, 486, 89, 23);
		contentPane.add(btnGuardar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(514, 486, 89, 23);
		contentPane.add(btnLimpiar);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(0, 0, 0));
		comboBox_1.setToolTipText("Seleccione una opcion");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Sin fiebre: 0 puntos", "Fiebre moderada: 1 punto", "Fiebre alta: 2 puntos"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setMaximumRowCount(4);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_1.setBounds(157, 138, 287, 22);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Seleccione una opcion");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Normal: 0 puntos", "Anormal (r\u00E1pido o lento): 1 punto"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setMaximumRowCount(4);
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_2.setBounds(157, 173, 287, 22);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setToolTipText("Seleccione una opcion");
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"No presente: 0 puntos", "Presente: 1 punto"}));
		comboBox_3.setSelectedIndex(0);
		comboBox_3.setMaximumRowCount(4);
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_3.setBounds(157, 208, 287, 22);
		contentPane.add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setToolTipText("Seleccione una opcion");
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"No presente: 0 puntos", "Dolor abdominal moderado: 1 punto", "Dolor abdominal severo: 2 puntos"}));
		comboBox_4.setSelectedIndex(0);
		comboBox_4.setMaximumRowCount(4);
		comboBox_4.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_4.setBounds(157, 243, 287, 22);
		contentPane.add(comboBox_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setToolTipText("Seleccione una opcion");
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"No presentes: 0 puntos", "Presentes: 2 puntos"}));
		comboBox_5.setSelectedIndex(0);
		comboBox_5.setMaximumRowCount(4);
		comboBox_5.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_5.setBounds(157, 278, 287, 22);
		contentPane.add(comboBox_5);
		
		comboBox_6 = new JComboBox();
		comboBox_6.setToolTipText("Seleccione una opcion");
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"No presentes: 0 puntos", "Presentes: 1 puntos"}));
		comboBox_6.setSelectedIndex(0);
		comboBox_6.setMaximumRowCount(4);
		comboBox_6.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_6.setBounds(157, 313, 287, 22);
		contentPane.add(comboBox_6);
		
		comboBox_7 = new JComboBox();
		comboBox_7.setToolTipText("Seleccione una opcion");
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Normal: 0 puntos", "Confusi\u00F3n leve: 1 punto", "Confusi\u00F3n grave o somnolencia: 2 puntos"}));
		comboBox_7.setSelectedIndex(0);
		comboBox_7.setMaximumRowCount(4);
		comboBox_7.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_7.setBounds(157, 348, 287, 22);
		contentPane.add(comboBox_7);
		
		comboBox_8 = new JComboBox();
		comboBox_8.setToolTipText("Seleccione una opcion");
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"No presente: 0 puntos", "Sangrado moderado: 1 punto", "Sangrado intenso: 2 puntos"}));
		comboBox_8.setSelectedIndex(0);
		comboBox_8.setMaximumRowCount(4);
		comboBox_8.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_8.setBounds(157, 383, 287, 22);
		contentPane.add(comboBox_8);
		
		comboBox_9 = new JComboBox();
		comboBox_9.setToolTipText("Seleccione una opcion");
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Sin v\u00F3mitos: 0 puntos", "V\u00F3mitos moderados: 1 punto", "V\u00F3mitos intensos: 2 puntos"}));
		comboBox_9.setSelectedIndex(0);
		comboBox_9.setMaximumRowCount(4);
		comboBox_9.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_9.setBounds(157, 418, 287, 22);
		contentPane.add(comboBox_9);
		
		comboBox_10 = new JComboBox();
		comboBox_10.setToolTipText("Seleccione una opcion");
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"No presentes: 0 puntos", "Presentes: 3 puntos"}));
		comboBox_10.setSelectedIndex(0);
		comboBox_10.setMaximumRowCount(4);
		comboBox_10.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_10.setBounds(157, 453, 287, 22);
		contentPane.add(comboBox_10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Edad del Paciente");
		textField_1.setBounds(157, 70, 60, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		txtpnElPacienteSe = new JTextPane();
		txtpnElPacienteSe.setText("El paciente se encuentra en estado:  nashe");
		txtpnElPacienteSe.setBounds(487, 66, 314, 330);
		contentPane.add(txtpnElPacienteSe);
		
		lblConciencia = new JLabel("Conciencia\r\n");
		lblConciencia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConciencia.setBounds(10, 485, 137, 24);
		contentPane.add(lblConciencia);
		
		comboBox_11 = new JComboBox();
		comboBox_11.setToolTipText("Seleccione una opcion");
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Consciente y alerta: 0 puntos", "P\u00E9rdida de conciencia: 3 puntos"}));
		comboBox_11.setSelectedIndex(0);
		comboBox_11.setMaximumRowCount(4);
		comboBox_11.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_11.setBounds(157, 486, 287, 22);
		contentPane.add(comboBox_11);
	}
}
