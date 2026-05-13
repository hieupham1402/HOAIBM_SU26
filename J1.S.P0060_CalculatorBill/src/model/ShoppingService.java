/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ShoppingService {
     public int calcTotal(int[] bills) {
        int total = 0;
        for (int bill : bills) {
            total = total + bill;
        }
        return total;
    }

    public boolean payMoney(Wallet wallet, int total){
        return wallet.getAmount() >= total;
    }
}
