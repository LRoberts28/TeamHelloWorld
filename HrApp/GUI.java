package HrApp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI 
{
    private JFrame frame;
    private JPanel background;
    private Container mainMenu;

    //Arraylists of Containers to contain content panes to save each page
    ArrayList<Container> pages = new ArrayList<Container>();
    int currentIndex = 0;

    public static void main(String[] args)
    {
        GUI gui = new GUI();

    }
    public GUI()
    {
        frame = new JFrame("Main Page");
        initiallize();
        JFrame j = new JFrame("Main Page");
        setPage(j.getContentPane());
        mainMenu = mainPage();
        setPage(mainMenu);
        
        
    }
    public void addToPages(Container newPage)
    {
        pages.add(newPage);
        currentIndex++;
    }
    private void setPage(Container newPage)
    {
        frame.setContentPane(newPage);
        addToPages(newPage);
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
        back.addActionListener(e -> setPage(pages.get(currentIndex - 1)));

        JButton forward = new JButton("->");
        forward.addActionListener(e -> setPage(pages.get(currentIndex + 1)));
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



