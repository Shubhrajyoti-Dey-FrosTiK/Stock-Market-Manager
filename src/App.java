import java.math.BigDecimal;

import javax.swing.JFrame;

import DeleteAccountPage.DeleteAccount;
import Homepage.HomePage;
import Info.CustomerInfo;
import Info.StockInfo;
import Loginpage.loginPage;
import PastTransactionPage.*;
import SignupPage.*;
import Startpage.StartPage;
import StockPossesionPage.StockPossesion;
import stocksPage.StocksPage;
import stocksPage.Backend.BuyOperation;
import stocksPage.Backend.GetStock;
import stocksPage.Backend.SellOperation;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // loginPage LP= new loginPage();
        // SignUp s = new SignUp();
        // JFrame frame = new JFrame();
        StartPage SP = new StartPage();


        // CustomerInfo data = new CustomerInfo();
        // data.EmailID = "sakshi@gmail.com";
        // data.AadharNo = "123";
        // data.FullName = "Sakshi Sharan";
        // data.Username = "SakshiOP";

        // StockInfo info = new StockInfo();
        // info.Price =new BigDecimal(120.0);
        // info.Symbol = "GOOG";
        // SellOperation BO = new SellOperation(data, info, 2); 


        // StocksPage StP = new StocksPage(data);

        
        // PastTransaction PT = new PastTransaction(data);   

        // StockPossesion SPs = new StockPossesion(data);
        
        // CustomerInfo data = new CustomerInfo();
        // data.EmailID = "sakshi@gmail.com";
        // HomePage H = new HomePage(data);

        // GetStock g= new GetStock();
        // StockInfo info = g.getStock("gog");
        // System.out.println(info.isValid);

        // DeleteAccount del = new DeleteAccount(data);
    }
}
