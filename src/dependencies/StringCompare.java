package dependencies;

public class StringCompare {
	public static int CompareString(String S1,String S2){
        if(S1.length()!=S2.length()){return 0;}
        for(int i = 0; i<S1.length(); i++) {
            if(S1.charAt(i)!=S2.charAt(i)){return 0;}
        }
        return 1;
    }
}
