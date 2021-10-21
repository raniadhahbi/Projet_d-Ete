package src;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.border.BevelBorder;

public class Paiement extends JFrame {

	 JPanel contentPane;
	 static JTable table;
     static JTable table_1;
	static JTextField permis;
	 static JTextField examen_total;
	static JTextField heure_totale;
	 static JTextField montant_total;
	static  JTextField montant_deja_payer;
	static JTextField reste;
	static String[] tab3;
	static int p5;
	static JLabel   nbr_examen_conduite;
	static JLabel     nbr_examen_code;
	static JLabel    nbr_conduite;
	static JLabel   nbr_code;
	static JLabel    prix_ex_conduite;
	static JLabel    prix_ex_code;
	static JLabel    prix_ex_total;
	static JLabel    prix_conduite;
	static JLabel    prix_code;
	static JLabel    prix_total;
	static JLabel cin;
	static JLabel nom;
	static JLabel prenom;
	static JLabel age;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paiement frame = new Paiement();
					UpdateTable ();
					paiementTable ();
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
	public Paiement() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1329, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listes des candidats", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(247, 94, 460, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1315, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Gestion De Paiements");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(10, 29, 270, 41);
		panel_1.add(lblNewLabel_7);
		JButton btnacceuil = new JButton("Aceuil");
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
		btnCours.setBounds(0, 154, 239, 33);
		contentPane.add(btnCours);
		btnCours.setHorizontalAlignment(SwingConstants.LEFT);
		btnCours.setIconTextGap(10);
		btnCours.setIcon(new ImageIcon("image\\cours11_25x25.png"));
		btnCours.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCours.setForeground(Color.WHITE);
		btnCours.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCours.setBackground(Color.DARK_GRAY);
		
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
		panel_2.setBounds(0, 366, 239, 267);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnVehicules = new JButton(" Vehicules");
		btnVehicules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVehicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehicule frame = new Vehicule();
				frame.UpdateTable();
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
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 442, 289);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLUE);
		table.getTableHeader().setBackground(Color.lightGray);
		table.getTableHeader().setForeground(Color.white);
		table.setBackground(Color.white);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualiser();
			}

		});
		scrollPane.setViewportView(table);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u00E9penses", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_7.setBounds(303, 425, 954, 200);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 15, 940, 179);
		panel_7.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setForeground(Color.BLUE);
		table_1.getTableHeader().setBackground(Color.lightGray);
		table_1.getTableHeader().setForeground(Color.white);
		table_1.setBackground(Color.white);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(717, 101, 239, 217);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mode de paiment");
		lblNewLabel.setBounds(6, 150, 105, 13);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date de paiment");
		lblNewLabel_1.setBounds(6, 190, 97, 13);
		panel_3.add(lblNewLabel_1);
		
		JComboBox mode_paiement = new JComboBox();
		mode_paiement.setBounds(111, 150, 118, 21);
		panel_3.add(mode_paiement);
		mode_paiement.setModel(new DefaultComboBoxModel(new String[] {"espece", "par chèque", "cr\u00E9dit "}));
		mode_paiement.setSelectedIndex(1);
		
		JDateChooser date_paiement = new JDateChooser();
		date_paiement.setBounds(111, 190, 119, 19);
		panel_3.add(date_paiement);
		

		
		JLabel lblNewLabel_2 = new JLabel("Carte d'identit\u00E9:\r\n");
		lblNewLabel_2.setBounds(6, 15, 97, 13);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom:");
		lblNewLabel_3.setBounds(6, 38, 63, 13);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom:");
		lblNewLabel_4.setBounds(6, 61, 63, 13);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age:");
		lblNewLabel_5.setBounds(6, 84, 63, 13);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Type de permis:");
		lblNewLabel_6.setBounds(6, 107, 105, 13);
		panel_3.add(lblNewLabel_6);
		
		permis = new JTextField();
		permis.setBounds(111, 104, 26, 19);
		panel_3.add(permis);
		permis.setColumns(10);
		
	    cin = DefaultComponentFactory.getInstance().createLabel("");
	    cin.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	    cin.setBounds(112, 15, 84, 13);
	    panel_3.add(cin);
	    
	     nom = DefaultComponentFactory.getInstance().createLabel("");
	     nom.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	     nom.setBounds(112, 38, 84, 13);
	     panel_3.add(nom);
	     
	      prenom = DefaultComponentFactory.getInstance().createLabel("");
	      prenom.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	      prenom.setBounds(112, 61, 84, 13);
	      panel_3.add(prenom);
	      
	       age = DefaultComponentFactory.getInstance().createLabel("");
	       age.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	       age.setBounds(112, 84, 84, 13);
	       panel_3.add(age);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_6.setBounds(717, 328, 242, 87);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(966, 292, 349, 100);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		montant_deja_payer = new JTextField();
		montant_deja_payer.setBounds(137, 48, 119, 16);
		panel_5.add(montant_deja_payer);
		montant_deja_payer.setText("0");
		montant_deja_payer.setColumns(10);
		
		reste = new JTextField();
		reste.setBounds(137, 78, 119, 16);
		panel_5.add(reste);
		reste.setColumns(10);
		
		JLabel lblNewJgoodiesTitle_17 = DefaultComponentFactory.getInstance().createTitle("Montant total:");
		lblNewJgoodiesTitle_17.setBounds(6, 18, 118, 13);
		panel_5.add(lblNewJgoodiesTitle_17);
		
		JLabel lblNewJgoodiesTitle_18 = DefaultComponentFactory.getInstance().createTitle("Montant d\u00E9ja payer");
		lblNewJgoodiesTitle_18.setBounds(6, 50, 118, 13);
		panel_5.add(lblNewJgoodiesTitle_18);
		
		JLabel lblNewJgoodiesTitle_19 = DefaultComponentFactory.getInstance().createTitle("Reste");
		lblNewJgoodiesTitle_19.setBounds(6, 81, 118, 13);
		panel_5.add(lblNewJgoodiesTitle_19);
		
		montant_total = new JTextField();
		montant_total.setBounds(137, 15, 119, 16);
		panel_5.add(montant_total);
		montant_total.setColumns(10);
		

		

		
		JLabel lblNewJgoodiesTitle_20 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_20.setBounds(264, 18, 18, 13);
		panel_5.add(lblNewJgoodiesTitle_20);
		
		JLabel lblNewJgoodiesTitle_21 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_21.setBounds(264, 50, 18, 13);
		panel_5.add(lblNewJgoodiesTitle_21);
		
		JLabel lblNewJgoodiesTitle_22 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_22.setBounds(264, 81, 18, 13);
		panel_5.add(lblNewJgoodiesTitle_22);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("image\\save.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps = conn.prepareStatement("insert into paiements (cin_candidat,montant_total,mode_paiement,date_paiement,reste)values(?,?,?,?,?);");
					ps.setInt(1, Integer.parseInt(tab3[0]));
					ps.setInt(2, p5);
				    ps.setString(3,mode_paiement.getSelectedItem().toString());
				    ps.setDate(4, new java.sql.Date(date_paiement.getDate().getTime()));
				    int t = p5-Integer.parseInt(montant_deja_payer.getText());
				    reste.setText(Integer.toString(t));
				    ps.setInt(5,t);
				   int x =ps.executeUpdate();
				   JOptionPane.showMessageDialog(null, "enregistré");
				   paiementTable ();
					if (x>0)
					{/* System.out.println( "succés");*/}
					else {/*System.out.println("non enregistré");*/}
					
				}
				catch(Exception e1){ System.out.println(e1); }
			}
		});
		btnNewButton.setBounds(8, 17, 111, 62);
		panel_6.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("");
		btnNewButton1.setIcon(new ImageIcon("image\\delete1.png"));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int row = table_1.getSelectedRow();
					String value = table_1.getModel().getValueAt(row, 1).toString();
					String request="delete from paiements where cin_candidat=?";
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps =  conn.prepareStatement(request);
					ps.setString(1,value);
					ps.execute();
					paiementTable ();
					JOptionPane.showMessageDialog(null, "succés de suppression");
				}
				catch (Exception e3) { System.out.println(e3); }
			}
		});
		btnNewButton1.setBounds(124, 16, 111, 62);
		panel_6.add(btnNewButton1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(966, 101, 349, 185);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Nombre d'examen de conduite:");
		lblNewJgoodiesTitle.setBounds(6, 22, 169, 13);
		panel_4.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Nombre d'examen de code:");
		lblNewJgoodiesTitle_1.setBounds(6, 56, 163, 13);
		panel_4.add(lblNewJgoodiesTitle_1);
		
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("Examen Total");
		lblNewJgoodiesTitle_2.setBounds(6, 87, 133, 13);
		panel_4.add(lblNewJgoodiesTitle_2);
		
		examen_total = new JTextField();
		examen_total.setBounds(174, 84, 26, 19);
		panel_4.add(examen_total);
		examen_total.setColumns(10);
		
		 nbr_examen_conduite = DefaultComponentFactory.getInstance().createLabel("");
		 nbr_examen_conduite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 nbr_examen_conduite.setBounds(174, 22, 26, 13);
		 panel_4.add(nbr_examen_conduite);
		
		 nbr_examen_code = DefaultComponentFactory.getInstance().createLabel("");
		 nbr_examen_code.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 nbr_examen_code.setBounds(174, 56, 26, 13);
		 panel_4.add(nbr_examen_code);
		
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("Prix:");
		lblNewJgoodiesTitle_3.setBounds(218, 22, 36, 13);
		panel_4.add(lblNewJgoodiesTitle_3);
		
		JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("Prix:");
		lblNewJgoodiesTitle_4.setBounds(218, 56, 36, 13);
		panel_4.add(lblNewJgoodiesTitle_4);
		
		JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory.getInstance().createTitle("Total");
		lblNewJgoodiesTitle_5.setBounds(218, 87, 36, 13);
		panel_4.add(lblNewJgoodiesTitle_5);
		
		 prix_ex_conduite = DefaultComponentFactory.getInstance().createLabel("");
		 prix_ex_conduite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 prix_ex_conduite.setBounds(264, 22, 50, 13);
		 panel_4.add(prix_ex_conduite);
		
		 prix_ex_code = DefaultComponentFactory.getInstance().createLabel("");
		 prix_ex_code.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 prix_ex_code.setBounds(264, 56, 50, 13);
		 panel_4.add(prix_ex_code);
		
	    prix_ex_total = DefaultComponentFactory.getInstance().createLabel("");
	    prix_ex_total.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	    prix_ex_total.setBounds(264, 87, 50, 13);
	    panel_4.add(prix_ex_total);
		
		JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_6.setBounds(324, 22, 18, 13);
		panel_4.add(lblNewJgoodiesTitle_6);
		
		JLabel lblNewJgoodiesTitle_7 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_7.setBounds(324, 56, 18, 13);
		panel_4.add(lblNewJgoodiesTitle_7);
		
		JLabel lblNewJgoodiesTitle_8 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_8.setBounds(324, 87, 18, 13);
		panel_4.add(lblNewJgoodiesTitle_8);
		
		JLabel lblNewJgoodiesTitle_9 = DefaultComponentFactory.getInstance().createTitle("Nombre d'heure de conduite:");
		lblNewJgoodiesTitle_9.setBounds(6, 110, 169, 13);
		panel_4.add(lblNewJgoodiesTitle_9);
		
		JLabel lblNewJgoodiesTitle_10 = DefaultComponentFactory.getInstance().createTitle("Nombre d'heure de code:");
		lblNewJgoodiesTitle_10.setBounds(6, 137, 163, 13);
		panel_4.add(lblNewJgoodiesTitle_10);
		
	    nbr_conduite = DefaultComponentFactory.getInstance().createLabel("");
	    nbr_conduite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	    nbr_conduite.setBounds(174, 110, 26, 13);
	    panel_4.add(nbr_conduite);
		
		 nbr_code = DefaultComponentFactory.getInstance().createLabel("");
		 nbr_code.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 nbr_code.setBounds(174, 137, 26, 13);
		 panel_4.add(nbr_code);
		
		JLabel lblNewJgoodiesTitle_11 = DefaultComponentFactory.getInstance().createTitle("Prix:");
		lblNewJgoodiesTitle_11.setBounds(218, 110, 36, 13);
		panel_4.add(lblNewJgoodiesTitle_11);
		
		JLabel lblNewJgoodiesTitle_12 = DefaultComponentFactory.getInstance().createTitle("Prix:");
		lblNewJgoodiesTitle_12.setBounds(218, 137, 36, 13);
		panel_4.add(lblNewJgoodiesTitle_12);
		
		 prix_code = DefaultComponentFactory.getInstance().createLabel("");
		 prix_code.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 prix_code.setBounds(264, 137, 50, 13);
		 panel_4.add(prix_code);
		
		 prix_conduite = DefaultComponentFactory.getInstance().createLabel("");
		 prix_conduite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 prix_conduite.setBounds(264, 110, 50, 13);
		 panel_4.add(prix_conduite);
		
		JLabel lblNewJgoodiesTitle_13 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_13.setBounds(324, 110, 18, 13);
		panel_4.add(lblNewJgoodiesTitle_13);
		
		JLabel lblNewJgoodiesLabel_13 = DefaultComponentFactory.getInstance().createLabel("DT");
		lblNewJgoodiesLabel_13.setBounds(324, 137, 18, 13);
		panel_4.add(lblNewJgoodiesLabel_13);
		
		JLabel lblNewJgoodiesTitle_14 = DefaultComponentFactory.getInstance().createTitle("Heures totales:");
		lblNewJgoodiesTitle_14.setBounds(6, 167, 111, 13);
		panel_4.add(lblNewJgoodiesTitle_14);
		
		heure_totale = new JTextField();
		heure_totale.setBounds(174, 164, 26, 19);
		panel_4.add(heure_totale);
		heure_totale.setColumns(10);
		
		JLabel lblNewJgoodiesTitle_15 = DefaultComponentFactory.getInstance().createTitle("Total");
		lblNewJgoodiesTitle_15.setBounds(218, 167, 36, 13);
		panel_4.add(lblNewJgoodiesTitle_15);
		
		 prix_total = DefaultComponentFactory.getInstance().createLabel("");
		 prix_total.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 prix_total.setBounds(264, 167, 50, 13);
		 panel_4.add(prix_total);
		
		JLabel lblNewJgoodiesTitle_16 = DefaultComponentFactory.getInstance().createTitle("DT");
		lblNewJgoodiesTitle_16.setBounds(324, 167, 18, 13);
		panel_4.add(lblNewJgoodiesTitle_16);
		//-------------------------------------------

		
		
	}
	public static void actualiser () {
	    int row = table.getSelectedRow();
		
		if(row==-1)
		{JOptionPane.showMessageDialog(null, "selectionner une ligne");}
		else {
		 tab3=  new String [10]; 
		for(int i=0;i<1;i++) {
			String value = table.getModel().getValueAt(row, i).toString();
			tab3[i]=value;
		}
		String sql1 = "select * from candidats Where cin_candidat='"+tab3[0]+"'";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql1);
		ResultSet resultat = prepared.executeQuery();
	    while (resultat.next()) {
	     int  a =resultat.getInt("cin_candidat");
		 String b =resultat.getString("nom");
		 String c =resultat.getString("prenom");
		 Date d =resultat.getDate("date_naissance");
		 int e =resultat.getInt("age");
		 String j =resultat.getString("permis");
		cin.setText(tab3[0]);
		nom.setText(b);
		prenom.setText(c);
		age.setText(Integer.toString(e));
		permis.setText(j);
	    }
		}
		catch(Exception e) { System.out.println("wrong faulte"); }
		
		int k1=0;
		int k2=0;
		int k3=0;
		int k4=0;
		int p1=0;
		int p2=0;
		int p3=0;
		int p4=0;
		String sql2 = "select * from cours Where cin_candidat='"+tab3[0]+"'";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql2);
		ResultSet resultat3 = prepared.executeQuery();
	    while (resultat3.next()) {
	   	
		String x =resultat3.getString("statut");
		int  y =resultat3.getInt("prix");
		int z =resultat3.getInt("duree_cours");
		System.out.println(x);
		if(x.contentEquals("examen conduite")) {
			k1++;
			p1+=y;
		}
		if(x.contentEquals("examen code")) {
			k2++;
			p2+=y;
		}
		if(x.contentEquals("conduite")) {
			k3+=z;
			p3+=y;
		}
		if(x.contentEquals("code")) {
			k4+=z;
			p4+=y;
		}
	    }
	    nbr_examen_conduite.setText(Integer.toString(k1));
	    nbr_examen_code.setText(Integer.toString(k2));
	    nbr_conduite.setText(Integer.toString(k3));
	    nbr_code.setText(Integer.toString(k4));
	    examen_total.setText(Integer.toString(k2+k1));
	    heure_totale.setText(Integer.toString(k3+k4));
	    prix_ex_conduite.setText(Integer.toString(p1));
	    prix_ex_code.setText(Integer.toString(p2));
	    prix_ex_total.setText(Integer.toString(p1+p2));
	    prix_conduite.setText(Integer.toString(p3));
	    prix_code.setText(Integer.toString(p4));
	    prix_total.setText(Integer.toString(p3+p4));
	    p5=p1+p2+p3+p4;
	    montant_total.setText(Integer.toString(p5));
		}
		catch(Exception e2) { System.out.println(e2); }
		
		
		}
	}
	public static void paiementTable ()
	{
		String sql = "Select * from paiements";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement prepared =  conn.prepareStatement(sql);
		ResultSet resultat = prepared.executeQuery();
		DefaultTableModel model = new DefaultTableModel(new String[]{"id_paiements", "cin_candidat","montant_total","mode_paiement","date_paiement","reste",}, 0);
		table_1.setModel(model);
		
		 while (resultat.next()) {
		 int a =resultat.getInt("id_paiements");
		 int b =resultat.getInt("cin_candidat");
		 int c =resultat.getInt("montant_total");
		 String d =resultat.getString("mode_paiement");
		 String e =resultat.getString("date_paiement");
		 int f =resultat.getInt("reste");
		 int row = resultat.getRow();
		
		 model.addRow(new Object[]{a,b,c,d,e,f});
		 table_1.setModel(model);
		
		}}
		 catch(Exception e1) {System.out.println(e1);}}
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
		 table.setModel(model);
		
		}
		}
		
		catch(Exception e) { System.out.println(e); }
	}
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
