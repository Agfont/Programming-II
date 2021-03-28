/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.FontArthurRodriguezCristian.vista;

import edu.ub.prog2.FontArthurRodriguezCristian.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 * @author Arthur Font i Cristian Rodriguez
 * La clase AplicacioUB2 es la interface externa de nuestro progama.
 * Es responsable por enseñar las opciones del menu, llamar los métodos 
 * del Controlador y agafar las excepciones.
 * 
 */
public class AplicacioUB3 {
    /**
     * Opcions de los menus
     */
    static private enum OpcionsMenuPrincipal {GESTIO,GESTIOALBUM,CONTROL,GUARDAR,RECUPERAR,SORTIR};
    static private enum OpcionsMenu1 {AFEGIR,MOSTRAR,ELIMINAR,VOLVER};
    static private enum OpcionsMenu1_1 {VIDEO,AUDIO,VOLVER};
    static private enum OpcionsMenu2 {AFEGIR,MOSTRAR,ELIMINAR,GESTIONAR,VOLVER};
    static private enum OpcionsMenu2_4 {AFEGIR,MOSTRAR,ELIMINAR,VOLVER};
    static private enum OpcionsMenu3 {REPFITXER,REPBIBLIO,REPALBUM,ACTCONT,ACTRANDOM,GESTIO,VOLVER};
    static private enum OpcionsMenu3_6 {REACTIVA,PAUSA,ATURA,SALTA,VOLVER};
    /**
     * Funcions de los menus
     */
    static private String[] descMenuPrincipal= {"Gestió Biblioteca",
                                        "Gestió Àlbums",
                                        "Control Reproducció/Visió",
                                        "Guardar Dades", 
                                        "Recuperar Dades", 
                                        "Sortir"};         
    
    static private String[] descMenu1= {"Afegir fitxer multimèdia a la biblioteca",
                                            "Mostrar Biblioteca", 
                                            "Eliminar fitxer multimèdia",  
                                            "Menú Anterior"}; 
    static private String[] descMenu1_1= {"Afegir vídeo.",
                                            "Afegir àudio",
                                            "Menú Anterior"};
    
    static private String[] descMenu2= {"Afegir Àlbum",
                                         "Mostrar LLista de àlbums", 
                                         "Eliminar Àlbums",  
                                         "Gestionar Àlbum",
                                         "Menú Anterior"};
    
    static private String[] descMenu2_4= {"Afegir fitxer multimèdia",
                                            "Mostrar Àlbum", 
                                            "Eliminar fitxer multimèdia",  
                                            "Menú Anterior"};
    static private String[] descMenu3= {"Reproduir un fitxer reproduïble",
                                            "Reproduir tota la biblioteca",
                                            "Reproduir un àlbum",
                                            "Activar/desactivar reproducció continua", 
                                            "Activar/desactivar reproducció aleatòria", 
                                            "Gestió reproducció en curs",
                                            "Menú Anterior"};
    static private String[] descMenu3_6= {"Re-emprèn",
                                            "Pausa", 
                                            "Atura",  
                                            "Salta",
                                            "Sortir"};
    private Controlador control;
    
    /**
     * Constructor de AplicacioUB2
     */
    public AplicacioUB3() {
        control = new Controlador();
    }    
    
    public void gestioAplicacioUB() {
        this.menuPrincipal();
    }
    
    /**
     * Es el menu de nuestra aplicación
     */
    private void menuPrincipal() {
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu",OpcionsMenuPrincipal.values()); 
        menu.setDescripcions(descMenuPrincipal);
        OpcionsMenuPrincipal opcio1 = null;       
        
        Scanner sc = new Scanner (System.in);

        do {
            menu.mostrarMenu();
            opcio1 = menu.getOpcio(sc);
            switch(opcio1) {               
                case GESTIO: // Gestio Biblio                    
                    this.menu1(sc);
                    break;
                    
                case GESTIOALBUM:
                    this.menu2(sc);
                    break;
                    
                case CONTROL:
                    this.menu3(sc);
                    break;
                    
                case GUARDAR: // Guardar Dades
                    this.opcio4(sc);
                    break;
                    
                case RECUPERAR: // Recuperar dades
                    this.opcio5(sc);
                    break;
                    
                case SORTIR: // Sortir
                    this.opcio6();
                    break;                   
            }
            
        } while(opcio1!=OpcionsMenuPrincipal.SORTIR);
    }
    
