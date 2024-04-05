package HrApp;
import java.util.ArrayList;
public class TempArrays {
    private static ArrayList<Person> allUsers = new ArrayList<Person>(); 
    public static void addUser(Person newUser) //replace object with user
    {
        int index = 0;
       
        for(int i = 0; i < allUsers.size(); i++)    //Determines where to put the user compared to the list, sorts the list
        {
            if(allUsers.get(i).getName().compareTo(newUser.getName()) >= 0)
            {
                break;
            }
            index++;
        }
        allUsers.add(index, newUser);

    }
    //implement removeUser(String email), getUser(String email),  
    public static void removeUser(String email)
    {
        
        if(getUser(email) == null)
        {
            throw new RuntimeException("User not in system");
        }
        allUsers.remove(getUser(email));
        
    }
    public static Person getUser(String email)
    {
        for(int i = 0; i < allUsers.size(); i++)
        {
            if(allUsers.get(i).getEmail().compareToIgnoreCase(email) == 0)
            {
                return allUsers.get(i);
            }
        }
        return null;
    }
    public static ArrayList<Person> getAllUsers()
    {
        return allUsers;
    }
    public static void main(String[] args)
    {
        System.out.println(getAllUsers());
        Person alex = new Person("Alex", 20, "arhea2@murraystate.edu", "adojsnfonwon");
        addUser(alex);
        System.out.println(getAllUsers());
        Person johnDoe = new Person("John", 20, "jdoe@murraystate.edu", "jnijewbff");
        addUser(johnDoe);
        System.out.println(getAllUsers());
        Person asher = new Person("Asher", 20, "ameyers@murraystate.edu", "jnijewbff");
        addUser(asher);
        System.out.println(getAllUsers());
    }
    
}
