package dependencies;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Details {
	public static String details(int SerialNo,String FileName){
        try{
            String N="";
            File obj1=new File(FileName);
            Scanner sc1= new Scanner(obj1);
            for(int i=0;i<=SerialNo;i++){N=sc1.nextLine();}
            sc1.close();
            return N;
        }catch(IOException e){
            e.printStackTrace();
        }
        return "0";
    }
}
