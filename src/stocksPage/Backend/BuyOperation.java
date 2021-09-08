package stocksPage.Backend;

import java.math.BigDecimal;

import Info.CustomerInfo;
import Info.StockInfo;
import currentDate.CurrentDate;
import dependencies.AbsolutePath;
import dependencies.WriteToFile;

public class BuyOperation {

    public BuyOperation(CustomerInfo data,StockInfo StockData,int Volume){
        WriteToFile w = new WriteToFile();
        AbsolutePath Path = new AbsolutePath();
        CurrentDate Date = new CurrentDate();
        CheckSymbol c = new CheckSymbol();
        String Store = StockData.Symbol + " " + String.valueOf(Volume) + " units "  +  "Price  : " + StockData.Price + " Date & Time : " + Date.currentDate(); 
        int SerialNo = c.checkSymbol(StockData.Symbol,Path.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt");
        w.writeToFile(Store, Path.AbsPath() + "src/BuyInfoFiles/" + data.AadharNo + ".txt");
        System.out.println(Path.AbsPath() + "src/BuyInfoFiles/" + data.AadharNo + ".txt");
        System.out.println(SerialNo);
        w.writeToFile("BUY " + Store, Path.AbsPath() + "src/CustomerDataFiles/" + data.AadharNo + ".txt");

        if(SerialNo == -1){
            Store = StockData.Symbol + " " + Volume + " " + String.valueOf(BigDecimal.valueOf( Volume ).multiply( StockData.Price)) +" "+ "BUY" ;
            w.writeToFile(Store,Path.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt");
        }else{
            ModifyVolumeBUY m = new ModifyVolumeBUY(data,StockData.Symbol,Volume,StockData.Price,Path.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt");
        }

    }
}
