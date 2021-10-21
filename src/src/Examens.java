package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;

public class Examens extends JFrame {

	
	private JPanel contentPane;
	private static JTable table1;
	private JTextField textField;
	private static JTable table3;
	public static int tab1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examens frame = new Examens();
					UpdateTable();
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
	public Examens() {
		
		/*---Creation du Fenetre---*/
		
		    setBounds(100, 100,1108, 610);
		    contentPane = new JPanel();
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(null);
		    contentPane.setLayout(null);
		 
	        /*---Creation du bouton Acceuil---*/
		    
		    JButton btnNewButton1 = new JButton("  Acceuil");
			btnNewButton1.setBounds(0, 93, 239, 31);
			contentPane.add(btnNewButton1);
			btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Accueil frame = new Accueil();
					frame.setVisible(true);
					frame.setResizable(false);
					fermer();}
			   });
			btnNewButton1.setIconTextGap(10);
			btnNewButton1.setIcon(new ImageIcon("image\\img1_1_18x18.png"));
			btnNewButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton1.setForeground(Color.WHITE);
			btnNewButton1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			btnNewButton1.setBackground(Color.DARK_GRAY);
			
			/*---Creation du bouton Candidat---*/
			
			JButton btnNewButton2 = new JButton("Candidats");
			btnNewButton2.setBounds(0, 124, 239, 31);
			contentPane.add(btnNewButton2);
			btnNewButton2.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton2.setIconTextGap(10);
			btnNewButton2.setIcon(new ImageIcon("image\\candidat1_25x25.png"));
			btnNewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					candidat frame = new candidat();
					frame.UpdateTable();
					frame.setVisible(true);
					frame.setResizable(false);
					fermer();}
			  });
			btnNewButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton2.setForeground(Color.WHITE);
			btnNewButton2.setBackground(Color.DARK_GRAY);
			btnNewButton2.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
			
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
			btnCours.setBounds(0, 156, 239, 31);
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
					fermer();}
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
			
			/*---Creation du bouton Vehicules---*/
			
			JButton btnVehicules = new JButton(" Vehicules");
			btnVehicules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVehicules.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Vehicule frame = new Vehicule();
					frame.UpdateTable();
					frame.setVisible(true);
					frame.setResizable(false);
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
			contentPane.add(btnVehicules);
			
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
			btnPaiement.setBounds(0, 275, 239, 31);
			contentPane.add(btnPaiement);
			btnPaiement.setHorizontalAlignment(SwingConstants.LEFT);
			btnPaiement.setIconTextGap(10);
			btnPaiement.setIcon(new ImageIcon("image\\paiement_1_25x25.png"));
			btnPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPaiement.setForeground(Color.WHITE);
			btnPaiement.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
			btnPaiement.setBackground(Color.DARK_GRAY);
			
			
			/*---Creation du bouton S'incrire---*/
			
			JButton btnRegister = new JButton("S'inscrire");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Inscription frame = new Inscription();
					frame.setVisible(true);
					frame.setResizable(false);
					fermer();}
			   });
			btnRegister.setBounds(0, 305, 239, 31);
			contentPane.add(btnRegister);
			btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
			btnRegister.setIconTextGap(10);
			btnRegister.setIcon(new ImageIcon("image\\register1_25x25.png"));
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setForeground(Color.WHITE);
			btnRegister.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
			btnRegister.setBackground(Color.DARK_GRAY);
			
			/*---Creation du bouton Deconnexion---*/
			
			JButton btnDeconnexion = new JButton("Deconnexion");
			btnDeconnexion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);}
			  });
			btnDeconnexion.setBounds(0, 336, 239, 31);
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
			
			/*---Creation du JPanel---*/
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 0, 1101, 93);
			panel_1.setBackground(Color.DARK_GRAY);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			/*---Label 'Creation des Examens'---*/
			
			JLabel lblNewLabel_8 = new JLabel("Gestion des Examens");
			lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel_8.setForeground(new Color(255, 255, 255));
			lblNewLabel_8.setBounds(8, 24, 264, 38);
			panel_1.add(lblNewLabel_8);

			/*---Creation du JPanel---*/
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(0, 365, 239, 198);
			panel_2.setBackground(Color.DARK_GRAY);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			/*---Creation du bouton Modifier cours---*/ 
			
		    JButton btnNewButton = new JButton("");
		    btnNewButton.setIcon(new ImageIcon("image\\new1.png"));
		    btnNewButton.setBounds(329, 336,111, 62);
		    btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				planifier_cours frame = new planifier_cours();
				frame.setVisible(true);}
		     });
		    contentPane.add(btnNewButton);
		    
		/*---Creation du bouton Supprimer---*/
		    
		    JButton btnSuppression = new JButton("");
		    btnSuppression.setIcon(new ImageIcon("image\\delete1.png"));
		    btnSuppression.setBounds(523, 336, 111, 62);
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
					JOptionPane.showMessageDialog(null, "examen supprimé");
					UpdateTable();
				}}
				catch (Exception e3) { System.out.println("Il y'a une faute "); }}
		     });
		    contentPane.add(btnSuppression);
		    
		    /*---Creation du bouton Liste des Examens---*/
		    
		    JButton btnNewButton_1 = new JButton("");
		    btnNewButton_1.setIcon(new ImageIcon("image\\liste1.png"));
		    btnNewButton_1.setBounds(261, 103,111, 62);
		    btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();}
		    });
		    contentPane.add(btnNewButton_1);
		    
		    
		    /*---Zone de saisie du recherche ---*/
		    
		    JTextField txtrecherche = new JTextField();
		    txtrecherche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		    txtrecherche.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		    txtrecherche.setBounds(380, 122, 193, 36);
		    contentPane.add(txtrecherche);
		    txtrecherche.setColumns(10);
		    
		    /*---Creation du JPanel---*/
		    
		    JPanel panel = new JPanel();
		    panel.setForeground(new Color(0, 0, 128));
		    panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "listes_candidats", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		    panel.setBounds(245, 407, 678, 125);
		    contentPane.add(panel);
		    panel.setLayout(null);
		
		    /*---Creation du JScrollPane---*/
		    
		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setBounds(8, 21, 662, 94);
		    panel.add(scrollPane);
	        
		    /*--Creation du Table--*/
		    
		    table3 = new JTable();
		    scrollPane.setViewportView(table3);
		
		
		    /*---Creation du bouton Recherche ---*/
		    
		    
		    JButton btnNewButton_2 = new JButton("");
		    btnNewButton_2.setIcon(new ImageIcon("image\\search.png"));
		    btnNewButton_2.setBounds(581, 103, 111, 62);
		    btnNewButton_2.addActionListener(new ActionListener() {
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
					System.out.println(e4);}
				}});
		    contentPane.add(btnNewButton_2);
		    
		    
		    /*---Creation du bouton Modifier---*/
		    
		    JButton btnNewButton_3 = new JButton("");
		    btnNewButton_3.setIcon(new ImageIcon("image\\update.png"));
		    btnNewButton_3.addActionListener(new ActionListener() {
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
				modif_cours.id_cours=Integer.parseInt(tab[0]);
				modif_cours.date_cours.setText(tab[1]);
				modif_cours.matricule_vehicule.setText(tab[2]);
				modif_cours.cin_candidat.setText(tab[3]);
				modif_cours.cin_moniteur.setText(tab[4]);
				modif_cours.heure_deb.setText(tab[5]);
				modif_cours.heure_fin.setText(tab[6]);
				modif_cours.prix.setText(tab[9]);
				modif_cours.statut.setModel(new DefaultComboBoxModel(new String[] {"examen code", "examen conduite"}));
				modif_cours.statut.setSelectedIndex(1);
				modif_cours.statut.setSelectedItem(tab[7]);
				frame.setVisible(true);
			}
			}});
		btnNewButton_3.setBounds(698, 336, 111, 62);
		contentPane.add(btnNewButton_3);
		
		
		//--------------------------------------------
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(261, 195, 833, 131);
		 contentPane.add(scrollPane_1);
		 scrollPane_1.setForeground(new Color(0, 0, 255));
		 scrollPane_1.setBackground(new Color(255, 255, 255));
		 scrollPane_1.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		 
		 /*---Creation du Table ---*/
		 
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
		 table1.setShowVerticalLines(false);
		 scrollPane_1.setViewportView(table1);}
	
	
	//-------------------------------------------
	
	public static void UpdateTable ()
	{
		String sql = "Select * from cours Where statut='examen code' or statut='examen conduite' ";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql);
		ResultSet resultat = prepared.executeQuery();
		
		DefaultTableModel model1 = new DefaultTableModel(new String[]{"id", "date","matricule","cin_candidat","cin_moniteur","heure_deb","heure_fin","statut","duree_cours","prix",}, 0);
		DefaultTableModel model2=new DefaultTableModel(new String[]{"id", "date","matricule","cin_candidat","cin_moniteur","heure_deb","heure_fin","statut","duree_cours","prix",}, 0) ;
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
		 model2.addRow(new Object[]{a,b,c,d,e,f, g,h,i,j});
		 model1.addRow(new Object[]{a,b,c,d,e,f, g,h,i,j});
		 table1.setModel(model1);}}
		catch(Exception e) { System.out.println(e); }
	     }
	//----------------------------------------
	
	public static void selectionner1() {
		
		 int row = table1.getSelectedRow();
			if(row==-1)
			{JOptionPane.showMessageDialog(null, "selectionner une ligne !");}
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
					 table3.setModel(model2);}}
			
			   catch(Exception e4) {System.out.println(e4);}}
	      }
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);}}

	
		


