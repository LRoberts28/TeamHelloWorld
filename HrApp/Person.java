package HrApp;

public class Person {
    //attributes
    private String name;
    private int age;

    //constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
}
