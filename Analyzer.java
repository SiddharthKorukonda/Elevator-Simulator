/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

import java.util.Scanner;

/**
 * Runs the elevator simulation based on the given parameters (inputted by the user)
 */
public class Analyzer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the elevator simulator!");

        try {
            double probability;

            while (true) {
                System.out.print("Enter the probability of arrival for Requests: ");
                try {
                    probability = s.nextDouble();
                    if (probability >= 0.0 && probability <= 1.0) {
                        break;
                    } else {
                        System.out.println("Invalid probability. Please enter a value between 0.0 and 1.0.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.\n");
                    s.next();
                }
            }

            int number_of_floors;

            while (true) {
                System.out.print("Enter the number of floors: ");
                try {
                    number_of_floors = s.nextInt();

                    if (number_of_floors > 1) {
                        break;
                    } else if (number_of_floors < 0) {
                        System.out.print("A building with negative floors exists only in your imagination\n");
                    } else {
                        System.out.println("This building isn't flat.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.\n");
                    s.next();
                }
            }

            int number_of_elevators;

            while (true) {
                System.out.print("Enter the number of elevators: ");
                try {
                    number_of_elevators = s.nextInt();

                    if (number_of_elevators > 0) {
                        break;
                    } else if (number_of_elevators < 0) {
                        System.out.print("Negative number of elevators exists only in your imagination\n");
                    } else {
                        System.out.println("This building for sure has elevators.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.\n");
                    s.next();
                }
            }

            int simulationLength;

            while (true) {
                System.out.print("Enter the length of the simulation (in time units): ");
                try {
                    simulationLength = s.nextInt();
                    if (simulationLength > 0) {
                        break;
                    } else if (simulationLength < 0) {
                        System.out.print("Time doesn't move backwards");
                    } else {
                        System.out.println("Time can't be less than or equal to 0.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.\n");
                    s.next();
                }
            }

            Simulator.simulate(probability, number_of_floors, number_of_elevators, simulationLength);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            s.next();
        }
    }
}
