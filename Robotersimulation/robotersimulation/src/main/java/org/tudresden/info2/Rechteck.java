package org.tudresden.info2;

import java.awt.Color;

public class Rechteck {
    
    private Punkt position;
    private int breite;
    private int laenge;
    private String bezeichnung;
    private Color farbe;

    private Punkt bottomLeft, topRight;

    public Rechteck() {

    }

    public Rechteck(Punkt position, int breite, int laenge, String bezeichnung, Color farbe) {
        this.position = position;
        this.breite = breite;
        this.laenge = laenge;
        this.bezeichnung = bezeichnung;
        if(farbe != Color.WHITE) {
            this.farbe = farbe;
        } else {
            System.out.println("Farbe darf nicht weiss sein! Jetzt ist es rot.");
            this.farbe = Color.RED;
        }
        this.bottomLeft = new Punkt(position.getX() - this.breite/2, position.getY() - this.laenge/2);
        this.topRight = new Punkt(position.getX() + this.breite/2, position.getY() + this.laenge/2);

    }

    public Punkt getPosition() {
        return this.position;
    }

    public void setPosition(Punkt andererPunkt) {
        this.position = andererPunkt;
    }

    public int getBreite() {
        return this.breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getLaenge() {
        return this.laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
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
        this.position = andererPunkt;
    }

    public boolean ueberlappt(Rechteck r) {
        if(this.topRight.getY() < r.bottomLeft.getY() || this.bottomLeft.getY() > r.topRight.getY()) {
            return false;
        }
        if(this.topRight.getX() < r.bottomLeft.getX() || this.bottomLeft.getX() > r.topRight.getX()) {
             return false;
        }
        return true;
    }

    public String toString() {
        return String.format("Position: %s\nBreite: %d Laenge: %d\nBezeichnung: %s\nFarbe: %s", this.position, this.breite, this.laenge, this.bezeichnung, this.farbe.toString());
    }
}