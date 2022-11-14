package libraries;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import libraries.NewStudent;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import java.awt.Point;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setResizable(false);
		setUndecorated(true);
		setPreferredSize(new Dimension(0, 0));
		setTitle("ADMIN PANEL");
		setBounds(0, 0, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminstrtorPanel = new JLabel("ADMINSTRATOR PANEL");
		lblAdminstrtorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAdminstrtorPanel.setBounds(new Rectangle(1, 1, 1, 1));
		lblAdminstrtorPanel.setBackground(new Color(169, 169, 169));
		lblAdminstrtorPanel.setForeground(new Color(0, 0, 255));
		lblAdminstrtorPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminstrtorPanel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblAdminstrtorPanel.setBounds(10, 11, 249, 45);
		contentPane.add(lblAdminstrtorPanel);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBounds(988, 520, 193, 73);
		contentPane.add(btnLogOut);
		btnLogOut.setActionCommand("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Close");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to LOG OUT", "LIBRARY MNAGEMENT SYSTEM",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
				setVisible(false);
			}
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("BOOK REPORTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BookReport().setVisible(true);
				
			}});
		btnNewButton.setBounds(160, 520, 229, 73);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton button = new JButton("NEW STUDENT");
		button.setBounds(282, 11, 193, 73);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new NewStudent().setVisible(true);

					
					
			}
		});
		button.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnNewStundent = new JButton("NEW BOOK");
		btnNewStundent.setBounds(539, 11, 193, 73);
		contentPane.add(btnNewStundent);
		btnNewStundent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NewBook().setVisible(true);
							}
		});
		btnNewStundent.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnIssiueBook = new JButton("ISSIUE BOOK");
		btnIssiueBook.setBounds(782, 11, 193, 73);
		contentPane.add(btnIssiueBook);
		btnIssiueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IssiueBook().setVisible(true);
				
			}
		});
		btnIssiueBook.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnReturnBook = new JButton("RETURN BOOK");
		btnReturnBook.setBounds(1039, 11, 222, 73);
		contentPane.add(btnReturnBook);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new returnBook().setVisible(true);
			}
		});
		btnReturnBook.setFont(new Font("SansSerif", Font.BOLD, 20));
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblAdminstrtorPanel, btnLogOut, btnNewButton, button, btnNewStundent, btnIssiueBook, btnReturnBook}));
	}
	
}
