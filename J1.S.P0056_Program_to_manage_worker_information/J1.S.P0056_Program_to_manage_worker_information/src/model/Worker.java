package model;

import java.io.Serializable;
import utils.Constants;

/**
 * Stores worker data and validates worker field rules.
 */
public class Worker implements Serializable {

    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    /**
     * Creates a worker with validated information.
     *
     * @param code worker code.
     * @param name worker name.
     * @param age worker age.
     * @param salary worker salary.
     * @param workLocation worker location.
     * @throws Exception if any field is invalid.
     */
    public Worker(String code, String name, int age,
            double salary, String workLocation) throws Exception {
        setCode(code);
        setName(name);
        setAge(age);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    /**
     * Gets worker code.
     *
     * @return worker code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Validates and sets worker code.
     *
     * @param code worker code.
     * @throws Exception if code is invalid.
     */
    public void setCode(String code) throws Exception {
        if (code == null || !code.trim().matches(Constants.WORKER_CODE_REGEX)) {
            throw new Exception("Code must follow format W1, W2, W3...");
        }
        this.code = code.trim().toUpperCase();
    }

    /**
     * Gets worker name.
     *
     * @return worker name.
     */
    public String getName() {
        return name;
    }

    /**
     * Validates and sets worker name.
     *
     * @param name worker name.
     * @throws Exception if name is invalid.
     */
    public void setName(String name) throws Exception {
        if (name == null || !name.trim().matches(Constants.TEXT_REGEX)) {
            throw new Exception("Name only contains letters and spaces.");
        }
        this.name = name.trim();
    }

    /**
     * Gets worker age.
     *
     * @return worker age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Validates and sets worker age.
     *
     * @param age worker age.
     * @throws Exception if age is out of range.
     */
    public void setAge(int age) throws Exception {
        if (age < Constants.MIN_AGE || age > Constants.MAX_AGE) {
            throw new Exception("Age must be in range [18, 50].");
        }
        this.age = age;
    }

    /**
     * Gets worker salary.
     *
     * @return worker salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Validates and sets worker salary.
     *
     * @param salary worker salary.
     * @throws Exception if salary is not positive.
     */
    public void setSalary(double salary) throws Exception {
        if (salary <= Constants.MIN_MONEY) {
            throw new Exception("Salary must be greater than 0.");
        }
        this.salary = salary;
    }

    /**
     * Gets worker location.
     *
     * @return worker location.
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Validates and sets worker location.
     *
     * @param workLocation worker location.
     * @throws Exception if location is invalid.
     */
    public void setWorkLocation(String workLocation) throws Exception {
        if (workLocation == null || !workLocation.trim().matches(Constants.TEXT_REGEX)) {
            throw new Exception("Work location only contains letters and spaces.");
        }
        this.workLocation = workLocation.trim();
    }

    /**
     * Converts worker information to text.
     *
     * @return worker information text.
     */
    @Override
    public String toString() {
        return "Worker{" + code + ", " + name + ", " + age
                + ", " + salary + ", " + workLocation + "}";
    }
}
