/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import utils.Validator;

public class BubbleSortView {

    // Scanner should be in View
    private Scanner sc;

    // Constructor
    public BubbleSortView() {

        sc = new Scanner(System.in);
    }

    // Input array size
    public int inputSize() {

        while (true) {

            try {

                System.out.print("Enter number of array: ");

                String input = sc.nextLine();

                // Validate positive integer
                int size = Validator.validateInt(input, 1, 1000);

                return size;

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }
    }

    // Display array
    public void displayArray(int[] arr, String message) {

        System.out.print(message);

        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);

            if (i < arr.length - 1) {

                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
