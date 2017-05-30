/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Usuario9
 */
public class TableroA extends JPanel implements ActionListener, KeyListener,Runnable{
    protected Timer timer; 
    private ArrayList<Circulo> circulo;
    private ArrayList<Dulce> dulce;
    private ArrayList<Trans> trans;
    private ArrayList<Bordes> bordes;
    private Carro personajePrincipal;
    private Sound sonido;
    private JFrame frame;
    private int colisiones = 0;
    private int puntaje = 0;
    int cuadro=136;
    int c=68;
    protected boolean colision=false;
    
    public boolean getColision() {
        return colision;
    }
    public void setColision(boolean colision) {
        this.colision = colision;
    }
    
    public TableroA(){
      this.setFocusable(true);
      this.addKeyListener(this);
      this.personajePrincipal = new Carro(100,200);
      this.bordes = new ArrayList<Bordes>();
      this.circulo = new ArrayList<Circulo>();
      this.dulce = new ArrayList<Dulce>();
      this.trans = new ArrayList<Trans>();
      ///-------------------------------------BORDES----------------
      for(int i=0; i<32;i++){
          this.bordes.add(new Bordes(0,i*25));
      }
      for(int i=0; i<32;i++){
          this.bordes.add(new Bordes(1175,i*25));
      }
      for(int i=1; i<47;i++){
          this.bordes.add(new Bordes(25*i,0));
      }
      for(int i=1; i<47;i++){
          this.bordes.add(new Bordes(25*i,775));
      }
      ///-------------------------------------sube----------------
      //this.circulo.add(new Circulo(284,468-c));
      this.circulo.add(new Circulo(80,672));
      this.circulo.add(new Circulo(148,604));
      this.circulo.add(new Circulo(216,536));
      this.circulo.add(new Circulo(284,468));
      this.circulo.add(new Circulo(352,400));
      
      this.circulo.add(new Circulo(488,264));
      this.circulo.add(new Circulo(556,196));
      //this.circulo.add(new Circulo(771-cuadro,264));
      ///-------------------------------------baja----------------
      //this.circulo.add(new Circulo(624,196));
      this.circulo.add(new Circulo(624,264));
      this.circulo.add(new Circulo(692,332));
      this.circulo.add(new Circulo(760,400));
      this.circulo.add(new Circulo(828,468));
      this.circulo.add(new Circulo(896,536));
      this.circulo.add(new Circulo(964,604));
      this.circulo.add(new Circulo(1032,672));
      //---------------------------------------linea-------------
      this.circulo.add(new Circulo(420,468));
      this.circulo.add(new Circulo(488,468));
      this.circulo.add(new Circulo(556,468));
      this.circulo.add(new Circulo(624,468));
      this.circulo.add(new Circulo(692,468));
      //-----------------------------------------dulces----------
      this.dulce.add(new Dulce(556,128));
      this.dulce.add(new Dulce(1032,604));
      this.dulce.add(new Dulce(692,400));
      //-----------------------------------------trans-----------
      
      this.trans.add(new Trans(1100,672));
      this.timer = new Timer(100, this);
      //this.sonido.loop();
      
      
    }
//    @Override
    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         //omagen---------
         
        Image fondo = loadImage("Af.png");//omagen---------
        g.drawImage(fondo, 0, 0, null);
        //Image fondo2 = loadImage("gif.gif");//omagen---------
        //g.drawImage(fondo2, 0, 0, null);
        
        
         for(Circulo c: this.circulo)
            c.dibujar(g,this);
         
         for(Dulce d: this.dulce)
            d.dibujar(g,this);
         
         for(Trans t: this.trans)
            t.dibujar(g,this);
         
         for(Bordes b: this.bordes)
            b.dibujar(g, this);
         
         this.personajePrincipal.dibujar(g,this);
         g.drawString("Puntaje " + puntaje, 40, 40);
         
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.puntaje==3){
            this.frame=new JFrame();
            this.frame.setSize(1200, 800);
            this.frame.add(new TableroE());
            this.frame.setLocationRelativeTo(null);
            this.frame.setVisible(true);
            timer.stop();
        }
        validarColisiones();
        validarBordes();
        validarDulces();
        validarTrans();
        
         for(Circulo c: this.circulo)
//            c.mover();
            repaint();
    }
     
    
    public void validarColisiones(){
         Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle Rec = c.obtenerRectangulo();
           if(recPersonaje.intersects(Rec)){
               
               if(recPersonaje.getX()<=Rec.getX()){
           this.personajePrincipal.setX(this.personajePrincipal.getX()-35);
           }
               else if(Rec.getX()<recPersonaje.getX()){
               this.personajePrincipal.setX(this.personajePrincipal.getX()+35);
           }
               else if(recPersonaje.getY()<=Rec.getY()){
           this.personajePrincipal.setY(this.personajePrincipal.getY()-35);
           }
               else if(Rec.getY()<recPersonaje.getY()){
               this.personajePrincipal.setY(this.personajePrincipal.getY()+35);
           }
              this.colisiones++;
           }
           this.circulo=copia;
        }
    
        /*Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle RecCir = c.obtenerRectangulo();
           if(recPersonaje.intersects(RecCir)){
               this.puntaje++;
               this.colision=true;
           }
           this.circulo=copia;
       
        }
            if(puntaje==0){
               this.colision=false;
           }
              
           this.puntaje=0;*/
    }
    
public void validarBordes(){
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Bordes> bor = (ArrayList<Bordes>) this.bordes.clone();
        for(Bordes b : this.bordes){
           Rectangle Rec = b.obtenerRectangulo();
           if(recPersonaje.intersects(Rec)){
               if(recPersonaje.getX()<=Rec.getX()){
               this.personajePrincipal.setX(this.personajePrincipal.getX()-68);
           }
               else if(Rec.getX()<recPersonaje.getX()){
               this.personajePrincipal.setX(this.personajePrincipal.getX()+68);
           }
               else if(recPersonaje.getY()<=Rec.getY()){
           this.personajePrincipal.setY(this.personajePrincipal.getY()-68);
           }
               else if(Rec.getY()<recPersonaje.getY()){
                   System.out.println("hola");
               this.personajePrincipal.setY(this.personajePrincipal.getY()+68);
           }
              this.colisiones++;
           }
           this.bordes=bor;
        }
}
public void validarDulces(){
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Dulce> copiad = (ArrayList<Dulce>) this.dulce.clone();
        for(Dulce d : dulce){
           Rectangle RecDul = d.obtenerRectangulo();
           if(recPersonaje.intersects(RecDul)){
               
               copiad.remove(d);
               this.puntaje++;
           }
           this.dulce=copiad;   
           
        }
}
public void validarTrans(){
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Trans> copiat = (ArrayList<Trans>) this.trans.clone();
        for(Trans t : trans){
           Rectangle RecCir = t.obtenerRectangulo();
           if(recPersonaje.intersects(RecCir)){
               this.personajePrincipal.setX(420);
               this.personajePrincipal.setY(400);
               }
           this.trans=copiat;   
           
        }
}

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       this.personajePrincipal.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void run() {
        timer.start();
        if(this.puntaje==3){
            timer.stop();
        }
    }
    
  
   
}
