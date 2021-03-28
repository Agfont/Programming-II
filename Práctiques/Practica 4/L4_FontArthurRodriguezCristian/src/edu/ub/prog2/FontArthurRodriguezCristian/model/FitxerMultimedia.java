package edu.ub.prog2.FontArthurRodriguezCristian.model;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
/**
 * @author Arthur Font i Cristian Rodriguez
 * 
 * La classe FitxerMultimedia es una classe heredada de File i maneja les dades dels fitxer.
 * El atributo de FitxerMultimedia es descripcio.
 */
public class FitxerMultimedia extends File implements Serializable{
    /**
     * Descripcio del fitxer
     */
    private String descripcio;
    /**
     * Contructor de FitxerMultimedia
     * @param cami
     * @param desc
     */
    public FitxerMultimedia(String cami, String desc) {
        super(cami);
        this.descripcio = desc;
    }

    /**
     * Constructor
     * @param cami
     */
    public FitxerMultimedia(String cami) {
        super(cami);
        this.descripcio = null;
    }
    /**
     * Retorna la descripcio del fitxer
     * @return String
     */
    public String getDescripcio() {
        return descripcio;
    }
    /**
     * Modifica a descripcio del fitxer
     * @param descripcio 
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    /**
     * Retorna la data de la ultima modificacio del fitxer
     * @return Date
     */
    public Date getUltimaModificacio(){
        long mili = this.lastModified();
        Date data = new Date(mili);
        return data;
    }
    /**
     * Retorna el cami del fitxer
     * @return String
     */
    public String getCamiAbsolut() {
        String cami = this.getAbsolutePath();
        String nom = this.getName();
        String[] lista = cami.split(nom);
        cami = lista[0];
        return cami;
    }
    /**
     * Retorna el nom del fitxer
     * @return String
     */
    public String getNomFitxer() {
        String nom = this.getName();
        String[] l = nom.split("\\.");
        nom = l[0];
        return nom;
    }
    /**
     * Retorna la extensio del fitxer
     * @return String
     */
    public String getExtensio() {
        String ext = this.getName();
        String[] lista = ext.split("\\.");
        ext = lista[1];
        return ext;
    }
    /**
     * Compara dos fitxers i retorna si son iguals o no
     * @param fitxerMultimedia
     * @return boolean
     */
    public boolean equals(FitxerMultimedia fitxerMultimedia) {
        boolean igual = false;
        if (this.getCamiAbsolut().equals(fitxerMultimedia.getCamiAbsolut())&&
                this.getNomFitxer().equals (fitxerMultimedia.getNomFitxer()) &&
                this.getExtensio().equals(fitxerMultimedia.getExtensio()) && 
                this.getDescripcio().equals(fitxerMultimedia.getDescripcio())) {
            igual = true;
        }
        return igual;
    }
    /**
     * Retorna les dades d'un fitxer
     * @return String
     */
    @Override
    public String toString() {
        return ("Descripció: " + this.getDescripcio() +
                ", data: " + this.getUltimaModificacio() +
                "\n   Nom fitxer: " + this.getNomFitxer() +
                ", extensió: " + this.getExtensio() +
                ", camí complet: " + this.getCamiAbsolut());
    }
}