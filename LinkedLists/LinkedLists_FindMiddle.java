package LinkedLists;

import java.util.Scanner;

// Definition for singly-linked list.
class Node2 {
    int val;
    Node2 next;
    Node2() {}
    Node2(int val) { this.val = val; }
    Node2(int val, Node2 next) { this.val = val; this.next = next; }
}

class LinkedLists_FindMiddle {
    // Function to find the middle node of a linked list
    public Node2 middleNode(Node2 head) {
        Node2 slow = head;
        Node2 fast = head;

        // Move fast pointer twice as fast as slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Slow pointer will be at the middle
    }

    // Function to create a linked list from user input
    public static Node2 createLinkedList(int[] values) {
        if (values.length == 0) return null;
        Node2 head = new Node2(values[0]);
        Node2 current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node2(values[i]);
            current = current.next;
        }
        return head;
    }

    // Function to print a linked list
    public static void printLinkedList(Node2 head) {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for linked list elements
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        // Create linked list
        Node2 head = createLinkedList(values);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Find middle node
        LinkedLists_FindMiddle solution = new LinkedLists_FindMiddle();
        Node2 middle = solution.middleNode(head);

        System.out.println("Middle node value: " + middle.val);

        scanner.close();
    }
}