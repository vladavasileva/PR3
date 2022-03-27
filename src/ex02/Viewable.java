package ex02;
/** Creator
 * (design pattern
 * Factory Method)<br>
 * Declares a method,
 * "fabricating" objects
 * @author Vlada
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {
    /** Creates an object that implements{@linkplain View} */
    View getView();

}