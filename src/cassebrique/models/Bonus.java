package cassebrique.models;

import cassebrique.CasseBrique;

import java.awt.*;

public class Bonus extends Rond{
    protected int vitesseY;
    protected int type;
    protected boolean malus;
    public int TYPE_VITESSE;
    public int TYPE_TAILLE;

    public Bonus() {
        this.y = Brique.hauteurDefaut/2;
        this.vitesseY = 5;
        this.diametre = 10;
    }

    //effet type à faire

    @Override
    public void dessiner(Graphics2D dessin) {
        super.dessiner(dessin);
        if (malus == true) {
        dessin.setColor(Color.GREEN);
        dessin.fillOval(x, y, diametre, diametre);
        }
        else {
            dessin.setColor(Color.RED);
            dessin.fillOval(x, y, diametre, diametre);
        }
    }

    public boolean collisionBarre(Barre barre) {
        if ((x + diametre >= barre.x) && (x <= barre.x + Barre.largeurDefaut) &&
                (y + diametre >= barre.y) && (y <= barre.y + Barre.hauteurDefaut)) {
            return true;
        }
        return false;
    }

    public void deplacer() {

        y += vitesseY;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isMalus() {
        return malus;
    }

    public void setMalus(boolean malus) {
        this.malus = malus;
    }

}
