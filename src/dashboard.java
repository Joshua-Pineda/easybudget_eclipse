import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import node.Category;
import node.User;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;

//class
public class dashboard {

	private JFrame frame;
	User usr = login.getUsr();
	Category cat = new Category();
	private JTable table;
	private JTextField spendingAmountField;
	private JTextField budgetField;
	private JTextField spendingCategoryField;
	//private Choice choiceBox;
	private int catID;
	private int budID;
	private JTextField spendingDateField;
	//private JTextField textArea = new JTextField();
	//private String categoryName = null;
	//private String displayedName;
	private JTextField budgetCategoryField;
	private JTextField budgetDateField;
	private JTextField id_textField;
	public JFrame getFrame() {
		return frame;
	}
	public int getCatID() {
		return catID;
	}
	public void setCatID(int id) {
		catID = id;
	}
	public int getBudID() {
		return budID;
	}
	public void setBudID(int id) {
		budID = id;
	}
	
	
		
		
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard();
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
	public dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 845, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel welcomeLabel = new JLabel("Welcome "+usr.getUsr());
		welcomeLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		welcomeLabel.setBounds(6, 6, 168, 26);
		frame.getContentPane().add(welcomeLabel);
	
		
		DefaultTableModel model = new DefaultTableModel();
		Object column [] = {"Categories","Budget"};
		
		DefaultTableModel model2 = new DefaultTableModel();
		Object column2 [] = {"ID","Amount", "Date"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 81, 220, 242);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setModel(model);
		table.setBounds(90, 90, 90, 90);
		model.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		
		JScrollPane spending_scrollPane = new JScrollPane();
		spending_scrollPane.setBounds(431, 81, 272, 242);
		frame.getContentPane().add(spending_scrollPane);
		
		JTable spending_table = new JTable();
		spending_table.setModel(model2);
		spending_table.setBounds(90, 90, 90, 90);
		model2.setColumnIdentifiers(column2);
		spending_scrollPane.setViewportView(spending_table);
		
		
		
//		choiceBox = new Choice();
//		
//		choiceBox.setBounds(455, 32, 130, 27);
//		
//			try{
////			 try {
////				Class.forName("com.mysql.cj.jdbc.Driver");
////			} catch (ClassNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//				//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
//				Statement stmt = MyConnection.getConnection().createStatement();
//			
//				
//				//make table out of this query and then replace this 
//				//string with a SELECT name, amount, spending_amount FROM new_table; query
//	            String query = " SELECT name FROM categories WHERE user_id ='"+usr.getId()+"'";
//	           
//	           
//	            ResultSet rs =  stmt.executeQuery(query);
//	           
//	  
//	            
//	            while(rs.next()) {
//	            
//	            	
//	            	
//	            
//	             String cat = rs.getString("name");
//	             choiceBox.addItem(cat);
//	             
//	      
//	     		
//	           
//	            }
//	            MyConnection.getConnection().close();
//	  
//	       } catch (SQLException ex){
//	    	   System.out.print(ex);
//	       }
//		
//			choiceBox.addItemListener(new ItemListener() {
//				public void itemStateChanged(ItemEvent e) {
//					categoryName = choiceBox.getSelectedItem();
//					textArea.setText(categoryName);
//				}
//			});
//			
//		frame.getContentPane().add(choiceBox);
		
		//catID setter
//		 PreparedStatement ps;
//	        ResultSet r;
//	       
//	       
//	        String q = "SELECT categoryID FROM categories WHERE name ='"+categoryName+"'";
//	       
//	    
//	       
//	        try {
//	        	//Class.forName("com.mysql.cj.jdbc.Driver");
//				//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
//	        ps = MyConnection.getConnection().prepareStatement(q);
//	      
//	       
//	       
//	        r = ps.executeQuery();
//	     
//	        
//	        if(r.next()){
//	            setCatID(r.getInt("categoryID"));
//	            //setBudID(r.getInt("budget_id"));
//	        }
//	        
//	        
//	    } catch (SQLException ex) {
//	    	System.out.print(ex);
//	    }
//	  
//	        //budID setter
//	        PreparedStatement ps2;
//	        ResultSet r2;
//	        String q2 = "SELECT budget_id FROM `budget` WHERE `categoryID` =? ";
//	        try {
//	        	//Class.forName("com.mysql.cj.jdbc.Driver");
//				//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
//	      
//	        ps2 = MyConnection.getConnection().prepareStatement(q2);
//	        
//	       
//	        ps2.setInt(1, catID);
//	       
//	        r2= ps2.executeQuery();
//	        
//	        
//	        if(r2.next()){
//	            setBudID(r2.getInt("budget_id"));
//	            //setBudID(r.getInt("budget_id"));
//	        }
//	        
//	    } catch (SQLException ex) {
//	    	System.out.print(ex);
//	    }
	        
