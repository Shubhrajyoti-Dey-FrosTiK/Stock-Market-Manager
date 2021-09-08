package dependencies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
	public static void writeToFile(String Data,String FileName){
        try{
            File obj=new File(FileName);
            obj.createNewFile(); 
            Scanner sc= new Scanner(obj);
            String Store="";
            System.out.println(FileName);
            System.out.println(Data);
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                Store = Store + s +"\n";
            }
            Store = Store + Data;
            sc.close();
            FileWriter f = new FileWriter(FileName);
            f.write(Store);
            f.close();
        }catch (IOException e){
        	 try {
        	      File myObj = new File(FileName);
        	      if (myObj.createNewFile()) {
//        	        System.out.println("File created: " + myObj.getName());
        	      } else {
        	        System.out.println("File already exists.");
        	      }
        	      writeToFile(Data,FileName);
        	    } catch (IOException f) {
        	      System.out.println("An error occurred.");
        	      f.printStackTrace();
        	    }
            
        }
    }
}
