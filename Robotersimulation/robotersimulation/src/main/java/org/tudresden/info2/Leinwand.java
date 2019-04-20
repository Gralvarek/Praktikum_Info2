package org.tudresden.info2;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Leinwand extends JFrame{

    private static JFrame fenster;

    private int laenge, breite;
    private Color hintergrundfarbe;
    
    private Zeichenflaeche zeichenflaeche;

    public Leinwand(int laenge, int breite, Color hintergrundfarbe) {
        this.laenge = laenge;
        this.breite = breite;
        this.hintergrundfarbe = hintergrundfarbe;
        zeichenflaeche = new Zeichenflaeche();
        zeichenflaeche.setPreferredSize(new Dimension(this.breite, this.laenge));
        zeichenflaeche.setBackground(this.hintergrundfarbe);

        Container cp = getContentPane();
        cp.add(zeichenflaeche);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void warten(int millisekunden) {

    }

    public void zeichnen(ArrayList<Rechteck> hindernisse) {

    }
    
    private class Zeichenflaeche extends JPanel {

        private ArrayList<Rechteck> hindernissRechtecks;
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for(Rechteck r : hindernissRechtecks) {
                g.drawRect(r.getPosition().getX(), r.getPosition().getY(), r.getBreite(), r.getLaenge());
                g.setColor(r.getFarbe());
            
            }

        }
    
        
        
    
    }

}