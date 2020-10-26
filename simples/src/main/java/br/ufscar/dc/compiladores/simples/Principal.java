/*
 *  Esse projeto foi compilado e testado usando NetBeans 12.0, Java 14.0.2 e ANTLR 4.8.
 *
 */
package br.ufscar.dc.compiladores.simples;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import br.ufscar.dc.compiladores.simples.LinguagemSimplesParser.ProgramaContext;

public class Principal {

    public static void main(String args[]) throws IOException {

        CharStream cs = CharStreams.fromFileName(args[0]); // Inicializar o primeiro argumento como arquivo de entrada
        LinguagemSimplesLexer lexer = new LinguagemSimplesLexer(cs); // Inicializar o analisador léxico com o fluxo de caracteres do arquivo de entrada;
        CommonTokenStream tokens = new CommonTokenStream(lexer); // Inicializar a lista de tokens com o analisador léxico
        LinguagemSimplesParser parser = new LinguagemSimplesParser(tokens); // Inicializar o analisador sintático com a lista de tokens

        MeuErrorListener meuErrorListener = new MeuErrorListener(); // Instanciar a classe que irá capturar os erros
        parser.removeErrorListeners(); // Remover a manipulação padrão dos erros sintáticos
        parser.addErrorListener(meuErrorListener); // Adicionar o objeto instanciado para manipular os erros sintáticos

        try {
            ProgramaContext arvore = parser.programa(); // Começar a análise sintática pelo símbolo inicial da gramática, armazenando a árvore gerada

            LinguagemSimplesSemantico semantico = new LinguagemSimplesSemantico(); // Instanciar a classe para a análise semântica
            semantico.visitPrograma(arvore); // Reutilizar a árvore sintática para realizar a análise semântica

            if (!LinguagemSimplesSemanticoUtils.errosSemanticos.isEmpty()) {
                LinguagemSimplesSemanticoUtils.errosSemanticos.forEach((s) -> System.out.println(s)); // Caso a haja erros semânticos, imprimí-los no arquivo de saída
                System.out.println("Fim da compilacao");
            } else {
                LinguagemSimplesGerador gerador = new LinguagemSimplesGerador(); // Instanciar a classe para executar o programa
                gerador.visitPrograma(arvore); // Reutilizar a árvore sintática para executar o programa

                System.out.println("Compilado com sucesso");
            }

        } catch (RuntimeException re) {
            System.out.println(re.getMessage()); // Caso haja erro sintático, capturar a mensagem de erro e imprimir no terminal
            System.out.println("Fim da compilacao");
        }
    }
}
