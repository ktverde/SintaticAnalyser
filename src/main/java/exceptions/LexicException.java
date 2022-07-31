package exceptions;

public class LexicException extends RuntimeException{

    public LexicException(char foundChar, String expectedChar){
        super("Erro léxico! Caracter encontrado: "+ foundChar + "\nEra(m) esperado(s): " + expectedChar);
    }

}
