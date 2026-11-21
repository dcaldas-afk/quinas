package quinas;



import quinas.parser.*;
import quinas.lexer.*;
import quinas.node.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String arquivo = args[0];

            Lexer lex = new Lexer(
                new PushbackReader(
                    new FileReader(arquivo), 1024));

            Parser p = new Parser(lex);

            Start tree = p.parse();

            // Imprime arvore na saida padrao
            // tree.apply(new ASTPrinter());

            // Imprime arvore em interface grafica
            tree.apply(new ASTDisplay());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
