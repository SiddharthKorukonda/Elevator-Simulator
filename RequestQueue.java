/* Siddharth Korukonda
 * 115607752
 * CSE 214.30
 */

package Homework3;

import java.util.LinkedList;

/**
 * Represents the queue for the requests
 * Class extends the LinkedList for Requests
 */
public class RequestQueue extends LinkedList<Request> {
    /**
     * Adds a new passenger request to the queue
     * @param request added to the queue
     */
    public void enqueue(Request request) {
        this.addLast(request);
    }

    /**
     * Removes a new passenger request from the queue
     * @return the request that is supposed to be removed from the queue
     */
    public Request dequeue() {
        return this.removeFirst();
    }

    /**
     * Size of the queue for passenger's requests
     * @return the size of the queue for passenger's requests
     */
    public int size() {
        return super.size();
    }

    /**
     * Checks if the queue for passenger requests is empty or not
     * @return true if the passenger request queue is empty. False if the passenger request queue is not empty
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
