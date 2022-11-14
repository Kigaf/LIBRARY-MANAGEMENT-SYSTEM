package libraries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;

public class NewBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
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
	public NewBook() {
		
		
		
		
		
		
		
		setSize(new Dimension(325, 125));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(325, 125, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("book id");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookId.setBounds(133, 96, 89, 24);
		contentPane.add(lblBookId);
		
		JLabel lblName = new JLabel("Book Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(133, 131, 89, 24);
		contentPane.add(lblName);
		
		JLabel lblPublisher = new JLabel("publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPublisher.setBounds(133, 166, 89, 24);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(133, 201, 89, 24);
		contentPane.add(lblPrice);
		
		JLabel lblPublisherYear = new JLabel("publisher year");
		lblPublisherYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPublisherYear.setBounds(133, 236, 113, 24);
		contentPane.add(lblPublisherYear);
		
		textField = new JTextField();
		textField.setBounds(394, 98, 161, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(394, 132, 161, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(394, 168, 161, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(394, 203, 161, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(394, 237, 161, 26);
		contentPane.add(textField_4);
		
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bookid = textField.getText();
				String name = textField_1.getText();
				String publisher = textField_2.getText();
				String price = textField_3.getText();
				String publisheryear = textField_4.getText();
				
				
				try{
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					
					String query = ("INSERT INTO `books`(`book_Id`, `name`, `publisher`, `price`, `publisher_year`)"
							+ " VALUES ('"+bookid+"','"+name+"','"+publisher+"','"+price+"','"+publisheryear+"')");
					
					
					Statement sta = MyConn.createStatement();
					sta.executeUpdate(query);
					
					JOptionPane.showMessageDialog(btnSave, "successfuly saved");
					setVisible(false);
					
					new NewBook().setVisible(true);
				
				}catch(Exception exception){
					JOptionPane.showMessageDialog(btnSave, "book id already exists");
					setVisible(false);
					
					new NewBook().setVisible(true);
					
					
				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(175, 337, 120, 59);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Inventory System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
				setVisible(false);
			}}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(516, 337, 126, 59);
		contentPane.add(btnExit);
		
		JLabel lblAddNewBook = new JLabel("ADD  NEW BOOK DETAILS");
		lblAddNewBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddNewBook.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAddNewBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewBook.setBounds(202, 28, 353, 38);
		contentPane.add(lblAddNewBook);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblBookId, lblName, lblPublisher, lblPrice, lblPublisherYear, textField, textField_1, textField_2, textField_3, textField_4, btnSave, btnExit}));
	}
}
