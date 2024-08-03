/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

/**
 * Exception thrown when there is an error in the request information
 */
public class RequestErrorException extends Exception {
    public RequestErrorException(String message) {
        super(message);
    }
}
