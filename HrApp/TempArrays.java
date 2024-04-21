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
    public static ArrayList<Person> searchBy(SecurityClearance security) //returns everyone who has that level of security clearance
    {
        ArrayList<Person> results = new ArrayList<Person>();
        for(int i = 0; i < allUsers.size(); i++)
        {
            if(allUsers.get(i).getClearance().equals(security))
            {
                results.add(allUsers.get(i));
            }
        }
        return results;

    }
    public static ArrayList<Person> searchBy(String email) //returns everyone who has this email, which should always be one person, but this list will be used for search results
    {
        ArrayList<Person> results = new ArrayList<Person>();
        for(int i = 0; i < allUsers.size(); i++)
        {
            if(allUsers.get(i).getEmail().compareToIgnoreCase(email) == 0)
            {
                results.add(allUsers.get(i));
            }
        }
        return results;
    }
    
}
