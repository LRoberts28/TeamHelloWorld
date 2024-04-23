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
    private ArrayList<Container> pages = new ArrayList<Container>();

    public GUI()
    {
        frame = new JFrame("Main Page");
        mainPage();
    }


    //creates the main page as a content pane and returns it
    private Container mainPage()
    {
        taskBar();

        background = new JPanel(new FlowLayout(FlowLayout.CENTER));
        background.setBackground(Color.DARK_GRAY);
        frame.add(background, BorderLayout.CENTER);

        TextField search = new TextField("Start your search here!");

        //Add keylistener to textfield to log what is typed and when enter is pressed, call search function

        background.add(search, BorderLayout.CENTER);

        return frame.getContentPane();
    }

    //searches for the name in the 
    private void search(String name)
    {

    }

    //creates the login page as a content pane and returns it, currently returns void due to method being incomplete, replace with Container to complete
    private void loginPage()
    {
        //form login page background using the background JPanel

        //add textfield for Username and jpasswordfield for Password

        //in the two textfields, when enter is pressed, call the login method

    }

    private void taskBar()
    {
        background = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        background.setBackground(Color.GRAY);

        JButton back = new JButton("<-");
        back.addActionListener(e -> System.out.println("Back"));    //replace with code to go back a page
        background.add(back);

        JButton forward = new JButton("->");
        forward.addActionListener(e -> System.out.println("Forward"));      //replace with code to go forward a page
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
    public JFrame getJFrame()
    {
        return frame;
    }

    public void addToPages(Container newPage)
    {
        pages.add(newPage);
    }
    private void setPage(Container newPage)
    {
        frame.setContentPane(newPage);
        addToPages(newPage);
    }
}



