package org.tudresden.info2;

import java.awt.Color;

public abstract class Figur {

    protected Punkt position;
    protected Color farbe;

    public void setPosition(Punkt andererPunkt) {
        this.position = andererPunkt;
    }

    public Punkt getPosition() {
        return this.position;
    }

    public Color getFarbe() {
        return this.farbe;
    }

    public void setFarbe(Color farbe) {
        if (farbe != Color.WHITE) {
            this.farbe = farbe;
        } else {
            System.out.println("Farbe darf nicht weiss sein!");
        }
    }

    public void bewegeUm(int dx, int dy) {
        this.position.bewegeUm(dx, dy);
    }

    public void bewegeUm(Punkt andererPunkt) {
        this.position.bewegeUm(andererPunkt.getX() - this.position.getX(), andererPunkt.getY() - this.position.getY());
    }

    public abstract int minX();
    public abstract int minY();
    public abstract int maxX();
    public abstract int maxY();

    
}