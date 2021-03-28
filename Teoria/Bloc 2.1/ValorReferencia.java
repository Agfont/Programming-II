/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valorreferencia;

/**
 *
 * @author Sergio
 */
public class ValorReferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // per valor = copia
        int valor = 5;
        System.out.println("Abans metode: " + valor);
        copiaValor(valor);
        System.out.println("Despres metode: " + valor);
        // per referencia = direccions / punters;
        Estudiant Sergio = new Estudiant("Sergio");
        System.out.println("Abans metode: " + Sergio.getNom());
        perReferencia(Sergio);
        System.out.println("Despres metode: " + Sergio.getNom());
    }
    
    public static void copiaValor (int a){
        a = 2;
        System.out.println("Dins del metode: " + a); 
    }
    
    public static void perReferencia (Estudiant e){
       e.setNom("Laura");
       System.out.println("Dins metode: " + e.getNom());
    }
}
class Estudiant{
    private String nom;
    Estudiant(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }    
    public void setNom(String n){
        nom = n;
    }
}