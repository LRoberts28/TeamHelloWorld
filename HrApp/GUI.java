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
        loginPage();
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

    //creates the main page as a content pane and returns it
    private Container mainPage()
    {
        taskBar();
        background = new JPanel();
        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        background.setBackground(Color.DARK_GRAY);
        frame.add(background, BorderLayout.CENTER);
        TextField search = new TextField("Start your search here!");
        search.addKeyListener(new KeyListener(){
            private String returned = "";
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == e.VK_ENTER)
                {
                    System.out.println(returned);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
                returned += e.getKeyChar();
            }
        });

        background.add(search, BorderLayout.CENTER);
        return frame.getContentPane();
    }

    private Container loginPage()
    {
        background = new JPanel();
        TextField username = new TextField("Username");
        username.addKeyListener(new KeyListener() {
            private String returned = "";
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == e.VK_ENTER)
                {
                    System.out.println(returned);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
                returned += e.getKeyChar();
            }
        });
        frame.add(username);

        return background;

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



