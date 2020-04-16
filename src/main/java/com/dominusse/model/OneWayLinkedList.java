package com.dominusse.model;

public class OneWayLinkedList {

    Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    Node sortedMerge(Node a, Node b) {
        Node result = null;
        /* Base cases */
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        /* Pick either a or b, and recur */
        if (a.getData() >= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

    public Node mergeSort(Node h) {
        // Base case : if head is null
        if (h == null || h.getNext() == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

}
