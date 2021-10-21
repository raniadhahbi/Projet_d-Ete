package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class Nouveau_candidat extends JFrame {

	private JPanel contentPane;
	
	private JTextField cin_candidat;
	private JTextField nom;
	private JTextField prenom;
	private JTextField age;
	private JTextField sexe;
	private JTextField numero;
	private JTextField gmail;
	static int i;
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nouveau_candidat frame = new Nouveau_candidat();
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
	public Nouveau_candidat() {
		
		/*creation du panel principal */
		setBounds(100, 100, 507, 669);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(14, 15, 380, 538);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des zones de textes */
		cin_candidat = new JTextField();
		cin_candidat.setBounds(172, 15, 202, 35);
		panel.add(cin_candidat);
		cin_candidat.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(172, 60, 202, 35);
		panel.add(nom);
		nom .setColumns(10);
		
		prenom  = new JTextField();
		prenom.setBounds(172, 105, 202, 35);
		panel.add(prenom);
		prenom .setColumns(10);
		
		JDateChooser date_naiss = new JDateChooser();
		date_naiss.setBounds(172, 150, 202, 35);
		panel.add(date_naiss);
		
		age = new JTextField();
		age.setBounds(172, 195, 200, 35);
		panel.add(age);
		age.setColumns(10);
		
		sexe = new JTextField();
		sexe.setBounds(172, 240, 202, 39);
		panel.add(sexe);
		sexe.setColumns(10);
		
		numero = new JTextField();
		numero.setBounds(172, 289, 202, 35);
		panel.add(numero);
		numero.setColumns(10);
		
		gmail = new JTextField();
		gmail.setBounds(172, 334, 202, 35);
		panel.add(gmail);
		gmail.setColumns(10);
		
		JComboBox etat = new JComboBox();
		etat.setBounds(172, 389, 202, 35);
		panel.add(etat);
		etat.setModel(new DefaultComboBoxModel(new String[] {"Admis", "En cours", "Echec"}));
		etat.setSelectedIndex(1);
		
		JComboBox permis = new JComboBox();
		permis.setBounds(172, 434, 202, 33);
		panel.add(permis);
		permis.setModel(new DefaultComboBoxModel(new String[] {"A", "A1", "B", "B+E", "C", "C+E", "D", "D1", "D+E", "H"}));
		permis.setSelectedIndex(1);
		
		JDateChooser date_inscription = new JDateChooser();
		date_inscription.setBounds(172, 481, 202, 35);
		panel.add(date_inscription);
		
		/*creation des labels */
		JLabel lblNewLabel = new JLabel("Cin du candidat");
		lblNewLabel.setBounds(14, 26, 99, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(14, 71, 77, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(14, 116, 99, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date de naissance");
		lblNewLabel_3.setBounds(14, 156, 131, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setBounds(14, 201, 82, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexe");
		lblNewLabel_5.setBounds(14, 253, 45, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone");
		lblNewLabel_6.setBounds(14, 300, 67, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setBounds(14, 345, 45, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Etat");
		lblNewLabel_8.setBounds(14, 400, 51, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Permis");
		lblNewLabel_9.setBounds(14, 450, 45, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Date d'inscription");
		lblNewLabel_10.setBounds(14, 495, 107, 13);
		panel.add(lblNewLabel_10);
		
		/*bouttton d'ajout du candidat */
		JButton Buttonregister = new JButton("");
		Buttonregister.setIcon(new ImageIcon("image\\new1.png"));
		Buttonregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=0;
				int [] tab = new int [10000];
				String sql = "Select * from candidats";
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				PreparedStatement prepared =  conn.prepareStatement(sql);
				ResultSet resultat = prepared.executeQuery();
			    while (resultat.next()) {
				 int b =resultat.getInt("cin_candidat");
				 tab[i]=b;
				  i++;
				 }  
				 }
				catch(Exception e1) { System.out.println(e1); }
				if(cin_candidat.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ cin","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				
				}
				else if(nom.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ nom","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(prenom.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ prenom","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(((JTextField)date_naiss.getDateEditor().getUiComponent()).getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ date de naissance","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(sexe.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ sexe","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(age.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ age","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(numero.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ numero","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(gmail.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ gmail","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(etat.getSelectedItem().toString().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ etat","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(permis.getSelectedItem().toString().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ permis","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(((JTextField)date_inscription.getDateEditor().getUiComponent()).getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ date d'inscription","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				
				}
				else if(existe(tab,Integer.parseInt(cin_candidat.getText()))) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "le cin de candidat est dupliqué","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(!(isNumeric(age.getText()))) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ age","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if(!(isNumeric(numero.getText()))) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ numero","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
					
				}
				
				else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps = conn.prepareStatement("insert into candidats (cin_candidat,nom,prenom,date_naissance,age,sexe,numero,gmail,etat,permis,date_inscription)values(?,?,?,?,?,?,?,?,?,?,?);");
					ps.setInt(1,Integer.parseInt(cin_candidat.getText()));
				    ps.setString(2, nom.getText());
				    ps.setString(3, prenom.getText());
				    ps.setDate(4, new java.sql.Date(date_naiss.getDate().getTime()));
				    ps.setString(6, sexe.getText());
				    ps.setInt(5,Integer.parseInt(age.getText()));
				    ps.setInt(7,Integer.parseInt(numero.getText()));
				    ps.setString(8, gmail.getText());
				    ps.setString(9,etat.getSelectedItem().toString());
				    ps.setString(10,permis.getSelectedItem().toString());
				    ps.setDate(11, new java.sql.Date(date_inscription.getDate().getTime()));
				    
				    int x =ps.executeUpdate();
					if (x>0)
					{/*System.out.println("succés");*/}
					else {System.out.println("il y'a une faute");}
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "succés d'enregistrement","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
					candidat.UpdateTable();
				}
				catch(Exception e1){ System.out.println(e1); }
		}
			}
		});
		Buttonregister.setBounds(349, 560, 111, 62);
		contentPane.add(Buttonregister);
	}
	/*verification du format du donnée */
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	/*verification d'unicité du cin */
	 static boolean existe(int T[], int val){
		  for(int j =0 ; j<i;j++){
		      if(val==T[j])
		          return true;
		  }
		  return false;}
}







	

	
	
		
		
		
		

