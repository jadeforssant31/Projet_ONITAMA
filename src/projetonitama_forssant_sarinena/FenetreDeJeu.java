/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_forssant_sarinena;

import java.util.Random;
import java.util.Scanner;
import projetonitama_forssant_sarinena.Carte;
import projetonitama_forssant_sarinena.Joueur;
import projetonitama_forssant_sarinena.Plateau;

/**
 *
 * @author jade
 */
public class FenetreDeJeu extends javax.swing.JFrame {

    Joueur ListeJoueurs[] = new Joueur[2];  // liste de 2 d'objet joueur à 2 cases. Sera initialisée quand les joueurs seront créés
    Plateau PlateauJeu = new Plateau(); // création de la référence objet GrilleJeu
    Joueur JoueurCourant;
    Carte CarteTransition;
    Carte CarteCourante;

    /**
     * Creates new form FenetreDeJeu
     */
    public FenetreDeJeu() {
        initComponents();
        infos_joueurs.setVisible(false);
        infos_partie.setVisible(false);
        carte_transition.setVisible(false);
        carte1_jbleu.setVisible(false);
        carte2_jbleu.setVisible(false);
        carte1_jrouge.setVisible(false);
        carte2_jrouge.setVisible(false);
        // On cache les pannels d'infos partie, joueur ainsi que ceux des cartes, ils seront visible seulement quand l'utilisateur aura appuyé sur le bouton pour demarrer une partie

        for (int i = 4; i >= 0; i--) { // on décremente car [0;Ø] en java est en haut à gauche, nous l'avons pris en bas a gauche
            for (int j = 0; j < 5; j++) {
                CaseGraphique case_graphique = new CaseGraphique(PlateauJeu.Grille[i][j]);
                grille_jeu.add(case_graphique);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grille_jeu = new javax.swing.JPanel();
        infos_joueurs = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        lbl_j1_cartes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        lbl_j2_cartes = new javax.swing.JLabel();
        debuter_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomjoueur1 = new javax.swing.JTextField();
        nomjoueur2 = new javax.swing.JTextField();
        btn_demarrer = new javax.swing.JButton();
        carte1_jbleu = new javax.swing.JPanel();
        carte1_jrouge = new javax.swing.JPanel();
        carte2_jrouge = new javax.swing.JPanel();
        carte_transition = new javax.swing.JPanel();
        carte2_jbleu = new javax.swing.JPanel();
        infos_partie = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_jeu.setBackground(new java.awt.Color(255, 255, 255));
        grille_jeu.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(grille_jeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 172, 480, 480));

        infos_joueurs.setBackground(new java.awt.Color(153, 153, 255));
        infos_joueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Informations Joueur");
        infos_joueurs.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Joueur 1 : ");
        infos_joueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Couleur : ");
        infos_joueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres de cartes en main : ");
        infos_joueurs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lbl_j1_nom.setBackground(new java.awt.Color(255, 255, 255));
        lbl_j1_nom.setForeground(new java.awt.Color(0, 0, 153));
        lbl_j1_nom.setText("nomjoueur1");
        infos_joueurs.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        lbl_j1_couleur.setForeground(new java.awt.Color(0, 0, 153));
        lbl_j1_couleur.setText("couleurjoueur1");
        infos_joueurs.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        lbl_j1_cartes.setForeground(new java.awt.Color(0, 0, 153));
        lbl_j1_cartes.setText("nbcartesj1");
        infos_joueurs.add(lbl_j1_cartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 153));
        infos_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Joueur 2 : ");
        infos_joueurs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Couleur : ");
        infos_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombres de cartes en main : ");
        infos_joueurs.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        lbl_j2_nom.setForeground(new java.awt.Color(0, 0, 153));
        lbl_j2_nom.setText("nomjoueur2");
        infos_joueurs.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        lbl_j2_couleur.setForeground(new java.awt.Color(0, 0, 153));
        lbl_j2_couleur.setText("couleurjoueur2");
        infos_joueurs.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        lbl_j2_cartes.setForeground(new java.awt.Color(0, 0, 153));
        lbl_j2_cartes.setText("nbcartesj2");
        infos_joueurs.add(lbl_j2_cartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        getContentPane().add(infos_joueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 200, 300, 300));

        debuter_partie.setBackground(new java.awt.Color(153, 153, 255));
        debuter_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nom Joueur 2");
        debuter_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, 20));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nom Joueur 1");
        debuter_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, 20));
        debuter_partie.add(nomjoueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, -1));

        nomjoueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomjoueur2ActionPerformed(evt);
            }
        });
        debuter_partie.add(nomjoueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, -1));

        btn_demarrer.setText("Démarrer une Partie");
        btn_demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_demarrerActionPerformed(evt);
            }
        });
        debuter_partie.add(btn_demarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        getContentPane().add(debuter_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 300, 130));

        carte1_jbleu.setBackground(new java.awt.Color(153, 0, 255));
        carte1_jbleu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte1_jbleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 300, 172));

        carte1_jrouge.setBackground(new java.awt.Color(153, 0, 255));
        carte1_jrouge.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte1_jrouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 653, 300, 172));

        carte2_jrouge.setBackground(new java.awt.Color(153, 0, 255));
        carte2_jrouge.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte2_jrouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 653, 300, 172));

        carte_transition.setBackground(new java.awt.Color(153, 51, 255));
        carte_transition.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte_transition, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 172, 300));

        carte2_jbleu.setBackground(new java.awt.Color(153, 51, 255));
        carte2_jbleu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte2_jbleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 300, 172));

        infos_partie.setBackground(new java.awt.Color(153, 153, 255));
        infos_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Informations Partie");
        infos_partie.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Joueur courant :");
        infos_partie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("joueurcourant");
        infos_partie.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        message.setViewportView(jTextArea1);

        infos_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 90));

        getContentPane().add(infos_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 300, 190));

        setBounds(0, 0, 1416, 893);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_demarrerActionPerformed
        // TODO add your handling code here:
        //code qui sera éxécuté une fois que l'utilisateur aura appuyé sur le bouton "démarrer la partie"
        infos_joueurs.setVisible(true);
        infos_partie.setVisible(true);
        carte_transition.setVisible(true);
        carte1_jbleu.setVisible(true);
        carte2_jbleu.setVisible(true);
        carte1_jrouge.setVisible(true);
        carte2_jrouge.setVisible(true);
        initialiserPartie();
    }//GEN-LAST:event_btn_demarrerActionPerformed

    private void nomjoueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjoueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjoueur2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenetreDeJeu().setVisible(true);
            }
        });
    }

    void initialiserPartie() {

        // vider Plateau
        // Placer Pions (Rouge en bas/bleu en haut)
        // Entrée des joueurs et affectation dans liste
        // Sélection des 5 cartes déplacements
        // Attribution des couleurs
        // Attribution des cartes
        // Création et attribution CarteTransition (qui commence ?)
        // Afficher la grille
        
        PlateauJeu.ViderPlateau(); // On vide la grille avant de demarrer une nouvelle partie
        String nomJoueur1 = nomjoueur1.getText();
        Joueur Joueur1 = new Joueur(nomJoueur1); // création des deux objets joueur
        String nomJoueur2 = nomjoueur2.getText();
        Joueur Joueur2 = new Joueur(nomJoueur1);

        ListeJoueurs[0] = Joueur1; // affectation des référence au tableau
        ListeJoueurs[1] = Joueur2;

        AttribuerCouleursAuxJoueurs();

        System.out.println(Joueur1.NomJoueur + " possède les jetons de couleur " + Joueur1.CouleurJoueur);
        System.out.println(Joueur2.NomJoueur + " possède les jetons de couleur " + Joueur2.CouleurJoueur);

       

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_demarrer;
    private javax.swing.JPanel carte1_jbleu;
    private javax.swing.JPanel carte1_jrouge;
    private javax.swing.JPanel carte2_jbleu;
    private javax.swing.JPanel carte2_jrouge;
    private javax.swing.JPanel carte_transition;
    private javax.swing.JPanel debuter_partie;
    private javax.swing.JPanel grille_jeu;
    private javax.swing.JPanel infos_joueurs;
    private javax.swing.JPanel infos_partie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_j1_cartes;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_cartes;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nomjoueur1;
    private javax.swing.JTextField nomjoueur2;
    // End of variables declaration//GEN-END:variables

}
