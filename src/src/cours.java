package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class cours extends JFrame {

	private JPanel contentPane;
	private static JTable table1;
	private JTextField textField;
	private static JTable table3;
	public static int tab1;

	/**
	 * Execution d'appliction.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cours frame = new cours();
					frame.UpdateTable();
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
	public cours() {
		
		/*---Creation du Fenetre---*/
		
		setBounds(100, 100, 1108,610);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
	     
		 /*---Creation du Scroll---*/
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		 scrollPane_1.setForeground(new Color(128, 0, 128));
		 scrollPane_1.setBounds(249, 226, 766, 104);
		 contentPane.add(scrollPane_1);
		 
		 /*---Creation du table---*/
		 
		 table1 = new JTable();
		 table1.addMouseListener(new MouseAdapter() {
		 @Override
		 public void mouseClicked(MouseEvent e) {
			selectionner1();}
		});
		table1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table1.getTableHeader().setOpaque(false);
		table1.setForeground(Color.BLUE);
		table1.getTableHeader().setBackground(Color.lightGray);
		table1.getTableHeader().setForeground(Color.white);
		table1.setBackground(Color.white);
		scrollPane_1.setViewportView(table1);
		
		/*---Creation du bouton Ajouter---*/
		
		JButton Button3 = new JButton("");
		Button3.setIcon(new ImageIcon("image\\new1.png"));
		Button3.setBounds(306, 366, 111, 62);
		Button3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			planifier_cours frame = new planifier_cours();
			frame.setVisible(true);
			frame.setResizable(false);
			}
		});
		contentPane.add(Button3);
		
		/*---Creation du bouton Supprimer--- */
		
		JButton btnSuppression = new JButton("");
		btnSuppression.setIcon(new ImageIcon("image\\delete1.png"));
		btnSuppression.setBounds(457, 366, 111, 62);
		btnSuppression.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
			{
					int row = table1.getSelectedRow();
					if(row==-1)
					{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
					else {
					String value = table1.getModel().getValueAt(row, 0).toString();
					String request="delete from cours where id_cours=?";
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps =  conn.prepareStatement(request);
					ps.setString(1,value);
					ps.execute();
					JOptionPane.showMessageDialog(null, "cours supprimé ");
					candidat.UpdateTable();
			}}
			catch (Exception e3) { System.out.println("Il y'a une faute"); }
			}	
		});
		contentPane.add(btnSuppression);
		
		/*---Creation du bouton liste---*/
		
		JButton Button_1 = new JButton("");
		Button_1.setIcon(new ImageIcon("image\\liste1.png"));
		Button_1.setBounds(284, 125, 111, 62);
		Button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UpdateTable();}
		});
		contentPane.add(Button_1);
		
		/*---Creation du zone de saisie Rechercher---*/
		
		JTextField txtrecherche = new JTextField();
		txtrecherche.setBounds(432, 162, 111, 25);
		contentPane.add(txtrecherche);
		txtrecherche.setColumns(10);
		
		/*---creation du Panel---*/
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "listes_candidats", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(294, 438, 518, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*---Creation du Scroll---*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 498, 94);
		panel.add(scrollPane);
		
		/*---Creation du Table---*/
		
		table3 = new JTable();
		table3.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table3.getTableHeader().setOpaque(false);
		table3.setForeground(Color.BLUE);
		table3.getTableHeader().setBackground(Color.lightGray);
		table3.getTableHeader().setForeground(Color.white);
		table3.setBackground(Color.white);
		scrollPane.setViewportView(table3);
		
		/*---Creation du bouton Rechercher---*/
		
		JButton Button_2 = new JButton("");
		Button_2.setIcon(new ImageIcon("image\\search.png"));
		Button_2.setBounds(597, 125, 111, 62);
		Button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					String requete1="select * from cours where statut =?";
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps=conn.prepareStatement(requete1);
					ps.setString(1,txtrecherche.getText());
					ResultSet res=ps.executeQuery();
					DefaultTableModel model1 = new DefaultTableModel(new String[]{"id", "date","matricule","cin_candidat","cin_moniteur","heure_deb","heure_fin","statut","duree_cours",}, 0);
					DefaultTableModel model2 = new DefaultTableModel(new String[]{"nom", "prenom","etat","date_inscription",}, 0);
					 while (res.next()) {
					     int a =res.getInt("id_cours");
					     Date b =res.getDate("date_cours");
					     String c =res.getString("matricule_vehicule");
					     tab1=res.getInt("cin_candidat");
					     int e =res.getInt("cin_moniteur");
					     int f =res.getInt("heure_deb");
					     int g =res.getInt("heure_fin");
					     String h =res.getString("statut");
					     int i =res.getInt("duree_cours");
					     model1.addRow(new Object[]{a,b,c,tab1,e,f, g,h,i});
					     table1.setModel(model1);
		                 String request = "select * from candidats Where cin_candidat='"+tab1+"'";
						 Class.forName("com.mysql.cj.jdbc.Driver");
						 java.sql.Connection conn1 =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					 	 PreparedStatement prepared =  conn1.prepareStatement(request);
						 ResultSet resultat2 = prepared.executeQuery();
						 while (resultat2.next()) {	 
						    String t1 =resultat2.getString("nom");
						    String t2 =resultat2.getString("prenom");
						    String t3 =resultat2.getString("etat");
						    Date t4 =resultat2.getDate("date_inscription");
						    model2.addRow(new Object[]{t1,t2,t3,t4});
						    table3.setModel(model2);					
			               }}
			}catch(Exception e4) {
					    System.out.println(e4);}}
		});
		contentPane.add(Button_2);
		
		/*---Creation bouton Modifier---*/
		
		JButton Button4 = new JButton("");
		Button4.setIcon(new ImageIcon("image\\update.png"));
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            int row = table1.getSelectedRow();
				if(row==-1)
				{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
				else {
				modif_cours frame = new modif_cours();
				String[] tab=  new String [10]; 
				for(int i=0;i<10;i++) {
					String value = table1.getModel().getValueAt(row, i).toString();
					tab[i]=value;
				}
				modif_cours.id_cours= Integer.parseInt(tab[0]);
				modif_cours.date_cours.setText(tab[1]);
				modif_cours.matricule_vehicule.setText(tab[2]);
				modif_cours.cin_candidat.setText(tab[3]);
				modif_cours.cin_moniteur.setText(tab[4]);
				modif_cours.heure_deb.setText(tab[5]);
				modif_cours.heure_fin.setText(tab[6]);
				int t = Integer.parseInt(modif_cours.heure_fin.getText())-Integer.parseInt(modif_cours.heure_deb.getText());
				modif_cours.prix.setText(tab[9]);
				modif_cours.statut.setModel(new DefaultComboBoxModel(new String[] {"code", "conduite"}));
				modif_cours.statut.setSelectedIndex(1);
				modif_cours.statut.setSelectedItem(tab[7]);
				frame.setVisible(true);}
			}});
		Button4.setBounds(597, 366, 111, 62);
		contentPane.add(Button4);
		
		/*---Creation bouton Panel---*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1094, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/*---Creation du label---*/
		
		JLabel lblNewLabel_1 = new JLabel("Gestion De Cours");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 37, 226, 33);
		panel_1.add(lblNewLabel_1);
		
		/*---Creation bouton Acceuil---*/
		
		JButton btnNewButton = new JButton("  Acceuil");
		btnNewButton.setBounds(0, 91, 239, 33);
		contentPane.add(btnNewButton);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil frame = new Accueil();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		});
		btnNewButton.setIconTextGap(10);
		btnNewButton.setIcon(new ImageIcon("image\\img1_1_18x18.png"));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton Candidats---*/
		
		JButton btnNewButton_1 = new JButton("Candidats");
		btnNewButton_1.setBounds(0, 124, 239, 31);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIconTextGap(10);
		btnNewButton_1.setIcon(new ImageIcon("image\\candidat1_25x25.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				candidat frame = new candidat();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		
		/*---Creation du bouton Cours---*/
		
		JButton btnCours = new JButton("Cours");
		btnCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cours frame = new cours();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		});
		btnCours.setBounds(0, 154, 239, 33);
		contentPane.add(btnCours);
		btnCours.setHorizontalAlignment(SwingConstants.LEFT);
		btnCours.setIconTextGap(10);
		btnCours.setIcon(new ImageIcon("image\\cours11_25x25.png"));
		btnCours.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCours.setForeground(Color.WHITE);
		btnCours.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCours.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton Moniteur---*/
		
		JButton btnMoniteurs = new JButton("Moniteurs");
		btnMoniteurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moniteur frame = new Moniteur();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		});
		btnMoniteurs.setBounds(0, 187, 239, 31);
		contentPane.add(btnMoniteurs);
		btnMoniteurs.setHorizontalAlignment(SwingConstants.LEFT);
		btnMoniteurs.setIconTextGap(10);
		btnMoniteurs.setIcon(new ImageIcon("image\\moniteur_1_25x25.png"));
		btnMoniteurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMoniteurs.setForeground(Color.WHITE);
		btnMoniteurs.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnMoniteurs.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton Examen---*/
		
		JButton btnExamens = new JButton("Examens");
		btnExamens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Examens frame = new Examens();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();
			}
		});
		btnExamens.setBounds(0, 217, 239, 31);
		contentPane.add(btnExamens);
		btnExamens.setHorizontalAlignment(SwingConstants.LEFT);
		btnExamens.setIcon(new ImageIcon("image\\examen_25x25.png"));
		btnExamens.setIconTextGap(10);
		btnExamens.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExamens.setForeground(Color.WHITE);
		btnExamens.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnExamens.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton Paiement---*/
		
		JButton btnPaiement = new JButton("Paiement");
		btnPaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paiement frame = new Paiement();
				frame.UpdateTable ();
				frame.paiementTable ();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		});
		btnPaiement.setBounds(0, 273, 239, 33);
		contentPane.add(btnPaiement);
		btnPaiement.setHorizontalAlignment(SwingConstants.LEFT);
		btnPaiement.setIconTextGap(10);
		btnPaiement.setIcon(new ImageIcon("image\\paiement_1_25x25.png"));
		btnPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPaiement.setForeground(Color.WHITE);
		btnPaiement.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPaiement.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton S'incrire---*/
		
		JButton btnRegister = new JButton("Sinscrire");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription frame = new Inscription();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		});
		btnRegister.setBounds(0, 306, 239, 33);
		contentPane.add(btnRegister);
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setIconTextGap(10);
		btnRegister.setIcon(new ImageIcon("image\\register1_25x25.png"));
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRegister.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton Deconexion---*/
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);}
		});
		btnDeconnexion.setBounds(0, 339, 239, 31);
		contentPane.add(btnDeconnexion);
		btnDeconnexion.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeconnexion.setIconTextGap(10);
		btnDeconnexion.setIcon(new ImageIcon("image\\deconnexion_25x25.png"));
		btnDeconnexion.setIgnoreRepaint(true);
		btnDeconnexion.setAutoscrolls(true);
		btnDeconnexion.setLocale(new Locale("aa"));
		btnDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeconnexion.setToolTipText("");
		btnDeconnexion.setForeground(new Color(255, 255, 255));
		btnDeconnexion.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnDeconnexion.setBackground(Color.DARK_GRAY);
		
		/*---Creation du panel---*/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 366, 239, 199);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		/*---Creation du label Statut ---*/
		
		JLabel lblNewLabel = new JLabel("tapez un statut");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(422, 131, 157, 21);
		contentPane.add(lblNewLabel);
		
		/*---Creation du bouton Vehicule---*/
		
		JButton btnVehicules = new JButton(" Vehicules");
		btnVehicules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVehicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehicule frame = new Vehicule();
				frame.UpdateTable();
				frame.setVisible(true);
				fermer();}
		});
		btnVehicules.setIcon(new ImageIcon("image\\vehicule_25x25.png"));
		btnVehicules.setToolTipText("");
		btnVehicules.setLocale(new Locale("aa"));
		btnVehicules.setIgnoreRepaint(true);
		btnVehicules.setIconTextGap(10);
		btnVehicules.setHorizontalAlignment(SwingConstants.LEFT);
		btnVehicules.setForeground(Color.WHITE);
		btnVehicules.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnVehicules.setBackground(Color.DARK_GRAY);
		btnVehicules.setAutoscrolls(true);
		btnVehicules.setBounds(0, 244, 239, 31);
		contentPane.add(btnVehicules);}
	
	
	/*---Methode du Mise A jour du Table---*/
	
	public static void UpdateTable ()
	{
		String sql = "Select * from cours Where statut='code' or statut='conduite' ";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql);
		ResultSet resultat = prepared.executeQuery();
		
		DefaultTableModel model1 = new DefaultTableModel(new String[]{"id", "date","matricule","cin_candidat","cin_moniteur","heure_deb","heure_fin","statut","duree_cours","prix",}, 0);
		table1.setModel(model1);
		 while (resultat.next()) {
		 int a =resultat.getInt("id_cours");
		 Date b =resultat.getDate("date_cours");
		 String c =resultat.getString("matricule_vehicule");
		 int d =resultat.getInt("cin_candidat");
		 int e =resultat.getInt("cin_moniteur");
		 int f =resultat.getInt("heure_deb");
		 int g =resultat.getInt("heure_fin");
		 String h =resultat.getString("statut");
		 int i =resultat.getInt("duree_cours");
		 int j =resultat.getInt("prix");
		 int row = resultat.getRow();
		 model1.addRow(new Object[]{a,b,c,d,e,f, g,h,i,j});
		 table1.setModel(model1);}}
		catch(Exception e) { System.out.println("il y'a une faute"); }
	}
	
	/*--- Methode Selectionner du Table---*/
	
	public static void selectionner1() {
		   int row = table1.getSelectedRow();
			if(row==-1){JOptionPane.showMessageDialog(null, "selectionner une ligne");}
			else {
			    String[] tab3=  new String [10]; 
				String value = table1.getModel().getValueAt(row, 3).toString();
				tab3[0]=value;
			    try {
				    String sql1 = "select * from candidats Where cin_candidat='"+tab3[0]+"'";
				    java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				    PreparedStatement ps=conn.prepareStatement (sql1 );
				    ResultSet rs=ps.executeQuery();
				    DefaultTableModel model2 = new DefaultTableModel(new String[]{"nom", "prenom","etat","date_inscription",}, 0);
				    table3.setModel(model2);
					 while (rs.next()) { 
					         String t1 =rs.getString("nom");
					         String t2 =rs.getString("prenom");
					         String t3 =rs.getString("etat");
					         Date t4 =rs.getDate("date_inscription");
					         model2.addRow(new Object[]{t1,t2,t3,t4});
					         table3.setModel(model2); }
					 		
			    }catch(Exception e4) {
				            System.out.println(e4);}}
	}
	
	/*---Methode Fermer la Fenetre---*/
	
	
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
