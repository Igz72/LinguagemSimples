package br.ufscar.dc.compiladores.simples;

import org.antlr.v4.runtime.Token;
import static br.ufscar.dc.compiladores.simples.LinguagemSimplesSemanticoUtils.adicionarErroSemantico;
import static br.ufscar.dc.compiladores.simples.LinguagemSimplesSemanticoUtils.tipoCor;
import static br.ufscar.dc.compiladores.simples.LinguagemSimplesSemanticoUtils.extrapolaLargura;
import static br.ufscar.dc.compiladores.simples.LinguagemSimplesSemanticoUtils.extrapolaAltura;

public class LinguagemSimplesSemantico extends LinguagemSimplesBaseVisitor<Void> {

    Escopos escopo;

    @Override
    public Void visitPrograma(LinguagemSimplesParser.ProgramaContext ctx) {
        escopo = new Escopos();
        super.visitPrograma(ctx);

        Token eof = ctx.EOF().getSymbol();
        if (!escopo.existe("Tela")) {
            adicionarErroSemantico(eof, "Deve haver uma imagem \"Tela\" definida");
        }
        return null;
    }

    @Override
    public Void visitCor(LinguagemSimplesParser.CorContext ctx) {
        Token corToken = ctx.IDENTIFICADOR().getSymbol();
        Token redToken = ctx.NUMERO(0).getSymbol();
        Token greenToken = ctx.NUMERO(1).getSymbol();
        Token blueToken = ctx.NUMERO(2).getSymbol();

        String corNome = corToken.getText();
        String redString = redToken.getText();
        String greenString = greenToken.getText();
        String blueString = blueToken.getText();

        int red = Integer.parseInt(redString);
        int green = Integer.parseInt(greenString);
        int blue = Integer.parseInt(blueString);

        if (escopo.existe(corNome)) {
            adicionarErroSemantico(corToken, "O nome \"" + corNome + "\" já está sendo usado");
        } else if ("Tela".equals(corNome)) {
            adicionarErroSemantico(corToken, "\"" + corNome + "\" deve ser uma imagem");
        } else {
            escopo.adicionarCor(corNome);
            if (red > 255) {
                adicionarErroSemantico(redToken,
                        "O número referente à cor vermelha está fora do intervalo permitido");
            }
            if (green > 255) {
                adicionarErroSemantico(greenToken,
                        "O número referente à cor verde está fora do intervalo permitido");
            }
            if (blue > 255) {
                adicionarErroSemantico(blueToken,
                        "O número referente à cor azul está fora do intervalo permitido");
            }
        }
        return null;
    }

    @Override
    public Void visitImagem(LinguagemSimplesParser.ImagemContext ctx) {
        Token imagemToken = ctx.IDENTIFICADOR().getSymbol();
        Token larguraToken = ctx.NUMERO(0).getSymbol();
        Token alturaToken = ctx.NUMERO(1).getSymbol();

        String imagemNome = imagemToken.getText();
        String larguraString = larguraToken.getText();
        String alturaString = alturaToken.getText();

        int largura = Integer.parseInt(larguraString);
        int altura = Integer.parseInt(alturaString);

        if (escopo.existe(imagemNome)) {
            adicionarErroSemantico(imagemToken, "O nome \"" + imagemNome + "\" já está sendo usado");
        } else if (largura == 0 || altura == 0) {
            adicionarErroSemantico(imagemToken, "A imagem \"" + imagemNome + "\" não deve possuir tamanho nulo");
        } else {
            escopo.adicionarImagem(imagemNome, largura, altura);
        }
        return null;
    }

    @Override
    public Void visitAtribuicao(LinguagemSimplesParser.AtribuicaoContext ctx) {
        Token esquerdaToken = ctx.IDENTIFICADOR(0).getSymbol();
        Token direitaToken = ctx.IDENTIFICADOR(1).getSymbol();

        String esquerdaNome = esquerdaToken.getText();
        String direitaNome = direitaToken.getText();

        if (!escopo.existe(esquerdaNome)) {
            adicionarErroSemantico(esquerdaToken, "O nome \"" + esquerdaNome + "\" não foi declarado");
        }
        if (!escopo.existe(direitaNome)) {
            adicionarErroSemantico(direitaToken, "O nome \"" + direitaNome + "\" não foi declarado");
        }

        if (escopo.existe(esquerdaNome) && escopo.existe(direitaNome)) {
            if (tipoCor(escopo, esquerdaNome)) {
                adicionarErroSemantico(esquerdaToken,
                        "\"" + esquerdaNome + "\" é do tipo cor, portanto não deve receber atribuições");
            } else {
                if (extrapolaLargura(ctx, escopo, esquerdaNome, direitaNome)) {
                    adicionarErroSemantico(esquerdaToken,
                            "A largura da imagem \"" + esquerdaNome + "\" foi extrapolada");
                }
                if (extrapolaAltura(ctx, escopo, esquerdaNome, direitaNome)) {
                    adicionarErroSemantico(esquerdaToken,
                            "A altura da imagem \"" + esquerdaNome + "\" foi extrapolada");
                }
            }
        }
        return null;
    }

    @Override
    public Void visitRepeticao(LinguagemSimplesParser.RepeticaoContext ctx) {
        Token variavelToken = ctx.IDENTIFICADOR().getSymbol();
        Token inicioToken = ctx.NUMERO(0).getSymbol();
        Token fimToken = ctx.NUMERO(1).getSymbol();
        Token variacaoToken = ctx.NUMERO(2).getSymbol();

        String variavelNome = variavelToken.getText();
        String inicioString = inicioToken.getText();
        String fimString = fimToken.getText();
        String variacaoString = variacaoToken.getText();

        int inicio = Integer.parseInt(inicioString);
        int fim = Integer.parseInt(fimString);
        int variacao = Integer.parseInt(variacaoString);

        if (escopo.existe(variavelNome)) {
            adicionarErroSemantico(variavelToken, "A variável \"" + variavelNome + "\" já está sendo usado");
        } else {
            escopo.criarNovoEscopo();
            escopo.adicionarNumero(variavelNome, inicio, fim, variacao);
            visitComando(ctx.comando());
            escopo.abandonarEscopo();
        }
        return null;
    }
}
