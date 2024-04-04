import java.util.ArrayList;
public class GUI {
    private ArrayList<Person> results;
    public GUI(ArrayList<Person> res)
    {
        results = res;
    }
    public ArrayList<Person> search(String searchBy)
    {
        ArrayList<Person> sorted = new ArrayList<Person>();

        while(results.size() != 0)
        {
            for(int i = 0; i < results.size(); i++)
            {
                if(results.get(i).getName() == searchBy)
                {
                    sorted.add(results.get(i));
                }
                else
                {
                    results.remove(i);
                }
            }

        }
        
        return sorted;
    }
    public void sortByName(ArrayList<Person> n)
    {
        Person p1;
        Person p2;
        for(int i = 1; i < n.size(); i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(n.get(i).getName().compareTo(n.get(j).getName()) > 0) //[4,3,4,2,5,3,1]
                {
                    //swap the values
                    p1 = n.get(i);
                }
                else
                {
                    //its in the right place
                }
            }

        }
        int[] arr = int[5]
        int p = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

    }
    
    
}
class Person
{
    String name;
    public Person(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }
}
