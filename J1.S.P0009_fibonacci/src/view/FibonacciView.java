/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import utils.Validator;

/**
 *
 * @author Tuan Tran
 */
public class FibonacciView {

    private int[] array;
    private int number;
    Scanner scanner = new Scanner(System.in);

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfFibonacci() {
        while (true) {
            try {
                System.out.print("Enter number of fibonacci sequence: ");
                String input = scanner.nextLine();
                number = Validator.validateInt(input, 1, 1000);
                return number;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setArray(int[] array) {
        if (array != null) {
            this.array = array;
        } else {
            throw new NullPointerException();
        }
    }

    public void display() {
        System.out.println("The " + number + " sequence fibonacci:");
        // In dãy số ra màn hình
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                System.out.print(".");
            } else {
                System.out.print(", ");
            }
        }
    }
}
