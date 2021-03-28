/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici1.tema2;

/**
 *
 * @author sergiosayago
 */
public class Quadrat extends Figura {
    public Quadrat(){
        System.out.println("Quadrat creat");        
    }
    public void mostraInfo(){
        System.out.println("Color: " + this.getColor() + "\n");
    }
}
