package cassebrique.models;

import cassebrique.CasseBrique;

import java.awt.*;
<<<<<<< HEAD
import java.util.Random;
=======
import java.util.ArrayList;
>>>>>>> 5061b7324f3c893c1323791da569e948703e5368

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

    public Collision detecteCollision(ArrayList<Rectangle> listeRectangle) {
        int x1Balle = x;
        int x2Balle = x + diametre;
        int y1Balle = y;
        int y2Balle =y + diametre;

        for (Rectangle rectangle : listeRectangle) {
            int x1Rectangle = rectangle.x;
            int x2Rectangle = rectangle.x + rectangle.largeur;
            int y1Rectangle = rectangle.y;
            int y2Rectangle =rectangle.y + rectangle.hauteur;

            //est ce que l'un des coin de la balle se trouve dans le Rectangle testé
            if((x1Balle > x1Rectangle && x1Balle < x2Rectangle && y1Balle > y1Rectangle && y1Balle < y2Rectangle)
            || (x2Balle > x1Rectangle && x2Balle < x2Rectangle && y1Balle > y1Rectangle && y1Balle < y2Rectangle)
            || (x1Balle > x1Rectangle && x1Balle < x2Rectangle && y2Balle > y1Rectangle && y2Balle < y2Rectangle)
            || (x2Balle > x1Rectangle && x2Balle < x2Rectangle && y2Balle > y1Rectangle && y2Balle < y2Rectangle)){
                // il y a une collision
                int distanceDroite = Math.abs(x2Balle - x1Rectangle);
                int distanceGauche = Math.abs(x1Balle - x2Rectangle);
                int distanceHaut = Math.abs(y1Balle - y2Rectangle);
                int distanceBas = Math.abs(y2Balle - y1Rectangle);

                int plusPetiteDistance = Math.min(
                        distanceDroite,Math.min(
                                distanceGauche,Math.min(
                                        distanceHaut,distanceBas)));

                if(plusPetiteDistance == distanceDroite) {
                    return new Collision(rectangle, "droite");
                } else if(plusPetiteDistance == distanceGauche) {
                    return new Collision(rectangle, "gauche");
                } else if(plusPetiteDistance == distanceHaut) {
                    return new Collision(rectangle, "haut");
                } else  {
                    return new Collision(rectangle, "bas");
                }
            }
        }

        return null;
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
