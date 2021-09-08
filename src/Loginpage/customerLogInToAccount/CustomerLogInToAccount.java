package Loginpage.customerLogInToAccount;

import dependencies.StringCompare;
import Homepage.HomePage;
import Info.CustomerInfo;
import SignupPage.customer.Customer;
import dependencies.AbsolutePath;
import dependencies.Input;
// import SignupPage.customerLoggedIn.CustomerLoggedIn;

public class CustomerLogInToAccount {
	
	public static int CustomerLoginToAccount(CustomerInfo data){
		
		Customer cus = new Customer();
		// CustomerLoggedIn cli = new CustomerLoggedIn();
		ValidateLogin v = new ValidateLogin();	
		AbsolutePath absp = new AbsolutePath();
		
        int Validate = v.validateLogin(data,absp.AbsPath()+"src/CustomerInfoFiles/CustomerDatabase.txt");
        if(Validate==1){System.out.println("You are Logged in !!"); HomePage h = new HomePage(data); return 1;}
        else{System.out.println("Invalid Credentials\n"); return 0;}
    }
}
