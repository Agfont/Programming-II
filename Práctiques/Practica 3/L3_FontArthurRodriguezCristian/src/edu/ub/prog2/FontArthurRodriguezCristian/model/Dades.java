/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;

import edu.ub.prog2.FontArthurRodriguezCristian.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Guarda los datos de nuestra aplicacion
 * @author Arthur Font i Cristian Rodriguez
 */
public class Dades implements Serializable {
    private BibliotecaFitxersMultimedia biblio;
    private ArrayList <AlbumFitxersMultimedia> listaAlbum;
    private transient Reproductor r;

    /**
     * Constructor
     */
    public Dades() {
        this.biblio = new BibliotecaFitxersMultimedia();
        this.listaAlbum = new ArrayList<>();
    }
    
    /**
     * Añade un video
     * @param path
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @param r
     * @throws AplicacioException
     */
    public void afegirVideo(String path, String nomVideo, String codec, float durada, 
                            int alcada, int amplada, float fps, Reproductor r) throws AplicacioException {
        
        Video video;
        video = new Video(path, nomVideo, codec, durada, alcada, amplada, fps, r);
        biblio.addFitxer(video);

    }
    
    /**
     * Añade un audio
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @param r
     * @throws AplicacioException
     */
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
                            String codec, float durada, int kbps, Reproductor r) throws AplicacioException {
        
        File fitxerImatge = new File(camiImatge);
        Audio audio = new Audio(cami, fitxerImatge, nomAudio, codec, durada, kbps, r);
        biblio.addFitxer(audio);
        
    }
    
    /**
     * Muestra la biblioteca
     * @return List
     */
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        String[] temp = biblio.toString().split("-");
        List<String> lista = Arrays.asList(temp);
        return lista;
    }
    
    /**
     * Borra un fichero
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxer(int id) throws AplicacioException { 
        // id és la posició a llista de getBiblioteca()
        if (id >= 0 && id < biblio.getSize()) {
            FitxerMultimedia fitxer;
            fitxer = biblio.getAt(id);
            for (int i = 0; i < this.listaAlbum.size(); i++) {
                this.listaAlbum.get(i).removeAllFitxer(fitxer);
            }
            biblio.removeFitxer(fitxer);
        }
        else {
            throw new AplicacioException("Index no valido");
        }
    
    }
    
    /**
     * Guarda los datos en el disco
     * @param camiDesti
     * @throws AplicacioException
     */
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        FitxerMultimedia fitxer = new FitxerMultimedia(camiDesti);
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(fitxer);
        } catch (FileNotFoundException ex) {
            throw new AplicacioException("File Not Found");
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException ex) {
                throw new AplicacioException("IO Exception");
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                throw new AplicacioException("IO Exception");
            }
        }
                
    }
    
    /**
     * Carga los datos del disco
     * @param camiOrigen
     * @return
     * @throws AplicacioException
     */
    public static Dades carregarDadesDisc(String camiOrigen) throws AplicacioException{
        FitxerMultimedia fitxer = new FitxerMultimedia(camiOrigen);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fitxer);
        } catch (FileNotFoundException ex) {
            throw new AplicacioException("File Not Found");
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fin);
            try {
                Dades d = (Dades)ois.readObject();
                return d;
            } catch (ClassNotFoundException ex) {
                throw new AplicacioException("Class Not Found");
            }
        } catch (IOException ex) {
            throw new AplicacioException("IO Exception");
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                throw new AplicacioException("IO Exception");
            }
        }
    }
    
    /**
     * Mira si existe un album
     * @param titolAlbum
     * @return boolean
     */
    public boolean existeixAlbum(String titolAlbum) {
        Iterator<AlbumFitxersMultimedia> it = listaAlbum.iterator();
        while (it.hasNext()) {
            if (it.next().getTitol().equals(titolAlbum)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Mira si la lista de albums esta vacio
     * @return boolean
     */
    public boolean emptyListaAlbums() {
        return this.listaAlbum.isEmpty();
    }

      
    /**
     * Añade un album
     * @param titolAlbum
     * @throws AplicacioException
     */
    public void afegirAlbum(String titolAlbum) throws AplicacioException{
        if (existeixAlbum(titolAlbum)) {
            throw new AplicacioException("Album ja existent");
        }else {
            AlbumFitxersMultimedia album = new AlbumFitxersMultimedia(titolAlbum);
            this.listaAlbum.add(album);
        }    
    }
    
    /**
     * Borra un album
     * @param titolAlbum
     * @throws AplicacioException
     */
    public void esborrarAlbum(String titolAlbum) throws AplicacioException {
        if (existeixAlbum(titolAlbum)) {
            this.listaAlbum.remove(getIndexAlbum(titolAlbum));
        } else {
            throw new AplicacioException("Album no existent");
        }
    }
    
    /**
     * Muestra la lista de albums
     * @return List
     */
    public List<String> mostrarLlistatAlbums() {
        String mensaje;
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < this.listaAlbum.size(); i++){
            mensaje = "[" + (i+1) + "] " + this.listaAlbum.get(i).getTitol();
            lista.add(mensaje);
        }
        return lista;
    }
    
    /**
     * Devuelve el int del index de un album
     * @param titolAlbum
     * @return int
     * @throws AplicacioException
     */
    public int getIndexAlbum (String titolAlbum) throws AplicacioException {
        int j = -1;
        for (int i = 0; i < listaAlbum.size(); i++) {
            if (listaAlbum.get(i).getTitol().equals(titolAlbum)) {
                j = i;
            }
        }
        if (j == -1) {
            throw new AplicacioException("Album no existent");
        }
        else {
            return j;
        }
    }

    /**
     * Añade un fichero a un album
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    public void afegirFitxer (String titolAlbum, int id) throws AplicacioException {
        if (id < biblio.getSize()) {
            this.getAlbum(titolAlbum).addFitxer(this.biblio.getAt(id));
        }
        else {
            throw new AplicacioException("No existeix el fitxer");
        }
    }
    
    /**
     * Muestra un album
     * @param titolAlbum
     * @return List
     * @throws AplicacioException
     */
    public List<String> mostrarAlbum(String titolAlbum) throws AplicacioException {
        String mensaje;
        List<String> lista = new ArrayList<>();
        mensaje = this.getAlbum(titolAlbum).toString();
        lista.add(mensaje);
        return lista;
    }
    
    /**
     * Borra un fichero de un album
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxer(String titolAlbum, int id) throws AplicacioException { 
        if (id >= 0 && id < this.getAlbum(titolAlbum).getSize()) {
            FitxerMultimedia fitxer;
            fitxer = this.getAlbum(titolAlbum).getAt(id);
            this.getAlbum(titolAlbum).removeFitxer(fitxer);
        }
        else {
            throw new AplicacioException("Index no valido");
        }
    }
    
    /**
     * Devuelve un fichero
     * @param id
     * @return FitxerMultimedia
     * @throws AplicacioException
     */
    public FitxerMultimedia getFitxerBiblioteca (int id) throws AplicacioException {
        if (id >= 0 && id < this.biblio.getSize()) {
            return this.biblio.getAt(id);
        }
        else {
            throw new AplicacioException("Index no valido\n");
        }

    }

    /**
     * Devuelve la biblioteca
     * @return BibliotecaFitxersMultimedia
     */
    public BibliotecaFitxersMultimedia getBiblio() {
        return biblio;
    }
    
    /**
     * Devuelve un album
     * @param titolAlbum
     * @return AlbumFitxersMultimedia
     * @throws AplicacioException
     */
    public AlbumFitxersMultimedia getAlbum (String titolAlbum) throws AplicacioException {
        return this.listaAlbum.get(this.getIndexAlbum(titolAlbum));
    }
    
    /**
     * Recibe el reproductor
     * @param r
     */
    public void setReproductor (Reproductor r) {
        this.r = r;
    }
}