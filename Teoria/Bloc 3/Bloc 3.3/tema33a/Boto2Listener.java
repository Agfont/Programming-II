/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema33a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Sergio
 */
public class Boto2Listener implements ActionListener{

    private JLabel etiqueta;
    
    public Boto2Listener(JLabel jl){
        etiqueta = jl;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        etiqueta.setText("Etiqueta canviada");
    }
    
}
