package cassebrique.models;

import java.awt.*;

public class Brique extends Rectangle {

    protected int resistance;
    public static int hauteurDefaut = 40;
    public static int largeurDefaut = 70;

    // Constructor that assigns color based on resistance
    public Brique(int x, int y) {
        super(x, y, largeurDefaut, hauteurDefaut, null);
        this.resistance = this.nombreAleatoire(1, 4);
        this.couleur = assignColorBasedOnResistance();
    }

    private Color assignColorBasedOnResistance() {
        switch (resistance) {
            case 3:
                return Color.RED;
            case 2:
                return Color.ORANGE;
            case 1:
                return Color.YELLOW;
            default:
                return Color.GRAY;
        }
    }

    protected int nombreAleatoire(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        this.couleur = assignColorBasedOnResistance();


        super.dessiner(dessin);
        dessin.setColor(couleur);
        dessin.fillRect(x, y, largeur, hauteur);

        dessin.setColor(Color.BLACK);
        dessin.drawRect(x, y, largeur, hauteur);
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
}
