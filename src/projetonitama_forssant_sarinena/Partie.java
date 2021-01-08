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
    Carte GrilleCarte[][] = new Carte[5][1];
    
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
        // Determine qui est le premier joueur OK
        // Placer Pions (Rouge en bas/bleu en haut) OK
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

        //placer les pions
        PlateauJeu.PositionnerPionsDepart();

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

        /*// affichage sur console ----- suivi du bon déroulement du jeu
        System.out.println(Joueur1.NomJoueur + " possède les cartes " + Joueur1.CarteEnMain[0].NomCarte + " et " + Joueur1.CarteEnMain[1].NomCarte);
        System.out.println(Joueur2.NomJoueur + " possède les cartes " + Joueur2.CarteEnMain[0].NomCarte + " et " + Joueur2.CarteEnMain[1].NomCarte);
        System.out.println("La carte transition est " + CarteTransition.NomCarte);

        System.out.println(Joueur1.NomJoueur + " possède les pions de couleur " + Joueur1.CouleurJoueur);
        System.out.println(Joueur2.NomJoueur + " possède les pions de couleur " + Joueur2.CouleurJoueur);

        PlateauJeu.AfficherPlateauSurConsole(); // affichage du jeu initialisé sur la console
        // BD : methode non présente OK*/
    }

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

    String CarteExistanteDansJeu() {
        String val = null;
        for (int i = 0; i < TabCartePartie.length; i++) {
            if (val == TabCartePartie[i].NomCarte) //retourner la position courante
            {
                return val;
            }
        }
        return "La valeur recherchée n'existe pas";
    }

    /*    String CarteExistanteDansMain() {
        String val = null;
        for (int i = 0; i < Joueur.CarteEnMain.length; i++) {
            if (val == CarteEnMain[i].NomCarte) //retourner la position courante
            {
                return val;
            }
        }
        return "La valeur recherchée n'existe pas";
    }
        
                 
   boolean ChoisirCarteDansJeu(Carte uneCarte) {
        if (uneCarte.NomCarte == CarteExistanteDansJeu()) {
            return true;
        } else {
            System.out.println("Erreur. La carte n'est pas de la partie");
            return false;
        }
    }

    String NomCarteChoisieDansJeu(Carte uneCarte) {
        if (ChoisirCarteDansJeu(uneCarte) != true) {
            return "Erreur...Choix de carte non valide";
        }
        return uneCarte.NomCarte;
    }*/
    
    String NomCarteChoisie(Carte uneCarte) {
        if (JoueurCourant.ChoisirCarteDansMain(uneCarte) != true) {
            return "Erreur...Choix de carte non valide";
        }
        return uneCarte.NomCarte;
    }
    
    Carte CarteChoisie(String unNomCarte){
        if (JoueurCourant.CarteEnMain[0].NomCarte == unNomCarte){
            return JoueurCourant.CarteEnMain[0];
        }
        else return JoueurCourant.CarteEnMain[1];
    }
    

    boolean ChoisirPion(Pion unPion) {
        if (unPion.CouleurPion == JoueurCourant.CouleurJoueur) {
            return true;
        } else {
            System.out.println("le pion selectionné n'est pas de votre couleur");
            return false;
        }
    }
    
        boolean ChoisirPion(int l, int c) {
        if (PlateauJeu.Grille[l][c].PionCourant.CouleurPion == JoueurCourant.CouleurJoueur) {
            return true;
        } else {
            System.out.println("le pion selectionné n'est pas de votre couleur");
            return false; 
        }
    }
        
        
    void Tour() { // équivalent de notre méthode Menu() achevée
        System.out.println("Tour de " + JoueurCourant.NomJoueur);
        System.out.println("Choisissez une carte déplacement");
        String ChoixCarte;
        Scanner sc = new Scanner(System.in);
        ChoixCarte = sc.nextLine();
        while (!ChoixCarte.equals(JoueurCourant.CarteEnMain[0].NomCarte) && !ChoixCarte.equals(JoueurCourant.CarteEnMain[1].NomCarte)){
             System.out.println("Carte invalide. Réessayer.");
             ChoixCarte = sc.nextLine();
        }
        System.out.println("la carte déplacement choisie est " + ChoixCarte);
        Carte CarteDuTour = CarteChoisie(ChoixCarte);
        
        System.out.println("Choisissez un pion à déplacer");
        int c;
        int l;
        System.out.println("Donner les coordonnées du pion à déplacer : ");
        System.out.println("Saisir colonne : ");
        c = sc.nextInt() - 1;
        while (c < 0 || c > 4) {
            System.out.println("Colonne invalide. Réessayer.");
            c = sc.nextInt() - 1;
        }
        System.out.println("Saisir ligne : ");
        l = sc.nextInt() - 1;
        while (l < 0 || l > 4) {
            System.out.println("Ligne invalide. Réessayer.");
            l = sc.nextInt() - 1;
        

        
    
        System.out.println("Choisissez une case grise");
    
    }
    }

    void JoueurSuivant() { // changement de joueur
        // BD : joueur suivant
        if (ListeJoueurs[0] == JoueurCourant) {
            JoueurCourant = ListeJoueurs[1];
        } else {
            JoueurCourant = ListeJoueurs[0];
        }
    }

    Carte EchangeCarte(Carte uneCarte) {
        // la dernière carte jouée devient carte transition
        // changement de main, ajout de la 3e carte à l'autre joueur
        // BD: je vois a peu pres cette méthode. Ne pas oublier qu'il faudra, uen fois les cartes échangées, raffecter carteCourante comme une carte appartenant au joueur courant
        //return uneCarte;  
        return CarteTransition;
    }
}
