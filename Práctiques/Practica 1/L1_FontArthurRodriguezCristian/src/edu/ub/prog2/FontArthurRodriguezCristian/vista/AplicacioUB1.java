package edu.ub.prog2.FontArthurRodriguezCristian.vista;

import edu.ub.prog2.FontArthurRodriguezCristian.model.CarpetaFitxers;
import edu.ub.prog2.FontArthurRodriguezCristian.model.FitxerMultimedia;
import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 * @author Arthur Font i Cristian Rodriguez
 * 
 * La classe AplicacioUB funciona com a menu intermediari entre l'usuari i el programa.
 * Els atributs de AplicacioUB1 son OpcionsMenuPrincipal, descMenuPrincipal.
 */

public class AplicacioUB1 {
    
    /**
     * Opcions del menu principal
     */
    static private enum OpcionsMenuPrincipal {OPCIO1,OPCIO2,OPCIO3,SORTIR};
    /**
     * Funcions del menu principal
     */
    static private String[] descMenuPrincipal= {"Afegir fitxer multimèdia:",
                                                "Eliminar fitxer multimèdia:", 
                                                "Mostrar carpeta:",  
                                                "Sortir:"};
    Scanner sc = new Scanner (System.in);
    CarpetaFitxers biblio = new CarpetaFitxers();
    
    /**
     * Es el menu
     */
    public void gestioAplicacioUB() {
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal",OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);
        OpcionsMenuPrincipal opcio = null;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);            
            switch(opcio) {
                
                case OPCIO1:
                    FitxerMultimedia fitxer;
                    String cami, descripcio;
                    System.out.println("\nCamí on es troba el fitxer:");
                    cami = sc.next ();
                    System.out.println("Nom fitxer amb l'extensió:");
                    cami += sc.next();
                    System.out.println("Descripció:");
                    descripcio = sc.next();
                    
                    fitxer = new FitxerMultimedia(cami);
                    fitxer.setDescripcio(descripcio);
                    biblio.addFitxer(fitxer);
                    System.out.println("Fitxer creat i guardat");
                    
                    break;
                    
                case OPCIO2:
                    FitxerMultimedia fitxer2;
                    String cami2;
                    System.out.println("\nCamí on es troba el fitxer:");
                    cami2 = sc.next ();
                    System.out.println("Nom fitxer amb l'extensió:");
                    cami2 += sc.next();
                    
                    fitxer2 = new FitxerMultimedia(cami2);
                    biblio.removeFitxer(fitxer2);  
                    break;
                    
                case OPCIO3:
                    System.out.println(biblio.toString());
                    break;
                    
                case SORTIR:
                    System.out.println("\nFins aviat!");
                    break;
                   
            }
        } while(opcio!=OpcionsMenuPrincipal.SORTIR);
    }
}