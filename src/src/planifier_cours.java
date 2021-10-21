package src;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.*;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
public class planifier_cours extends JFrame {

	private JPanel contentPane;
	private JTextField matricule_vehicule;
	private JTextField heure_deb;
	private JTextField heure_fin;
	private JTextField prix;
	public String[] tab= new String[1000] ;
	public String[] tab1= new String[1000] ;
	public static int cin;
	public static int cin2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planifier_cours frame = new planifier_cours();
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
	public planifier_cours() {
		setBounds(100, 100, 562, 570);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String sql = "Select * from candidats";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql);
		ResultSet resultat = prepared.executeQuery();
		int i=0;
	    while (resultat.next()) {
		 String b =resultat.getString("nom");
		 tab[i]=b;
		  i++;
		 }
		 }
		catch(Exception e) { System.out.println("il y'a une faulte"); }
		
		String sql1 = "Select * from moniteurs";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql1);
		ResultSet resultat = prepared.executeQuery();
	    int j=0;
		while (resultat.next()) {
		 String a =resultat.getString("nom");
		 tab1[j]=a;
		 j++;

		}
		}
		catch(Exception e) { System.out.println("il y'a une faulte"); }
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "candidat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(16, 26, 384, 493);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des zones de textes */
		JDateChooser date_cours = new JDateChooser();
		date_cours.setBounds(164, 60, 202, 35);
		panel.add(date_cours);
		
		matricule_vehicule = new JTextField();
		matricule_vehicule.setBounds(164, 105, 202, 35);
		panel.add(matricule_vehicule);
		matricule_vehicule.setColumns(10);
		
		JComboBox nom_candidat = new JComboBox();
		nom_candidat.setBounds(164, 163, 202, 22);
		panel.add(nom_candidat);
		nom_candidat.setModel(new DefaultComboBoxModel(tab));
		nom_candidat.setSelectedIndex(1);
		
		JComboBox nom_moniteur = new JComboBox();
		nom_moniteur.setBounds(164, 207, 202, 22);
		panel.add(nom_moniteur);
		nom_moniteur.setModel(new DefaultComboBoxModel(tab1));
		nom_moniteur.setSelectedIndex(1);
		
		heure_deb = new JTextField();
		heure_deb.setBounds(164, 240, 202, 35);
		panel.add(heure_deb);
		heure_deb.setColumns(10);
		
		heure_fin = new JTextField();
		heure_fin.setBounds(164, 285, 202, 35);
		panel.add(heure_fin);
		heure_fin.setColumns(10);
		
		JComboBox statut = new JComboBox();
		statut.setBounds(164, 339, 202, 21);
		panel.add(statut);
		statut.setModel(new DefaultComboBoxModel(new String[] {"code", "examen code", "conduite", "examen conduite"}));
		statut.setSelectedIndex(1);
		
		prix = new JTextField();
		prix.setBounds(164, 382, 202, 27);
		panel.add(prix);
		prix.setColumns(10);
	
		/*creation des labels */
		JLabel lblNewLabel_1 = new JLabel("Date du cours\r\n");
		lblNewLabel_1.setBounds(6, 71, 99, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Matricule du vehicule");
		lblNewLabel_2.setBounds(6, 116, 148, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom du candidat");
		lblNewLabel_3.setBounds(6, 161, 99, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nom du moniteur");
		lblNewLabel_4.setBounds(6, 206, 99, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Heure debut");
		lblNewLabel_5.setBounds(6, 251, 82, 24);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Heure fin");
		lblNewLabel_6.setBounds(6, 296, 82, 24);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Statut");
		lblNewLabel_7.setBounds(6, 341, 82, 22);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Prix");
		lblNewLabel_9.setBounds(6, 389, 75, 13);
		panel.add(lblNewLabel_9);

		/*boutton de planification du cours */
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("image\\save.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((JTextField)date_cours.getDateEditor().getUiComponent()).getText().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ date","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if( matricule_vehicule.getText().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ matricule de vehicule","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(nom_candidat.getSelectedItem().toString().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ nom de candidat","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				
				else if(nom_moniteur.getSelectedItem().toString().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ nom de moniteur","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(heure_deb.getText().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ heure du debut","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(!(isNumeric(heure_deb.getText()))) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ heure de fin","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(heure_fin.getText().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ heure de fin","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(!(isNumeric(heure_fin.getText()))) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ heure de fin","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(statut.getSelectedItem().toString().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ statut","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				
				}
				else if(prix.getText().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ prix","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				
				
				else {
				String c=nom_candidat.getSelectedItem().toString();
				String sql2 = "Select * from candidats Where nom='"+c+"'";
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			PreparedStatement prepared =  conn.prepareStatement(sql2);
			    ResultSet resultat1 = prepared.executeQuery();
			    				
			  while (resultat1.next()) {
				   cin =resultat1.getInt("cin_candidat");
				
				}
			    
				 }
				catch(Exception e1) { System.out.println("il y'a une faulte"); }
				String d=nom_moniteur.getSelectedItem().toString();
				String sql3 = "Select * from moniteurs Where nom='"+d+"'";
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			    PreparedStatement prepared =  conn.prepareStatement(sql3);
			    ResultSet resultat2 = prepared.executeQuery();
			   
				
			  while (resultat2.next()) {
				   cin2 =resultat2.getInt("cin_moniteur");
				 
				}
			    
				 }
				catch(Exception e1) { System.out.println("il y'a une faulte"); }
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps = conn.prepareStatement("insert into cours(date_cours,matricule_vehicule,cin_candidat,cin_moniteur,heure_deb,heure_fin,statut,duree_cours,prix)values(?,?,?,?,?,?,?,?,?);");
				    ps.setDate(1, new java.sql.Date(date_cours.getDate().getTime()));
				    ps.setString(2, matricule_vehicule.getText());
				    ps.setInt(3, cin);
				    ps.setInt(4, cin2);
				    ps.setInt(5, Integer.parseInt(heure_deb.getText()));
				    ps.setInt(6, Integer.parseInt(heure_fin.getText()));
				    ps.setString(7, statut.getSelectedItem().toString());
				  
				    int t = Integer.parseInt(heure_fin.getText())-Integer.parseInt(heure_deb.getText());
				
				    ps.setInt(8,t);
				    ps.setInt(9, Integer.parseInt(prix.getText()));
				    int x =ps.executeUpdate();
					if (x>0)
					{/*System.out.println("succés ");*/}
					else {System.out.println("il y'a une faulte ");}
					UIManager.put("OptionPane.background", Color.WHITE);
			        UIManager.put("OptionPane.messagebackground", Color.WHITE);
			        UIManager.put("Panel.background", Color.WHITE);
			        UIManager.put("OptionPane.messageForeground", Color.blue);
			        ImageIcon image3 = new ImageIcon("image\\information.jpg");
					JOptionPane.showMessageDialog(null, "cours planifié","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					cours.UpdateTable();
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
			}});

		
		btnNewButton.setBounds(414, 461, 111, 62);
		contentPane.add(btnNewButton);
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
}
