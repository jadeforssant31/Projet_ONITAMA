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
public class Case {
    
    Pion PionCourant;
    boolean CaseGrise;
    boolean EstRoi;
    
public Case () { // constructeur qui initialise les attributs
    PionCourant = null;
    CaseGrise = false;
    EstRoi = false;
} 

boolean AffecterPion(Pion unPion){ //affecte le pion à une case suite à un mouvement
    if (PionCourant == null){
       PionCourant = unPion;
       PionCourant.Roi = unPion.Roi;
       PionCourant.CouleurPion = unPion.CouleurPion;
       //System.out.println(PionCourant.Roi);
       //System.out.println(PionCourant.CouleurPion);
        return true;
    }
    else{
      return false;
    }
}

boolean PresenceCaseVide(){
    if (PionCourant == null){
        return true;
    }
    else{
        return false;
    }
}

void AffecterCaseGrise(){
    CaseGrise = true;
}

String LireCouleurDuPion(){ //retourne la couleur du pion joué
    if (PionCourant == null){
        return "vide";
    }
    else{
        return PionCourant.CouleurPion;
    }
}

boolean LireRoleDuPion(){ //retourne la couleur du pion joué
    if (PionCourant == null){
        return false;
    }
    else if (PionCourant.Roi != true) {
        return false;
    }
    else {
        return true;
    }
}

boolean presenceRoi(){
    if (LireRoleDuPion() == true){
        EstRoi = true ;
        return true;
    }
    else {
        return false;
    }
}

boolean presenceCaseGrise(){
    if (CaseGrise == true){
        return true;
    }
    else {
        return false;
    }
}

boolean SupprimerPion(){ //supprime le pion de la case 
    if(PionCourant==null){
        return false;
    }
    else{
        PionCourant=null;
        return true;
    }
}

}
