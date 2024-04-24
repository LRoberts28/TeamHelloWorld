package HrApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GUI 
{
    private JFrame frame;
    private JPanel background;
    private Container mainMenu;
    private ArrayList<JFrame> pages = new ArrayList<JFrame>();
    private int currentIndex = 0;

    public GUI()
    {
        frame = mainPage();
        initiallize();
    }


    //creates the main page as a content pane and returns it
    private JFrame mainPage()
    {
        frame = new JFrame("main");
        taskBar();

        background = new JPanel(new FlowLayout(FlowLayout.CENTER));
        background.setBackground(Color.DARK_GRAY);
        frame.add(background, BorderLayout.CENTER);

        TextField search = new TextField("Start your search here!");

        //Add keylistener to textfield to log what is typed and when enter is pressed, call search function

        background.add(search, BorderLayout.CENTER);

        return frame;
    }

    //searches for any person who has that name
    private void search(String name)
    {
        //loops through all of the people in the TempArrays ArrayList and returns a new ArrayList

        //this ArrayList has, in alphabetical order, every person who has that name

        //NOTICE: this should NOT change or be used to change the ArrayList in the TempArrays class

    }

    //creates the login page as a content pane and returns it, currently returns void due to method being incomplete, replace with Container to complete
    private void loginPage()
    {
        //create login page background using the background JPanel

        //add textfield Username and jpasswordfield Password

        //in the two textfields, when enter is pressed, call the login method taking the username and the password as parrameters

        //when the login method returns true, shift to the main page

    }

    //Creates a taskbar with a back and forward button, used for almost every page
    private void taskBar()
    {
        background = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        background.setBackground(Color.GRAY);

        JButton back = new JButton("<-");
        back.addActionListener(e -> setPage(pages.get(currentIndex - 1)));    //replace with code to go back a page
        background.add(back);

        JButton forward = new JButton("->");
        forward.addActionListener(e -> setPage(pages.get(currentIndex + 1)));      //replace with code to go forward a page
        background.add(forward);

        frame.add(background, BorderLayout.NORTH);

        //NOTE: you can edit the panel after it has been added!!!
    }


    
    public void initiallize() //sets up the jframe 
    {
        
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addToPages(JFrame newPage)
    {
        pages.add(newPage);
        currentIndex++;
    }

    private void setPage(JFrame newPage)
    {
        frame = newPage;
        addToPages(newPage);
    }
}



