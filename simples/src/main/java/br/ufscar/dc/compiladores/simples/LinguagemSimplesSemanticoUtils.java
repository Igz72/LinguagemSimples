package br.ufscar.dc.compiladores.simples;

import java.util.List;
import java.util.ArrayList;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.simples.LinguagemSimplesParser.ValorContext;
import br.ufscar.dc.compiladores.simples.TabelaDeSimbolos.TipoLinguagemSimples;

public class LinguagemSimplesSemanticoUtils {

    public static List<String> errosSemanticos = new ArrayList<>();

    public static void adicionarErroSemantico(Token token, String mensagem) {
        int linha = token.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static Boolean tipoCor(Escopos escopo, String variavelNome) {
        if (escopo.obterTipo(variavelNome) == TipoLinguagemSimples.COR) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean valorNumero(LinguagemSimplesParser.ValorContext ctx) {
        if (ctx.NUMERO() != null) {
            return true;
        } else {
            return false;
        }
    }

    public static int valorMaximo(Escopos escopo, LinguagemSimplesParser.ValorContext ctx) {
        int coordenadaMaxima;

        if (valorNumero(ctx)) {
            Token coordenadaToken = ctx.NUMERO().getSymbol();
            String coordenadaString = coordenadaToken.getText();
            coordenadaMaxima = Integer.parseInt(coordenadaString);
        } else {
            Token variavelToken = ctx.IDENTIFICADOR().getSymbol();
            String variavelNome = variavelToken.getText();

            if (escopo.existe(variavelNome)) {
                int inicio = escopo.obterInicio(variavelNome);
                int fim = escopo.obterFim(variavelNome);
                int variacao = escopo.obterVariacao(variavelNome);
                int resto = (fim - inicio + 1) % variacao;
                coordenadaMaxima = fim - resto;
            } else {
                adicionarErroSemantico(variavelToken, "A variável \"" + variavelNome + "\" não foi declarado");
                coordenadaMaxima = 0;
            }
        }
        return coordenadaMaxima;
    }

    public static Boolean extrapolaLargura(LinguagemSimplesParser.AtribuicaoContext ctx, Escopos escopo, String esquerdaNome, String direitaNome) {
        ValorContext larguraCtx = ctx.valor(0);
        int coordenada = valorMaximo(escopo, larguraCtx);

        int larguraEsquerda = escopo.obterLargura(esquerdaNome);
        int larguraDireita;

        if (tipoCor(escopo, direitaNome)) {
            if (coordenada > larguraEsquerda) {
                return true;
            }
        } else {
            larguraDireita = escopo.obterLargura(direitaNome);

            if (coordenada + larguraDireita - 1 > larguraEsquerda) {
                return true;
            }
        }
        return false;
    }

    public static Boolean extrapolaAltura(LinguagemSimplesParser.AtribuicaoContext ctx, Escopos escopo, String esquerdaNome, String direitaNome) {
        ValorContext alturaCtx = ctx.valor(1);
        int coordenada = valorMaximo(escopo, alturaCtx);

        int alturaEsquerda = escopo.obterAltura(esquerdaNome);
        int alturaDireita;

        if (tipoCor(escopo, direitaNome)) {
            if (coordenada > alturaEsquerda) {
                return true;
            }
        } else {
            alturaDireita = escopo.obterAltura(direitaNome);

            if (coordenada + alturaDireita - 1 > alturaEsquerda) {
                return true;
            }
        }
        return false;
    }

}
