package q1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <p>
 * This program reads in a range of numbers from a file and uses them
 * to create a Range object. It then calls methods of that object to
 * calculate and print off the mean and standard diviation.
 * </p>
 *
 * @author Deric
 * @version 1.0
 */
public class Statistics {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        final int arraySize = 50;
        
        int[] input = new int[arraySize];
        int index = 0;
        Range range;
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            input[index++] = scan.nextInt();
        }
        scan.close();

        range = new Range(input, index);

        System.out.println("Mean:" + df.format(range.mean()));
        System.out.println("Standard Deviation: " + df.format(range.stDiv()));

        System.out.println("Question one was called and ran sucessfully.");
    }

};
