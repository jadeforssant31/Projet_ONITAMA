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
public class Plateau {

    Case Grille[][] = new Case[5][5];
    int[] useCoordPion; // tableau d'entiers qui recensent les coordonnées d'un pion grâce à la méthode TakePion
    String[] useAttribPion; // tableau de String qui recensent les attributs d'un pion grâce à la méthode TakePion

    public Plateau() { // constructeur qui à chaque position du tableau crée une référence objet de classe Case
        
        useCoordPion = new int[2]; //ncréation du tableau coordonnées
        useAttribPion = new String[2]; // création du tableau attribut
        
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c] = new Case();
            }
        }
    }

// méthode qui va récupérer et mettre dans les tableaux coord et attributs les éléments de la case souhaitée
// méthode importante notamment pour déplacement de pion et remplacement de pion 
    void takePion(Case uneCase) {
        if (uneCase != null && uneCase.PionCourant != null) { // si la case possède un pion alors on récupère tout
            useCoordPion[0] = LireCoordC(uneCase);
            useCoordPion[1] = LireCoordL(uneCase);
            useAttribPion[0] = uneCase.PionCourant.CouleurPion;
            useAttribPion[1] = uneCase.PionCourant.LireRolePion();
        } else if (uneCase != null) { // si la case ne possède pas de pion
            useCoordPion[0] = LireCoordC(uneCase);
            useCoordPion[1] = LireCoordL(uneCase);
        } else { // cas n'arrivant jamais, signalement d'erreurs
            useCoordPion[0] = -1;
            useCoordPion[1] = -1;
            useAttribPion[0] = "pb couleur";
            useAttribPion[1] = "pb role";
        }
    }
    
    // retourne la coordonnée colonne de la case associee
    int LireCoordC(Case uneCase) {
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (uneCase == Grille[l][c]) {
                    return c;
                }
            }
        }
        return -1; // sinon retour -1 sur la console pour détecter les eventuelles erreurs
    }

    // retourne la coordonnée ligne de la case associée
    int LireCoordL(Case uneCase) {
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (uneCase == Grille[l][c]) {
                    return l;

                }
            }
        }
        return -2; // sinon retour -2 sur la console pour détecter les éventuelles erreurs
    }

    
    // création des 10 pions sur le plateau (8 pions + 2 rois), disposés d'une certaine manière
    void PositionnerPionsDepart() { 
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Pion RoiRouge = new Pion("Rouge");
                RoiRouge.Roi = true;
                Grille[0][2].PionCourant = RoiRouge; // Roi rouge placé en bas au centre du plateau
                Pion RoiBleu = new Pion("Bleu");
                RoiBleu.Roi = true;
                Grille[4][2].PionCourant = RoiBleu; // Roi bleu placé en haut au centre du plateau
            } else {
                Pion unPionR = new Pion("Rouge");
                Grille[0][i].PionCourant = unPionR; // placement des pions rouges sur la ligne du bas
                Pion unPionB = new Pion("Bleu");
                Grille[4][i].PionCourant = unPionB; // placement des pions bleus sur la ligne du haut
            }
        }
    }
    
// méthode qui parcourt la grille et initialise les données à 0 pour toutes les cases
    void ViderPlateau() { 
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c].PionCourant = null;
            }
        }
    }

