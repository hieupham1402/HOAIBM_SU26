/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class BubbleSort {

    // Array declaration
    private int[] array;

    // Constructor
    public BubbleSort(int size) {
        array = new int[size];
    }

    // Getter
    public int[] getArray() {
        return array;
    }

    // Setter
    public void setArray(int[] array) {
        this.array = array;
    }
}