/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_sarinena_forssant;

/**
 *
 * @author lucie
 */
public class Joueur {
    
    String NomJoueur;
    String CouleurJoueur;
    Carte CarteEnMain[] = new Carte[2];
    // BD : seulement 2 cartes en main pour un joueur OK
    Carte CarteCourante;
    // BD : carte courante c'est bien la carte qu'il s'apprete à jouer ? OUI

    
public Joueur (String unNomJoueur) { // constructeur qui passe le nom en paramètre et initialise les attributs
    NomJoueur = unNomJoueur;
}  

void AffecterCouleur (String uneCouleurJoueur){ // affecte la couleur en paramètre au joueur
    CouleurJoueur = uneCouleurJoueur ;
}

String CouleurDuJoueur(){ // création de cette méthode pour récupérer la couleur dans la classe grille
    return CouleurJoueur;
}

// le joueur joue la carte selectionnee
//la carte va ensuite être mechngée avec celle qui etait au bord du plateau

boolean UtiliserCarte (Carte NomCarte){
   return true;
}

}
