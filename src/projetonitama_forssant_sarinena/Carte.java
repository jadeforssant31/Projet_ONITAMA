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
public class Carte {

    String NomCarte;
    int Matrice[][];
    Carte CarteCourante;
    
    public Carte(String unNom){ // Constructeur qui passe le nom de la carte en paramèttre
        NomCarte = unNom;
    }

    // Second constructeur, finalement pas utilisé
    // Initialisé notamment pour remplir la matrice de déplacement de chaque carte
    // Utile si décision de prendre en compte les matrices de déplacement
    public Carte(String unNom, String uneCouleur, int MatCoord[][]){ 
        NomCarte = unNom;
        Matrice = new int[5][5];
        
        for (int i=0; i<MatCoord.length; i++){
        int x = MatCoord[i][0];
        int y = MatCoord[i][1];
        Matrice[x][y] = 1;
    }
        
}  

String LireCarte(){ //Retourne au joueur le nom de la carte
   return NomCarte;
}      
}
