/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema33c;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Sergio
 */
public class Tema33c {

    private JFrame frame;
    private JLabel etiqueta;
    private JButton boto1;
    private JButton boto2;
    
    public Tema33c(){
        frame = new JFrame();
        etiqueta = new JLabel("Soc una etiqueta");
        boto1 = new JButton ("Canvia mida");
        boto2 = new JButton ("Canvia etiqueta");
    }
    public void go(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, boto1);
        frame.getContentPane().add(BorderLayout.SOUTH, boto2);
        frame.getContentPane().add(BorderLayout.CENTER, etiqueta);
        frame.setSize(300, 300);
        
        boto1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                frame.setSize(100, 100);
            }
            
        });
        
        boto2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                etiqueta.setText("Etiqueta canviada");
            }
            
        });
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Tema33c gui = new Tema33c();
        gui.go();
    }
    
}
