package Carro;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * @author Ron Brash (ron.brash@gmail.com)
 * 
 *         The concept of this class is to create a panel which
 *         contains a JButton which has an inline actionListener.
 *         
 *         The action listener will change the state using a static
 *         function from the class Main.
 */
@SuppressWarnings("serial")
public class Panel1 extends JPanel {

	public Panel1() {
		JPanel panel1 = new JPanel(new BorderLayout());
                  Font fuente = new Font("Calibri",2, 10);
                 
              
                panel1.setSize(1200,800);
                panel1.setBackground(java.awt.Color.white);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("vocales.jpg"));
                panel1.add(label,BorderLayout.CENTER);
		JButton button = new JButton("Empezar a Jugar");
                button.setBackground(java.awt.Color.red);
                button.setFont(fuente);
                button.setForeground(java.awt.Color.GREEN);
                JButton button1 = new JButton("Observar Diccionario");
                button.setBackground(java.awt.Color.blue);
                
                button.setSize(300,300);
                
                JLabel imagen = new JLabel();
                
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main_1.changeState(ViewState.NEXT_STATE,0);

			}
		});
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Main_1.changeState(ViewState.TABE,0);
                    }
                });
                panel1.add(button,BorderLayout.WEST);
                panel1.add(button1,BorderLayout.SOUTH);
              
		this.add(panel1);
                
	}
        

}
