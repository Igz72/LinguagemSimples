package br.ufscar.dc.compiladores.simples;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class MeuErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String erroMensagem;

        Token erroToken = (Token) offendingSymbol;
        int erroTipo = erroToken.getType();
        String erroCategoria;

        if (LinguagemSimplesParser.VOCABULARY.getSymbolicName(erroTipo) != null) {
            erroCategoria = LinguagemSimplesParser.VOCABULARY.getSymbolicName(erroTipo);
        } else {
            erroCategoria = "DEFAULT";
        }

        // Caso o método seja chamado, definir a categoria do erro
        switch (erroCategoria) {
            case "ERRO_SIMBOLO":
                erroMensagem = ("Linha " + line + ": símbolo \"" + ((Token) offendingSymbol).getText() + "\" nao identificado");
                break;
            default:
                erroMensagem = "Linha " + line + ": erro sintático próximo a \"" + ((Token) offendingSymbol).getText() + "\"";
                break;
        }

        // Lançar uma RuntimeExcpetion com a mensagem de erro adequada
        throw new RuntimeException(erroMensagem);

    }
}
