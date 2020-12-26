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
    boolean Roi; // BD : ok pour Role. On pouvait aussi le gérer en tant que boolean, ou rajouter une méthode etreRoi OK

    public Pion(String uneCouleurPion) { // constructeur qui passe le nom en paramètre et initialise les attributs
        CouleurPion = uneCouleurPion;
        Roi = false;
    }

    String LireCouleurPion() { //retourne la couleur du pion
        return CouleurPion;
    }

    boolean EtreRoi() { //retourne le role du pion (pion simple ou roi)
        if (Roi == true) {
            //System.out.println("Roi présent");
            return true;
        } else {
            //System.out.println("Roi absent");
            return false;
        }
    }

}
