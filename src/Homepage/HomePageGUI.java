package Homepage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DeleteAccountPage.DeleteAccount;
import Homepage.Backend.GetNews;
import Info.CustomerInfo;
import PastTransactionPage.PastTransaction;
import Startpage.StartPage;
import StockPossesionPage.StockPossesion;
import dependencies.AbsolutePath;
import dependencies.Details;
import dependencies.SerialNoFinder;
import stocksPage.StocksPage;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;

public class HomePageGUI extends JFrame {

    private JFrame frame = new JFrame();
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public HomePageGUI(CustomerInfo data) {
		
		SerialNoFinder SLF = new SerialNoFinder();
        AbsolutePath path = new AbsolutePath();
        String FileName = path.AbsPath() + "src/CustomerInfoFiles/CustomerDatabase.txt";
        int SerialNo = SLF.serialNoFinder(data.EmailID, FileName);
        System.out.println(SerialNo);
        Details d = new Details();
        String Name = d.details(SerialNo, path.AbsPath() + "src/CustomerInfoFiles/CustomerNames.txt");
        String Aadhar = d.details(SerialNo, path.AbsPath() + "src/CustomerInfoFiles/CustomerAadhar.txt");
        String UserName =  d.details(SerialNo, path.AbsPath() + "src/CustomerInfoFiles/CustomerUserName.txt");
        data.AadharNo = Aadhar;
        data.FullName = Name;
        data.Username = UserName;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 252, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		contentPane.setLayout(null);

		JButton del = new JButton();
		del.setOpaque(true);
		del.setBorderPainted(false);
		del.setBackground(new Color(255,0,0));
			// Search.setBounds(820,120,150,40);
			del.setBounds(770,35,190,34);
			del.setForeground(Color.white);
			del.setFont(new Font("Arial", Font.PLAIN, 14));
			del.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFrame f = new JFrame("Select Volume");
					f.setBounds(200, 200, 350, 170);
					f.setBackground(new Color(245, 252, 255));

					JLabel text = new JLabel("Are you sure you want ot delete your account");
					// text.setLineWrap(true);
					// text.setBackground(new Color(245, 252, 255));
					text.setFont(new Font("Arial", Font.PLAIN, 16));
					text.setBounds(17,20,400,40);
					f.getContentPane().add(text);

					JButton btn = new JButton("YES");
					btn.setOpaque(true);
					btn.setBorderPainted(false);
					btn.setBackground(new Color(255,0,0));
						// Search.setBounds(820,120,150,40);
					btn.setBounds(45,70,120,50);
					btn.setForeground(Color.white);
					btn.setFont(new Font("Arial", Font.PLAIN, 17));
					btn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							f.dispose();
							DeleteAccount DA = new DeleteAccount(data); 
							frame.dispose();
							StartPage SPg = new StartPage();
						}
					});
					f.getContentPane().add(btn);

					JButton btnNO = new JButton("NO");
					btnNO.setOpaque(true);
					btnNO.setBorderPainted(false);
					btnNO.setBackground(new Color(0,128,0));
						// Search.setBounds(820,120,150,40);
						btnNO.setBounds(175,70,120,50);
						btnNO.setForeground(Color.white);
						btnNO.setFont(new Font("Arial", Font.PLAIN, 17));
						btnNO.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							f.dispose();
						}
					});
					f.getContentPane().add(btnNO);
					

					JPanel pn = new JPanel();
					pn.setBounds(0,0,500,200);
					pn.setBackground(new Color(245, 252, 255));
					f.getContentPane().add(pn);

					f.setVisible(true);
				}
			});
			del.setText(" DELETE ACCOUNT");
			contentPane.add(del);
		
		JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel_1.setBounds(321, 35, 320, 42);
		contentPane.add(lblNewLabel_1);
		
		JButton b = new JButton("SIGN OUT");
        b.setForeground(Color.white);
        b.setBackground(new Color(255,101,45));
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                StartPage SPg = new StartPage();
            }
        });
        b.setFont(new Font("Arial", Font.PLAIN, 15));
        b.setBounds(20, 40, 250, 50);
        contentPane.add(b);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 300, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STOCK POSSESSION");
		lblNewLabel.setBounds(30, 222, 240, 40);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                frame.dispose();
                StockPossesion SPos = new StockPossesion(data);
			}
		});
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("SEARCH STOCK");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(30, 307, 240, 40);
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                frame.dispose();
                try {
					
					StocksPage SPge = new StocksPage(data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TRANSACTION HISTORY");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(30, 386, 330, 40);
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                frame.dispose();
                PastTransaction PT = new PastTransaction(data);
			}
		});
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("     DASHBOARD");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(new Color(68, 68, 135));
		lblNewLabel_1_1.setBounds(0, 124, 300, 66);
		panel.add(lblNewLabel_1_1);
		
		JTextArea textArea = new JTextArea("Hello, "+ Name);
		textArea.setEditable(false);
		textArea.setBackground(new Color(245, 252, 255));
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea.setBounds(321, 108, 260, 29);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea("Aadhar No: "+ Aadhar);
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(245, 252, 255));
		textArea_1.setBounds(321, 138, 260, 29);
		contentPane.add(textArea_1);
		
		JTextArea textArea_1_1 = new JTextArea("Username: " + UserName);
		textArea_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea_1_1.setEditable(false);
		textArea_1_1.setBackground(new Color(245, 252, 255));
		textArea_1_1.setBounds(615, 108, 260, 29);
		contentPane.add(textArea_1_1);
		
		JTextArea textArea_1_2 = new JTextArea("Email ID: "+ data.EmailID);
		textArea_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea_1_2.setEditable(false);
		textArea_1_2.setBackground(new Color(245, 252, 255));
		textArea_1_2.setBounds(615, 138, 260, 29);
		contentPane.add(textArea_1_2);
		
		SerialNoFinder SF = new SerialNoFinder();
		AbsolutePath p = new AbsolutePath();
		int sl = SF.serialNoFinder(data.EmailID, p.AbsPath() + "src/CustomerInfoFiles/CustomerDatabase.txt");
		Details det = new Details();
		String Money = det.details(SerialNo, p.AbsPath() + "src/CustomerInfoFiles/CustomerMoney.txt");

		JTextArea textArea_1_3 = new JTextArea("Profit: " + Money + " USD");
		textArea_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea_1_3.setEditable(false);
		textArea_1_3.setBackground(new Color(245, 252, 255));
		textArea_1_3.setBounds(321, 167, 260, 29);
		contentPane.add(textArea_1_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(321, 259, 626, 268);
		scrollPane.setBackground(new Color(245, 252, 255));
		contentPane.add(scrollPane);
		
		GetNews g = new GetNews();
		String News="";
		try {
			News = g.getNews();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(245, 252, 255));
		textArea_2.setText(News);
		textArea_2.setEditable(false);
		textArea_2.setFont(new Font("Arial", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea_2);
		
		JLabel lblNewLabel_2 = new JLabel("Today's News");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(320, 226, 149, 22);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(321, 204, 630, 12);
		contentPane.add(separator);
		
		frame.setVisible(true);
	}
}