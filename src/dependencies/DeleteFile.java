package dependencies;

import java.io.File;

public class DeleteFile {
    public DeleteFile(String FileName){
        File myObj = new File(FileName);
        myObj.delete();
    }
}
