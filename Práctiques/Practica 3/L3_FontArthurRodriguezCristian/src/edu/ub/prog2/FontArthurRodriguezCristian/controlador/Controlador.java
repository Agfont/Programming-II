/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.controlador;

import edu.ub.prog2.FontArthurRodriguezCristian.model.CarpetaFitxers;
import edu.ub.prog2.FontArthurRodriguezCristian.model.Dades;
import edu.ub.prog2.FontArthurRodriguezCristian.model.EscoltadorReproduccio;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.InControlador;
import java.util.List;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase Controlador es encarregada de hacer la conexión
 * entre el model y la vista.
 * El atributo de la clase Controlador es dada.
 */
public class Controlador implements InControlador {
    
    private Dades dada;
    private final transient Reproductor r;
    private EscoltadorReproduccio escoltador;
    
    /**
     * Constructor de Controlador
     */
    public Controlador(){
        this.escoltador = new EscoltadorReproduccio();
        this.r = new Reproductor(this.escoltador);
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
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, float durada, 
                            int alcada, int amplada, float fps) throws AplicacioException {
        dada.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps, r);
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
    
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
                            String codec, float durada, int kbps) throws AplicacioException {
        dada.afegirAudio(cami, camiImatge, nomAudio, codec, durada, kbps, r);
    }

    /**
     * Llama al metode mostrarBiblioteca() de la clase Dades
     * y retorna una lista con la información de la blblioteca.
     * @return List
     */
    @Override
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        return dada.mostrarBiblioteca();
    }

    /**
     * Llama al metode esborrarFitxer() de la clase Dades.
     * @param id
     * @throws AplicacioException
     */
    
    @Override
    public void esborrarFitxer(int id) throws AplicacioException { 
        dada.esborrarFitxer(id);
    }

    /**
     * Llama al metode guardarDadesDisc() de la clase Dades.
     * @param camiDesti
     * @throws AplicacioException
     */
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        dada.guardarDadesDisc(camiDesti);
    }

    /**
     * Llama al metode carregarDadesDisc() de la clase Dades.
     * @param camiOrigen
     * @throws AplicacioException
     */
    
    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException{
        this.dada = Dades.carregarDadesDisc(camiOrigen);
    }
    
    /**
     * Mira si existeix un album
     * @param titolAlbum
     * @return boolean
     */
    @Override
    public boolean existeixAlbum(String titolAlbum) {
        return this.dada.existeixAlbum(titolAlbum);
    }
    
    /**
     * Mira si la listaAlbums esta vacia
     * @return boolean
     */
    public boolean emptyListaAlbums() {
        return this.dada.emptyListaAlbums();
    }
    
    /**
     * Añade un album a la lista
     * @param titolAlbum
     * @throws AplicacioException
     */
    @Override
    public void afegirAlbum(String titolAlbum) throws AplicacioException {
        this.dada.afegirAlbum(titolAlbum); 
        
    }
    
    /**
     * Borra un album
     * @param titolAlbum
     * @throws AplicacioException
     */
    @Override
    public void esborrarAlbum(String titolAlbum) throws AplicacioException {
        this.dada.esborrarAlbum(titolAlbum);
    }

    /**
     * Muestra la lista de albums
     * @return List
     */
    @Override
    public List<String> mostrarLlistatAlbums() {
        return this.dada.mostrarLlistatAlbums();
    }

    /**
     * Añade un fichero a un album
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void afegirFitxer(String titolAlbum, int id) throws AplicacioException {
        this.dada.afegirFitxer(titolAlbum, id);
    }
    
    /**
     * Muestra el contenido del album
     * @param titolAlbum
     * @return List
     * @throws AplicacioException
     */
    @Override
    public List<String> mostrarAlbum(String titolAlbum) throws AplicacioException {
        return this.dada.mostrarAlbum(titolAlbum);
    }
    
    /**
     * Borra un fichero de un album
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void esborrarFitxer(String titolAlbum, int id) throws AplicacioException {
        this.dada.esborrarFitxer(titolAlbum,id);
    }
    
    /**
     * Reproduce un fichero
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void reproduirFitxer(int id) throws AplicacioException {
        CarpetaFitxers cp = new CarpetaFitxers(1);
        cp.addFitxer(this.dada.getFitxerBiblioteca(id));
        this.escoltador.iniciarReproduccio(cp, escoltador.isReproduccioCiclica());
    }
    
    /**
     * Reproduce la biblioteca
     * @throws AplicacioException
     */
    @Override
    public void reproduirCarpeta() throws AplicacioException {
        this.escoltador.iniciarReproduccio(this.dada.getBiblio(), this.escoltador.isReproduccioCiclica());
    }
    
    /**
     * Reproduce un album
     * @param titolAlbum
     * @throws AplicacioException
     */
    @Override
    public void reproduirCarpeta(String titolAlbum) throws AplicacioException {
        this.escoltador.iniciarReproduccio(this.dada.getAlbum(titolAlbum), this.escoltador.isReproduccioCiclica());
    }
    
    /**
     * Abre el reproductor
     */
    @Override
    public void obrirFinestraReproductor() {
       this.r.open();
    }

    /**
     * Cierra el reproductor
     * @throws AplicacioException
     */
    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        this.r.close();
    }
    
    /**
     * Play
     * @throws AplicacioException
     */
    @Override
    public void reemprenReproduccio() throws AplicacioException {
        this.r.resume();
    }

    /**
     * Pausa
     * @throws AplicacioException
     */
    @Override
    public void pausaReproduccio() throws AplicacioException {
        this.r.pause();
    }

    /**
     * Stop
     * @throws AplicacioException
     */
    @Override
    public void aturaReproduccio() throws AplicacioException {
        this.r.stop();
    }

    /**
     * Salta
     * @throws AplicacioException
     */
    @Override
    public void saltaReproduccio() throws AplicacioException {
        this.escoltador.onEndFile();
    }
    
    /**
     * Cambia el modo aleatorio
     */
    public void setAleatori () {
        if (this.escoltador.isReproduccioAleatoria()){
            this.escoltador.setReproduccioAleatoria(false);
        }else{
            this.escoltador.setReproduccioAleatoria(true);
        }
    }
    
    /**
     * Cambia el modo ciclico
     */
    public void setCiclica () {
        if (this.escoltador.isReproduccioCiclica()){
            this.escoltador.setReproduccioCiclica(false);
        }else{
            this.escoltador.setReproduccioCiclica(true);
        }
    }
    
    /**
     * Le pasa a dades el reproductor
     */
    public void setReprodutor() {
        this.dada.setReproductor(r);
    }
}
