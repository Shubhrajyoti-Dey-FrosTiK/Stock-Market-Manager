package stocksPage.Backend;

import java.math.BigDecimal;

import Info.CustomerInfo;
import Info.StockInfo;
import dependencies.*;

public class SellOperation {
    public SellOperation(CustomerInfo data,StockInfo StockData,int Volume){
        WriteToFile w = new WriteToFile();
        AbsolutePath Path = new AbsolutePath();
        CurrentDate Date = new CurrentDate();
        CheckSymbol c = new CheckSymbol();
        String Store = StockData.Symbol + " " + String.valueOf(Volume) + " units "  +  "Price  : " + StockData.Price + " Date & Time : " + Date.currentDate(); 
        int SerialNo = c.checkSymbol(StockData.Symbol,Path.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt");
        w.writeToFile(Store, Path.AbsPath() + "src/SellInfoFiles/" + data.AadharNo + ".txt");
        System.out.println(Path.AbsPath() + "src/SellInfoFiles/" + data.AadharNo + ".txt");
        w.writeToFile("SELL " + Store, Path.AbsPath() + "src/CustomerDataFiles/" + data.AadharNo + ".txt");
        System.out.println(SerialNo);

        if(SerialNo == -1){
            Store = StockData.Symbol + " " + Volume + " " + String.valueOf(BigDecimal.valueOf( Volume ).multiply( StockData.Price)) +" "+ "SELL" ;
            w.writeToFile(Store,Path.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt");
        }else{
            ModifyVolumeSELL m = new ModifyVolumeSELL(data,StockData.Symbol,Volume,StockData.Price,Path.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt");
        }
    }
}
