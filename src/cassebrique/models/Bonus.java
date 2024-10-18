package cassebrique.models;

import cassebrique.CasseBrique;

public class Bonus extends Rond{
    protected int vitesseY;
    protected int type;
    protected boolean malus;
    public int TYPE_VITESSE;
    public int TYPE_TAILLE;






    public void deplacer() {

        y += vitesseY;

        if(y >= CasseBrique.HAUTEUR - diametre || y <= 0) {
            vitesseY = -vitesseY;
        }
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
