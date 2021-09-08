package dependencies;

import java.util.Scanner;

public class Input {
	
	public static int InputInt(){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        return n;
    }
    // Funtion For Inputing String
    public static String InputString(){
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        return s;
    }
}
