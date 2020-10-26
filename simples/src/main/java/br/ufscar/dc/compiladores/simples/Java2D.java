package br.ufscar.dc.compiladores.simples;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

class Imagem extends JPanel {

    int largura;
    int altura;
    Color[][] imagem;

    public Imagem(int largura, int altura, Color[][] imagem) {
        this.largura = largura;
        this.altura = altura;
        this.imagem = imagem;
    }

    private void desenhar(Graphics grafico) {
        Graphics2D grafico2d = (Graphics2D) grafico;

        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                grafico2d.setPaint(imagem[x][y]);
                grafico2d.drawLine(x, y, x, y);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhar(g);
    }
}

public class Java2D extends JFrame {

    int largura;
    int altura;
    Color[][] imagem;

    public Java2D(int largura, int altura, Color[][] imagem) {
        this.largura = largura;
        this.altura = altura;
        this.imagem = imagem;
        inicializar();
    }

    private void inicializar() {
        add(new Imagem(largura, altura, imagem));

        setTitle("Imagem Simples");
        setSize(largura, altura);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
