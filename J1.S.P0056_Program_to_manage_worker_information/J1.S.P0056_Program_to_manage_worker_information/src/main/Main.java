package main;

import controller.WorkerController;

/**
 * Starts the Worker Management program.
 */
public class Main {

    /**
     * Creates the controller and runs the application.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        WorkerController controller = new WorkerController();
        controller.run();
    }
}
