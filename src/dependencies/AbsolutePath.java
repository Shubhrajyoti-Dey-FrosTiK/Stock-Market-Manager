package dependencies;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class AbsolutePath {
	public String AbsPath() {
		File f = new File("program.txt");
		String absolute = f.getAbsolutePath();
		String replaceString=absolute.replaceAll("program.txt","");
		return replaceString;
	}
}
