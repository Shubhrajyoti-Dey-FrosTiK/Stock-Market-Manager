package stocksPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.prompt.PromptSupport;

import Homepage.HomePage;

import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.FlowLayout;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.web.WebView;
import stocksPage.Backend.BuyOperation;
import stocksPage.Backend.GetStock;
import stocksPage.Backend.SellOperation;
import Info.CustomerInfo;
import Info.StockInfo;
import PastTransactionPage.PastTransaction;
import Startpage.StartPage;
import StockPossesionPage.StockPossesion;
import dependencies.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.ScrollPaneConstants;

public class StockPageGUI extends JFrame implements Runnable{
	

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
	public StockPageGUI(CustomerInfo data,StockInfo StockData,int flag,JFrame frame) {

		//  JFrame frame = new JFrame();
	 	JPanel contentPane;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		frame.setResizable(false);

		JFXPanel BrowserPanel = new JFXPanel();
		
		// JFXPanel InfoPanel = new JFXPanel();
		if(flag == 1){

			BrowserPanel.setBounds(750,45,620,600);
			LineBorder border = new LineBorder(Color.ORANGE, 4, true);
			BrowserPanel.setBorder(border);
			// BrowserPanel.
			contentPane.add(BrowserPanel); 

			Platform.runLater(()->{
				WebView Browser = new WebView();
				Browser.getEngine().load("https://in.tradingview.com/chart/?symbol=" + StockData.Symbol + "&source=unauth_header&feature=launch_chart");
				BrowserPanel.setScene(new Scene(Browser));

			});
			
			JLabel StockSymbol = new JLabel();
			StockSymbol.setBounds(320,250,300,50);
			StockSymbol.setText(StockData.Symbol);
			StockSymbol.setFont(new Font("Arial", Font.BOLD, 25));
			contentPane.add(StockSymbol);

			JLabel StockN = new JLabel();
			StockN.setBounds(320,280,300,50);
			StockN.setText(StockData.Name);
			StockN.setFont(new Font("Arial", Font.PLAIN, 15));
			contentPane.add(StockN);

			JLabel Price = new JLabel();
			Price.setBounds(320,320,300,50);
			Price.setText("Price : " + StockData.Price);
			Price.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Price);

			JLabel Currency = new JLabel();
			Currency.setBounds(320,350,300,50);
			Currency.setText("Currency : " + StockData.Currency);
			Currency.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Currency);

			JLabel DayHigh = new JLabel();
			DayHigh.setBounds(320,380,400,50);
			DayHigh.setText("Day High : " + StockData.DayHigh);
			DayHigh.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(DayHigh);

			JLabel DayLow = new JLabel();
			DayLow.setBounds(320,410,400,50);
			DayLow.setText("Day Low : " + StockData.DayLow);
			DayLow.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(DayLow);

