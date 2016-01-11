package q2;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Sets the frame and the content pane.
 * 
 * @author Deric
 * @version 1.0
 */
public class DrawTriangle extends JFrame {

    /** Width of the screen. **/
    private final int width = 800;
    /** Length of the screen. **/
    private final int length = 800;

    /**
     * Default constructor.
     */
    public DrawTriangle() {
        super("Deric Mccadden, A00751277, 1D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawTrianglePanel());
        setSize(length, width);
        setVisible(true);
    }

    /**
     * Builds the Triangle object, adds it to the Panel, and changes its
     * dimensions when apropriate.
     * 
     * @author Deric
     * @version 1.0
     */
    private class DrawTrianglePanel extends JPanel implements MouseListener, 
        MouseMotionListener {

        /** The Triangle object to be added to the screen. **/
        private Triangle triangle;

        /**
         * Default Constructor.
         */
        DrawTrianglePanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        /**
         * paintComponent. Paints the Triangle to the screen.
         * 
         * @param g
         *            Graphics object to be painted on.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (triangle != null) {
                triangle.draw(g);
            }

            System.out.println("Paint called");
        }

        /**
         * Make a new triangle when the mouse is clicked, then repaint.
         * 
         * @param e
         *            the mouse event.
         */
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            triangle = new Triangle(p);
            repaint();

            System.out.println("Mouse pressed called");
        }

        /**
         * not used.
         * 
         * @param e
         *            the mouse event.
         */
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse released called");
        }

        /**
         * Resize the triangle and repaint.
         * 
         * @param e
         *            the mouse event.
         */
        public void mouseDragged(MouseEvent e) {
            triangle.resize(e.getPoint());
            repaint();
            System.out.println("Mouse dragged called");
        }

        /**
         * not used.
         * 
         * @param e
         *            the mouse event.
         */
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * not used.
         * 
         * @param e
         *            the mouse event.
         */
        public void mouseExited(MouseEvent e) {
        }

        /**
         * not used.
         * 
         * @param e
         *            the mouse event.
         */
        public void mouseClicked(MouseEvent e) {
        }

        /**
         * not used.
         * 
         * @param e
         *            the mouse event.
         */
        public void mouseMoved(MouseEvent e) {
        }

    }

    /**
     * Main entry point of the program.
     * 
     * @param args
     *            not used.
     */
    public static void main(String[] args) {
        new DrawTriangle();
    }

};
