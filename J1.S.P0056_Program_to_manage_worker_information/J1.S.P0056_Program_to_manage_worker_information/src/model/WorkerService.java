package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Constants;

/**
 * Handles worker business logic and salary history data.
 */
public class WorkerService {

    private Map<String, Worker> workerMap;
    private List<SalaryHistory> salaryHistoryList;

    /**
     * Creates empty worker storage and salary history storage.
     */
    public WorkerService() {
        workerMap = new HashMap<>();
        salaryHistoryList = new ArrayList<>();
    }

    /**
     * Adds a new worker if the worker code is not duplicated.
     *
     * @param worker worker information.
     * @return true if worker is added.
     * @throws Exception if worker is null or code is duplicated.
     */
    public boolean addWorker(Worker worker) throws Exception {
        if (worker == null) {
            throw new Exception("Worker cannot be null.");
        }

        if (workerMap.containsKey(worker.getCode())) {
            throw new Exception("Worker code [" + worker.getCode() + "] is duplicate.");
        }

        workerMap.put(worker.getCode(), worker);
        return true;
    }

    /**
     * Increases or decreases worker salary and saves the adjustment history.
     *
     * @param status adjustment direction.
     * @param code worker code.
     * @param amount adjustment amount.
     * @return true if salary is changed.
     * @throws Exception if code is not found or amount is invalid.
     */
    public boolean changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        Worker worker = getWorkerByCode(code);

        if (worker == null) {
            throw new Exception("Worker code does not exist.");
        }

        if (amount <= Constants.MIN_MONEY) {
            throw new Exception("Amount must be greater than 0.");
        }

        if (status == null) {
            throw new Exception("Salary status cannot be null.");
        }

        double newSalary = calculateNewSalary(worker.getSalary(), amount, status);
        worker.setSalary(newSalary);
        salaryHistoryList.add(new SalaryHistory(worker, newSalary, status));

        return true;
    }

    /**
     * Gets salary adjustment history sorted by worker code.
     *
     * @return sorted salary history list.
     */
    public List<SalaryHistory> getInfomationSalary() {
        List<SalaryHistory> resultList = new ArrayList<>(salaryHistoryList);

        Collections.sort(resultList, new Comparator<SalaryHistory>() {
            @Override
            public int compare(SalaryHistory firstHistory, SalaryHistory secondHistory) {
                return firstHistory.getWorker().getCode()
                        .compareToIgnoreCase(secondHistory.getWorker().getCode());
            }
        });

        return resultList;
    }

    /**
     * Finds worker by normalized code.
     *
     * @param code worker code.
     * @return matched worker or null.
     */
    private Worker getWorkerByCode(String code) {
        if (code == null) {
            return null;
        }
        return workerMap.get(code.trim().toUpperCase());
    }

    /**
     * Calculates salary after an up or down adjustment.
     *
     * @param currentSalary salary before adjustment.
     * @param amount adjustment amount.
     * @param status adjustment direction.
     * @return salary after adjustment.
     * @throws Exception if the decreased salary is not positive.
     */
    private double calculateNewSalary(double currentSalary,
            double amount, SalaryStatus status) throws Exception {
        double newSalary;

        if (status == SalaryStatus.UP) {
            newSalary = currentSalary + amount;
        } else {
            newSalary = currentSalary - amount;
        }

        if (newSalary <= Constants.MIN_MONEY) {
            throw new Exception("Salary after decreasing must be greater than 0.");
        }

        return newSalary;
    }
}
