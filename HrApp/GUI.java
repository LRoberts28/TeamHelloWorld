package HrApp;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.*;

public class GUI 
{
    private JButton button;
    private JFrame mainPage;
    public static void main(String[] args)
    {
        GUI gui = new GUI();

    }
    public GUI()
    {
        mainPage = new JFrame("Main Page");
        buttonTest();
        setUp();
        
    }
    public void buttonTest()    //testing for resizing a button
    {
        button = new JButton("D");
        button.setSize(10,10);
        button.addActionListener(new actionBack());
        mainPage.getContentPane().add(button);
        

    }
    public void setUp() //sets up the jframe for all of the tests
    {
        mainPage.setSize(1000, 1000);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setVisible(true);
    }
    public JFrame getJFrame()
    {
        return mainPage;
    }
    
}
class actionBack implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        //go back to previous page
        //test code, delete later
        System.out.println("Success");
    }
}