    private void menu1(Scanner sc) {
        Menu<OpcionsMenu1> menu1 = new Menu<OpcionsMenu1>("Menu Getió Biblio",OpcionsMenu1.values());
        menu1.setDescripcions(descMenu1);
        OpcionsMenu1 opcio1= null;
        do {
            menu1.mostrarMenu();
            opcio1 = menu1.getOpcio(sc);
            switch(opcio1){
                case AFEGIR: // Afegir fitxer multimedia
                    this.menu1_1(sc);
                    break;

                case MOSTRAR: // Mostrar Biblio
                    this.opcio1_2();
                    break;

                case ELIMINAR: // Eliminar fitxer multimedia
                    this.opcio1_3(sc);
                    break;
                    
                case VOLVER: // Menu anterior
                    break;
            }
        } while (opcio1!=OpcionsMenu1.VOLVER);
    }
    
    private void menu1_1(Scanner sc) {
        Menu<OpcionsMenu1_1> menu1_1 = new Menu<OpcionsMenu1_1>("Menu Afegir Fitxer Multimedia",OpcionsMenu1_1.values());
        menu1_1.setDescripcions(descMenu1_1);
        OpcionsMenu1_1 opcio1_1 = null;
        do {
            menu1_1.mostrarMenu();
            opcio1_1 = menu1_1.getOpcio(sc);
            switch(opcio1_1) {
                case VIDEO :  // Video
                    this.opcio1_1_1(sc);
                    break;
                case AUDIO: // Audio
                    this.opcio1_1_2(sc); 
                    break;
                case VOLVER:
                    break;
            }

        } while (opcio1_1!= OpcionsMenu1_1.VOLVER);
    }
    
