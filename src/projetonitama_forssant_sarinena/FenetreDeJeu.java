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
    //PileCarte unePileCarte = new PileCarte();
    //Partie unePartie = new Partie();

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
        panel_carte_transition.setVisible(false);
        panel_carte1_j1.setVisible(false);
        panel_carte2_j1.setVisible(false);
        panel_carte1_j2.setVisible(false);
        panel_carte2_j2.setVisible(false);
        btn_c1_j1.setVisible(false);
        btn_c2_j1.setVisible(false);
        btn_c1_j2.setVisible(false);
        btn_c2_j2.setVisible(false);
        btn_carte_transition.setVisible(false);
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

        
       
        
        
        
        carte_graphique1_j1.addActionListener(new java.awt.event.ActionListener() { // ActionListener permet d'interagir avec la fenêtre graphique de jeu (cliquer sur les cases graphiques)
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carte c = carte_graphique1_j1.CarteAssociee;
                if (c.CarteCourante == null) {
                    return;
                }

                if (c.equals(JoueurCourant.CarteEnMain[0])) {
                    textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[0].LireCarte()); //setText permet d'afficher des String sur une fenêtre de texte
                    //Jeton jetonrecup = c.recupererJeton();
                    //joueurCourant.ajouterJeton(jetonrecup);
                    JoueurSuivant();
                }
                /*else {
                    if (joueurCourant.nombreDesintegrateurs > 0) {
                        textemessage.setText(joueurCourant.Nom + " désintègre un jeton adverse");
                        c.supprimerJeton();
                        joueurCourant.utiliserDesintegrateur();
                        CouleurSuivante();
                    } else {
                        return;
                    }
                }
                GrilleJeu.tasserGrille();
                panneau_grille.repaint(); // rafraîchit, actualise le panneau d'affichage
                lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + ""); // double guillements force conversion en String
                lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + ""); // double guillements force conversion en String

                boolean vict_j1 = GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]);
                boolean vict_j2 = GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]);

                if (vict_j1 && !vict_j2) {
                    textemessage.setText("Victoire de " + ListeJoueurs[0].Nom);
                }
                if (vict_j2 && !vict_j1) {
                    textemessage.setText("Victoire de " + ListeJoueurs[1].Nom);
                }
                if (vict_j1 && vict_j2) {
                    if (joueurCourant == ListeJoueurs[0]) {
                        textemessage.setText("Victoire par faute de " + ListeJoueurs[1].Nom); // explicite les règles aux joueurs
                    } else {
                        textemessage.setText("Victoire par faute de " + ListeJoueurs[0].Nom); // explicite les règles aux joueurs
                    }
                }*/

            }
        });

        for (int i = 4; i >= 0; i--) { // on décremente car [0;Ø] en java est en haut à gauche, nous l'avons pris en bas a gauche
            for (int j = 0; j < 5; j++) {
                CaseGraphique case_graphique = new CaseGraphique(PlateauJeu.Grille[i][j]);

                /*case_graphique.addActionListener(new java.awt.event.ActionListener() { // ActionListener permet d'interagir avec la fenêtre graphique de jeu (cliquer sur les cases graphiques)
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Case c = case_graphique.CaseAssociee;
                        if (c.PionCourant == null) {
                            return;
                        }
                        if (c.PionCourant.CouleurPion.equals(JoueurCourant.CouleurJoueur)) {
                            textemessage.setText(JoueurCourant.Nom + " choisit ce pion"); //setText permet d'afficher des String sur une fenêtre de texte
                            PlateauJeu.PlacerCaseGrise(JoueurCourant, l, c, CarteCourante); // trouver moyen de changer les coordonnées
                            Jeton jetonrecup = c.recupererJeton();
                            joueurCourant.ajouterJeton(jetonrecup);
                            CouleurSuivante();
                        }
                */
                
                // A COMPLETER CHOIX PION
                
                

                grille_jeu.add(case_graphique);
                

                /* public FenetreDeJeu() {
        initComponents();
        panneau_info_joueurs.setVisible(false); // le setVisible(boolean) rend la référence-objet visible ou non 
        panneau_info_partie.setVisible(false);
        btn_rejouer.setEnabled(false); // le setEnabled(boolean) rend le bouton fonctionnel ou non
        btn_stop.setEnabled(true);
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(GrilleJeu.Cellules[i][j]); // création des cellule graphique associée aux coordonnées du jeu console

                cellGraph.addActionListener(new java.awt.event.ActionListener() { // ActionListener permet d'interagir avec la fenêtre graphique de jeu (cliquer sur les cases graphiques)
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Cellule c = cellGraph.celluleAssociee;
                        if (c.jetonCourant == null) {
                            return;
                        }
                        if (c.jetonCourant.Couleur.equals(joueurCourant.Couleur)) {
                            textemessage.setText(joueurCourant.Nom + " récupère un de ses jetons"); //setText permet d'afficher des String sur une fenêtre de texte
                            Jeton jetonrecup = c.recupererJeton();
                            joueurCourant.ajouterJeton(jetonrecup);
                            CouleurSuivante();
                        } else {
                            if (joueurCourant.nombreDesintegrateurs > 0) {
                                textemessage.setText(joueurCourant.Nom + " désintègre un jeton adverse");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                CouleurSuivante();
                            } else {
                                return;
                            }
                        }
                        GrilleJeu.tasserGrille();
                        panneau_grille.repaint(); // rafraîchit, actualise le panneau d'affichage
                        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + ""); // double guillements force conversion en String
                        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + ""); // double guillements force conversion en String

                        boolean vict_j1 = GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]);
                        boolean vict_j2 = GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]);

                        if (vict_j1 && !vict_j2) {
                            textemessage.setText("Victoire de " + ListeJoueurs[0].Nom);
                        }
                        if (vict_j2 && !vict_j1) {
                            textemessage.setText("Victoire de " + ListeJoueurs[1].Nom);
                        }
                        if (vict_j1 && vict_j2) {
                            if (joueurCourant == ListeJoueurs[0]) {
                                textemessage.setText("Victoire par faute de " + ListeJoueurs[1].Nom); // explicite les règles aux joueurs
                            } else {
                                textemessage.setText("Victoire par faute de " + ListeJoueurs[0].Nom); // explicite les règles aux joueurs
                            }
                        }

                    }
                });
                panneau_grille.add(cellGraph);
            }
        }
    }*/
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

        // Tirage des cartes
        //DefinirCartesPartie();
        panel_carte1_j1.repaint();
        panel_carte2_j1.repaint();
        panel_carte1_j2.repaint();
        panel_carte2_j2.repaint();
        panel_carte_transition.repaint();
        //System.out.println(ListeCartes);

        // Attribution des cartes et affectation dela derniere en tant que carte transition
        Joueur1.CarteEnMain[0] = TabCartePartie[0];
        Joueur1.CarteEnMain[1] = TabCartePartie[1];
        Joueur2.CarteEnMain[0] = TabCartePartie[2];
        Joueur2.CarteEnMain[1] = TabCartePartie[3];
        CarteTransition = TabCartePartie[4];

        /*// Test sur placercartegrise
        Joueur1.CarteEnMain[0] = CarteMante;
        Joueur1.CarteEnMain[1] = CarteCoq;
        Joueur2.CarteEnMain[0] = CarteMante;
        Joueur2.CarteEnMain[1] = CarteCoq;*/
        // On determine qui commence à jouer
        Random joueur = new Random();
        boolean premier_joueur = joueur.nextBoolean();
        if (premier_joueur) {
            JoueurCourant = ListeJoueurs[0];
        } else {
            JoueurCourant = ListeJoueurs[1];
        }

        /**/
        // affiche les noms/couleurs des joueurs dans le pannel des informations joueurs/ informations partie
        lbl_j1_nom.setText(nomJoueur1);
        lbl_j1_couleur.setText(Joueur1.CouleurJoueur);
        lbl_j2_nom.setText(nomJoueur2);
        lbl_j2_couleur.setText(Joueur2.CouleurJoueur);
        lbl_joueur_courant.setText(JoueurCourant.NomJoueur);

        //PlateauJeu.AfficherPlateauSurConsole();
        //Tour();
    }

    void Tour() { // équivalent de notre méthode Menu() achevée
        System.out.println("Tour de " + JoueurCourant.NomJoueur);
        System.out.println("Choisissez une carte déplacement");
        String ChoixCarte;
        Scanner sc = new Scanner(System.in);
        ChoixCarte = sc.nextLine();
        while (!ChoixCarte.equals(JoueurCourant.CarteEnMain[0].NomCarte) && !ChoixCarte.equals(JoueurCourant.CarteEnMain[1].NomCarte)) {
            System.out.println("Carte invalide. Réessayer.");
            ChoixCarte = sc.nextLine();
        }
        System.out.println("la carte déplacement choisie est " + ChoixCarte);
        Carte CarteDuTour = CarteChoisie(ChoixCarte);

        System.out.println("Choisissez un pion à déplacer");
        int c;
        int l;
        do {
            System.out.println("Donner les coordonnées du pion à déplacer : ");
            System.out.println("Saisir colonne : ");
            c = sc.nextInt() - 1;
            while (c < 0 || c > 4) {
                System.out.println("Colonne invalide. Réessayer.");
                c = sc.nextInt() - 1;
            }
            System.out.println("Saisir ligne : ");
            l = sc.nextInt() - 1;
            while (l < 0 || l > 4) {
                System.out.println("Ligne invalide. Réessayer.");
                l = sc.nextInt() - 1;
            }
        } while (ChoisirPion(l, c) != true);

        PlateauJeu.PlacerCaseGrise(JoueurCourant, l, c, CarteDuTour);
        PlateauJeu.AfficherPlateauSurConsole();

        System.out.println("Choisissez une carte grise");

    }

    public void JoueurSuivant() {
        // rotation des joueurs
        if (JoueurCourant == ListeJoueurs[0]) {
            JoueurCourant = ListeJoueurs[1];
        } else {
            JoueurCourant = ListeJoueurs[0];
        }
        lbl_joueur_courant.setText(JoueurCourant.NomJoueur);
    }

    /*boolean TourDeJeu(Carte uneCarte, Pion unPion, ) { // A COMPLETER; combinaison de selection de carte et de deplacer pion
        boolean ResultatAction;
    ResultatAction=...;
    boolean victoire_j1 = PlateauJeu.EtreGagnant();
    boolean victoire_j2 = PlateauJeu.EtreGagnant();
    if (victoire_j1 && !victoire_j2) textemessage.setText("Victoire de " + ListeJoueurs[0].NomJoueur);
    if (victoire_j2 && !victoire_j1) textemessage.setText("Victoire de " + ListeJoueurs[1].NomJoueur);
    if (victoire_j1 && victoire_j2){
        if(JoueurCourant == ListeJoueurs[0]) textemessage.setText("Victoire de " + ListeJoueurs[1].NomJoueur);
        else textemessage.setText("Victoire de " + ListeJoueurs[0].NomJoueur);
    }
    
        (ResultatAction == true) {
            return true;
        } else {
            return false;
        }*/
    void AttribuerCouleursAuxJoueurs() {
        Random alea = new Random(); // attribution des couleurs aux joueurs au hasard
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

    Carte CarteChoisie(String unNomCarte) {
        if (JoueurCourant.CarteEnMain[0].NomCarte == unNomCarte) {
            return JoueurCourant.CarteEnMain[0];
        } else {
            return JoueurCourant.CarteEnMain[1];
        }
    }

    boolean ChoisirPion(int l, int c) {
        if (PlateauJeu.Grille[l][c].PionCourant == null) {
            System.out.println("vous n'avez pas sélectionné de pion");
            return false;
        } else if (PlateauJeu.Grille[l][c].PionCourant.CouleurPion == JoueurCourant.CouleurJoueur) {
            return true;
        } else {
            System.out.println("le pion selectionné n'est pas de votre couleur");
            return false;
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
        btn_carte_transition = new javax.swing.JButton();
        btn_c1_j2 = new javax.swing.JButton();
        btn_c2_j2 = new javax.swing.JButton();
        btn_c1_j1 = new javax.swing.JButton();
        btn_c2_j1 = new javax.swing.JButton();

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
        panel_carte_transition.setLayout(new java.awt.GridLayout());
        getContentPane().add(panel_carte_transition, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 300, 170));

        panel_carte1_j2.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte1_j2.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panel_carte1_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 690, 300, 170));

        panel_carte2_j2.setBackground(new java.awt.Color(153, 51, 0));
        panel_carte2_j2.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panel_carte2_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 690, 300, 170));

        btn_carte_transition.setBackground(new java.awt.Color(153, 51, 0));
        btn_carte_transition.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_carte_transition.setForeground(new java.awt.Color(255, 255, 255));
        btn_carte_transition.setText("Carte Transition");
        btn_carte_transition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carte_transitionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_carte_transition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 190, 40));

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
        btn_c1_j1.setVisible(true);
        btn_c2_j1.setVisible(true);
        btn_c1_j2.setVisible(true);
        btn_c2_j2.setVisible(true);
        btn_carte_transition.setVisible(true);
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
        infos_joueurs.setVisible(true); // problème sur rejouer qui ne repaint pas les cartes
        infos_partie.setVisible(true);
        initialiserPartie();
        grille_jeu.repaint(); //rafraichitl'affichage
        btn_demarrer.setEnabled(false); // bloque la possibilite de cliquer plusieurs fois que le bouton demarrer
        panel_carte1_j1.setEnabled(true);
        panel_carte2_j1.setEnabled(true);
        panel_carte1_j2.setEnabled(true);
        panel_carte2_j1.setEnabled(true);
        panel_carte1_j1.repaint();
        panel_carte2_j1.repaint();
        panel_carte1_j2.repaint();
        panel_carte2_j2.repaint();
        panel_carte_transition.repaint();
        textemessage.setText(" "); // efface le dernier message affiche dans le panneau infos partie
        btn_rejouer.setEnabled(false);
    }//GEN-LAST:event_btn_rejouerActionPerformed

    private void btn_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitterActionPerformed
        super.dispose(); // ferme la fenetre de jeu
    }//GEN-LAST:event_btn_quitterActionPerformed

    private void btn_carte_transitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carte_transitionActionPerformed
        textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + TabCartePartie[4].LireCarte());
    }//GEN-LAST:event_btn_carte_transitionActionPerformed

    private void btn_c2_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c2_j2ActionPerformed
        if (JoueurCourant == ListeJoueurs[0]) {
            btn_c2_j2.setEnabled(false);
            textemessage.setText("Ce n'est pas votre carte. Réessayez");
        } else {
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[1].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[1].NomCarte);
        }
    }//GEN-LAST:event_btn_c2_j2ActionPerformed

    private void btn_c1_j1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_j1ActionPerformed
        if (JoueurCourant == ListeJoueurs[1]) {
            btn_c1_j1.setEnabled(false);
            textemessage.setText("Ce n'est pas votre carte. Réessayez");
        } else {
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[0].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[1].NomCarte);
        }
    }//GEN-LAST:event_btn_c1_j1ActionPerformed

    private void btn_c2_j1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c2_j1ActionPerformed
        if (JoueurCourant == ListeJoueurs[1]) {
            btn_c2_j1.setEnabled(false);
            textemessage.setText("Ce n'est pas votre carte. Réessayez");
        } else {
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[1].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[1].NomCarte);
        }
    }//GEN-LAST:event_btn_c2_j1ActionPerformed

    private void btn_c1_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_j2ActionPerformed
        if (JoueurCourant == ListeJoueurs[0]) {
            btn_c1_j2.setEnabled(false);
            textemessage.setText("Ce n'est pas votre carte. Réessayez");
        } else {
            textemessage.setText(JoueurCourant.NomJoueur + " prend la carte " + JoueurCourant.CarteEnMain[0].LireCarte());
            CarteCourante = CarteChoisie(JoueurCourant.CarteEnMain[1].NomCarte);
        }
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
    private javax.swing.JButton btn_carte_transition;
    private javax.swing.JButton btn_demarrer;
    private javax.swing.JButton btn_quitter;
    private javax.swing.JButton btn_rejouer;
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
