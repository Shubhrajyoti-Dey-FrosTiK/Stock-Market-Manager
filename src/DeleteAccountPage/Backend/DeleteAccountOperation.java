package DeleteAccountPage.Backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Info.CustomerInfo;
import currentDate.CurrentDate;
import dependencies.AbsolutePath;
import dependencies.DeleteFile;
import dependencies.Details;
import dependencies.WriteToFile;

public class DeleteAccountOperation {
	static void DeleteFromFile(int SerialNo,String FileName){
        try{
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
            String Store = "";
            int i=0;
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                if(i==SerialNo){
                }else{Store = Store + s + "\n";}
                i++;
            }
            sc.close();
            FileWriter f = new FileWriter(FileName);
            f.write(Store);
            f.close();

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not opened");
        }
    }
	
	public static void deleteAccount(int SerialNo,CustomerInfo data){
		AbsolutePath p = new AbsolutePath();
		WriteToFile w = new WriteToFile();
		CurrentDate d = new CurrentDate();
		String D = d.currentDate();
		Details det = new Details();
		
        DeleteFromFile(SerialNo,p.AbsPath() + "src/CustomerInfoFiles/CustomerDatabase.txt");
        DeleteFromFile(SerialNo,p.AbsPath() + "src/CustomerInfoFiles/CustomerMoney.txt");
        DeleteFromFile(SerialNo,p.AbsPath() + "src/CustomerInfoFiles/CustomerNames.txt");
        DeleteFromFile(SerialNo,p.AbsPath() + "src/CustomerInfoFiles/CustomerAadhar.txt");
        DeleteFromFile(SerialNo,p.AbsPath() + "src/CustomerInfoFiles/CustomerUserName.txt");
        DeleteFile del1 = new DeleteFile(p.AbsPath() + "src/CustomerDataFiles/" + data.AadharNo + ".txt" );
        DeleteFile del2 = new DeleteFile(p.AbsPath() + "src/CustomerPossesionFiles/" + data.AadharNo + ".txt" );
        DeleteFile del3 = new DeleteFile(p.AbsPath() + "src/BuyInfoFiles/" + data.AadharNo + ".txt" );
        DeleteFile del4 = new DeleteFile(p.AbsPath() + "src/SellInfoFiles/" + data.AadharNo + ".txt" );
//        String Data = "Account Deleted on : " + D + "\n";
//        w.writeToFile(Data, p.AbsPath() + "src/CustomerDataFiles/" + det.details(SerialNo, p.AbsPath() + "src/CustomerInfoFiles/CustomerAadhar.txt")+".txt");

    }

}
