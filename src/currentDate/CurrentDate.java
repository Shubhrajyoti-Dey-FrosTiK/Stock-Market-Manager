package currentDate;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrentDate {
	public static String currentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String D = formatter.format(date);
        return D;
    }
}
