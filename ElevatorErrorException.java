/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

/**
 * Exception thrown when there is an error in an elevator's operation or status
 */
public class ElevatorErrorException extends Exception {
    public ElevatorErrorException(String message) {
        super(message);
    }
}
