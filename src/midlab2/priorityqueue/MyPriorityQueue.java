package midlab2.priorityqueue;

public class MyPriorityQueue<T> extends MyQueue<T> {
    Comparer compare;

    public MyPriorityQueue(Comparer c){
        this.compare = c;
    }

    public void enqueue(T data) {
        DoublyLinkedNode<T> newDoublyLinkedNode = new DoublyLinkedNode<>(data);
        DoublyLinkedNode<T> checker = head;
        if (head.getData() == null){
            head.setData(data);
        } else if(compare.compare(head.getData(),data) >= 0){
            newDoublyLinkedNode.setNext(head);
            head.setPrev(newDoublyLinkedNode);
            head = newDoublyLinkedNode;
        }else {
            while (checker != null){
                if (compare.compare(checker.getData(),data) >= 0 ) {
                    newDoublyLinkedNode.setPrev(checker.getPrev());
                    checker.getPrev().setNext(newDoublyLinkedNode);
                    newDoublyLinkedNode.setNext(checker);
                    checker.setPrev(newDoublyLinkedNode);
                    return;
                }
                if (checker.getNext() == null){
                    break;
                } else {
                    checker = checker.getNext();
                }
            }
            checker.setNext(newDoublyLinkedNode);
            newDoublyLinkedNode.setPrev(checker);
        }
    }
}
