/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_sarinena_forssant;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lucie
 */
public class Partie {
    
    Joueur ListeJoueurs[] = new Joueur[2];  // liste de 2 d'objet joueur à 2 cases. Sera initialisée quand les joueurs seront créés
    Plateau PlateauJeu = new Plateau(); // création de la référence objet GrilleJeu
    Joueur JoueurCourant;
    Carte CarteTransition;
    Carte CarteCourante;

void initialiserPartie() {
    
    // vider Plateau
    // Placer Pions (Rouge en bas/bleu en haut)
    // Entrée des joueurs et affectation dans liste
    // Sélection des 5 cartes déplacements
    // Attribution des couleurs
    // Attribution des cartes
    // Création et attribution CarteTransition (qui commence ?)
    // Afficher la grille
    
        PlateauJeu.ViderPlateau(); // initialisation de la grille
        // BD : corrigé avec un V majuscule OK
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du Joueur 1 : ");
        Joueur Joueur1 = new Joueur(sc.nextLine()); // création des deux objets joueur
        System.out.println("Entrez le nom du Joueur 2 : ");
        Joueur Joueur2 = new Joueur(sc.nextLine());

        ListeJoueurs[0] = Joueur1; // affectation des référence au tableau
        ListeJoueurs[1] = Joueur2;

        AttribuerCouleursAuxJoueurs();

        System.out.println(Joueur1.NomJoueur + " possède les jetons de couleur " + Joueur1.CouleurJoueur);
        System.out.println(Joueur2.NomJoueur + " possède les jetons de couleur " + Joueur2.CouleurJoueur);

        PlateauJeu.AfficherPlateauSurConsole(); // affichage du jeu initialisé sur la console
        // BD : methode non présente OK
}
    
// méthode débuter partie ?

void AttribuerCouleursAuxJoueurs() {
        Random alea = new Random(); // attribution des joueurs au hasard
        boolean ChoixJoueur;
        ChoixJoueur = alea.nextBoolean();
        if (ChoixJoueur == true) {
            ListeJoueurs[0].CouleurJoueur = "Bleu";
            ListeJoueurs[1].CouleurJoueur = "Rouge";
        } else {
            ListeJoueurs[0].CouleurJoueur = "Rouge";
            ListeJoueurs[1].CouleurJoueur = "Bleu";
        }
}

Carte SelectionCartePartie(){
    // tirage aléatoire de 5 cartes parmi les 16 et les renvoie
    
   // BD : ou sont stockées les 16 cartes au début ? DANS LA CLASSE PLATEAU.
   // BD : conseil : commencer par les créer. Ce sont des objets simples. OK
    //return uneCarte;
    return CarteTransition;
}

void AttribuerCartesAuxJoueurs() {
      // création tirage aléatoire parmi le résultat de la méthode SelectionCartePartie
      // attribution au hasard de 2 pour chaque joueur
      // affectation de la carte transition à un des joueurs
}

boolean DeplacerPion(Pion unPion){ // à revoir
    // appeler méthode déplacer pion dans plateau
    return true;
}

boolean ChoisirCarte(Carte unNomCarte){
    // comparaison string pour sélectionner la bonne carte
    return true;
}

boolean ChoisirPion(Pion unPion){
    return true;
}

boolean Tour() { // équivalent de notre méthode Menu() achevée
        System.out.println("Tour de " + JoueurCourant.NomJoueur);
        return true;
}

void JoueurSuivant() { // changement de joueur
    // BD : joueur suivant
        if (ListeJoueurs[0] == JoueurCourant) {
            JoueurCourant = ListeJoueurs[1];
        } else {
            JoueurCourant = ListeJoueurs[0];
        }
}

/*Carte CarteAJouer(){
    // renvoyer les cartes que le joueur peut utiliser (seulement 2)
    // BD : pas compris cette méthode, on renvoie quelle carte? 
    return uneCarte;
}*/

Carte EchangeCarte(){
    // la dernière carte jouée devient carte transition
    // changement de main, ajout de la 3e carte à l'autre joueur
    // BD: je vois a peu pres cette méthode. Ne pas oublier qu'il faudra, uen fois les cartes échangées, raffecter carteCourante comme une carte appartenant au joueur courant
    //return uneCarte;  
    return CarteTransition;
}

// échange des valeurs des matrices
int[][] Mante = {{1, 2}, {3, 1}, {3, 3}};
Carte CarteMante = new Carte("Mante", "Rouge", Mante);

int[][] Singe = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
Carte CarteSinge = new Carte("Singe", "Bleu", Singe);

int[][] Cheval = {{2, 1}, {1, 2}, {3, 2}};
Carte CarteCheval = new Carte("Cheval", "Rouge", Cheval);

int[][] Boeuf = {{1, 2}, {3, 2}, {2, 3}};
Carte CarteBoeuf = new Carte("Boeuf", "Bleu", Boeuf);

int[][] Grue = {{1, 1}, {3, 2}, {1, 3}};
Carte CarteGrue = new Carte("Grue", "Bleu", Grue);

int[][] Sanglier = {{2, 1}, {2, 3}, {3, 2}};
Carte CarteSanglier = new Carte("Sanglier", "Rouge", Sanglier);

int[][] Anguille = {{1, 1}, {3, 1}, {2, 3}};
Carte CarteAnguille = new Carte("Anguille", "Bleu", Anguille);

int[][] Cobra = {{2, 1}, {1, 3}, {3, 3}};
Carte CarteCobra = new Carte("Cobra", "Rouge", Cobra);

int[][] Tigre = {{1, 2}, {4, 2}};
Carte CarteTigre = new Carte("Tigre", "Bleu", Tigre);

int[][] Dragon = {{3, 0}, {1, 1}, {1, 3}, {3, 4}};
Carte CarteDragon = new Carte("Dragon", "Rouge", Dragon);

int[][] Grenouille = {{2, 0}, {1, 3}, {3, 1}};
Carte CarteGrenouille = new Carte("Grenouille", "Bleu", Grenouille);

int[][] Lapin = {{1, 1}, {3, 3}, {2, 4}};
Carte CarteLapin = new Carte("Lapin", "Bleu", Lapin);

int[][] Crabe = {{2, 0}, {3, 2}, {2, 2}};
Carte CarteCrabe = new Carte("Crabe", "Bleu", Crabe);

int[][] Elephant = {{2, 1}, {3, 1}, {2, 3}, {3, 3}};
Carte CarteElephant = new Carte("Elephant", "Rouge", Elephant);

int[][] Oie = {{1, 2}, {3, 1}, {2, 1}, {2, 3}};
Carte CarteOie = new Carte("Oie", "Bleu", Oie);

int[][] Coq = {{1, 1}, {2, 1}, {2, 3}, {3, 3}};
Carte CarteCoq = new Carte("Coq", "Rouge", Coq);
}



