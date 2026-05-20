package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Constants;

/**
 * Stores one salary adjustment record of a worker.
 */
public class SalaryHistory {

    private Worker worker;
    private double salary;
    private SalaryStatus status;
    private Date date;

    /**
     * Creates a salary history record at the current date.
     *
     * @param worker the adjusted worker.
     * @param salary the salary after adjustment.
     * @param status the adjustment status.
     */
    public SalaryHistory(Worker worker, double salary, SalaryStatus status) {
        this.worker = worker;
        this.salary = salary;
        this.status = status;
        this.date = new Date();
    }

    /**
     * Gets worker of the salary history record.
     *
     * @return worker information.
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * Gets salary after adjustment.
     *
     * @return adjusted salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets salary adjustment status.
     *
     * @return adjustment status.
     */
    public SalaryStatus getStatus() {
        return status;
    }

    /**
     * Formats the adjusted date for displaying in the view.
     *
     * @return formatted date string.
     */
    public String getDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        return dateFormat.format(date);
    }
}
