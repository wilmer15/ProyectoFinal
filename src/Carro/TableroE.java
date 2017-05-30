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
public class TableroE extends JPanel implements ActionListener, KeyListener,Runnable{
    private Timer timer; 
    private ArrayList<Circulo> circulo;
    private ArrayList<Dulce> dulce;
    private ArrayList<Trans> trans;
    private ArrayList<Bordes> bordes;
    private Carro personajePrincipal;
    private Sound sonido;
    protected JFrame frame;

    private int puntaje = 0;
    private int colisiones = 0;
    protected TableroA a;
    int cuadro=136;
    int c=68;
    protected boolean colision=false;
    
    public boolean getColision() {
        return colision;
    }
    public void setColision(boolean colision) {
        this.colision = colision;
    }
    
    public TableroE(){
      this.setFocusable(true);
      this.addKeyListener(this);
      this.personajePrincipal = new Carro(100,200);
      this.a=new TableroA();
      this.circulo = new ArrayList<Circulo>();
      this.dulce = new ArrayList<Dulce>();
      this.trans = new ArrayList<Trans>();
      this.bordes = new ArrayList<Bordes>();
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
      
      ///-------------------------------------linea3----------------
      this.circulo.add(new Circulo(420,134));
      this.circulo.add(new Circulo(488,134));
      this.circulo.add(new Circulo(556,134));
      this.circulo.add(new Circulo(624,134));
      this.circulo.add(new Circulo(692,134)); 
      ///-------------------------------------linea2----------------
      this.circulo.add(new Circulo(420,338));
      this.circulo.add(new Circulo(488,338));
      this.circulo.add(new Circulo(556,338));
      this.circulo.add(new Circulo(624,338));
      //---------------------------------------linea-------------
      this.circulo.add(new Circulo(284,678));
      this.circulo.add(new Circulo(352,678));
      this.circulo.add(new Circulo(420,678));
      this.circulo.add(new Circulo(488,678));
      this.circulo.add(new Circulo(556,678));
      this.circulo.add(new Circulo(624,678));
      this.circulo.add(new Circulo(692,678));     
      //---------------------------------------lineabajo-------------
      this.circulo.add(new Circulo(420,134));
      this.circulo.add(new Circulo(420,202));
      this.circulo.add(new Circulo(420,270));
      this.circulo.add(new Circulo(420,338));
      this.circulo.add(new Circulo(420,406));
      this.circulo.add(new Circulo(420,474));
      this.circulo.add(new Circulo(420,542));
      //---------------------------------------lineabajo2-------------
      this.circulo.add(new Circulo(284,134));
      this.circulo.add(new Circulo(284,202));
      this.circulo.add(new Circulo(284,270));
      this.circulo.add(new Circulo(284,338));
      this.circulo.add(new Circulo(284,406));
      this.circulo.add(new Circulo(284,474));
      this.circulo.add(new Circulo(284,542));
      //-----------------------------------------dulces----------
      this.dulce.add(new Dulce(284,66));
      this.dulce.add(new Dulce(284,604));
      this.dulce.add(new Dulce(624,264));
      //-----------------------------------------trans-----------
      this.trans.add(new Trans(1100,672));
      
      this.timer = new Timer(50, this);
      //this.sonido.loop();
      timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         //omagen---------
         Image fondo = loadImage("Ef.png");//omagen---------
        g.drawImage(fondo, 0, 0, null);
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
            a.setVisible(false);
            this.frame.add(new TableroI());
            this.frame.setLocationRelativeTo(null);
            this.frame.setVisible(true);
            timer.stop();
        }
        validarColisiones();
        validarBordes();
        validarDulces();
        validarTrans();
         for(Circulo c: this.circulo)
           // c.mover();
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
               this.personajePrincipal.setX(488);
               this.personajePrincipal.setY(264);
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
        a.timer.start();
        timer.start();
        
    }
}
