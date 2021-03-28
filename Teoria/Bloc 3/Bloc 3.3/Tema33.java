/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema33;

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
public class Tema33 implements ActionListener{

    private JFrame frame;
    private JLabel etiqueta;
    private JButton boto1, boto2;
    
    public Tema33(){
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
        boto1.addActionListener(this);
        boto2.addActionListener(this);
        frame.setVisible(true);        
    }
    
    public static void main(String[] args) {
        Tema33 gui = new Tema33();
        gui.go();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (ae.getSource().equals(boto1)){        
        frame.setSize(100, 100);
    }
    else{
        etiqueta.setText("Etiqueta canviada");
    }
    }
    
}
