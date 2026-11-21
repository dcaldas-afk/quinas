package quinas.testes;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.nio.charset.StandardCharsets;
import quinas.lexer.Lexer;
import quinas.lexer.LexerException;
import quinas.parser.Parser;
import quinas.parser.ParserException;

public final class TesteParserEtapa3 {
    public static void main(String[] args) {
        boolean arvore = args.length == 2 && "--arvore".equals(args[0]);
        String arquivo = arvore ? args[1] : (args.length == 1 ? args[0] : null);
        if (arquivo == null) {
            System.err.println("Uso: java -cp bin TesteParserEtapa3 [--arvore] arquivo.qui");
            System.exit(64);
        }
        try (PushbackReader leitor = new PushbackReader(
                new InputStreamReader(new FileInputStream(arquivo), StandardCharsets.UTF_8), 4096)) {
            Parser parser = new Parser(new Lexer(leitor));
            parser.parse();
            System.out.println("RESULTADO=SINTATICO_OK");
        } catch (LexerException e) {
            System.out.println("RESULTADO=ERRO_LEXICO");
            System.err.println(e.getMessage());
            System.exit(3);
        } catch (ParserException e) {
            System.out.println("RESULTADO=ERRO_SINTATICO");
            System.err.println(e.getMessage());
            System.exit(2);
        } catch (Exception e) {
            System.out.println("RESULTADO=ERRO_EXECUCAO");
            e.printStackTrace(System.err);
            System.exit(4);
        }
    }
}
