package HrApp;

public class HrMain {
    public static void main(String[] args) {
        //Creates and Instantiates person, job, and hardSkill
        Person person = new Person("John Doe", 25);
        Job job = new Job("Chief Engineer", 62);
        HardSkill hardSkill = new HardSkill("Coding in Python", "Expert");
        

        //Tests the Person class's getName() and getAge()
        System.out.println("Name: " + person.getName() + "\n");
        System.out.println("Age: " + person.getAge() + "\n");
        
        //Tests the Person class's setName() and setAge()
        person.setName("Alex");
        person.setAge(20);
        System.out.println("Name: " + person.getName() + "\n");
        System.out.println("Age: " + person.getAge() + "\n");

        //Tests the Job class's getTitle() and getExperience()
        System.out.println("Job's getTitle() test: " + job.getTitle() + "\n");
        System.out.println("getExperience() test: " + job.getExperience() + "\n");

        //Tests the Job class's setTitle() and setAge()
        job.setTitle("Student");
        job.setExperience(128);
        System.out.println("Job's getTitle() test: " + job.getTitle() + "\n");
        System.out.println("getExperience() test: " + job.getExperience() + "\n");

        //Tests the HardSkill class's getTitle() and getLevel()
        System.out.println("HardSkill's getTitle() test: " + hardSkill.getTitle() + "\n");
        System.out.println("getLevel() test " + hardSkill.getLevel() + "\n");

        //Tests the HardSkill class's setTitle() and setLevel()
        hardSkill.setTitle("Java Programing");
        hardSkill.setLevel("Intermediate");
        System.out.println("Job's getTitle() test: " + hardSkill.getTitle() + "\n");
        System.out.println("getLevel() test: " + hardSkill.getLevel() + "\n");


        //Tests the Person class's displayDetails()
        System.out.println("Person's displayDetails() test:");
        person.displayDetails();

        //Tests the Job class's displayDetails()
        System.out.println("Job's displayDetails() test:");
        job.displayDetails();

        //Tests the HardSkill class's displayDetails()
        System.out.println("HardSkill's displayDetails() test:");
        hardSkill.displayDetails();






    }
}
