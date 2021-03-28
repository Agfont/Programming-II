package edu.ub.prog2.FontArthurRodriguezCristian.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Arthur Font i Cristian Rodriguez
 * 
 * La classe CarpetaFitxers guarda els fitxers.
 * Els atributs de CarpetaFitxers son carpeta i MAXIM_FITXER.
 */

public class CarpetaFitxers implements Serializable{
    /**
     * Array on guardem els fitxers
     */
    protected ArrayList<FitxerMultimedia> carpeta;
    /**
     * Nombre maxim de fitxers que accepta la carpeta
     */
    protected final int MAXIM_FITXER = 100;
    
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
     * @throws edu.ub.prog2.utils.AplicacioException 
     */
    public void addFitxer(FitxerMultimedia fitxer) throws AplicacioException {
        if(!this.isFull()) {
           this.carpeta.add(fitxer);
        }
        else {
            throw new AplicacioException("ErrorException: Carpeta plena");
        }
    }
    /**
     * Esborra un fitxer de la carpeta
     * @param fitxer 
     * @throws edu.ub.prog2.utils.AplicacioException 
     */
    public void removeFitxer(FitxerMultimedia fitxer) throws AplicacioException {
        int i = 0;
        boolean trobat = false;
        if (!this.isFull()){
            while (i < this.getSize() && !trobat){
                if (this.carpeta.get(i).equals(fitxer)){
                    this.carpeta.remove(i);
                    trobat = true;
                    throw new AplicacioException("Fitxer esborrat\n");
                }
                i++;
            }
            if (!trobat){
                    throw new AplicacioException("Aquest fitxer no existeix\n");
            }
        }
        else {
            throw new AplicacioException("Carpeta vacia\n");
        }
    }
    /**
     * Retorna el FitxerMultimedia de la posicio indicada
     * @param position
     * @return FitxerMultimedia
     */
    public FitxerMultimedia getAt(int position) {
        return this.carpeta.get(position);
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
        return (this.getSize() == MAXIM_FITXER);
    }
    /**
     * Retorna totes les dades de tots els fitxers de la carpeta
     * @return String
     */
    @Override
    public String toString(){
        String mensaje;
        if (this.getSize() == 0){
            mensaje = ""; // Vacio
        }
        else {
            mensaje = "";
            for (int i = 0; i < this.getSize(); i++){
                mensaje += "[" + (i+1) + "] " + this.getAt(i).toString() + "\n";
            }
        }
        return mensaje;
    }
    
}
