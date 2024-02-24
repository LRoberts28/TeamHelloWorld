package HrApp;

public class Job {
    //attributes
        //Stores the past or current job title
        String title;
    
        //Stores the number of months in the job
        int experience;
    
    //constructor
        public Job(String title, int xp)
        {
            this.title = title;
            experience = xp;
        }

    
    //methods
        //Sets the job title
        public void setTitle(String jobTitle)
        {
            title = jobTitle;
        }
    
        //Sets the number of months on the job.
        public void setExperience(int exp)
        {
            experience = exp;
        }
    
        //Retrieves the job title
        public String getTitle()
        {
            return title;
        }
    
        //Retrieves the number of months on the job
        public int getExperience()
        {
            return experience;
        }
    
        //Displays the jobs and lengths of time in months on the job
        public void displayDetails()
        {
            System.out.println();
            System.out.println("--- Jobs ---");
            System.out.println("Title: " + title);
            System.out.println("Experience " + experience + " months");
            System.out.println();
        }
    }
