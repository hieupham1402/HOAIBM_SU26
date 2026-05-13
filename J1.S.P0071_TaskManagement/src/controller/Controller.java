/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TaskModel;
import entity.Task;
import java.util.Date;
import java.util.Scanner;
import utils.Validator;
import view.TaskView;

/**
 *
 * @author win
 */
public class Controller {

    private TaskModel taskModel;
    private TaskView view;
    private Scanner sc;

    public Controller(TaskModel taskModel, TaskView view) {
        this.taskModel = taskModel;
        this.view = view;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        view.addItem("Add Task");
        view.addItem("Delete Task");
        view.addItem("Display Task");
        view.addItem("exit");
        while (true) {
            view.showMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1:
                    handleAddTask();
                    break;
                case 2:
                    handleDeleteTask();
                    break;
                case 3:
                    handleShowTask();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public TaskModel getManagerTask() {
        return taskModel;
    }

    public void setManagerTask(TaskModel managerTask) {
        this.taskModel = managerTask;
    }

    private void handleAddTask() {
        System.out.println("------------Add Task------------");
        try {
            String name = view.getRequirementName();
            int typeID = view.getTaskTypeID();
            Date date = view.getDate();
            double from = view.getPlanFrom();
            double to = view.getPlanTo(from);
            String assign = view.getAssignee();
            String reviewer = view.getReviewer();

            int id = taskModel.add(typeID, name, date, from, to, assign, reviewer);
            System.out.println("Add success task id: " + id);
        } catch (Exception e) {
            System.out.println("Add failed: " + e.getMessage());
        }
    }

    private void handleDeleteTask() {
        System.out.println("------------Del Task------------");
        try {
            int id = view.getTaskID();
            Task task = taskModel.deleteTaskByID(id);
            System.out.println("Delete success task: " + task.getRequirementName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleShowTask() {
        if (taskModel.getList().isEmpty()) {
            System.out.println("List is empty!!!");
            return;
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date",
                "Time", "Assignee", "Reviewer"));
        for (Task task : taskModel.getList()) {
            result.append(task.toString());
        }
        view.setHeader("------------Show Task------------");
        view.setBody(result.toString());
        view.displayTasks();
    }
}
