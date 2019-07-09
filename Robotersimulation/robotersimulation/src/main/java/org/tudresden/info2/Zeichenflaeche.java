package org.tudresden.info2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Zeichenflaeche extends JPanel {

    private static final long serialVersionUID = 1L;

    private ArrayList<Rechteck> hindernisse;
    private Roboter robot;

    public Zeichenflaeche() {
        super();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(robot != null) {
            g.setColor(robot.getFarbe());
            g.fillOval(robot.minX(), robot.minY(), robot.getDurchmesser(), robot.getDurchmesser());
        }
        if (hindernisse != null) {
            for(Rechteck r : hindernisse) {
                g.setColor(r.getFarbe());
                g.fillRect(r.minX(), r.minY(), r.getBreite(), r.getLaenge());
            }
        }
    }

    public void setHindernisse(ArrayList<Rechteck> hindernisse) {
        this.hindernisse = hindernisse;
    }

    public void setRoboter(Roboter robot) {
        this.robot = robot;
    }
}