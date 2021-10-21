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
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mysql.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Nouveau_moniteur extends JFrame {

	private JPanel contentPane;
	private JTextField cin_moniteur;
	private JTextField nom;
	private JTextField prenom;
	JDateChooser date_naiss = new JDateChooser(); 
	private JTextField age;
	private JTextField sexe;
	private JTextField adresse;
   static int i;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nouveau_moniteur frame = new Nouveau_moniteur();
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
	public Nouveau_moniteur() {
		
		/*creation du panel principal */
		setBounds(100, 100, 508, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 12, 369, 429);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des zones de textes */
		cin_moniteur = new JTextField();
		cin_moniteur.setBounds(208, 18, 96, 19);
		panel.add(cin_moniteur);
		cin_moniteur.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(208, 68, 96, 19);
		panel.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(208, 125, 96, 19);
		panel.add(prenom);
		prenom.setColumns(10);
		date_naiss.setBounds(208, 174, 111, 19);
		panel.add(date_naiss);
		
		age = new JTextField();
		age.setBounds(208, 226, 96, 19);
		panel.add(age);
		age.setColumns(10);
		
		sexe = new JTextField();
		sexe.setBounds(208, 270, 96, 19);
		panel.add(sexe);
		sexe.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(208, 319, 96, 19);
		panel.add(adresse);
		adresse.setColumns(10);
		
		/*creation des labels */
		JLabel Label1 = new JLabel("Cin du moniteur");
		Label1.setBounds(6, 15, 103, 24);
		panel.add(Label1);
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label2 = new JLabel("Nom");
		label2.setBounds(6, 71, 91, 13);
		panel.add(label2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label3 = new JLabel("Prenom");
		label3.setBounds(6, 125, 69, 19);
		panel.add(label3);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label4 = new JLabel("Date de naissance");
		label4.setBounds(6, 174, 137, 16);
		panel.add(label4);
		label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label5 = new JLabel("Age");
		label5.setBounds(6, 229, 81, 16);
		panel.add(label5);
		label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label6 = new JLabel("Sexe");
		label6.setBounds(6, 273, 81, 16);
		panel.add(label6);
		label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label7 = new JLabel("Adresse");
		label7.setBounds(6, 322, 81, 19);
		panel.add(label7);
		label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
         date_naiss.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
         /*bouttton d'ajout du moniteur */
		JButton btnNewenregistrer = new JButton("");
		btnNewenregistrer.setIcon(new ImageIcon("image\\new1.png"));
		btnNewenregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=0;
				int [] tab= new int [1000];
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
				if(cin_moniteur.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ cin","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(!(isNumeric(cin_moniteur.getText()))) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ cin moniteur","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(existe(tab,Integer.parseInt(cin_moniteur.getText()))) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "le cin de moniteur est dupliqué","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
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
				else if(adresse.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ adresse","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}

				else if(!(isNumeric(age.getText()))) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ age","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				
				
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						java.sql.Connection Conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						PreparedStatement ps =Conn.prepareStatement("insert into moniteurs(cin_moniteur,nom,prenom,date_naiss,age,sexe,adresse) values(?,?,?,?,?,?,?);");
					    ps.setInt(1,Integer.parseInt(cin_moniteur.getText()));
					    ps.setString(2, nom.getText());
					    ps.setString(3, prenom.getText());
					    ps.setDate(4, new java.sql.Date(date_naiss.getDate().getTime()));
					    ps.setInt(5, Integer.parseInt(age.getText()));
					    ps.setString(6,sexe.getText());
					    ps.setString(7, adresse.getText());
					
					    int x =ps.executeUpdate();
						if (x>0)
						{ UIManager.put("OptionPane.background", Color.WHITE);
				           UIManager.put("OptionPane.messagebackground", Color.WHITE);
				           UIManager.put("Panel.background", Color.WHITE);
				           UIManager.put("OptionPane.messageForeground", Color.blue);
				           ImageIcon image3 = new ImageIcon("image\\information.jpg");
						   JOptionPane.showMessageDialog(null, "Ajout avec succés","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
							}
						else {
							 UIManager.put("OptionPane.background", Color.WHITE);
					           UIManager.put("OptionPane.messagebackground", Color.WHITE);
					           UIManager.put("Panel.background", Color.WHITE);
					           UIManager.put("OptionPane.messageForeground", Color.blue);
					           ImageIcon image3 = new ImageIcon("image\\champ.png");
							   JOptionPane.showMessageDialog(null, "Il y a une faute","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
							}
						Moniteur.UpdateTable();
					} 
					catch (ClassNotFoundException e1) { e1.printStackTrace();} 
					catch (SQLException e1) { e1.printStackTrace();}
					}
			}});
		btnNewenregistrer.setBounds(362, 445, 111, 62);
		contentPane.add(btnNewenregistrer);
		
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
