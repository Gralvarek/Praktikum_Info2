package org.tudresden.info2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Zeichenflaeche extends JPanel {

    private static final long serialVersionUID = 1L;

    private ArrayList<Rechteck> hindernisse;
    private Roboter robot;

    public void paintComponent(Graphics g) {
        g.setColor(robot.getFarbe());
        g.fillOval(robot.getPosition().getX(), robot.getPosition().getY(), robot.getDurchmesser(), robot.getDurchmesser());
        for(Rechteck r : hindernisse) {
            g.setColor(r.getFarbe());
            g.fillRect(r.getPosition().getX(), r.getPosition().getY(), r.getBreite(), r.getLaenge());
        }
    }

    public void setHindernisse(ArrayList<Rechteck> hindernisse) {
        this.hindernisse = hindernisse;
    }

    public void setRoboter(Roboter robot) {
        this.robot = robot;
    }
}