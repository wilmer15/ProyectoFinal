/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Personaje principal
 */
public class Carro {
    private int x;
    private int y;
    private int Secuencia;
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    private Image tileset;
        
    public Carro(int x, int y) {
        this.x = x;
        this.y = y;
        this.Secuencia=0;
        this.tileset = loadImage("Mostrico.jpg");
    }

    public Image getTileset() {
        return tileset;
    }

    public void setTileset(Image tileset) {
        this.tileset = tileset;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public Carro(){
       this.x=20;
       this.y=20;
    }
    public void dibujar(Graphics g, JPanel panel){
       g.setColor(Color.red);
       g.drawImage(tileset,x, y,x+50, y+50 ,50*this.Secuencia ,0, 50*this.Secuencia+ 50 ,50, panel);
       this.Secuencia++;
       if(this.Secuencia==4){
           this.Secuencia=0;
       }
    }
    
    
   protected Image loadImage(String imageName) {
       ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
         return image;
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN: y += 10; break;
            case KeyEvent.VK_UP: y -= 10; break;
            case KeyEvent.VK_LEFT: x -= 10; break;
            case KeyEvent.VK_RIGHT: x += 10; break;
              
          }
    }
    
    public void mover(){
       this.x+=1;
       //this.y+=1;
    }
    
     public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y,50, 50);
    }
}
