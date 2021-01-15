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
public class Partie { // CLASSE OU ON A DEPOSE LES METHODES CONCERNANT LA CONSOLE ET LES METHODES NON UTILISEES DANS FENETRE DE JEU

    Joueur ListeJoueurs[] = new Joueur[2];  // liste de 2 d'objet joueur à 2 cases. Sera initialisée quand les joueurs seront créés
    Plateau PlateauJeu = new Plateau(); // création de la référence objet GrilleJeu
    Joueur JoueurCourant;
    Carte CarteTransition;
    Carte CarteCourante;
    Carte TabCartePartie[] = new Carte[5]; // Tableau de 5 objets Carte qui représente les 5 cartes déplacements pour une seule partie

   // Matrice pas utilisées (cf constructeur carte)
    //int[][] Mante = {{1, 2}, {3, 1}, {3, 3}};
    Carte CarteMante = new Carte("Mante");

    //int[][] Singe = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
    Carte CarteSinge = new Carte("Singe");

    //int[][] Cheval = {{2, 1}, {1, 2}, {3, 2}};
    Carte CarteCheval = new Carte("Cheval");

    //int[][] Boeuf = {{1, 2}, {3, 2}, {2, 3}};
    Carte CarteBoeuf = new Carte("Boeuf");

    //int[][] Grue = {{1, 1}, {3, 2}, {1, 3}};
    Carte CarteGrue = new Carte("Grue");

    //int[][] Sanglier = {{2, 1}, {2, 3}, {3, 2}};
    Carte CarteSanglier = new Carte("Sanglier");

    //int[][] Anguille = {{1, 1}, {3, 1}, {2, 3}};
    Carte CarteAnguille = new Carte("Anguille");

    //int[][] Cobra = {{2, 1}, {1, 3}, {3, 3}};
    Carte CarteCobra = new Carte("Cobra");

    //int[][] Tigre = {{1, 2}, {4, 2}};
    Carte CarteTigre = new Carte("Tigre");

    //int[][] Dragon = {{3, 0}, {1, 1}, {1, 3}, {3, 4}};
    Carte CarteDragon = new Carte("Dragon");

    //int[][] Grenouille = {{2, 0}, {1, 3}, {3, 1}};
    Carte CarteGrenouille = new Carte("Grenouille");

    //int[][] Lapin = {{1, 1}, {3, 3}, {2, 4}};
    Carte CarteLapin = new Carte("Lapin");

    //int[][] Crabe = {{2, 0}, {3, 2}, {2, 2}};
    Carte CarteCrabe = new Carte("Crabe");

    //int[][] Elephant = {{2, 1}, {3, 1}, {2, 3}, {3, 3}};
    Carte CarteElephant = new Carte("Elephant");

    //int[][] Oie = {{1, 2}, {3, 1}, {2, 1}, {2, 3}};
    Carte CarteOie = new Carte("Oie");

    //int[][] Coq = {{1, 1}, {2, 1}, {2, 3}, {3, 3}};
    Carte CarteCoq = new Carte("Coq");


    //On regroupe les 16 cartes dans une Arrayliste -> plus facile qu'un tableau car "dynamique" notamment pour récupérer les cartes aléatoirement
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

    
    // On initialise sur console
    void initialiserPartie() {
        
        // On vide le plateau de jeu
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

        // Tirage des 5 cartes choisies au hasard pour la partie
        DefinirCartesPartie();

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

        // affichage sur console ----- suivi du bon déroulement du jeu
        System.out.println(Joueur1.NomJoueur + " possède les cartes " + Joueur1.CarteEnMain[0].NomCarte + " et " + Joueur1.CarteEnMain[1].NomCarte);
        System.out.println(Joueur2.NomJoueur + " possède les cartes " + Joueur2.CarteEnMain[0].NomCarte + " et " + Joueur2.CarteEnMain[1].NomCarte);
        System.out.println("La carte transition est " + CarteTransition.NomCarte);

        System.out.println(Joueur1.NomJoueur + " possède les pions de couleur " + Joueur1.CouleurJoueur);
        System.out.println(Joueur2.NomJoueur + " possède les pions de couleur " + Joueur2.CouleurJoueur);

        PlateauJeu.AfficherPlateauSurConsole(); // affichage du jeu initialisé sur la console
    }

   
    
