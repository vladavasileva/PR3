package ex02;

/** ConcreteCreator
 * (design pattern
 * Factory Method)<br>
 * Declares a method,
 * "fabricating" objects
 * @author Vlada
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {
    /** Creates a displayable {@linkplain ViewResult} */
    @Override
    public View getView() {
        return new ViewResult();
    }

}