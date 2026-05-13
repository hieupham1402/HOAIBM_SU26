/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import entity.TaskModel;
import view.TaskView;

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
        TaskModel tasks = new TaskModel();
        TaskView view = new TaskView();
        Controller control = new Controller(tasks, view);
        control.run();
    }

}
