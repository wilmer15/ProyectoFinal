package Carro;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Ron Brash (ron.brash@gmail.com)
 * 
 *         The concept of this class is to create a JFrame which contains three
 *         panels:
 * 
 *         > mpanel is the master panel in which all of the other panel related
 *         content will be added to it
 * 
 *         > panel1 is the first panel to be displayed
 * 
 *         > panel2 is the second panel to be displayed
 * 
 *         Both panel1 and panel2 contain JButtons which will alter the enum
 *         viewState and depending on the state (which is determined by button
 *         click), the correct panel will be rendered.
 * 
 *         If you do not use a master panel, removeAll() will cause logic errors
 *         for whatever reason.
 */
public class Main_1 {

	private static ViewState viewState;
	private static JPanel mpanel;
	private static JPanel panel1;
        private static JPanel panel2;
        private static JPanel panel3;
        private static JPanel panel4;
        private static JPanel panel5;
        private static JPanel panel6;
	private static JFrame frame;
        private static TableroA tableroa;
        private static TableroE tableroe;
        private static Timer time;

        @SuppressWarnings("empty-statement")
	public Main_1() {

		frame = new JFrame();
                tableroa= new TableroA();
                tableroe= new TableroE();
		mpanel = new JPanel();
		panel1 = new Panel1();
                panel2= new Panel2();
                panel3= new Panel3();
                panel4= new Panel4();
                panel5=new Panel5();
                panel6=new Panel6();
                
		// Sets default state
		changeState(ViewState.START_STATE,0);
		frame.setSize(1200, 800);
 
		frame.add(mpanel);
		frame.setVisible(true);
                frame.setLocationRelativeTo(null);

	}

	/**
	 * changeState(ViewState state)
	 * 
	 * Publicly available state changer function
	 * 
	 * @param state
	 * @return void
	 */
	public static void changeState(ViewState state,int list) {
                Runnable A = new TableroA();
                Thread thread1= new Thread(A);
                Runnable E = new TableroE();
                Thread thread2= new Thread(E);
                 thread1.start();
                 thread2.start();
                 
		viewState = state;
		System.out.println("change state: " + viewState);

		switch (state) {
		case START_STATE:
			mpanel.removeAll();
			mpanel.add(panel1);
			mpanel.revalidate();
			mpanel.repaint();
			break;
		case NEXT_STATE:
                        if(list==0){
                        System.out.println("i");
                        mpanel.removeAll();
			frame.add((Component) A);
                        frame.setVisible(false);
                        frame.setVisible(true);
			mpanel.revalidate();
			mpanel.repaint(); 
                        break;
                        }else{
                        
                        thread2.run();
                        thread1.suspend();
                        mpanel.removeAll(); 
                        mpanel.add(panel1);
                        frame.setVisible(false);
                        frame.setVisible(true);
			mpanel.revalidate();
			mpanel.repaint(); 
                        
                        break;    
                        }
                case TABE:
                        mpanel.removeAll();
			mpanel.add(panel2);
			mpanel.revalidate();
			mpanel.repaint();
			break;
                case NEXTP2:
                        mpanel.removeAll();
			mpanel.add(panel3);
			mpanel.revalidate();
			mpanel.repaint();
                        break;
                case NEXTP3:
                        mpanel.removeAll();
			mpanel.add(panel4);
			mpanel.revalidate();
			mpanel.repaint();
                        break;
                case NEXTP4:
                        mpanel.removeAll();
			mpanel.add(panel5);
			mpanel.revalidate();
			mpanel.repaint();
                        break;	
                case NEXTP5:
                        mpanel.removeAll();
			mpanel.add(panel6);
			mpanel.revalidate();
			mpanel.repaint();
                        break;
		default:
			System.out.println("UNKNOWN STATE!");
			break;
		}
	}

	/**
	 * main(String[] args)
	 * 
	 * Like an opinion, everyone has one.
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
               
                
		Main_1 n = new Main_1();
                
            
	}

}
