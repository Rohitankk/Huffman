package midlab2.set;

import midlab2.priorityqueue.DoublyLinkedNode;

import java.util.NoSuchElementException;

public class mySet<T> implements Set<T> {
    DoublyLinkedNode<T> head;
    Filter filter;

    public mySet(Filter filter){
        head = new DoublyLinkedNode<>();
        this.filter = filter;
    }

    @Override
    public int getSize() {
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
    public void insert(T data) {
        if (head.getData() == null) {
            head.setData(data);
        } else {
            DoublyLinkedNode<T> newDoublyLinkedNode = new DoublyLinkedNode<>(data);
            DoublyLinkedNode<T> checker = head;
            while (checker != null) {
                if (filter.whatToFilter(checker.getData(),data)){
                    filter.whenFiltered(checker.getData());
                    return;
                } else if (checker.getNext() == null) {
                    checker.setNext(newDoublyLinkedNode);
                    newDoublyLinkedNode.setPrev(checker);
                    return;
                }
                checker = checker.getNext();
            }
        }
    }
    @Override
    public T getElement(T data) throws NoSuchElementException {
        return null;
    }
    public void showSet(){
        DoublyLinkedNode<T> checker = head;
        while (checker != null){
            System.out.println(checker.getData().toString());
            checker = checker.getNext();
        }
    }

    public DoublyLinkedNode<T> getByNo(int srch){
        DoublyLinkedNode<T> checker = head;
        if (srch > getSize() || srch < 1){
            throw new NoSuchElementException();
        }
        for (int i = 0; i < srch -1; i++){
            checker = checker.getNext();
        }
        return checker;
    }
}
