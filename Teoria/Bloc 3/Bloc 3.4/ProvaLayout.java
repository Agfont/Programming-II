/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provalayout;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author sergiosayago
 */
public class ProvaLayout {

    private JFrame frame;
    private JPanel panell;
    private JPanel panellb;
    private JButton boto1;
    private JButton boto2;
    
    public ProvaLayout(){
        frame = new JFrame();
        boto1 = new JButton ("boto1");
        boto2 = new JButton ("boto2");
        panell = new JPanel();
        panellb = new JPanel();
    }
    
    public void go(){
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        panell.setLayout(new BoxLayout(panell, BoxLayout.Y_AXIS));
        panell.add(boto1);
        panell.add(boto2);   
        //amb aquest panellb conseguim tenir-lo en vertical i centrat
        panellb.add(panell);
        frame.getContentPane().add(BorderLayout.CENTER, panellb);        
        frame.setVisible(true);       
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ProvaLayout gui = new ProvaLayout();
        gui.go();
    }
    
}
