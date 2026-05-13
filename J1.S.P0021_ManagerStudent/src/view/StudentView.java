package view;

import java.util.ArrayList;
import java.util.HashMap;
import model.Student;
import java.util.List;
import java.util.Scanner;
import model.Course;
import utils.Validator;

public class StudentView {

    private String mess;
    private String error;
    ArrayList<String> menu = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addItem(String s) {
        menu.add(s);
    }

    public void showMenu() {
        System.out.println("========= WELCOME TO STUDENT MANAGEMENT =========");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public int getChoice(int size) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return Validator.validateInt(scanner.nextLine(), 1, size);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public String getId() {
        while (true) {
            try {
                return Validator.validateString(getInput("Enter id: "), "[Ss]\\d+");
            } catch (Exception e) {
                System.out.println("Invalid ID format (e.g., S1, S2)!");
            }
        }
    }

    public String getStudentName() {
        while (true) {
            try {
                return Validator.validateString(getInput("Enter name student: "), "[A-Za-z\\s]+").toUpperCase();
            } catch (Exception e) {
                System.out.println("Name cannot be empty and must contain letters only!");
            }
        }
    }

    public String getSemester() {
        while (true) {
            try {
                return Validator.validateString(getInput("Enter Semester: "), "^(Spring|Summer|Fall)\\d{4}$");
            } catch (Exception e) {
                System.out.println("Invalid semester! Format: [Spring|Summer|Fall][Year] (e.g., Fall2022)");
            }
        }
    }

    public Course getCourse() {
        String msg = "Only three courses:\n\t1-Java\n\t2-.Net\n\t3-C/C++\nEnter your choice: ";
        while (true) {
            try {
                int choice = Validator.validateInt(getInput(msg), 1, 3);
                return Course.getLanguage(choice);
            } catch (Exception e) {
                System.out.println("Please enter a number from 1 to 3!");
            }
        }
    }

    public boolean getContinueChoice() {
        while (true) {
            try {
                String choice = Validator.validateString(getInput("Do you want to continue (Y/N)? "), "^[YNyn]$");
                return choice.equalsIgnoreCase("Y");
            } catch (Exception e) {
                System.out.println("Please enter Y or N!");
            }
        }
    }

    public String getUpdateOrDelete() {
        while (true) {
            try {
                return Validator.validateString(getInput("Do you want to update (U) or delete (D): "), "^[UuDd]$");
            } catch (Exception e) {
                System.out.println("Please enter U (Update) or D (Delete)!");
            }
        }
    }

    public String getSearchName() {
        return getInput("Enter name student to search: ");
    }

    public void displayStudents(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty!!!");
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                "Semester", "Course Name"));
        for (int i = 0; i < list.size(); i++) {
            result.append(String.format("|%5s|%15s|%10s|%15s|\n", i + 1,
                    list.get(i).getStudentName(),
                    list.get(i).getSemester(),
                    list.get(i).getCourse().valueLanguage()));
        }
        System.out.println(result.toString());
    }

    public void showReport(HashMap<String, Integer> reports) {
        if (reports.isEmpty()) {
            System.out.println("List is empty!!!");
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name", "Course", "Total of Course"));
        int count = 1;
        for (String key : reports.keySet()) {
            String[] parts = key.split("#");
            String studentName = parts[1];
            String course = parts[2];
            int total = reports.get(key);
            result.append(String.format("|%5s|%15s|%10s|%15s|\n", count++, studentName, course, total));
        }
        System.out.println(result.toString());
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

}
