/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

import java.util.*;

/**
 * Simulates the elevator working based on the given parameters
 */
public class Simulator {
    /**
     * Simulates the elevator
     * @param probability of the passenger's request being introduced (per time unit)
     * @param number_of_floors in the building
     * @param number_of_elevators in the building
     * @param simulationLength of the elevator simulation (in time units)
     * @throws Exception if there is an error in the simulation parameters
     */
    public static void simulate(double probability, int number_of_floors, int number_of_elevators, int simulationLength) throws Exception {
        if (probability < 0 || probability > 1) {
            throw new InvalidProbabilityException("Probability must be between 0 and 1");
        } else if (number_of_floors <= 1) {
            throw new RequestErrorException("Number of floors must be greater than 1");
        } else if (number_of_elevators <= 0) {
            throw new ElevatorErrorException("Number of elevators must be greater than 0");
        } else if (simulationLength <= 0) {
            throw new RequestErrorException("Simulation length must be greater than 0");
        }

        BooleanSource booleanSource = new BooleanSource(probability);
        RequestQueue requestQueue = new RequestQueue();
        List<Elevator> elevators = new ArrayList<>();

        for (int i=0; i<number_of_elevators; i++) {
            elevators.add(new Elevator());
        }

        int requestCount = 0;
        int waitingSum = 0;

        for (int i=0; i<simulationLength; i++) {
            System.out.println("Step " + (i+1) + ":");
            if (booleanSource.requestArrived()) {
                Request request = new Request(number_of_floors);
                request.setTimeEntered(i);
                requestQueue.enqueue(request);

                System.out.println("     New request: Source = " + request.getSourceFloor() + ", Destination = " + request.getDestinationFloor() + ", Time Entered = " + request.getTimeEntered());
            } else {
                System.out.println("     Nothing arrives");
            }

            for (int j=0; j<elevators.size(); j++) {
                Elevator elevator = elevators.get(j);

                if (elevator.isIdle() && !requestQueue.isEmpty()) {
                    Request request = requestQueue.dequeue();
                    elevator.setRequest(request);
                    elevator.setElevatorState(Elevator.TO_SOURCE);

                    System.out.println("     Elevator assigned to request: Source = " + request.getSourceFloor() + ", Destination = " + request.getDestinationFloor());
                }
            }

            for (int k=0; k<elevators.size(); k++) {
                Elevator elevator = elevators.get(k);

                if (!elevator.isIdle()) {
                    Request request = elevator.getRequest();

                    if (elevator.getElevatorState() == Elevator.TO_SOURCE) {
                        if (elevator.getCurrentFloor() == request.getSourceFloor()) {
                            waitingSum += (i) - (request.getTimeEntered());
                            requestCount++;

                            elevator.setElevatorState(Elevator.TO_DESTINATION);

                            System.out.println("     Elevator reached source floor: Source = " + request.getSourceFloor() + ", Time = " + k);
                        } else {
                            if (elevator.getCurrentFloor() < request.getSourceFloor()) {
                                elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
                            } else {
                                elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
                            }
                        }

                    } else if (elevator.getElevatorState() == Elevator.TO_DESTINATION) {
                        if (elevator.getCurrentFloor() == request.getDestinationFloor()) {
                            elevator.setElevatorState(Elevator.IDLE);
                            elevator.setRequest(null);

                            System.out.println("     Elevator reached destination floor: Destination = " + request.getDestinationFloor() + ", Time = " + i);
                        } else {
                            if (elevator.getCurrentFloor() < request.getDestinationFloor()) {
                                elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
                            } else {
                                elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
                            }
                        }
                    }
                }
            }

            System.out.print("     Requests: ");
            if (requestQueue.isEmpty()) {
                System.out.println();
            } else {
                for (int j=0; j<requestQueue.size(); j++) {
                    Request request = requestQueue.get(j);
                    System.out.print("(" + request.getSourceFloor() + ", " + request.getDestinationFloor() + ", " + request.getTimeEntered() + ") ");
                }

                System.out.println();
            }

            System.out.print("     Elevators: ");

            for (int l=0; l<elevators.size(); l++) {
                Elevator elevator = elevators.get(l);

                if (elevator.isIdle()) {
                    System.out.print("[Floor " + elevator.getCurrentFloor() + ", IDLE, ---] ");
                } else {
                    Request request = elevator.getRequest();
                    String state;
                    if (elevator.getElevatorState() == Elevator.TO_SOURCE) {
                        state = "TO_SOURCE";
                    } else {
                        state = "TO_DESTINATION";
                    }
                    System.out.print("[Floor " + elevator.getCurrentFloor() + ", " + state + ", (" +
                            request.getSourceFloor() + ", " + request.getDestinationFloor() + ", " + request.getTimeEntered() + ")] ");
                }
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("Total Wait Time: " + waitingSum);
        System.out.println("Total Requests: " + requestCount);

        double average_wait_time = (double) waitingSum / requestCount;

        if (requestCount > 0) {
            double averageWaitTime = (double) waitingSum / requestCount;
            averageWaitTime = Math.round(averageWaitTime * 100.0) / 100.0;
            System.out.println("Average Wait Time: " + averageWaitTime);
        } else {
            System.out.println("Average Wait Time: 0.00");
        }
    }
}