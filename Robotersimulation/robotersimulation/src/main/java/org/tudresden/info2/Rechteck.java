package org.tudresden.info2;

import java.awt.Color;

public class Rechteck extends Figur {
    
    private int breite;
    private int laenge;
    private String bezeichnung;
    private Punkt bottomRight, topLeft;

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
        this.bottomRight = new Punkt(position.getX() + this.breite/2, position.getY() + this.laenge/2);
        this.topLeft = new Punkt(position.getX() - this.breite/2, position.getY() - this.laenge/2);

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

    public boolean ueberlappt(Rechteck r) {
        if(this.minX() > r.maxX() || r.minX() > this.maxX()){
            return false;
        }
        if(this.minY() > r.maxY() || r.minY() > this.maxY()){
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("Position: %s\nBreite: %d Laenge: %d\nBezeichnung: %s\nFarbe: %s", this.position, this.breite, this.laenge, this.bezeichnung, this.farbe.toString());
    }

    @Override
    public int minX() {
        return this.topLeft.getX();
    }

    @Override
    public int minY() {
        return this.topLeft.getY();
    }

    @Override
    public int maxX() {
        return this.bottomRight.getX();
    }

    @Override
    public int maxY() {
        return this.bottomRight.getY();
    }
}