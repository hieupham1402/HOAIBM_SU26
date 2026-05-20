package controller;

import java.util.List;
import model.SalaryHistory;
import model.SalaryStatus;
import model.Worker;
import model.WorkerService;
import view.WorkerView;

/**
 * Controls the Worker Management menu flow.
 */
public class WorkerController {

    private WorkerView view;
    private WorkerService service;

    /**
     * Creates the view and service used by the controller.
     */
    public WorkerController() {
        service = new WorkerService();
        view = new WorkerView();
    }

    /**
     * Displays the menu and dispatches each selected function.
     */
    public void run() {
        view.addItem("Add Worker");
        view.addItem("Up salary");
        view.addItem("Down salary");
        view.addItem("Display Information salary");
        view.addItem("Exit");

        int choice;
        do {
            view.showMenu();
            choice = view.getChoice();

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    changeSalary(SalaryStatus.UP);
                    break;
                case 3:
                    changeSalary(SalaryStatus.DOWN);
                    break;
                case 4:
                    displaySalaryInformation();
                    break;
                case 5:
                    view.setMess("Exiting program...");
                    view.displayMessages();
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }

    /**
     * Gets worker information from the view and asks service to save it.
     */
    private void addWorker() {
        try {
            Worker worker = new Worker(
                    view.getCode(),
                    view.getName(),
                    view.getAge(),
                    view.getSalary(),
                    view.getWorkLocation()
            );

            service.addWorker(worker);
            view.setMess("Worker added successfully: " + worker);
            view.displayMessages();
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.displayErrorMessages();
        }
    }

    /**
     * Gets salary adjustment input and asks service to update salary history.
     *
     * @param status the direction of salary adjustment.
     */
    private void changeSalary(SalaryStatus status) {
        try {
            view.displaySalaryFormTitle();

            String code = view.getCode();
            double amount = view.getAmount();

            service.changeSalary(status, code, amount);
            view.setMess("Salary changed successfully.");
            view.displayMessages();
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.displayErrorMessages();
        }
    }

    /**
     * Gets adjusted salary history from service and sends it to the view.
     */
    private void displaySalaryInformation() {
        List<SalaryHistory> salaryHistoryList = service.getInfomationSalary();

        if (salaryHistoryList.isEmpty()) {
            view.setError("No salary history found.");
            view.displayErrorMessages();
            return;
        }

        view.setHeader(String.format("%-10s %-20s %-5s %-12s %-8s %-12s",
                "Code", "Name", "Age", "Salary", "Status", "Date"));

        StringBuilder body = new StringBuilder();
        for (SalaryHistory history : salaryHistoryList) {
            body.append(String.format("%-10s %-20s %-5d %-12.2f %-8s %-12s%n",
                    history.getWorker().getCode(),
                    history.getWorker().getName(),
                    history.getWorker().getAge(),
                    history.getSalary(),
                    history.getStatus(),
                    history.getDateString()));
        }

        view.setBody(body.toString());
        view.displaySalaryInformation();
    }
}
