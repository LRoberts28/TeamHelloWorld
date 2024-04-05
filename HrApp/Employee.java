package HrApp;

import java.io.File;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee extends Person {
    private String address;
    private String phone;
    private String currJob;
    private int tasksPerformed;

    // default constructor for Employee
    public Employee(){
    }

    // employee constructor
    public Employee(String name, int age, String email, String password, String address,
            String phone, String currJob, int tasksPerformed) {
        this.address = address;
        this.phone = phone;
        this.currJob = currJob;
        this.tasksPerformed = tasksPerformed;
        clearance = SecurityClearance.LOW;
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
    public void setSecurityClearance(SecurityClearance clearance){
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
        return note; // returns the note with info
    }

    public static String saveFile(){
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
                // Open the file using the default system application associated with its file type
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

    //example usage for note writer

    public static void main(String[] args) {
        // Get note from user input
        String note = getNoteFromUser();
        String filePath = saveFile();

        //String filePath = "note.txt";

        writeNoteToFile(note, filePath);
    }

}

/*
 * Employee inherits from Person
 * securityClearance: Low //----------------------------------------------------------- done
 * +address: String //----------------------------------------------------------- done
 * +phone: String //-----------------------------------------------------------done
 * +age: short //-----------------------------------------------------------
 * person class already has this
 * +currentJob: Job //----------------------------------------------------------- done
 * +resume: .pdf file //uploaded pdf file, cannot be changed in program 
 * +notes: String //written to embedded file using BufferedWriter //----------------------------------------------------------- done
 * +jobHistory: ArrayList<Job>
 * +tasksPreformed: int //----------------------------------------------------------- done
 * +softSkills:ArrayList<Skill>
 * +talents:ArrayList<String>
 * +gifts:ArrayList<String>
 * +evals: ArrayList<Evaluations>
 * 
 * +addJobHistory()
 * +addSoftSkill()
 * +addTalent()
 * +addGift()
 * +addEval()
 * +getChangeLog()
 * +getAddress() //-----------------------------------------------------------done
 * +getPhone() //-----------------------------------------------------------done
 * +getAge() //----------------------------------------------------------- done
 * +getJob() //----------------------------------------------------------- done
 * +getJobHistory()
 * +getTasksPreformed() //----------------------------------------------------------- done
 * +getSoftSkills()
 * +getTalents()
 * +getGifts()
 * +getEvals()
 * +setAge() //----------------------------------------------------------- done
 * +setAddress() //-----------------------------------------------------------done
 * +setPhone() //-----------------------------------------------------------done
 * +setAge() //----------------------------------------------------------- done
 * +setCurrentJob() //-----------------------------------------------------------done
 * +setTasksPreformed()//----------------------------------------------------------- done
 * +readNotes()
 * +removeJobHistory()
 * +removeSoftSkills()
 * +removeTalents()
 * +removeGifts()
 * +removeEvals()
 * +writeNotes()
 */