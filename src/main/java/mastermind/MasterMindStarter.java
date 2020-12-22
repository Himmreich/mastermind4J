package mastermind;

import mastermind.game.Couleur;
import mastermind.game.Plateau;

import java.util.Scanner;

public class MasterMindStarter {

    public static void main(String args[]) {
        /**
         * Le jeu se compose d'un plateau de 12 lignes de 4 couleurs chacunes.
         * Les couleurs sont:
         *  - Bleu
         *  - Rouge
         *  - Jaune
         *  - Vert
         *  - Violet
         *  1 ligne cachée qui contient la combinaison a deviner.
         *  Si un pion est bien place et a la bonne couleur on affiche un pion noir.
         *  Si un pion a la bonne couleur mais n'est pas bien placé on affiche une couleur blanche.
         *  Dans un premier temps on va le faire en mode console avec des lettres pour les couleurs.
         */
        try (Scanner scanner = new Scanner(System.in)){
           //On affiche le menu
           Plateau plateau = null;
           int choix = -1;
           do{
               System.out.println("Bienvenue dans MasterMind");
               System.out.println();
               System.out.println("1 - Nouvelle partie (mode auto)");
               System.out.println("2 - Nouvelle partie (mode normal)");
               choix = scanner.nextInt();
           }while (choix < 1 && choix > 2);

           if(choix == 1) {
               plateau = new Plateau();
           } else {
               Couleur[] pions = new Couleur[4];
               for(int i = 0; i < 4; i++) {
                   int pion = -1;
                   do{
                       System.out.println("Choix du pion n° " + (i + 1) + " (0 - Bleu; 1 - Jaune; 2 - Rouge; 3 - Vert; 4 - Violet)");
                       pion = scanner.nextInt();
                   }while (pion < 0 || pion > 4);
                   pions[i] = Plateau.couleurs.get(pion);
               }
               plateau = new Plateau(pions[0], pions[1], pions[2], pions[3]);
           }
           boolean quit = false;
           //On joue la partie
           for (int i = 0; i < 12; i++) {
               if(quit) break;
               Couleur[] pions = new Couleur[4];
               for(int j = 0; j < 4; j++) {
                   int pion = -1;
                   do{
                       System.out.println("Choisir le pion n° " + (j + 1) + " pour la ligne " + (i + 1) + " (0 - Bleu; 1 - Jaune; 2 - Rouge; 3 - Vert; 4 - Violet; 5 - Abandon)");
                       pion = scanner.nextInt();
                       if (pion == 5) quit = true;
                   }while ((pion < 0 || pion > 5) && !quit);
                   pions[j] = Plateau.couleurs.get(pion);
                   if(quit) System.exit(0);
               }
               plateau.nouvelleLigne(pions[0], pions[1], pions[2], pions[3]);
               plateau.afficherLignes();
               if(plateau.isVictoire()) {
                   plateau.afficherSolution();
                   break;
               };
           }
           if(quit) System.exit(0);
           String message = " gagné !";
           if(!plateau.isVictoire()) message = " perdu !";
           System.out.println("Vous avez " + message);
        }
    }
}
