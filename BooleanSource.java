/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

/**
 * Represents a source that determines whether a new request has been made by a passenger based on a specific probability
 */
public class BooleanSource {
    private double probability;

    /**
     * Constructor for the source that determines whether a new request has been made by a passenger based on a specific probability
     * @param probability of a passenger request being made
     * @throws InvalidProbabilityException if the probability is invalid
     */
    public BooleanSource(double probability) throws InvalidProbabilityException {
        if (probability < 0.0 || probability > 1.0) {
            throw new InvalidProbabilityException("Invalid probability");
        }
        this.probability = probability;
    }

    /**
     * Determines if a new passenger request has arrived
     * @return true if a new passenger request has arrived. False if a new passenger request didn't arrive
     */
    public boolean requestArrived() {
        return Math.random() < probability;
    }
}
