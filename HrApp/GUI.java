package HrApp;
import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;

public class GUI 
{
    private JFrame frame;
    private JPanel background;
    private Container mainMenu;
    private Container defaultContainer;

    //Arraylists of Containers to contain content panes to save each page

    public static void main(String[] args)
    {
        GUI gui = new GUI();

    }
    public GUI()
    {
        frame = new JFrame("Main Page");
        initiallize();
        defaultContainer = frame.getContentPane();
        mainMenu = mainPage();
        setPage(mainMenu);
        
    }
    private void setPage(Container newPage)
    {
        frame.setContentPane(newPage);
    }
    private Container mainPage()
    {
        taskBar();
        background = new JPanel();
        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        background.setBackground(Color.DARK_GRAY);
        frame.add(background, BorderLayout.CENTER);
        TextField search = new TextField("Start your search here!");

        background.add(search, BorderLayout.CENTER);
        return frame.getContentPane();
    }
    private void taskBar()
    {
        JPanel j = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        j.setBackground(Color.GRAY);

        JButton back = new JButton("<-");
        back.addActionListener(e -> frame.setContentPane(defaultContainer));

        JButton forward = new JButton("->");
        forward.addActionListener(e -> frame.setContentPane(mainMenu));
        j.add(back);
        j.add(forward);
        frame.add(j, BorderLayout.NORTH);


        //you can edit the panel after it has been added!!!
    }
    public void initiallize() //sets up the jframe for all of the tests
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
    
    
}



