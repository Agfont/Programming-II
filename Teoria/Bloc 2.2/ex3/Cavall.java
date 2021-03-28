/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici3.tema2;

/**
 *
 * @author sergiosayago
 */
public class Cavall extends Mamifer{
    private int potes;
    
    public Cavall(String nom){
        super(nom);
        potes = 4;
        setHabitat("Terrestre");
    }
    
    @Override
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Potes: " + potes);
    }
    
}
