package mastermind.game;

public class Ligne {

    private Couleur[] pions;

    public Ligne(Couleur pion1, Couleur pion2, Couleur pion3, Couleur pion4) {
        pions = new Couleur[]{pion1, pion2, pion3, pion4};
    }

    public Couleur[] getPions() {
        return pions;
    }
}
