package cassebrique.models;

import cassebrique.CasseBrique;

import java.awt.*;
import java.util.Random;

public class Balle extends Rond {

    protected int vitesseX;
    protected int vitesseY;

    public Balle() {
        super();
        this.x = this.nombreAleatoire(diametre,CasseBrique.LARGEUR - diametre);
        this.y = this.nombreAleatoire(400,500);
        this.vitesseX = 5;
        this.vitesseY = -5;
        this.couleur = new Color(ratioAleatoire(), ratioAleatoire(), ratioAleatoire(0.4f,0.7f));
    }

    public Balle(int x, int y, int vitesseX, int vitesseY) {
        this.x = x;
        this.y = y;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.couleur = new Color(ratioAleatoire(), ratioAleatoire(), ratioAleatoire(0.4f,0.7f));
    }

    public Balle(int x, int y, int vitesseX, int vitesseY, Color couleur) {
        this.x = x;
        this.y = y;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.couleur = couleur;
    }

    protected float ratioAleatoire(float min, float max) {
        return (float)Math.random() * (max - min) + min;
    }

    protected float ratioAleatoire() {
        //return (float)Math.random() * 0.6f + 0.2f;
        return ratioAleatoire(0.2f, 0.8f);
    }

    protected int nombreAleatoire(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }

    public void deplacer() {

        x += vitesseX;
        y += vitesseY;

        if(x >= CasseBrique.LARGEUR - diametre || x <= 0) {
            vitesseX = -vitesseX;
        }

        if(y >= CasseBrique.HAUTEUR - diametre || y <= 0) {
            vitesseY = -vitesseY;
        }

    }

    public boolean collisionBrique(Brique brique){
        if ((x + diametre >= brique.x) && (x <= brique.x + Brique.largeurDefaut) &&
                (y + diametre >= brique.y) && (y <= brique.y + Brique.hauteurDefaut)) {
            vitesseY = -vitesseY;

            brique.setResistance(brique.getResistance()-1);
            if(brique.resistance == 0){
                Random random = new Random();
                int chance = random.nextInt(100);

                if (chance < 10) {

                    Bonus bonus = new Bonus();

                    bonus.setMalus(random.nextBoolean());

                    bonus.setType(random.nextBoolean() ? bonus.TYPE_VITESSE : bonus.TYPE_TAILLE);
                    //rajout d'une fonction pour rajouter un bonus dans une liste
                }

            return true;
            }
            return false;
        }
        return false;
    }

    public boolean collisionBarre(Barre barre) {
        if ((x + diametre >= barre.x) && (x <= barre.x + Barre.largeurDefaut) &&
                (y + diametre >= barre.y) && (y <= barre.y + Barre.hauteurDefaut)) {
            vitesseY = -vitesseY;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }


    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
