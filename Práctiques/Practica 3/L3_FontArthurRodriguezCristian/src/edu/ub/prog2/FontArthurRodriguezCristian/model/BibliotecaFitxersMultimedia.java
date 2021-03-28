/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;
import edu.ub.prog2.utils.AplicacioException;
import java.io.Serializable;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase BibliotecaFitxersMultimedia hereda de CarpetaFixters
 * y es encargada de contener los archivos multimedias. 
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers implements Serializable{
    
    /**
     * Constructor de BibliotecaFitxersMultimedia
     */
    public BibliotecaFitxersMultimedia() {
        super();
    }
    
    @Override
    public void addFitxer(FitxerMultimedia fitxer) throws AplicacioException {
        if (!fitxer.exists()) {
            throw new AplicacioException("ErrorException: No existeix fitxer al disc");
        }        
        else {
            if (this.carpeta.contains(fitxer)){
                throw new AplicacioException("ErrorException: Fitxer duplicat");
            }
            else {
                this.carpeta.add(fitxer);  
            }
        }
    }
    
}

