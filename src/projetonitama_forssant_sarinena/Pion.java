/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_forssant_sarinena;

/**
 *
 * @author lucie
 */
public class Pion {

    String CouleurPion;
    boolean Roi; 

    public Pion(String uneCouleurPion) { // constructeur qui passe le nom en paramètre et initialise les attributs
        CouleurPion = uneCouleurPion;
        Roi = false;
    }

    public Pion() {
        CouleurPion = null;
        Roi = false;
    }

    String LireCouleurPion() { //retourne la couleur du pion
        return CouleurPion;
    }

    //retourne le role du pion
    String LireRolePion() {
        if (Roi == true) {
            return "Roi";
        } else {
            return "Pion";
        }
    }

    // renvoie true si le pion est roi, false sinon (pion simple)
    boolean EtreRoi() { 
        if (Roi == true) { 
            return true;
        } else {
            return false;
        }
    }
}
