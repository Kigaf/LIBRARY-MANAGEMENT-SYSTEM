package libraries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.Rectangle;

public class IssiueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssiueBook frame = new IssiueBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IssiueBook() {
		setMaximizedBounds(new Rectangle(325, 125, 700, 450));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Book Id");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(125, 71, 98, 25);
		contentPane.add(lblDate);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(125, 107, 98, 41);
		contentPane.add(lblStudentId);
		
		JLabel lblIssiueDate = new JLabel("Issiue Date");
		lblIssiueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIssiueDate.setBounds(125, 142, 98, 58);
		contentPane.add(lblIssiueDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDueDate.setBounds(125, 206, 98, 48);
		contentPane.add(lblDueDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(285, 153, 191, 31);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(285, 213, 191, 31);
		contentPane.add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(284, 110, 191, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(285, 65, 191, 31);
		contentPane.add(textField_1);
		
		JButton btnSave = new JButton("Issiue");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-YYYY");
				String bookid = textField.getText();
				String StudentId = textField_1.getText();
				String issiueDate = dFormat.format(dateChooser.getDate());
				String Duedate = dFormat.format(dateChooser_1.getDate());
				String ReturnBook = "No";

				try{
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					
					
					Statement st = MyConn.createStatement();
					
					
					ResultSet rs = st.executeQuery("SELECT * FROM books WHERE book_Id ='"+bookid+"' ");
					
					
					if(rs.next()){
						ResultSet rs1 = st.executeQuery("SELECT * FROM student WHERE Student_ID = '"+StudentId+"'");
						if(rs1.next()){
							st.executeUpdate("INSERT INTO `issue_book` VALUES ('"+bookid+"','"+StudentId+"','"+issiueDate+"','"+Duedate+"','"+ReturnBook+"') ");
							JOptionPane.showConfirmDialog(null, "issiued successfully");
							setVisible(false);
							new IssiueBook().setVisible(true);
							
						}else
							JOptionPane.showConfirmDialog(null, "incorect StudentId");	
						
						
					}else
						JOptionPane.showConfirmDialog(null, "incorect bookid");
					
		
				
				}catch(Exception exception){
					{
												
				JOptionPane.showConfirmDialog(null, "connection error");	
					
					}
					
				}
			}}); 
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(144, 280, 131, 41);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("close"); 
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBounds(397, 280, 131, 41);
		contentPane.add(btnClose);
	}
	
	}

