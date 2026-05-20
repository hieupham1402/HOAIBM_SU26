package view;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Constants;
import utils.Validator;

/**
 * Handles all keyboard input and console output for worker management.
 */
public class WorkerView {

    private String header;
    private String body;
    private String mess;
    private String error;
    private ArrayList<String> menuList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Adds one menu item to the menu list.
     *
     * @param item menu item text.
     */
    public void addItem(String item) {
        menuList.add(item);
    }

    /**
     * Displays the worker management menu.
     */
    public void showMenu() {
        System.out.println("======== Worker Management =========");

        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i));
        }
    }

    /**
     * Gets and validates menu choice.
     *
     * @return selected menu choice.
     */
    public int getChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return Validator.validateInt(scanner.nextLine(), 1, menuList.size());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Gets and validates worker code.
     *
     * @return valid worker code.
     */
    public String getCode() {
        while (true) {
            try {
                System.out.print("Enter Code: ");
                String code = Validator.validateString(scanner.nextLine(),
                        Constants.WORKER_CODE_REGEX);
                return code.toUpperCase();
            } catch (Exception e) {
                System.out.println("Error: Code must follow format W1, W2, W3...");
            }
        }
    }

    /**
     * Gets and validates worker name.
     *
     * @return valid worker name.
     */
    public String getName() {
        while (true) {
            try {
                System.out.print("Enter Name: ");
                return Validator.validateString(scanner.nextLine(), Constants.TEXT_REGEX);
            } catch (Exception e) {
                System.out.println("Error: Name only contains letters and spaces.");
            }
        }
    }

    /**
     * Gets and validates worker age.
     *
     * @return valid worker age.
     */
    public int getAge() {
        while (true) {
            try {
                System.out.print("Enter Age: ");
                return Validator.validateInt(scanner.nextLine(),
                        Constants.MIN_AGE, Constants.MAX_AGE);
            } catch (Exception e) {
                System.out.println("Error: Age must be in range [18, 50].");
            }
        }
    }

    /**
     * Gets and validates worker salary.
     *
     * @return valid worker salary.
     */
    public double getSalary() {
        return getPositiveMoney("Enter Salary: ");
    }

    /**
     * Gets and validates salary adjustment amount.
     *
     * @return valid adjustment amount.
     */
    public double getAmount() {
        return getPositiveMoney("Enter Salary: ");
    }

    /**
     * Gets and validates worker location.
     *
     * @return valid worker location.
     */
    public String getWorkLocation() {
        while (true) {
            try {
                System.out.print("Enter work location: ");
                return Validator.validateString(scanner.nextLine(), Constants.TEXT_REGEX);
            } catch (Exception e) {
                System.out.println("Error: Work location only contains letters and spaces.");
            }
        }
    }

    /**
     * Displays the salary adjustment form title.
     */
    public void displaySalaryFormTitle() {
        System.out.println("------- Up/Down Salary --------");
    }

    /**
     * Displays the salary history table.
     */
    public void displaySalaryInformation() {
        System.out.println("-------------------- Display Information Salary "
                + "-----------------------");
        System.out.println(header);
        System.out.print(body);
    }

    /**
     * Gets and validates a positive money value.
     *
     * @param message input message.
     * @return valid positive money value.
     */
    private double getPositiveMoney(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Validator.validateDouble(scanner.nextLine(),
                        Double.MIN_VALUE, Double.MAX_VALUE);
            } catch (Exception e) {
                System.out.println("Error: Salary must be greater than 0.");
            }
        }
    }

    /**
     * Sets table header content.
     *
     * @param header table header.
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Sets table body content.
     *
     * @param body table body.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Sets normal message content.
     *
     * @param mess normal message.
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Sets error message content.
     *
     * @param error error message.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Displays normal program message.
     */
    public void displayMessages() {
        System.out.println(mess);
    }

    /**
     * Displays error program message.
     */
    public void displayErrorMessages() {
        System.out.println(error);
    }
}
