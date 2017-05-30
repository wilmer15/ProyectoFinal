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
public class Panel3 extends JPanel {

	public Panel3() {
		JPanel panel3 = new JPanel(new BorderLayout());
                Font fuente = new Font("Calibri",2, 10);
                 
                panel3.setSize(1200,800);
                panel3.setBackground(java.awt.Color.white);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("E.png"));
                
		JButton button = new JButton("Adelante");
                JButton button1 = new JButton("Atras");
                button.setBackground(java.awt.Color.red);
                button.setFont(fuente);
                button.setSize(300,300);
                panel3.add(label,BorderLayout.CENTER);
                panel3.add(button,BorderLayout.EAST);
                panel3.add(button1,BorderLayout.WEST);
                
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main_1.changeState(ViewState.NEXTP3,0);
			}
		});
                button1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Main_1.changeState(ViewState.TABE,0);
                    }
                });
              
		this.add(panel3);
                
	}
        

}
