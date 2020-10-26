package br.ufscar.dc.compiladores.simples;

import java.util.List;
import java.util.LinkedList;
import java.awt.Color;

public class Escopos {

    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    public Escopos() {
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo();
    }

    public void criarNovoEscopo() {
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }

    public TabelaDeSimbolos obterEscopoAtual() {
        return pilhaDeTabelas.peek();
    }

    public List<TabelaDeSimbolos> percorrerEscoposAninhados() {
        return pilhaDeTabelas;
    }

    public void abandonarEscopo() {
        pilhaDeTabelas.pop();
    }

    public void adicionarCor(String nome) {
        obterEscopoAtual().adicionarCor(nome);
    }

    public void adicionarCor(String nome, Color cor) {
        obterEscopoAtual().adicionarCor(nome, cor);
    }

    public void adicionarImagem(String nome, int largura, int altura) {
        obterEscopoAtual().adicionarImagem(nome, largura, altura);
    }

    public void adicionarImagem(String nome, int largura, int altura, Color[][] imagem) {
        obterEscopoAtual().adicionarImagem(nome, largura, altura, imagem);
    }

    public void adicionarNumero(String nome, int inicio, int fim, int variacao) {
        obterEscopoAtual().adicionarNumero(nome, inicio, fim, variacao);
    }

    public boolean existe(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return true;
            }
        }
        return false;
    }

    public TabelaDeSimbolos.TipoLinguagemSimples obterTipo(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterTipo(nome);
            }
        }
        return null;
    }

    public int obterLargura(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterLargura(nome);
            }
        }
        return 0;
    }

    public int obterAltura(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterAltura(nome);
            }
        }
        return 0;
    }

    public int obterInicio(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterInicio(nome);
            }
        }
        return 0;
    }

    public int obterFim(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterFim(nome);
            }
        }
        return 0;
    }

    public int obterVariacao(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterVariacao(nome);
            }
        }
        return 0;
    }

    public Color[][] obterImagem(String nome) {
        for (TabelaDeSimbolos ts : pilhaDeTabelas) {
            if (ts.existe(nome)) {
                return ts.obterImagem(nome);
            }
        }
        return null;
    }
}
