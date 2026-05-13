/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class WorkerModel {

    private List<Worker> list;

    public WorkerModel() {
        this.list = new ArrayList<>();
    }

    public List<Worker> getList() {
        return list;
    }

    public void setList(List<Worker> list) {
        this.list = list;
    }

    private Worker getWorker(String id) {
        for (Worker workers : list) {
            if (workers.getId().equalsIgnoreCase(id)) {
                return workers;
            }
        }
        return null;
    }

    private boolean isExist(String id) {
        for (Worker workers : list) {
            if (workers.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Worker worker) throws Exception {
        if (isExist(worker.getId())) {
            throw new Exception("Worker with ID " + worker.getId() + " already exists.");
        }
        return list.add(worker);
    }

    public Worker changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty!Can not change salary");
        }
        if (!isExist(code)) {
            throw new Exception("Can not found code!");
        }
        if (amount <= 0) {
            throw new Exception("Amount of money must be > 0 ");
        }
        Worker worker = getWorker(code);
        switch (status) {
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                break;
            case DOWN:
                if (worker.getSalary() - amount < 0) {
                    throw new Exception("Can not down " + amount);
                }
                worker.setSalary(worker.getSalary() - amount);
                break;
        }
        return worker;
    }

  }
