/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Validator;

/**
 *
 * @author Tuan Tran
 */
public class DoctorView {

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
        System.out.println("========= Doctor Management Program =========");
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

    public String getCode() {
        while (true) {
            try {
                System.out.print("Enter Code: ");
                // Regex handles "DOC" followed by whitespace and digits
                return Validator.validateString(scanner.nextLine(), "DOC\\s\\d+");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getName() {
        while (true) {
            try {
                System.out.print("Enter Name: ");
                return Validator.validateString(scanner.nextLine(), "^(?!\\s*$).+");
            } catch (Exception e) {
                System.out.println("Error: Name cannot be empty");
            }
        }
    }

    public String getSpecialization() {
        while (true) {
            try {
                System.out.print("Enter Specialization: ");
                return Validator.validateString(scanner.nextLine(), "^(?!\\s*$).+");
            } catch (Exception e) {
                System.out.println("Error: Specialization cannot be empty");
            }
        }
    }

    public int getAvailability() {
        while (true) {
            try {
                System.out.print("Enter Availability: ");
                return Validator.validateInt(scanner.nextLine(), 0, Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println("Error: Availability must be a non-negative number!");
            }
        }
    }

    public String getKeySearch() {
        while (true) {
            try {
                System.out.print("Enter search term: ");
                return Validator.validateString(scanner.nextLine(), "^(?!\\s*$).+");
            } catch (Exception e) {
                System.out.println("Error: Search term cannot be empty");
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

    public void displayDoctors() {
        System.out.println(header);
        System.out.println(body);
    }

}
