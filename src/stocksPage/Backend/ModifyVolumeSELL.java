package stocksPage.Backend;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import Info.CustomerInfo;
import dependencies.StringCompare;

public class ModifyVolumeSELL {
    public ModifyVolumeSELL(CustomerInfo data,String Symbol,int Volume,BigDecimal Price,String FileName){
        try {
            File obj=new File(FileName);
            obj.createNewFile(); 
            Scanner sc= new Scanner(obj);
            int LineNumber =1;
            String Resultant ="";
            StringCompare comp = new StringCompare();
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                String Store = "";
                for(int i = 0;i<s.length();i++){
                    if(s.charAt(i)==' '){break;}
                    Store+=s.charAt(i);
                }
                if(comp.CompareString(Store, Symbol)==1){
                    int CountSpaces=0;
                    String countVoulume = "";
                    String countPrice = "";
                    String BS = "";
                    for(int i = 0; i <s.length();i++){
                        if(s.charAt(i)==' '){
                            CountSpaces++;
                        }
                        else if(CountSpaces == 1){
                            countVoulume = countVoulume + s.charAt(i);
                        }else if(CountSpaces == 2 ){
                            countPrice = countPrice + s.charAt(i);
                        }else if(CountSpaces == 3&&s.charAt(i)!='\n'){
                            BS = BS + s.charAt(i);
                        }
                    }
                    BigDecimal CPrice = new BigDecimal(countPrice);
                    int CVolume = Integer.parseInt(countVoulume);
                    if(comp.CompareString(BS, "BUY")==1){CVolume =CVolume * (-1);}
                    System.out.println(CPrice);
                     System.out.println(countVoulume);
                    //  CPrice = CPrice.add(BigDecimal.valueOf( Volume ).multiply(Price));
                    //  CVoulume = CVoulume;
                     if(CVolume < 0){
                         if(CVolume*(-1)>Volume){
                            CPrice = CPrice.subtract(Price.multiply(new BigDecimal(Volume))) ;
                            CVolume = CVolume * (-1) - Volume;
                            BS = "BUY";
                            Resultant = Resultant + Symbol + " " + String.valueOf(CVolume ) + " " + CPrice.toString() + " " + BS + "\n";
                         }else if(CVolume * (-1) <Volume){
                             ModifyCustomerMoney MCMB = new ModifyCustomerMoney(data,CPrice.subtract(Price.multiply(new BigDecimal(CVolume))));
                            CPrice = (Price.multiply(new BigDecimal(Volume))).subtract(CPrice);
                            CVolume = Volume + CVolume;
                            BS = "SELL";
                            Resultant = Resultant + Symbol + " " + String.valueOf(CVolume ) + " " + CPrice.toString() + " " + BS + "\n";
                         }else{ModifyCustomerMoney MCMB = new ModifyCustomerMoney(data,CPrice.subtract(Price.multiply(new BigDecimal(CVolume))));}
                     }else if (CVolume > 0 ){
                         BS = "SELL";
                         CPrice = (Price.multiply(new BigDecimal(Volume))).add(CPrice);
                         CVolume = CVolume + Volume;
                         Resultant = Resultant + Symbol + " " + String.valueOf(CVolume) + " " + CPrice.toString() + " " + BS + "\n";
                     }
                     System.out.println(CPrice);
                     System.out.println(CVolume);
                     
                }else{Resultant = Resultant + s + "\n"; LineNumber++;}
            }
            System.out.println(Resultant);
            sc.close();
            FileWriter w = new FileWriter(FileName);
            w.write(Resultant);
            w.close();

        } catch (IOException e) {
            //TODO: handle exception
        }
    }
}
