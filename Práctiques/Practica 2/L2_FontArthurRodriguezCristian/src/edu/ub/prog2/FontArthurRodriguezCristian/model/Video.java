/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;
import java.io.Serializable;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase Video hereda de FitxerReproduible.
 * Los atributos de Video son alcada, amplada y fps.
 * Además de los atributos heredados.
 */
public class Video extends FitxerReproduible implements Serializable{
    
    private int alcada;
    private int amplada;
    private float fps;

    /**
     * Constructor de Video
     * @param cami
     * @param nom
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @param r
     */
    public Video(String cami, String nom, String codec, float durada, int alcada,
                int amplada, float fps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.alcada = alcada;
        this.amplada = amplada;
        this.fps = fps;
        
    }
    
    @Override
    protected void reproduir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
