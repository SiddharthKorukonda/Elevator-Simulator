/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

/**
 * Represents an elevator in the building
 */
public class Elevator {
    private int currentFloor;
    private int elevatorState;
    private Request request;

    /**
     * Constructor for the elevator
     */
    public Elevator() {
        this.request = null;
        this.elevatorState = IDLE;
        this.currentFloor = 1;
    }

    public static final int IDLE = 0;
    public static final int TO_SOURCE = 1;
    public static final int TO_DESTINATION = 2;

    /**
     * Gets the current floor of the elevator
     * @return the current floor
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Gets the state of the elevator
     * @return the state of the elevator
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Gets the passenger's request
     * @return the passenger's request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets the current floor of the elevator
     * @param currentFloor of the elevator
     * @throws ElevatorErrorException if the Elevator information input is invalid
     */
    public void setCurrentFloor(int currentFloor) throws ElevatorErrorException {
        if (currentFloor < 1) {
            throw new ElevatorErrorException("Current floor must be greater than 1");
        }
        this.currentFloor = currentFloor;
    }

    /**
     * Sets the state of the elevator
     * @param elevatorState of the elevator
     * @throws ElevatorErrorException if the Elevator information is invalid
     */
    public void setElevatorState(int elevatorState) throws ElevatorErrorException {
        if (elevatorState != IDLE && elevatorState != TO_SOURCE && elevatorState != TO_DESTINATION) {
            throw new ElevatorErrorException("Elevator state is invalid");
        }
        this.elevatorState = elevatorState;
    }

    /**
     * Sets the passenger's request
     * @param request of the passenger
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * Checks if the elevator is idle or not
     * @return true if the elevator is idle. False if the elevator is not idle
     */
    public boolean isIdle() {
        return this.elevatorState == IDLE;
    }
}
