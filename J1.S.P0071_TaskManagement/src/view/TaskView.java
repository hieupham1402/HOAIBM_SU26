package view;

import entity.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import utils.Validator;

public class TaskView {

    private String header;
    private String body;
    private String mess;
    private String error;
    ArrayList<String> menu = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addItem(String s) {
        menu.add(s);
    }

    public void showMenu() {
        System.out.println("========= Task Management =========");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public int getChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return Validator.validateInt(scanner.nextLine(), 1, menu.size());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public String getRequirementName() {
        while (true) {
            try {
                return Validator.validateString(getInput("Requirement Name: "), "[A-Za-z0-9\\s]+");
            } catch (Exception e) {
                System.out.println("Invalid name! Please use only letters and numbers.");
            }
        }
    }

    public int getTaskTypeID() {
        String menu = "1. Code\n2. Test\n3. Design\n4. Review\nEnter your choice: ";
        while (true) {
            try {
                return Validator.validateInt(getInput(menu), 1, 4);
            } catch (Exception e) {
                System.out.println("Task type must be 1-4.");
            }
        }
    }

    public Date getDate() {
        while (true) {
            try {
                // Assuming Validator.validateDate is implemented for dd-MM-yyyy
                return Validator.validateDate(getInput("Enter Date (dd-MM-yyyy): "), "dd-MM-yyyy");
            } catch (Exception e) {
                System.out.println("Invalid date! Use format: dd-MM-yyyy");
            }
        }
    }

    public double getPlanFrom() {
        while (true) {
            try {
                double val = Validator.validateDouble(getInput("From: "), 8.0, 17.0);
                if (val % 0.5 == 0) {
                    return val;
                }
                System.out.println("Plan time must be x.0 or x.5");
            } catch (Exception e) {
                System.out.println("Plan From must be within 8.0 - 17.0");
            }
        }
    }

    public double getPlanTo(double planFrom) {
        while (true) {
            try {
                double val = Validator.validateDouble(getInput("To: "), planFrom + 0.5, 17.5);
                if (val % 0.5 == 0) {
                    return val;
                }
                System.out.println("Plan time must be x.0 or x.5");
            } catch (Exception e) {
                System.out.println("Plan To must be within " + (planFrom + 0.5) + " - 17.5");
            }
        }
    }

    public String getAssignee() {
        while (true) {
            try {
                return Validator.validateString(getInput("Assignee: "), "[A-Za-z0-9\\s]+");
            } catch (Exception e) {
                System.out.println("Invalid Assignee name!");
            }
        }
    }

    public String getReviewer() {
        while (true) {
            try {
                return Validator.validateString(getInput("Reviewer: "), "[A-Za-z0-9\\s]+");
            } catch (Exception e) {
                System.out.println("Invalid Reviewer name!");
            }
        }
    }

    public int getTaskID() {
        while (true) {
            try {
                return Validator.validateInt(getInput("Task ID: "), 1, Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println("Task ID must be a positive integer.");
            }
        }
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }

    public void displayMessages() {
        System.out.println(mess);
    }

    public void displayErrorMessages() {
        System.out.println(error);
    }

    public void displayTasks() {
        System.out.println(header);
        System.out.println(body);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
