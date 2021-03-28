/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema33a;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Sergio
 */
public class Tema33a {

    private JFrame frame;
    private JLabel etiqueta;
    private JButton boto1;
    private JButton boto2;
    
    public Tema33a(){
        frame = new JFrame();
        etiqueta = new JLabel("Soc una etiqueta");
        boto1 = new JButton("Canvia mida");
        boto2 = new JButton ("Canvia etiqueta");
    }
    
    public void go(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(BorderLayout.NORTH, boto1);
        frame.add(BorderLayout.SOUTH, boto2);
        frame.add(BorderLayout.CENTER, etiqueta);
        frame.setSize(300, 300);
        boto1.addActionListener(new Boto1Listener(frame));
        boto2.addActionListener(new Boto2Listener(etiqueta));
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Tema33a gui = new Tema33a();
        gui.go();
    }
    
}
