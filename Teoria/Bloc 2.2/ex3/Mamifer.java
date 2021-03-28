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
public abstract class Mamifer {
    private String nom;
    private String habitat;
    
    public Mamifer(String nom){
        this.nom = nom;
        habitat = "Desconegut";
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getHabitat(){
        return habitat;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setHabitat(String hab){
        habitat = hab;
    }
    
    public void imprimirInfo(){
        System.out.println("Nom: " + nom + " Habitat: " + habitat);
    }    
}
