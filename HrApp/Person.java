package HrApp;

import java.util.ArrayList;

public class Person { // class diagram says User.java but i didn't want to break code.
    private String name;
    private int age;
    private String email;
    private char[] password;
    protected SecurityClearance clearance;
    private ArrayList<String> tags;

    // default constructor for Person
    public Person() {
    }

    // person constructor
    public Person(String name, int age, String email, char[] password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.tags = new ArrayList<>();
        clearance = SecurityClearance.LOW;
    }

    // method to set persons email
    public String setEmail(String email) {
        return email;
    }

    // method to get persons email
    public String getEmail() {
        return email;
    }

    // method to set persons password
    public void setPassword(char[] password) {
        this.password = password;
    }

    // method to get persons password
    public char[] getPassword() {
        return password;
    }

    // method to set persons name
    public void setName(String name) {
        this.name = name;
    }

    // method to get persons name
    public String getName() {
        return name;
    }

    // method to set persons age
    public void setAge(int age) {
        this.age = age;
    }

    // method to get persons age
    public int getAge() {
        return age;
    }

    // method to add tags to array list
    public void addTags(String Tag) {
        tags.add(Tag);
    }

    // method to get tags from arraylist
    public ArrayList<String> getTags() {
        return tags;
    }

    // method for setting the persons clearance level
    public void setClearanceLevel(SecurityClearance clearance) {
        this.clearance = clearance;
    }

    // method for getting the persons clearance level
    public SecurityClearance getClearance() {
        return clearance;
    }

    // overrided method to return custom toString()
    @Override
    public String toString() {
        return name + " " + age + " " + email;
    }

    public void displayDetails() {
        System.out.println("--- Person Details ---\n" + "Name: " + name + "\n" + "Age: " + age);
    }
}

/*
 * To Add below
 * User
 * +email: String------------------------------------ // done
 * +password: String------------------------------------ // done
 * +name: String------------------------------------ // done
 * +securityClearance: enum ------------------------------ // done
 * +description: String //written to embedded file using BufferedWriter
 * +tags: Enum
 * +accountRecovery()
 * +addTags() ------------------------------ // done
 * +getEmail()------------------------------------ // done
 * +getPassword()------------------------------------ // done
 * +getName()------------------------------------ // done
 * +getSecurity() ------------------------------ // done
 * +getTags() ------------------------------ // done
 * +logIn()
 * +save()
 * +setPassword()------------------------------------ // done
 * +setEmail()------------------------------------ // done
 * +setName()------------------------------------ // done
 * +setSecurity() ------------------------------ // done
 * +switchUser()
 * +readDesc()
 * +removeUser()
 * +writeDesc()
 */