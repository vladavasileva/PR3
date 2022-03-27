package ex01;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Performs testing of developed classes.
 *
 * @author Vlada
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class MainTest {
    /**
     * Checking the core functionality of a class {@linkplain Calc}
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        calc.init(new double[]{0, 100, 200, 300});
        assertEquals(4, calc.getResult().getOnesNumber());
        calc.init(new double[]{25, 50, 75, 100});
        assertEquals(3, calc.getResult().getOnesNumber());
        calc.init(new double[]{50, 100, 150, 200});
        assertEquals(5, calc.getResult().getOnesNumber());
        calc.init(new double[]{100, 120, 140, 160});
        assertEquals(6, calc.getResult().getOnesNumber());
        calc.init(new double[]{0, 50, 100, 200});
        assertEquals(5, calc.getResult().getOnesNumber());
    }

    /**
     * Serialization check. Correctness of data recovery.
     */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        byte onesNumber;
        double []arguments;
        for (int ctr = 0; ctr < 360; ctr++) {
            arguments = new double[]{ctr, ctr, 360 - ctr, 360 - ctr};
            onesNumber = calc.init(arguments);
            try {
                calc.save();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
            calc.init(new double[]{360 - ctr, ctr, ctr, 360 - ctr});
            try {
                calc.restore();
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
            assertEquals(onesNumber, calc.getResult().getOnesNumber());
            assertArrayEquals(arguments, calc.getResult().getArguments());
        }
    }
}