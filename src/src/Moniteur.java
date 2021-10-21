package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.EventQueue;
import com.mysql.*;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import net.proteanit.sql.DbUtils;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
public class Moniteur extends JFrame {

	protected static final String Conn = null;
	private static final String DbUtils = null;
	private JPanel contentPane;
	private JTextField txtTapezLeNom;
	public static JTable table;
	static Connection conn =null;
	private JButton btninsertion;
	public static JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	static JTextField textFieldcin;
	static JTextField textFieldnom;
	static JTextField textFieldprenom;
	static JTextField textFielddate_naiss;
	static JTextField textFieldage;
	static JTextField textFieldsexe;
	static JTextField textFieldadresse;
	static JPanel panel;
	public static int a;
	public static	String[] tab;
	private JButton btnrecherche;

	/**
	 * Launch the application.
	 * @return 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Moniteur frame = new Moniteur();
					UpdateTable();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole","root","");
			if (conn!=null)
			  {/*System.out.println("connected");*/}
			else {System.out.println("probleme de connecion");}
			
		
		}
		catch(Exception e) {
			System.out.println("---->SQLException"+ e);
			}
		
		
	}
	

	/**
	 * Create the frame.
	 */
	public Moniteur() {
		
		/*creation du panel principal */
		setBounds( 100,100, 1108, 610);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(245, 222, 179));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(818, 158, 266, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des labels */
		
		lblNewLabel = new JLabel("Cin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 15, 80, 21);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 64, 45, 13);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(23, 102, 77, 13);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Date de naissance");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(23, 163, 115, 13);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(23, 212, 45, 13);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Sexe");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(23, 256, 45, 13);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Adresse");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(23, 296, 57, 13);
		panel.add(lblNewLabel_6);
		
		/*creation des zones de textes */
		
		textFieldcin = new JTextField();
		textFieldcin.setBounds(160, 17, 96, 19);
		panel.add(textFieldcin);
		textFieldcin.setColumns(10);
		
		textFieldnom = new JTextField();
		textFieldnom.setBounds(160, 62, 96, 19);
		panel.add(textFieldnom);
		textFieldnom.setColumns(10);
		
		textFieldprenom = new JTextField();
		textFieldprenom.setBounds(160, 100, 96, 19);
		panel.add(textFieldprenom);
		textFieldprenom.setColumns(10);
		
		textFielddate_naiss = new JTextField();
		textFielddate_naiss.setBounds(160, 161, 96, 19);
		panel.add(textFielddate_naiss);
		textFielddate_naiss.setColumns(10);
		
		textFieldage = new JTextField();
		textFieldage.setBounds(160, 210, 96, 19);
		panel.add(textFieldage);
		textFieldage.setColumns(10);
		
		textFieldsexe = new JTextField();
		textFieldsexe.setBounds(160, 254, 96, 19);
		panel.add(textFieldsexe);
		textFieldsexe.setColumns(10);
		
		textFieldadresse = new JTextField();
		textFieldadresse.setBounds(160, 294, 96, 19);
		panel.add(textFieldadresse);
		textFieldadresse.setColumns(10);
		
		/*creation du label*/
		
		JLabel lblNewLabel_7 = new JLabel("Tapez le nom du moniteur");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7.setBounds(451, 103, 180, 21);
		contentPane.add(lblNewLabel_7);
		
		
		/*espace de recherche */
		
		txtTapezLeNom = new JTextField();
		txtTapezLeNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		txtTapezLeNom.setBounds(451, 133, 149, 21);
		txtTapezLeNom.setToolTipText("");
		txtTapezLeNom.setForeground(new Color(0, 0, 128));
		txtTapezLeNom.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 13));
		contentPane.add(txtTapezLeNom);
		txtTapezLeNom.setColumns(10);
		
	
		/*cretion du table */
		
		 scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(298, 164, 437, 312);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setForeground(Color.BLUE);
		table.getTableHeader().setBackground(Color.lightGray);
		table.getTableHeader().setForeground(Color.white);
		table.setShowVerticalLines(false);
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectionner1();
			}

		});
		 scrollPane_1.setViewportView(table);
		
		/*boutton d'insertion du moniteur */
		 
		btninsertion = new JButton("");
		btninsertion.setIcon(new ImageIcon("image\\new1.png"));
		btninsertion.setBounds(308, 485, 111, 62);
		btninsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nouveau_moniteur frame = new Nouveau_moniteur();
				frame.setVisible(true);
				frame.setResizable(false);
				
			}
		});
		contentPane.add(btninsertion);
		
		/* boutton d'actualisation */
		JButton actualiser = new JButton("");
		actualiser.setIcon(new ImageIcon("image\\liste1.png"));
		actualiser.setBounds(309, 101, 111, 62);
		actualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
				
			}
		});
		contentPane.add(actualiser);
		
		/*boutton de modification */
		
		JButton btnmodifier = new JButton("");
		btnmodifier.setIcon(new ImageIcon("image\\update.png"));
		btnmodifier.setBounds(451, 485, 111, 62);
		btnmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
				
			}});
		contentPane.add(btnmodifier);
		
		/*boutton de suppression */
		JButton btnsupprimer = new JButton("");
		btnsupprimer.setIcon(new ImageIcon("image\\delete1.png"));
		btnsupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleterow();
				}
		});
		btnsupprimer.setBounds(596, 485, 111, 62);
		contentPane.add(btnsupprimer);
		
	    /*boutton de tarif */
		JButton btntarif = new JButton("");
		btntarif.setIcon(new ImageIcon("image\\tarif.png"));
		btntarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payer();
			}});
		btntarif.setBounds(742, 485, 111, 62);
		contentPane.add(btntarif);
		
		/* boutton de recherche */ 
		JButton btnNewButton;
		btnrecherche = new JButton("");
		btnrecherche.setIcon(new ImageIcon("image\\search.png"));
		btnrecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					String requete="select * from moniteurs where nom =?";
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole","root","");
					PreparedStatement ps=conn.prepareStatement(requete);
					ps.setString(1,txtTapezLeNom.getText());
					ResultSet rs=ps.executeQuery();
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e4) 
				{System.out.println(e4);}
				
			}
		});	
		btnrecherche.setBounds(641, 101, 111, 62);
        btnrecherche.setBackground(new Color(220, 220, 220));
		contentPane.add(btnrecherche);
		
		/* panel pour le design */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1094, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/*label de titre de page */
		JLabel lblNewLabel_8 = new JLabel("Gestion De Moniteurs");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(10, 26, 255, 41);
		panel_1.add(lblNewLabel_8);
		
		/*boutton d'accés a la page d'acceuil */
		JButton btnacceuil = new JButton("  Aceuil");
		btnacceuil.setBounds(0, 91, 239, 33);
		contentPane.add(btnacceuil);
		btnacceuil.setHorizontalAlignment(SwingConstants.LEFT);
		btnacceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil frame = new Accueil();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();
			}
		});
		btnacceuil.setIconTextGap(10);
		btnacceuil.setIcon(new ImageIcon("image\\img1_1_18x18.png"));
		btnacceuil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnacceuil.setForeground(Color.WHITE);
		btnacceuil.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		btnacceuil.setBackground(Color.DARK_GRAY);
		
		/*boutton d'accés a la page des candidats */
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
				fermer();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		/*boutton d'accés a la page des cours */
		JButton btnCours = new JButton("Cours");
		btnCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cours frame = new cours();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
			}
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
		
		/*boutton d'accés a la page des moniteurs */
		JButton btnMoniteurs = new JButton("Moniteurs");
		btnMoniteurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moniteur frame = new Moniteur();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();
			}
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
		
		/*boutton d'accés a la page des examens */
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
		
		/*boutton d'accés a la page du paiement */
		JButton btnPaiement = new JButton("Paiement");
		btnPaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paiement frame = new Paiement();
				frame.UpdateTable ();
				frame.paiementTable ();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();
			}
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
		
		/*boutton d'accés a la page d'inscription */
		JButton btnRegister = new JButton("Sinscrire");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription frame = new Inscription();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();
			}
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
		
		/*boutton de deconnexion */
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 366, 239, 207);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		/*boutton d'accés a la page des vehicules */
		JButton btnVehicules = new JButton(" Vehicules");
		btnVehicules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVehicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehicule frame = new Vehicule();
				UpdateTable();
				frame.setVisible(true);
				fermer();
			}
			
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
		
		
	}
	
	
	

	
	/* suppression des moniteurs*/
	
	public void deleterow()
	{
		try
		{
			int row = table.getSelectedRow();
			if (row==-1) {JOptionPane.showMessageDialog(null, "selectionner une ligne !");}
			else {
			String value = table.getModel().getValueAt(row, 0).toString();
			String request="delete from moniteurs where cin_moniteur=?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			PreparedStatement ps =  conn.prepareStatement(request);
			ps.setString(1,value);
			ps.execute();
			JOptionPane.showMessageDialog(null, "moniteur supprimé");
			UpdateTable();
		}}
		catch (Exception e3) { System.out.println(e3); }
	}
	
	/*affichage des coordonnées du moniteur selectionné*/
	public static void selectionner1() {
		
		 int row = table.getSelectedRow();
			
			if(row==-1)
			{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
			else {
			String[] tab3=  new String [10]; 
			for(int i=0;i<1;i++) {
				String value = table.getModel().getValueAt(row, i).toString();
				tab3[i]=value;
			}
			
			try {
				String sql1 = "select * from moniteurs Where cin_moniteur='"+tab3[0]+"'";
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				PreparedStatement ps=conn.prepareStatement (sql1 );
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					String t1=rs.getString("cin_moniteur");
					textFieldcin.setText(t1);
					String t2=rs.getString("nom");
					 textFieldnom.setText(t2);
					String t3=rs.getString("prenom");
					textFieldprenom.setText(t3);
					String t4=rs.getString("date_naiss");
					textFielddate_naiss.setText(t4);
					String t5=rs.getString("age");
					textFieldage.setText(t5);
					String t6=rs.getString("sexe");
					textFieldsexe.setText(t6);
					String t7=rs.getString("adresse");
					textFieldadresse.setText(t7);
					 
					
				}
			}catch(Exception e4) {System.out.println(e4);}
			}
	}
	/* mise a jour du table des moniteurs*/
	public static void UpdateTable ()
	{
		String sql = "Select * from moniteurs";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql);
		ResultSet resultat = prepared.executeQuery();
		DefaultTableModel model = new DefaultTableModel(new String[]{"cin_moniteur", "nom", "prenom","date","age","sexe","adresse",}, 0);
	    while (resultat.next()) {
	     a =resultat.getInt("cin_moniteur");
		 String b =resultat.getString("nom");
		 String c =resultat.getString("prenom");
		 Date d =resultat.getDate("date_naiss");
		 int e =resultat.getInt("age");
		 String f =resultat.getString("sexe");
		 String g =resultat.getString("adresse");
		 int row = resultat.getRow();
		
		 model.addRow(new Object[]{a,b,c,d,e,f, g});
		 table.setModel(model);
		
		}
		}
		catch(Exception e) { System.out.println(e); }
	}
	
	/*modification du moniteur selectionné*/
	public static void modify() 
	{
		int row = table.getSelectedRow();
		
		if(row==-1)
		{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
		else {
		Modif_moniteur frame = new Modif_moniteur();
		String[] tab=  new String [7]; 
		for(int i=0;i<7;i++) {
			String value = table.getModel().getValueAt(row, i).toString();
			tab[i]=value;
		}
		Modif_moniteur.txtcin.setText(tab[0]);
		Modif_moniteur.txtnom.setText(tab[1]);
		Modif_moniteur.txtprenom.setText(tab[2]);
		Modif_moniteur.txtdate.setText(tab[3]);
		Modif_moniteur.txtage.setText(tab[4]);
		Modif_moniteur.txtsexe.setText(tab[5]);
		Modif_moniteur.txtadresse.setText(tab[6]);
		frame.setVisible(true);
		
	}}
	
	/*tarif du moniteur selectionné*/
	public static void payer() 
	{
		int row = table.getSelectedRow();
		if (row==-1) {JOptionPane.showMessageDialog(null, "selectionner une ligne !");}
		else {
		tarif_moniteur frame = new tarif_moniteur();
	    tab=  new String [7]; 
		for(int i=0;i<7;i++) {
			String value = table.getModel().getValueAt(row, i).toString();
			tab[i]=value;
		}
	   	tarif_moniteur.cin_moniteur.setText(String.valueOf(Moniteur.tab[0]));
	   	
		frame.setVisible(true);
		
	}
	}
	
	/*fermeture du fenetre précédente */
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	}

	

