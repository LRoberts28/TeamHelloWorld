package HrApp;

public class Employee extends Person {
    private String address;
    private String phone;
    private String currJob;
    private int tasksPerformed;

    // employee constructor
    public Employee(String name, int age, String email, String password, SecurityClearance clearance, String address,
            String phone, String currJob, int tasksPerformed) {
        super(name, age, email, password, clearance);
        this.address = address;
        this.phone = phone;
        this.currJob = currJob;
        this.tasksPerformed = tasksPerformed;
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
}

/*
 * Employee
 * User
 * securityClearance: Low
 * +address: String
 * //----------------------------------------------------------- done
 * +phone: String
 * //-----------------------------------------------------------done
 * +age: short //-----------------------------------------------------------
 * person class already has this
 * +currentJob: Job
 * //----------------------------------------------------------- done
 * +resume: .pdf file //uploaded pdf file, cannot be changed in program
 * +notes: String //written to embedded file using BufferedWriter
 * +jobHistory: ArrayList<Job>
 * +tasksPreformed: int
 * //----------------------------------------------------------- done
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
 * +getAddress()
 * //-----------------------------------------------------------done
 * +getPhone() //-----------------------------------------------------------done
 * +getAge() //----------------------------------------------------------- done
 * +getJob() //----------------------------------------------------------- done
 * +getJobHistory()
 * +getTasksPreformed()//-------------------------------------------------------
 * ---- done
 * +getSoftSkills()
 * +getTalents()
 * +getGifts()
 * +getEvals()
 * +setAge() //----------------------------------------------------------- done
 * +setAddress()
 * //-----------------------------------------------------------done
 * +setPhone() //-----------------------------------------------------------done
 * +setAge() //----------------------------------------------------------- done
 * +setCurrentJob()//-----------------------------------------------------------
 * done
 * +setTasksPreformed()//-------------------------------------------------------
 * ---- done
 * +readNotes()
 * +removeJobHistory()
 * +removeSoftSkills()
 * +removeTalents()
 * +removeGifts()
 * +removeEvals()
 * +writeNotes()
 */