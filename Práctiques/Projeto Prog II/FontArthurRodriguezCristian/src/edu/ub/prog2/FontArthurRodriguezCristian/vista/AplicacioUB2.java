/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.vista;

import edu.ub.prog2.FontArthurRodriguezCristian.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase AplicacioUB2 es la interface externa de nuestro progama.
 * Es responsable por enseñar las opciones del menu, llamar los métodos 
 * del Controlador y agafar las excepciones.
 * 
 */
public class AplicacioUB2 {
    /**
     * Opcions de los menus
     */
    static private enum OpcionsMenuPrincipal {GESTIO,GUARDAR,RECUPERAR,SORTIR};
    static private enum OpcionsMenuSecundari {AFEGIR,MOSTRAR,ELIMINAR,VOLVER};
    static private enum OpcionsMenuTerciari {VIDEO,AUDIO,VOLVER};
    /**
     * Funcions de los menus
     */
    static private String[] descMenuPrincipal= {"Gestió Biblioteca",
                                                "Guardar Dades", 
                                                "Recuperar Dades", 
                                                "Sortir"};           
    static private String[] descMenuSecundari= {"Afegir fitxer multimèdia a la biblioteca",
                                                "Mostrar Biblioteca", 
                                                "Eliminar fitxer multimèdia",  
                                                "Menú Anterior"}; 
    static private String[] descMenuTerciari= {"Afegir vídeo.",
                                               "Afegir àudio",
                                               "Menú Anterior"};
    private Controlador control;
    
    /**
     * Constructor de AplicacioUB2
     */
    public AplicacioUB2() {
        control = new Controlador();
    }
    
