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

        TextField search = new TextField("         ");
        JButton searchButton = new JButton("Search");
        searchButton.setFocusPainted(false);
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
        JPanel taskBar = new JPanel(new GridLayout(1,2));
        JPanel addUser = new JPanel(new FlowLayout(FlowLayout.LEFT));
        if(me.getClearance() == SecurityClearance.MEDIUM || me.getClearance() == SecurityClearance.HIGH)
        {
            JButton addUserButton = new JButton("New User");
            addUserButton.addActionListener(e-> openRegistrationForm());
            addUserButton.setFocusPainted(false);
            addUser.add(addUserButton);


        }
        addUser.setBackground(Color.DARK_GRAY);
        taskBar.add(addUser);
        taskBar.add(taskBar());

        grid.add(taskBar);

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
        JPanel background = new JPanel(new GridLayout(14, 1));
        JPanel editPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        editPanel.setBackground(Color.DARK_GRAY);
        if(me.getClearance() == SecurityClearance.MEDIUM || me.getClearance() == SecurityClearance.HIGH)
        {
            JButton edit = new JButton("Edit");
            edit.setFocusPainted(false);
            edit.addActionListener(e->openEditForm(person));
            editPanel.add(edit);
        }
        JPanel taskBar = new JPanel(new GridLayout(1,2));
        taskBar.add(editPanel);
        taskBar.add(taskBar());
        background.add(taskBar);
        if(person != null)
        {
            background.add(new JLabel("     Demographics:"));
            background.add(new JLabel("     - Email: " + person.getEmail()));
            background.add(new JLabel("     - Name: " + person.getName()));
            background.add(new JLabel("     - Age: " + person.getAge()));
            background.setBackground(Color.GRAY);
            System.out.println("Showing info on " + person.getName());
            if(me.getClearance() == SecurityClearance.MEDIUM || me.getClearance() == SecurityClearance.HIGH || person == me)
            {
                JButton delete = new JButton("Delete");
                delete.setFocusPainted(false);
                delete.addActionListener(e -> deleteUser(person));
                JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                deletePanel.setBackground(Color.gray);
                deletePanel.add(delete);
                Employee employee = (Employee)person;
                background.add(new JLabel("     - Address: " + employee.getAddress()));
                background.add(new JLabel("     - Phone: " + employee.getPhone()));
                background.add(new JLabel("     - Current Job: " + employee.getCurrJob()));
                background.add(new JLabel("     - Number of Tasks Performed: " + employee.getTasksPerformed()));
                background.add(new JLabel("     - Soft Skills: " + employee.getSoftSkills()));
                background.add(new JLabel("     - Talents: " + employee.getTalents()));
                background.add(new JLabel("     - Clearance: " + employee.getClearance()));
                background.add(new JLabel("     - Evaluations" + employee.getEvaluations()));
                background.add(deletePanel);
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
        profile.setFocusPainted(false);
        profile.addActionListener(F -> {
            this.profile = profile(me);
            primaryPage.add(pageNames[1], this.profile);
            cardLayout.show(primaryPage, "Profile");
        });
        background.add(profile);

        JButton back = new JButton("<-");
        back.setFocusPainted(false);
        back.addActionListener(e -> back());    
        background.add(back);

        JButton forward = new JButton("->");
        forward.setFocusPainted(false);
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

        frame = new JFrame("HR App");
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

     // creates function that adds a register button and allows a user to register
    private void openRegistrationForm() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setSize(300, 250);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setLayout(new GridLayout(5, 1));
        registerFrame.setResizable(false);

        // Create labels and text fields for name, age, email, and password
        JLabel label_name = new JLabel("   Name:");
        JTextField textField_name = new JTextField(20);
        JPanel namePanel = new JPanel(new FlowLayout());
        JLabel label_age = new JLabel("    Age:");
        JTextField textField_age = new JTextField(20);
        JPanel agePanel = new JPanel(new FlowLayout());
        JLabel label_email = new JLabel("   Email:");
        JTextField textField_email = new JTextField(20);
        JPanel emailPanel = new JPanel(new FlowLayout());
        JLabel label_password = new JLabel("Password:");
        JPasswordField passwordField_password = new JPasswordField(20);
        JPanel passwordPanel = new JPanel(new FlowLayout());

        // Create register button
        JButton button_register = new JButton("Register");
        button_register.setFocusPainted(false);
        JPanel buttonFrame = new JPanel(new FlowLayout(FlowLayout.CENTER));
        button_register.addActionListener(e-> 
        {
            String name = textField_name.getText();
            int age = Integer.parseInt(textField_age.getText());
            String email = textField_email.getText();
            char[] password = passwordField_password.getPassword();
            if (registerUser(name, (short)age, email, password))
            {
                registerFrame.dispose();
            }
        });
        buttonFrame.add(button_register);

        // Add components to panels
        namePanel.add(label_name);
        namePanel.add(textField_name);
        agePanel.add(label_age);
        agePanel.add(textField_age);
        emailPanel.add(label_email);
        emailPanel.add(textField_email);
        passwordPanel.add(label_password);
        passwordPanel.add(passwordField_password);


        // Add components to registration form
        registerFrame.add(namePanel);
        registerFrame.add(agePanel);
        registerFrame.add(emailPanel);
        registerFrame.add(passwordPanel);
        registerFrame.add(buttonFrame);

        registerFrame.setVisible(true);
    }

    // Method to register a new user
    private boolean registerUser(String name, short age, String email, char[] password) {
        // Create a new Person object with the provided email and password
        if(TempArrays.getUser(email) != null)
        {
            JOptionPane.showMessageDialog(null , "Email already in use");
            return false;
        }
        else
        {
            Person newUser = new Person(name, age, email, password);

            Employee newEmployee = new Employee(newUser, "Temporary Address", "Temporary Phone", "Temporary Job Title", 0);

            // Add the new user to TempArrays
            TempArrays.addUser(newEmployee);

            // Display a success message
            JOptionPane.showMessageDialog(null, "Registration successful");
            return true;
        }
    }


     private void openEditForm(Person me) {
        JFrame editFrame = new JFrame("Edit " + me.getName());
        editFrame.setSize(300, 250);
        editFrame.setLocationRelativeTo(null);
        editFrame.setLayout(new GridLayout(5, 1));
        editFrame.setResizable(false);

        // Create labels and text fields for name, age, email, and password
        JLabel label_name = new JLabel("   Name:");
        JTextField textField_name = new JTextField(20);
        textField_name.setText(me.getName());
        JPanel namePanel = new JPanel(new FlowLayout());

        JLabel label_age = new JLabel("    Age:");
        JTextField textField_age = new JTextField(20);
        textField_age.setText("" + me.getAge());
        JPanel agePanel = new JPanel(new FlowLayout());

        JLabel label_email = new JLabel("   Email:");
        JTextField textField_email = new JTextField(20);
        textField_email.setText(me.getEmail());
        textField_email.setEditable(false);
        JPanel emailPanel = new JPanel(new FlowLayout());

        JLabel label_password = new JLabel("Password:");
        JPasswordField passwordField_password = new JPasswordField(20);
        passwordField_password.setText(Helper.charArrayToString(me.getPassword()));
        JPanel passwordPanel = new JPanel(new FlowLayout());

        // Create save button
        JButton button_save = new JButton("Save");
        button_save.setFocusPainted(false);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        button_save.addActionListener(e-> 
        {
            String name = textField_name.getText();
            int age = Integer.parseInt(textField_age.getText());
            String email = textField_email.getText();
            char[] password = passwordField_password.getPassword();
            editUser(name, (short)age, email, password);
            editFrame.dispose();
        });
        buttonPanel.add(button_save);

        // Add components to panels
        namePanel.add(label_name);
        namePanel.add(textField_name);
        agePanel.add(label_age);
        agePanel.add(textField_age);
        emailPanel.add(label_email);
        emailPanel.add(textField_email);
        passwordPanel.add(label_password);
        passwordPanel.add(passwordField_password);

        // Add components to edit page
        editFrame.add(namePanel);
        editFrame.add(agePanel);
        editFrame.add(emailPanel);
        editFrame.add(passwordPanel);
        editFrame.add(buttonPanel);
        

        editFrame.setVisible(true);
    }

    // Method to register a new user
    private void editUser(String name, short age, String email, char[] password) {
        // Create a new Person object with the provided email and password

        Person me = TempArrays.getUser(email);
        me.setName(name);
        me.setAge(age);
        me.setPassword(password);

        // Display a success message
        JOptionPane.showMessageDialog(null, "Changes Saved");
    }

    private void deleteUser(Person person)
    {
        if(person == me)
        {
            JOptionPane.showMessageDialog(null, "Cannot delete user: Currently signed in as " + me.getName());
        }
        else
        {
            int yesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + person.getName() + "?");
            if(yesOrNo == 0)
            {
                TempArrays.removeUser(person.getEmail());
                JOptionPane.showMessageDialog(null, person + " deleted");
            }
        }
    }

}
