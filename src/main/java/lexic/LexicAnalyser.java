package lexic;

import exceptions.LexicException;

public class LexicAnalyser extends ReadLexicFile {

    public LexicAnalyser() {

    }
    public LexicAnalyser(String fileName){
        super(fileName);
    }

    public void read_0(){
        if(nextCharIs(digits)){
            readNext();
            read_1();
        }
        else if(nextCharIs(operators)){
            readNext();
            read_2();
        }
        else if(nextCharIs(letters)){
            readNext();
            read_3();
        }
        else if(nextCharIs(String.valueOf(ptovirg))){
            readNext();
            read_4();
        }
        else if(nextCharIs(String.valueOf(EOF))){
            readNext();
            read_5();
        }
        else if(nextCharIs(special)){
            read_6(getNextChar());
            readNext();
        }
        else if(nextCharIs(empty)){
            readNext();
            read_0();
        }
        else{
            throw new LexicException(getNextChar(), digits+letters+empty+ptovirg+operators);
        }
    }

    private void read_1() {
        this.setReconToken(Tokens.NUM);
        if(this.nextCharIs(digits)){
            readNext();
            read_1();
        }
    }

    private void read_2(){
        setReconToken(Tokens.OP);
    }

    private void read_3(){
        setReconToken(Tokens.IDENT);
        if(this.nextCharIs(letters)){
            readNext();
            read_3();
        }
    }

    private void read_4(){
        setReconToken(Tokens.PTOVIRG);
    }

    private void read_5(){
        setReconToken(Tokens.EOF);
    }

    private void read_6(char s){
        if(s == '(') setReconToken(Tokens.OPENPAR);
        else if(s == ')') setReconToken(Tokens.CLOSEPAR);

        if(s == '[') setReconToken(Tokens.OPENCOL);
        else if(s == ']') setReconToken(Tokens.CLOSECOL);

        if(s == '{') setReconToken(Tokens.OPENCHA);
        else if(s == '}') setReconToken(Tokens.CLOSECHA);
    }

}
