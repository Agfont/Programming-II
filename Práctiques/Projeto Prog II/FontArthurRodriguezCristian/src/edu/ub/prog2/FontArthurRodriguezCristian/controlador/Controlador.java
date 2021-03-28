/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.controlador;

import edu.ub.prog2.FontArthurRodriguezCristian.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase Controlador es encarregada de hacer la conexión
 * entre el model y la vista.
 * El atributo de la clase Controlador es dada.
 */
public class Controlador {
    
    private Dades dada;
    
    /**
     * Constructor de Controlador
     */
    public Controlador(){
        this.dada = new Dades();
    }

    /**
     * Llama al metode afegirVideo() de la clase Dades.
     * @param path
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException
     */
    public void afegirVideo(String path, String nomVideo, String codec, float durada, 
                            int alcada, int amplada, float fps) throws AplicacioException {
        dada.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }

    /**
     * Llama al metode afegirAudio() de la clase Dades.
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
                            String codec, float durada, int kbps) throws AplicacioException {
        dada.afegirAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
    }

    /**
     * Llama al metode mostrarBiblioteca() de la clase Dades
     * y retorna una lista con la información de la blblioteca.
     * @return List
     */
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        return dada.mostrarBiblioteca();
    }

    /**
     * Llama al metode esborrarFitxer() de la clase Dades.
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxer(int id) throws AplicacioException { 
        dada.esborrarFitxer(id);
    }

    /**
     * Llama al metode guardarDadesDisc() de la clase Dades.
     * @param camiDesti
     * @throws AplicacioException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void guardarDadesDisc(String camiDesti) throws AplicacioException, IOException, FileNotFoundException, ClassNotFoundException {
        dada.guardarDadesDisc(camiDesti);
    }

    /**
     * Llama al metode carregarDadesDisc() de la clase Dades.
     * @param camiOrigen
     * @throws AplicacioException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException, IOException, FileNotFoundException, ClassNotFoundException {
        dada.carregarDadesDisc(camiOrigen);
    }
}
