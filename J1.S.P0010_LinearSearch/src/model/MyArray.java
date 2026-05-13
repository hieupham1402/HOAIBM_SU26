/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author win
 */
public class MyArray {

    private int[] array;

    public MyArray(int number) throws Exception {
        if (number <= 0) {
            throw new Exception("Number of array must be >0");
        }
        array = new int[number];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(number);
        }
    }

    public int[] getArray() {
        return array;
    }

    public MyArray(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Array can not null!");
        }
        this.array = array;
    }

    public int linearSearch(int key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
}
