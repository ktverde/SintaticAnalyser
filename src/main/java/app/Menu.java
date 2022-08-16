package app;

import exceptions.LexicException;
import exceptions.SyntaxException;
import syntax.SyntaxAnalyser;

import java.io.File;
import java.util.Scanner;

public class Menu
{
    public void menu() {
        String op;
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("""
                 Escolha entre as opções:
                 
                 1) Ler um arquivo de entrada.
                 2) Escrever uma sentença no console.
                 
                 0) Sair""");

            op = teclado.nextLine();
            switch (op) {
                case "1" -> {

                    System.out.println("Digite o nome do seu arquivo.");
                    while (true) {
                        op = teclado.nextLine();
                        if (new File(op).exists() || op.equals("0")) break;
                        System.out.println("Digite um caminho de arquivo válido! (Cheque se o arquivo está no diretório do projeto, caso contrário, digite o caminho completo.\nEx: C:/Usuarios/projeto/arquivo.txt)");
                        System.out.println("\n0) Voltar");
                    }
                    if(op.equals("0")) break;
                    try{

                        SyntaxAnalyser syntaxAnalyser = new SyntaxAnalyser(op);
                        if (syntaxAnalyser.analyse())
                            System.out.println("Arquivo " + op + " analisado com sucesso! \nNenhum erro sintático e/ou léxico encontrado!");
                        else
                            throw new SyntaxException("Erro de sintaxe na mensagem!");

                    }catch (SyntaxException | LexicException e){
                        System.out.println(e.getMessage());
                    }
                }
                case "2" -> {

                    System.out.println("Digite a sua sentença: ");
                    op = teclado.nextLine();
                    try{

                        SyntaxAnalyser syntaxAnalyser = new SyntaxAnalyser(new StringBuilder(op));
                        if (syntaxAnalyser.analyse())
                            System.out.println("Mensagem " + op + " analisada com sucesso! \nNenhum erro sintático e/ou léxico encontrado!");
                        else
                            throw new SyntaxException("Erro de sintaxe na mensagem!");

                    }catch (SyntaxException | LexicException e){
                        System.out.println(e.getMessage());
                    }
                }
                case "0" -> {
                    System.out.println("Obrigado!");
                    return;
                }
                default -> System.out.println("Digite uma opção válida! ");
            }
        }while(true);

    }
}
