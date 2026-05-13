/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
import model.SalaryHistoryModel;
import model.WorkerModel;
import model.SalaryHistory;
import model.SalaryStatus;
import model.Worker;
import java.util.Date;
import java.util.Scanner;
import view.HistoryView;

/**
 *
 * @author win
 */
public class Controller {

    private WorkerModel workerModel;
    private SalaryHistoryModel historyModel;
    private HistoryView view;
    private Scanner sc;

    public Controller(WorkerModel workerModel, SalaryHistoryModel historyModel, HistoryView view) {
        this.workerModel = workerModel;
        this.historyModel = historyModel;
        this.view = view;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        view.addItem("Add Worker");
        view.addItem("Up salary");
        view.addItem("Down salary");
        view.addItem("Display Information salary");
        view.addItem("Exit");
        do {
            view.showMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1:
                    handleAddWorker();
                    break;
                case 2:
                    handleUpSalary();
                    break;
                case 3:
                    handleDownSalary();
                    break;
                case 4:
                    showHistory();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public void handleAddWorker() {
        String id = view.getWorkerId();
        String name = view.getWorkerName();
        int age = view.getWorkerAge();
        double salary = view.getSalaryAmount();
        String location = view.getWorkLocation();

        Worker worker = new Worker(id, name, age, salary, location);
        try {
            if (workerModel.add(worker)) {
                view.setMess("Add success: " + id);
                view.displayMessages();
            } else {
                view.setError("Error: Worker ID already exists!");
                view.displayErrorMessages();
            }
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.displayErrorMessages();
        }
    }

    public void handleUpSalary() {
        String code = view.getWorkerId();
        double amount = view.getSalaryAmount();
        try {
            Worker worker = workerModel.changeSalary(SalaryStatus.UP, code, amount);
            SalaryHistory history = new SalaryHistory(worker, worker.getSalary(), SalaryStatus.UP, new Date());
            if (historyModel.addSalaryHistory(history)) {
                view.setMess("Up salary success for: " + code);
                view.displayMessages();
            }
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.displayErrorMessages();
        }
    }

    public void handleDownSalary() {
        String code = view.getWorkerId();
        double amount = view.getSalaryAmount();
        try {
            Worker worker = workerModel.changeSalary(SalaryStatus.DOWN, code, amount);
            SalaryHistory history = new SalaryHistory(worker, worker.getSalary(), SalaryStatus.DOWN, new Date());
            if (historyModel.addSalaryHistory(history)) {
                view.setMess("Down salary success for: " + code);
                view.displayMessages();
            }
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.displayErrorMessages();
        }
    }

    public void showHistory() {
        historyModel.sortByID();
        if (historyModel.getList().isEmpty()) {
            System.out.println("List is empty!!!");
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder result = new StringBuilder();
        result.append(String.format("%7s%10s%10s%10s%10s%15s\n", "Code", "Name", "Age", "Salary", "Status", "Date"));
        for (SalaryHistory history : historyModel.getList()) {
            result.append(String.format("%7s%10s%10d%10.0f%10s%15s\n", history.getWorker().getId(), history.getWorker().getName(),
                    history.getWorker().getAge(), history.getSalaryUpdate(), history.getStatus(), dateFormat.format(history.getDate())));
        }
        view.setHeader("===========WORKER LIST==========");
        view.setBody(result.toString());
        view.displayWorkers();
    }
}
