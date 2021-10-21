package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;

public class candidat extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	static JTextField textFieldcin_candidat;
	static JTextField textFieldnom;
	static JTextField textFieldprenom;
	static JTextField textFielddate;
	static JTextField textFieldage;
	static JTextField textFieldepermis;
	static JTextField textFieldnum;
	static JTextField txtcherche;
	static JTextField txtfieldnumero;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					candidat frame = new candidat();
					frame.UpdateTable();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public candidat() {
		
		/*---Creation du Fenetre---*/
		
		setBounds(100, 100, 1108, 610);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---Creation du Panel---*/
		
		JPanel panel = new JPanel();
		panel.setBounds(782, 130, 283, 341);
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel);
		 
		
		/*---Creation du Scroll---*/
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(273, 183, 463, 288);
		contentPane.add(scrollPane_1);
		scrollPane_1.setForeground(Color.WHITE);
		
		/*---Creation du Table---*/
		
		table = new JTable();
		table.setForeground(Color.BLUE);
		table.getTableHeader().setBackground(Color.lightGray);
		table.getTableHeader().setForeground(Color.white);
		table.setBackground(Color.white);
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
				selectionner();}
		});
		scrollPane_1.setViewportView(table);
		
		
	     /*---Creation du Bouton Ajouter Candidat---*/
		
		 JButton btnButton = new JButton("");
		 btnButton.setIcon(new ImageIcon("image\\new1.png"));
		 btnButton.setBounds(297, 481, 111, 62);
			btnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Nouveau_candidat frame = new Nouveau_candidat();
					frame.setVisible(true);
					frame.setResizable(false);
					UpdateTable();}
			});
			contentPane.add(btnButton);
			
			/*---Creation du bouton Listes Candidtas---*/
			
			JButton btnListesCandidats = new JButton("");
			btnListesCandidats.setIcon(new ImageIcon("image\\liste1.png"));
			btnListesCandidats.setBounds(273, 105, 111, 62);
			btnListesCandidats.setForeground(Color.BLUE);
			btnListesCandidats.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnListesCandidats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					UpdateTable();}
			});
			contentPane.add(btnListesCandidats);
			
			/*---Creation du bouton Rechercher ---*/
			
		    JButton Button_2 = new JButton("");
		    Button_2.setIcon(new ImageIcon("image\\search.png"));
		    Button_2.setBounds(625, 105, 111, 62);
		    Button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						String requete="select * from candidats where cin_candidat =?";
						java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						PreparedStatement ps=conn.prepareStatement(requete);
						ps.setString(1,txtcherche.getText());
						ResultSet rs=ps.executeQuery();
						table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					 }catch(Exception e4) {
						System.out.println(e4);}
					try {
						String requete="select * from candidats where cin_candidat =?";
						java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						PreparedStatement ps=conn.prepareStatement(requete);
						ps.setString(1,txtcherche.getText());
						ResultSet rs=ps.executeQuery();
						if(rs.next()) {
							String t1=rs.getString("cin_candidat");
							textFieldcin_candidat.setText(t1);
							String t2=rs.getString("nom");
							textFieldnom.setText(t2);
							String t3=rs.getString("prenom");
							textFieldprenom.setText(t3);
							String t4=rs.getString("date_naissance");
							textFielddate.setText(t4);
							String t5=rs.getString("age");
							textFieldage.setText(t5);
							String t6=rs.getString("permis");
							textFieldepermis.setText(t6);
							String t7=rs.getString("numero");
							txtfieldnumero.setText(t7);}
					}catch(Exception e4) {
						System.out.println(e4);}
				   }
			     });
			contentPane.add(Button_2);
		
	        /*---Creation du bouton Supprimer---*/
			
	        JButton btnSuppression = new JButton("");
	        btnSuppression.setIcon(new ImageIcon("image\\delete1.png"));
	        btnSuppression.setBounds(436, 481, 111, 62);
	        btnSuppression.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			try
			{
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				String request="delete from candidats where cin_candidat=?";
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				PreparedStatement ps =  conn.prepareStatement(request);
				ps.setString(1,value);
				ps.execute();
				JOptionPane.showMessageDialog(null, "supprimé avec succés");
				UpdateTable();}
			catch (Exception e3) { System.out.println(e3); }}	
	       });
	        contentPane.add(btnSuppression);
	        
	        /*---Creation du Zone de recherche---*/
	        
	        txtcherche = new JTextField();
	        txtcherche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	        txtcherche.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
	        txtcherche.setBounds(392, 124, 225, 36);
	        contentPane.add(txtcherche);
	        txtcherche.setColumns(10);
	        //-----------
	        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Infos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25, 112)));
	        contentPane.add(panel);
	        panel.setLayout(null);
	        panel.setLayout(null);
	        
	       /*---label du cin du candidat---*/
	        
	       JLabel lblNewLabel = new JLabel("Cin du candidat");
	       lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
           lblNewLabel.setBounds(6, 16, 109, 16);
	       panel.add(lblNewLabel);
	       /*---label du Nom---*/
	       
	       JLabel lblNewLabel_1 = new JLabel("Nom");
	       lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	       lblNewLabel_1.setBounds(6, 61, 77, 21);
	       panel.add(lblNewLabel_1);
	       
	       /*---label du Prenom---*/
	       
	       JLabel lblNewLabel_2 = new JLabel("Prenom");
	       lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	       lblNewLabel_2.setBounds(6, 102, 77, 21);
	       panel.add(lblNewLabel_2);
	       /*---label du date de naissance---*/
	       
	       JLabel lblNewLabel_3 = new JLabel("Date de naissance");
	       lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	       lblNewLabel_3.setBounds(6, 156, 122, 21);
	       panel.add(lblNewLabel_3);
	       
	       /*---label du Age---*/
	       
	       JLabel lblNewLabel_4 = new JLabel("Age");
	       lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	       lblNewLabel_4.setBounds(6, 200, 66, 21);
	       panel.add(lblNewLabel_4);
           
	       /*---label du Permis---*/
	       
	       JLabel lblNewLabel_5 = new JLabel("Permis");
	       lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	       lblNewLabel_5.setBounds(6, 246, 66, 16);
	       panel.add(lblNewLabel_5);
	       
	       /*---Creation du zone de saisie de cin_candidat---*/
	       
	       textFieldcin_candidat= new JTextField();
	       textFieldcin_candidat.setBounds(155, 16, 96, 19);
	       panel.add(textFieldcin_candidat);
	       textFieldcin_candidat.setColumns(10);
	
	       /*---Creation du zone de saisie de nom---*/
	       
	       textFieldnom = new JTextField();
	       textFieldnom.setBounds(155, 63, 96, 19);
	       panel.add(textFieldnom);
	       textFieldnom.setColumns(10);
	
	       /*---Creation du zone de saisie de prenom---*/
	       textFieldprenom = new JTextField();
	       textFieldprenom.setBounds(155, 104, 96, 19);
	       panel.add(textFieldprenom);
	       textFieldprenom.setColumns(10);
	       
	       /*---Creation du zone de saisie de date---*/
	       
	       textFielddate = new JTextField();
	       textFielddate.setBounds(155, 158, 96, 19);
	       panel.add( textFielddate);
	       textFielddate.setColumns(10);
	       /*---Creation du zone de saisie d'age ---*/
	       
	       textFieldage = new JTextField();
	       textFieldage.setBounds(155, 202, 96, 19);
	       panel.add(textFieldage);
	       textFieldage.setColumns(10);
	       
	       /*---Creation du zone de saisie de Permis---*/
	       
	       textFieldepermis = new JTextField();
	       textFieldepermis.setBounds(155, 246, 96, 19);
	       panel.add(textFieldepermis);
	       textFieldepermis.setColumns(10);
	       
	       /*---label Telephone---*/
	       
	       JLabel lblNewLabel_6 = new JLabel("T\u00E9l\u00E9phone");
	       lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	       lblNewLabel_6.setBounds(6, 283, 109, 16);
	       panel.add(lblNewLabel_6);
	       
	       /*---Creation du zone de saisie de Numero---*/
	       
	       txtfieldnumero = new JTextField();
	       txtfieldnumero.setBounds(155, 283, 96, 19);
	       panel.add(txtfieldnumero);
	       txtfieldnumero.setColumns(10);
	       
	       /*---Creation du bouton Aceeuil---*/
	       
	       JButton btnaccueil = new JButton("  Aceuil");
	       btnaccueil.setBounds(0, 93, 239, 31);
	       contentPane.add(btnaccueil);
	       btnaccueil.setHorizontalAlignment(SwingConstants.LEFT);
	       btnaccueil.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
			Accueil frame = new Accueil();
			frame.setVisible(true);
			frame.setResizable(false);
			fermer();}
	      });
	       btnaccueil.setIconTextGap(10);
	       btnaccueil.setIcon(new ImageIcon("image\\img1_1_18x18.png"));
	       btnaccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	       btnaccueil.setForeground(Color.WHITE);
	       btnaccueil.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
	       btnaccueil.setBackground(Color.DARK_GRAY);
	       
	       /*---Creation du bouton Candidat---*/
	       
	       JButton btncandidats = new JButton("Candidats");
	       btncandidats.setBounds(0, 124, 239, 31);
	       contentPane.add(btncandidats);
	       btncandidats.setHorizontalAlignment(SwingConstants.LEFT);
	       btncandidats.setIconTextGap(10);
	       btncandidats.setIcon(new ImageIcon("image\\candidat1_25x25.png"));
	       btncandidats.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			candidat frame = new candidat();
			frame.UpdateTable();
			frame.setVisible(true);
			frame.setResizable(false);
			fermer();}
	       });
	       btncandidats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	       btncandidats.setForeground(Color.WHITE);
	       btncandidats.setBackground(Color.DARK_GRAY);
	       btncandidats.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
	       
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
	       
	       /*---Creation du bouton Vehicule---*/
	       
	       JButton btnVehicules = new JButton(" Vehicules");
	       btnVehicules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	       btnVehicules.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
			        Vehicule frame = new Vehicule();
			        UpdateTable();
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
	       btnPaiement.setBounds(0, 273, 239, 31);
	       contentPane.add(btnPaiement);
	       btnPaiement.setHorizontalAlignment(SwingConstants.LEFT);
	       btnPaiement.setIconTextGap(10);
	       btnPaiement.setIcon(new ImageIcon("image\\paiement_1_25x25.png"));
	       btnPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	       btnPaiement.setForeground(Color.WHITE);
	       btnPaiement.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
	       btnPaiement.setBackground(Color.DARK_GRAY);
	       
	       /*---Creation du bouton Inscrit---*/
	       
	       JButton btnRegister = new JButton("S'inscrire");
	       btnRegister.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
			         Inscription frame = new Inscription();
			         frame.setVisible(true);
			         frame.setResizable(false);
			         fermer();}
	           });
	       btnRegister.setBounds(0, 304, 239, 31);
	       contentPane.add(btnRegister);
	       btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
 	       btnRegister.setIconTextGap(10);
	       btnRegister.setIcon(new ImageIcon("image\\register1_25x25.png"));
	       btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	       btnRegister.setForeground(Color.WHITE);
	       btnRegister.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
	       btnRegister.setBackground(Color.DARK_GRAY);
           
	       /*---Deconnexion---*/
	        
 	       JButton btnDeconnexion = new JButton("Deconnexion");
	       btnDeconnexion.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   System.exit(0);}
	       });
	       btnDeconnexion.setBounds(0, 335, 239, 31);
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
	  
	       /*---Panel---*/
	       
	       JPanel panel_1 = new JPanel();
	       panel_1.setBounds(0, 0, 1101, 93);
	       panel_1.setBackground(Color.DARK_GRAY);
	       contentPane.add(panel_1);
	       panel_1.setLayout(null);
	       
	       /*---label Candidat---*/
	       
	       JLabel lblNewLabel_8 = new JLabel("Gestion des \r\n Candidats");
	       lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
	       lblNewLabel_8.setForeground(new Color(255, 255, 255));
	       lblNewLabel_8.setBounds(8, 24, 264, 38);
	       panel_1.add(lblNewLabel_8);

	       /*---Creation de JPanel---*/
	       
	       JPanel panel_2 = new JPanel();
	       panel_2.setBounds(0, 365, 239, 198);
	       panel_2.setBackground(Color.DARK_GRAY);
	       contentPane.add(panel_2);
	       
	       /*---label Cin Candidat---*/
	       
	       JLabel lblNewLabel_7 = new JLabel("Taper le cin candidat");
	       lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
	       lblNewLabel_7.setBounds(399, 105, 199, 13);
	       contentPane.add(lblNewLabel_7);
	
	       JButton btnNewButton_2 = new JButton("New button");
	       btnNewButton_2.setIcon(new ImageIcon("image\\update.png"));
	       btnNewButton_2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
			      modify();}
	       });
	       btnNewButton_2.setBounds(595, 481, 111, 62);
	       contentPane.add(btnNewButton_2);
	       }
	
	/*---Methode Selectionner la Table---*/
	
	 public static void selectionner() {
		    int row = table.getSelectedRow();
			if(row==-1)
			{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
			else {
			String[] tab3=  new String [10]; 
			for(int i=0;i<1;i++) {
				String value = table.getModel().getValueAt(row, i).toString();
				tab3[i]=value;}
			
			try {
				String sql1 = "select * from candidats Where cin_candidat='"+tab3[0]+"'";
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				PreparedStatement ps=conn.prepareStatement (sql1 );
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					String t1=rs.getString("cin_candidat");
					textFieldcin_candidat.setText(t1);
					String t2=rs.getString("nom");
					textFieldnom.setText(t2);
					String t3=rs.getString("prenom");
					textFieldprenom.setText(t3);
					String t4=rs.getString("date_naissance");
					textFielddate.setText(t4);
					String t5=rs.getString("age");
					textFieldage.setText(t5);
					String t6=rs.getString("permis");
					textFieldepermis.setText(t6);
					String t7=rs.getString("numero");
					txtfieldnumero.setText(t7);}
			}catch(Exception e4) {
				System.out.println(e4);}}
	        }
	 
	 /*---Mise A jour du Table---*/
	 
    public static void UpdateTable ()
	   {
		String sql = "Select * from candidats";
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		 PreparedStatement prepared =  conn.prepareStatement(sql);
		 ResultSet resultat = prepared.executeQuery();
		 DefaultTableModel model = new DefaultTableModel(new String[]{"cin_candidat", "nom","prenom","date_naissance","age","numero","permis","etat",}, 0);
		 table.setModel(model);
		 while (resultat.next()) {
		 int a =resultat.getInt("cin_candidat");
		 String b =resultat.getString("nom");
		 String c =resultat.getString("prenom");
		 String d =resultat.getString("date_naissance");
		 String e =resultat.getString("age");
		 int f =resultat.getInt("numero");
		 String g =resultat.getString("permis");
		 String h =resultat.getString("etat");
		 int row = resultat.getRow();
		 model.addRow(new Object[]{a,b,c,d,e,f,g,h});
		 table.setModel(model);}}
		catch(Exception e) { System.out.println(e); }
	  }
	
    /*---Modifier la Table---*/
    
	public static void modify() 
	{
		int row = table.getSelectedRow();
		if(row==-1)
		{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
		else {
        Modif_candidat frame = new Modif_candidat();
		String[] tab=  new String [7]; 
		for(int i=0;i<1;i++) {
			String value = table.getModel().getValueAt(row, i).toString();
			tab[i]=value;
		}
		try {
		String sql4 = "Select * from candidats Where cin_candidat='"+tab[0]+"'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
	    PreparedStatement prepared =  conn.prepareStatement(sql4);
	    ResultSet resultat2 = prepared.executeQuery();
		if(resultat2.next()) {
			String t1=resultat2.getString("cin_candidat");
			Modif_candidat.cin_candidat1.setText(t1);
			String t2=resultat2.getString("nom");
			Modif_candidat.nom1.setText(t2);
			String t3=resultat2.getString("prenom");
			Modif_candidat.prenom1.setText(t3);
			Date t4=resultat2.getDate("date_naissance");
			Modif_candidat.date_naiss1.setDate(t4);
			String t5=resultat2.getString("age");
			Modif_candidat.age1.setText(t5);
			String t6=resultat2.getString("sexe");
			Modif_candidat.sexe1.setText(t6);
			String t7=resultat2.getString("numero");
			Modif_candidat.numero1.setText(t7);
			String t8=resultat2.getString("gmail");
			Modif_candidat.gmail1.setText(t8);
			String t9=resultat2.getString("etat");
			Modif_candidat.etat1.setText(t9);
			String t10=resultat2.getString("permis");
			Modif_candidat.permis1.setText(t10);
			Date t11=resultat2.getDate("date_inscription");
			Modif_candidat.date_inscription1.setDate(t11);	}}
		
		catch(Exception e1) { System.out.println(e1); }
		frame.setVisible(true);
	  }}
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}

	

