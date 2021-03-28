/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Es un album de ficheros
 * @author Arthur Font i Cristian Rodriguez
 */
public class AlbumFitxersMultimedia extends CarpetaFitxers implements Serializable{    
    private ArrayList<FitxerMultimedia> album;
    private final int MAX_SIZE;
    private String titol;
    
    /**
     * Constructor
     * @param titol
     */
    public AlbumFitxersMultimedia(String titol){
        super();
        this.MAX_SIZE = 10;
        this.album = super.carpeta;
        this.titol = titol;
            
    }

    /**
     * Constructor
     * @param titol
     * @param size
     */
    public AlbumFitxersMultimedia(String titol, int size) {
        super();
        this.MAX_SIZE = size;
        this.album = super.carpeta;
        this.titol = titol;
    }
    
    /**
     * Devuelve el titulo
     * @return String
     */
    public String getTitol() {
        return this.titol;
    }
    
    @Override
    public FitxerMultimedia getAt(int position) {
        return this.album.get(position);
    }
    
    @Override
    public void addFitxer(FitxerMultimedia fitxer) throws AplicacioException {
        if(this.album.size() < MAX_SIZE) {
           this.album.add(fitxer);
        }
        else {
            throw new AplicacioException("ErrorException: Album ple");
        }
    }
    
    @Override
    public void removeFitxer(FitxerMultimedia fitxer) throws AplicacioException {
        int i = 0;
        boolean trobat = false;
        if (!this.album.isEmpty()){
            while (i < this.album.size() && !trobat){
                if (this.album.get(i).equals(fitxer)){
                    this.album.remove(i);
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
            throw new AplicacioException("Album vacio\n");
        }
    }
    
    public void removeAllFitxer(FitxerMultimedia fitxer) throws AplicacioException {
        if (!this.album.isEmpty()){
            while (this.album.contains(fitxer)) {
                this.album.remove(fitxer);
            }
        }
        else {
            throw new AplicacioException("Album vacio\n");
        }
    }
    
    @Override
    public String toString(){
        String mensaje;
        if (this.album.isEmpty()){
            mensaje = ""; // Vacio
        }
        else {
            mensaje = "";
            for (int i = 0; i < this.album.size(); i++){
                mensaje += "[" + (i+1) + "] " + "Titol de l'àlbum " + this.titol
                        + " " + this.album.get(i).toString() + "\n";
            }
        }
        return mensaje;
    }
}
    