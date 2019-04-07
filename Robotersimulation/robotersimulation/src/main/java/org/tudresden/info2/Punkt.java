package org.tudresden.info2;

public class Punkt {
    
    private int x;
    private int y;
    
    public Punkt() {

    }

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
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

    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }

}