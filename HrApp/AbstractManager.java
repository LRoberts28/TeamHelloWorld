package HrApp;

import java.util.ArrayList;

abstract class AbstractManager {
    protected ArrayList<Employee> employees;

    public AbstractManager() {
        this.employees = new ArrayList<>();
    }

    // abstract method to return data of an employee
    public abstract void returnData(Employee employee);

    // abstract method to edit data of an employee
    public abstract void editData(Employee employee);

}

/*
 * 
 * securityClearance: MEDIUM
 * +employees: ArrayList<Employee>
 * 
 * +returnData(Employee)
 * +editTags(Employee)
 * +editData(Employee)
 */