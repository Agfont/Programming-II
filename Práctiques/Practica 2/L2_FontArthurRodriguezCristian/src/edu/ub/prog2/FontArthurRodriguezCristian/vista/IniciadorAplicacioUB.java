package edu.ub.prog2.FontArthurRodriguezCristian.vista;
import edu.ub.prog2.utils.AplicacioException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase IniciadorAplicacioUB es el main.
 */
public class IniciadorAplicacioUB {

    /**
     * Inicia la aplicación
     * @param args 
     * @throws edu.ub.prog2.utils.AplicacioException 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public static void main(String[] args) throws AplicacioException, IOException, FileNotFoundException, ClassNotFoundException {
        
        AplicacioUB2 aplicacio;
        aplicacio = new AplicacioUB2();     
        aplicacio.gestioAplicacioUB();
    }
}
