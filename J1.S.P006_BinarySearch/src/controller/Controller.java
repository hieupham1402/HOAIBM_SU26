/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.MyArray;
import view.ArrayView;

/**
 *
 * @author Tuan Tran
 */
public class Controller {

    private MyArray array;
    private ArrayView view;

    public Controller() {
        view = new ArrayView();
    }

    public void run() {
        //Step 1: Enter number of random array
        int number = view.getNumberOfArray();
        try {
            //Step 2: Genenrate random array
            array = new MyArray(number);
            //Step 3: Display sorted array
            view.setArray(array.getArraySorted());
            view.displayArray();
            //Step 4: Enter key
            int key = view.getKey();
            //Step 5: Binary search to find key
            int index = array.binarySearch(key);
            //Step 6: Display index found
            view.setIndex(index);
            view.setKey(key);
            view.displayIndexOfKey();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
