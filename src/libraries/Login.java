package libraries;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("LIBRARY MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Alaska", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 25, 550, 54);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel.setForeground(new Color(0, 0, 128));
		panel.setBounds(111, 90, 325, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(146, 5, 0, 0);
		panel.add(label);
		
		JLabel lblUserneme = new JLabel("USERNAME");
		lblUserneme.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserneme.setBounds(35, 37, 74, 24);
		panel.add(lblUserneme);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(35, 83, 74, 24);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 205));
		textField.setBounds(177, 37, 113, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String USERNAME = textField.getText();
				String PASSWORD = passwordField.getText();

				try {
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					
					Statement st = MyConn.createStatement();
					
					String query = ("SELECT * FROM users WHERE username = '"+USERNAME+"' AND password ='"+PASSWORD+"' ");
					
					ResultSet rs = st.executeQuery(query);
					
					if(rs.next()){
						textField.setText(null);
						passwordField.setText(null);
						
						new Homepage().setVisible(true);
						
						
						
					}else{
						JOptionPane.showMessageDialog(null, "invalid login details", "LOGIN ERROR",JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
					 
					
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBackground(new Color(0, 255, 0));
		btnLogIn.setBounds(35, 141, 89, 23);
		panel.add(btnLogIn);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(Color.GREEN);
		btnExit.setBounds(195, 141, 89, 23);
		panel.add(btnExit);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 205));
		passwordField.setBounds(177, 86, 113, 21);
		panel.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(543, 63, -537, 2);
		contentPane.add(separator);
	}
	private void systemExit(){
		WindowEvent winClosing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	}
}
