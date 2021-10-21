package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JFrame {

	 static JPanel contentPane;
	 private JButton btnDeconexion;
	 static JPanel panel;
     static JPanel panel4;
	 static int k=240;

	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creation du frame
	 */
	public Accueil() {
        
		/*---Creation du Fenetre---*/
		
		setBounds(100, 100, 1201, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
		/*---Creation du JPanel---*/
		 
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 240, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//-----------
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\about1.png"));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (k==240)
				{panel.setSize(240, 680);
				  try 
				 {
					 for(int i=240;i>0;i--)
					 {	 
						 panel.setSize(i,680); }}
				 catch (Exception e7) {e7.printStackTrace();}}}
		   });
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(142, 22, 88, 40);
		panel.add(lblNewLabel);
		
		
		/*---Creation du JPanel---*/
		
		panel4 = new JPanel();
		panel4.setBackground(Color.DARK_GRAY);
		panel4.setOpaque(false);
		panel4.setBounds(0, 0, 240, 680);
		contentPane.add(panel4);
		panel4.setLayout(null);
		
		//------------
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image\\about2.png"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (k==240)
				{panel.setSize(240, 680);
				 try 
				 {
					 for(int i=0;i<k;i++)
					 {	 
						 panel.setSize(i,680); 
					 }}
				 catch (Exception e7) {e7.printStackTrace();}}}
		     });
		lblNewLabel_1.setBounds(142, 22, 88, 40);
		panel4.add(lblNewLabel_1);
		//-------------- 
		
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setIcon(new ImageIcon("image\\propos1.png"));
		lblNewLabel2.setBounds(0, 0, 240, 680);
		contentPane.add(lblNewLabel2);
		
		/*---Creation du bouton Acceuil---*/
		
		JButton btnNewButton = new JButton("  Acceuil");
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
		btnNewButton.setBounds(0, 84, 239, 31);
		panel.add(btnNewButton);
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		/*---Creation du bouton Candidtas---*/
		
		JButton btnNewButton_1 = new JButton("Candidats");
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
		btnNewButton_1.setBounds(0, 115, 239, 31);
		panel.add(btnNewButton_1);
		
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
		btnCours.setHorizontalAlignment(SwingConstants.LEFT);
		btnCours.setIconTextGap(10);
		btnCours.setIcon(new ImageIcon("image\\cours11_25x25.png"));
		btnCours.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCours.setForeground(Color.WHITE);
		btnCours.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCours.setBackground(Color.DARK_GRAY);
		btnCours.setBounds(0, 146, 239, 31);
		panel.add(btnCours);
		
		/*---Creation du bouton Moniteurs---*/
		
		JButton btnMoniteurs = new JButton("Moniteurs");
		btnMoniteurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moniteur frame = new Moniteur();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		  });
		btnMoniteurs.setHorizontalAlignment(SwingConstants.LEFT);
		btnMoniteurs.setIconTextGap(10);
		btnMoniteurs.setIcon(new ImageIcon("image\\moniteur_1_25x25.png"));
		btnMoniteurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMoniteurs.setForeground(Color.WHITE);
		btnMoniteurs.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnMoniteurs.setBackground(Color.DARK_GRAY);
		btnMoniteurs.setBounds(0, 176, 239, 31);
		panel.add(btnMoniteurs);
		
		/*---Creation du bouton Examens---*/
		
		JButton btnExamens = new JButton("Examens");
		btnExamens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Examens frame = new Examens();
				frame.UpdateTable();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();}
		    });
		btnExamens.setHorizontalAlignment(SwingConstants.LEFT);
		btnExamens.setIcon(new ImageIcon("image\\examen_25x25.png"));
		btnExamens.setIconTextGap(10);
		btnExamens.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExamens.setForeground(Color.WHITE);
		btnExamens.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnExamens.setBackground(Color.DARK_GRAY);
		btnExamens.setBounds(0, 207, 239, 31);
		panel.add(btnExamens);
		
		
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
		btnVehicules.setBounds(0, 236, 239, 31);
		panel.add(btnVehicules);
		
		
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
		btnPaiement.setHorizontalAlignment(SwingConstants.LEFT);
		btnPaiement.setIconTextGap(10);
		btnPaiement.setIcon(new ImageIcon("image\\paiement_1_25x25.png"));
		btnPaiement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPaiement.setForeground(Color.WHITE);
		btnPaiement.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPaiement.setBackground(Color.DARK_GRAY);
		btnPaiement.setBounds(0, 266, 239, 31);
		panel.add(btnPaiement);
		
		/*---Creation du bouton S'inscrire---*/
		
		JButton btnRegister = new JButton("S'inscrire");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription frame = new Inscription();
				frame.setVisible(true);
				frame.setResizable(false);
				fermer();
			}
		});
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setIconTextGap(10);
		btnRegister.setIcon(new ImageIcon("image\\register1_25x25.png"));
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRegister.setBackground(Color.DARK_GRAY);
		btnRegister.setBounds(0, 296, 239, 31);
		panel.add(btnRegister);
		
		/*---Creation du bouton Deconnexion---*/
		btnDeconexion = new JButton("Deconexion");
		btnDeconexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnDeconexion.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeconexion.setIconTextGap(10);
		btnDeconexion.setIcon(new ImageIcon("image\\deconnexion_25x25.png"));
		btnDeconexion.setIgnoreRepaint(true);
		btnDeconexion.setAutoscrolls(true);
		btnDeconexion.setLocale(new Locale("aa"));
		btnDeconexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeconexion.setToolTipText("");
		btnDeconexion.setForeground(new Color(255, 255, 255));
		btnDeconexion.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnDeconexion.setBackground(Color.DARK_GRAY);
		btnDeconexion.setBounds(0, 324, 239, 31);
		panel.add(btnDeconexion);
		
		/*---Creation du JPanel---*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(new Rectangle(30, 40, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(240, 0, 939, 680);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/*---Creation du bouton Paiement---*/
		JButton btnNewButton_2 = new JButton("Paiement");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paiement frame = new Paiement();
				frame.UpdateTable ();
				frame.paiementTable ();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(255, 153, 204));
		btnNewButton_2.setIcon(new ImageIcon("image\\card-in-use-128.png"));
		btnNewButton_2.setBounds(42, 506, 272, 151);
		panel_1.add(btnNewButton_2);
		
		/*---Creation du bouton Cours---*/
		JButton btnCours_1 = new JButton("Cours");
		btnCours_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cours frame = new cours();
				frame.UpdateTable();
				frame.setVisible(true);
				fermer();
			}
		});
		btnCours_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCours_1.setIcon(new ImageIcon("image\\books-128.png"));
		btnCours_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCours_1.setForeground(Color.WHITE);
		btnCours_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnCours_1.setBackground(new Color(128, 128, 0));
		btnCours_1.setAlignmentY(1.0f);
		btnCours_1.setBounds(364, 148, 272, 151);
		panel_1.add(btnCours_1);
		
		/*---Creation du bouton Vehicules---*/
		
		JButton btnVehicule = new JButton("V\u00E9hicules");
		btnVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehicule frame = new Vehicule();
				frame.UpdateTable();
				frame.setVisible(true);
				fermer();
			}
		});
		btnVehicule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVehicule.setIcon(new ImageIcon("image\\car-4-128.png"));
		btnVehicule.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVehicule.setForeground(Color.WHITE);
		btnVehicule.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnVehicule.setBackground(new Color(123, 104, 238));
		btnVehicule.setAlignmentY(1.0f);
		btnVehicule.setBounds(364, 325, 272, 151);
		panel_1.add(btnVehicule);
		
		/*---Creation du bouton Examens---*/
		
		JButton btnExamen = new JButton("Examen");
		btnExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Examens frame = new Examens();
				frame.UpdateTable();
				frame.setVisible(true);
				fermer();
			}
		});
		btnExamen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExamen.setIcon(new ImageIcon("image\\exam.png"));
		btnExamen.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnExamen.setForeground(Color.WHITE);
		btnExamen.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnExamen.setBackground(new Color(100, 149, 237));
		btnExamen.setAlignmentY(1.0f);
		btnExamen.setBounds(42, 325, 272, 151);
		panel_1.add(btnExamen);
		
		/*---Creation du bouton Candidtas---*/
		
		JButton btnCandidats = new JButton("Candidats");
		btnCandidats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				candidat frame = new candidat();
				frame.UpdateTable();
				frame.setVisible(true);
				fermer();
				
			}
		});
		btnCandidats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCandidats.setIcon(new ImageIcon("image\\candidat.png"));
		btnCandidats.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCandidats.setForeground(Color.WHITE);
		btnCandidats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnCandidats.setBackground(new Color(255, 99, 71));
		btnCandidats.setAlignmentY(1.0f);
		btnCandidats.setBounds(42, 148, 272, 151);
		panel_1.add(btnCandidats);
		
		/*---Creation du bouton Moniteurs---*/
		
		JButton btnMoniteurs_1 = new JButton("Moniteurs");
		btnMoniteurs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moniteur frame = new Moniteur();
				frame.UpdateTable();
				frame.setVisible(true);
				fermer();
			}
		});
		btnMoniteurs_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMoniteurs_1.setIcon(new ImageIcon("image\\moniteur1.png"));
		btnMoniteurs_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMoniteurs_1.setForeground(Color.WHITE);
		btnMoniteurs_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnMoniteurs_1.setBackground(new Color(32, 178, 170));
		btnMoniteurs_1.setAlignmentY(1.0f);
		btnMoniteurs_1.setBounds(659, 148, 272, 151);
		panel_1.add(btnMoniteurs_1);
		
		/*---Creation du bouton Deconnexion---*/
		
		JButton btnDconexion = new JButton("D\u00E9conexion");
		btnDconexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnDconexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDconexion.setIcon(new ImageIcon("image\\deconnection1.png"));
		btnDconexion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDconexion.setForeground(Color.WHITE);
		btnDconexion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnDconexion.setBackground(new Color(112, 128, 144));
		btnDconexion.setAlignmentY(1.0f);
		btnDconexion.setBounds(364, 506, 272, 151);
		panel_1.add(btnDconexion);
		
		/*---Creation du bouton S'inscrire---*/
		
		JButton btnRegister_1 = new JButton("S'inscrire");
		btnRegister_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription frame = new Inscription();
				frame.setVisible(true);
				fermer();
			}
		});
		btnRegister_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister_1.setIcon(new ImageIcon("image\\sign.png"));
		btnRegister_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegister_1.setForeground(Color.WHITE);
		btnRegister_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnRegister_1.setBackground(new Color(205, 133, 63));
		btnRegister_1.setAlignmentY(1.0f);
		btnRegister_1.setBounds(659, 325, 272, 151);
		panel_1.add(btnRegister_1);
		
		/*---Creation du JPanel---*/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 939, 85);
		panel_1.add(panel_2);
			
}
	
//---------------	
	public void fermer()
{
	WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);}
  }
