/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratonswing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sergiosayago
 */
public class RatonSwing {

    private JFrame frame;
    private PanelDeDibuix panell;
    private int x;
    private int y;
    
    public RatonSwing(){
        frame = new JFrame();
        panell = new PanelDeDibuix();
    }
    
    public void go(){
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panell);
        frame.addMouseListener(new GestorRatoli());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        RatonSwing gui = new RatonSwing();
        gui.go();
    }
    
    class GestorRatoli extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            x = e.getX();
            y = e.getY();
            frame.repaint();
        }
    }
    class PanelDeDibuix extends JPanel{
        public void paintComponent (Graphics g){
            g.drawString(x+","+y,x,y);
        }
    }
    
}
