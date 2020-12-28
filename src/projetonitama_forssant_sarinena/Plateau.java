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

    public Plateau() { // constructeur qui à chaque case du tableau crée une référence objet de classe cellule
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c] = new Case();
            }
        }
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
        }

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Pion RoiBleu = new Pion("Bleu");
                RoiBleu.Roi = true;
                Grille[4][2].PionCourant = RoiBleu;
            } else {
                Pion unPionB = new Pion("Bleu");
                Grille[4][i].PionCourant = unPionB;
            }
        }
    }

    void ViderPlateau() { //vide le plateau en fin de partie // parcours la grille et initialise les données à 0 pour toutes les cellules, les trou noirs et les desintegrateurs
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                Grille[l][c].PionCourant = null;
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
        if (ConditionPierre(l,c,unPion) == true || ConditionRuisseau(l,c) == true){
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

        for (int l = 5; l >= 0; l--) { // boucle décrémentée car l'affichage conventionnel et celui pris par les tableaux est inversé
            for (int c = 0; c < 5; c++) {
                if (Grille[l][c].PionCourant == null) {
                    System.out.print("N");
                } else if ((Grille[l][c].PionCourant.CouleurPion) != "Rouge") {
                    System.out.print("B");
                } else {
                    System.out.print("R");
                }

            }
            System.out.println(" " + (l + 1)); // affichage des numéros de lignes (l+1) car tableau commence à 0
        }
        for (int c = 0; c < 5; c++) {
            System.out.print((c + 1)); // affichage des colonnes (c+1) car tableau commence à 0
        }
        System.out.println(); // affichage global du tableau
    }

    // cases grises -> visualiser les potentiels mouvements de pions avec les cartes en main
    void PlacerCaseGrise(int l, int c, Carte uneCarte, Pion unPion) { // équivalent de déplacerPion
        if (uneCarte.NomCarte == "Mante" && unPion == Grille[l][c].PionCourant){
        Grille[l+1][c-1].AffecterCaseGrise();
        Grille[l+1][c+1].AffecterCaseGrise();
        Grille[l-1][c].AffecterCaseGrise();    
	}
        if (uneCarte.NomCarte == "Coq" && unPion == Grille[l][c].PionCourant){
        Grille[l][c-1].AffecterCaseGrise();
        Grille[l][c+1].AffecterCaseGrise();
        Grille[l-1][c-1].AffecterCaseGrise();
        Grille[l+1][c+1].AffecterCaseGrise();       
	}
        if (uneCarte.NomCarte == "Crabe" && unPion == Grille[l][c].PionCourant){
        Grille[l][c-2].AffecterCaseGrise();
        Grille[l][c+2].AffecterCaseGrise();
        Grille[l+1][c].AffecterCaseGrise();    
	}
        if (uneCarte.NomCarte == "Sanglier" && unPion == Grille[l][c].PionCourant){
        Grille[l][c-1].AffecterCaseGrise();
        Grille[l][c+1].AffecterCaseGrise();
        Grille[l+1][c].AffecterCaseGrise();    
	}
        if (uneCarte.NomCarte == "Dragon" && unPion == Grille[l][c].PionCourant){
        Grille[l-1][c-1].AffecterCaseGrise();
        Grille[l-1][c+1].AffecterCaseGrise();
        Grille[l+1][c-2].AffecterCaseGrise();
        Grille[l+1][c+2].AffecterCaseGrise();
	}
        
        // A COMPLETER (VA SUREMENT PLANTER A CAUSE DE LA TAILLE DE LA GRILLE)
        
        
        
        
        
        
        }
        

    // BD : on place les case grises à partir d'un pion choisi par ses coordonnées, et d'une carte, non ? OK
    // ou sont ces éléments quand on appelle cette méthode ? DANS CETTE CLASSE
}

// déplacement des cartes dans parties

