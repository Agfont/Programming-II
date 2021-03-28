/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;


public class socis {
    String Dni, nom;
    boolean comu=false, preferit=false;
    int activitats, descomptes;
    
    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isComu() {
        return comu;
    }

    public void setComu(boolean comu) {
        this.comu = comu;
    }

    public boolean isPreferit() {
        return preferit;
    }

    public void setPreferit(boolean preferit) {
        this.preferit = preferit;
    }

    public int getActivitats() {
        return activitats;
    }

    public void setActivitats(int activitats) {
        this.activitats = activitats;
    }

    public int getDescomptes() {
        return descomptes;
    }

    public void setDescomptes(int descomptes) {
        this.descomptes = descomptes;
    }
}
