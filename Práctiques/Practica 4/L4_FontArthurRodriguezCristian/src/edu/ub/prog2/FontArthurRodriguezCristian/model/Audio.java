/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;
import edu.ub.prog2.FontArthurRodriguezCristian.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.Serializable;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase Audio hereda de la clase FitxerReproduible.
 * Los atributos de Audio son fixterImatge y kbps.
 * Además de los atributos heredados.
 */
public class Audio extends FitxerReproduible implements Serializable{
    
    private File fitxerImatge;
    private int kbps;
    
    /**
     * Constructor de Audio
     * @param cami
     * @param fitxerImatge
     * @param nom
     * @param codec
     * @param durada
     * @param kbps
     * @param r
     */
    public Audio(String cami, File fitxerImatge, String nom, String codec, float durada, 
                int kbps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.fitxerImatge = fitxerImatge;
        this.kbps = kbps;
    }

    @Override
    public void reproduir() throws AplicacioException {
       this.r.reprodueix(this, this.fitxerImatge);
    }        

    @Override
    public void setReproductor(Reproductor r) throws AplicacioException {
        this.r = r;
    }
}
