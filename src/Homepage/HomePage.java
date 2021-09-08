package Homepage;

import Info.CustomerInfo;
import dependencies.AbsolutePath;
import dependencies.Details;
import dependencies.SerialNoFinder;

public class HomePage {
    public HomePage(CustomerInfo data){
        HomePageGUI GUI = new HomePageGUI(data);
        // GUI.setVisible(true);
    }
}
