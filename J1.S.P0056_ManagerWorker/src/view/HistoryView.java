package view;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Validator;

public class HistoryView {

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
        System.out.println("========= Worker Management =========");
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

    public String getWorkerId() {
        while (true) {
            try {
                return Validator.validateString(getInput("Enter id: "), "[Ww]\\d+").toUpperCase();
            } catch (Exception e) {
                System.out.println("Invalid ID! Format: W + digits (e.g., W1)");
            }
        }
    }

    public String getWorkerName() {
        while (true) {
            try {
                return Validator.validateString(getInput("Enter Name: "), "[A-Za-z\\s]+");
            } catch (Exception e) {
                System.out.println("Name cannot be empty and must contain letters only.");
            }
        }
    }

    public int getWorkerAge() {
        while (true) {
            try {
                return Validator.validateInt(getInput("Enter age: "), 18, 50);
            } catch (Exception e) {
                System.out.println("Age must be between 18 and 50.");
            }
        }
    }

    public double getSalaryAmount() {
        while (true) {
            try {
                // Assuming salary must be greater than 0
                return Validator.validateDouble(getInput("Enter Salary: "), 0.000001, 10000);
            } catch (Exception e) {
                System.out.println("Salary must be a positive number.");
            }
        }
    }

    public String getWorkLocation() {
        while (true) {
            try {
                return Validator.validateString(getInput("Enter work location: "), "[A-Za-z0-9\\s]+");
            } catch (Exception e) {
                System.out.println("Location cannot be empty.");
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

    public void displayWorkers() {
        System.out.println(header);
        System.out.println(body);
    }
}
