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
    ImageIcon img_sanglier = new javax.swing.ImageIcon(getClass().getResource("/images/boar.jpg"));
    ImageIcon img_cobra = new javax.swing.ImageIcon(getClass().getResource("/images/cobra.jpg"));
    ImageIcon img_crabe = new javax.swing.ImageIcon(getClass().getResource("/images/crab.jpg"));
    ImageIcon img_Roi_Rouge = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_dragon = new javax.swing.ImageIcon(getClass().getResource("/images/dragon.jpg"));
    ImageIcon img_anguille = new javax.swing.ImageIcon(getClass().getResource("/images/eel.jpg"));
    ImageIcon img_elephant = new javax.swing.ImageIcon(getClass().getResource("/images/elephant.jpg"));
    ImageIcon img_grenouille = new javax.swing.ImageIcon(getClass().getResource("/images/frog.jpg"));
    ImageIcon img_oie = new javax.swing.ImageIcon(getClass().getResource("/images/goose.jpg"));
    ImageIcon img_cheval = new javax.swing.ImageIcon(getClass().getResource("/images/horse.jpg"));
    ImageIcon img_Pion_Bleu = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_Pion_Rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_mante = new javax.swing.ImageIcon(getClass().getResource("/images/mantis.jpg"));
    ImageIcon img_singe = new javax.swing.ImageIcon(getClass().getResource("/images/monkey.jpg"));
    ImageIcon img_boeuf = new javax.swing.ImageIcon(getClass().getResource("/images/ox.jpg"));
    ImageIcon img_lapin = new javax.swing.ImageIcon(getClass().getResource("/images/rabbit.jpg"));
    ImageIcon img_coq = new javax.swing.ImageIcon(getClass().getResource("/images/rooster.jpg"));
    ImageIcon img_tigre = new javax.swing.ImageIcon(getClass().getResource("/images/tiger.jpg"));
    ImageIcon img_Roi_Bleu = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    ImageIcon img_Case_Grise = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));

    public CaseGraphique(Case uneCase) {
        CaseAssociee = uneCase;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (CaseAssociee.EstRoi == true && CaseAssociee.LireCouleurDuPion() == "Rouge") {
            setIcon(img_Roi_Rouge);// on attribue l'image lorsque la condition est vérifiée  
        } else if (CaseAssociee.EstRoi == true && CaseAssociee.LireCouleurDuPion() == "Bleu") {
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
