/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_forssant_sarinena;

import java.util.ArrayList;
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
    Carte TabCartePartie[] = new Carte[5];

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

    ArrayList<Carte> ListeCartes = new ArrayList<Carte>() {
        {
            add(CarteMante);
            add(CarteSinge);
            add(CarteCheval);
            add(CarteBoeuf);
            add(CarteGrue);
            add(CarteSanglier);
            add(CarteAnguille);
            add(CarteCobra);
            add(CarteTigre);
            add(CarteDragon);
            add(CarteGrenouille);
            add(CarteLapin);
            add(CarteCrabe);
            add(CarteElephant);
            add(CarteOie);
            add(CarteCoq);
        }
    };

    void initialiserPartie() {

        // vider Plateau OK
        // Entrée des joueurs et affectation dans tableau OK
        // Sélection des 5 cartes déplacements OK
        // Attribution des couleurs OK
        // Tirage et attribution des cartes OK
        // Determine qui est le premier joueur
        // Placer Pions (Rouge en bas/bleu en haut)
        
        
        // On vide le plateau
        PlateauJeu.ViderPlateau();

        // création des 2 joueurs et affectation dans tableau
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du Joueur 1 : ");
        Joueur Joueur1 = new Joueur(sc.nextLine()); // création des deux objets joueur
        System.out.println("Entrez le nom du Joueur 2 : ");
        Joueur Joueur2 = new Joueur(sc.nextLine());

        ListeJoueurs[0] = Joueur1; // affectation des référence au tableau
        ListeJoueurs[1] = Joueur2;

        //attribution des couleurs
        AttribuerCouleursAuxJoueurs();

        // Tirage des cartes
        DefinirCartesPartie();
        //System.out.println(ListeCartes);

        // Attribution des cartes et affectation dela derniere en tant que carte transition
        Joueur1.CarteEnMain[0] = TabCartePartie[0];
        Joueur1.CarteEnMain[1] = TabCartePartie[1];
        Joueur2.CarteEnMain[0] = TabCartePartie[2];
        Joueur2.CarteEnMain[1] = TabCartePartie[3];
        CarteTransition = TabCartePartie[4];

        // On determine qui commence à jouer
        Random joueur = new Random();
        boolean premier_joueur = joueur.nextBoolean();
        if (premier_joueur) {
            JoueurCourant = ListeJoueurs[0];
        } else {
            JoueurCourant = ListeJoueurs[1];
        }

        // Placer les pions
        // affichage sur console ----- suivi du bon déroulement du jeu
        System.out.println(Joueur1.NomJoueur + " possède les cartes " + Joueur1.CarteEnMain[0].NomCarte + " et " + Joueur1.CarteEnMain[1].NomCarte);
        System.out.println(Joueur2.NomJoueur + " possède les cartes " + Joueur2.CarteEnMain[0].NomCarte + " et " + Joueur2.CarteEnMain[1].NomCarte);
        System.out.println("La carte transition est " + CarteTransition.NomCarte);

        System.out.println(Joueur1.NomJoueur + " possède les pions de couleur " + Joueur1.CouleurJoueur);
        System.out.println(Joueur2.NomJoueur + " possède les pions de couleur " + Joueur2.CouleurJoueur);

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

    void DefinirCartesPartie() { // définit la pile des 5 cartes pour une partie
        Random rand = new Random();
        int NbreCartes = 5;

        for (int i = 0; i < NbreCartes; i++) {
            int randomIndex = rand.nextInt(ListeCartes.size());
            Carte randomElement = ListeCartes.get(randomIndex);
            TabCartePartie[i] = randomElement;
            //System.out.println(TabCartePartie[i].NomCarte);
            ListeCartes.remove(randomIndex);
        }
        //return (TabCartePartie);
    }

    boolean DeplacerPion(int l, int c, Carte uneCarte) { // à revoir
        if (uneCarte.NomCarte == "Mante") {
            //Plateau.Grille[l][c].PionCourant = Plateau.Grille[l+1][c].PionCourant;     

//PROBLEME METTRE DES COORD DANS CLASSE PARTIE OU DES CARTES DANS CLASSE PLATEAU
        }

        // appeler méthode déplacer pion dans plateau
        return true;
    }

    Carte ChoisirCarte(Carte unNomCarte) {
        Carte CarteChoisie = unNomCarte;
        // comparaison string pour sélectionner la bonne carte
        return CarteChoisie;
    }

    String NomCarteChoisie(Carte unNomCarte) {
        return unNomCarte.NomCarte;
    }

    boolean ChoisirPion(Pion unPion) {
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
    Carte EchangeCarte(Carte uneCarte) {
        // la dernière carte jouée devient carte transition
        // changement de main, ajout de la 3e carte à l'autre joueur
        // BD: je vois a peu pres cette méthode. Ne pas oublier qu'il faudra, uen fois les cartes échangées, raffecter carteCourante comme une carte appartenant au joueur courant
        //return uneCarte;  
        return CarteTransition;
    }
}
