package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



public class Nouveau_vehicule extends JFrame {

	private JPanel contentPane;
	
	private JTextField numero;
	private JTextField marque;
	private JTextField matricule_vehicule;
	private JTextField couleur;
	static String[] tab5= new String[1000] ;
	public static int cin;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nouveau_vehicule frame = new Nouveau_vehicule();
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
	public Nouveau_vehicule() {
		
		/*creation du panel principal */
		setBounds(100, 100, 432, 709);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
		 tab5[i]=b;
		  i++;
		 }
		 }
		catch(Exception e) { System.out.println(e); }
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 415, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des zones de textes */
		numero = new JTextField();
		numero.setBounds(162, 15, 202, 35);
		panel.add(numero);
		numero.setColumns(10);
		
		couleur = new JTextField();
		couleur.setBounds(162, 196, 202, 35);
		panel.add(couleur);
		couleur .setColumns(10);
		
		matricule_vehicule = new JTextField();
		matricule_vehicule.setBounds(162, 60, 202, 35);
		panel.add(matricule_vehicule);
		matricule_vehicule.setColumns(10);
		
		marque = new JTextField();
		marque.setBounds(162, 151, 200, 35);
		panel.add(marque);
		marque.setColumns(10);
		

		JComboBox nom_candidat = new JComboBox();
		nom_candidat.setModel(new DefaultComboBoxModel(tab5));
		nom_candidat.setSelectedIndex(1);
		nom_candidat.setBounds(162, 296, 202, 35);
		panel.add(nom_candidat);
		
		/*creation des labels */
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(6, 26, 75, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Matricle du vehicule");
		lblNewLabel_1.setBounds(6, 71, 122, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(6, 116, 97, 24);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		JLabel lblNewLabel_3 = new JLabel("Marque");
		lblNewLabel_3.setBounds(6, 156, 80, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Couleur");
		lblNewLabel_4.setBounds(6, 201, 75, 22);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5 = new JLabel("Etat");
		lblNewLabel_5.setBounds(6, 253, 58, 13);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Nom du candidat");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(6, 307, 122, 24);
		panel.add(lblNewLabel_6);
		
		JComboBox type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"sport", "golf7", "Le 4x4"}));
		type.setSelectedIndex(1);
		type.setBounds(165, 105, 199, 35);
		panel.add(type);
		
		JComboBox etat= new JComboBox();
		 etat.setModel(new DefaultComboBoxModel(new String[] {"Occupee", "Libre"}));
		 etat.setSelectedIndex(1);
		 etat.setBounds(162, 245, 200, 35);
		panel.add( etat);
		
		
		/*bouttton d'ajout du vehicule */
		JButton Newenregister = new JButton("");
		Newenregister.setIcon(new ImageIcon("image\\new1.png"));
		Newenregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c=nom_candidat.getSelectedItem().toString();
				String sql2 = "Select * from candidats Where nom='"+c+"'";
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			PreparedStatement prepared =  conn.prepareStatement(sql2);
			    ResultSet resultat1 = prepared.executeQuery();
			  while (resultat1.next()) {
				   cin =resultat1.getInt("cin_candidat");
				 
				}}
				catch(Exception e3) { System.out.println("wrong");}
				
				if(numero.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ numero","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
					
				}
				else if(!(isNumeric(numero.getText()))) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ numero","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if(matricule_vehicule.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ matricule","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
					
				}
				else if(type.getSelectedItem().toString().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ type","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
					
				}
				else if(marque.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ marque","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if(couleur.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ couleur","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if(etat.getSelectedItem().toString().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ age","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if(numero.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ nom du candidat","CHAMP MANQUANT",JOptionPane.INFORMATION_MESSAGE,image3);

				}
				else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps = conn.prepareStatement("insert into vehicule (numero,matricule,type,marque,couleur,etat,cin_candidat)values(?,?,?,?,?,?,?);");
					ps.setInt(1,Integer.parseInt(numero.getText()));
				    ps.setString(2, matricule_vehicule.getText());
				    ps.setString(3, type.getSelectedItem().toString());
				    ps.setString(4, marque.getText());
				    ps.setString(5, couleur.getText());
				    ps.setString(6, etat.getSelectedItem().toString());
				    ps.setInt(7, cin);
				    int x =ps.executeUpdate();
					if (x>0)
					{/*System.out.println("succes ");*/}
					else {System.out.println("il y'a une faute");}
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\img3.jpg");
					   JOptionPane.showMessageDialog(null, "Vehiculee ajoutée","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
					
					
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
			}
		});
		Newenregister.setBounds(280, 583, 111, 62);
		contentPane.add(Newenregister);
		
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







	

	
	
		
		
		
		

