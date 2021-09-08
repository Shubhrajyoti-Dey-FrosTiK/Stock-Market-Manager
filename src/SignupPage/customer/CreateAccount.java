package SignupPage.customer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import dependencies.StringCompare;

public class CreateAccount {
	static int createAccount(String Data,String FileName){
        try{
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
            String Store = Data + "\n";
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                Store=Store+s+"\n";
            }
            sc.close();
            FileWriter f=new FileWriter(FileName);
            f.write(Store);
            f.close();
            return 1;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error");
        }
        return 0;
    }
    public static void appendStrToFile(String fileName,String str)
    {
            try {

        // Open given file in append mode.
                BufferedWriter out = new BufferedWriter(
                new FileWriter(fileName, true));
                out.write(str);
                out.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }
}
