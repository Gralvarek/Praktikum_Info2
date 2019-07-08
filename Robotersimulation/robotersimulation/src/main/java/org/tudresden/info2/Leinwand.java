package org.tudresden.info2;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class Leinwand extends JFrame {

    private static final long serialVersionUID = -8979930495742157974L;

    private static JFrame fenster;

    private static final int LAENGE = 1000;
    private static final int BREITE = 1000;
    private static final Color HINTERGRUNDFARBE = Color.WHITE;

    private static Leinwand instance;
    
    private Zeichenflaeche zeichenflaeche;

    public static Leinwand getInstance() {
        if(instance == null) {
            return instance = new Leinwand();
        } else {
            return instance;
        }
    }
    private Leinwand() {

        this.zeichenflaeche = new Zeichenflaeche();
        fenster = new JFrame();
        fenster.setBackground(HINTERGRUNDFARBE);
        fenster.setSize(BREITE, LAENGE);
        fenster.add(this.zeichenflaeche);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);

    }

    /*
    * Pauses the thread a certain amount of miliseconds
    */
    public void warten(int millisekunden)
    {
        try {
            Thread.sleep(millisekunden);
        } catch (Exception e) {
        }
    }
    
    /*
     * Hides the frame, sets the obstacles, reopens the frame
     */
    public void zeichnen(ArrayList<Rechteck> hindernisse) {
        zeichenflaeche.setHindernisse(hindernisse);
        zeichenflaeche.updateUI();
    }

    /*
     * Hides the frame, sets the robot, reopens the frame
     */
    public void zeichnen(Roboter robot) {
        zeichenflaeche.setRoboter(robot);
        zeichenflaeche.updateUI();
    }

}