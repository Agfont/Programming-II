/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplejlist;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author sergiosayago
 */
public class ExempleJList implements ListSelectionListener {

    private JFrame frame;
    private JList llista;
    private JPanel panell;
    private JScrollPane scroll;
    private String[] entrada;
    
    public ExempleJList(){
        entrada = new String[5];
        entrada[0] = "alpha";
        entrada[1] = "beta";
        entrada[2] = "gamma";
        entrada[3] = "delta";
        entrada[4] = "epsilon";
        frame = new JFrame();
        llista = new JList(entrada);
        panell = new JPanel();
        scroll = new JScrollPane(llista);
    }
    
    public void go(){
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //scroll policy
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //llista
        llista.setVisibleRowCount(4);
        llista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //escoltador
        llista.addListSelectionListener(this);
        //montar GUI
        panell.add(scroll);
        frame.getContentPane().add(BorderLayout.CENTER, panell);        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ExempleJList gui = new ExempleJList();
        gui.go();
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (lse.getValueIsAdjusting()){
            System.out.println((String)llista.getSelectedValue());
        }
    }
    
}
