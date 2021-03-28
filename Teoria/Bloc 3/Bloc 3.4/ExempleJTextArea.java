/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplejtextarea;

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
public class ExempleJTextArea implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton boto;
    private JScrollPane scroll;
    private JTextArea text;
    
    public ExempleJTextArea(){
        frame = new JFrame();
        panel = new JPanel();
        boto = new JButton("Apreta'm");        
        text = new JTextArea(10,20);   
        scroll = new JScrollPane(text);
    }
    
    public void go(){
        frame.setSize(300, 300);
        text.setLineWrap(true);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scroll);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, boto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boto.addActionListener(this);
        frame.setVisible(true);        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ExempleJTextArea gui = new ExempleJTextArea();
        gui.go();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        text.append("boto apretat\n");
    }
    
}
