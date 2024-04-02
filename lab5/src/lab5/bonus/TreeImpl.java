package lab5.bonus;

import java.util.HashSet;
import java.util.List;

public class TreeImpl<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private int treeSize;

    public TreeImpl() {
        this.root = null;
        this.treeSize = 0;
    }

    private void findPlace(Node<T> current, T value){

        if(value.compareTo(current.getValue()) < 0){
            if (current.getLeft() == null) {
                Node<T> newNode = new Node<>(value);
                current.setLeft(newNode);
                this.treeSize ++;
            }
            else
                findPlace(current.getLeft(), value);
        }
        if(value.compareTo(current.getValue()) > 0){
            if (current.getRight() == null) {
                Node<T> newNode = new Node<>(value);
                current.setRight(newNode);
                this.treeSize ++;
            }
            else
                findPlace(current.getRight(), value);
        }
    }

    private void findValues (Node<T> current, T inf, T sup, HashSet<T> result) {
        if (current == null) {
            return;
        }

        if (current.getValue().compareTo(inf) >= 0 && current.getValue().compareTo(sup) <= 0) {
            result.add(current.getValue());
        }

        if (current.getValue().compareTo(inf) > 0) {
            findValues(current.getLeft(), inf, sup, result);
        }

        if (current.getValue().compareTo(sup) < 0) {
            findValues(current.getRight(), inf, sup, result);
        }
    }

    @Override
    public void addValue(T value) {
        if(this.root == null){
            Node<T> newNode = new Node<>(value);
            this.root = newNode;
            this.treeSize ++;
        }
        else
            findPlace(root, value);
    }

    @Override
    public void addAll(List<T> values) {
        for (T value: values){
            addValue(value);
        }
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> result = new HashSet<>();
        findValues(root, inf, sup, result);
        return result;
    }

    @Override
    public int size() {
        return treeSize;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
