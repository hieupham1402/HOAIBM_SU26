/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Item;
import view.FruitView;

public class FruitController {

    private ArrayList<Fruit> listFruit;
    private Hashtable<String, ArrayList<Item>> orders;
    private FruitView view;

    // Constructor khởi tạo các thuộc tính của Controller
    public FruitController() {
        this.listFruit = new ArrayList<>();
        this.orders = new Hashtable<>();
        this.view = new FruitView();
    }

    public void run() {
        generateFruit();
        while (true) {
            view.displayMenu();
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    view.displayAllOrders(orders);
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    return;
            }
        }
    }

    // Chức năng 1: Tạo trái cây mới
    public void createFruit() {
        while (true) {
            String id = view.inputFruitId();
            Fruit existing = findFruitById(id);

            if (existing != null) {
                System.out.println("ID already exists! Current quantity: " + existing.getQuantity());
            } else {
                String name = view.inputFruitName();
                double price = view.inputPrice();
                int quantity = view.inputQuantity();
                String origin = view.inputOrigin();
                listFruit.add(new Fruit(id, name, price, quantity, origin));
            }

            if (!view.inputContinue("Do you want to continue (Y/N): ")) {
                break;
            }
        }
    }

    // Chức năng 2: Mua hàng
    public void shopping() {
        // Lọc danh sách trái cây có số lượng > 0 [cite: 28]
        ArrayList<Fruit> availableFruits = new ArrayList<>();
        for (Fruit f : listFruit) {
            if (f.getQuantity() > 0) {
                availableFruits.add(f);
            }
        }

        if (availableFruits.isEmpty()) {
            System.out.println("Sorry, all fruits are out of stock!");
            return;
        }

        ArrayList<Item> cart = new ArrayList<>();
        while (true) {
            // Hiển thị danh sách đã lọc [cite: 16, 26]
            view.displayListFruit(availableFruits);
            int itemNo = view.inputItemSelection(availableFruits.size());

            if (itemNo == 0) {
                break;
            }

            Fruit selectedFruit = availableFruits.get(itemNo - 1);
            System.out.println("You selected: " + selectedFruit.getFruitName());

            int quantity = view.inputQuantity();

            if (quantity > selectedFruit.getQuantity()) {
                System.out.println("Not enough stock! Max available: " + selectedFruit.getQuantity());
            } else {
                // Cập nhật số lượng trong kho
                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
                cart.add(new Item(selectedFruit.getFruitId(), selectedFruit.getFruitName(), quantity, selectedFruit.getPrice()));

                // Nếu hết hàng sau khi mua, cập nhật lại danh sách hiển thị
                if (selectedFruit.getQuantity() == 0) {
                    availableFruits.remove(selectedFruit);
                }
            }

            if (availableFruits.isEmpty() || !view.inputContinue("You want to continue (Y/N): ")) {
                break;
            }
        }

        if (!cart.isEmpty()) {
            view.displayOrder(cart);
            String customerName = view.inputCustomerName();

            // LOGIC QUAN TRỌNG: Kiểm tra khách hàng cũ để cộng dồn đơn hàng
            if (orders.containsKey(customerName)) {
                // Nếu khách đã có đơn hàng, lấy danh sách cũ và thêm giỏ hàng hiện tại vào
                orders.get(customerName).addAll(cart);
            } else {
                // Nếu khách mới, tạo mới entry trong Hashtable
                orders.put(customerName, cart);
            }
        }
    }

    private Fruit findFruitById(String id) {
        for (Fruit f : listFruit) {
            if (f.getFruitId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }

    public void generateFruit() {
        listFruit.add(new Fruit("F01", "Cam", 2000, 3, "Hanoi"));
        listFruit.add(new Fruit("F02", "Quyt", 4000, 6, "Hanoi"));
        listFruit.add(new Fruit("F03", "Dua", 5000, 5, "Can Tho"));
        listFruit.add(new Fruit("F04", "Thang Long", 5000, 5, "Can Tho"));
        listFruit.add(new Fruit("F05", "Na", 5000, 5, "Can Tho"));
        listFruit.add(new Fruit("F06", "Hong Xiem", 5000, 5, "Can Tho"));
    }
}
