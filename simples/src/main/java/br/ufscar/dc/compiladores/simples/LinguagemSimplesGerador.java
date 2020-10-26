package br.ufscar.dc.compiladores.simples;

import java.awt.Color;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.simples.LinguagemSimplesParser.ValorContext;
import static br.ufscar.dc.compiladores.simples.LinguagemSimplesSemanticoUtils.valorNumero;

public class LinguagemSimplesGerador extends LinguagemSimplesBaseVisitor<Void> {

    Escopos escopo;

    @Override
    public Void visitPrograma(LinguagemSimplesParser.ProgramaContext ctx) {
        escopo = new Escopos();
        super.visitPrograma(ctx);

        int largura = escopo.obterLargura("Tela");
        int altura = escopo.obterAltura("Tela");
        Color[][] Tela = escopo.obterImagem("Tela");

        Java2D janela = new Java2D(largura, altura, Tela);
        janela.setVisible(true);

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

        escopo.adicionarCor(corNome, new Color(red, green, blue));
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

        Color[][] imagem = new Color[largura][altura];

        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                imagem[i][j] = new Color(255, 255, 255);
            }
        }

        escopo.adicionarImagem(imagemNome, largura, altura, imagem);
        return null;
    }

    @Override
    public Void visitAtribuicao(LinguagemSimplesParser.AtribuicaoContext ctx) {
        Token esquerdaToken = ctx.IDENTIFICADOR(0).getSymbol();
        Token direitaToken = ctx.IDENTIFICADOR(1).getSymbol();

        String esquerdaNome = esquerdaToken.getText();
        String direitaNome = direitaToken.getText();

        ValorContext larguraCtx = ctx.valor(0);
        ValorContext alturaCtx = ctx.valor(1);

        int xInicio;
        int xFim;
        int xVariacao;

        int yInicio;
        int yFim;
        int yVariacao;

        if (valorNumero(larguraCtx)) {
            Token xToken = larguraCtx.NUMERO().getSymbol();
            String xString = xToken.getText();
            xInicio = Integer.parseInt(xString);
            xFim = xInicio;
            xVariacao = 1;
        } else {
            Token xToken = larguraCtx.IDENTIFICADOR().getSymbol();
            String xNome = xToken.getText();
            xInicio = escopo.obterInicio(xNome);
            xFim = escopo.obterFim(xNome);
            xVariacao = escopo.obterVariacao(xNome);
        }

        if (valorNumero(alturaCtx)) {
            Token yToken = alturaCtx.NUMERO().getSymbol();
            String yString = yToken.getText();
            yInicio = Integer.parseInt(yString);
            yFim = yInicio;
            yVariacao = 1;
        } else {
            Token yToken = alturaCtx.IDENTIFICADOR().getSymbol();
            String yNome = yToken.getText();
            yInicio = escopo.obterInicio(yNome);
            yFim = escopo.obterFim(yNome);
            yVariacao = escopo.obterVariacao(yNome);
        }

        int larguraImagem = escopo.obterLargura(direitaNome);
        int alturaImagem = escopo.obterAltura(direitaNome);

        Color[][] esquerdaImagem = escopo.obterImagem(esquerdaNome);
        Color[][] direitaImagem = escopo.obterImagem(direitaNome);

        for (int i = xInicio - 1; i < xFim; i += xVariacao) {
            for (int j = yInicio - 1; j < yFim; j += yVariacao) {
                for (int k = 0; k < larguraImagem; k++) {
                    for (int l = 0; l < alturaImagem; l++) {
                        esquerdaImagem[i + k][j + l] = direitaImagem[k][l];
                    }
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

        escopo.criarNovoEscopo();
        escopo.adicionarNumero(variavelNome, inicio, fim, variacao);
        visitComando(ctx.comando());
        escopo.abandonarEscopo();
        return null;
    }

}
