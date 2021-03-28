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
            int i = 0;
            boolean trobat = false;
            if (!this.isFull()){
                while (i < this.getSize() && !trobat){
                    if (this.carpeta.get(i).equals(fitxer)){
                        trobat = true;
                        throw new AplicacioException("ErrorException: Fitxer duplicat");
                    }
                    i++;
                }
                if (!trobat){
                    this.carpeta.add(fitxer);  
                }
            }
            else {
                throw new AplicacioException("ErrorException: Carpeta plena");
            }
        }
    }
    
}

