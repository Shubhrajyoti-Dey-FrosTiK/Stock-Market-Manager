// package dependencies;

// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;

// public class ShowFile {
// 	public static void showFile(String FileName){
//         try{
//             File obj=new File(FileName);
//             Scanner sc= new Scanner(obj);
//             while(sc.hasNextLine()){
//                 String s=sc.nextLine();
//                System.out.println(s);
//             }
//             sc.close();
//         }catch (IOException e){
//             e.printStackTrace();
//             System.out.println("File not opened");
//         }
//     }
// }


package dependencies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShowFile {
	public static String showFile(String FileName){
        try{
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
            String Store="";
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                Store=Store+s+"\n";
               System.out.println(s);
            }
            sc.close();
            return Store;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not opened");
        }
        return "0";
    }

    public static String ShowFileReadable(String FileName){
        try{
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
            String Store="";
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                String ModifiedString = "";
                int spaces =0;
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)==' '){
                        spaces++;
                        if(spaces == 1 ){ModifiedString = ModifiedString + "    Volume : ";}
                        if(spaces == 2 ){ModifiedString = ModifiedString + "    Total Price : ";}
                        if(spaces == 3){ModifiedString = ModifiedString + "    Status : ";}
                    }else {
                        ModifiedString = ModifiedString + s.charAt(i);
                    }
                }
                Store = Store + ModifiedString + "\n";
               System.out.println(s);
            }
            sc.close();
            return Store;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not opened");
        }
        return "0";
    }
}