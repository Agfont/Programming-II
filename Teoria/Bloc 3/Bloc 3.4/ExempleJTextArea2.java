/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplejtextarea2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author sergiosayago
 */
public class ExempleJTextArea2 {

    private JFrame frame;
    private JButton boto;
    private JPanel panell;
    private JTextArea text;
    private JScrollPane scroll;
    
    public ExempleJTextArea2(){
        frame = new JFrame();
        boto = new JButton ("El boto");
        text = new JTextArea(10,20);
        scroll = new JScrollPane(text);
        panell = new JPanel();
    }
    
    public void go(){
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JTextArea
        text.setLineWrap(true);
        //scroll policy
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //montar GUI
        panell.add(scroll);
        frame.getContentPane().add(BorderLayout.CENTER, panell);
        frame.getContentPane().add(BorderLayout.SOUTH, boto);
        //escoltador
        boto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                text.append(boto.getText().concat("\n"));
            }            
        });
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ExempleJTextArea2 gui = new ExempleJTextArea2();
        gui.go();
    }
    
}