	      //table content setter  
		 try{
//			 try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
				//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
				Statement stmt = MyConnection.getConnection().createStatement();
			//	Statement stmt1 = MyConnection.getConnection().createStatement();
				//Statement stmt2 = MyConnection.getConnection().createStatement();
				
				//make table out of this query and then replace this 
				//string with a SELECT name, amount, spending_amount FROM new_table; query
	            String query = " SELECT name, budget FROM categories WHERE user_id ='"+usr.getId()+"' AND EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM now())";
	            //String query2 = " SELECT  amount FROM  WHERE user_id ='"+usr.getId()+"'";
	           // String query3 = " SELECT spending_amount FROM spending WHERE user_id ='"+usr.getId()+"'";
	           
	            ResultSet rs =  stmt.executeQuery(query);
	          //  ResultSet rs2 = stmt1.executeQuery(query2);
	          //  ResultSet rs3 = stmt2.executeQuery(query3);
	  
	            
	            while(rs.next()) {
	            
	             String cat = rs.getString("name");
	             String bud = String.valueOf(rs.getDouble("budget"));
	            // String spe = String.valueOf(rs3.getDouble("spending_amount"));
	             
	            String data [] = {cat,bud};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)table.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		
		 //spending table
		 try{


				Statement stmt = MyConnection.getConnection().createStatement();
			
	            String query = " SELECT spending_id, spending_amount, date FROM spending WHERE user_id ='"+usr.getId()+"' AND EXTRACT(MONTH FROM date) = EXTRACT(MONTH FROM now())";
	         
	           
	            ResultSet rs =  stmt.executeQuery(query);
	         
	  
	            
	            while(rs.next()) {
	            
	             String id = String.valueOf(rs.getInt("spending_id"));
	             String amount = String.valueOf(rs.getDouble("spending_amount"));
	             String date = rs.getString("date");
	          
	             
	            String data [] = {id,amount,date};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)spending_table.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		//	
			
		 
		spendingAmountField = new JTextField();
		spendingAmountField.setBounds(715, 246, 130, 26);
		frame.getContentPane().add(spendingAmountField);
		spendingAmountField.setColumns(10);
		
		JButton sAddButton = new JButton("add");
		sAddButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		sAddButton.setBounds(715, 272, 60, 29);
		sAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
					Statement stmt = MyConnection.getConnection().createStatement();
					Double amount = Double.valueOf(spendingAmountField.getText());
					double a = amount;
					String sql = "INSERT INTO spending(user_id,date,spending_amount,category_name) "
							+ "VALUES('"+usr.getId()+"','"+spendingDateField.getText()+"',"+a+",'"+spendingCategoryField.getText()+"')";
					stmt.execute(sql);
					spendingAmountField.setText("");
					
					MyConnection.getConnection().close();
				}catch(Exception ex) {System.out.print(ex);}
			}
	
		});
		frame.getContentPane().add(sAddButton);
		
		JLabel lblNewLabel = new JLabel("spending amount");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel.setBounds(715, 231, 110, 16);
		frame.getContentPane().add(lblNewLabel);
		
		budgetField = new JTextField();
		budgetField.setBounds(258, 246, 130, 26);
		frame.getContentPane().add(budgetField);
		budgetField.setColumns(10);
		
		JButton bAddButton = new JButton("add");
		bAddButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		bAddButton.setBounds(258, 272, 60, 29);
		bAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybudget","root","Joshua3421");
					Statement stmt = MyConnection.getConnection().createStatement();
					//Statement cStmt = MyConnection.getConnection().createStatement();
					Double amount = Double.valueOf(budgetField.getText());
					String sql = "INSERT INTO categories(name,user_id,budget,date) VALUES('"+budgetCategoryField.getText()+"','"+usr.getId()+"','"+amount+"','"+budgetDateField.getText()+"')";
					//String categoryQ = "UPDATE categories SET budget_id = '"+getBudID()+"' WHERE categoryID='"+getCatID()+"'";
					stmt.execute(sql);
					//cStmt.execute(categoryQ);
					budgetField.setText("");
					
					MyConnection.getConnection().close();
				}catch(Exception ex) {System.out.print(ex);}
			}
	
		});
		frame.getContentPane().add(bAddButton);
		
		JLabel lblNewLabel_1 = new JLabel("budget");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(258, 231, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		spendingCategoryField = new JTextField();
		spendingCategoryField.setBounds(715, 185, 130, 26);
		frame.getContentPane().add(spendingCategoryField);
		spendingCategoryField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("category");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(715, 169, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		spendingDateField = new JTextField();
		spendingDateField.setBounds(715, 115, 130, 26);
		frame.getContentPane().add(spendingDateField);
		spendingDateField.setColumns(10);
		
		JLabel dateLabel = DefaultComponentFactory.getInstance().createLabel("date");
		dateLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		dateLabel.setBounds(715, 100, 120, 16);
		frame.getContentPane().add(dateLabel);
		
		JLabel spendingTitle = DefaultComponentFactory.getInstance().createTitle("Spending Manager");
		spendingTitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		spendingTitle.setBounds(715, 49, 130, 16);
		frame.getContentPane().add(spendingTitle);
		
		JLabel lblNewLabel_2_1 = new JLabel("category");
		lblNewLabel_2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(257, 169, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		budgetCategoryField = new JTextField();
		budgetCategoryField.setBounds(258, 193, 130, 26);
		budgetCategoryField.setColumns(10);
		frame.getContentPane().add(budgetCategoryField);
		
		budgetDateField = new JTextField();
		budgetDateField.setBounds(258, 115, 130, 26);
		budgetDateField.setColumns(10);
		frame.getContentPane().add(budgetDateField);
		
		id_textField = new JTextField();
		id_textField.setBounds(778, 77, 67, 26);
		frame.getContentPane().add(id_textField);
		id_textField.setColumns(10);
		
		JLabel idLabel = new JLabel("id");
		idLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		idLabel.setBounds(763, 82, 12, 16);
		frame.getContentPane().add(idLabel);
		
		JLabel datelabel2 = DefaultComponentFactory.getInstance().createLabel("date");
		datelabel2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		datelabel2.setBounds(258, 100, 120, 16);
		frame.getContentPane().add(datelabel2);
		
		JButton budgetUpdateButton = new JButton("update");
		budgetUpdateButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		budgetUpdateButton.setBounds(315, 272, 67, 29);
		budgetUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Statement stmt = MyConnection.getConnection().createStatement();
					
					Double amount = Double.valueOf(budgetField.getText());
					String sql = "UPDATE categories SET budget = "+amount+" WHERE name = '"+budgetCategoryField.getText()+"' "
							+ "AND user_id = "+usr.getId()+" AND date = '"+budgetDateField.getText()+"'";
				
					stmt.execute(sql);
					
					budgetField.setText("");
					
					MyConnection.getConnection().close();
				}catch(Exception ex) {System.out.print(ex);}
			}
		});
		frame.getContentPane().add(budgetUpdateButton);
		
		JButton budgetremoveButton = new JButton("remove");
		budgetremoveButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		budgetremoveButton.setBounds(258, 294, 75, 29);
		budgetremoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Statement stmt = MyConnection.getConnection().createStatement();
					
					String sql = "DELETE FROM categories WHERE name = '"+budgetCategoryField.getText()+"' "
							+ "AND user_id = "+usr.getId()+" AND date = '"+budgetDateField.getText()+"'";
				
					stmt.execute(sql);
					
					budgetCategoryField.setText("");
					
					MyConnection.getConnection().close();
				}catch(Exception ex) {System.out.print(ex);}
			}
		});
		frame.getContentPane().add(budgetremoveButton);
		
		JButton spendingUpdateButton = new JButton("update");
		spendingUpdateButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		spendingUpdateButton.setBounds(772, 272, 67, 29);
		spendingUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Statement stmt = MyConnection.getConnection().createStatement();
					Double amount = Double.valueOf(spendingAmountField.getText());
					double a = amount;
					Integer id = Integer.valueOf(id_textField.getText());
					String sql = "UPDATE spending SET spending_amount="+a+" WHERE user_id = "+usr.getId()+" AND spending_id="+id+"";
					stmt.execute(sql);
					spendingAmountField.setText("");
					
					MyConnection.getConnection().close();
				}catch(Exception ex) {System.out.print(ex);}
			}
	
		});
		frame.getContentPane().add(spendingUpdateButton);
		
		JButton spendingRemoveButton = new JButton("remove");
		spendingRemoveButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		spendingRemoveButton.setBounds(715, 294, 75, 29);
		spendingRemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Statement stmt = MyConnection.getConnection().createStatement();
					Double amount = Double.valueOf(spendingAmountField.getText());
					double a = amount;
					Integer id = Integer.valueOf(id_textField.getText());
					String sql = "DELETE FROM spending WHERE user_id = "+usr.getId()+" AND spending_id="+id+"";
					stmt.execute(sql);
					spendingAmountField.setText("");
					
					MyConnection.getConnection().close();
				}catch(Exception ex) {System.out.print(ex);}
			}
	
		});
		frame.getContentPane().add(spendingRemoveButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(420, 49, 425, 303);
		panel.setBackground(new Color(255, 116, 0));
		frame.getContentPane().add(panel);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Budget Manager");
		lblNewJgoodiesTitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewJgoodiesTitle.setBounds(258, 49, 112, 16);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(18, 49, 380, 303);
		panel_1.setBackground(new Color(255, 116, 0));
		frame.getContentPane().add(panel_1);
		
		JButton reportButton = new JButton("Generate Report");
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report r = new report();
				r.getFrame().setVisible(true);
			}
		});
		reportButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		reportButton.setBounds(347, 364, 130, 29);
		frame.getContentPane().add(reportButton);
		
		
		
		
		
		
		
		
		
		
		
		
		//frame.getContentPane().add(table);
}
}
