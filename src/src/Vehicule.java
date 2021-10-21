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
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
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
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Vehicule extends JFrame {

	private JPanel contentPane;
	private static JTable table;
  static JTextField txtrecherche;
  static JTextField textFieldnumero;
  static JTextField textFieldmatricule;
  static JTextField textFieldtype;
  static JTextField textFieldmarque;
  static JTextField textFieldcouleur;
  static JTextField textFieldetat;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicule frame = new Vehicule();
					frame.UpdateTable();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Vehicule() {
		
		/*creation du panel principal */
		setBounds(100, 100, 1108, 610);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		/*zone de recherche */
		JLabel lblNewLabel_7 = new JLabel("Taper le numero du vehicule");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_7.setBounds(399, 105, 199, 13);
		contentPane.add(lblNewLabel_7);
		
		
		/*creation du table */
		JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(273, 175, 463, 288);
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
				selectionner();
			}

		});
		scrollPane_1.setViewportView(table);
		
		
		 /*boutton d'ajout de vehicule */
		 JButton btnNewButton = new JButton("");
		 btnNewButton.setIcon(new ImageIcon("image\\new1.png"));
			btnNewButton.setBounds(328, 501, 111, 62);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Nouveau_vehicule frame = new Nouveau_vehicule();
					frame.setVisible(true);
					frame.setResizable(false);
				}
			});
			contentPane.add(btnNewButton);
			
			/* boutton d'acces a la liste des vehicules */
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("image\\liste1.png"));
			btnNewButton_1.setForeground(Color.BLUE);
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnNewButton_1.setBounds(273, 103, 111, 62);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateTable();
				}
			});
			contentPane.add(btnNewButton_1);
			
			/* boutton de recherche  */
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setIcon(new ImageIcon("image\\search.png"));
			btnNewButton_2.setBounds(625, 103, 111, 62);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String requete="select * from vehicule where numero =?";
						java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						PreparedStatement ps=conn.prepareStatement(requete);
						ps.setString(1,txtrecherche.getText());
						ResultSet rs=ps.executeQuery();
						table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					}catch(Exception e4) {
						System.out.println(e4);
				}
					try {
						String requete="select * from vehicule where numero =?";
						java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						PreparedStatement ps=conn.prepareStatement(requete);
						ps.setString(1,txtrecherche.getText());
						ResultSet rs=ps.executeQuery();
						//table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
						if(rs.next()) {
							String t1=rs.getString("numero");
							textFieldnumero.setText(t1);
							String t2=rs.getString("matricule");
							textFieldmatricule.setText(t2);
							String t3=rs.getString("type");
							textFieldtype.setText(t3);
							String t4=rs.getString("marque");
							textFieldmarque.setText(t4);
							String t5=rs.getString("couleur");
							textFieldcouleur.setText(t5);
							String t6=rs.getString("etat");
							textFieldetat.setText(t6);
							
						}
					}catch(Exception e4) {
						System.out.println(e4);
				}
				}
			});
			contentPane.add(btnNewButton_2);
		
	/*boutton de suppression du vehicule selectionné */
	JButton btnSuppression = new JButton("");
	btnSuppression.setIcon(new ImageIcon("image\\delete1.png"));
	btnSuppression.setBounds(547, 501, 111, 62);
	btnSuppression.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try
			{
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				String request="delete from vehicule where numero=?";
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				PreparedStatement ps =  conn.prepareStatement(request);
				ps.setString(1,value);
				ps.execute();
				JOptionPane.showMessageDialog(null, "vehicule supprimé");
				UpdateTable();
			}
			catch (Exception e3) { JOptionPane.showMessageDialog(null, "Selectionner une ligne"); }
		}
		
		
		
	});
	contentPane.add(btnSuppression);
	
	/* zone de recherche */
	txtrecherche = new JTextField();
	txtrecherche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	txtrecherche.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
	txtrecherche.setBounds(392, 128, 225, 36);
	contentPane.add(txtrecherche);
	txtrecherche.setColumns(10);
	
	/*panel pour le design */
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Infos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
	panel.setBounds(777, 127, 283, 341);
	contentPane.add(panel);
	panel.setLayout(null);
	
	/*creation des labels */
	JLabel lblNewLabel = new JLabel("Numero");
	lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	lblNewLabel.setBounds(6, 16, 77, 16);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Matricule");
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(6, 61, 77, 21);
	panel.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Type");
	lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	lblNewLabel_2.setBounds(6, 102, 77, 21);
	panel.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Marque");
	lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	lblNewLabel_3.setBounds(6, 156, 53, 21);
	panel.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Couleur");
	lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	lblNewLabel_4.setBounds(6, 200, 66, 21);
	panel.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Etat");
	lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	lblNewLabel_5.setBounds(6, 246, 66, 16);
	panel.add(lblNewLabel_5);
	
	/*creation des zones de textes */
	textFieldnumero = new JTextField();
	textFieldnumero.setBounds(104, 15, 96, 19);
	panel.add(textFieldnumero);
	textFieldnumero.setColumns(10);
	
	textFieldmatricule = new JTextField();
	textFieldmatricule.setBounds(104, 62, 96, 19);
	panel.add(textFieldmatricule);
	textFieldmatricule.setColumns(10);
	
	textFieldtype = new JTextField();
	textFieldtype.setBounds(104, 103, 96, 19);
	panel.add(textFieldtype);
	textFieldtype.setColumns(10);
	
	textFieldmarque = new JTextField();
	textFieldmarque.setBounds(104, 157, 96, 19);
	panel.add(textFieldmarque);
	textFieldmarque.setColumns(10);
	
	textFieldcouleur = new JTextField();
	textFieldcouleur.setBounds(104, 201, 96, 19);
	panel.add(textFieldcouleur);
	textFieldcouleur.setColumns(10);
	
	textFieldetat = new JTextField();
	textFieldetat.setBounds(104, 245, 96, 19);
	panel.add(textFieldetat);
	textFieldetat.setColumns(10);
	
	/*boutton d'acces a la page d'acceuil */
	JButton btnNewButton1 = new JButton("  Acceuil");
	btnNewButton1.setBounds(0, 93, 239, 31);
	contentPane.add(btnNewButton1);
	btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
	btnNewButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Accueil frame = new Accueil();
			frame.setVisible(true);
			frame.setResizable(false);
			fermer();
		}
	});
	btnNewButton1.setIconTextGap(10);
	btnNewButton1.setIcon(new ImageIcon("image\\img1_1_18x18.png"));
	btnNewButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnNewButton1.setForeground(Color.WHITE);
	btnNewButton1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
	btnNewButton1.setBackground(Color.DARK_GRAY);
	
	/*boutton d'acces a la page des candidats */
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
			fermer();
		}
	});
	btnNewButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnNewButton2.setForeground(Color.WHITE);
	btnNewButton2.setBackground(Color.DARK_GRAY);
	btnNewButton2.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
	
	/*boutton d'acces a la page des cours */
	JButton btnCours = new JButton("Cours");
	btnCours.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cours frame = new cours();
			frame.UpdateTable();
			frame.setVisible(true);
			frame.setResizable(false);
			fermer();
		}
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
	
	/*boutton d'acces a la page des moniteurs */
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
	
	/*boutton d'acces a la page des examens */
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
	
	/*boutton d'acces a la page des vehicules */
	JButton btnVehicules = new JButton(" Vehicules");
	btnVehicules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnVehicules.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Vehicule frame = new Vehicule();
			UpdateTable();
			frame.setVisible(true);
			frame.setResizable(false);
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
	
	/*boutton d'acces a la page des paiements */
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
	btnPaiement.setBounds(0, 275, 239, 31);
	contentPane.add(btnPaiement);
	btnPaiement.setHorizontalAlignment(SwingConstants.LEFT);
	btnPaiement.setIconTextGap(10);
	btnPaiement.setIcon(new ImageIcon("image\\paiement_1_25x25.png"));
	btnPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnPaiement.setForeground(Color.WHITE);
	btnPaiement.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
	btnPaiement.setBackground(Color.DARK_GRAY);
	
	/*boutton d'acces a la page d'inscription */
	JButton btnRegister = new JButton("S'inscrire");
	btnRegister.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Inscription frame = new Inscription();
			frame.setVisible(true);
			frame.setResizable(false);
			fermer();
		}
	});
	btnRegister.setBounds(0, 306, 239, 31);
	contentPane.add(btnRegister);
	btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
	btnRegister.setIconTextGap(10);
	btnRegister.setIcon(new ImageIcon("image\\register1_25x25.png"));
	btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnRegister.setForeground(Color.WHITE);
	btnRegister.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
	btnRegister.setBackground(Color.DARK_GRAY);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(0, 0, 1101, 93);
	panel_1.setBackground(Color.DARK_GRAY);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
	/*label de titre de page */
	JLabel lblNewLabel_8 = new JLabel("Gestion des Vehicules");
	lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
	lblNewLabel_8.setForeground(new Color(255, 255, 255));
	lblNewLabel_8.setBounds(8, 24, 264, 38);
	panel_1.add(lblNewLabel_8);

	
	JPanel panel_2 = new JPanel();
	panel_2.setBounds(0, 336, 239, 227);
	panel_2.setBackground(Color.DARK_GRAY);
	contentPane.add(panel_2);
	panel_2.setLayout(null);
	
	/*boutton de deconnexion */
	JButton btnDeconnexion = new JButton("Deconnexion");
	btnDeconnexion.setBounds(0, 0, 239, 31);
	panel_2.add(btnDeconnexion);
	btnDeconnexion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
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
	}
	
	/*affichage de la liste des vehicules */
	public static void UpdateTable ()
	{
		String sql = "Select * from vehicule";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql);
		ResultSet resultat = prepared.executeQuery();
		DefaultTableModel model = new DefaultTableModel(new String[]{"numero", "matricule","type","marque","couleur","etat",}, 0);
		table.setModel(model);
		
		 while (resultat.next()) {
		 int a =resultat.getInt("numero");
		 String b =resultat.getString("matricule");
		 String c =resultat.getString("type");
		 String d =resultat.getString("marque");
		 String e =resultat.getString("couleur");
		 String f =resultat.getString("etat");
		 int row = resultat.getRow();
		
		 model.addRow(new Object[]{a,b,c,d,e,f});
		 table.setModel(model);
		
		}
		}
		catch(Exception e) { System.out.println(e); }
	}
  
	
	/*modification des coordonnées des vehicules */
	public static void selectionner() {
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
				String sql1 = "select * from vehicule Where numero='"+tab3[0]+"'";
				java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				PreparedStatement ps=conn.prepareStatement (sql1 );
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					String t1=rs.getString("numero");
					textFieldnumero.setText(t1);
					String t2=rs.getString("matricule");
					textFieldmatricule.setText(t2);
					String t3=rs.getString("type");
					textFieldtype.setText(t3);
					String t4=rs.getString("marque");
					textFieldmarque.setText(t4);
					String t5=rs.getString("couleur");
					textFieldcouleur.setText(t5);
					String t6=rs.getString("etat");
					textFieldetat.setText(t6);
					
					
				}
			}catch(Exception e4) {
				System.out.println(e4);
		}}
	}
	/*fermeture du fenetre précédente */
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

}

	

