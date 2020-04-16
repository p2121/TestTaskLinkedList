package com.dominusse.model;

import java.util.Objects;

public class Node implements Comparable {

    Integer data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return getData() == node.getData() &&
                Objects.equals(getNext(), node.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNext());
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            return this.data.compareTo(((Node) o).getData());
        } else {
            throw new UnsupportedOperationException("Incorrect Type of o");
        }

    }
}
