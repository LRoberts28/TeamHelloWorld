package HrApp;
import javax.swing.*;

public class NodeGUI {
    private JFrame previousFrame;
    private JFrame nextFrame;
    public NodeGUI()
    {
        previousFrame = null;
        nextFrame = null;
    }
    public JFrame getPrevious()
    {
        return previousFrame;
    }
    public JFrame getNext()
    {
        return nextFrame;
    }
    public void setPrevious(JFrame previous)
    {
        previousFrame = previous;
    }
    public void setNext(JFrame next)
    {
        nextFrame = next;
    }
}