			JLabel Open = new JLabel();
			Open.setBounds(320,440,400,50);
			Open.setText("Open : " + StockData.Open);
			Open.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Open);

			JLabel PrevClose = new JLabel();
			PrevClose.setBounds(320,470,400,50);
			PrevClose.setText("Previous Close : " + StockData.PreviousClose);
			PrevClose.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(PrevClose);

			JLabel YearHight = new JLabel();
			YearHight.setBounds(320,500,400,50);
			YearHight.setText("Year High : " + StockData.YearHigh);
			YearHight.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(YearHight);

			JLabel YearLow = new JLabel();
			YearLow.setBounds(320,530,400,50);
			YearLow.setText("Year Low : " + StockData.YearLow);
			YearLow.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(YearLow);

			// JLabel Bid = new JLabel();
			// Bid.setBounds(320,410,400,200);
			// Bid.setText("Bid" + StockData.Bid);
			// Bid.setFont(new Font("Arial", Font.PLAIN, 20));
			// contentPane.add(Bid);

			JLabel Avg200 = new JLabel();
			Avg200.setBounds(320,560,300,50);
			Avg200.setText("200 day average : " + StockData.Avg200);
			Avg200.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Avg200);
			
			JLabel Change200 = new JLabel();
			Change200.setBounds(320,590,300,50);
			Change200.setText("200 day change : " + StockData.Change200);
			Change200.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Change200);

			JLabel Change200P = new JLabel();
			Change200P.setBounds(320,620,300,50);
			Change200P.setText("200 day change % : " + StockData.Change200P);
			Change200P.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Change200P);

			JLabel Change50 = new JLabel();
			Change50.setBounds(320,650,300,50);
			Change50.setText("50 day change : " + StockData.Change50);
			Change50.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Change50);

			JLabel Change50P = new JLabel();
			Change50P.setBounds(320,680,300,50);
			Change50P.setText("50 day change % : " + StockData.Change50P);
			Change50P.setFont(new Font("Arial", Font.PLAIN, 20));
			contentPane.add(Change50P);

			JButton Buy = new JButton();
			Buy.setOpaque(true);
			Buy.setBorderPainted(false);
			Buy.setBackground(new Color(0,128,0));
			// Search.setBounds(820,120,150,40);
			Buy.setBounds(820,660,230,60);
			Buy.setForeground(Color.white);
			Buy.setFont(new Font("Arial", Font.PLAIN, 27));
			Buy.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFrame f = new JFrame("Select Volume");
					f.setBounds(200, 200, 450, 200);
					f.setBackground(new Color(245, 252, 255));

					JLabel text = new JLabel("Enter the volume you want to buy");
					// text.setLineWrap(true);
					// text.setBackground(new Color(245, 252, 255));
					text.setBounds(20,20,400,40);
					f.add(text);

					JTextField vol = new JTextField();
					vol.setBounds(20,70,250,60);
					f.add(vol);

					JButton btn = new JButton("BUY");
					btn.setOpaque(true);
					btn.setBorderPainted(false);
					btn.setBackground(new Color(0,128,0));
						// Search.setBounds(820,120,150,40);
					btn.setBounds(280,70,120,60);
					btn.setForeground(Color.white);
					btn.setFont(new Font("Arial", Font.PLAIN, 17));
					btn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							f.dispose();
							String dummy = vol.getText();
							BuyOperation BUY = new BuyOperation(data,StockData,Integer.parseInt(dummy));
						}
					});
					f.add(btn);
					

					JPanel pn = new JPanel();
					pn.setBounds(0,0,500,200);
					pn.setBackground(new Color(245, 252, 255));
					f.add(pn);

					f.setVisible(true);
				}
			});
			Buy.setText("BUY");
			contentPane.add(Buy);

			JButton Sell = new JButton();
			Sell.setOpaque(true);
			Sell.setBorderPainted(false);
			Sell.setBackground(new Color(255,0,0));
			// Search.setBounds(820,120,150,40);
			Sell.setBounds(1070,660,230,60);
			Sell.setForeground(Color.white);
			Sell.setFont(new Font("Arial", Font.PLAIN, 27));
			Sell.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFrame f = new JFrame("Select Volume");
					f.setBounds(200, 200, 450, 200);
					f.setBackground(new Color(245, 252, 255));

					JLabel text = new JLabel("Enter the volume you want to sell");
					// text.setLineWrap(true);
					// text.setBackground(new Color(245, 252, 255));
					text.setBounds(20,20,400,40);
					f.add(text);

					JTextField vol = new JTextField();
					vol.setBounds(20,70,250,60);
					f.add(vol);

					JButton btn = new JButton("SELL");
					btn.setOpaque(true);
					btn.setBorderPainted(false);
					btn.setBackground(new Color(255,0,0));
						// Search.setBounds(820,120,150,40);
					btn.setBounds(280,70,120,60);
					btn.setForeground(Color.white);
					btn.setFont(new Font("Arial", Font.PLAIN, 17));
					btn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							f.dispose();
							String dummy = vol.getText();
							SellOperation SELL = new SellOperation(data,StockData,Integer.parseInt(dummy));
						}
					});
					f.add(btn);
					

					JPanel pn = new JPanel();
					pn.setBounds(0,0,500,200);
					pn.setBackground(new Color(245, 252, 255));
					f.add(pn);

					f.setVisible(true);
				}
			});
			Sell.setText("SELL");
			contentPane.add(Sell);

		}Platform.setImplicitExit(false);
		
		
		if(flag==-1){
			JLabel Error = new JLabel();
			Error.setBounds(320,240,300,50);
			Error.setText(StockData.Name);
			Error.setFont(new Font("Arial", Font.PLAIN, 15));
			Error.setForeground(Color.red);
			contentPane.add(Error);
		}
		
		JTextField SearchBox = new JTextField();
		SearchBox.setBounds(310,120,400,40);
		contentPane.add(SearchBox);

		JLabel SearchLine = new JLabel();
		SearchLine.setBounds(323,95,300,30);
		SearchLine.setText("Enter the code of the stock you want to search");
		contentPane.add(SearchLine);

		JButton Search = new JButton();
		Search.setOpaque(true);
		Search.setBorderPainted(false);
		Search.setBackground(new Color(255,101,45));
		// Search.setBounds(820,120,150,40);
		Search.setBounds(320,170,150,40);
		Search.setForeground(Color.white);
		Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// StockPageGUI G = new StockPageGUI(data,1,frame);
		        String StockName = SearchBox.getText();
				System.out.println(StockName);
				if(StockName != null){
					GetStock g =  new GetStock();
					try {
						StockInfo Info =g.getStock(StockName);
						// StockInfo Info = new StockInfo(); 
						// Info.Symbol = StockName;
						// System.out.println(Info.Symbol);
						// System.out.println(Info.Name);
						contentPane.setVisible(false);
						if(Info.isValid == false){StockPageGUI GUI = new StockPageGUI(data,Info,-1,frame);}
						else if(Info.Symbol!=null){
							StockPageGUI GUI = new StockPageGUI(data,Info,1,frame);
						}else{StockPageGUI GUI = new StockPageGUI(data,Info,0,frame);}
						
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
					 
			}
		});
		Search.setText("SEARCH");
		contentPane.add(Search);

		
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
		panel.setBackground(new Color(245, 252, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,51));
		panel_1.setBounds(0, 0, 300, 800);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("STOCK POSSESSION");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				StockPossesion SPos = new StockPossesion(data);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(35, 208, 265, 38);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("TRANSACTION HISTORY");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel_1_1.setBackground(new Color(68, 68, 135));
		// lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				BrowserPanel.setVisible(false);
				Platform.setImplicitExit(false);
		        PastTransaction PT = new PastTransaction(data);
			}
		});
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(0, 364, 300, 66);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("      SEARCH STOCK");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
        lblNewLabel_1_2.setBackground(new Color(68, 68, 135));
        lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(0, 294, 300, 66);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("DASHBOARD");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				HomePage h = new HomePage(data);
			}
		});
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(35, 125, 265, 38);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel = new JLabel("SEARCH STOCK");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(323, 10, 488, 80);
		panel.add(lblNewLabel);
		
		
		frame.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	

}
