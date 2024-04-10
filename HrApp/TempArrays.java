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
    public ArrayList<Person> findBy(SecurityClearance security)
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
    public ArrayList<Person> findBy(String email)
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
