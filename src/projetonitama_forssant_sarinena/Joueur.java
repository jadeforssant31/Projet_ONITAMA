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
    Carte CarteEnMain[] = new Carte[2]; // tableau d'objet Carte qui recensent les cartes en main d'un joueur pendant la partie
    Carte CarteCourante;

    public Joueur(String unNomJoueur) { // constructeur qui passe le nom en paramètre
        NomJoueur = unNomJoueur;
    }

    void AffecterCouleur(String uneCouleurJoueur) { // affecte la couleur en paramètre au joueur
        CouleurJoueur = uneCouleurJoueur;
    }

    String CouleurDuJoueur() { // création de cette méthode pour récupérer la couleur dans la classe grille
        return CouleurJoueur;
    }

// le joueur joue la carte selectionnee
// la carte va ensuite être échangée avec celle qui était au bord du plateau
    
    boolean ChoisirCarteDansMain(Carte uneCarte) { //cette méthode vérifie que la carte sélectionnée est bien dans la main du joueur, sinon impossibilité de choisir la carte
        if (uneCarte.NomCarte == CarteEnMain[0].NomCarte || uneCarte.NomCarte == CarteEnMain[1].NomCarte) {
            return true;
        } else {
            System.out.println("Erreur. La carte n'est pas dans votre jeu");
            return false;
        }
    }

    String NomCarteChoisieDansMain(Carte uneCarte) { // renvoie le nom de la carte choisie
        if (ChoisirCarteDansMain(uneCarte) != true) {
            return "Erreur...Choix de carte non valide";
        }
        return uneCarte.NomCarte;
    }
}
