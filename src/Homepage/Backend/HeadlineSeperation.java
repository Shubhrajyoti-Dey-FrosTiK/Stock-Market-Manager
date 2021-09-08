package Homepage.Backend;

// import jdk.internal.jshell.tool.resources.l10n;

public class HeadlineSeperation {
    
    public static String removeWord(String string, String word)
    {
        if (string.contains(word)) {
            String tempWord = word + " ";
            string = string.replaceAll(tempWord, "");
            tempWord = " " + word;
            string = string.replaceAll(tempWord, "");
        }
       return string;
    }
    
    public static String headlineSeperation(String WebData){
        String Store = "";
        String Resultant = "";

        for(int i=0;i<WebData.length();i++){
            if(WebData.charAt(i)==' '){
                if(Store.contains("class=\"AoCdqe\">") == true){
                    // System.out.println("found");
                    String Heading = Store.substring(15) + " ";
                    // System.out.println(Heading);
                    String Dummy = "";
                    for(int j=i+1; ;j++){
                        if(WebData.charAt(j)==' '){
                            // System.out.println(Dummy);
                            // Heading = Heading  + Dummy;
                            if(Dummy.contains("</div>") == true){
                                for(int k=0;k<Dummy.length();k++){
                                    if(Dummy.charAt(k)=='<'){
                                        if(Dummy.charAt(k+1)=='/'){
                                            break;
                                        }
                                    }else{Heading = Heading + Dummy.charAt(k);}
                                }
                                break;
                            }
                            Heading = Heading + Dummy + " ";
                            Dummy ="";
                            // System.out.println(Dummy);
                            // break;
                        }else{
                            Dummy = Dummy + WebData.charAt(j);
                            
                        }
                    }
                    
                    Resultant = Resultant + removeWord(Heading, "\n") + "\n\n";
                    // System.out.println(Heading);
                    // System.out.println(Resultant);
                    // System.out.println();
                }Store = "";
            }else{
                Store = Store + WebData.charAt(i);
            }
        }
        System.out.println(Resultant);
        return Resultant;
    }
}
