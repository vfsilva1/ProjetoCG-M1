/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

/**
 *
 * @author Vitor
 */
public class Jogador extends Base{
    protected ImageIcon imgJogador;
    protected int hp = 3; //3 de hp(saúde)
    
    public Jogador (int width, int height, String url) {
        x = 640;
        y = 360;
        imgJogador = new ImageIcon(this.getClass().getResource("/").getPath() + url);
        largura = imgJogador.getIconWidth();
        altura=  imgJogador.getIconHeight();
    }

    public ImageIcon getImgJogador() {
        return imgJogador;
    }

    public void setImgJogador(ImageIcon imgJogador) {
        this.imgJogador = imgJogador;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void desenharJogador (Graphics2D g2Jogador, int mx, int my) {
        if (imgJogador != null) {
            AffineTransform at =  AffineTransform.getTranslateInstance(x, y);
            at.rotate(calculaAngulo(mx, my), imgJogador.getIconWidth() / 2, imgJogador.getIconHeight() / 2);
            g2Jogador.drawImage(imgJogador.getImage(), at, null);
        }
    }

    private double calculaAngulo(int mx, int my) {
        return Math.atan2((my - (y + 18 + imgJogador.getIconHeight() / 2)), (mx - (x + imgJogador.getIconWidth() / 2)));
    }
}
