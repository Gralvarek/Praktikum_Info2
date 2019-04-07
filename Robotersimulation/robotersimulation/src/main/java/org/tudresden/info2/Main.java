package org.tudresden.info2;

public class Main {
    public static void main(String[] args) {
        Punkt A = new Punkt();
        Punkt B = new Punkt();

        A.setX(4);
        A.setY(6);

        B.setX(10);
        B.setY(3);

        A.aktuellePositionAusgeben();
        B.aktuellePositionAusgeben();

        A.bewegeUm(3, 4);
        A.aktuellePositionAusgeben();

        System.out.println("Abstand: " + A.gibAbstand(B));
    }
}