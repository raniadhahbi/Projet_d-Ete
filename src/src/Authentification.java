package src;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.UIManager;


public class Authentification extends JFrame {

	private JPanel contentPane;
	static JTextField loginField;
	static JPasswordField passwordField;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 Creation du Frame 
	 */
	public Authentification() throws IOException {
		
		/*---Creation du Fenetre---*/
		
		setBounds(100, 100, 612, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---Zone de saisie du Identifiant---*/
		
		loginField= new JTextField();
		loginField.setBounds(209, 222, 220, 39);
		loginField.setOpaque(false);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		/*---Zone de saisie du Mot de passe---*/
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 283, 209, 33);
		passwordField.setOpaque(false);
		contentPane.add(passwordField);
		
		/*---Label Connexion---*/
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(209, 331, 194, 47);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connecter();				
			}});
		contentPane.add(lblNewLabel_1);
		
		/*---Creation du bouton de nouveau compte---*/
		
		btnNewButton = new JButton("Creer un nouveau compte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription frame = new Inscription();
				frame.setVisible(true);
				fermer();}
		  });
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lenovo\\Desktop\\ensi\\2\u00E9me semestre\\autoecole2\\image\\nouveau_compte1.png"));
		btnNewButton.setBounds(379, 38, 219, 33);
		contentPane.add(btnNewButton);
		
		
		// enregistrement du nouveau utilisateur

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 604, 567);
		lblNewLabel.setIcon(new ImageIcon("image\\login.png"));
		contentPane.add(lblNewLabel);}
	
	/*---Connexion à l'application---*/
	
public void connecter()
	{
	try {
		String tab1 = loginField.getText();
		String tab2 = passwordField.getText();
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection Conn =  DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		PreparedStatement ps =Conn.prepareStatement("select * from  utilisateurs");
	    ResultSet res=ps.executeQuery(); 
	    int k=0;
	    while (res.next() && k==0) {
	         String  a = res.getString("name");
	         String b = res.getString("password");
	         if (a.equals(tab1) && b.equals(tab2)) 
	         {k=1;}
	   }
	   if(k==1) {
		   UIManager.put("OptionPane.background", Color.WHITE);
           UIManager.put("OptionPane.messagebackground", Color.WHITE);
           UIManager.put("Panel.background", Color.WHITE);
           UIManager.put("OptionPane.messageForeground", Color.blue);
           ImageIcon image1 = new ImageIcon("C:\\Users\\lenovo\\Desktop\\ensi\\2éme semestre\\autoecole3\\image\\images.jpg");
		    JOptionPane.showMessageDialog(null, "connecté !","INFO",JOptionPane.INFORMATION_MESSAGE,image1);
		     Accueil a =new Accueil();
		     a.setVisible(true);
		     fermer();}
	    else {
	    	 UIManager.put("OptionPane.background", Color.WHITE);
	         UIManager.put("OptionPane.messagebackground", Color.WHITE);
	         UIManager.put("Panel.background", Color.WHITE);
	         UIManager.put("OptionPane.messageForeground", Color.blue);
	    	ImageIcon image2 = new ImageIcon("image\\authenfausse.png");
		    JOptionPane.showMessageDialog(null, "verifier votre compte!","INFO",JOptionPane.INFORMATION_MESSAGE,image2);}
	   }
	   catch (ClassNotFoundException e1) { System.out.println(e1);  } 
	catch (SQLException e1) {System.out.println(e1); }
	 }

//--------

public void fermer()
	{
		WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);}	
}

	 



