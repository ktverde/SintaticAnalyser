package lexic;

import models.Constants;
import lombok.Getter;

public class OpenLexicFile implements Constants {
    @Getter
    protected String fileName;

    public OpenLexicFile(String fileName){
        this.fileName = fileName;
    }

    public OpenLexicFile(){
        this.fileName = defaultFileName;
    }
}
