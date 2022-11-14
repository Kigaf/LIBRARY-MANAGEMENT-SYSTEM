package libraries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BookReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReport frame = new BookReport();
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
	public BookReport() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(325, 125, 700, 450);
		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIssiueBookDetails = new JButton("ISSIUE BOOK DETAILS");
		btnIssiueBookDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					Statement st = MyConn.createStatement();
					ResultSet rs = st.executeQuery("SELECT issue_book.Student_ID,student.Sname,issue_book.book_Id,books.name,issue_book.IssueDate, issue_book.DueDate FROM "
				+ "student inner join books inner join issue_book WHERE books.book_Id = issue_book.book_Id and student.Student_ID = issue_book.Student_ID and Return_Book = 'No'");
					
                     ResultSetMetaData rsmd = rs.getMetaData();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i=0;i<cols;i++)
						 colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					
					String Student_Id,Sname,book_Id,name,IssueDate,DueDate;
					while(rs.next()){
						Student_Id = rs.getString(1);
						
						Sname = rs.getString(2);
						book_Id = rs.getString(3);
						name = rs.getString(4);
						IssueDate= rs.getString(5);
						DueDate = rs.getString(6);
						String[] row = {Student_Id,Sname,book_Id,name,IssueDate,DueDate};
						
						model.addRow(row);
						}
						st.close();
						MyConn.close();
						
					
				
				}catch(Exception e){
				e.printStackTrace();
				
			}
				
			
			}
			
		
		});
		btnIssiueBookDetails.setBounds(205, 11, 221, 34);
		contentPane.add(btnIssiueBookDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 56, 633, 142);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("RETURN BOOK DETAILS");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					Statement st = MyConn.createStatement();
					ResultSet rs = st.executeQuery("SELECT issue_book.Student_ID,student.Sname,issue_book.book_Id,books.name,issue_book.IssueDate, issue_book.DueDate FROM "
				+ "student inner join books inner join issue_book WHERE books.book_Id = issue_book.book_Id and student.Student_ID = issue_book.Student_ID and Return_Book = 'YES'");
					
                     ResultSetMetaData rsmd = rs.getMetaData();
					
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i=0;i<cols;i++)
						 colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					
					String Student_Id,Sname,book_Id,name,IssueDate,DueDate;
					while(rs.next()){
						Student_Id = rs.getString(1);
						
						Sname = rs.getString(2);
						book_Id = rs.getString(3);
						name = rs.getString(4);
						IssueDate= rs.getString(5);
						DueDate = rs.getString(6);
						String[] row = {Student_Id,Sname,book_Id,name,IssueDate,DueDate};
						
						model.addRow(row);
						}
						st.close();
						MyConn.close();
						
					
				
				}catch(Exception e){
				e.printStackTrace();
				
			}
				
			
			}
	

			
		});
		button.setBounds(205, 209, 221, 34);
		contentPane.add(button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 254, 638, 158);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			}
		});
		btnClose.setBounds(574, 427, 89, 23);
		contentPane.add(btnClose);
	}
}
