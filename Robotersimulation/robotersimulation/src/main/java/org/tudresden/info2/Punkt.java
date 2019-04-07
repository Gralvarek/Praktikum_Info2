package org.tudresden.info2;

public class Punkt {
    
    private int x;
    private int y;
    
    public Punkt() {
    
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void bewegeUm(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public double gibAbstand(Punkt andererPunkt) {
        double dx = andererPunkt.getX() - this.x;
        double dy = andererPunkt.getY() - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void aktuellePositionAusgeben() {
        System.out.println(String.format("X Position: %d Y Position: %d", this.x, this.y));
    }

}