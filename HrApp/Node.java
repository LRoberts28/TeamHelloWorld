package HrApp;

public class Node<T> {
    private T item;
    private Node<T> next;
    public Node(T item)
    {
        item = this.item;
        next = null;
    }
    public T getItem()
    {
        return item;
    }
    public Node<T> getNext()
    {
        return next;
    }
    public void setItem(T item)
    {
        item = this.item;
    }
    public void setNext(Node<T> next)
    {
        next = this.next;
    }
}
