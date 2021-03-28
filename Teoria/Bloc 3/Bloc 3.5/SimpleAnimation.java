/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleanimation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sergiosayago
 */
public class SimpleAnimation {

    private int x;
    private int y;
    
    private JFrame frame;
    private PanelDeDibuix panell;
    
    public SimpleAnimation(){
        frame = new JFrame();
        panell = new PanelDeDibuix();        
    }
    
    public void go(){
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panell);
        frame.setVisible(true);
        //animacio
        for (int i = 0; i < 200; i++){
            x++;
            y++;
            frame.repaint();            
            try{
                Thread.sleep(5);
            } catch(Exception ex){}
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }
    
    class PanelDeDibuix extends JPanel{
        public void paintComponent (Graphics g){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            g.setColor(Color.yellow);
            g.fillOval(x, y, 40, 40);
        }
    }
    
}
