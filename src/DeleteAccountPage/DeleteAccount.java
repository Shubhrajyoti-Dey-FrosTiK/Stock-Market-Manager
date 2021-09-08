package DeleteAccountPage;

import DeleteAccountPage.Backend.DeleteAccountOperation;
import Info.CustomerInfo;
import dependencies.AbsolutePath;
import dependencies.SerialNoFinder;

public class DeleteAccount {
    public DeleteAccount(CustomerInfo data){
        DeleteAccountOperation DAO = new DeleteAccountOperation();
        SerialNoFinder SF = new SerialNoFinder();
        AbsolutePath Path = new AbsolutePath();
        int SerialNo = SF.serialNoFinder(data.EmailID, Path.AbsPath() + "src/CustomerInfoFiles/CustomerDatabase.txt");
        DAO.deleteAccount(SerialNo,data);
    }
    
}
