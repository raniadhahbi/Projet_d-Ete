package src;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Cursor;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField usernameField;
	private JTextField e_mailField;
	static JPasswordField passwordField;
	static JPasswordField passwordField1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
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
	public Inscription() {
		
		/*---Creation du Fenetre---*/
		
		setBounds(100, 100, 599, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---Zone de saisie du Nom---*/
		
		nameField = new JTextField();
		nameField.setBounds(338, 105, 216, 25);
		nameField.setForeground(new Color(255, 255, 255));
		nameField.setOpaque(false);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		/*---Zone de saisie du Prenom---*/
		
		usernameField = new JTextField();
		usernameField.setBounds(338, 169, 216, 25);
		usernameField.setForeground(new Color(255, 255, 255));
		usernameField.setOpaque(false);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		/*---Zone de saisie du E-mail---*/
		
		e_mailField = new JTextField();
		e_mailField.setBounds(338, 232, 216, 25);
		e_mailField.setForeground(new Color(255, 255, 255));
		e_mailField.setOpaque(false);
		contentPane.add(e_mailField);
		e_mailField.setColumns(10);
		
		/*---Zone de saisie du Mot de passe---*/
		
		passwordField = new JPasswordField();
		passwordField.setBounds(338, 290, 216, 25);
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setOpaque(false);
		contentPane.add(passwordField);
		
		/*---Zone de saisie du Confirmation de mot de passe ---*/
		
		passwordField1 = new JPasswordField();
		passwordField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordField1.setBounds(338, 354, 216, 25);
		passwordField1.setForeground(new Color(255, 255, 255));
		passwordField1.setOpaque(false);
		contentPane.add(passwordField1);
		
		// enregistrement du nouveau utilisateur

		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(340, 457, 214, 25);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameField.getText().contentEquals("")) {
					   UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.jpg");
					   JOptionPane.showMessageDialog(null, "Remplir le champ name","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(usernameField.getText().contentEquals("")) {
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.jpg");
					   JOptionPane.showMessageDialog(null, "Remplir le champ username","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else if(e_mailField.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.jpg");
					   JOptionPane.showMessageDialog(null, "Remplir le champ e_mail","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
					
				}
				else if(passwordField.getText().contentEquals("")) {
					UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\champ.jpg");
					   JOptionPane.showMessageDialog(null, "Remplir le champ password","CHAMP MANQANT",JOptionPane.INFORMATION_MESSAGE,image3);
				}
				else {
				if ( passwordField.getText().contentEquals(passwordField1.getText()) ){
					
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection Conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps =Conn.prepareStatement("insert into utilisateurs(name,username,e_mail,password) values(?,?,?,?);");
				    ps.setString(1, nameField.getText());
				    ps.setString(2, usernameField.getText());
				    ps.setString(3,e_mailField.getText());
				    ps.setString(4, passwordField.getText());
				   
				    int x =ps.executeUpdate();
					if (x>0)
						{
						UIManager.put("OptionPane.background", Color.WHITE);
				           UIManager.put("OptionPane.messagebackground", Color.WHITE);
				           UIManager.put("Panel.background", Color.WHITE);
				           UIManager.put("OptionPane.messageForeground", Color.blue);
				           ImageIcon image3 = new ImageIcon("image\\connection.png");
						   JOptionPane.showMessageDialog(null, "votre compte est créé","INSCRIPTION",JOptionPane.INFORMATION_MESSAGE,image3);
						Accueil frame = new Accueil();
						frame.setVisible(true);
						frame.setResizable(false);
						fermer();}
					else 
						{
						   UIManager.put("OptionPane.background", Color.WHITE);
				           UIManager.put("OptionPane.messagebackground", Color.WHITE);
				           UIManager.put("Panel.background", Color.WHITE);
				           UIManager.put("OptionPane.messageForeground", Color.blue);
				           ImageIcon image3 = new ImageIcon("image\\fauxcompte.png");
						   JOptionPane.showMessageDialog(null, "le compte deja existe !","INSCRIPTION",JOptionPane.INFORMATION_MESSAGE,image3);
						}
					
				    }
				catch (ClassNotFoundException e1) { 
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\fauxcompte.png");
					   JOptionPane.showMessageDialog(null, "le compte deja existe ou les champs sont vides !","INSCRIPTION",JOptionPane.INFORMATION_MESSAGE,image3);
					 } 
				catch (SQLException e1) { 
					 UIManager.put("OptionPane.background", Color.WHITE);
			           UIManager.put("OptionPane.messagebackground", Color.WHITE);
			           UIManager.put("Panel.background", Color.WHITE);
			           UIManager.put("OptionPane.messageForeground", Color.blue);
			           ImageIcon image3 = new ImageIcon("image\\fauxcompte.png");
					   JOptionPane.showMessageDialog(null, "le compte deja existe ou les champs sont vides !","INSCRIPTION",JOptionPane.INFORMATION_MESSAGE,image3);
				}
							
			   }
			else 
			    { 
				JOptionPane.showMessageDialog(null, "verifier la confirmation de votre mot de passe !");  }
				  }}});
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 596, 542);
		
		//creation du label
		lblNewLabel.setIcon(new ImageIcon("image\\register.png"));
		contentPane.add(lblNewLabel);	}
	
	/*---Methode fermer() 'fermer les fenetres precedentes '---*/
	
	public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}}
