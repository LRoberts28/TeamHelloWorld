package HrApp;

public class linkedList<T> {
    private Node<T> end;
    private int size;
    private int currentIndex;
    public linkedList()
    {
        end = null;
        size = 0;
        currentIndex = 0;
    }
    public void add(T item)
    {
        Node<T> temp = new Node<T>(item);
        if(size != 0)
        {
            end.setNext(temp);
            temp.setPrevious(end);
        }
        end = temp;
        size++;
        currentIndex++;

    }
    public T remove()
    {
        if(end == null)
        {
            throw new RuntimeException("Can't remove from an empty list");
        }
        Node<T> temp = end;
        end = end.getNext();
        return temp.getItem();
    }
    public int getSize()
    {
        return size;
    }
}
