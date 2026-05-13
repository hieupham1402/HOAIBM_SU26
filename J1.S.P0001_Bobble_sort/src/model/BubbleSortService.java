/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

public class BubbleSortService {

    // Generate random array
    public void generateRandomArray(BubbleSort bubbleSort) {

        Random rd = new Random();

        int[] array = bubbleSort.getArray();

        for (int i = 0; i < array.length; i++) {

            array[i] = rd.nextInt(100);
        }
    }

    // Bubble Sort algorithm
    public void bubbleSort(BubbleSort bubbleSort) {

        int[] array = bubbleSort.getArray();

        // Outer loop
        for (int i = 0; i < array.length - 1; i++) {

            boolean swapped = false;

            // Inner loop
            for (int j = 0; j < array.length - 1 - i; j++) {

                // Compare adjacent elements
                if (array[j] > array[j + 1]) {

                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swap -> already sorted
            if (!swapped) {

                break;
            }
        }
    }
}