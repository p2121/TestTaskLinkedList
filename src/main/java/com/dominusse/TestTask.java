package com.dominusse;

import com.dominusse.model.Node;
import com.dominusse.model.OneWayLinkedList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class TestTask {

    public static void main(String[] args) {
        int n;
        Node head = null;
        OneWayLinkedList oneWayLinkedList = new OneWayLinkedList();
        OneWayLinkedList result[];
        Scanner s = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in list:");
        n = s.nextInt();
        int a[] = new int[n];
        System.out.println("Enter all the elements:");
        if (n > 0) {
            head = new Node(s.nextInt());
            oneWayLinkedList.setHead(head);
            Node currentNode = head;
            int i = 1;
            while (i < n) {
                Node next = new Node(s.nextInt());
                currentNode.setNext(next);
                currentNode = next;
                i++;
            }

            result = divideListInToOddAndEvenReversedOrder(head);
            System.out.println("The odd element are:");
            result[0].printList(result[0].getHead());
            System.out.println("The even elements are:");
            result[1].printList(result[1].getHead());
        } else {
            System.out.println("You have entered 0 elements.");
        }
    }

    private static OneWayLinkedList[] divideListInToOddAndEvenReversedOrder(Node head) {
        OneWayLinkedList result[] = new OneWayLinkedList[2];
        OneWayLinkedList odd = new OneWayLinkedList();
        OneWayLinkedList even = new OneWayLinkedList();
        Node current = head;
        Node previousEven = null;
        Node previousOdd = null;

        while (current != null) {
            if (current.getData() % 2 != 0) {
                Node currentOdd = new Node(current.getData());
                if (odd.getHead() == null) {
                    previousOdd = currentOdd;
                    Node headOdd = previousOdd;
                    odd.setHead(headOdd);
                } else {
                    previousOdd.setNext(currentOdd);
                    previousOdd = currentOdd;
                }
            } else {
                Node currentEven = new Node(current.getData());
                if (even.getHead() == null) {
                    previousEven = currentEven;
                    Node headEven = previousEven;
                    even.setHead(headEven);
                } else {
                    previousEven.setNext(currentEven);
                    previousEven = currentEven;
                }
            }
            current = current.getNext();
        }
        even.setHead(even.mergeSort(even.getHead()));
        odd.setHead(odd.mergeSort(odd.getHead()));
        result[0] = odd;
        result[1] = even;
        return result;
    }


}
