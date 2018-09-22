/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Vitor
 */
public class Base {
    protected int x;
    protected int y;
    protected int incX;
    protected int incY;
    protected Color cor = Color.BLACK;
    protected int altura;
    protected int largura;

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Rectangle getLimites(){
        return new Rectangle(x, y, largura, altura);
    }
    
    public void mover() {
        x = x + (int)incX;
        y = y + (int)incY;
    }
}
