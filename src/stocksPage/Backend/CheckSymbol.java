package stocksPage.Backend;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dependencies.StringCompare;

public class CheckSymbol {
    public static int checkSymbol(String Symbol,String FileName){
        try {
            File obj=new File(FileName);
            obj.createNewFile(); 
            Scanner sc= new Scanner(obj);
            int LineNumber =1;
            StringCompare comp = new StringCompare();
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                String Store = "";
                for(int i = 0;i<s.length();i++){
                    if(s.charAt(i)==' '){break;}
                    Store+=s.charAt(i);
                }
                if(comp.CompareString(Store, Symbol)==1){return LineNumber;}
                else{LineNumber++;}
            }
            return -1;
        } catch (IOException e) {
            //TODO: handle exception
        }
        return -1;
    }
}
