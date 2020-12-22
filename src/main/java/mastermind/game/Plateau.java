package mastermind.game;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Plateau {

    public static Map<Integer, Couleur> couleurs = new HashMap();

    private Couleur[] solution;
    private Ligne[] lignes;
    private Couleur[][] indices;
    private Integer derniereLigne;

    public Plateau() {
        couleurs.put(0, Couleur.BLEU);
        couleurs.put(1, Couleur.JAUNE);
        couleurs.put(2, Couleur.ROUGE);
        couleurs.put(3, Couleur.VERT);
        couleurs.put(4, Couleur.VIOLET);

        solution = new Couleur[4];
        for(int i = 0; i < 4; i++) {
            solution[i] = couleurs.get(new Random().nextInt((4 - 0) + 1) - 0);
        }
        indices = new Couleur[12][4];
        lignes = new Ligne[12];
        derniereLigne = -1;
    }

    public Plateau(Couleur pion1, Couleur pion2, Couleur pion3, Couleur pion4) {
        solution = new Couleur[]{pion1, pion2, pion3, pion4};
        indices = new Couleur[12][4];
        lignes = new Ligne[12];
        derniereLigne = -1;
    }

    public void afficherSolution() {
        System.out.println("+---------+");
        System.out.println("| " + solution[0].getInitiale()
                + " " + solution[1].getInitiale()
                + " " + solution[2].getInitiale()
                + " " + solution[3].getInitiale() + " |");
        System.out.println("+---------+");
    }

    public void nouvelleLigne(Couleur pion1, Couleur pion2, Couleur pion3, Couleur pion4) {
        derniereLigne++;
        lignes[derniereLigne] = new Ligne(pion1, pion2, pion3, pion4);
        indices[derniereLigne] = getIndices(lignes[derniereLigne]);
    }

    public Boolean isVictoire() {
        Boolean victoire = true;
        for (int i = 0; i < 4; i++) {
            if(lignes[derniereLigne].getPions()[i].compareTo(solution[i]) != 0) {
                victoire = false;
            break;
            }
        }
        return victoire;
    }

    public Couleur[] getIndices(Ligne ligne) {
        for(int i = 0; i < ligne.getPions().length; i++) {
            if(ligne.getPions()[i].compareTo(solution[i]) == 0)
                indices[derniereLigne][i] = Couleur.NOIR;
            else {
                for(int j = 0; j < solution.length; j++) {
                    if(ligne.getPions()[i].compareTo(solution[j]) == 0)
                        indices[derniereLigne][i] = Couleur.BLANC;
                }
            }
        }
        return indices[derniereLigne];
    }

    public void afficherLignes() {
        System.out.println("   +---------+---------+");
        for (int i = 0; i < derniereLigne + 1; i++) {
            System.out.println(i + "  | " + lignes[i].getPions()[0].getInitiale()
                    + " " + lignes[i].getPions()[1].getInitiale()
                    + " " + lignes[i].getPions()[2].getInitiale()
                    + " " + lignes[i].getPions()[3].getInitiale()
                    + " | " + ((indices[i][0] != null) ? indices[i][0].getInitiale() : " ")
                    + " " + ((indices[i][1] != null) ? indices[i][1].getInitiale() : " ")
                    + " " + ((indices[i][2] != null) ? indices[i][2].getInitiale() : " ")
                    + " " + ((indices[i][3] != null) ? indices[i][3].getInitiale() : " ") + " |");
        }
        System.out.println("   +---------+---------+");
    }
}
