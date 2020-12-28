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
public class Joueur {

    String NomJoueur;
    String CouleurJoueur;
    Carte CarteEnMain[] = new Carte[2];
    // Pion ListePions[] = new Pion[5]; // Necessaire ?
    // BD : seulement 2 cartes en main pour un joueur OK
    Carte CarteCourante;
    // BD : carte courante c'est bien la carte qu'il s'apprete à jouer ? OUI

    public Joueur(String unNomJoueur) { // constructeur qui passe le nom en paramètre et initialise les attributs
        NomJoueur = unNomJoueur;
    }

    void AffecterCouleur(String uneCouleurJoueur) { // affecte la couleur en paramètre au joueur
        CouleurJoueur = uneCouleurJoueur;
    }

    String CouleurDuJoueur() { // création de cette méthode pour récupérer la couleur dans la classe grille
        return CouleurJoueur;
    }

// le joueur joue la carte selectionnee
//la carte va ensuite être mechngée avec celle qui etait au bord du plateau

    boolean ChoisirCarteDansMain(Carte uneCarte) {
        if (uneCarte.NomCarte == CarteEnMain[0].NomCarte || uneCarte.NomCarte == CarteEnMain[1].NomCarte) {
            return true;
        } else {
            System.out.println("Erreur. La carte n'est pas dans votre jeu");
            return false;
        }
    }
    
        String NomCarteChoisieDansMain(Carte uneCarte) {
        if (ChoisirCarteDansMain(uneCarte) != true) {
            return "Erreur...Choix de carte non valide";
        }
        return uneCarte.NomCarte;
    }

    boolean UtiliserCarte(Carte NomCarte) {
        return true;
    }

}
