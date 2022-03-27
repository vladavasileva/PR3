package ex01;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stores the initial data and the result of calculations.
 *
 * @author Vlada
 * @version 1.0
 */

public class Item2d implements Serializable {
    /**
     * The number of units in the number.
     */
    private byte onesNumber;

    /**
     * Function arguments.
     */
    private double []arguments;

    /**
     * Automatically generated constant
     */
    private static final long serialVersionUID = 1L;

    /**
     * Initializes fields {@linkplain Item2d#onesNumber}, {@linkplain Item2d#arguments}
     */
    public Item2d() {
        onesNumber = 0;
        arguments = new double[4];
    }

    /**
     * Sets field values: arguments
     * and the result of the function evaluation.
     *
     * @param onesNumber - value to initialize the field {@linkplain Item2d#onesNumber}
     * @param arguments - value to initialize the field {@linkplain Item2d#arguments}
     */
    public Item2d(byte onesNumber, double []arguments) {
        this.onesNumber = onesNumber;
        this.arguments = arguments;
    }

    /**
     * Setting a field value {@linkplain Item2d#onesNumber}
     *
     * @param onesNumber - value for{@linkplain Item2d#onesNumber}
     * @return value {@linkplain Item2d#onesNumber}
     */
    public byte setOnesNumber(byte onesNumber) {
        return this.onesNumber = onesNumber;
    }

    /**
     * Getting the value of a field {@linkplain Item2d#onesNumber}
     *
     * @return value {@linkplain Item2d#onesNumber}
     */
    public byte getOnesNumber() {
        return onesNumber;
    }

    /**
     * Setting a field value {@linkplain Item2d#arguments}
     *
     * @param arguments - value for {@linkplain Item2d#arguments}
     * @return value {@linkplain Item2d#arguments}
     */
    public double []setArguments(double []arguments) {
        return this.arguments = arguments;
    }

    /**
     * Getting the value of a field{@linkplain Item2d#arguments}
     *
     * @return value {@linkplain Item2d#arguments}
     */
    public double []getArguments() {
        return arguments;
    }

    /**
     * Setting values  {@linkplain Item2d#onesNumber} è {@linkplain Item2d#arguments}
     *
     * @param onesNumber - value for {@linkplain Item2d#onesNumber}
     * @param arguments - value for {@linkplain Item2d#arguments}
     * @return this
     */
    public Item2d setOnesNumberAndArguments(byte onesNumber, double []arguments) {
        this.onesNumber = onesNumber;
        this.arguments = arguments;
        return this;
    }

    /**
     * Represents the result of a calculation as a string. {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Number of one = " + onesNumber + ", arguments = " + Arrays.toString(arguments);
    }

    /**
     * An automatically generated method.{@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item2d other = (Item2d) obj;
        if(onesNumber != other.onesNumber) {
            return false;
        }

        return !Arrays.equals(arguments, other.arguments);
    }
}