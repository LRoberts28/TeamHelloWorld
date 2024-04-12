package HrApp;

public class Skill {
    String skillName;


    public Skill(String skillName)
    {
        this.skillName = skillName;
    }

    public Skill(String skillName, Proficiency proficiencyLevel)
    {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
    }

    enum Proficiency 
    {
        BIGINNER,
        MEDIUM,
        HIGH
    }

    public Proficiency proficiencyLevel;

    public Proficiency getProficiency()
    {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(Proficiency input)
    {
        proficiencyLevel = input;
    }
}
