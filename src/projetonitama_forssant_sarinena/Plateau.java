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
    int[] useCoordPion;

    public Plateau() { // constructeur qui à chaque case du tableau crée une référence objet de classe cellule
        useCoordPion = new int[2];
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c] = new Case();
            }
        }
    }

void takePion(Case uneCase){
if(uneCase != null){
    useCoordPion[0] = LireCoordC(uneCase);
    useCoordPion[1] = LireCoordL(uneCase);
}
else {
    useCoordPion[0] = -1;
    useCoordPion[1] = -1;
}
}


    int LireCoordC(Case uneCase) {
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (uneCase == Grille[l][c]) {
                    return c;
                }
            }
        }
        return -1;
    }

    int LireCoordL(Case uneCase) {
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (uneCase == Grille[l][c]) {
                    return l;

                }
            }
        }
        return -2;
    }

    void PositionnerPionsDepart() { // ajoute les 10 jetons sur le plateau, disposés d'une certaine manière
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Pion RoiRouge = new Pion("Rouge");
                RoiRouge.Roi = true;
                //System.out.println(RoiRouge.EtreRoi());
                Grille[0][2].PionCourant = RoiRouge;
            } else {
                Pion unPionR = new Pion("Rouge");
                Grille[0][i].PionCourant = unPionR;
            }
            if (i == 2) {
                Pion RoiBleu = new Pion("Bleu");
                RoiBleu.Roi = true;
                Grille[4][2].PionCourant = RoiBleu;
            } else {
                Pion unPionB = new Pion("Bleu");
                Grille[4][i].PionCourant = unPionB;
            }
        }
        
        /*//Test pour déplacements
        Grille[2][1].PionCourant = new Pion("Bleu");
        Grille[2][1].PionCourant.Roi = true;
        Grille[2][2].PionCourant = new Pion("Rouge");
        Grille[2][2].PionCourant.Roi = true;*/

    }

    void ViderPlateau() { //vide le plateau en fin de partie // parcours la grille et initialise les données à 0 pour toutes les cellules, les trou noirs et les desintegrateurs
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c].PionCourant = null;
            }
        }
    }
    
    void ViderCaseGrise() { //vide le plateau en fin de partie // parcours la grille et initialise les données à 0 pour toutes les cellules, les trou noirs et les desintegrateurs
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c].CaseGrise = false;
            }
        }
    }

    boolean CaseOccupee(int l, int c) { //renvoie si la case est occupée par un pion (adverse ou non)
        // BD : quelle case ? il manque les coordonnées en paramètre OK
        if (Grille[l][c].PionCourant != null) {
            System.out.println("case occupée par pion");
            return true;
        }
        return false;
    }

    String LireCouleurPion(int l, int c) { // renvoie la couleur du pion 
        // BD : la couleur de quel pion? celui qui est sur quelle cas? idem que précédent OK
        return Grille[l][c].PionCourant.CouleurPion;
    }

