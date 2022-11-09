import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import java.time.LocalDate;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register {

	private JFrame frame;
	private JTextField fntextField;
	private JTextField lntextField;
	private JTextField dobtextField;
	private JTextField usrtextField;
	private JTextField passtextField;
	private LocalDate date;
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Register");
		title.setFont(new Font("Zapfino", Font.PLAIN, 15));
		title.setBounds(19, 6, 84, 52);
		frame.getContentPane().add(title);
		
		JLabel fname = new JLabel("First Name");
		fname.setBounds(125, 6, 77, 16);
		frame.getContentPane().add(fname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(125, 42, 77, 16);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(125, 75, 84, 26);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblyyyymmdd = new JLabel("(YYYY-MM-DD)");
		lblyyyymmdd.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblyyyymmdd.setBounds(125, 97, 84, 26);
		frame.getContentPane().add(lblyyyymmdd);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(125, 132, 69, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(125, 170, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		fntextField = new JTextField();
		fntextField.setBounds(241, 6, 130, 26);
		frame.getContentPane().add(fntextField);
		fntextField.setColumns(10);
		
		
		lntextField = new JTextField();
		lntextField.setColumns(10);
		lntextField.setBounds(241, 37, 130, 26);
		frame.getContentPane().add(lntextField);
		
		dobtextField = new JTextField();//if (dobtextField.getText().length() != 10) {textArea.append("Invalid input")}
		dobtextField.setColumns(10);
		dobtextField.setBounds(241, 75, 130, 26);
		frame.getContentPane().add(dobtextField);
		
		
		usrtextField = new JTextField();
		usrtextField.setColumns(10);
		usrtextField.setBounds(241, 127, 130, 26);
		frame.getContentPane().add(usrtextField);
		
		passtextField = new JTextField();
		passtextField.setColumns(10);
		passtextField.setBounds(241, 165, 130, 26);
		frame.getContentPane().add(passtextField);
		
		
		
		JButton submitButton = new JButton("submit");//if any values are null don't update the user table 
		submitButton.setBounds(251, 203, 117, 29);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
					Statement stmt = MyConnection.getConnection().createStatement();
					String sql = "INSERT INTO users(username,password,firstname,lastname,dob) VALUES('"+usrtextField.getText()+"',"
							+ "'"+passtextField.getText()+"', '"+fntextField.getText()+"','"+lntextField.getText()+"','"+dobtextField.getText()+"')";
					stmt.execute(sql);
					fntextField.setText("");lntextField.setText("");dobtextField.setText("");usrtextField.setText("");passtextField.setText("");
					JOptionPane.showMessageDialog(null, "Success! thank you for registering with EBS, "
							+ "you can exit this page to log in to your new account.");
					MyConnection.getConnection().close();
				}catch(Exception e) {System.out.print(e); JOptionPane.showMessageDialog(null, "invalid input...");}
			}
		
		});
		frame.getContentPane().add(submitButton);
		
		JButton exitButton = new JButton("exit");
		exitButton.setBounds(6, 203, 84, 29);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					login l = new login();
					l.getFrame().setVisible(true);
				}catch(Exception e) {System.out.print(e);
				}
			}
		});
		frame.getContentPane().add(exitButton);
		
		
		
		
		
	}
}
