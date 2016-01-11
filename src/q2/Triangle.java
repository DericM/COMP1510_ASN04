package q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 * An object representing a equallateral triangle.
 * 
 * @author Deric
 * @version 1.0
 */
public class Triangle {

    /** The center point. */
    private Point center;
    /** Point A. */
    private Point a;
    /** Point B. */
    private Point b;
    /** Point C. */
    private Point c;
    /** The color of the triangle. */
    private Color color;
    /** Random number. */
    private Random generator;

    /**
     * Default constructor.
     * 
     * @param p
     *            The center point of the triangle.
     */
    public Triangle(Point p) {
        final int rgbMax = 16777216;
        generator = new Random();
        color = new Color(Math.abs(generator.nextInt()) % rgbMax);
        center = new Point(p);
        a = new Point(p);
        b = new Point(p);
        c = new Point(p);
    }

    /**
     * Draws the Triangle.
     * 
     * @param page
     *            the Graphics to draw on.
     */
    public void draw(Graphics page) {
        final int numOfPoints = 3;
        int[] xPoints = { a.x, b.x, c.x };
        int[] yPoints = { a.y, b.y, c.y };
        page.setColor(color);
        page.fillPolygon(xPoints, yPoints, numOfPoints);
    }

    /**
     * Set a to a new location. Calculate Points b and c to match a.
     * 
     * @param p
     *            the new location of Point a.
     */
    public void resize(Point p) {
        final int deg120 = 120;
        final int deg240 = 240;
        a.setLocation(p);
        b.setLocation(rotate(p, deg120));
        c.setLocation(rotate(p, deg240));
    }

    /**
     * Rotate a point around a center point a number of degrees.
     * 
     * @param p
     *            the starting point.
     * @param deg
     *            the degrees to rotate.
     * @return the end Point after rotation.
     */
    private Point rotate(Point p, int deg) {
        Point[] pt = { new Point(p.x, p.y) };
        AffineTransform.getRotateInstance(
                Math.toRadians(deg), center.x, center.y)
                    .transform(pt, 0, pt, 0, 1);
        return pt[0];
    }

}