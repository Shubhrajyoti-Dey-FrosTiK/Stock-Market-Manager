package SignupPage.customer;

import dependencies.CurrentDate;
import Info.CustomerInfo;
// import customerLoggedIn.CustomerLoggedIn;
import dependencies.AbsolutePath;
import dependencies.StringCompare;
import dependencies.WriteToFile;


public class CustomerAccountCreate {
	
	
	// Function to create a customer account 
    public static int customerAccountCreate(CustomerInfo data){
    	CurrentDate d = new CurrentDate();
    	Validate v =new Validate();
    	AbsolutePath a = new AbsolutePath();
    	String Path = a.AbsPath();
    	CreateAccount c = new CreateAccount();
    	WriteToFile w = new WriteToFile();
    	Customer cus = new Customer();

    	// CustomerLoggedIn cli = new CustomerLoggedIn();
//    	w.writeToFile("Hello",Path + "src/CustomerDataFiles/" + String.valueOf(1)+".txt");
    	
        String D = d.currentDate();
        
        
        // Validating all the Checks 
        int Validation = v.validate(data,Path + "src/CustomerInfoFiles/CustomerDatabase.txt");
        if(Validation==1){
            System.out.println("Account can be made");
            String Password = new String(data.Password);
            String AccountCreate = data.AadharNo + " " + data.EmailID + " " + Password  + " " + data.FullName + " " + data.Username ;
            int Success = c.createAccount(AccountCreate,Path + "src/CustomerInfoFiles/" + "CustomerDatabase.txt"); 
            int NameList = c.createAccount(data.FullName,Path + "src/CustomerInfoFiles/" + "CustomerNames.txt");
            int InitiateMoney = c.createAccount("0",Path + "src/CustomerInfoFiles/" + "CustomerMoney.txt");
            int Aadhar = c.createAccount(data.AadharNo,Path + "src/CustomerInfoFiles/" + "CustomerAadhar.txt" );
            int UserName = c.createAccount(data.Username, Path + "src/CustomerInfoFiles/CustomerUserName.txt");
            w.writeToFile("Account Created on :" + D ,Path + "src/CustomerDataFiles/" + data.AadharNo +".txt");

            // int Success1 = c.createAccount(AccountCreate,Path + "src/AdminFiles/" + "CustomerDatabase.txt"); 
        //     int NameList1 = c.createAccount(Name,Path + "src/AdminFiles/" + "CustomerNames.txt");
        //     int InitiateMoney1 = c.createAccount("0",Path + "src/AdminFiles/" + "CustomerMoney.txt");
        //     int Aadhar1 = c.createAccount(String.valueOf(AadharNo),Path + "src/AdminFiles/" + "CustomerAadhar.txt" );

            
        //     // Checking if Account Created 
            if(Success==1){System.out.println("Account Created Successfully !!\n You are now Logged in !! "); return 1;}
            else{System.out.println("Some unexpected error occured"); return 0;}
        // }
        // else{cus.customer();}
        }
        else{return Validation;}
    }
}
