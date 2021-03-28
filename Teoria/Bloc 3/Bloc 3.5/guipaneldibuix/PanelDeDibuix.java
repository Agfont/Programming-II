/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipaneldibuix;

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
        g.setColor(Color.yellow);
        g.fillRect(20, 50, 100, 100);
    }
}
