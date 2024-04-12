package HrApp;

import java.util.ArrayList;

public class Job 
{
    String companyName;
    String companyTime;
    String timeWorked;
    ArrayList<Skill> skillsLearned;

    public Job(String companyName, String companyTime, String timeWorked)
    {
        this.companyName = companyName;
        this.companyTime = companyTime;
        this.timeWorked = timeWorked;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getCompanyTime()
    {
        return companyTime;
    }

    public String getTimeWorked()
    {
        return timeWorked;
    }
}

