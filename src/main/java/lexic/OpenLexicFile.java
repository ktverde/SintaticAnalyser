package lexic;

import models.Constants;

public class OpenLexicFile implements Constants {

    protected String fileName;

    public OpenLexicFile(String fileName){
        this.fileName = fileName;
    }

    public OpenLexicFile(){
        this.fileName = defaultFileName;
    }

    public String getFileName() {
        return fileName;
    }
}
