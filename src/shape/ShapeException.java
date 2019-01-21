package shape;

import java.lang.Exception;

/** Helps to throw exceptions about Shape hierarchy that extends from Exception.
 * @author Tolga Reis
 * @version 1.0
 */

public class ShapeException extends Exception{
    private String message;
    /** No parameter constructor that sets message to "ERROR!".
     */
    public ShapeException(){
        this.message = new String("\nERROR!\n");
    }
    /** Takes a string as parameter and sets it as message.
     * @param newMessage setted as message.
     */
    public ShapeException(String newMessage){
        this.message = newMessage;
    }
    /** Returns the message to screen error.
     * @return this.message returns class field message.
     */
    public String what(){
        return this.message;
    }
}
