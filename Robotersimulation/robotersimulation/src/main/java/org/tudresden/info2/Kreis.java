package org.tudresden.info2;

import java.awt.Color;

public class Kreis extends Figur {

    protected int durchmesser;
    
    public Kreis(Punkt position, Color farbe, int durchmesser) {
        this.position = position;
        this.farbe = farbe;
        this.durchmesser = durchmesser;
    }

    public int getDurchmesser() {
        return this.durchmesser;
    }

    public void setDurchmesser(int durchmesser) {
        this.durchmesser = durchmesser;
    }

    @Override
    public int minX() {
        return durchmesser;
    }

    @Override
    public int minY() {
        return durchmesser;
    }

    @Override
    public int maxX() {
        return 1000-durchmesser;
    }

    @Override
    public int maxY() {
        return 1000-durchmesser;
    }
    
}