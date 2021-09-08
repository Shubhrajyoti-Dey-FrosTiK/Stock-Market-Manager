package SignupPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Info.CustomerInfo;
import Loginpage.loginPage;
import Loginpage.loginPage;
import SignupPage.customer.Customer;
import SignupPage.customer.CustomerAccountCreate;
// import jdk.vm.ci.hotspot.JFR;
import Startpage.StartPage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpGUI  {

	private JFrame frame = new JFrame();
	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_email;
	private JTextField txt_fullname;
	private JTextField txt_aadhar;
	private JPasswordField txt_password;
	private JPasswordField txt_conpassword;

	
	/**
	 * Create the frame.
	 */
	public SignUpGUI(int flag) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		setContentPaneBackground(new Color(245, 252, 255));
		
		JLabel lblNewLabel_3 = new JLabel("< Back");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				StartPage SP = new StartPage();
			}
		});
		lblNewLabel_3.setBounds(20, 0, 116, 30);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.white);
		contentPane.add(lblNewLabel_3);

		// JPanel panel = new JPanel();
		// panel.setBackground(Color.LIGHT_GRAY);
		// panel.setForeground(Color.CYAN);
		// panel.setBounds(0, 0, 156, 563);
		// contentPane.add(panel);
		
		// JLabel lblNewLabel_2 = new JLabel("");
		// panel.add(lblNewLabel_2);
		// lblNewLabel_2.setIcon(new ImageIcon(SignUpGUI.class.getResource("/images/leftborder.jpeg")));
		JPanel leftJPanel = new JPanel();
		leftJPanel.setBounds(0,0,150,600);
		leftJPanel.setBackground(new Color(0,0,51));
		contentPane.add(leftJPanel);
              
		if(flag!=1)
		{
			if(flag==2){
				JLabel Aadhar_error = new JLabel("* Aadhar already exists");
				Aadhar_error.setFont(new Font("Arial", Font.PLAIN, 15));
				Aadhar_error.setForeground(Color.RED);
				Aadhar_error.setBounds(189, 394, 195, 24);
				contentPane.add(Aadhar_error);
			}
			else if(flag==3){
				JLabel email_error = new JLabel("* Email ID already exists");
				email_error.setForeground(Color.RED);
				email_error.setFont(new Font("Arial", Font.PLAIN, 15));
				email_error.setBounds(578, 221, 195, 24);
				contentPane.add(email_error);
			}
			else if(flag==4){
				JLabel password_error = new JLabel("* Passwords do not match");
				password_error.setForeground(Color.RED);
				password_error.setFont(new Font("Arial", Font.PLAIN, 15));
				password_error.setBounds(578, 394, 195, 24);
				contentPane.add(password_error);
			}
			
		}

		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 45));
		lblNewLabel.setBounds(173, 41, 221, 76);
		contentPane.add(lblNewLabel);
		
		txt_username = new JTextField();
		txt_username.setBounds(189, 193, 311, 30);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(189, 159, 136, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(578, 244, 136, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(578, 327, 284, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("AADHAR NO.");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(189, 327, 136, 24);
		contentPane.add(lblNewLabel_1_3);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(578, 193, 311, 30);
		contentPane.add(txt_email);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerInfo data = new CustomerInfo();
				data.Username = txt_username.getText();
				data.AadharNo = txt_aadhar.getText();
				data.EmailID = txt_email.getText();
				data.FullName = txt_fullname.getText();
				data.Password = txt_password.getPassword();
				data.ConPass = txt_conpassword.getPassword();
				// CustomerAccountCreate CAC = new CustomerAccountCreate(data);
				Customer C = new Customer();
				int flag = C.customer(data);
				if(flag!=1){
					contentPane.setVisible(false);
					SignUpGUI SUG = new SignUpGUI(flag);

				}else{
					frame.dispose();
					loginPage LP = new loginPage();
				}
				
			}
		});
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(new Color(255,101,45));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(425, 455, 195, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("FULL NAME");
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_3_1.setBounds(189, 244, 136, 24);
		contentPane.add(lblNewLabel_1_3_1);
		
		txt_fullname = new JTextField();
		txt_fullname.setColumns(10);
		txt_fullname.setBounds(189, 278, 311, 30);
		contentPane.add(txt_fullname);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("EMAIL ID");
		lblNewLabel_1_3_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_3_2.setBounds(578, 159, 136, 24);
		contentPane.add(lblNewLabel_1_3_2);
		
		txt_aadhar = new JTextField();
		txt_aadhar.setColumns(10);
		txt_aadhar.setBounds(189, 361, 311, 30);
		contentPane.add(txt_aadhar);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(578, 278, 311, 30);
		contentPane.add(txt_password);
		
		txt_conpassword = new JPasswordField();
		txt_conpassword.setBounds(578, 361, 311, 30);
		contentPane.add(txt_conpassword);
		

		// contentPane.setVisible(true);
		// frame.add(contentPane);
		frame.setVisible(true);
	}
	public Color getContentPaneBackground() {
		return contentPane.getBackground();
	}
	public void setContentPaneBackground(Color background) {
		contentPane.setBackground(background);
	}
}
