package Loginpage.customerLogInToAccount;

import dependencies.Input;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Info.CustomerInfo;
import currentDate.CurrentDate;
// import Loginpage.customerLoggedIn.CustomerLoggedIn;
import dependencies.AbsolutePath;
import dependencies.StringCompare;
import dependencies.WriteToFile;

public class ValidateLogin {
	 static int validateLogin(CustomerInfo data,String FileName){
	        try{
	        	StringCompare c= new StringCompare();
	        	
	            File obj=new File(FileName);
	            Scanner sc= new Scanner(obj);
	           
	            while(sc.hasNextLine()){
	                int flag=0;
	                String s=sc.nextLine();
	                int count=0;
	                String Store1="";
	                for(int i = 0; i<s.length(); i++) {
	                    if(s.charAt(i)==' ')
	                    {
	                        if(count==0){count++;}
	                        else if(count==1){break;}
	                    }
	                    else if(count==1){Store1=Store1+s.charAt(i);}
	                }
	                String Store2="";
	                count=0;
	                for(int i = 0; i<s.length(); i++) {
	                    if(s.charAt(i)==' ')
	                    {
	                        if(count<=1){count++;}
	                        else if(count==2){break;}
	                    }
	                    else if(count==2){Store2=Store2+s.charAt(i);}
	                }
	                if(c.CompareString(Store1, data.EmailID)==1)
	                {if(c.CompareString(Store2, new String(data.Password))==1){ sc.close(); return 1;}}
	            }
	            sc.close();
	            return 0;
	        }catch (IOException e){
	            e.printStackTrace();
	            System.out.println("File not opened");
	        }
	        return 0;
	    }
}