    // METHODE NON UTILISEE
    // On attribue une couleur à chaque joueur
    // ici, on a pris le parti de ne pas utiliser cette méthode car on a préféré fixer les rouges en bas et les bleus en haut pour faciliter la gestion du plateau
    void AttribuerCouleursAuxJoueurs() {
        Random alea = new Random(); // Random -> permet d'attribuer au hasard
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

    //Tirage aléatoire de 5 cartes parmis les 16 disponibles
    void DefinirCartesPartie() { 
        Random rand = new Random();
        int NbreCartes = 5;

        for (int i = 0; i < NbreCartes; i++) {
            int randomIndex = rand.nextInt(ListeCartes.size()); // on choisit un numéro au hasard entre 0 et 15 (car 16 cartes en tout)
            Carte randomElement = ListeCartes.get(randomIndex); // une fois le numéro choisi, on récupère la carte associé au n° de liste
            TabCartePartie[i] = randomElement; // on affecte au tableau cette carte
            //System.out.println(TabCartePartie[i].NomCarte);
            ListeCartes.remove(randomIndex); // on enlève enfin le n° au paquet afin de ne pas choisir deux fois la  même carte
        }
    }

    //METHODE NON UTILISEE
    String CarteExistanteDansJeu(Carte uneCarte) { // méthode qui vérifie la présence d'une carte dans la pile des 5 cartes de la partie
        String val = uneCarte.NomCarte;
        for (int i = 0; i < TabCartePartie.length; i++) {
            if (val == TabCartePartie[i].NomCarte) //retourner la position courante
            {
                return val;
            }
        }
        return "La valeur recherchée n'existe pas";
    }

    //METHODE NON UTILISEE
    // méthode plutôt pour la console 
    boolean ChoisirPion(int l, int c) {
        if (PlateauJeu.Grille[l][c].PionCourant == null) {
            System.out.println("vous n'avez pas sélectionné de pion");
            return false;
        } else if (PlateauJeu.Grille[l][c].PionCourant.CouleurPion == JoueurCourant.CouleurJoueur) {
            return true;
        } else {
            System.out.println("le pion selectionné n'est pas de votre couleur");
            return false;
        }
    }

    
    //METHODE NON UTILISEE
    // méthode plutôt pour la console 
    boolean ChoisirCarteDansJeu(Carte uneCarte) {
        if (uneCarte.NomCarte == CarteExistanteDansJeu(uneCarte)) {
            return true;
        } else {
            System.out.println("Erreur. La carte n'est pas de la partie");
            return false;
        }
    }

    
    //METHODE NON UTILISEE
    // méthode plutôt pour la console 
    String NomCarteChoisieDansJeu(Carte uneCarte) {
        if (ChoisirCarteDansJeu(uneCarte) != true) {
            return "Erreur...Choix de carte non valide";
        }
        return uneCarte.NomCarte;
    }

    // NON UTILISEE
    // méthode plutôt pour la console 
    String NomCarteChoisie(Carte uneCarte) {
        if (JoueurCourant.ChoisirCarteDansMain(uneCarte) != true) {
            return "Erreur...Choix de carte non valide";
        }
        return uneCarte.NomCarte;
    }

    Carte CarteChoisie(String unNomCarte) { // renvoie dans la main du joueur la carte correspondante à celle mise en paramètre
        if (JoueurCourant.CarteEnMain[0].NomCarte == unNomCarte) {
            return JoueurCourant.CarteEnMain[0];
        } else {
            return JoueurCourant.CarteEnMain[1];
        }
    }

    // METHODE NON UTILISEE
    // méthode plutôt pour la console  
    boolean ChoisirPion(Pion unPion) {
        if (unPion.CouleurPion == JoueurCourant.CouleurJoueur) {
            return true;
        } else {
            System.out.println("le pion selectionné n'est pas de votre couleur");
            return false;
        }
    }

    // METHODE NON UTILISEE
    // début d'un gestionnaire d'action pour la console
    //permet le choix d'une carte, puis celui d'un pion et enfin d'une case grise
    void Tour() { 
        System.out.println("Tour de " + JoueurCourant.NomJoueur);
        System.out.println("Choisissez une carte déplacement");
        String ChoixCarte;
        Scanner sc = new Scanner(System.in);
        ChoixCarte = sc.nextLine();
        while (!ChoixCarte.equals(JoueurCourant.CarteEnMain[0].NomCarte) && !ChoixCarte.equals(JoueurCourant.CarteEnMain[1].NomCarte)) {
            System.out.println("Carte invalide. Réessayer.");
            ChoixCarte = sc.nextLine();
        }
        System.out.println("la carte déplacement choisie est " + ChoixCarte);
        Carte CarteDuTour = CarteChoisie(ChoixCarte);

        System.out.println("Choisissez un pion à déplacer");
        int c;
        int l;
        do {
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
            }
        } while (ChoisirPion(l, c) != true);

        PlateauJeu.PlacerCaseGrise(JoueurCourant, l, c, CarteDuTour);
        PlateauJeu.AfficherPlateauSurConsole();

        System.out.println("Choisissez une case grise");

    }

    // METHODE NON UTILISEE (car on ajoute les gestion des boutons dans partie graphique)
    // définit selon le joueur courant le joueur suivant
    void JoueurSuivant() { 
        if (ListeJoueurs[0] == JoueurCourant) {
            JoueurCourant = ListeJoueurs[1];
        } else {
            JoueurCourant = ListeJoueurs[0];
        }
    }

    // Echange la carte venant d'être jouée avec la carte transition
    Carte EchangeCarte() {
        Carte NouvCarteTransit;
        for (int i = 0; i < 5; i++) {
            if (TabCartePartie[i] == CarteCourante) {
                NouvCarteTransit = TabCartePartie[i];
                return NouvCarteTransit;
            }
        }
        CarteCourante = CarteTransition;
        
        return null;
    }
}
