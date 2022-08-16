package syntax;

import lexic.LexicUser;
import models.Constants.Tokens;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SyntaxAnalyser
{
    List<Tokens> tokensList = new ArrayList<>();

    public SyntaxAnalyser(String fileName){

        tokensList = new LexicUser().analyseFile(fileName);
    }
    public SyntaxAnalyser(StringBuilder string){

        tokensList = new LexicUser().analyseString(string);
    }
    public boolean analyse(){

        Stack<Tokens> specialStack = new Stack<>();
        Stack<Tokens> opStack = new Stack<>();

        boolean pop = false;
        boolean closedPar = false;
        boolean closedCol = false;

        System.out.println("------------------------------");
        System.out.println(tokensList);
        System.out.println("------------------------------");

        for (Tokens t: tokensList) {

            if(t.equals(Tokens.OP) && opStack.isEmpty()){
                opStack.push(t);
                pop = true;
                t = Tokens.EOF;
            }
            if((t.equals(Tokens.OPENPAR) ||  t.equals(Tokens.OPENCOL) || t.equals(Tokens.OPENCHA)) && specialStack.isEmpty()){
                specialStack.push(t);
                t = Tokens.EOF;
            }

            switch (String.valueOf(t)) {

                case "OPENPAR" -> {
                    specialStack.push(t);
                    pop = false;
                }

                case "OPENCOL" -> {
                    if (specialStack.peek().equals(Tokens.OPENPAR)) return false;
                    specialStack.push(t);
                    closedPar = false;
                    pop = false;
                }
                case "OPENCHA" -> {
                    if (specialStack.peek().equals(Tokens.OPENPAR)) return false;
                    else if (specialStack.peek().equals(Tokens.OPENCOL)) return false;
                    specialStack.push(t);
                    closedCol = false;
                    pop = false;
                }
                case "CLOSEPAR" -> {
                    if (!specialStack.peek().equals(Tokens.OPENPAR)) return false;
                    specialStack.pop();
                    closedPar = true;
                    pop = false;

                }
                case "CLOSECOL" -> {
                    if (!specialStack.peek().equals(Tokens.OPENCOL)) return false;
                    if(!closedPar) return false;
                    specialStack.pop();
                    closedCol = true;
                    pop = false;

                }
                case "CLOSECHA" -> {
                    if (!specialStack.peek().equals(Tokens.OPENCHA)) return false;
                    if(!closedCol) return false;
                    specialStack.pop();
                    pop = false;

                }
                case "OP" -> {
                    if(pop) return false;
                    else opStack.pop();
                    pop = false;
                }

                case "EOF" -> {

                }

                default -> pop = false;

            }
        }

        return specialStack.isEmpty();

    }
}
