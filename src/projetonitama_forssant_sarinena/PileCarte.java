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
public class PileCarte {
        Carte GrilleCarte[][] = new Carte[1][1];

    public PileCarte() { // constructeur qui à chaque case du tableau crée une référence objet de classe cellule
        for (int l = 0; l < 1 ; l++) {
            for (int c = 0; c < 0; c++) {
                GrilleCarte[l][c] = new Carte();
            }
        }
    }
}
