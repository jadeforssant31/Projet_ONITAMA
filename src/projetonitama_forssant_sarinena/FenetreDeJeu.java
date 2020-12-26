/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_forssant_sarinena;

import java.util.ArrayList;
import java.util.Random;

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
    Carte TabCartePartie[] = new Carte[5];

    // échange des valeurs des matrices
    int[][] Mante = {{1, 2}, {3, 1}, {3, 3}};
    Carte CarteMante = new Carte("Mante", "Rouge", Mante);

    int[][] Singe = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
    Carte CarteSinge = new Carte("Singe", "Bleu", Singe);

    int[][] Cheval = {{2, 1}, {1, 2}, {3, 2}};
    Carte CarteCheval = new Carte("Cheval", "Rouge", Cheval);

    int[][] Boeuf = {{1, 2}, {3, 2}, {2, 3}};
    Carte CarteBoeuf = new Carte("Boeuf", "Bleu", Boeuf);

    int[][] Grue = {{1, 1}, {3, 2}, {1, 3}};
    Carte CarteGrue = new Carte("Grue", "Bleu", Grue);

    int[][] Sanglier = {{2, 1}, {2, 3}, {3, 2}};
    Carte CarteSanglier = new Carte("Sanglier", "Rouge", Sanglier);

    int[][] Anguille = {{1, 1}, {3, 1}, {2, 3}};
    Carte CarteAnguille = new Carte("Anguille", "Bleu", Anguille);

    int[][] Cobra = {{2, 1}, {1, 3}, {3, 3}};
    Carte CarteCobra = new Carte("Cobra", "Rouge", Cobra);

    int[][] Tigre = {{1, 2}, {4, 2}};
    Carte CarteTigre = new Carte("Tigre", "Bleu", Tigre);

    int[][] Dragon = {{3, 0}, {1, 1}, {1, 3}, {3, 4}};
    Carte CarteDragon = new Carte("Dragon", "Rouge", Dragon);

    int[][] Grenouille = {{2, 0}, {1, 3}, {3, 1}};
    Carte CarteGrenouille = new Carte("Grenouille", "Bleu", Grenouille);

    int[][] Lapin = {{1, 1}, {3, 3}, {2, 4}};
    Carte CarteLapin = new Carte("Lapin", "Bleu", Lapin);

    int[][] Crabe = {{2, 0}, {3, 2}, {2, 2}};
    Carte CarteCrabe = new Carte("Crabe", "Bleu", Crabe);

    int[][] Elephant = {{2, 1}, {3, 1}, {2, 3}, {3, 3}};
    Carte CarteElephant = new Carte("Elephant", "Rouge", Elephant);

    int[][] Oie = {{1, 2}, {3, 1}, {2, 1}, {2, 3}};
    Carte CarteOie = new Carte("Oie", "Bleu", Oie);

    int[][] Coq = {{1, 1}, {2, 1}, {2, 3}, {3, 3}};
    Carte CarteCoq = new Carte("Coq", "Rouge", Coq);

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
    
    
    /**
     * Creates new form FenetreDeJeu
     */
    public FenetreDeJeu() {
        initComponents();
        infos_joueurs.setVisible(false);
        infos_partie.setVisible(false);
        carte_transition.setVisible(false);
        carte1_j1.setVisible(false);
        carte2_j1.setVisible(false);
        carte1_j2.setVisible(false);
        carte2_j2.setVisible(false);
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
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        debuter_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomjoueur1 = new javax.swing.JTextField();
        nomjoueur2 = new javax.swing.JTextField();
        btn_demarrer = new javax.swing.JButton();
        infos_partie = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_joueur_courant = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        carte2_j1 = new javax.swing.JButton();
        carte_transition = new javax.swing.JButton();
        carte1_j2 = new javax.swing.JButton();
        carte2_j2 = new javax.swing.JButton();
        carte1_j1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_jeu.setBackground(new java.awt.Color(153, 102, 0));
        grille_jeu.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(grille_jeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 480, 480));

        infos_joueurs.setBackground(new java.awt.Color(153, 102, 0));
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

        lbl_j1_nom.setBackground(new java.awt.Color(255, 255, 255));
        lbl_j1_nom.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_nom.setText("nomjoueur1");
        infos_joueurs.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        lbl_j1_couleur.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_couleur.setText("couleurjoueur1");
        infos_joueurs.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 153));
        infos_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Joueur 2 : ");
        infos_joueurs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Couleur : ");
        infos_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lbl_j2_nom.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_nom.setText("nomjoueur2");
        infos_joueurs.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        lbl_j2_couleur.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_couleur.setText("couleurjoueur2");
        infos_joueurs.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        getContentPane().add(infos_joueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 260, 300, 230));

        debuter_partie.setBackground(new java.awt.Color(153, 102, 0));
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

        btn_demarrer.setBackground(new java.awt.Color(204, 153, 0));
        btn_demarrer.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_demarrer.setForeground(new java.awt.Color(153, 51, 0));
        btn_demarrer.setText("Démarrer une Partie");
        btn_demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_demarrerActionPerformed(evt);
            }
        });
        debuter_partie.add(btn_demarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 210, 60));

        getContentPane().add(debuter_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 300, 170));

        infos_partie.setBackground(new java.awt.Color(153, 102, 0));
        infos_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Informations Partie");
        infos_partie.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Joueur courant :");
        infos_partie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_joueur_courant.setForeground(new java.awt.Color(255, 255, 255));
        lbl_joueur_courant.setText("joueurcourant");
        infos_partie.add(lbl_joueur_courant, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        message.setViewportView(jTextArea1);

        infos_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 90));

        getContentPane().add(infos_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 300, 190));

        carte2_j1.setBackground(new java.awt.Color(204, 102, 0));
        carte2_j1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(carte2_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 300, 174));

        carte_transition.setBackground(new java.awt.Color(204, 102, 0));
        carte_transition.setForeground(new java.awt.Color(255, 255, 255));
        carte_transition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carte_transitionActionPerformed(evt);
            }
        });
        getContentPane().add(carte_transition, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 174, 300));

        carte1_j2.setBackground(new java.awt.Color(204, 102, 0));
        carte1_j2.setForeground(new java.awt.Color(255, 255, 255));
        carte1_j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carte1_j2ActionPerformed(evt);
            }
        });
        getContentPane().add(carte1_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 300, 174));

        carte2_j2.setBackground(new java.awt.Color(204, 102, 0));
        carte2_j2.setForeground(new java.awt.Color(255, 255, 255));
        carte2_j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carte2_j2ActionPerformed(evt);
            }
        });
        getContentPane().add(carte2_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 680, 300, 174));

        carte1_j1.setBackground(new java.awt.Color(204, 102, 0));
        carte1_j1.setForeground(new java.awt.Color(255, 255, 255));
        carte1_j1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carte1_j1ActionPerformed(evt);
            }
        });
        getContentPane().add(carte1_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 300, 174));

        setBounds(0, 0, 1416, 893);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_demarrerActionPerformed
        // TODO add your handling code here:
        //code qui sera éxécuté une fois que l'utilisateur aura appuyé sur le bouton "démarrer la partie"
        infos_joueurs.setVisible(true);
        infos_partie.setVisible(true);
        carte_transition.setVisible(true);
        carte1_j1.setVisible(true);
        carte2_j1.setVisible(true);
        carte1_j2.setVisible(true);
        carte2_j2.setVisible(true);
        initialiserPartie();
        grille_jeu.repaint(); 
        //rafraichit le plateau de jeu (permet a avoir les elements directement sur le plateau et eviter leur apparition seulement au passage de la souris)
        btn_demarrer.setEnabled(false); 
        //on désactive le bouton du demarrage de la partie lorsque celle ci est demarree
        // evite de rafraichir le plateau en cours de partie
    }//GEN-LAST:event_btn_demarrerActionPerformed

    private void nomjoueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjoueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjoueur2ActionPerformed

    private void carte_transitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carte_transitionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carte_transitionActionPerformed

    private void carte1_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carte1_j2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carte1_j2ActionPerformed

    private void carte2_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carte2_j2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carte2_j2ActionPerformed

    private void carte1_j1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carte1_j1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carte1_j1ActionPerformed

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
        // vider Plateau OK
        // Entrée des joueurs et affectation dans tableau OK
        // Sélection des 5 cartes déplacements OK
        // Attribution des couleurs OK
        // Tirage et attribution des cartes OK
        // Determine qui est le premier joueur
        // Placer Pions (Rouge en bas/bleu en haut)
        
        // On vide le plateau
        PlateauJeu.ViderPlateau(); 
        
        // création des 2 joueurs et affectation dans tableau
        String nomJoueur1 = nomjoueur1.getText();
        Joueur Joueur1 = new Joueur(nomJoueur1); 
        String nomJoueur2 = nomjoueur2.getText();
        Joueur Joueur2 = new Joueur(nomJoueur2);
        ListeJoueurs[0] = Joueur1; // affectation des référence au tableau
        ListeJoueurs[1] = Joueur2;

        //attribution des couleurs
        AttribuerCouleursAuxJoueurs(); 
        
        // Tirage des cartes
        DefinirCartesPartie(); 
        //System.out.println(ListeCartes);
        
        // Attribution des cartes et affectation dela derniere en tant que carte transition
        Joueur1.CarteEnMain[0] = TabCartePartie[0];
        Joueur1.CarteEnMain[1] = TabCartePartie[1];
        Joueur2.CarteEnMain[0] = TabCartePartie[2];
        Joueur2.CarteEnMain[1] = TabCartePartie[3];
        CarteTransition = TabCartePartie[4];
        
        // On determine qui commence à jouer
        Random joueur = new Random();
        boolean premier_joueur=joueur.nextBoolean();
        if(premier_joueur){
            JoueurCourant = ListeJoueurs[0];  
        } else{
            JoueurCourant = ListeJoueurs[1];
        }
       
        
        // Placer les pions
        
        // affichage sur console ----- suivi du bon déroulement du jeu
        System.out.println(Joueur1.NomJoueur + " possède les cartes " + Joueur1.CarteEnMain[0].NomCarte + " et " + Joueur1.CarteEnMain[1].NomCarte);
        System.out.println(Joueur2.NomJoueur + " possède les cartes " + Joueur2.CarteEnMain[0].NomCarte + " et " + Joueur2.CarteEnMain[1].NomCarte);
        System.out.println("La carte transition est " + CarteTransition.NomCarte);

        System.out.println(Joueur1.NomJoueur + " possède les pions de couleur " + Joueur1.CouleurJoueur);
        System.out.println(Joueur2.NomJoueur + " possède les pions de couleur " + Joueur2.CouleurJoueur);
        
        // affiche les noms/couleurs des joueurs dans le pannel des informations joueurs/ informations partie
        lbl_j1_nom.setText(nomJoueur1);
        lbl_j1_couleur.setText(Joueur1.CouleurJoueur);
        lbl_j2_nom.setText(nomJoueur2);
        lbl_j2_couleur.setText(Joueur2.CouleurJoueur);
        lbl_joueur_courant.setText(JoueurCourant.NomJoueur);

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

void DefinirCartesPartie() {
        Random rand = new Random();
        int NbreCartes = 5;

        for (int i = 0; i < NbreCartes; i++) {
            int randomIndex = rand.nextInt(ListeCartes.size());
            Carte randomElement = ListeCartes.get(randomIndex);
            TabCartePartie[i] = randomElement;
            //System.out.println(TabCartePartie[i].NomCarte);
            ListeCartes.remove(randomIndex);
        }
        
        //return (TabCartePartie);
        // création tirage aléatoire parmi le résultat de la méthode SelectionCartePartie
        // attribution au hasard de 2 pour chaque joueur
        // affectation de la carte transition à un des joueurs
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_demarrer;
    private javax.swing.JButton carte1_j1;
    private javax.swing.JButton carte1_j2;
    private javax.swing.JButton carte2_j1;
    private javax.swing.JButton carte2_j2;
    private javax.swing.JButton carte_transition;
    private javax.swing.JPanel debuter_partie;
    private javax.swing.JPanel grille_jeu;
    private javax.swing.JPanel infos_joueurs;
    private javax.swing.JPanel infos_partie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_joueur_courant;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nomjoueur1;
    private javax.swing.JTextField nomjoueur2;
    // End of variables declaration//GEN-END:variables

}
