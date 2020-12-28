/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_forssant_sarinena;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author jade
 */
public class CaseGraphique extends JButton {

    Case CaseAssociee;
    //--------------
    // Trou noir = Roi Bleu
    // jeton jaune = pions bleus
    // Desintegrateur = Roi Rouge
    // jeton rouge = pions rouges
    
    ImageIcon img_Roi_Rouge = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_Roi_Bleu = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    ImageIcon img_Pion_Bleu = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_Pion_Rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
   
    // case grise necessaire?
    ImageIcon img_Case_Grise = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));

    
    public CaseGraphique(Case uneCase) {
        CaseAssociee = uneCase;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (CaseAssociee.presenceRoi() == true && CaseAssociee.LireCouleurDuPion() == "Rouge") {
            setIcon(img_Roi_Rouge);// on attribue l'image lorsque la condition est vérifiée  
        } else if (CaseAssociee.presenceRoi() == true && CaseAssociee.LireCouleurDuPion() == "Bleu") {
            setIcon(img_Roi_Bleu);
        } else {
            String couleur_pion = CaseAssociee.LireCouleurDuPion();
            switch (couleur_pion) {
                case "Rouge":
                    setIcon(img_Pion_Rouge);
                    break;
                case "Bleu":
                    setIcon(img_Pion_Bleu);
                    break;
            }
        }
    }

}
