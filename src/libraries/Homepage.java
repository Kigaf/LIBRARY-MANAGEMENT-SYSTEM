package libraries;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Window.Type;
import javax.swing.JComboBox;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

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
		setTitle("ADMIN PANEL");
		setBounds(325, 125, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminstrtorPanel = new JLabel("ADMINSTRATOR PANEL");
		lblAdminstrtorPanel.setForeground(new Color(0, 0, 255));
		lblAdminstrtorPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminstrtorPanel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblAdminstrtorPanel.setBounds(10, -4, 684, 65);
		contentPane.add(lblAdminstrtorPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(10, 72, 684, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewStundent = new JButton("NEW BOOK");
		btnNewStundent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NewBook().setVisible(true);
							}
		});
		btnNewStundent.setBounds(0, 0, 193, 73);
		panel.add(btnNewStundent);
		btnNewStundent.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnIssiueBook = new JButton("ISSIUE BOOK");
		btnIssiueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IssiueBook().setVisible(true);
				
			}
		});
		btnIssiueBook.setBounds(481, 0, 193, 73);
		panel.add(btnIssiueBook);
		btnIssiueBook.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("BOOK REPORTS");
		btnNewButton.setBounds(41, 179, 229, 73);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnReturnBook = new JButton("RETURN BOOK");
		btnReturnBook.setBounds(390, 179, 222, 73);
		panel.add(btnReturnBook);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReturnBook.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton button = new JButton("NEW STUDENT");
		button.setBounds(221, 0, 193, 73);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new NewStudent().setVisible(true);

					
					
			}
		});
		button.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBounds(491, 346, 193, 73);
		contentPane.add(btnLogOut);
		btnLogOut.setActionCommand("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("SansSerif", Font.BOLD, 20));
	}
	
}
