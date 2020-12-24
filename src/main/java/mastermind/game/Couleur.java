package mastermind.game;

public enum Couleur {
    BLEU("B"),
    ROUGE("R"),
    JAUNE("J"),
    VERT("V"),
    VIOLET("M"),
    BLANC("B"),
    NOIR("N"),
    EMPTY("E");

    private String initiale;

    Couleur(String initiale) {
        this.initiale = initiale;
    }

    public String getInitiale() { return this.initiale; }
}
