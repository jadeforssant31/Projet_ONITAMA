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
       //System.out.println("pion affecté");
        return true;
    }
    else{
      //System.out.println("Un pion est déjà présent"); 
      return false;
    }
}

String LireCouleurDuPion(){ //retourne la couleur du pion joué
    if (PionCourant == null){
        return "vide";
    }
    else{
        return PionCourant.CouleurPion;
    }
}

boolean presenceRoi(){
    if (EstRoi == true){
        //System.out.println("Désintégrateur présent");
        return true;
    }
    else {
        //System.out.println("Désintégrateur absent");
        return false;
    }
}

boolean presenceCaseGrise(){
    if (CaseGrise == true){
        //System.out.println("Désintégrateur présent");
        return true;
    }
    else {
        //System.out.println("Désintégrateur absent");
        return false;
    }
}

boolean SupprimerPion(){ //supprime le pion de la case 
    if(PionCourant==null){
        //System.out.println("Case vide");
        return false;
    }
    else{
        PionCourant=null;
        //System.out.println("Suppression du pion effectuée");
        return true;
    }
}
// methode alliant AffecterPion() et SupprimerPion()
//utilisée quand un pion arrive sur une case où un autre est deja present

/*boolean RemplacerPion(){ // en suspens (Normalement pas la peine de la faire exister)
    // BD : s'il s'agit de remplacer le pion présent, il faut que le pion remplacant soit en paramètre
    // autre chose : que fait-on du pion premplacé? on le dégage ? on le récupère poru le stocker ailleurs?
    // (il n'y a pas une bonne et une mauvaise réponse, tout dépend
    return true;
}*/

}
