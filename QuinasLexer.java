import quinas.lexer.Lexer;
import quinas.lexer.LexerException;
import quinas.node.EOF;
import quinas.node.Token;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class QuinasLexer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java QuinasLexer <arquivo.qui>");
            return;
        }

        try (
            PushbackReader reader = new PushbackReader(
                new InputStreamReader(
                    new FileInputStream(args[0]),
                    StandardCharsets.UTF_8
                ),
                1024
            )
        ) {
            Lexer lexer = new Lexer(reader);

            while (true) {
                Token token = lexer.next();

                if (token instanceof EOF) {
                    break;
                }

                System.out.printf(
                    "%-25s lexema = [%s]  linha=%d coluna=%d%n",
                    token.getClass().getSimpleName(),
                    token.getText(),
                    token.getLine(),
                    token.getPos()
                );
            }

        } catch (LexerException e) {
            System.err.println("Erro léxico: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de leitura: " + e.getMessage());
        }
    }
}