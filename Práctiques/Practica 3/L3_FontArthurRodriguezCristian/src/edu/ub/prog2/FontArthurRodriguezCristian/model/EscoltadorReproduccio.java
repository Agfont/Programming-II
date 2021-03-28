/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;

import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Arthur Font i Cristian Rodriguez
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic implements Serializable {
    
    private CarpetaFitxers llistaReproduint;
    private boolean [] llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria; // transient (?)
    private int id;

    /**
     * Constructor
     */
    public EscoltadorReproduccio() {
        this.llistaReproduint = null;
        this.llistaCtrl = null;
        this.reproduccioCiclica = false;
        this.reproduccioAleatoria = false;
        this.id = 0;
    }
    
    /**
     * Set del modo ciclico
     * @param reproduccioCiclica
     */
    public void setReproduccioCiclica(boolean reproduccioCiclica) {
        this.reproduccioCiclica = reproduccioCiclica;
    }

    /**
     * Set del modo aleatorio
     * @param reproduccioAleatoria
     */
    public void setReproduccioAleatoria(boolean reproduccioAleatoria) {
        this.reproduccioAleatoria = reproduccioAleatoria;
    }

    /**
     * Mira si el modo ciclico esta activado
     * @return boolean
     */
    public boolean isReproduccioCiclica() {
        return reproduccioCiclica;
    }

    /**
     * Mira si el modo aletorio esta activado
     * @return boolean
     */
    public boolean isReproduccioAleatoria() {
        return reproduccioAleatoria;
    }
    
    /**
     * Inicia la reproduccion
     * @param llistaReproduint
     * @param reproduccioCiclica
     * @throws AplicacioException
     */
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica) throws AplicacioException {
        this.llistaReproduint = llistaReproduint;
        this.llistaCtrl = new boolean [llistaReproduint.getSize()];
        Arrays.fill(llistaCtrl, Boolean.FALSE);
        this.reproduccioCiclica = reproduccioCiclica;
        this.id = 0;
        FitxerMultimedia f;
        f = llistaReproduint.getAt(id);
        ((FitxerReproduible) f).reproduir();
        llistaCtrl[id] = true;
    }
    
    /**
     * Cuando acaba de reproducir un fichero se llama automaticamente
     */
    @Override
    public void onEndFile() {
        FitxerMultimedia f;
        if (this.hasNext()) {
            this.next();
            f = llistaReproduint.getAt(id);
            try {
                ((FitxerReproduible) f).reproduir();
                llistaCtrl[id] = true;
            } catch (AplicacioException ex){}
        }
    }

    /**
     * Pasa al siguiente fichero
     */
    @Override
    protected void next() {
        if (this.isReproduccioAleatoria()) {  //aleatorio
            id = (int) Math.round(Math.random()*(llistaReproduint.getSize()-1));
            boolean trobatFalse = false; int i = 0;
            while (i < llistaCtrl.length && !trobatFalse) {
                trobatFalse = !llistaCtrl[i];
                i++;
            }
            if (!trobatFalse) {
                Arrays.fill(llistaCtrl, Boolean.FALSE);
            }
            while (llistaCtrl[id]) { //se ha reproducido?
                id++;
                if (id == llistaReproduint.getSize()) {
                    id = 0;
                }  //aqui es aleatorio y no se ha reproducido
            }
        }
        else {
            if (id+1 == llistaReproduint.getSize()) {
                id = 0;
            }
            else id++;
        }
    }
    
    /**
     * Mira si hay siguiente
     * @return boolean
     */
    @Override
    protected boolean hasNext() {
        if (this.isReproduccioCiclica()){
            return true;
        }else {
            int i = 0;
            boolean reproduit = true;
            while (i < llistaCtrl.length && reproduit) {
                reproduit = llistaCtrl[i];
                i++;
            }
            return !reproduit;
        }
    }
}
