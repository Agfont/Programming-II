/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JavaApplication2 {
    JFrame frame;
    JButton afegir;
    JList lista;
    JButton calcular;
    JLabel app;
    JLabel total;
    JTextField tot;
    JButton sortir;
    ArrayList<socis> llistaSocis;
    int i=-1;
    
    public JavaApplication2(){
        frame = new JFrame("Aplicació de gestió de socis");
        llistaSocis= new ArrayList<socis>();
    }
    
    public void ini(){
        JPanel panel = new JPanel();
        app=new JLabel("aplicació");
        panel.add(app);
        afegir = new JButton("afegir soci");
        afegir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent Arg0){
            NewClass n = new NewClass();
            n.setModal(true);
            n.setVisible(true);
            if(n.getN().getText().length()>0){
                String nombre=n.n.getText();
                String k = "";
                if(n.check.isSelected())k="comu";
                else if(n.check2.isSelected()){
                    k="preferit";
                    n.des.setEditable(false);
                }
                String dni=n.dn.getText();
                String a=n.num.getText();
                int act=Integer.parseInt(a);
                String d=n.des.getText();
                int desc=Integer.parseInt(d);
                int tamano=lista.getModel().getSize()+1;
                Object[] Modelo = new Object[tamano];
                for(int j=0; j<tamano-1; j++) {
                        Modelo[j]=lista.getModel().getElementAt(j);
                }
                Modelo[tamano-1]="soci "+k+": "+nombre;
                lista.setListData(Modelo);
                socis s=new socis();
                s.setActivitats(act);
                if(k=="comu")s.setComu(true);
                else s.setPreferit(true);
                s.setDni(dni);
                s.setNom(nombre);
                s.setDescomptes(desc);
                llistaSocis.add(s);
                if(lista.isSelectedIndex(1)){
                    int i=lista.getSelectedIndex();
                    String ss=String.valueOf(i);
                    tot.setText(ss);
                }
                
            
            }
        }
        });
        panel.add(afegir);
        
        lista=new JList();
        
        
        lista.setBackground(new Color(255, 255, 255));
        lista.addListSelectionListener(new ListSelectionListener() {
      
            public void valueChanged(ListSelectionEvent e) {
                i=lista.getSelectedIndex();
                
            }
    });
        panel.add(lista);
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        
        
        total=new JLabel("total");
        
        panel.add(total);
        
        tot=new JTextField();
        
        panel.add(tot);
        
        calcular = new JButton("calcular");
        calcular.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent Arg0){
            socis s=llistaSocis.get(i);
            int a=0;
            if(s.comu==true) a+=10*s.getActivitats();
            else if(s.preferit==true) a+=20-(20*s.getDescomptes()/100);
            String n=String.valueOf(a);
            tot.setText(n);
        }
        });
        panel.add(calcular);
        
        sortir = new JButton("sortir");
        sortir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Arg0){
                frame.dispose();
            }
        });
        panel.add(sortir);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
    JavaApplication2 aplicacio = new JavaApplication2();
    aplicacio.ini();
    }
}
