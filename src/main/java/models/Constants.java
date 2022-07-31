package models;

public interface Constants {

    enum Tokens {NUM, ATRIB, IDENT, OP, OPENCHA, CLOSECHA, OPENCOL, CLOSECOL, OPENPAR, CLOSEPAR, EOF, PTOVIRG, VAZIO} ;
    String digits = "0123456789";
    String letters = "abcdefghijklmnopqrstuvwxyz";
    String atrib = "-:";
    String operators = "-+*/";
    String special = "()[]{}";
    String empty = " \r\n\t";
    char EOF = 0;
    char ptovirg = ';';
    char doispontos = ':';

    String defaultFileName = "entrada.txt";

}
