package PastTransactionPage;

import Info.CustomerInfo;

public class PastTransaction {
    public PastTransaction(CustomerInfo data){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
  
            public void run() {  
                PastTransactionGUI GUI = new PastTransactionGUI(data);
            }  
        }); 
        
    }
}
