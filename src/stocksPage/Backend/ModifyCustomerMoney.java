package stocksPage.Backend;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import Info.CustomerInfo;
import dependencies.AbsolutePath;
import dependencies.SerialNoFinder;
import dependencies.StringCompare;

public class ModifyCustomerMoney {
    public ModifyCustomerMoney(CustomerInfo data,BigDecimal Profit){
        AbsolutePath p = new AbsolutePath();
        SerialNoFinder SF = new SerialNoFinder();
        int SerialNo = SF.serialNoFinder(data.EmailID,p.AbsPath() + "src/CustomerInfoFiles/CustomerDatabase.txt" );
        String Path = p.AbsPath() + "src/CustomerInfoFiles/CustomerMoney.txt";
        try {
            File obj=new File(Path);
            obj.createNewFile(); 
            Scanner sc= new Scanner(obj);
            int LineNumber =0;
            System.out.println("Details");
            String Resultant ="";
            StringCompare comp = new StringCompare();
            while(sc.hasNextLine())
            {
                String s= sc.nextLine();
                if(LineNumber == SerialNo){
                    Resultant =Resultant + Profit.toString() + "\n";
                }else{Resultant = Resultant + s + "\n";}
                LineNumber++;
            }
            sc.close();
            FileWriter f = new FileWriter(Path);
            System.out.println(Resultant);
            f.write(Resultant);
            f.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
