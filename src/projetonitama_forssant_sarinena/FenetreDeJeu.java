/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetonitama_forssant_sarinena;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;

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
    Pion PionCourant;

    // échange des valeurs des matrices
    
    //int[][] Mante = {{1, 2}, {3, 1}, {3, 3}};
    Carte CarteMante = new Carte("Mante");

    int[][] Singe = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
    Carte CarteSinge = new Carte("Singe");

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
    Carte CarteCrabe = new Carte("Crabe");

    int[][] Elephant = {{2, 1}, {3, 1}, {2, 3}, {3, 3}};
    Carte CarteElephant = new Carte("Elephant", "Rouge", Elephant);

    int[][] Oie = {{1, 2}, {3, 1}, {2, 1}, {2, 3}};
    Carte CarteOie = new Carte("Oie", "Bleu", Oie);

    int[][] Coq = {{1, 1}, {2, 1}, {2, 3}, {3, 3}};
    Carte CarteCoq = new Carte("Coq");

    
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
        panel_carte_transition.setVisible(false);
        panel_carte1_j1.setVisible(false);
        panel_carte2_j1.setVisible(false);
        panel_carte1_j2.setVisible(false);
        panel_carte2_j2.setVisible(false);
        c_transition.setVisible(false);
        btn_c1_j1.setVisible(false);
        btn_c2_j1.setVisible(false);
        btn_c1_j2.setVisible(false);
        btn_c2_j2.setVisible(false);
        // On cache les pannels d'infos partie, joueur ainsi que ceux des cartes, ils seront visible seulement quand l'utilisateur aura appuyé sur le bouton pour demarrer une partie

        DefinirCartesPartie();

        CarteGraphique carte_graphique1_j1 = new CarteGraphique(TabCartePartie[0]);
        panel_carte1_j1.add(carte_graphique1_j1);
        CarteGraphique carte_graphique2_j1 = new CarteGraphique(TabCartePartie[1]);
        panel_carte2_j1.add(carte_graphique2_j1);
        CarteGraphique carte_graphique1_j2 = new CarteGraphique(TabCartePartie[2]);
        panel_carte1_j2.add(carte_graphique1_j2);
        CarteGraphique carte_graphique2_j2 = new CarteGraphique(TabCartePartie[3]);
        panel_carte2_j2.add(carte_graphique2_j2);
        CarteGraphique cartetransition = new CarteGraphique(TabCartePartie[4]);
        panel_carte_transition.add(cartetransition);

        for (int i = 4; i >= 0; i--) { // on décremente car [0;Ø] en java est en haut à gauche, nous l'avons pris en bas a gauche
            for (int j = 0; j < 5; j++) {
                CaseGraphique case_graphique = new CaseGraphique(PlateauJeu.Grille[i][j]);

                case_graphique.addActionListener(new java.awt.event.ActionListener() { // ActionListener permet d'interagir avec la fenêtre graphique de jeu (cliquer sur les cases graphiques)
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Case c = case_graphique.CaseAssociee;
                        if (c.CaseGrise == true) {
                            int lig = PlateauJeu.LireCoordL(c);
                            int col = PlateauJeu.LireCoordC(c);
                            //System.out.println(lig);
                            //System.out.println(col);
                            
                            if (PlateauJeu.PeutDeplacerPion(JoueurCourant, lig, col) == true && PlateauJeu.Grille[lig][col].PionCourant == null) {
                                col = PlateauJeu.useCoordPion[0];
                                lig = PlateauJeu.useCoordPion[1];
                                //String couleur = PlateauJeu.useAttribPion[0];
                                //String role = PlateauJeu.useAttribPion[1];
                                //System.out.println(couleur);
                                //System.out.println(role);

                                PlateauJeu.Grille[lig][col].AffecterPion(PionCourant);
                                c.AffecterPion(PlateauJeu.Grille[lig][col].PionCourant);

                                PlateauJeu.SupprimerPion(lig, col);
                                PlateauJeu.ViderCaseGrise();
                                
                                textemessage.setText("Déplacement effectué");

                                PlateauJeu.takePion(PlateauJeu.Grille[lig][col]);
                                PlateauJeu.takePion(c);

                                panel_carte1_j1.remove(carte_graphique1_j1);
                                panel_carte2_j1.remove(carte_graphique2_j1);
                                panel_carte1_j2.remove(carte_graphique1_j2);
                                panel_carte2_j2.remove(carte_graphique2_j2);
                                panel_carte_transition.remove(cartetransition);
                                ChangementCartes();
                                carte_graphique1_j1.CarteAssociee = TabCartePartie[0];
                                carte_graphique2_j1.CarteAssociee = TabCartePartie[1];
                                carte_graphique1_j2.CarteAssociee = TabCartePartie[2];
                                carte_graphique2_j2.CarteAssociee = TabCartePartie[3];
                                cartetransition.CarteAssociee = TabCartePartie[4];
                                panel_carte1_j1.add(carte_graphique1_j1);
                                panel_carte2_j1.add(carte_graphique2_j1);
                                panel_carte1_j2.add(carte_graphique1_j2);
                                panel_carte2_j2.add(carte_graphique2_j2);
                                panel_carte_transition.add(cartetransition);

                                RafraichissementPanelBouton();
                                
                                int nouvcol = PlateauJeu.useCoordPion[0];
                                int nouvlig = PlateauJeu.useCoordPion[1];
                                //String nouvcouleur = PlateauJeu.useAttribPion[0];
                                //String nouvrole = PlateauJeu.useAttribPion[1];

                                PlateauJeu.ConditionRuisseau(nouvlig, nouvcol);
                                
                                System.out.println(PlateauJeu.ConditionRuisseau(nouvlig, nouvcol));
                                if (PlateauJeu.ConditionRuisseau(nouvlig, nouvcol) == true) {
                                    System.out.println("Victoire par Condition Ruisseau");
                                    textemessage.setText("Victoire par Condition Ruisseau");
                                    FinDePartie();
                                }
                                else {
                                    PlateauJeu.AfficherPlateauSurConsole();
                                    JoueurSuivantEtBouton();
                                }
      
                                //System.out.println(nouvlig);
                                //System.out.println(nouvcol);
                                //System.out.println(nouvcouleur);
                                //System.out.println(nouvrole);

                                
                            } 
                            
                            else if (PlateauJeu.PeutDeplacerPion(JoueurCourant, lig, col) == true) {
                                if (c.PionCourant.Roi == true) {
                                    col = PlateauJeu.useCoordPion[0];
                                    lig = PlateauJeu.useCoordPion[1];
                                    //String couleur = PlateauJeu.useAttribPion[0];
                                    //String role = PlateauJeu.useAttribPion[1];
                                    //System.out.println(couleur);
                                    //System.out.println(role);

                                    c.SupprimerPion();
                                    PlateauJeu.Grille[lig][col].AffecterPion(PlateauJeu.Grille[lig][col].PionCourant);
                                    c.AffecterPion(PlateauJeu.Grille[lig][col].PionCourant);
                                    PlateauJeu.SupprimerPion(lig, col);
                                    PlateauJeu.ViderCaseGrise();
                                    
                                    textemessage.setText("Déplacement effetué");

                                    panel_carte1_j1.remove(carte_graphique1_j1);
                                    panel_carte2_j1.remove(carte_graphique2_j1);
                                    panel_carte1_j2.remove(carte_graphique1_j2);
                                    panel_carte2_j2.remove(carte_graphique2_j2);
                                    panel_carte_transition.remove(cartetransition);
                                    ChangementCartes();
                                    carte_graphique1_j1.CarteAssociee = TabCartePartie[0];
                                    carte_graphique2_j1.CarteAssociee = TabCartePartie[1];
                                    carte_graphique1_j2.CarteAssociee = TabCartePartie[2];
                                    carte_graphique2_j2.CarteAssociee = TabCartePartie[3];
                                    cartetransition.CarteAssociee = TabCartePartie[4];
                                    panel_carte1_j1.add(carte_graphique1_j1);
                                    panel_carte2_j1.add(carte_graphique2_j1);
                                    panel_carte1_j2.add(carte_graphique1_j2);
                                    panel_carte2_j2.add(carte_graphique2_j2);
                                    panel_carte_transition.add(cartetransition);

                                    RafraichissementPanelBouton();

                                    System.out.println("Victoire par Condition Pierre");
                                    textemessage.setText("Victoire par Condition Pierre");
                                    FinDePartie();

                                } else {
                                    col = PlateauJeu.useCoordPion[0];
                                    lig = PlateauJeu.useCoordPion[1];
                                    //String couleur = PlateauJeu.useAttribPion[0];
                                    //String role = PlateauJeu.useAttribPion[1];
                                    //System.out.println(couleur);
                                    //System.out.println(role);

                                    c.SupprimerPion();

                                    PlateauJeu.Grille[lig][col].AffecterPion(PlateauJeu.Grille[lig][col].PionCourant);
                                    c.AffecterPion(PlateauJeu.Grille[lig][col].PionCourant);
                                    PlateauJeu.SupprimerPion(lig, col);
                                    PlateauJeu.ViderCaseGrise();
                                    
                                    textemessage.setText("Déplacement effectué");
         
                                    panel_carte1_j1.remove(carte_graphique1_j1);
                                    panel_carte2_j1.remove(carte_graphique2_j1);
                                    panel_carte1_j2.remove(carte_graphique1_j2);
                                    panel_carte2_j2.remove(carte_graphique2_j2);
                                    panel_carte_transition.remove(cartetransition);
                                    ChangementCartes();
                                    carte_graphique1_j1.CarteAssociee = TabCartePartie[0];
                                    carte_graphique2_j1.CarteAssociee = TabCartePartie[1];
                                    carte_graphique1_j2.CarteAssociee = TabCartePartie[2];
                                    carte_graphique2_j2.CarteAssociee = TabCartePartie[3];
                                    cartetransition.CarteAssociee = TabCartePartie[4];
                                    panel_carte1_j1.add(carte_graphique1_j1);
                                    panel_carte2_j1.add(carte_graphique2_j1);
                                    panel_carte1_j2.add(carte_graphique1_j2);
                                    panel_carte2_j2.add(carte_graphique2_j2);
                                    panel_carte_transition.add(cartetransition);

                                    RafraichissementPanelBouton();

                                    System.out.println("Pion a mangé un Autre Pion");

                                    PlateauJeu.AfficherPlateauSurConsole();
                                    JoueurSuivantEtBouton();
                                }
                            } else {
                                textemessage.setText("Mouvement impossible");
                            }
                        } 
                        else if (c.PionCourant == null) {
                            textemessage.setText("Erreur. Case vide");
                        } 
                        else if (CarteCourante == null && c.PionCourant.CouleurPion.equals(JoueurCourant.CouleurJoueur)) {
                            textemessage.setText("Carte Déplacement non sélectionnée");
                        } 
                        else if (!c.PionCourant.CouleurPion.equals(JoueurCourant.CouleurJoueur)) {
                            textemessage.setText("Le pion sélectionné non valide"); //setText permet d'afficher des String sur une fenêtre de texte   
                        } 
                        else if (c.PionCourant == null) {
                            textemessage.setText("La case sélectionnée est vide");
                        } 
                        else if (c.PionCourant.CouleurPion.equals(JoueurCourant.CouleurJoueur)) {
                            textemessage.setText(JoueurCourant.NomJoueur + " choisit ce pion"); //setText permet d'afficher des String sur une fenêtre de texte
                            int lig = PlateauJeu.LireCoordL(c);
                            int col = PlateauJeu.LireCoordC(c);
                            PlateauJeu.takePion(c);
                            //System.out.println(lig + "!");
                            //System.out.println(col + "!");
                            PlateauJeu.ViderCaseGrise();
                            PlateauJeu.PlacerCaseGrise(JoueurCourant, lig, col, CarteCourante);
                            PlateauJeu.AfficherPlateauSurConsole();
                            
                            RafraichissementPanelBouton();
                        }
                    }
                });
                grille_jeu.add(case_graphique);
            }
        }
    }
 
    void initialiserPartie() {
        // vider Plateau OK
        // Entrée des joueurs et affectation dans tableau OK
        // Sélection des 5 cartes déplacements OK
        // Attribution des couleurs OK
        // Tirage et attribution des cartes OK
        // Determine qui est le premier joueur OK
        // Placer Pions (Rouge en bas/bleu en haut)OK

        // On vide le plateau
        PlateauJeu.ViderPlateau();
        PlateauJeu.PositionnerPionsDepart();

        // création des 2 joueurs et affectation dans tableau
        String nomJoueur1 = nomjoueur1.getText();
        Joueur Joueur1 = new Joueur(nomJoueur1);
        String nomJoueur2 = nomjoueur2.getText();
        Joueur Joueur2 = new Joueur(nomJoueur2);
        ListeJoueurs[0] = Joueur1; // affectation des référence au tableau
        ListeJoueurs[1] = Joueur2;

        //attribution des couleurs
        AttribuerCouleursAuxJoueurs();

        // Attribution des cartes et affectation dela derniere en tant que carte transition
        Joueur1.CarteEnMain[0] = TabCartePartie[0];
        Joueur1.CarteEnMain[1] = TabCartePartie[1];
        Joueur2.CarteEnMain[0] = TabCartePartie[2];
        Joueur2.CarteEnMain[1] = TabCartePartie[3];
        CarteTransition = TabCartePartie[4];

        // On determine qui commence à jouer
        PremierJoueurEtBouton();

        // affiche les noms/couleurs des joueurs dans le pannel des informations joueurs/ informations partie
        lbl_j1_nom.setText(nomJoueur1);
        lbl_j1_couleur.setText(Joueur1.CouleurJoueur);
        lbl_j2_nom.setText(nomJoueur2);
        lbl_j2_couleur.setText(Joueur2.CouleurJoueur);
        lbl_joueur_courant.setText(JoueurCourant.NomJoueur);

        PlateauJeu.AfficherPlateauSurConsole();
    }

    void FinDePartie() {
        textemessage.setText(JoueurCourant.NomJoueur + " gagne la partie !");
        grille_jeu.setEnabled(false);
        c_transition.setEnabled(false);
        btn_c1_j1.setEnabled(false);
        btn_c2_j1.setEnabled(false);
        btn_c1_j2.setEnabled(false);
        btn_c2_j2.setEnabled(false);
    }

    void PremierJoueurEtBouton() {
        // On determine qui commence à jouer
        Random joueur = new Random();
        boolean premier_joueur = joueur.nextBoolean();
        if (premier_joueur) {
            JoueurCourant = ListeJoueurs[0];
            btn_c1_j2.setEnabled(false);
            btn_c2_j2.setEnabled(false);
            btn_c1_j1.setEnabled(true);
            btn_c2_j1.setEnabled(true);
        } 
        else {
            JoueurCourant = ListeJoueurs[1];
            btn_c1_j2.setEnabled(true);
            btn_c2_j2.setEnabled(true);
            btn_c1_j1.setEnabled(false);
            btn_c2_j1.setEnabled(false);
        }
    }
    
        void RafraichissementPanelBouton() {
        grille_jeu.repaint();
        panel_carte1_j1.repaint();
        panel_carte2_j1.repaint();
        panel_carte1_j2.repaint();
        panel_carte2_j2.repaint();
        panel_carte_transition.repaint();
        btn_c1_j1.setEnabled(true);
        btn_c2_j1.setEnabled(true);
        btn_c1_j2.setEnabled(true);
        btn_c2_j2.setEnabled(true);
    }

    Carte EchangeCarte() {
        Carte NouvCarteTransit;
        for (int i = 0; i < 5; i++) {
            if (TabCartePartie[i] == CarteCourante) {
                NouvCarteTransit = TabCartePartie[i];
                return NouvCarteTransit;
            }
        }
        CarteCourante = CarteTransition;
        // la dernière carte jouée devient carte transition
        // changement de main, ajout de la 3e carte à l'autre joueur
        // BD: je vois a peu pres cette méthode. Ne pas oublier qu'il faudra, uen fois les cartes échangées, raffecter carteCourante comme une carte appartenant au joueur courant
        //return uneCarte; 
        return null;
    }

    public void JoueurSuivantEtBouton() {
        // rotation des joueurs
        if (JoueurCourant == ListeJoueurs[0]) {
            JoueurCourant = ListeJoueurs[1];
            btn_c1_j2.setEnabled(true);
            btn_c2_j2.setEnabled(true);
            btn_c1_j1.setEnabled(false);
            btn_c2_j1.setEnabled(false);
        } 
        else {
            JoueurCourant = ListeJoueurs[0];
            btn_c1_j2.setEnabled(false);
            btn_c2_j2.setEnabled(false);
            btn_c1_j1.setEnabled(true);
            btn_c2_j1.setEnabled(true);
        }
        lbl_joueur_courant.setText(JoueurCourant.NomJoueur);
    }

    public void ChangementCartes() {
        Carte nouvCarteTrans;
        nouvCarteTrans = EchangeCarte();
        //System.out.println(nouvCarteTrans.NomCarte);
        if (nouvCarteTrans == JoueurCourant.CarteEnMain[0] && JoueurCourant.CarteEnMain[0] == TabCartePartie[0]) {
            JoueurCourant.CarteEnMain[0] = CarteTransition;
            TabCartePartie[0] = JoueurCourant.CarteEnMain[0];
        } else if (nouvCarteTrans == JoueurCourant.CarteEnMain[0] && JoueurCourant.CarteEnMain[0] == TabCartePartie[1]) {
            JoueurCourant.CarteEnMain[0] = CarteTransition;
            TabCartePartie[1] = JoueurCourant.CarteEnMain[0];
        } else if (nouvCarteTrans == JoueurCourant.CarteEnMain[0] && JoueurCourant.CarteEnMain[0] == TabCartePartie[2]) {
            JoueurCourant.CarteEnMain[0] = CarteTransition;
            TabCartePartie[2] = JoueurCourant.CarteEnMain[0];
        } else if (nouvCarteTrans == JoueurCourant.CarteEnMain[0] && JoueurCourant.CarteEnMain[0] == TabCartePartie[3]) {
            JoueurCourant.CarteEnMain[0] = CarteTransition;
            TabCartePartie[3] = JoueurCourant.CarteEnMain[0];
        } else if (nouvCarteTrans == JoueurCourant.CarteEnMain[1] && JoueurCourant.CarteEnMain[1] == TabCartePartie[0]) {
            JoueurCourant.CarteEnMain[1] = CarteTransition;
            TabCartePartie[0] = JoueurCourant.CarteEnMain[1];
        } else if (nouvCarteTrans == JoueurCourant.CarteEnMain[1] && JoueurCourant.CarteEnMain[1] == TabCartePartie[1]) {
            JoueurCourant.CarteEnMain[1] = CarteTransition;
            TabCartePartie[1] = JoueurCourant.CarteEnMain[1];
        } else if (nouvCarteTrans == JoueurCourant.CarteEnMain[1] && JoueurCourant.CarteEnMain[1] == TabCartePartie[2]) {
            JoueurCourant.CarteEnMain[1] = CarteTransition;
            TabCartePartie[2] = JoueurCourant.CarteEnMain[1];
        } else { //(nouvCarteTrans == JoueurCourant.CarteEnMain[1] && JoueurCourant.CarteEnMain[0] == TabCartePartie[3])
            JoueurCourant.CarteEnMain[1] = CarteTransition;
            TabCartePartie[3] = JoueurCourant.CarteEnMain[1];
        }
        CarteTransition = nouvCarteTrans;
        TabCartePartie[4] = CarteTransition;
        CarteCourante = null;

        //TEST CONSOLE
        /*System.out.println("carte transition " + CarteTransition.NomCarte);
        System.out.println("carte 1 joueur courant " + JoueurCourant.CarteEnMain[0].NomCarte);
        System.out.println("carte 2 joueur courant " + JoueurCourant.CarteEnMain[1].NomCarte);

        System.out.println("tabcarte0 " + TabCartePartie[0].NomCarte);
        System.out.println("tabcarte1 " + TabCartePartie[1].NomCarte);
        System.out.println("tabcarte2 " + TabCartePartie[2].NomCarte);
        System.out.println("tabcarte3 " + TabCartePartie[3].NomCarte);
        System.out.println("cartetransition " + TabCartePartie[4].NomCarte);

        System.out.println("tabcarte0gr " + carte_graphique1_j1.CarteAssociee.NomCarte);
        System.out.println("tabcarte1gr " + carte_graphique2_j1.CarteAssociee.NomCarte);
        System.out.println("tabcarte2gr " + carte_graphique1_j2.CarteAssociee.NomCarte);
        System.out.println("tabcarte3gr " + carte_graphique2_j2.CarteAssociee.NomCarte);
        System.out.println("cartetransitiongr " + cartetransition.CarteAssociee.NomCarte);*/
    }

    void AttribuerCouleursAuxJoueurs() {
        ListeJoueurs[0].CouleurJoueur = "Bleu";
        ListeJoueurs[1].CouleurJoueur = "Rouge";
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
        // création tirage aléatoire parmi le résultat de la méthode SelectionCartePartie
        // attribution au hasard de 2 pour chaque joueur
        // affectation de la carte transition à un des joueurs
    }

    Carte CarteChoisie(String unNomCarte) {
        if (JoueurCourant.CarteEnMain[0].NomCarte == unNomCarte) {
            return JoueurCourant.CarteEnMain[0];
        } else {
            return JoueurCourant.CarteEnMain[1];
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
        textemessage = new javax.swing.JTextArea();
        btn_rejouer = new javax.swing.JButton();
        btn_quitter = new javax.swing.JButton();
        panel_carte1_j1 = new javax.swing.JPanel();
        panel_carte2_j1 = new javax.swing.JPanel();
        panel_carte_transition = new javax.swing.JPanel();
        panel_carte1_j2 = new javax.swing.JPanel();
        panel_carte2_j2 = new javax.swing.JPanel();
        btn_c1_j2 = new javax.swing.JButton();
        btn_c2_j2 = new javax.swing.JButton();
        btn_c1_j1 = new javax.swing.JButton();
        btn_c2_j1 = new javax.swing.JButton();
        c_transition = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_jeu.setBackground(new java.awt.Color(153, 102, 0));
        grille_jeu.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(grille_jeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 480, 480));

        infos_joueurs.setBackground(new java.awt.Color(153, 102, 0));
        infos_joueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Informations Joueur");
        infos_joueurs.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Joueur Bleu");
        infos_joueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Couleur : ");
        infos_joueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        lbl_j1_nom.setBackground(new java.awt.Color(255, 255, 255));
        lbl_j1_nom.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_nom.setText("nomjoueurbleu");
        infos_joueurs.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        lbl_j1_couleur.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j1_couleur.setText("couleurjoueurbleu");
        infos_joueurs.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 153));
        infos_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Joueur Rouge: ");
        infos_joueurs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Couleur : ");
        infos_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lbl_j2_nom.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_nom.setText("nomjoueurrouge");
        infos_joueurs.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        lbl_j2_couleur.setForeground(new java.awt.Color(255, 255, 255));
        lbl_j2_couleur.setText("couleurjoueurrouge");
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

        textemessage.setColumns(20);
        textemessage.setRows(5);
        message.setViewportView(textemessage);

        infos_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 90));

        btn_rejouer.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btn_rejouer.setForeground(new java.awt.Color(153, 51, 0));
        btn_rejouer.setText("Rejouer");
        btn_rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rejouerActionPerformed(evt);
            }
        });
        infos_partie.add(btn_rejouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, 40));

        btn_quitter.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btn_quitter.setForeground(new java.awt.Color(153, 51, 0));
        btn_quitter.setText("Quitter");
        btn_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitterActionPerformed(evt);
            }
        });
        infos_partie.add(btn_quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 90, 40));

        getContentPane().add(infos_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 300, 250));

        panel_carte1_j1.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte1_j1.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panel_carte1_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 300, 170));

        panel_carte2_j1.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte2_j1.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panel_carte2_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 300, 170));

        panel_carte_transition.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte_transition.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(panel_carte_transition, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 300, 170));

        panel_carte1_j2.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte1_j2.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panel_carte1_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 690, 300, 170));

        panel_carte2_j2.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte2_j2.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panel_carte2_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 690, 300, 170));

        btn_c1_j2.setBackground(new java.awt.Color(153, 51, 0));
        btn_c1_j2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_c1_j2.setForeground(new java.awt.Color(255, 255, 255));
        btn_c1_j2.setText("Carte 1");
        btn_c1_j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_c1_j2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_c1_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 130, 40));

        btn_c2_j2.setBackground(new java.awt.Color(153, 51, 0));
        btn_c2_j2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_c2_j2.setForeground(new java.awt.Color(255, 255, 255));
        btn_c2_j2.setText("Carte 2");
        btn_c2_j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_c2_j2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_c2_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 629, 130, 40));

        btn_c1_j1.setBackground(new java.awt.Color(153, 51, 0));
        btn_c1_j1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_c1_j1.setForeground(new java.awt.Color(255, 255, 255));
        btn_c1_j1.setText("Carte 1");
        btn_c1_j1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_c1_j1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_c1_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 130, 40));

        btn_c2_j1.setBackground(new java.awt.Color(153, 51, 0));
        btn_c2_j1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_c2_j1.setForeground(new java.awt.Color(255, 255, 255));
        btn_c2_j1.setText("Carte 2");
        btn_c2_j1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_c2_j1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_c2_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 130, 40));

        c_transition.setBackground(new java.awt.Color(153, 0, 0));
        c_transition.setForeground(new java.awt.Color(255, 255, 255));
        c_transition.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Carte Transition");
        c_transition.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, -1, -1));

        getContentPane().add(c_transition, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 130, 30));

        setBounds(0, 0, 1416, 893);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_demarrerActionPerformed
        // TODO add your handling code here:
        //code qui sera éxécuté une fois que l'utilisateur aura appuyé sur le bouton "démarrer la partie"
        infos_joueurs.setVisible(true);
        infos_partie.setVisible(true);
        panel_carte_transition.setVisible(true);
        panel_carte1_j1.setVisible(true);
        panel_carte2_j1.setVisible(true);
        panel_carte1_j2.setVisible(true);
        panel_carte2_j2.setVisible(true);
        c_transition.setVisible(true);
        btn_c1_j1.setVisible(true);
        btn_c2_j1.setVisible(true);
        btn_c1_j2.setVisible(true);
        btn_c2_j2.setVisible(true);
        initialiserPartie();
        grille_jeu.repaint();
        infos_joueurs.repaint();
        infos_partie.repaint();
        panel_carte1_j1.repaint();
        panel_carte2_j1.repaint();
        panel_carte1_j2.repaint();
        panel_carte2_j2.repaint();
        panel_carte_transition.repaint();
        //rafraichit le plateau de jeu (permet a avoir les elements directement sur le plateau et eviter leur apparition seulement au passage de la souris)
        btn_demarrer.setEnabled(false);
        //on désactive le bouton du demarrage de la partie lorsque celle ci est demarree
        // evite de rafraichir le plateau en cours de partie
    }//GEN-LAST:event_btn_demarrerActionPerformed

    private void nomjoueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjoueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjoueur2ActionPerformed

    private void btn_rejouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rejouerActionPerformed
        // TODO add your handling code here:
        //code qui sera éxécuté une fois que l'utilisateur aura appuyé sur le bouton "démarrer la partie"
        infos_joueurs.setVisible(true);
        infos_partie.setVisible(true);
        grille_jeu.setVisible(true);
        panel_carte_transition.setVisible(true);
        panel_carte1_j1.setVisible(true);
        panel_carte2_j1.setVisible(true);
        panel_carte1_j2.setVisible(true);
        panel_carte2_j2.setVisible(true);
        c_transition.setVisible(true);
        btn_c1_j1.setVisible(true);
        btn_c2_j1.setVisible(true);
        btn_c1_j2.setVisible(true);
        btn_c2_j2.setVisible(true);
        btn_c1_j1.setEnabled(true);
        btn_c2_j1.setEnabled(true);
        btn_c1_j2.setEnabled(true);
        btn_c2_j2.setEnabled(true);
        initialiserPartie();
        grille_jeu.repaint();
        infos_joueurs.repaint();
        infos_partie.repaint();
        panel_carte1_j1.repaint();
        panel_carte2_j1.repaint();
        panel_carte1_j2.repaint();
        panel_carte2_j2.repaint();
        panel_carte_transition.repaint();
        textemessage.setText(" ");
        //rafraichit le plateau de jeu (permet a avoir les elements directement sur le plateau et eviter leur apparition seulement au passage de la souris)
        btn_demarrer.setEnabled(false);
        //on désactive le bouton du demarrage de la partie lorsque celle ci est demarree
        // evite de rafraichir le plateau en cours de partie
    }//GEN-LAST:event_btn_rejouerActionPerformed

    private void btn_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitterActionPerformed
        super.dispose(); // ferme la fenetre de jeu
    }//GEN-LAST:event_btn_quitterActionPerformed

    private void btn_c2_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c2_j2ActionPerformed
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[1].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[1].NomCarte);
    }//GEN-LAST:event_btn_c2_j2ActionPerformed

    private void btn_c1_j1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_j1ActionPerformed
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[0].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[0].NomCarte);
    }//GEN-LAST:event_btn_c1_j1ActionPerformed

    private void btn_c2_j1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c2_j1ActionPerformed
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[1].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[1].NomCarte);
    }//GEN-LAST:event_btn_c2_j1ActionPerformed

    private void btn_c1_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_j2ActionPerformed
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[0].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[0].NomCarte);
    }//GEN-LAST:event_btn_c1_j2ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_c1_j1;
    private javax.swing.JButton btn_c1_j2;
    private javax.swing.JButton btn_c2_j1;
    private javax.swing.JButton btn_c2_j2;
    private javax.swing.JButton btn_demarrer;
    private javax.swing.JButton btn_quitter;
    private javax.swing.JButton btn_rejouer;
    private javax.swing.JPanel c_transition;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_joueur_courant;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nomjoueur1;
    private javax.swing.JTextField nomjoueur2;
    private javax.swing.JPanel panel_carte1_j1;
    private javax.swing.JPanel panel_carte1_j2;
    private javax.swing.JPanel panel_carte2_j1;
    private javax.swing.JPanel panel_carte2_j2;
    private javax.swing.JPanel panel_carte_transition;
    private javax.swing.JTextArea textemessage;
    // End of variables declaration//GEN-END:variables

}
