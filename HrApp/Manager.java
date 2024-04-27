package HrApp;

import java.util.ArrayList;

public class Manager extends Employee implements AbstractManager {
    private ArrayList<Employee> employees;
    protected SecurityClearance clearance;

    public Manager() {
        super();
        this.clearance = SecurityClearance.MEDIUM;
        this.employees = new ArrayList<>();
    }

    public Manager(Employee me){
        super((Person)me, me.getAddress(), me.getPhone(), me.getCurrJob(), me.getTasksPerformed());
        this.clearance = SecurityClearance.MEDIUM;
        this.setClearanceLevel(clearance);
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void returnData(Employee employee) {
        System.out.println("Return Data " + employee.toString());

    }

    @Override
    public void editData(Employee employee) {
        // not sure what to put here yet
    }
}