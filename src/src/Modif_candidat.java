package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Modif_candidat extends JFrame {

	private JPanel contentPane;
	public static JTextField cin_candidat1;
	public static JTextField nom1;
	public static JTextField age1;
	public static JTextField sexe1;
	public static JTextField numero1;
	public static JTextField gmail1;
	public static JTextField etat1;
	public static JTextField permis1;
	public static JTextField prenom1;
	public static JDateChooser date_naiss1;
	public static JDateChooser date_inscription1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modif_candidat frame = new Modif_candidat();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creation du Frame
	 */
	public Modif_candidat() {
		/*---Creation d'un Fenetre---*/
		
		setBounds(100, 100, 447, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---Creation du Panel---*/
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(33, 41, 328, 495);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*---Zone de saisie du Cin candidat---*/
		
		cin_candidat1 = new JTextField();
		cin_candidat1.setBounds(181, 16, 86, 19);
		panel.add(cin_candidat1);
		cin_candidat1.setColumns(10);
		
		/*---Zone de saisie du Nom---*/
		
		nom1 = new JTextField();
		nom1.setBounds(181, 59, 86, 19);
		panel.add(nom1);
		nom1.setColumns(10);
		
		/*---Zone de saisie du Prenom---*/
		
		prenom1 = new JTextField();
		prenom1.setBounds(181, 104, 86, 19);
		panel.add(prenom1);
		prenom1.setColumns(10);
		
		/*---Calendrier des Dates---*/
		
	    date_naiss1 = new JDateChooser();
	    date_naiss1.setBounds(181, 150, 86, 19);
	    panel.add(date_naiss1);
		date_naiss1.setDateFormatString("yyyy-MM-dd");
		

		/*---Zone de saisie d'age---*/
		
		age1 = new JTextField();
		age1.setBounds(181, 195, 86, 19);
		panel.add(age1);
		age1.setColumns(10);
		
		/*---Zone de saisie du sexe---*/
		
		sexe1 = new JTextField();
		sexe1.setBounds(181, 239, 86, 19);
		panel.add(sexe1);
		sexe1.setColumns(10);
		
		/*---Zone de saisie du Numero---*/
		
		numero1 = new JTextField();
		numero1.setBounds(181, 288, 86, 19);
		panel.add(numero1);
		numero1.setColumns(10);
		
		/*---Zone de saisie du Gmail---*/
		
		gmail1 = new JTextField();
		gmail1.setBounds(181, 330, 86, 19);
		panel.add(gmail1);
		gmail1.setColumns(10);
		
		/*---Zone de saisie d'etat---*/
		
		etat1 = new JTextField();
		etat1.setBounds(181, 376, 86, 19);
		panel.add(etat1);
		etat1.setColumns(10);
		
		/*---Zone de saisie du Permis---*/
		
		permis1 = new JTextField();
		permis1.setBounds(181, 424, 86, 19);
		panel.add(permis1);
		permis1.setColumns(10);
		
		/*---Zone de saisie du Date d'inscription---*/
		
	    date_inscription1 = new JDateChooser();
	    date_inscription1.setBounds(182, 470, 86, 19);
	    panel.add(date_inscription1);
		date_inscription1.setDateFormatString("yyyy-MM-dd");
		
		/*---Label Cin Candidat---*/
		
		JLabel lblNewLabel = new JLabel("Cin du candidat");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 18, 113, 13);
		panel.add(lblNewLabel);
		
		/*---Label Nom---*/
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 62, 43, 13);
		panel.add(lblNewLabel_1);
		
		/*---Label Prenom---*/
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(6, 107, 86, 13);
		panel.add(lblNewLabel_2);
		
		/*---Label Date de naissance---*/
		
		JLabel lblNewLabel_3 = new JLabel("Date de naissance");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(6, 150, 126, 13);
		panel.add(lblNewLabel_3);
		
		/*---Label Age---*/
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(6, 198, 126, 13);
		panel.add(lblNewLabel_4);
		
		/*---Label Sexe---*/
		
		JLabel lblNewLabel_5 = new JLabel("Sexe");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(6, 242, 126, 13);
		panel.add(lblNewLabel_5);
		
		/*---Label Numero---*/
		
		JLabel lblNewLabel_6 = new JLabel("Numero");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(6, 291, 126, 13);
		panel.add(lblNewLabel_6);
		
		/*---Label Email---*/
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(6, 333, 126, 13);
		panel.add(lblNewLabel_7);
		
		/*---Label Etat---*/
		
		JLabel lblNewLabel_8 = new JLabel("Etat");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(6, 379, 126, 13);
		panel.add(lblNewLabel_8);
		
		/*---Label Permis---*/
		
		JLabel lblNewLabel_9 = new JLabel("Permis");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(6, 427, 126, 13);
		panel.add(lblNewLabel_9);
	     
		/*---Label Date d'inscription---*/
		
		JLabel lblNewLabel_10 = new JLabel("Date d'inscription");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(6, 470, 126, 13);
		panel.add(lblNewLabel_10);
		
		/*---Creation du bouton Modifier ---*/
		
		JButton Buttonupdate = new JButton("");
		Buttonupdate.setIcon(new ImageIcon("image\\update.png"));
		Buttonupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t1 =Integer.parseInt(cin_candidat1.getText());
				String t2 =nom1.getText();
				String t3 =prenom1.getText();
				String t4 =((JTextField)date_naiss1.getDateEditor().getUiComponent()).getText();
				int t5 =Integer.parseInt(age1.getText());
				String t6 =sexe1.getText();
				int t7 =Integer.parseInt(numero1.getText());
				String t8 =gmail1.getText();
				String t9 =etat1.getText();
				String t10 =permis1.getText();
				String t11 =((JTextField)date_inscription1.getDateEditor().getUiComponent()).getText();
				String request = "Update candidats set cin_candidat='"+t1+"',nom='"+t2+"',prenom='"+t3+"',date_naissance='"+t4+"',age='"+t5+"',sexe='"+t6+"',numero='"+t7+"',gmail='"+t8+"',etat='"+t9+"',permis='"+t10+"',date_inscription='"+t11+"'  Where cin_candidat='"+t1+"'";
			   
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
					   JOptionPane.showMessageDialog(null, "candidat modifié","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
					candidat.UpdateTable();
				}
				catch(Exception e2) { System.out.println(e2); }
			}
		});
		Buttonupdate.setBounds(291, 549, 111, 62);
		contentPane.add(Buttonupdate);}}
