package StockPossesionPage;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Homepage.HomePage;
import Info.CustomerInfo;
import PastTransactionPage.PastTransaction;
import Startpage.StartPage;
import dependencies.*;
import stocksPage.StocksPage;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class StockPossesionGUI extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PastTransactionsGUI frame = new PastTransactionsGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StockPossesionGUI(CustomerInfo data) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		frame.setResizable(false);
		// contentPane.setBorder(new EmptyBorder(0, 0, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(245, 252, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,51));
		panel_1.setBounds(0, 0, 300, 600);
		panel.add(panel_1);
		panel_1.setLayout(null);

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
        panel_1.add(b);

		
		JLabel lblNewLabel_1 = new JLabel("TRANSACTION HISTORY");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				PastTransaction PT = new PastTransaction(data);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(35, 364, 265, 38);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		
        

		JLabel lblNewLabel_1_1 = new JLabel("      STOCK POSSESSION");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBackground(new Color(68, 68, 135));
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(0, 200, 300, 66);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SEARCH STOCK");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				try {
					StocksPage SPg = new StocksPage(data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(35, 294, 265, 38);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(" DASHBOARD");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				HomePage HP = new HomePage(data);
			}
		});
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(35, 130, 265, 38);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel = new JLabel("STOCK POSSESSION");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(323, 10, 488, 80);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(321, 100, 640, 439);
		panel.add(scrollPane);
		
		ShowFile SF = new ShowFile();
		AbsolutePath Path = new AbsolutePath();
		String Read = SF.ShowFileReadable(Path.AbsPath() + "src/CustomerPOssesionFiles/" + data.AadharNo + ".txt");
		
		JTextArea textArea = new JTextArea(Read);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setBackground(new Color(245, 252, 255));
//		textArea.setBounds(333, 123, 578, 366);
		scrollPane.setViewportView(textArea);
		
		 
//		JTextArea textArea = new JTextArea(Read);
//		textArea.setEditable(false);
//		textArea.setFont(new Font("Arial", Font.PLAIN, 22));
//		textArea.setBackground(new Color(245, 252, 255));
//		textArea.setBounds(333, 123, 578, 366);
//		panel.add(textArea);
		
        
		
		
		frame.setVisible(true);
	}
}