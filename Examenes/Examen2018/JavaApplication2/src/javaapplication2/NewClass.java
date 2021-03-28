/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Miguel
 */
public class NewClass extends JDialog{
    
    JLabel Informacio;
    JCheckBox check;
    JCheckBox check2;
    JLabel nom;

    public JLabel getInformacio() {
        return Informacio;
    }

    public JCheckBox getCheck() {
        return check;
    }

    public JCheckBox getCheck2() {
        return check2;
    }

    public JLabel getNom() {
        return nom;
    }

    public JLabel getComu() {
        return comu;
    }

    public JLabel getPreferot() {
        return preferot;
    }

    public JLabel getDni() {
        return dni;
    }

    public JLabel getActivitats() {
        return activitats;
    }

    public JLabel getDescompte() {
        return descompte;
    }

    public JTextField getN() {
        return n;
    }

    public JTextField getDn() {
        return dn;
    }

    public JTextField getNum() {
        return num;
    }

    public JTextField getDes() {
        return des;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JButton getAcceptar() {
        return acceptar;
    }

    public JDialog getJ() {
        return j;
    }
    JLabel comu;
    JLabel preferot;
    JLabel dni;
    JLabel activitats;
    JLabel descompte;
    JTextField n;
    JTextField dn;
    JTextField num;
    JTextField des;
    JButton cancelar;
    JButton acceptar;
    JDialog j;
    JPanel jp = new JPanel();
    public NewClass(){
        
        setSize(400,400);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jp, BorderLayout.CENTER);
		jp.setLayout(null);
        Informacio = new JLabel("info");
        
        jp.add(Informacio);
        
        
        jp.setVisible(true);
        comu=new JLabel("comu");
        jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
        jp.add(comu);
       
        check=new JCheckBox();
        jp.add(check);
         preferot=new JLabel("preferot");
        jp.add(preferot);
        check2=new JCheckBox();
        jp.add(check2);
        
        nom=new JLabel("nom");
        jp.add(nom);
        n=new JTextField();
        jp.add(n);
        
        dni=new JLabel("dni");
        jp.add(dni);
        dn=new JTextField();
        jp.add(dn);
        
        activitats=new JLabel("activitats");
        jp.add(activitats);
        num=new JTextField();
        jp.add(num);
        
        descompte=new JLabel("descompte");
        jp.add(descompte);
        des=new JTextField();
        jp.add(des);
        
        acceptar=new JButton("acceptar");
        acceptar.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jp.add(acceptar);
    }
    
    public static void main(String [] args){
        NewClass aplicacion = new NewClass();
        aplicacion.setVisible(true);
    }
}
