package HrApp;

public class HardSkill {
    //HardSkill:
    //Attributes:
     //- title (String): Stores the title of the hardSkill (C#, OOP, Java, SQL, TeamLead, TechnicalWriting ect)
     //- level (String): Stores the skill level of the hardskill (Beginner, Intermediate, Advanced, Expert)
   //- Methods:
     //- setTitle(String): Sets the title of the hardskill.
     //- setLevel(String): Sets the level of skill
     //- getTitle(): Retrieves the title of the hardSkill.
     //- getLevel(): Retrieves the level of the hardSkill.
     //- displayDetails(): Displays the title and skillLevel of each hardSkill

     private String title;
     private String level;
     public String getTitle(){
        return title;
     }
    public String getLevel(){
        return level;
    }
    public void setTitle(String set)
    {
        title = set;
    }
    public void setLevel(String set)
    {
        level = set;
    }
    public void displayDetails()
    {
        System.out.println("Title: " + title + " Level: " + level);
    }
    
}
