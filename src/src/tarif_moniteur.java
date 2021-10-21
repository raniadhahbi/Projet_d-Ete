package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



public class tarif_moniteur extends JFrame {

	private JPanel contentPane;
	private JTextField tarif;
	public static JTextField cin_moniteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tarif_moniteur frame = new tarif_moniteur();
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
	public tarif_moniteur() {
		
		/*creation du panel principal */
		setBounds(100, 100, 422, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 32, 388, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*creation des zones de textes */
		cin_moniteur = new JTextField();
		cin_moniteur.setBounds(164, 15, 202, 35);
		panel.add(cin_moniteur);
		cin_moniteur.setColumns(10);
		
		tarif = new JTextField();
		tarif.setBounds(164, 60, 202, 35);
		panel.add(tarif);
		tarif.setColumns(10);
		
		JComboBox type = new JComboBox();
		type.setBounds(164, 157, 202, 35);
		panel.add(type);
		type.setModel(new DefaultComboBoxModel(new String[] {"code", "conduite", "Examen_code", "Examen_conduite"}));
		type.setSelectedIndex(1);
	
		JComboBox categorie = new JComboBox();
		categorie.setBounds(164, 105, 202, 35);
		panel.add(categorie);
		categorie.setModel(new DefaultComboBoxModel(new String[] {"A", "A1", "B", "B+E", "C", "C+E", "D", "D+E", "H"}));
		categorie.setSelectedIndex(1);
		
		/*creation des labels */
		JLabel lblNewLabel = new JLabel("Cin du candidat");
		lblNewLabel.setBounds(6, 26, 108, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Tarif");
		lblNewLabel_1.setBounds(6, 71, 77, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Categorie");
		lblNewLabel_2.setBounds(6, 116, 99, 24);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(6, 156, 82, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		/*bouttton d'tarif du moniteur */
		JButton btnenregistrer = new JButton("");
		btnenregistrer.setIcon(new ImageIcon("image\\new1.png"));
		btnenregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(tarif.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.png");
					   JOptionPane.showMessageDialog(null, "Remplir le champ nom du candidat","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				 else if(!(isNumeric(tarif.getText()))) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\information.jpg");
					   JOptionPane.showMessageDialog(null, "Modifier le champ age","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
						
					}
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps = conn.prepareStatement("insert into leçon (cin_moniteur,type_lecon,tarif,categorie)values(?,?,?,?);");
					
					ps.setInt(1,Integer.parseInt(cin_moniteur.getText()));
					ps.setString(2,type.getSelectedItem().toString());
				    ps.setString(3, tarif.getText());
				    ps.setString(4,categorie.getSelectedItem().toString());
				    int x =ps.executeUpdate();
					if (x>0)
					{/*System.out.println("succés");*/}
					else {/*System.out.println("il y'a une faute");*/}
					UIManager.put("OptionPane.background", Color.WHITE);
			        UIManager.put("OptionPane.messagebackground", Color.WHITE);
			        UIManager.put("Panel.background", Color.WHITE);
			        UIManager.put("OptionPane.messageForeground", Color.blue);
			        ImageIcon image3 = new ImageIcon("image\\information.jpg");
					JOptionPane.showMessageDialog(null, "plannifié avec succés","INFO",JOptionPane.INFORMATION_MESSAGE,image3);
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		btnenregistrer.setBounds(258, 283, 111, 62);
		contentPane.add(btnenregistrer);	
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







	

	
	
		
		
		
		

