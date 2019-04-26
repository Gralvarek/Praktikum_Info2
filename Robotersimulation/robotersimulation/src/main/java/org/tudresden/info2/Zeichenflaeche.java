package org.tudresden.info2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Zeichenflaeche extends JPanel {

    private static final long serialVersionUID = 1L;

    private ArrayList<Rechteck> hindernisse;

    public void paintComponent(Graphics g) {
        for(Rechteck r : hindernisse) {
            g.fillRect(r.getPosition().getX(), r.getPosition().getY(), r.getBreite(), r.getLaenge());
            g.setColor(r.getFarbe());
        }
    }

    public void setHindernisse(ArrayList<Rechteck> hindernisse) {
        this.hindernisse = hindernisse;
    }
}