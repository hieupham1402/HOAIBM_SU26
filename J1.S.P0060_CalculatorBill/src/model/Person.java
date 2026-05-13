/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author win
 */
public class Person {

    private Wallet wallet;
    private int[] bills;

    public Person(int[] bills, Wallet wallet) {
        this.bills = bills;
        this.wallet = wallet;
    }

    public int[] getBills() {
        return bills;
    }

    public void setBills(int[] bills) {
        this.bills = bills;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
}
