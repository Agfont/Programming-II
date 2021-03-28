/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;

import edu.ub.prog2.FontArthurRodriguezCristian.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.Serializable;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase FitxerReproduible es abstracta y hereda de FitxerMultimedia.
 * Los atributos de FitxerReproduible son codec, durada y r;
 */
public abstract class FitxerReproduible extends FitxerMultimedia implements Serializable{
    
    private String codec;
    private float durada;
    protected Reproductor r;
    
    /**
     * Constructor de FitxerReproduible
     * @param cami
     * @param nom
     * @param codec
     * @param durada
     * @param r
     */
    protected FitxerReproduible(String cami, String nom, String codec, float durada, Reproductor r) {
        super(cami, nom);
        this.codec = codec;
        this.durada = durada;
        this.r = r;
    }

    /**
     * Method abstract reproduir() is not defined yet.
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    protected abstract void reproduir() throws AplicacioException;
}
