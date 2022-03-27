package ex01;

import java.io.*;

/**
 * Contains the implementation of methods for calculating and displaying results.
 *
 * @author Vlada
 * @version 1.0
 */

public class Calc {
    /**
     * The name of the file to use during serialization.
     */
    private static final String FNAME = "ex0.Data.bin";
    /**
     * Stores the result of a calculation. class object {@linkplain Item2d}
     */
    private Item2d result;

    /**
     * Initializes {@linkplain Calc#result}
     */
    public Calc() {
        result = new Item2d();
    }

    /**
     * Set value  {@linkplain Calc#result}
     *
     * @param result - the new value of the object reference {@linkplain Item2d}
     */
    public void setResult(Item2d result) {
        this.result = result;
    }

    /**
     * Get value {@linkplain Calc#result}
     *
     * @return the current value of the object reference {@linkplain Item2d}
     */
    public Item2d getResult() {
        return result;
    }

    /**
     * Calculates the value of a function.
     *
     * @param arguments - arguments of the computed function.
     * @return function evaluation result.
     */
    private byte calc(double []arguments) {
        int number = (int)((Math.sin(arguments[0]) + Math.sin(arguments[1]) + Math.sin(arguments[2]) + Math.sin(arguments[3])) / 4.0 * 1000);
        byte count = 0;

        if(number < 0) {
            number *= -1;
        }

        while (number > 0) {
            number &= (number - 1);
            count++;
        }

        return count;
    }

    /**
     * Calculates the value of a function and saves
     * result in object{@linkplain Calc#result}
     *
     * @param arguments - arguments of the computed function.
     */
    public byte init(double []arguments) {
        result.setArguments(arguments);
        return result.setOnesNumber(calc(arguments));
    }

    /**
     * Displays the result of a calculation.
     */
    public void show() {
        System.out.println(result);
    }

    /**
     * Saves {@linkplain Calc#result}in a file {@linkplain Calc#FNAME}
     *
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Restores {@linkplain Calc#result} from a file {@linkplain Calc#FNAME}
     *
     * @throws Exception
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }
}
