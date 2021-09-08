package Startpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Loginpage.LoginPageGUI;
import Loginpage.loginPage;
import SignupPage.SignUp;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartPageGUI{
	
	private JFrame frame = new JFrame(); 
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				startpage frame = new startpage();
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	/**
	 * Create the frame.
	 */
	public StartPageGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 252, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		contentPane.setBounds(100, 100, 1000, 600);

		// JPanel panel = new JPanel();
		// panel.setBackground(Color.GRAY);
		// panel.setBounds(0, 0, 260, 563);
		// contentPane.add(panel);
		// panel.setLayout(null);
		
		JPanel lblNewLabel_4 = new JPanel();
		// lblNewLabel_4.setIcon(new ImageIcon(StartPageGUI.class.getResource("/IMAGES/WhatsApp Image 2021-06-10 at 7.12.50 PM.jpeg")));
		lblNewLabel_4.setBounds(0, 0, 200, 600);
		lblNewLabel_4.setBackground(new Color(0,0,51));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Stock Market Manager");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(220, 33, 600, 42);
		contentPane.add(lblNewLabel);
		
		JTextArea lblNewLabel_1 = new JTextArea();
		lblNewLabel_1.setLineWrap(true);
		lblNewLabel_1.setWrapStyleWord(true);
		lblNewLabel_1.setText("Developed by:	Shubhrajyoti Dey\n	Sakshi Sharan\n	Harsh Lalit Parmar\n\nThis project will help the User to manage their stock market needs.\nUser can view real-time stocks, their prices and various other details.\nUser can also BUY and SELL stocks, view transaction history, current stocks in possession and the profit made.\nUser needs to create an account first. If an account is existing, user can login to the user account dashboard.\n\nThis project uses YahooFinanceAPI and implements www.tradingview.com using Java, JavaFX and Swing/AWT to provide search services.\nFile Handling is used to store the user's details. \nWeb Scraping from www.googlefinance.com is used to make the program more attractive and add current news headlines to the dashboard page. ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(220, 105, 458, 448);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBackground(new Color(245, 252, 255));
		contentPane.add(lblNewLabel_1);
		
		JButton lblNewLabel_2 = new JButton("LOGIN");
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setBackground(new Color(255,101,45));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBorderPainted(false);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				loginPage L = new loginPage();
			}
		});
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(700, 100, 250, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton lblNewLabel_3 = new JButton("SIGN UP");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setBackground(new Color(255,101,45));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBorderPainted(false);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SignUp SU = new SignUp();
			}
		});
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(700, 170, 250, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		// lblNewLabel_5.setIcon(new ImageIcon(StartPageGUI.class.getResource("/IMAGES/WhatsApp Image 2021-06-10 at 7.12.50 PM.jpeg")));
		lblNewLabel_5.setBounds(913, 177, -389, 288);
		contentPane.add(lblNewLabel_5);

		frame.setVisible(true);
	}
}
