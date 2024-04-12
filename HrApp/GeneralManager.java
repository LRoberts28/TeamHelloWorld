package HrApp;

import java.util.ArrayList;

public class GeneralManager extends AbstractManager {
    private ArrayList<Employee> employees;
    protected SecurityClearance clearance;

    public GeneralManager() {
        super();
        this.clearance = SecurityClearance.MEDIUM;
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
    public void editTags(Employee employee) {
        //employee.getTags;
    }

    @Override
    public void editData(Employee employee) {
        // what data do we want to edit?
    }
}