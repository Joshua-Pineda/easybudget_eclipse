import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import node.User;
import java.awt.Color;
import javax.swing.JPanel;

public class login {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	static User usr = new User();
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextField getUserField() {
		return userField;
	}
	
	public static User getUsr() {
		return usr;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	public int getId(){
        int id = 0;
        PreparedStatement ps;
        ResultSet rs;
        String usr = userField.getText();
        String query = "SELECT user_id FROM `users` WHERE `username` =? ";
       
        try {
        	//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
        ps = MyConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, usr);
        
        rs = ps.executeQuery();
        
        if(rs.next()){
            id = rs.getInt("user_id");
        }
        
    } catch (SQLException ex) {
    	System.out.print(ex);
    }
       
        return id;
};
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		user.setBounds(82, 66, 75, 16);
		frame.getContentPane().add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		pass.setBounds(82, 132, 75, 16);
		frame.getContentPane().add(pass);
		
		userField = new JTextField();
		userField.setBounds(100, 94, 218, 26);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 159, 218, 26);
		frame.getContentPane().add(passwordField);
		
		JButton login = new JButton("login");
		login.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		login.setBounds(100, 209, 117, 29);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
					Statement stmt = MyConnection.getConnection().createStatement();
					String sql = "SELECT * FROM users WHERE username = '"+userField.getText()+"' AND password='"+passwordField.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						
						usr.setUsr(userField.getText());
						usr.setId(getId());
						dashboard d = new dashboard();
						d.getFrame().setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "login invalid...");
					}
						
					MyConnection.getConnection().close();
				}catch(Exception e) {System.out.print(e);}
			}
		
		});
		frame.getContentPane().add(login);
		
		JButton registerButton = new JButton("register");
		registerButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		registerButton.setBounds(229, 209, 117, 29);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					register r = new register();
					r.getFrame().setVisible(true);
				}catch(Exception e) {System.out.print(e);
				}
			}
		});
		//we need to create a register page then this button will send us to that page
		//and on that page we will have a submit button with this action listener
		
//	
		frame.getContentPane().add(registerButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 116, 0));
		panel.setBounds(51, 6, 338, 232);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Welcome to EBS");
		title.setBounds(104, 5, 136, 20);
		panel.add(title);
		title.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 17));
		
		
	}
}
