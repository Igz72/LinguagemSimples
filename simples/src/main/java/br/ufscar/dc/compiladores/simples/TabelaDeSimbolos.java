package br.ufscar.dc.compiladores.simples;

import java.util.Map;
import java.util.HashMap;
import java.awt.Color;

public class TabelaDeSimbolos {

    public enum TipoLinguagemSimples {
        COR,
        IMAGEM,
        NUMERO
    }

    class EntradaTabelaDeSimbolos {

        String nome;
        TipoLinguagemSimples tipo;
        int n0;
        int n1;
        int n2;
        Color[][] imagem;

        private EntradaTabelaDeSimbolos(String nome, TipoLinguagemSimples tipo, int n0, int n1, int n2, Color[][] imagem) {
            this.nome = nome;
            this.tipo = tipo;
            this.n0 = n0;
            this.n1 = n1;
            this.n2 = n2;
            this.imagem = imagem;
        }
    }

    private final Map<String, EntradaTabelaDeSimbolos> tabela;

    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    public void adicionarCor(String nome) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, TipoLinguagemSimples.COR, 0, 0, 0, null));
    }

    public void adicionarCor(String nome, Color cor) {
        Color[][] imagem = {{cor}};
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, TipoLinguagemSimples.COR, 1, 1, 0, imagem));
    }

    public void adicionarImagem(String nome, int largura, int altura) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, TipoLinguagemSimples.IMAGEM, largura, altura, 0, null));
    }

    public void adicionarImagem(String nome, int largura, int altura, Color[][] imagem) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, TipoLinguagemSimples.IMAGEM, largura, altura, 0, imagem));
    }

    public void adicionarNumero(String nome, int inicio, int fim, int variacao) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, TipoLinguagemSimples.NUMERO, inicio, fim, variacao, null));
    }

    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }

    public TipoLinguagemSimples obterTipo(String nome) {
        return tabela.get(nome).tipo;
    }

    public int obterLargura(String nome) {
        return tabela.get(nome).n0;
    }

    public int obterAltura(String nome) {
        return tabela.get(nome).n1;
    }

    public int obterInicio(String nome) {
        return tabela.get(nome).n0;
    }

    public int obterFim(String nome) {
        return tabela.get(nome).n1;
    }

    public int obterVariacao(String nome) {
        return tabela.get(nome).n2;
    }

    public Color[][] obterImagem(String nome) {
        return tabela.get(nome).imagem;
    }
}
