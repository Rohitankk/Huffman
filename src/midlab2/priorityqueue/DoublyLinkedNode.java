package midlab2.priorityqueue;

public class DoublyLinkedNode<T> {
    private T Data;
    private DoublyLinkedNode<T> Next;
    private DoublyLinkedNode<T> Prev;

    public DoublyLinkedNode(){
        this.Data = null;
        this.Next = null;
        this.Prev = null;
    }

    public DoublyLinkedNode(T data){
        this.Data = data;
        this.Next = null;
        this.Prev = null;
    }

    public void setData(T data) {
        Data = data;
    }

    public void setNext(DoublyLinkedNode next) {
        Next = next;
    }

    public void setPrev(DoublyLinkedNode prev) {
        Prev = prev;
    }

    public DoublyLinkedNode getNext() {
        return Next;
    }

    public DoublyLinkedNode getPrev() {
        return Prev;
    }

    public T getData() {
        return Data;
    }
}
