package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class modif_cours extends JFrame {

	private JPanel contentPane;
	public static JTextField date_cours;
	public static JTextField matricule_vehicule;
	public static JTextField cin_candidat;
	public static JTextField cin_moniteur;
	public static JTextField heure_deb;
	public static JTextField heure_fin;
	public static JComboBox statut;
	public static JTextField prix;
	public static int id_cours;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_9;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modif_cours frame = new modif_cours();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public modif_cours() {
		
		setBounds(200, 150, 550, 561);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---Creation du JPanel---*/
		
		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "modifier", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(25, 18, 364, 435);
		contentPane.add(panel);
		panel.setLayout(null);
		

		/*---Zone de saisie du Date_cours---*/
		
		date_cours = new JTextField();
		date_cours.setBounds(189, 44, 100, 22);
		panel.add(date_cours);
		date_cours.setColumns(10);
		
		/*---Zone de saisie du Matricule vehicule---*/
		
		matricule_vehicule = new JTextField();
		matricule_vehicule.setBounds(189, 76, 100, 22);
		panel.add(matricule_vehicule);
		matricule_vehicule.setColumns(10);
		
		/*---Zone de saisie du Cin candidat---*/
		
		cin_candidat = new JTextField();
		cin_candidat.setBounds(189, 112, 100, 22);
		panel.add(cin_candidat);
		cin_candidat.setColumns(10);
		
		/*---Zone de saisie du Cin moniteur---*/
		
		cin_moniteur = new JTextField();
		cin_moniteur.setBounds(189, 151, 100, 22);
		panel.add(cin_moniteur);
		cin_moniteur.setColumns(10);
		
		/*---Zone de saisie d'heure debut---*/
		heure_deb = new JTextField();
		heure_deb.setBounds(189, 190, 100, 22);
		panel.add(heure_deb);
		heure_deb.setColumns(10);
		
		/*---Zone de saisie d'heure fin---*/
		
		heure_fin = new JTextField();
		heure_fin.setBounds(189, 226, 100, 22);
		panel.add(heure_fin);
		heure_fin.setColumns(10);
		

		/*---Zone de saisie du statut---*/
		
		statut = new JComboBox();
	    statut.setBounds(189, 266, 100, 22);
		panel.add(statut);
        
		/*---Zone de saisie du Prix---*/
		
		prix = new JTextField();
		prix.setBounds(189, 309, 100, 22);
		panel.add(prix);
		prix.setColumns(10);
		
		/*---label date du cours---*/
		
		JLabel lblNewLabel_1 = new JLabel("Date du cours");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 43, 100, 22);
		panel.add(lblNewLabel_1);
		
		/*---label Matricule vehicule---*/
		
		lblNewLabel_2 = new JLabel("Matricule du vehicule");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 74, 135, 22);
		panel.add(lblNewLabel_2);
		
		/*---label Cin candidat---*/
		
		lblNewLabel_3 = new JLabel("Cin du candidat");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(33, 111, 100, 22);
		panel.add(lblNewLabel_3);
		
		/*---label Cin moniteur---*/
		
		lblNewLabel_4 = new JLabel("Cin du moniteur");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(33, 150, 100, 22);
		panel.add(lblNewLabel_4);
		
		/*---label Heure debut---*/
		
		lblNewLabel_5 = new JLabel("Heure du debut");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(33, 189, 100, 22);
		panel.add(lblNewLabel_5);
		
		/*---label Heure fin---*/
		
		lblNewLabel_6 = new JLabel("Heure du fin");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(33, 225, 100, 22);
		panel.add(lblNewLabel_6);
		
		/*---label Statut---*/
		
		lblNewLabel_7 = new JLabel("Statut");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(33, 265, 100, 22);
		panel.add(lblNewLabel_7);
		
		/*---label Prix---*/
		lblNewLabel_9 = new JLabel("Prix du cours");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(33, 297, 100, 22);
		panel.add(lblNewLabel_9);
		
		/*---Bouton Modifier ---*/
		JButton btnNewButton5 = new JButton("");
		btnNewButton5.setIcon(new ImageIcon("image\\update.png"));
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t0 =id_cours;
				String t1 =modif_cours.date_cours.getText();
				String t2 =modif_cours.matricule_vehicule.getText();
				int t3 =Integer.parseInt(modif_cours.cin_candidat.getText());
				int t4 =Integer.parseInt(modif_cours.cin_moniteur.getText());
				int t5 =Integer.parseInt(modif_cours.heure_deb.getText());
				int t6 =Integer.parseInt(modif_cours.heure_fin.getText());
				String t7 =modif_cours.statut.getSelectedItem().toString();
		     	int t8 =t6-t5;		
				int t9 =Integer.parseInt(modif_cours.prix.getText());
				String request = "Update cours set date_cours='"+t1+"',matricule_vehicule='"+t2+"',cin_candidat='"+t3+"',cin_moniteur='"+t4+"',heure_deb='"+t5+"',heure_fin='"+t6+"',statut='"+t7+"',duree_cours='"+t8+"',prix='"+t9+"'  Where id_cours='"+t0+"'";
			   
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps =  conn.prepareStatement(request);
					ps.execute();
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "modification avec succés","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
					if(t7 .contentEquals("conduite")||t7.contentEquals("code")) {
					cours.UpdateTable();
					}
					if(t7 .contentEquals("examen code")||t7.contentEquals("examen conduite")) {
						System.out.println(t7);
						Examens.UpdateTable();
					}}
				catch(Exception e2) { 
					e2.printStackTrace();}}
		       });
		btnNewButton5.setBounds(414, 454, 111, 62);
		contentPane.add(btnNewButton5);

	}
}
