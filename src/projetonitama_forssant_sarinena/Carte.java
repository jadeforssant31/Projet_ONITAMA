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
public class Carte {

    String NomCarte;
    int Matrice[][];
    String CouleurCarte;

    public Carte(String unNom, String uneCouleur, int MatCoord[][]){ // constructeur qui passe le nom en paramètre et initialise les attributs
        NomCarte = unNom;
        CouleurCarte = uneCouleur;
        Matrice = new int[5][5];
        
        for (int i=0; i<MatCoord.length; i++){
        int x = MatCoord[i][0];
        int y = MatCoord[i][1];
        Matrice[x][y] = 1;
    }
    // BD : je rajouterai un second parametre permettant de remplir la matrice pour chaque carte OK
}     

String LireCarte(){ //Retourne au joueur le nom de la carte
   return NomCarte;
}

/*String MouvementPossible(String unNom){ //retourne au joueur une matrice 5x5 avec l'action qu'il peut jouer (Elle sert encore ?)
// BD : manque un vecteur en paramètre désignant le mouvement
    return null;
}*/
       
}
