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
public class ShoppingView {

    private final Scanner scanner = new Scanner(System.in);

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getNumberOfBills() {
        while (true) {
            try {
                return Validator.validateInt(getInput("Input number of bill: "), 1, 100);
            } catch (Exception e) {
                // e.getMessage() will return "Number is out of range" or "Invalid format" from Validator
                System.out.println(e.getMessage());
            }
        }
    }
    //2
    public int getBillValue(int i) {
        while (true) {
            try {
                return Validator.validateInt(getInput("Input value of bill " + (i + 1) + ": "), 1, Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println("Invalid bill value! Must be a positive number.");
            }
        }
    }

    public int getWalletValue() {
        while (true) {
            try {
                return Validator.validateInt(getInput("Input value of wallet: "), 1, Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println("Invalid wallet value! Must be a positive number.");
            }
        }
    }

    public void showResult(int total, boolean canPay) {
        System.out.println("\nThis is total of bill: " + total);
        System.out.println(canPay ? "You can buy it." : "You can’t buy it.");
    }
}
