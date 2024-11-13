package cassebrique.models;

import java.awt.*;

public class Rond extends Sprite {

<<<<<<< HEAD
    protected int diametre = 20;

    public Rond() {

    }

    public Rond(int diametre) {
        this.diametre = diametre;
    }


=======
    protected int diametre;

    public Rond(int x, int y, int diametre, Color couleur) {
        super(x, y, couleur);
        this.diametre = diametre;
    }

>>>>>>> 5061b7324f3c893c1323791da569e948703e5368
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
    }
<<<<<<< HEAD

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
=======
>>>>>>> 5061b7324f3c893c1323791da569e948703e5368
}
