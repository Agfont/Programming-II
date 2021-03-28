/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipaneldibuix;

import javax.swing.JFrame;

/**
 *
 * @author sergiosayago
 */
public class GUIPanelDibuix {

    /**
     * @param args the command line arguments
     */
    
    private JFrame frame;
    private PanelDeDibuix panell;
    
    public GUIPanelDibuix(){
        frame = new JFrame();
        panell = new PanelDeDibuix();
    }
    public void go(){        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(panell);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GUIPanelDibuix gui = new GUIPanelDibuix();
        gui.go();
    }
    
}
