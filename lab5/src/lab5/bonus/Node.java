package lab5.bonus;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> right;
    private Node<T> left;

    public Node(T value){
        this.value = value;
        this.right = null;
        this.left = null;
    }
    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        this.value = value;
    }
    public Node<T> getRight(){
        return this.right;
    }
    public void setRight(Node<T> right){
        this.right = right;
    }
    public Node<T> getLeft(){
        return this.left;
    }
    public void setLeft(Node<T> left){
        this.left = left;
    }

}
