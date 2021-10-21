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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Modif_moniteur extends JFrame {

	private JPanel contentPane;
	public static JTextField txtcin;
	public static JTextField txtnom;
	public static JTextField txtprenom;
	public static JTextField txtdate;
	public static JTextField txtage;
	public static JTextField txtsexe;
	public static JTextField txtadresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modif_moniteur frame = new Modif_moniteur();
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
	public Modif_moniteur() {
		
		/*creation du panel principale*/
		
		setBounds(200, 150, 467, 566);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 17, 338, 415);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des zones de textes*/
		
		txtcin = new JTextField();
		txtcin.setBounds(179, 15, 96, 19);
		panel.add(txtcin);
		txtcin.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setBounds(179, 71, 96, 19);
		panel.add(txtnom);
		txtnom.setColumns(10);
		
		txtprenom = new JTextField();
		txtprenom.setBounds(179, 121, 96, 19);
		panel.add(txtprenom);
		txtprenom.setColumns(10);
		
		txtdate = new JTextField();
		txtdate.setBounds(179, 171, 96, 19);
		panel.add(txtdate);
		txtdate.setColumns(10);
		
		txtage = new JTextField();
		txtage.setBounds(179, 227, 96, 19);
		panel.add(txtage);
		txtage.setColumns(10);
		
		txtsexe = new JTextField();
		txtsexe.setBounds(179, 271, 96, 19);
		panel.add(txtsexe);
		txtsexe.setColumns(10);
		
		txtadresse = new JTextField();
		txtadresse.setBounds(179, 320, 96, 19);
		panel.add(txtadresse);
		txtadresse.setColumns(10);
		
		/*creation des labels */
		
		JLabel lblNewLabel = new JLabel("Cin de Moniteur");
		lblNewLabel.setBounds(6, 18, 101, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(6, 74, 111, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(6, 124, 111, 19);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Date de naissance");
		lblNewLabel_3.setBounds(6, 174, 116, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setBounds(6, 230, 130, 16);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5 = new JLabel("Sexe");
		lblNewLabel_5.setBounds(6, 274, 130, 16);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Adresse");
		lblNewLabel_6.setBounds(6, 323, 122, 19);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		/*création du boutton de modification des coordonnées de moniteur */
		
		JButton btnupdate = new JButton("");
		btnupdate.setIcon(new ImageIcon("image\\update.png"));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t1 =Integer.parseInt(Modif_moniteur.txtcin.getText());
				String t2 =Modif_moniteur.txtnom.getText();
				String t3 =Modif_moniteur.txtprenom.getText();
				String t4 =Modif_moniteur.txtdate.getText();
				int t5 =Integer.parseInt(Modif_moniteur.txtage.getText());
				String t6 =Modif_moniteur.txtsexe.getText();
				String t7 =Modif_moniteur.txtadresse.getText();
				String request = "Update moniteurs set cin_moniteur='"+t1+"',nom='"+t2+"',prenom='"+t3+"',date_naiss='"+t4+"',age='"+t5+"',sexe='"+t6+"',adresse='"+t7+"'  Where cin_moniteur='"+t1+"'";
			   
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
					   JOptionPane.showMessageDialog(null, "Moniteur Modifié","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
					Moniteur.UpdateTable();
				}
			   catch(Exception e2) { System.out.println(e2); }
			}
		});
		btnupdate.setBounds(308, 442, 111, 62);
		contentPane.add(btnupdate);
	}
}
