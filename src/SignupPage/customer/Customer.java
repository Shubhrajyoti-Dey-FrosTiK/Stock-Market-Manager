package SignupPage.customer;

import Info.CustomerInfo;

// import SignupPage.customerLogInToAccount.CustomerLogInToAccount;
// import Home.Home;
// import currentDate.CurrentDate;

import dependencies.*;

public class Customer {
	public static int customer(CustomerInfo data){

        CustomerAccountCreate cac = new CustomerAccountCreate();
        int flag = cac.customerAccountCreate(data);
        return flag;
    }
}
