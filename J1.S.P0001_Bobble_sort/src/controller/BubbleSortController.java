/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.BubbleSort;
import model.BubbleSortService;
import view.BubbleSortView;

public class BubbleSortController {

    private BubbleSort model;
    private BubbleSortService service;
    private BubbleSortView view;

    // Constructor
    public BubbleSortController() {

        view = new BubbleSortView();

        service = new BubbleSortService();
    }

    // Run program
    public void run() {

        // Input size
        int size = view.inputSize();

        // Create model
        model = new BubbleSort(size);

        // Generate random array
        service.generateRandomArray(model);

        // Display unsorted array
        view.displayArray(
                model.getArray(),
                "Unsorted array: ");

        // Sort array
        service.bubbleSort(model);

        // Display sorted array
        view.displayArray(
                model.getArray(),
                "Sorted array: ");
    }
}