    /**
     * Es el menu de nuestra aplicación
     */
    public void gestioAplicacioUB() throws AplicacioException, IOException, FileNotFoundException, ClassNotFoundException {
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal",OpcionsMenuPrincipal.values());
        Menu<OpcionsMenuSecundari> menuSec = new Menu<OpcionsMenuSecundari>("Menu Secundari",OpcionsMenuSecundari.values());
        Menu<OpcionsMenuTerciari> menuTerci = new Menu<OpcionsMenuTerciari>("Menu Terciari",OpcionsMenuTerciari.values());
        menu.setDescripcions(descMenuPrincipal);
        menuSec.setDescripcions(descMenuSecundari);
        menuTerci.setDescripcions(descMenuTerciari);
        
        Scanner sc = new Scanner (System.in);
        
        OpcionsMenuPrincipal opcio = null;
        OpcionsMenuSecundari opcio2 = null;
        OpcionsMenuTerciari opcio3 = null;
        
        try {
            control.afegirAudio("/home/arthurfont/Downloads/aud.mp3", "aaa", "aud.mp3", "codec", 11, 11);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        try {
            control.afegirVideo("/home/arthurfont/Downloads/vid.mp4", "vid.mp4", "doced", 11, 11, 11, 11);       
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        try {
            control.afegirVideo("/home/arthurfont/Downloads/ala.mp4", "ala.mp4", "doced", 11, 11, 11, 11);       
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        System.out.println("Carpeta Fitxers:\n==============\n" + control.mostrarBiblioteca());
        try {
            control.afegirVideo("/home/arthurfont/Downloads/ala.mp4", "ala.mp4", "doced", 11, 11, 11, 11);       
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        System.out.println("Carpeta Fitxers:\n==============\n" + control.mostrarBiblioteca());
        try {
            control.afegirVideo("/home/arthurfont/Downloads/sf.mp4", "sf.mp4", "doced", 11, 11, 11, 11);       
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        System.out.println("Carpeta Fitxers:\n==============\n" + control.mostrarBiblioteca());
        try {
            control.guardarDadesDisc("/home/arthurfont/Music/copia.dat");
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        try {
            control.esborrarFitxer(2);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        
        System.out.println("Carpeta Fitxers:\n==============\n" + control.mostrarBiblioteca()); 
        try {
            control.carregarDadesDisc("/home/arthurfont/Music/copia.dat");
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        System.out.println("Carpeta Fitxers:\n==============\n" + control.mostrarBiblioteca());


        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);            
            switch(opcio) {
                
                case GESTIO: // Gestio Biblio
                    
                    do {
                        menuSec.mostrarMenu();
                        opcio2 = menuSec.getOpcio(sc);
                        switch(opcio2){
                            case AFEGIR: // Afegir fitxer multimedia
                                do {
                                    menuTerci.mostrarMenu();
                                    opcio3 = menuTerci.getOpcio(sc);
                                    switch(opcio3) {
                                        case VIDEO :  // Video
                                            this.menuAfegirVideo();
                                            break;
                                        case AUDIO: // Audio
                                            this.menuAfegirAudio(); 
                                            break;
                                        case VOLVER:
                                            break;
                                    }
                                    
                                } while (opcio3!= OpcionsMenuTerciari.VOLVER);
                                break;
                                
                            case MOSTRAR: // Mostrar Biblio
                                this.menuMostrar();
                                break;
                            
                            case ELIMINAR: // Eliminar fitxer multimedia
                                this.menuEliminar();
                                break;
                            
                            case VOLVER: // Menu anterior
                                break;
                        }
                    } while (opcio2!=OpcionsMenuSecundari.VOLVER);
                    break;
                    
                case GUARDAR: // Guardar Dades
                    this.menuGuardar();
                    break;
                    
                case RECUPERAR: // Recuperar dades
                    this.menuRecuperar();
                    break;
                    
                case SORTIR: // Sortir
                    System.out.println("\nFins aviat!");
                    break;
                   
            }
        } while(opcio!=OpcionsMenuPrincipal.SORTIR);
    }
    /**
     * Llama al metodo carregarDadesDisc() de Controlador
     */
    private void menuRecuperar() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner (System.in);
        String camiDesti;
        System.out.println("\nCamí on es troba el fitxer:");
        camiDesti = sc.next();
        try {
            control.carregarDadesDisc(camiDesti);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
    }
    /**
     * Llama al metodo guardarDadesDisc() de Controlador
     */
    private void menuGuardar() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner (System.in);
        String camiOrigen;
        System.out.println("\nCamí on es guardarà el fitxer:");
        camiOrigen = sc.next();
        try {
            control.guardarDadesDisc(camiOrigen);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
                            
    }
    /**
     * Llama al metodo mostrarBiblioteca() de Controlador
     */
    private void menuMostrar() {
        System.out.println("Carpeta Fitxers:\n==============\n" + control.mostrarBiblioteca());
    }
    /**
     * Llama al metodo esborrarFitxer() de Controlador
     */
    private void menuEliminar() {
        Scanner sc = new Scanner (System.in);
        control.mostrarBiblioteca();
        System.out.println("Introdueix l'índex del fitxer desitjat:");
        int id = sc.nextInt();
        try {
            control.esborrarFitxer(id);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
    }
    /**
     * Llama al metodo afegirVideo() de Controlador
     */
    private void menuAfegirVideo() {
        String path, codec, nomVideo;
        float fps, durada;
        int alcada, amplada;
        Scanner sc = new Scanner (System.in);

        System.out.print("\nCamí on es troba el fitxer: ");
        path = sc.next ();
        System.out.print("\nNom fitxer: ");
        nomVideo = sc.next();
        path += "/" + nomVideo;
        System.out.print("\nCodec: ");
        codec = sc.next();
        System.out.print("\nDurada(float): ");
        durada = sc.nextFloat();
        System.out.print("\nAlcada: ");
        alcada = sc.nextInt();
        System.out.print("\nAmplada: ");
        amplada = sc.nextInt();
        System.out.print("\nFps(float): ");
        fps = sc.nextFloat();

        try {
            control.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps);       
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
        
    }
    /**
     * Llama al metodo afegirAudio() de Controlador
     */
    private void menuAfegirAudio() {
        String path, codec, camiImatge, nomAudio;
        float durada;
        int kbps;
        Scanner sc = new Scanner (System.in);

        System.out.print("\nCamí on es troba el fitxer: ");
        path = sc.next ();
        System.out.print("\nCami Imatge: ");
        camiImatge = sc.next();
        System.out.print("\nNom fitxer amb l'extensió: ");
        nomAudio = sc.next();
        path += "/" + nomAudio;
        System.out.print("\nCodec: ");
        codec = sc.next();
        System.out.print("\nDurada(float): ");
        durada = sc.nextFloat();
        System.out.print("\nKbps: ");
        kbps = sc.nextInt();

        try {
            control.afegirAudio(path, camiImatge, nomAudio, codec, durada, kbps);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
    }
    
}