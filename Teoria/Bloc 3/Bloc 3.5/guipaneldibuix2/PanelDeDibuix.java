/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipaneldibuix2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author sergiosayago
 */
public class PanelDeDibuix extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        //g.setColor(Color.yellow);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random()*255);
        int blue = (int) (Math.random()*255);
        int green = (int) (Math.random()*255);
        
        Color randomColor = new Color(red, blue, green);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);
    }
}