// parcourt la grille et initialise les données à 0 pour les cellules dont Grille[l][c].CaseGrise renvoyaient true 
    void ViderCaseGrise() { 
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c].CaseGrise = false;
            }
        }
    }

    // renvoie true si la case est occupée par un pion, false sinon
    boolean CaseOccupee(int l, int c) { 
        if (Grille[l][c].PionCourant != null) {
            System.out.println("case occupée par pion");
            return true;
        }
        return false;
    }

    // renvoie la couleur du pion courant
    String LireCouleurPion(int l, int c) { 
        return Grille[l][c].PionCourant.CouleurPion;
    }

    // On supprime le pion du plateau de jeu
    boolean SupprimerPion(int l, int c) { 
        if (Grille[l][c].PionCourant == null) { // vérifie que case soit non vide
            return false;
        } else {
            Grille[l][c].PionCourant = null;
            return true;
        }
    }

    // Condition gagnante 1: Le roi atteint la position initiale du roi adverse
    boolean ConditionRuisseau(int l, int c) {
        if (Grille[l][c].PionCourant.EtreRoi() == true && Grille[l][c].PionCourant.CouleurPion == "Bleu") {
            if (l == 0 && c == 2) {
                System.out.println("Le joueur possédant les pions bleus gagne !");
                return true;
            } else {
                return false;
            }
        }
        if (Grille[l][c].PionCourant.EtreRoi() == true && Grille[l][c].PionCourant.CouleurPion == "Rouge") {
            if (l == 4 && c == 2) {
                System.out.println("Le joueur possédant les pions rouges gagne ! ");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    
    // Affichage sur console
    void AfficherPlateauSurConsole() {
        for (int l = 4; l >= 0; l--) { // boucle décrémentée car l'affichage conventionnel et celui pris par les tableaux est inversé
            for (int c = 0; c < 5; c++) {
                if (Grille[l][c].PionCourant == null && Grille[l][c].CaseGrise == true) {
                    System.out.print(" G "); // Case grise
                } else if (Grille[l][c].PionCourant == null){
                    System.out.print(" N "); // Case vide
                } else if (Grille[l][c].CaseGrise == true) {
                    System.out.print(" G "); //Case grise
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Rouge" && Grille[l][c].PionCourant.Roi == true) {
                    System.out.print(" A "); // Roi Rouge
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Rouge") {
                    System.out.print(" B "); //Pion Rouge
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Bleu" && Grille[l][c].PionCourant.Roi == true) {
                    System.out.print(" Q "); // Roi Bleu
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Bleu") {
                    System.out.print(" R "); //Pion Bleu
                }
            }
            System.out.println(" " + (l + 1)); // affichage des numéros de lignes (l+1) car tableau commence à 0
        }

        for (int c = 0; c < 5; c++) {
            System.out.print(" " + (c + 1) + " "); // affichage des colonnes (c+1) car tableau commence à 0
        }
        System.out.println(); // affichage global du tableau
    }

    // Méthode rassemblant les 2 méthodes qui placent les cases grises selon les couleurs des joueurs
    // Bleu est en inversé de rouge
    void PlacerCaseGrise(Joueur unJoueur, int l, int c, Carte uneCarte) {
        if (unJoueur.CouleurJoueur == "Rouge") {
            PlacerCaseGriseRouge(l, c, uneCarte);
        } else {
            PlacerCaseGriseBleu(l, c, uneCarte);
        }
    }

    // cases grises -> visualiser les potentiels mouvements de pions avec les cartes en main
    void PlacerCaseGriseRouge(int l, int c, Carte uneCarte) { 
        System.out.println("case rouge");
        String couleur_carte = uneCarte.LireCarte();
        switch (couleur_carte) {
            case "Mante":
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) { // on restreint les coordonnées possibles pour éviter erreur de longueur de grille
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                //System.out.println("carte Mante"); //Vérification sur console 
                break;

            case "Coq":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                //System.out.println("carte Coq");
                break;

            case "Crabe":
                if ((l >= 0 && l < 5) && (c >= 2 && c < 5)) {
                    Grille[l][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { 
                    Grille[l][c + 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                System.out.println("carte Crabe");
                break;

            case "Sanglier":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                break;

            case "Dragon":
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 2 && c < 5)) { 
                    Grille[l + 1][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 3)) {
                    Grille[l + 1][c + 2].CaseGrise = true;
                }
                break;

            case "Cobra":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Anguille":
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                break;

            case "Elephant":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                break;

            case "Grenouille":
                if ((l >= 0 && l < 5) && (c >= 2 && c < 5)) {
                    Grille[l][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Oie":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Cheval":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                break;

            case "Singe":
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Boeuf":
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                break;

            case "Lapin":
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { 
                    Grille[l][c + 2].CaseGrise = true;
                }
                break;

            case "Tigre":
                if ((l >= 0 && l < 3) && (c >= 0 && c < 5)) { 
                    Grille[l + 2][c].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                break;

            default: //case grue
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                break;
        }
    }

    // Visualise les potentiels mouvements
    // En miroir de la PlacerCaseGriseRouge()
    void PlacerCaseGriseBleu(int l, int c, Carte uneCarte) { 
        System.out.println("case bleu");
        String couleur_carte = uneCarte.LireCarte();
        switch (couleur_carte) {
            case "Mante":
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                    //System.out.println("carte Mante");
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                System.out.println("carte Mante");
                break;

            case "Coq":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                System.out.println("carte Coq");
                break;

            case "Crabe":
                if ((l >= 0 && l < 5) && (c >= 2 && c < 5)) { 
                    Grille[l][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { 
                    Grille[l][c + 2].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                System.out.println("carte Crabe");
                break;

            case "Sanglier":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                break;

            case "Dragon":
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 2 && c < 5)) {
                    Grille[l - 1][c - 2].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 3)) {
                    Grille[l - 1][c + 2].CaseGrise = true;
                }
                break;

            case "Cobra":
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                break;

            case "Anguille":
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                break;

            case "Elephant":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                break;

            case "Grenouille":
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { 
                    Grille[l][c + 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Oie":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Cheval":
                if ((l >= 0 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                break;

            case "Singe":
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                }
                break;

            case "Boeuf":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                break;

            case "Lapin":
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 2 && c < 5)) { 
                    Grille[l][c - 2].CaseGrise = true;
                }
                break;

            case "Tigre":
                if ((l >= 2 && l < 5) && (c >= 0 && c < 5)) { 
                    Grille[l - 2][c].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                }
                break;

            default: //case grue
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    Grille[l + 1][c - 1].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                }
                break;

        }

    }

    // renvoie true si le pion peut être déplacé, false sinon
    boolean PeutDeplacerPion(Joueur unJoueur, int l, int c) {
        if (Grille[l][c].PionCourant == null && Grille[l][c].CaseGrise == false) { //La case sélectionée n'est pas grise 
            System.out.println("Vous ne pouvez pas aller sur la case selectionnée");
            return false;
        } else if (Grille[l][c].PionCourant == null && Grille[l][c].CaseGrise != false) { //La case sélectionée est vide et grise
            System.out.println("La case est vide, le pion peut être affecté");
            return true;
        } else if (Grille[l][c].CaseGrise != false && Grille[l][c].PionCourant.CouleurPion == unJoueur.CouleurJoueur) { //La case selectionée est grise et possède un pion de ma couleur
            System.out.println("La case selectionnée possède un de vos pions");
            return false;
        } else { //(Grille[l][c].CaseGrise != false && Grille[l][c].PionCourant.CouleurPion != unJoueur.CouleurJoueur) // Case Grise et possède un pion adverse
            System.out.println("Le pion peut être bien affecté. La case choisie est celle d'un pion adverse");
            return true;
        }
    }
}

