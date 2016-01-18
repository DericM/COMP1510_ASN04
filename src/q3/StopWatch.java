package q3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <p>
 * This class adds the panel to the frame.
 * </p>
 *
 * @author Deric
 * @version 1.0
 */
public class StopWatch extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -5640465042942452267L;
    /** Width of the screen. **/
    private final int width = 300;
    /** Length of the screen. **/
    private final int length = 200;

    /**
     * Constructor for StopWatch.
     */
    public StopWatch() {
        super("Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new StopWatchPanel());
        setSize(width, length);
        setVisible(true);

    }

    /**
     * <p>
     * Builds a Clock object and updates the time onto the panel. Adds the
     * buttons to the panel. Adds action listeners.
     * </p>
     * 
     * @author Deric
     * @version 1.0
     */
    private class StopWatchPanel extends JPanel {
        /**
         * 
         */
        private static final long serialVersionUID = 3708112439053723714L;
        /** Lable for the current time. **/
        private JLabel lable;
        /** Timer. **/
        private Timer timer;
        /** Start/Stop button. **/
        private JButton startStop;
        /** Reset button. **/
        private JButton reset;
        /** Clock to store the time. **/
        private Clock clock;
        /** Font for the lable. **/
        private Font font;

        /**
         * Default Constructor.
         */
        StopWatchPanel() {
            final int mili = 100;
            final int fontSize = 80;

            clock = new Clock();

            font = new Font("Ariel", 0, fontSize);
            lable = new JLabel("00:00:0", JLabel.CENTER);
            lable.setFont(font);

            startStop = new JButton("Start");
            reset = new JButton("Reset");

            startStop.addActionListener(new ButtonListener());
            reset.addActionListener(new ResetListener());
            timer = new Timer(mili, new TimerListener());

            add(lable);
            add(startStop);
            add(reset);
        }

        /**
         * Increments the clock and updates the label.
         *
         */
        private class TimerListener implements ActionListener {
            /**
             * Increments the clock and updates the label.
             * 
             * @param event ActionEvent
             */
            public void actionPerformed(ActionEvent event) {
                final int mili = 100;
                clock.increment(mili);
                lable.setText(clock.getTime());
            }
        }

        /**
         * Resets the labels.
         *
         */
        private class ButtonListener implements ActionListener {
            /**
             * Resets the labels.
             * 
             * @param event ActionEvent
             */
            public void actionPerformed(ActionEvent event) {

                if (startStop.getText().equals("Start")) {
                    startStop.setText("Stop");
                    timer.start();
                } else {
                    startStop.setText("Start");
                    timer.stop();
                }
            }
        }

        /**
         * When reset is clicked: Stop the clock. Reset clock. Refresh the
         * labels.
         *
         */
        private class ResetListener implements ActionListener {
            /**
             * When reset is clicked: Stop the clock. Reset clock. Refresh the
             * labels.
             * 
             * @param event ActionEvent
             */
            public void actionPerformed(ActionEvent event) {
                startStop.setText("Start");
                timer.stop();
                clock.reset();
                lable.setText(clock.getTime());
            }
        }

    }

    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        new StopWatch();

        System.out.println("Question three was called and ran sucessfully.");
    }

};
