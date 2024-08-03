/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

/**
 * Represents a request made by a passenger to use the elevator
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    /**
     * Constructor for the request
     * @param number_of_floors in the building
     */
    public Request(int number_of_floors) {
        this.sourceFloor = (int) (Math.random() * number_of_floors)+1;
        this.destinationFloor = (int) (Math.random() * number_of_floors)+1;

        while (this.sourceFloor == this.destinationFloor) {
            this.destinationFloor = (int) (Math.random() * number_of_floors)+1;
        }
    }

    /**
     * Gets the source floor of the passenger's request
     * @return the source floor
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Gets the destination floor of the passenger's request
     * @return the destination floor
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Gets the time when the passenger made the request
     * @return the time the request was made
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets the source floor of the passenger's request
     * @param sourceFloor of the request
     * @throws RequestErrorException if the request is invalid
     */
    public void setSourceFloor(int sourceFloor) throws RequestErrorException {
        if (sourceFloor < 1) {
            throw new RequestErrorException("Source floor must be greater than or equal to 1");
        }
        this.sourceFloor = sourceFloor;
    }

    /**
     * Sets the destination floor of the passenger's request
     * @param destinationFloor of the request
     * @throws RequestErrorException if the request is invalid
     */
    public void setDestinationFloor(int destinationFloor) throws RequestErrorException {
        if (destinationFloor < 1) {
            throw new RequestErrorException("Destination floor must be greater than or equal to 1");
        }
        this.destinationFloor = destinationFloor;
    }

    /**
     * Sets the time when the passenger made the request
     * @param timeEntered of the request
     * @throws RequestErrorException if the request is invalid
     */
    public void setTimeEntered(int timeEntered) throws RequestErrorException {
        if (timeEntered < 0) {
            throw new RequestErrorException("Time must be greater than 0");
        }
        this.timeEntered = timeEntered;
    }
}