//methode alliant AjouterPion et SupprimerPion
// utilisée lors de la capture d'un pion adverse
    boolean RemplacerPion(int l, int c, Pion unPion) { // attention aux références
        // BD : remplacer le pion de quelle case, par quoi ? manque coords et le nouveau pion OK
        if (Grille[l][c].PionCourant == null) {
            return false;
        }
        if (Grille[l][c].PionCourant.CouleurPion == unPion.CouleurPion) {
            return false;
        } else {
            //Grille[l][c] = null;
            unPion = Grille[l][c].PionCourant;
            return true;
        }
    }

    boolean SupprimerPion(int l, int c) { // supprime le pion du plateau
        if (Grille[l][c].PionCourant == null) { // vérifie que case soit non vide
            //System.out.println("Case vide");
            return false;
        } else {
            Grille[l][c].PionCourant = null;
            //System.out.println("Suppression du jeton effectuée");
            return true;
        }
// BD : sur quelle case on supprime le pion ?
    }
    
    //methode alliant ConditionPierre et ConditionRuisseau
    boolean EtreGagnant(int l, int c, Pion unPion) {
        if (ConditionPierre(l, c, unPion) == true || ConditionRuisseau(l, c) == true) {
            return true;
        }
        return false;
    }

    boolean ConditionPierre(int l, int c, Pion unPion) { //condition 1 pour gagner
        if (Grille[l][c].PionCourant.CouleurPion != unPion.CouleurPion && unPion.EtreRoi() == true) {
            return true;
        } else {
            return false;
        }
    }

    boolean ConditionRuisseau(int l, int c) { // condition 2 pour gagner
        if (Grille[l][c].PionCourant.EtreRoi() == true && Grille[l][c].PionCourant.CouleurPion == "Bleu") {
            if (l == 0 && c == 2) {
                return true;
            } else {
                return false;
            }
        }
        if (Grille[l][c].PionCourant.EtreRoi() == true && Grille[l][c].PionCourant.CouleurPion == "Rouge") {
            if (l == 4 && c == 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    void AfficherPlateauSurConsole() {
        // affiche la grille dans la console

        for (int l = 4; l >= 0; l--) { // boucle décrémentée car l'affichage conventionnel et celui pris par les tableaux est inversé
            for (int c = 0; c < 5; c++) {
                if (Grille[l][c].PionCourant == null) {
                    System.out.print(" N ");
                } else if (Grille[l][c].CaseGrise == true) {
                    System.out.print(" G ");
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Rouge" && Grille[l][c].PionCourant.Roi == true) {
                    System.out.print(" A ");
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Rouge") {
                    System.out.print(" B ");
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Bleu" && Grille[l][c].PionCourant.Roi == true) {
                    System.out.print(" Q ");
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Bleu") {
                    System.out.print(" R ");
                }
            }
            System.out.println(" " + (l + 1)); // affichage des numéros de lignes (l+1) car tableau commence à 0
        }

        for (int c = 0; c < 5; c++) {
            System.out.print(" " + (c + 1) + " "); // affichage des colonnes (c+1) car tableau commence à 0
        }
        System.out.println(); // affichage global du tableau
    }

    void PlacerCaseGrise(Joueur unJoueur, int l, int c, Carte uneCarte) {
        if (unJoueur.CouleurJoueur == "Rouge") {
            PlacerCaseGriseRouge(l, c, uneCarte);
        } else {
            PlacerCaseGriseBleu(l, c, uneCarte);
        }
    }

    // cases grises -> visualiser les potentiels mouvements de pions avec les cartes en main
    void PlacerCaseGriseRouge(int l, int c, Carte uneCarte) { // équivalent de déplacerPion
        System.out.println("case rouge");
        String couleur_carte = uneCarte.LireCarte();
        switch (couleur_carte) {
            case "Mante":
                if ((l >= 0 && l < 4) && (c >= 1 && c < 5)) {
                    //Grille[l + 1][c - 1].AffecterCaseGrise();
                    Grille[l + 1][c - 1].CaseGrise = true; //PROBLEME, L'affichage décale les cases...mais l'idée est là
                    //System.out.println("carte Mante");
                    //break;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                    //break;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 5)) {
                    Grille[l - 1][c].CaseGrise = true;
                    //break;
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
                if ((l >= 0 && l < 4) && (c >= 0 && c < 4)) {
                    Grille[l + 1][c + 1].CaseGrise = true;
                }
                System.out.println("carte Coq");
                break;

            case "Crabe":
                if ((l >= 0 && l < 5) && (c >= 1 && c < 5)) {// BIEN CHECK POUR LE -2
                    Grille[l][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { // BIEN CHECK POUR LE +2
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
                if ((l >= 0 && l < 4) && (c >= 2 && c < 5)) { // CHECK LE -2 // changement c-2 -> c<=2 à la place de 1
                    Grille[l + 1][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 3)) { // CHECK LE +2
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
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { // BIEN CHECK POUR LE +2
                    Grille[l][c + 2].CaseGrise = true;
                }
                break;

            case "Tigre":
                if ((l >= 0 && l < 3) && (c >= 0 && c < 5)) { // BIEN CHECK POUR LE +2 DS LIGNE
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

    void PlacerCaseGriseBleu(int l, int c, Carte uneCarte) { // équivalent de déplacerPion
        System.out.println("case bleu");
        String couleur_carte = uneCarte.LireCarte();
        switch (couleur_carte) {
            case "Mante":
                if ((l >= 1 && l < 5) && (c >= 0 && c < 4)) {
                    Grille[l - 1][c + 1].CaseGrise = true;
                    //System.out.println("carte Mante");
                    //break;
                }
                if ((l >= 1 && l < 5) && (c >= 1 && c < 5)) {
                    Grille[l - 1][c - 1].CaseGrise = true;
                    //break;
                }
                if ((l >= 0 && l < 4) && (c >= 0 && c < 5)) {
                    Grille[l + 1][c].CaseGrise = true;
                    //break;
                }
                System.out.println("carte Mante");
                break;

            /*case "Coq":
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
             */
            case "Crabe":
                if ((l >= 0 && l < 5) && (c >= 2 && c < 5)) { // CHECK LE -2
                    Grille[l][c - 2].CaseGrise = true;
                }
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { // CHECK LE +2
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
                if ((l >= 1 && l < 5) && (c >= 2 && c < 5)) {// CHECK LE -2 // changement c<=2 a la place de 1
                    Grille[l - 1][c - 2].CaseGrise = true;
                }
                if ((l >= 1 && l < 5) && (c >= 0 && c < 3)) {// CHECK LE +2
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
                if ((l >= 0 && l < 5) && (c >= 0 && c < 3)) { // BIEN CHECK POUR LE +2
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
                if ((l >= 0 && l < 5) && (c >= 2 && c < 5)) { // BIEN CHECK POUR LE -2
                    Grille[l][c - 2].CaseGrise = true;
                }
                break;

            case "Tigre":
                if ((l >= 2 && l < 5) && (c >= 0 && c < 5)) { // BIEN CHECK POUR LE +2 DS LIGNE
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

   boolean PeutDeplacerPion(Joueur unJoueur, int l, int c) {
       //Grille[l][c].CaseGrise = true;
       System.out.println(Grille[l][c].CaseGrise);
        if (Grille[l][c].PionCourant == null && Grille[l][c].CaseGrise == false){
            System.out.println("Vous ne pouvez pas aller sur la case selectionnée");
            return false;
        } else if (Grille[l][c].PionCourant == null && Grille[l][c].CaseGrise != false){
            System.out.println("La case est vide, le pion peut être affecté");
            return true;
        } else if (Grille[l][c].CaseGrise != false && Grille[l][c].PionCourant.CouleurPion == unJoueur.CouleurJoueur) {
            System.out.println("La case selectionnée possède un de vos pions");
            return false;
        } else {
       //(Grille[l][c].CaseGrise != false && Grille[l][c].PionCourant.CouleurPion != unJoueur.CouleurJoueur)
            System.out.println("Le pion peut être bien affecté. La case choisie est celle d'un pion adverse");
            return true;
        }
    }
   
   
    Pion RemplacerPion(Joueur unJoueur, int l, int c, Pion unPion){
        //Grille[l][c].CaseGrise = false;
        //Grille[l][c].PionCourant = null;
        Pion newPion = new Pion(unJoueur.CouleurJoueur);
        newPion = Grille[l][c].PionCourant;
        return newPion;
    }
    
    

    // BD : on place les case grises à partir d'un pion choisi par ses coordonnées, et d'une carte, non ? OK
    // ou sont ces éléments quand on appelle cette méthode ? DANS CETTE CLASSE
}

// déplacement des cartes dans parties

