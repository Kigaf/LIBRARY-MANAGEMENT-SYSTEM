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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class returnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook frame = new returnBook();
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
	public returnBook() {
		setResizable(false);
		setUndecorated(true);
		setTitle("ADMIN PANEL - RETURN BOOK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(325, 125, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK ");
		lblReturnBook.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnBook.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblReturnBook.setBounds(164, 11, 418, 80);
		contentPane.add(lblReturnBook);
		
		JLabel lblNewLabel = new JLabel("BOOK ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(125, 148, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(125, 187, 100, 26);
		contentPane.add(lblStudentId);
		
		JLabel lblIssiueDate = new JLabel("ISSIUE DATE");
		lblIssiueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIssiueDate.setBounds(125, 224, 100, 32);
		contentPane.add(lblIssiueDate);
		
		JLabel lblDueDate = new JLabel("DUE DATE");
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDueDate.setBounds(125, 267, 100, 26);
		contentPane.add(lblDueDate);
		
		textField = new JTextField();
		textField.setBounds(297, 139, 188, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(297, 181, 188, 26);
		contentPane.add(textField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(297, 224, 188, 26);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(297, 267, 188, 26);
		contentPane.add(dateChooser_1);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String book_Id = textField.getText();
				String Student_ID = textField_1.getText();
				try{
		      
				Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
				Statement st = MyConn.createStatement();
				st.executeUpdate("UPDATE `issue_book` SET Return_Book = 'YES' WHERE Student_ID ='"+Student_ID+"' AND book_Id = '"+book_Id+"'");
				JOptionPane.showConfirmDialog(null, "BOOK HAS BEEN SUCCESSIFULLY RETURNED   ");
				setVisible(false);
				new returnBook().setVisible(true);
				
				
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
				
				
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReturn.setBounds(211, 344, 169, 50);
		contentPane.add(btnReturn);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Close");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "LIBRARY MANAGEMENT SYSTEM",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
				setVisible(false);
			}
			}});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(509, 344, 169, 50);
		contentPane.add(btnClose);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");
				String book_Id = textField.getText();
				String Student_ID = textField_1.getText();
				
				
				try{
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					Statement st = MyConn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM `issue_book` WHERE book_Id = '"+book_Id+"' AND Student_ID = '"+Student_ID+"'");
					
					if(rs.next()){
						dateChooser.setDate(rs.getDate(3));
						dateChooser_1.setDate(rs.getDate(4));
						
						textField.setEditable(false);
						textField_1.setEditable(false);

						
						
					}
					else{
						JOptionPane.showConfirmDialog(null, "BOOK IS NOT ISSIUED TO THIS STUDENT !!!  ");
						setVisible(false);
						new returnBook().setVisible(true);
					}
				
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
				}
			
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(495, 182, 87, 23);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 712, 450);
		contentPane.add(label);
	}
}
