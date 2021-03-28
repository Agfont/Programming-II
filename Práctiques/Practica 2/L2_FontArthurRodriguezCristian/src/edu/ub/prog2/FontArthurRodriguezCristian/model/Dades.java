/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arthur Font i Cristian Rodriguez
 */
public class Dades {
    private BibliotecaFitxersMultimedia biblio;
    
    public Dades() {
        this.biblio = new BibliotecaFitxersMultimedia();
    }
    public void afegirVideo(String path, String nomVideo, String codec, float durada, 
                            int alcada, int amplada, float fps) throws AplicacioException {
        
        Reproductor r = new Reproductor();
        Video video;
        video = new Video(path, nomVideo, codec, durada, alcada, amplada, fps, r);
        biblio.addFitxer(video);

    }
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
                            String codec, float durada, int kbps) throws AplicacioException {
        File fitxerImatge = new File(camiImatge);
        Reproductor r = new Reproductor();
        Audio audio = new Audio(cami, fitxerImatge, nomAudio, codec, durada, kbps, r);
        biblio.addFitxer(audio);
        
    }
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        String[] temp = biblio.toString().split("-");
        List<String> lista = Arrays.asList(temp);
        return lista;
    }
    public void esborrarFitxer(int id) throws AplicacioException { 
        // id és la posició a llista de getBiblioteca()
        FitxerMultimedia fitxer;
        if (id > 0 && id <= biblio.getSize()) {
            fitxer = biblio.getAt(id-1);
            biblio.removeFitxer(fitxer);
        }
        else {
            throw new AplicacioException("Index no valido");
        }
    
    }
    public void guardarDadesDisc(String camiDesti) throws AplicacioException, FileNotFoundException, IOException, ClassNotFoundException {
        FitxerMultimedia fitxer = new FitxerMultimedia(camiDesti);
        FileOutputStream fout= new FileOutputStream(fitxer);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this.biblio);
        oos.close();
        
    }
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException, FileNotFoundException, IOException, ClassNotFoundException {
        FitxerMultimedia fitxer = new FitxerMultimedia(camiOrigen);
        FileInputStream fin= new FileInputStream(fitxer);
        ObjectInputStream ois = new ObjectInputStream(fin);  
        this.biblio = (BibliotecaFitxersMultimedia)ois.readObject();
        ois.close();
    }
    
    @Override
    public String toString(){
        return null;
    }

}
