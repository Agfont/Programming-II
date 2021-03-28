package edu.ub.prog2.FontArthurRodriguezCristian.model;

import java.util.ArrayList;

/**
 * @author Arthur Font i Cristian Rodriguez
 * 
 * La classe CarpetaFitxers guarda els fitxers.
 * Els atributs de CarpetaFitxers son carpeta i MAXIM_FITXER.
 */

public class CarpetaFitxers {
    /**
     * Array on guardem els fitxers
     */
    public ArrayList<FitxerMultimedia> carpeta;
    /**
     * Nombre maxim de fitxers que accepta la carpeta
     */
    private final int MAXIM_FITXER = 100;
    
    /**
     * Contructor de CarpetaFitxers
     */
    public CarpetaFitxers(){
        this.carpeta = new ArrayList(MAXIM_FITXER);
    }
    /**
     * Retorna el tamany de la carpeta
     * @return int
     */
    public int getSize(){
        return this.carpeta.size();
    }
    /**
     * Afegeix un fitxer a la carpeta
     * @param fitxer 
     */
    public void addFitxer(FitxerMultimedia fitxer){
        if(!this.isFull()) {
           this.carpeta.add(fitxer);
        }
        else {
            System.out.println("Carpeta plena\n");
        }
    }
    /**
     * Esborra un fitxer de la carpeta
     * @param fitxer 
     */
    public void removeFitxer(FitxerMultimedia fitxer){
        int i = 0;
        boolean trobat = false;
        if (!this.isFull()){
            while (i < this.getSize() && !trobat){
                if (this.carpeta.get(i).equals(fitxer)){
                    this.carpeta.remove(i);
                    trobat = true;
                    System.out.println("Fitxer esborrat\n");
                }
                i++;
            }
            if (!trobat){
                    System.out.println("Aquest fitxer no existeix\n");
            }
        }
        else {
            System.out.println("Carpeta vacia\n");
        }
    }
    /**
     * Retorna el FitxerMultimedia de la posicio indicada
     * @param position
     * @return FitxerMultimedia
     */
    public FitxerMultimedia getAt(int position) {
        if (this.getSize() > position){
            return this.carpeta.get(position);
        }
        else {
            System.out.println("No existeix\n");
            FitxerMultimedia file = new FitxerMultimedia("noExisteix.txt");
            return file;
        }
    }
    /**
     * Esborra tots els fitxers de la carpeta
     */
    public void clear() {
        this.carpeta.clear();
    }
    /**
     * Verifica si la carpeta esta plena o no
     * @return boolean
     */
    public boolean isFull() {
        if (this.getSize() == MAXIM_FITXER) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Retorna totes les dades de tots els fitxers de la carpeta
     * @return String
     */
    public String toString() {
        String mensaje;
        if (this.getSize() == 0){
            mensaje = "\nNo hi ha cap fitxer guardat";
        }
        else {
            mensaje = "\nCarpeta Fitxers:\n" +
                    "==============";
            for (int i = 0; i < this.getSize(); i++){
                mensaje += "\n\n[" + (i+1) + "] " + this.getAt(i).toString();
            }
        }
        mensaje += "\n";
        return mensaje;
    }
    
}
