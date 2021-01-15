# Projet_ONITAMA
SARINENA Lucie et FORSSANT Jade - 15/01/2021
Nous avons tout d'abord commencé à travailler sur le modèle UML du programme en y intégrant les différents attributs et classes. 
Après vous avoir fait valider notre modèle UML, nous avons pu commencer à développer le squelette du programme. Après celà, nous avons
commencé à développer l'interface graphique afin d'y voir plus clair. Nous avons récupéré les cartes sur moodle et Lucie a déssiné les pions sur paint. 
Nous avons choisi de déveloper une interface similaire à celle du puissance 4, interface que nous pourrions ensuite moduler au fur et à mesure 
de l'avancement du code. 

Ayant choisi de travailler sur l'interface graphique dès le début, il a fallu qu'on développe le jeu console en même temps, et ce, pour éviter les incohérences: 
Pax exemple, il nous est arrivé de déplacer un pion sur l'interface graphique, mais sur l'interface de la console rien ne se passait
(l'objet pion n'était pas déplacé, seulement l'image associée à ce dernier).

Nous avons décidé en premier lieu de travailler avec les matrices de déplacement liées aux cartes. Pour ce faire nous avons intégré dans un constructeur de
la classe Carte la création de matrices 5X5 de déplacement. Les cases grises étaient alors directement reliées aux cartes de déplacement. 
Par soucis de simplicité et de compréhension, nous avons choisi de travailler avec des méthodes semblables à celles du puissance 4 (conditions gagnantes 
du puissance 4) et laisser les matrices en suspens.

Nous avons réussi à développer un jeu complètement fonctionnel tant du point de vue de l'interface graphique que de l'interface console en se basant
sur les connaissances acquises sur les précédents TP.

En termes d'amélioration, nous pourions par exemple alléger le code en créant une méthode qui prend en compte les mouvements possibles en se basant sur l'écriture
de matrices. 
