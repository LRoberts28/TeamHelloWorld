package HrApp;

public class Person { // class diagram says User.java but i didn't want to break code.
    private String name;
    private int age;
    private String email;
    private String password;
    protected SecurityClearance clearance;

    // default constructor for Person
    public Person(){
    }

    public Person(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        clearance = SecurityClearance.LOW;
    }

    // method to set persons email
    public String setEmail(String email) {
        return email;
    }

    // method to set persons password
    public void setPassword(String password) {
        this.password = password;
    }

    // method to set persons name
    public void setName(String name) {
        this.name = name;
    }

    // method to set persons age
    public void setAge(int age) {
        this.age = age;
    }

    // method for setting the persons clearance level
    public void setClearanceLevel(SecurityClearance clearance) {
        this.clearance = clearance;
    }

    // method for getting the persons clearance level
    public SecurityClearance getClearance() {
        return clearance;
    }

    // method to get persons email
    public String getEmail() {
        return email;
    }

    // method to get persons password
    public String getPassword() {
        return password;
    }

    // method to get persons name
    public String getName() {
        return name;
    }

    // method to get persons age
    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("--- Person Details ---\n" + "Name: " + name + "\n" + "Age: " + age);
    }
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