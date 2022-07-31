package lexic;

import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;
import java.io.IOException;

public class ReadLexicFile extends OpenLexicFile {

    @Getter
    private char nextChar;

    @Setter
    private StringBuilder entry = new StringBuilder();

    private int pos = 0;

    @Setter
    @Getter
    private Tokens reconToken;

    public ReadLexicFile(){ }

    public ReadLexicFile(String fileName){
        super(fileName);
        analyser(fileName);
    }

    private void analyser(String fileName) {
        try{
            FileReader file = new FileReader(fileName);
            int c;
            while ((c = file.read()) != -1) {
                //System.out.println((char) c);
                this.entry.append((char) c);
            }
            file.close();
            readNext();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readNext() {
        try{
            this.nextChar = this.entry.charAt(this.pos++);
        }
        catch(IndexOutOfBoundsException e){
            this.nextChar = EOF;
        }
    }

    public boolean nextCharIs(String token){
        if(token.equals(this.nextChar)) return true;
        int index = token.indexOf(this.nextChar);
        return token.indexOf(this.nextChar) != -1;
    }


}
