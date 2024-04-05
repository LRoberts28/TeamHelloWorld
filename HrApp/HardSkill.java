package HrApp;

//HardSkill:
public class HardSkill {

//Attributes:
     //title (String): Stores the title of the hardSkill (C#, OOP, Java, SQL, TeamLead, TechnicalWriting ect)
     private String title;

     //- level (String): Stores the skill level of the hardskill (Beginner, Intermediate, Advanced, Expert)
     private String level;

//Constructor:
     public HardSkill(String t, String l)
     {
        title = t;
        level = l;

     }

//Methods:
     //getTitle(): Retrieves the title of the hardSkill.
     public String getTitle(){
        return title;
     }

    //setTitle(String): Sets the title of the hardskill.
    public void setTitle(String set)
    {
        title = set;
    }

    //getLevel(): Retrieves the level of the hardSkill.
    public String getLevel(){
        return level;
    }

    //setLevel(String): Sets the level of skill
    public void setLevel(String set)
    {
        level = set;
    }

    //displayDetails(): Displays the title and skillLevel of each 
    public void displayDetails()
    {
        System.out.println("--- Hard Skills ---\r\n" + "Title: " + getTitle() + "\r\n" + "Level: " + getLevel());
    }
    
}
