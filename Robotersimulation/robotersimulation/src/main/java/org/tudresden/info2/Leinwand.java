package org.tudresden.info2;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Leinwand extends JFrame {

    private static final long serialVersionUID = -8979930495742157974L;

    private static JFrame fenster;

    private int laenge, breite;
    private Color hintergrundfarbe;
    
    private Zeichenflaeche zeichenflaeche;

    public Leinwand(int laenge, int breite, Color hintergrundfarbe) {
        this.laenge = laenge;
        this.breite = breite;
        this.hintergrundfarbe = hintergrundfarbe;

        this.zeichenflaeche = new Zeichenflaeche();

        fenster = new JFrame();
        fenster.add(this.zeichenflaeche);
        fenster.setSize(this.breite, this.laenge);
    }

    public void warten(int millisekunden)
    {
        try
        {
        Thread.sleep(millisekunden);
        }
        catch (Exception e)
        {
        // Exception ignorieren
        }
    }

    public void zeichnen(ArrayList<Rechteck> hindernisse) {
        fenster.setVisible(false);
        zeichenflaeche.setHindernisse(hindernisse);
        zeichenflaeche.updateUI();
        fenster.setVisible(true);
    }

}