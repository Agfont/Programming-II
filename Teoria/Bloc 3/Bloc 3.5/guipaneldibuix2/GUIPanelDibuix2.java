/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipaneldibuix2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sergiosayago
 */
public class GUIPanelDibuix2 {

    private JFrame frame;
    private JButton boto1;
    private JButton boto2;
    private JLabel etiqueta;
    private PanelDeDibuix panell;
    
    public GUIPanelDibuix2(){
        frame = new JFrame();
        boto1 = new JButton("Canviar color");
        boto2 = new JButton("Canviar etiqueta");
        etiqueta = new JLabel("Soc una etiqueta");
        panell = new PanelDeDibuix();
    }
    
    public void go(){
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, boto1);
        frame.getContentPane().add(BorderLayout.CENTER, panell);
        frame.getContentPane().add(BorderLayout.EAST, boto2);
        frame.getContentPane().add(BorderLayout.WEST, etiqueta);
        //escoltadors
        boto1.addActionListener(new ColorButtonListener());
        boto2.addActionListener(new LabelButtonListener());
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        GUIPanelDibuix2 gui = new GUIPanelDibuix2();
        gui.go();
    }
    
    class LabelButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            etiqueta.setText("Ouch!");
        }
        
    }
    
    class ColorButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //frame.repaint();
            panell.repaint();
        }
        
    }
    
}
