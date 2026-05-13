/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Arrays;
import java.util.Scanner;
import utils.Validator;

/**
 *
 * @author Tuan Tran
 */
public class ArrayView {

    private int[] array;
    private int key;
    private int index;
    Scanner scanner = new Scanner(System.in);

    public int getNumberOfArray() {
        while (true) {
            try {
                System.out.print("Enter number of array: ");
                String input = scanner.nextLine();
                int number = Validator.validateInt(input, 1, 1000);
                return number;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getKey() {
        while (true) {
            try {
                System.out.print("Enter search value: ");
                String input = scanner.nextLine();
                int number = Validator.validateInt(input, -1000, 1000);
                return number;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void displayArray() {
        System.out.println("The array: " + Arrays.toString(array));
    }

    public void displayIndexOfKey() {
        if (index < 0) {
            System.out.println("Can not found");
        } else {
            System.out.println("Found " + key + " at index: " + index);
        }
    }

    public void setArray(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Array can not null!");
        }
        this.array = array;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
