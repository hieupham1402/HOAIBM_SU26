/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Fibonacci;
import view.FibonacciView;

/**
 *
 * @author Tuan Tran
 */
public class Controller {

    private FibonacciView view;
    private Fibonacci fiboSequence;

    public Controller() {
        this.view = new FibonacciView();
    }

    public void run() {
        //Cô hoài hiêu cầu phải nhập số lượng number 
        //cần sinh ra trong dãy fibonacci, ko mặc định là 45 nữa (Yêu cầu thì mới làm)
        //int number = 45;
        int number = view.getNumberOfFibonacci();
        fiboSequence = new Fibonacci(number);
        int array[] = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = fiboSequence.getFibonacci(i);
        }
        view.setArray(array);
        view.display();
    }
}
