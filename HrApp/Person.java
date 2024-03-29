package HrApp;

public class Person { // class diagram says User.java but i didn't want to break code.
    private String name;
    private int age;
    private String email;
    private String password;

    // private SecurityClearance clearance;
    // States = currentState=SecurityClearance.LOW

    enum ClearanceLevel {
        USER,
        EMPLOYEE,
        MANAGER;
    }

    ClearanceLevel secLevel = ClearanceLevel.EMPLOYEE;
    // System.out.println(c1);

    public enum SecurityClearance {
        LOW,
        MEDIUM,
        HIGH;
    }

    // constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // methods
    public String setEmail(String email) {
        return email;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("--- Person Details ---\r\n" + "Name: " + name + "\r\n" + "Age: " + age);
    }

    // public int getSecurity() {
    // int secLevel;
    // }
}

/*
 * User
 * +email: String------------------------------------ // done
 * +password: String------------------------------------ // done
 * +name: String------------------------------------ // done
 * +securityClearance: enum // working on
 * +description: String //written to embedded file using BufferedWriter
 * +tags: Enum
 * +accountRecovery()
 * +addTags()
 * +getEmail()------------------------------------ // done
 * +getPassword()------------------------------------ // done
 * +getName()------------------------------------ // done
 * +getSecurity() ---------- in progress-------------
 * +getTags()
 * +logIn()
 * +save()
 * +setPassword()------------------------------------ // done
 * +setEmail()------------------------------------ // done
 * +setName()------------------------------------ // done
 * +setSecurity()
 * +switchUser()
 * +readDesc()
 * +removeUser()
 * +writeDesc()
 */