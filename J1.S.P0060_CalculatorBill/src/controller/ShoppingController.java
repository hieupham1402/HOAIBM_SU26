/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Person;
import model.ShoppingService;
import model.Wallet;
import view.ShoppingView;

/**
 *
 * @author hieupm
 */
public class ShoppingController {

    private ShoppingView view;
    private ShoppingService service;

    public ShoppingController(){
        service = new ShoppingService();
        view = new ShoppingView();
    }
    
    public void run() {
        System.out.println("======= Shopping program ==========");
        
        //khai báo numberOfBill để lưu giá trị người dùng nhập
        int numberOfBills = view.getNumberOfBills();
        int[] bills = new int[numberOfBills];
        //vòng lặp for để lặp và lấy bill do người dùng nhập
        for (int i = 0; i < numberOfBills; i++) {
            bills[i] = view.getBillValue(i);
        }
        
        //khởi tạo walletAmout 
        int walletAmount = view.getWalletValue();
        
        Wallet wallet = new Wallet(walletAmount);
        Person person = new Person(bills, wallet);
        
        int total = service.calcTotal(person.getBills());
        
        boolean canPay = service.payMoney(person.getWallet(), total);
        view.showResult(total, canPay);
    }

}
