package cassebrique;

import cassebrique.models.Balle;
import cassebrique.models.Barre;
import cassebrique.models.Brique;
import cassebrique.models.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener {

    public JFrame fenetre = new JFrame();
    public ArrayList<Balle> listeBalle = new ArrayList<>();
    public ArrayList<Brique> listeBrique = new ArrayList<>();
<<<<<<< HEAD
    public ArrayList<Bonus> listeBonus = new ArrayList<>();
=======
    public ArrayList<Sprite> listeSprite = new ArrayList<>();
>>>>>>> 5061b7324f3c893c1323791da569e948703e5368
    public Barre barre;

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 700;

    public boolean toucheDroite = false;
    public boolean toucheGauche = false;

    public CasseBrique() throws InterruptedException {

        this.fenetre.setSize(LARGEUR, HAUTEUR);
        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0,0,LARGEUR, HAUTEUR);

        this.fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panneau = new JPanel();
        panneau.add(this);
        this.fenetre.setContentPane(panneau);

        this.setIgnoreRepaint(true);
        this.setFocusable(false);
        this.fenetre.pack();
        this.fenetre.setResizable(false);
        this.fenetre.requestFocus();
        this.fenetre.addKeyListener(this);
        this.fenetre.setVisible(true);
        this.createBufferStrategy(2);

        lancerUnePartie();
    }

    public void lancerUnePartie() throws InterruptedException {

        listeBalle = new ArrayList<>();
        listeBalle.add(new Balle());

        listeSprite.add(listeBalle.get(0));
        listeSprite.add(listeBalle.get(1));
        listeSprite.add(listeBalle.get(2));

        barre = new Barre(
                CasseBrique.LARGEUR / 2 - Barre.largeurDefaut / 2,
                CasseBrique.HAUTEUR - 100);

        listeSprite.add(barre);

        listeBrique = new ArrayList<>();
        for (int indexLigne = 0; indexLigne < 5; indexLigne++) {
            for (int indexColonne = 0; indexColonne < 7; indexColonne++) {
                Brique brique = new Brique(
                        indexColonne * (Brique.largeurDefaut + 2),
                        indexLigne * (Brique.hauteurDefaut + 2));
                listeBrique.add(brique);
                listeSprite.add(brique);
            }
        }

        //la balle peut avoir une couleur differente
        //ajouter un constructeur permettant de definir la couleur de la balle
        //si aucune couleur n'est donnée (utilisation du premier constructeur) : la couleur est aléatoire
        //    Math.random() = donne un nombre entre 0 et 1 (un double)
        //    new Color(R, G , B)  prend 3 float en parametre (pour rappel un double est trop grand pour un float)
        while(true) {

            Graphics2D dessin = (Graphics2D)this.getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, LARGEUR, HAUTEUR);

            for(Balle balle : listeBalle) {
                balle.deplacer();
<<<<<<< HEAD
                for (int j = listeBrique.size() - 1; j >= 0; j--) {
                    Brique brique = listeBrique.get(j);
                    if(balle.collisionBrique(brique)){
                        listeBrique.remove(j);
                    }
                }
                balle.collisionBarre(barre);
                balle.dessiner(dessin);
            }

            //liste bonus à faire apparaitre et disparaitre baser sur la collision

            if(toucheDroite){
                barre.deplacementDroite();
            }

            if(toucheGauche){
                barre.deplacementGauche();
            }

            barre.dessiner(dessin);

            for(Brique brique : listeBrique) {
                brique.dessiner(dessin);
=======
            }

            for(Sprite sprite : listeSprite) {
                sprite.dessiner(dessin);
>>>>>>> 5061b7324f3c893c1323791da569e948703e5368
            }

            dessin.dispose();
            this.getBufferStrategy().show();

            Thread.sleep(1000 / 60);
        }
    }

    //main : raccourci
    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            toucheDroite = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            toucheGauche = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            toucheDroite = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            toucheGauche = false;
        }
    }
}
