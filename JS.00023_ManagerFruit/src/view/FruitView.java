/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import model.Fruit;
import model.Item;
import utils.Validator;

/**
 *
 * @author Tuan Tran
 */
public class FruitView {
private final Scanner sc = new Scanner(System.in);
    // Hiển thị menu chính của hệ thống 
    public void displayMenu() {
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
    }

    // Hiển thị danh sách trái cây theo định dạng bảng (chỉ hiển thị những trái có số lượng >0) 
    public void displayListFruit(ArrayList<Fruit> listFruit) {
        System.out.println("+------+--------------------+--------------------+------------+------------+");
        System.out.printf("|%-6s|%-20s|%-20s|%-12s|%-12s|\n", "No.", "Fruit Name", "Origin", "Price", "Quantity");
        System.out.println("+------+--------------------+--------------------+------------+------------+");
        int stt = 1;
        for (Fruit f : listFruit) {
            System.out.printf("|%-6d|%-20s|%-20s|%11.1f$|%12d|\n",
                    stt++, f.getFruitName(), f.getOrigin(), f.getPrice(), f.getQuantity());
        }
        System.out.println("+------+--------------------+--------------------+------------+------------+");
    }

    // Hiển thị hóa đơn sau khi khách hàng chọn mua xong
    public void displayOrder(ArrayList<Item> cart) {
        double total = 0;
        System.out.println("+------+--------------------+------------+------------+------------+");
        System.out.printf("|%-6s|%-20s|%-12s|%-12s|%-12s|\n", "No.", "Product", "Quantity", "Price", "Amount");
        System.out.println("+------+--------------------+------------+------------+------------+");
        int stt = 1;
        for (Item item : cart) {
            System.out.printf("|%-6d|%-20s|%12d|%11.1f$|%11.1f$|\n",
                    stt++, item.getFruitName(), item.getQuantity(), item.getPrice(), item.getAmount());
            total += item.getAmount();
        }
        System.out.println("+------+--------------------+------------+------------+------------+");
        System.out.printf(" Total: %47.1f$\n", total);
    }

    // Hiển thị tất cả các đơn hàng trong hệ thống (dành cho chức năng View Orders) 
    public void displayAllOrders(Hashtable<String, ArrayList<Item>> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        for (String customer : orders.keySet()) {
            System.out.println("Customer: " + customer.toUpperCase());
            displayOrder(orders.get(customer));
            System.out.println();
        }
    }

    // Các phương thức nhận dữ liệu sử dụng Validator 
private String inputRaw(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public int getMenuChoice() {
        while (true) {
            try {
                return Validator.validateInt(inputRaw("Enter your choice: "), 1, 4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputFruitId() {
        while (true) {
            try {
                return Validator.validateString(inputRaw("Enter fruit id: "), "^.+$");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputFruitName() {
        while (true) {
            try {
                return Validator.validateString(inputRaw("Enter fruit name: "), "^.+$");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double inputPrice() {
        while (true) {
            try {
                return Validator.validateDouble(inputRaw("Enter price: "), 0.1, Double.MAX_VALUE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputQuantity() {
        while (true) {
            try {
                return Validator.validateInt(inputRaw("Enter quantity: "), 1, Integer.MAX_VALUE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputOrigin() {
        while (true) {
            try {
                return Validator.validateString(inputRaw("Enter origin: "), "^.+$");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputCustomerName() {
        while (true) {
            try {
                return Validator.validateString(inputRaw("Enter customer name: "), "^[a-zA-Z\\s]+$");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean inputContinue(String message) {
        while (true) {
            try {
                String result = Validator.validateString(inputRaw(message), "^[YyNn]$");
                return result.equalsIgnoreCase("Y");
            } catch (Exception e) {
                System.out.println("Please enter Y or N.");
            }
        }
    }

    public int inputItemSelection(int max) {
        while (true) {
            try {
                return Validator.validateInt(inputRaw("Enter item (Enter 0 to exit!): "), 0, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
