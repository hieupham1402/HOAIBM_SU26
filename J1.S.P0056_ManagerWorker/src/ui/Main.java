/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import model.SalaryHistoryModel;
import model.WorkerModel;
import view.HistoryView;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WorkerModel workers = new WorkerModel();
        SalaryHistoryModel histories = new SalaryHistoryModel();
        HistoryView view = new HistoryView();
        Controller control = new Controller(workers, histories, view);
        control.run();
 
    }

}
