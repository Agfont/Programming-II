/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.controlador;
import edu.ub.prog2.FontArthurRodriguezCristian.model.Audio;
import edu.ub.prog2.FontArthurRodriguezCristian.model.EscoltadorReproduccio;
import edu.ub.prog2.FontArthurRodriguezCristian.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.ReproductorBasic;
import java.io.File;
import java.io.Serializable;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase Reproductor hereda de Reprodutor Basic.
 */
public class Reproductor extends ReproductorBasic implements Serializable{
    /**
     * Constructor de Reproductor
     * @param controlador
     */
    public Reproductor(EscoltadorReproduccio controlador){
        super(controlador);
    }
    
    /**
     * Reproduce un video
     * @param fr
     * @throws AplicacioException
     */
    public void reprodueix(FitxerReproduible fr) throws AplicacioException {
        super.play(fr);
    }

    /**
     * Reproduce un audio
     * @param audio
     * @param fitxerImatge
     * @throws AplicacioException
     */
    public void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException {
        super.play(audio, fitxerImatge);
        
    }
}
