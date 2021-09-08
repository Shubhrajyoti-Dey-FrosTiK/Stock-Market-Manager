package SignupPage.customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Info.CustomerInfo;
import dependencies.StringCompare;

public class Validate {
	public static StringCompare CS = new StringCompare();
	
	public static int ValidateAadharInfo(String AadharNo,String FileName){
        try{
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
            int flag=1;
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                StringCompare CS = new StringCompare();
                String Store="";
                for(int i = 0; i<s.length(); i++) {
                    if(s.charAt(i)==' '){break;}
                    Store=Store+s.charAt(i);
                }
                if(CS.CompareString(Store, AadharNo)==1){
                    System.out.println("Aadhar nuymber exists");
                    sc.close();
                    return 0;
                }
            }
            sc.close();
            return 1;
        }catch (IOException e){
        	 try{
                 File obj=new File(FileName);
                 obj.createNewFile();
                 ValidateAadharInfo(AadharNo,FileName);
         }catch(IOException f){
             f.printStackTrace();
         }
            e.printStackTrace();
            System.out.println("File not opened");
        }
        return 0;
    }
	
	public static int ValidateEmailInfo(String EmailID,String FileName){
        try{
//        	StringCompare CS = new StringCompare();
            File obj=new File(FileName);
            Scanner sc= new Scanner(obj);
           
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
                // for(int i = 0; i<Store.length(); i++) {
                //     if(EmailID.charAt(i)!=Store.charAt(i)){flag=1; break;}
                // }
                if(CS.CompareString(Store,EmailID)==1){System.out.println("Email ID exists"); sc.close(); return 0;}
                // System.out.println(Store);
            }
            sc.close();
            return 1;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not opened");
        }
        return 0;
    }
	
	
	
	public static int validate(CustomerInfo data,String FileName){
        String Password = new String(data.Password);
        String ConPass = new String(data.ConPass);

        // Vallidating all the Aadhar Number 
        int AadharNoValidation = ValidateAadharInfo(data.AadharNo,FileName);
        if(AadharNoValidation==0){return 2;}
        int EmailVerification = ValidateEmailInfo(data.EmailID, FileName);
        if(EmailVerification==0){return 3;}
        if(CS.CompareString(Password, ConPass)==0){System.out.println("Passwords dont match"); return 4;}
        return 1;
    }
}
