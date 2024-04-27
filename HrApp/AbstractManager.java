package HrApp;

interface AbstractManager {

    // method to return data of an employee
    public void returnData(Employee employee);

    // method to edit data of an employee
    public void editData(Employee employee);

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