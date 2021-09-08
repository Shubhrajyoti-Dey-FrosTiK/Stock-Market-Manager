package Homepage.Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import Extraction.HeadlineSeperation;

public class GetNews {
    public static String getNews() throws IOException{
        URL url = new URL("https://www.google.com/finance/");
        url.openConnection();
        InputStream reader = url.openStream();
        // String result = IOUtils.toString(reader, StandardCharsets.UTF_8);
        Scanner s = new Scanner(reader).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        // System.out.println(result);
        // FileWriter f = new FileWriter("/Users/shubhrajyotidey/Desktop/JAVA/WebScrapingExp1/src/Readfiile.txt");
        // f.write(result);
        // f.close();
        HeadlineSeperation HS = new HeadlineSeperation();
        String r= HS.headlineSeperation(result);

        if(r.isEmpty()==true){
            GetNews g = new GetNews();
            return g.getNews();
        }else{
            return r;
        }
    }
}
