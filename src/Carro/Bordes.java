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
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */

public class Bordes {
    private int x;
    private int y;
    private Image tileset;
    private int numImage;
    public Bordes(int x, int y) {
        this.x = x;
        this.y = y;
        this.numImage =0;
        this.tileset = loadImage("bordes.png");
    }
    
    public Bordes(){
       this.x=25;
       this.y=25;
    }
    
    public void dibujar(Graphics g, JPanel panel){
      g.setColor(Color.red);
      g.drawImage(tileset, x, y, null);
    
    }
    
    
    protected Image loadImage(String imageName) {
       ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
         return image;
    }
    
    public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 25, 25);
    }
}
