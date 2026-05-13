/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tuan Tran
 */
public class Item {

    private String fruitId;
    private String fruitName;
    private int quantity;
    private double price;
    private double amount;

    public Item(String fruitId, String fruitName, int quantity, double price) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
        this.amount = quantity * price;
    }

    public String getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
