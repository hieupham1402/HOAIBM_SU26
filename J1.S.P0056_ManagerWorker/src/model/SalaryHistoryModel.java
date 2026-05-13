/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author win
 */
public class SalaryHistoryModel {

    private List<SalaryHistory> list;

    public SalaryHistoryModel() {
        this.list = new ArrayList<>();
    }

    public List<SalaryHistory> getList() {
        return list;
    }

    public void setList(List<SalaryHistory> list) {
        this.list = list;
    }

    public boolean addSalaryHistory(SalaryHistory history) {
        return list.add(history);
    }

    public void sortByID() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return null;
        }
        sortByID();
        String str = String.format("%7s%10s%10s%10s%10s%15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        return str;
    }
}