    /**
     * Llama al metodo afegirVideo() de Controlador
     */
    private void opcio1_1_1(Scanner sc) {
        String path, codec, nomVideo;
        float fps, durada;
        int alcada, amplada;

        /*System.out.print("\nCamí on es troba el fitxer: ");
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
        fps = sc.nextFloat();*/
        
        path = "/home/arthurfont/Downloads/Midia";
        nomVideo = "gato.mp4";
        path += "/" + nomVideo;
        
        codec = "Fitxer";
        durada = 1;
        alcada = 1;
        amplada = 1;
        fps = 1;
        
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
    private void opcio1_1_2(Scanner sc) {
        String path, codec, camiImatge, nomAudio;
        float durada;
        int kbps;

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
    
     /**
     * Llama al metodo mostrarBiblioteca() de Controlador
     */
    private void opcio1_2() {
        System.out.println("Biblioteca:\n==============\n" + control.mostrarBiblioteca());
    }
    
    /**
     * Llama al metodo esborrarFitxer() de Controlador
     */
    private void opcio1_3(Scanner sc) {
        System.out.println("Biblioteca:\n==============\n" + control.mostrarBiblioteca());
        System.out.println("Introdueix l'índex del fitxer desitjat [0 per tornar]:");
        int id = sc.nextInt() -1;
        try {
            control.esborrarFitxer(id);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
    }
    
    private void menu2 (Scanner sc) {
        Menu<OpcionsMenu2> menu2 = new Menu<OpcionsMenu2>("Menu Gestió Àlbums",OpcionsMenu2.values()); 
        menu2.setDescripcions(descMenu2);
        OpcionsMenu2 opcio2 = null;
        do {
            menu2.mostrarMenu();
            opcio2 = menu2.getOpcio(sc);
            switch(opcio2) {                   
                case AFEGIR:
                    this.opcio2_1(sc);
                    break;
                case MOSTRAR:
                    this.opcio2_2(sc);
                    break;
                case ELIMINAR:
                    this.opcio2_3(sc);
                    break;
                case GESTIONAR:
                    this.menu2_4(sc);
                    break;
                case VOLVER:
                    break;
            }
        } while (opcio2!= OpcionsMenu2.VOLVER);
    }
    
    private void opcio2_1 (Scanner sc) {
        String nomAlbum;
        System.out.println("\nNom del àlbum:");
        nomAlbum = sc.next();
        try {
            control.afegirAlbum(nomAlbum);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
    }
    
    private void opcio2_2 (Scanner sc) {
        System.out.println("Llista de Àlbums:\n==============\n" + control.mostrarLlistatAlbums());
    }
    
    private void opcio2_3 (Scanner sc) {
        String nomAlbum;
        System.out.println("Llista de Àlbums:\n==============\n" + control.mostrarLlistatAlbums());
        System.out.println("\nNom del àlbum que vols esborrar:");
        nomAlbum = sc.next();
        try {
            control.esborrarAlbum(nomAlbum);
        }
        catch (AplicacioException except) {
            except.getMessage();
        }
    }
    
    private void menu2_4(Scanner sc) {
        Menu<OpcionsMenu2_4> menu2_4 = new Menu<OpcionsMenu2_4>("Menu Gestió Àlbum",OpcionsMenu2_4.values());
        menu2_4.setDescripcions(descMenu2_4);
        OpcionsMenu2_4 opcio2_4 = null;
        String nomAlbum;
        System.out.println("Llista de Àlbums:\n==============\n" + control.mostrarLlistatAlbums());
        if (control.emptyListaAlbums()) {
            System.out.println("\nNo hi han àlbums");
        }
        else { 
            System.out.println("\nNom del àlbum que vols gestionar:");
            nomAlbum = sc.next();
            if (!control.existeixAlbum(nomAlbum)) {
                System.out.println("Album no existent");
                menu2_4(sc);
            }
            else {    
                do {          
                    menu2_4.mostrarMenu();
                    opcio2_4 = menu2_4.getOpcio(sc);
                    switch(opcio2_4) {                   
                        case AFEGIR:
                            this.opcio2_4_1(sc, nomAlbum);
                            break;
                        case MOSTRAR:
                            this.opcio2_4_2(sc, nomAlbum);
                            break;
                        case ELIMINAR:
                            this.opcio2_4_3(sc, nomAlbum);
                            break;
                        case VOLVER:
                            break;
                    }
                } while (opcio2_4!= OpcionsMenu2_4.VOLVER);
            }
        }
    }
    
    private void opcio2_4_1 (Scanner sc, String titolAlbum) {
        System.out.println("Biblioteca:\n==============\n" + control.mostrarBiblioteca());
        System.out.println("Introdueix l'índex del fitxer que vols afegir a l'àlbum: ");
        int id = sc.nextInt()-1;
        try {
            control.afegirFitxer(titolAlbum, id);
        } catch (AplicacioException execpt) {
            execpt.getMessage();
        }
        
    }
    
    private void opcio2_4_2 (Scanner sc, String titolAlbum) {
        try {
            System.out.println("Àlbum " + titolAlbum + ":\n==============\n" + control.mostrarAlbum(titolAlbum));
        } catch (AplicacioException ex) {}
    }
    
    private void opcio2_4_3 (Scanner sc, String titolAlbum) {
        this.opcio2_4_2(sc, titolAlbum);
        System.out.println("Introdueix l'índex del fitxer que vols esborrar de l'àlbum: ");
        int id = sc.nextInt()-1;
        try {
            control.esborrarFitxer(titolAlbum, id);
        } catch (AplicacioException execpt) {
            execpt.getMessage();
        }
    }
    
    private void menu3(Scanner sc) {
        Menu<OpcionsMenu3> menu3 = new Menu<OpcionsMenu3>("Menu Control Reproducció",OpcionsMenu3.values());
        menu3.setDescripcions(descMenu3);
        OpcionsMenu3 opcio3 = null;
        control.obrirFinestraReproductor();
        do {
            menu3.mostrarMenu();
            opcio3 = menu3.getOpcio(sc);
            switch(opcio3) {
                case REPFITXER:
                    this.opcio3_1(sc);
                    break;
                case REPBIBLIO:
                    this.opcio3_2(sc);
                    break;
                case REPALBUM:
                    this.opcio3_3(sc);
                    break;
                case ACTCONT:
                    this.opcio3_4(sc);
                    break;
                case ACTRANDOM:
                    this.opcio3_5(sc);
                    break;
                case GESTIO:
                    this.menu3_6(sc);
                    break;
                case VOLVER:
                    this.opcioTancarReproduccio();
                    break;
            }
        } while (opcio3!= OpcionsMenu3.VOLVER);
    }
    
    private void opcio3_1 (Scanner sc) {
        System.out.println("Biblioteca:\n==============\n" + control.mostrarBiblioteca());
        System.out.println("Introdueix l'índex del fitxer que vols reproduir: ");
        int id = sc.nextInt()-1;
        try {
            this.control.reproduirFitxer(id);
        } catch (AplicacioException execpt) {
            execpt.getMessage();
        }       
    }
    
    private void opcio3_2 (Scanner sc) {
        try {
            this.control.reproduirCarpeta();
        } catch (AplicacioException execpt) {
            execpt.getMessage();
        }
    }
    
    private void opcio3_3 (Scanner sc) {
        System.out.println("Llista de Àlbums:\n==============\n" + control.mostrarLlistatAlbums());
        if (control.emptyListaAlbums()) {
            System.out.println("\nNo hi han àlbums");
        }
        else { 
            System.out.println("\nNom del àlbum que vols reproduir:");
            String nomAlbum = sc.next();
            if (!control.existeixAlbum(nomAlbum)) {
                System.out.println("Album no existent");
                opcio3_3(sc);
            }
            else {    
                try {
                    this.control.reproduirCarpeta(nomAlbum);
                } catch (AplicacioException execpt) {
                    execpt.getMessage();
                }
            }
        }
    }
    
    private void opcio3_4 (Scanner sc) {
        this.control.setCiclica();
    }
    
    private void opcio3_5 (Scanner sc) {
        this.control.setAleatori();
    }
    private void menu3_6(Scanner sc) {
        Menu<OpcionsMenu3_6> menu3_6 = new Menu<OpcionsMenu3_6>("Menu Gestió Reproducció",OpcionsMenu3_6.values());
        menu3_6.setDescripcions(descMenu3_6);
        OpcionsMenu3_6 opcio3_6 = null;
        do {
            menu3_6.mostrarMenu();
            opcio3_6 = menu3_6.getOpcio(sc);
            switch(opcio3_6) {
                case REACTIVA:
                    this.opcio3_6_1(sc);
                    break;
                case PAUSA:
                    this.opcio3_6_2(sc);
                    break;
                case ATURA:
                    this.opcio3_6_3(sc);
                    break;
                case SALTA:
                    this.opcio3_6_4(sc);
                    break;
                case VOLVER:
                    break;
            }
        } while (opcio3_6!= OpcionsMenu3_6.VOLVER);
    }
    
    private void opcio3_6_1 (Scanner sc) {
        try {
            this.control.reemprenReproduccio();
        } catch (AplicacioException ex) {
            ex.getMessage();
        }
    }
    
    private void opcio3_6_2 (Scanner sc) {
        try {
            this.control.pausaReproduccio();
        } catch (AplicacioException ex) {
            ex.getMessage();
        }
    }
    
    private void opcio3_6_3 (Scanner sc) {
        try {
            this.control.aturaReproduccio();
        } catch (AplicacioException ex) {
            ex.getMessage();
        }
    }
    
    private void opcio3_6_4 (Scanner sc) {
        try {
            this.control.saltaReproduccio();
        } catch (AplicacioException ex) {
            ex.getMessage();
        }
    }
    
    private void opcioTancarReproduccio () {
        try {
            this.control.tancarFinestraReproductor();
        } catch (AplicacioException ex) {
            ex.getMessage();
        }
    }
    
    /**
     * Llama al metodo guardarDadesDisc() de Controlador
     */
    private void opcio4(Scanner sc) {
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
     * Llama al metodo carregarDadesDisc() de Controlador
     */
    private void opcio5(Scanner sc) {
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
    
    private void opcio6() {
        System.out.println("\nFins aviat!");
    }
    
}