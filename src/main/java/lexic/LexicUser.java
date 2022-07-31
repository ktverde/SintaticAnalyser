package lexic;

import models.Constants;
import models.Constants.Tokens;

import java.util.ArrayList;
import java.util.List;

public class LexicUser {

    List<Tokens> list = new ArrayList<>();

    public List<Tokens> analyseFile(String fileName){
        LexicAnalyser l = new LexicAnalyser(fileName);
        do{
            l.read_0();
            list.add(l.getReconToken());
        }while(l.getReconToken() != Constants.Tokens.EOF);

        return list;
    }

    public List<Tokens> analyseString(StringBuilder string){
        LexicAnalyser l = new LexicAnalyser();
        l.setEntry(string);
        l.readNext();
        do{
            l.read_0();
            list.add(l.getReconToken());
        }while(l.getReconToken() != Constants.Tokens.EOF);

        return list;
    }
}
