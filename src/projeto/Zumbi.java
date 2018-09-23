/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Vitor
 */
public class Zumbi extends Base{
    protected ImageIcon imgZumbi;
    Random r = new Random();
    protected int direcaoX;
    protected int direcaoY;
    protected boolean visivel;
    protected static int hp = 3;
    
    public Zumbi(String url){
        imgZumbi = new ImageIcon(this.getClass().getResource("/").getPath() + url);
        largura = imgZumbi.getIconWidth();
        altura = imgZumbi.getIconHeight();
        visivel = true;
        random(r);
    }
    
    public void desenhar (Graphics2D g2Zumbi, int jogadorX, int jogadorY){
        if(imgZumbi != null) {
            AffineTransform at =  AffineTransform.getTranslateInstance(x, y);
            at.rotate(calculaAngulo(jogadorX, jogadorY), imgZumbi.getIconWidth() / 2, imgZumbi.getIconHeight() / 2);
            g2Zumbi.drawImage(imgZumbi.getImage(), at, null);
        }
    }

    private double calculaAngulo(int jogadorX, int jogadorY) {
        return Math.atan2((jogadorY - y), (jogadorX - x));
    }
    
    private void random(Random r){
        int n = r.nextInt(4) + 1;
        
        switch (n){
            case 1:
                x = direcaoX = 640;
                y = direcaoY = 0;
                break;
            case 2:
                x = direcaoX = 1280;
                y = direcaoY = 360;
                break;
            case 3:
                x = direcaoX = 640;
                y = direcaoY = 720;
                break;
            case 4:
                x = direcaoX = 0;
                y = direcaoY = 360;
                break;
            default:
                break;
        }
    }

    public int getDirecaoX() {
        return direcaoX;
    }

    public void setDirecaoX(int direcaoX) {
        this.direcaoX = direcaoX;
    }

    public int getDirecaoY() {
        return direcaoY;
    }

    public void setDirecaoY(int direcaoY) {
        this.direcaoY = direcaoY;
    }
}
