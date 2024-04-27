package HrApp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI
{
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel primaryPage;
    private ArrayList<JPanel> history;
    private int currentPage;
    private ArrayList<Person> results;
    private JPanel profile, home;
    private Person me;
    private boolean hasInitialized;

    private final String[] pageNames = {"Home", "Profile"};

    public GUI(Person me)
    {
        initiallize();
        this.me = me;

        home = homePage(me);
        profile = profile(null);

        primaryPage = new JPanel(cardLayout);
        primaryPage.add(pageNames[0], home);
        primaryPage.add(pageNames[1], profile);

        frame.add(primaryPage);

    }


    //creates the main page as a JPanel and returns it
    private JPanel homePage(Person me)
    {
        hasInitialized = false;
        JPanel grid = new JPanel(new GridLayout(0, 1));
        grid.setName(pageNames[0]);
        JPanel background = new JPanel(new FlowLayout(FlowLayout.CENTER));
        background.setBackground(Color.GRAY);

        TextField search = new TextField("              ");
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            for(int i = 23; i > 1; i--)
            {
                if(hasInitialized)
                {
                    grid.remove(i);
                }
            }
            ArrayList<Person> resultList = search(search.getText());
            System.out.println(search.getText());
            System.out.println(resultList);
            
            for(int i = 0; i < 22; i++)
            {
                JPanel resultJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                if(i < resultList.size())
                {
                    resultJPanel.setBackground(Color.LIGHT_GRAY);
                    Person thisPerson = resultList.get(i);
                    JButton link = new JButton(thisPerson.getName());
                    link.setBackground(Color.lightGray);
                    link.addActionListener(E -> {
                        this.profile = profile(thisPerson);
                        primaryPage.add(pageNames[1], this.profile);
                        cardLayout.show(primaryPage, pageNames[1]);
                    });
                    resultJPanel.add(link);
                    
                }
                else
                {
                    resultJPanel.setBackground(Color.GRAY);
                }
                grid.add(resultJPanel);
            }
            this.home = grid;

        });
        grid.add(taskBar());

        background.add(search, BorderLayout.CENTER);
        background.add(searchButton);

        grid.add(background);
        addHistory(grid);

        searchButton.doClick();
        hasInitialized = true;
        return grid;
        
    }

    private JPanel profile(Person person)
    {
        JPanel background = new JPanel(new GridLayout(12, 1));
        background.add(taskBar());
        if(person != null)
        {
            background.add(new JLabel("Demographics:"));
            background.add(new JLabel("     - Email: " + person.getEmail()));
            background.add(new JLabel("     - Name: " + person.getName()));
            background.add(new JLabel("     - Age: " + person.getAge()));
            background.setBackground(Color.GRAY);
            System.out.println("Showing info on " + person.getName());
            if(me.getClearance() == SecurityClearance.MEDIUM || me.getClearance() == SecurityClearance.HIGH || person == me)
            {
                Employee employee = (Employee)person;
                background.add(new JLabel("     - Address: " + employee.getAddress()));
                background.add(new JLabel("     - Phone: " + employee.getPhone()));
                background.add(new JLabel("     - Current Job: " + employee.getCurrJob()));
                background.add(new JLabel("     - Number of Tasks Performed: " + employee.getTasksPerformed()));
                background.add(new JLabel("     - Soft Skills: " + employee.getSoftSkills()));
                background.add(new JLabel("     - Talents: " + employee.getTalents()));
                background.add(new JLabel("     - Clearance: " + employee.getClearance()));
            }
            else
            {
                for(int i = 0; i < 6; i++)
                {
                    JPanel filler = new JPanel();
                    filler.setBackground(Color.GRAY);
                    background.add(filler);
                }

            }
        }
        background.setName(pageNames[1]);

        addHistory(background);
        return background;
    }

    //Creates a taskbar with a back and forward button, used for almost every page
    private JPanel taskBar()
    {
        
        JPanel background = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        background.setBackground(Color.DARK_GRAY);

        JButton profile = new JButton(me.getName());
        profile.addActionListener(F -> {
            this.profile = profile(me);
            primaryPage.add(pageNames[1], this.profile);
            cardLayout.show(primaryPage, "Profile");
        });
        background.add(profile);

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

        frame = new JFrame("Page");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("HrApp\\Hello World HR App Logo Idea.png"));
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

    public ArrayList<Person> search(String name)
    {
        results = new ArrayList<Person>();
        for(Person person: TempArrays.getAllUsers())
        {
            if(person.getName().contains(name))
            {
                results.add(person);
            }
        }
        return results;
    }

}



