package dependencies;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SerialNoFinder {
	// Function to find out the serial number from Email ID 
    public static int serialNoFinder(String EmailID,String FileName){
    	StringCompare scomp = new StringCompare();
    	
        String Name = "";
        try{
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
            int SerialNo=0;
            while(sc.hasNextLine()){
                int flag=0;
                String s=sc.nextLine();
                int count=0;
                String Store="";
                for(int i = 0; i<s.length(); i++) {
                    if(s.charAt(i)==' ')
                    {
                        if(count==0){count++;}
                        else if(count==1){break;}
                    }
                    else if(count==1){Store=Store+s.charAt(i);}
                }
                if(scomp.CompareString(Store,EmailID)==1){break;}
                SerialNo++;
            }
            sc.close();
            return SerialNo;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not opened");
        }
        return 0;
    }
}
