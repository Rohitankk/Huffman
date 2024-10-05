package midlab2.priorityqueue;

public class MyQueue<T> implements Queue<T>{
    public DoublyLinkedNode<T> head;

    public MyQueue(){
        head = new DoublyLinkedNode<>();
    }

    @Override
    public void enqueue(T data) {
        if (head.getData() == null){
            head.setData(data);
        } else {
            DoublyLinkedNode<T> newDoublyLinkedNode = new DoublyLinkedNode<>(data);
            DoublyLinkedNode<T> checker = head;
            while(checker.getNext() != null){
                checker = checker.getNext();
            }
            checker.setNext(newDoublyLinkedNode);
            newDoublyLinkedNode.setPrev(checker);
        }
    }

    @Override
    public T dequeue() {
        T dequeued = head.getData();
        if (head.getNext() == null){
            head.setData(null);
        } else {
            head = head.getNext();
            head.getPrev().setNext(null);
            head.setPrev(null);
        }
        return dequeued;
    }

    @Override
    public int size() {
        int count = 0;
        DoublyLinkedNode<T> checker = head;
        if (head.getData() == null){
            return count;
        }
        while(checker != null){
            count++;
            checker = checker.getNext();
        }
        return count;
    }

    @Override
    public T peek() {
        return head.getData();
    }

    @Override
    public boolean isEmpty() {
        return head.getData() == null;
    }

    public void showQueue(){
        DoublyLinkedNode<T> checker = head;
        while (checker != null){
            System.out.println(checker.getData());
            checker = checker.getNext();
        }
    }

    @Override
    public String toString() {
        return head.toString();
    }

}
