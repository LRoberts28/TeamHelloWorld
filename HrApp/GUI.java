package HrApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GUI implements KeyListener
{
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel primaryPage;
    private ArrayList<JPanel> history;
    private int currentPage;
    private String searchResults;

    private final String[] pageNames = {"Home", "Login", "Search", "Profile"};

    public GUI()
    {
        initiallize();

        primaryPage = new JPanel(cardLayout);
        primaryPage.add(pageNames[0], homePage());
        primaryPage.add(pageNames[1], loginPage());

        frame.add(primaryPage);

    }


    //creates the main page as a content pane and returns it
    private JPanel homePage()
    {
        JPanel grid = new JPanel(new GridLayout(25,1));
        JPanel background = new JPanel(new FlowLayout(FlowLayout.CENTER));
        grid.setName(pageNames[0]);
        background.setBackground(Color.GRAY);

        TextField search = new TextField("              ");
        search.addKeyListener(this);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> System.out.println(search.getName()));

        //Add keylistener to textfield to log what is typed and when enter is pressed, call search function

        background.add(search, BorderLayout.CENTER);
        background.add(searchButton);

        grid.add(taskBar());
        grid.add(background);

        for(int i = 0; i <  23; i++)
        {
            JPanel filler = new JPanel();
            filler.setBackground(Color.GRAY);
            grid.add(filler);
        }

        return grid;
        
    }

    //creates the login page as a content pane and returns it, currently returns void due to method being incomplete, replace with Container to complete
    private JPanel loginPage()
    {
        //create login page background using the background JPanel

        //add textfield Username and jpasswordfield Password

        //in the two textfields, when enter is pressed, call the login method taking the username and the password as parrameters

        //when the login method returns true, shift to the main page
        JPanel background = new JPanel();
        background.setName(pageNames[1]);

        background.add(taskBar());
        return background;

    }

    //Creates a taskbar with a back and forward button, used for almost every page
    private JPanel taskBar()
    {
        JPanel background = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        background.setBackground(Color.DARK_GRAY);

        JButton back = new JButton("<-");
        back.addActionListener(e -> back());    
        background.add(back);

        JButton forward = new JButton("->");
        forward.addActionListener(e -> forward());      
        background.add(forward);

        return background;

        //NOTE: you can edit the panel after it has been added!!!
    }


    
    public void initiallize() 
    {
        currentPage = 0;
        history = new ArrayList<JPanel>();
        cardLayout = new CardLayout();
        searchResults = "";

        frame = new JFrame("Page");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void back()
    {
        if(currentPage> 0)
        {
            currentPage--;
            cardLayout.show(primaryPage, history.get(currentPage).getName());
        }
    }
    
    private void forward()
    {
        if(currentPage < history.size())
        {
            currentPage++;
            cardLayout.show(primaryPage, history.get(currentPage).getName());
        }

    }
    private void addHistory(JPanel page)
    {
        if(currentPage != history.size())
        {
            history.add(currentPage, page);
            for(int i = history.size() - currentPage; i < history.size(); i++)
            {
                history.set(i, null);
            }
        }
        else
        {
            history.add(page);
        }
        currentPage++;
    }

    public static ArrayList<Person> search(String name)
    {
        ArrayList<Person> results = new ArrayList<Person>();
        for(Person person: TempArrays.getAllUsers())
        {
            if(person.getName().equals(name))
            {
                results.add(person);
            }
        }
        return results;
    }


    @Override
    public void keyPressed(KeyEvent e) 
    {
        searchResults += e.getKeyChar();
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            search(searchResults);
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}



