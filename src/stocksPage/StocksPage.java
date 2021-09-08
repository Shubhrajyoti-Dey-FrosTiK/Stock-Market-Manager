package stocksPage;

import Info.CustomerInfo;
import Info.StockInfo;
import stocksPage.Backend.GetStock;
import java.io.IOException;

import javax.swing.JFrame;

public class StocksPage {
    public StocksPage(CustomerInfo data)throws IOException{
        GetStock g =  new GetStock();
        // StockInfo Info = g.getStock("GOOG"); 
        JFrame frame = new JFrame();
        StockInfo Info = new StockInfo();
        StockPageGUI GUI = new StockPageGUI(data,Info,0,frame);
        // System.out.println(Info.Name);
        // System.err.println(Info.Price);
        // System.out.println(Info.History);
    }
}
