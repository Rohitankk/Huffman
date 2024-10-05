package midlab2.Tree;

public class NarraNode<T> {
    T data;
    NarraNode left;
    NarraNode right;

    public NarraNode(T value) {
        this.data = value;
        right = null;
        left = null;
    }

    NarraNode() {
        this.data = null;
        right = null;
        left = null;
    }

    public void setLeft(NarraNode left) {
        this.left = left;
    }

    public void setRight(NarraNode right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NarraNode getLeft() {
        return left;
    }

    public NarraNode getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
