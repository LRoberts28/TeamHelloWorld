package HrApp;

import java.io.File;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Employee extends Person {
    private String address;
    private String phone;
    private String currJob;
    private int tasksPerformed;
    private ArrayList<String> jobHistory;
    private ArrayList<String> softSkills;
    private ArrayList<String> talents;
    private ArrayList<String> gifts;
    private ArrayList<String> evals;

    // default constructor for Employee
    public Employee() {
    }

    // employee constructor
    public Employee(String name, short age, String email, String password, String address,
            String phone, String currJob, int tasksPerformed) {
        this.address = address;
        this.phone = phone;
        this.currJob = currJob;
        this.tasksPerformed = tasksPerformed;
        clearance = SecurityClearance.LOW;
        this.jobHistory = new ArrayList<>();
        this.softSkills = new ArrayList<>();
        this.talents = new ArrayList<>();
        this.gifts = new ArrayList<>();
        this.evals = new ArrayList<>();
    }

    // method to set employees address
    public void setAddress(String address) {
        this.address = address;
    }

    // method to set employees phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // method to set employees current job
    public void setCurrJob(String currJob) {
        this.currJob = currJob;
    }

    // method to set employees tasks performed
    public void setTasksPerformed(int tasksPerformed) {
        this.tasksPerformed = tasksPerformed;
    }

    // method to set the SecurityClearance level of an employee
    public void setSecurityClearance(SecurityClearance clearance) {
        this.clearance = clearance;
    }

    public SecurityClearance getClearance() {
        return clearance;
    }

    // method to get employees address
    public String getAddress() {
        return address;
    }

    // method to get employees phone
    public String getPhone() {
        return phone;
    }

    // method to get employees current job
    public String getCurrJob() {
        return currJob;
    }

    // method to get employees tasks preformed
    public int getTasksPerformed() {
        return tasksPerformed;
    }

    // Method to write a note to a file
    // not sure what idea we have for file so will leave it be for now
    public static void writeNoteToFile(String note, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(note); // Write the note to the file
            // outputs if the note was written to file correctly
            System.out.println("Note has been successfully written to file: " + filePath);
        } catch (IOException e) { // catches exception
            System.err.println("Error writing note to file: " + e.getMessage());
            e.printStackTrace(); // prints the stack trace of an exception to the standard error stream
        }
    }

    // Method to get note input from user
    public static String getNoteFromUser() {
        Scanner scanner = new Scanner(System.in); // opens the scanner
        System.out.println("Enter your note:");
        String note = scanner.nextLine(); // reads info
        // scanner.close();
        return note; // returns the note with info
    }

    public static String saveFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Save as:");
        String noteName = scanner.nextLine();
        scanner.close();
        String filePath = noteName + ".txt";
        return filePath;
    }

    public static void readNote(String filePath) {
        try {
            File file = new File(filePath);

            // Check if the file exists
            if (file.exists()) {
                // Open the file using the default system application associated with its file
                // type
                Desktop.getDesktop().open(file);
                System.out.println("File opened successfully.");
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // example usage for note writer
    /*
     * public static void main(String[] args) {
     * // Get note from user input
     * Employee employee = new Employee();
     * employee.addSoftSkill("Communication");
     * employee.addSoftSkill("Teamwork");
     * employee.removeFromSoftSkills(employee.getSoftSkills(), "Communication");
     * System.out.println("Soft Skills after removal:");
     * for (String softSkill : employee.getSoftSkills()) {
     * System.out.println(softSkill);
     * }
     * String note = getNoteFromUser();
     * String filePath = saveFile();
     * 
     * // String filePath = "note.txt";
     * 
     * writeNoteToFile(note, filePath);
     * readNote(filePath);
     * }
     */

    public static boolean searchHardSkill(ArrayList<String> hardSkills, String searchedSkill) {
        // Iterate through the ArrayList to check if the skill searched exists
        for (String skill : hardSkills) {
            if (skill.equalsIgnoreCase(searchedSkill)) {
                return true; // if skill is found returns true
            }
        }
        // if skill not found return false
        return false;

    }

    // method that removes a string from job History
    public void removeFromJobHistory(ArrayList<String> jobHistory, String itemToRemove) {
        jobHistory.removeIf(item -> item.equals(itemToRemove));
    }

    // method that removes a string from soft Skills
    public void removeFromSoftSkills(ArrayList<String> softSkills, String itemToRemove) {
        softSkills.removeIf(item -> item.equals(itemToRemove));
    }

    // method that removes a string from talents
    public void removeFromTalents(ArrayList<String> talents, String itemToRemove) {
        talents.removeIf(item -> item.equals(itemToRemove));
    }

    // method that removes a string from gifts
    public void removeFromGifts(ArrayList<String> gifts, String itemToRemove) {
        gifts.removeIf(item -> item.equals(itemToRemove));
    }

    // method that removes a string from evals
    public void removeFromEvals(ArrayList<String> evals, String itemToRemove) {
        evals.removeIf(item -> item.equals(itemToRemove));
    }

    // method to add job history
    public void addJobHistory(String job) {
        jobHistory.add(job);
    }

    // method to add soft skills
    public void addSoftSkill(String softSkill) {
        softSkills.add(softSkill);
    }

    // method to add talents
    public void addTalent(String talent) {
        talents.add(talent);
    }

    // method to add gifts
    public void addGift(String gift) {
        gifts.add(gift);
    }

    // method to add evaluations
    public void addEval(String evaluation) {
        evals.add(evaluation);
    }

    // getter methods for job history
    public ArrayList<String> getJobHistory() {
        return jobHistory;
    }

    // getter method for soft skills
    public ArrayList<String> getSoftSkills() {
        return softSkills;
    }

    // getter method for talents
    public ArrayList<String> getTalents() {
        return talents;
    }

    // getter method for gifts
    public ArrayList<String> getGifts() {
        return gifts;
    }

    // getter method for evals
    public ArrayList<String> getEvaluations() {
        return evals;
    }
}

/*
 * Employee inherits from Person
 * securityClearance: Low //----------------------------- done
 * +address: String //----------------------------- done
 * +phone: String //----------------------------- done
 * +age: short //----------------------------- done
 * person class already has this ^^
 * +currentJob: Job //----------------------------- done
 * +resume: .pdf file //uploaded pdf file, cannot be changed in program
 * +notes: String //----------------------------- done
 * +jobHistory: ArrayList<Job> //----------------------------- done
 * +tasksPreformed: int //----------------------------- done
 * +softSkills:ArrayList<Skill> //----------------------------- done
 * +talents:ArrayList<String> //----------------------------- done
 * +gifts:ArrayList<String> //----------------------------- done
 * +evals: ArrayList<Evaluations> //----------------------------- done
 * 
 * +addJobHistory() //----------------------------- done
 * +addSoftSkill() //----------------------------- done
 * +addTalent() //----------------------------- done
 * +addGift() //----------------------------- done
 * +addEval() //----------------------------- done
 * +getChangeLog() // not possible without writing all the information
 * to a seperate file and comparing each string
 * +getAddress()//----------------------------- done
 * +getPhone() //----------------------------- done
 * +getAge() //----------------------------- done
 * +getJob() //----------------------------- done
 * +getJobHistory() //----------------------------- done
 * +getTasksPreformed()//------------------- done
 * +getSoftSkills() //----------------------------- done
 * +getTalents() //----------------------------- done
 * +getGifts() //----------------------------- done
 * +getEvals() //----------------------------- done
 * +setAge() //----------------------------- done
 * +setAddress()//----------------------------- done
 * +setPhone() //----------------------------- done
 * +setAge() //----------------------------- done
 * +setCurrentJob()//----------------------------- done
 * +setTasksPreformed()//----------------------------- done
 * +readNotes() //----------------------------- done
 * +removeJobHistory() //----------------------------- done
 * +removeSoftSkills() //----------------------------- done
 * +removeTalents() //----------------------------- done
 * +removeGifts() //----------------------------- done
 * +removeEvals() //----------------------------- done
 * +writeNotes() //----------------------------- done
 */