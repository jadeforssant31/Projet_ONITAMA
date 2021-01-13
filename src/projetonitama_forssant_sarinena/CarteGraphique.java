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
public class CarteGraphique extends JButton {
    
    // Création d'une CarteAssociee, permet de travailler sur la partie graphique
    Carte CarteAssociee;
    
    // Création des images utilisées dans la partie graphique
    ImageIcon img_sanglier = new javax.swing.ImageIcon(getClass().getResource("/images/boar.jpg"));
    ImageIcon img_cobra = new javax.swing.ImageIcon(getClass().getResource("/images/cobra.jpg"));
    ImageIcon img_crabe = new javax.swing.ImageIcon(getClass().getResource("/images/crab.jpg"));
    ImageIcon img_dragon = new javax.swing.ImageIcon(getClass().getResource("/images/dragon.jpg"));
    ImageIcon img_anguille = new javax.swing.ImageIcon(getClass().getResource("/images/eel.jpg"));
    ImageIcon img_elephant = new javax.swing.ImageIcon(getClass().getResource("/images/elephant.jpg"));
    ImageIcon img_grenouille = new javax.swing.ImageIcon(getClass().getResource("/images/frog.jpg"));
    ImageIcon img_oie = new javax.swing.ImageIcon(getClass().getResource("/images/goose.jpg"));
    ImageIcon img_cheval = new javax.swing.ImageIcon(getClass().getResource("/images/horse.jpg"));
    ImageIcon img_mante = new javax.swing.ImageIcon(getClass().getResource("/images/mantis.jpg"));
    ImageIcon img_singe = new javax.swing.ImageIcon(getClass().getResource("/images/monkey.jpg"));
    ImageIcon img_boeuf = new javax.swing.ImageIcon(getClass().getResource("/images/ox.jpg"));
    ImageIcon img_lapin = new javax.swing.ImageIcon(getClass().getResource("/images/rabbit.jpg"));
    ImageIcon img_coq = new javax.swing.ImageIcon(getClass().getResource("/images/rooster.jpg"));
    ImageIcon img_tigre = new javax.swing.ImageIcon(getClass().getResource("/images/tiger.jpg"));
    ImageIcon img_grue = new javax.swing.ImageIcon(getClass().getResource("/images/crane.jpg"));

    
    public CarteGraphique(Carte UneCarte){ // Constructeur qui passe initialise les attributs
        CarteAssociee = UneCarte;
    }
    
    // méthode permettant d'afficher les images dans la fenêtre graphique
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        String nom_carte = CarteAssociee.LireCarte();
        switch(nom_carte){ // Choix du switch pour éviter les if else imbriqués
            case "Sanglier":
                setIcon(img_sanglier);
                break;
            case "Cobra":
                setIcon(img_cobra);
                break;
            case "Crabe":
                setIcon(img_crabe);
                break;
            case "Dragon":
                setIcon(img_dragon);
                break;
            case "Anguille":
                setIcon(img_anguille);
                break;
            case "Elephant":
                setIcon(img_elephant);
                break;
            case "Grenouille":
                setIcon(img_grenouille);
                break;
            case "Oie":
                setIcon(img_oie);
                break;
            case "Cheval":
                setIcon(img_cheval);
                break;
            case "Mante":
                setIcon(img_mante);
                break;
            case "Singe":
                setIcon(img_singe);
                break;
            case "Boeuf":
                setIcon(img_boeuf);
                break;
            case "Lapin":
                setIcon(img_lapin);
                break;
            case "Coq":
                setIcon(img_coq);
                break;
            case "Tigre":
                setIcon(img_tigre);
                break;
            default : //case grue
                setIcon(img_grue);
                break;
        }
    }
    
    
}

