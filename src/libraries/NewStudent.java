package libraries;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class NewStudent extends JFrame {

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
					NewStudent frame = new NewStudent();
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
	public NewStudent() {
		setFont(new Font("Algerian", Font.BOLD, 14));
		setMaximizedBounds(new Rectangle(325, 125, 700, 450));
		setBounds(100, 100, 672, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add student details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 646, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(83, 137, 135, 35);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(83, 183, 135, 35);
		contentPane.add(lblName);
		
		JLabel lblCourseName = new JLabel("COURSE NAME");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseName.setBounds(83, 275, 135, 35);
		contentPane.add(lblCourseName);
		
		JLabel lblFaculty = new JLabel("FACULTY");
		lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFaculty.setBounds(83, 321, 135, 35);
		contentPane.add(lblFaculty);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(83, 229, 135, 35);
		contentPane.add(lblGender);
		
		textField = new JTextField();
		textField.setBackground(new Color(192, 192, 192));
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(287, 137, 173, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(192, 192, 192));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(287, 192, 173, 26);
		contentPane.add(textField_1);
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		comboBox_2.setBounds(287, 238, 173, 26);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BACHELOR OF SCIENCE", "AGRICULTURE", "ANIMAL SCIENCE", "B.TECH", "BIOCHEMISTRY", "COMPUTER SCIENCE", "SOCIAL SCIENCE"}));
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(287, 284, 173, 26);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BUSINESS", "ENGINEERING", "SOCIAL SCIENCES", "MEDICINE", "HUMANITIES"}));
		comboBox_1.setForeground(new Color(0, 0, 0));
		comboBox_1.setBounds(287, 321, 173, 29);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Student_ID = textField.getText();
				String Sname = textField_1.getText();
				String gender = (String)comboBox_2.getSelectedItem();
				String coursename = (String) comboBox.getSelectedItem();
				String faculty = (String) comboBox_1.getSelectedItem();
				
				try{
					Connection MyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "");
					
					String query = "INSERT INTO `student`(`Student_ID`, `Sname`, `gender`, `coursename`, `faculty`)"
							+ " VALUES ('"+Student_ID+"','"+Sname+"','"+gender+"','"+coursename+"','"+faculty+"')";
					
					
					Statement sta = MyConn.createStatement();
					sta.executeUpdate(query);
					
					JOptionPane.showMessageDialog(btnNewButton, "successfuly saved");
					setVisible(false);
					
					new NewStudent().setVisible(true);
				
				
				}catch(Exception exception){
					JOptionPane.showMessageDialog(btnNewButton, "student id already exists");
					setVisible(false);
					
					new NewStudent().setVisible(true);
					
					
				}
				
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(116, 367, 135, 35);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(410, 361, 135, 35);
		contentPane.add(btnClose);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblNewLabel, lblStudentId, lblName, lblCourseName, lblFaculty, lblGender, textField, textField_1, comboBox_2, comboBox, comboBox_1, btnNewButton, btnClose}));
		
		
	}

}
