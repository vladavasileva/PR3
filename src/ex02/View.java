package ex02;

import java.io.IOException;
/** Product
 * (design pattern
 * Factory Method)<br>
 * Interface "fabricated"
 * objects <br>
 * Declares methods
 * object display
 * @author Vlada
 * @version 1.0
 */
public interface View {
    /** Displays title */
    void viewHeader();
    /** Displays the main part */
    void viewBody();

    /** Displays ending */
    void viewFooter();

    /** Displays the entire object */
    void viewShow();

    /** Performs initialization */
    void viewInit();
    /** Saves data for later recovery */
    void viewSave() throws IOException;
    /** Restores previously saved data */
    void viewRestore() throws Exception;
}