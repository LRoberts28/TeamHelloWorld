package HrApp;
import java.util.ArrayList;
import javax.swing.*;
public class GUI 
{
    private ArrayList<Person> allUsers;
    public GUI()
    {
        allUsers = TempArrays.getAllUsers();
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
