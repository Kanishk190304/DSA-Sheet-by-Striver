package LinkedLists;

import java.util.Scanner;

// Definition for singly-linked list
class Node4 {
    int val;
    Node4 next;

    Node4() {}
    Node4(int val) { this.val = val; }
    Node4(int val, Node4 next) { this.val = val; this.next = next; }
}

public class LinkedLists_RemoveNthNodeFromEndOfList {

    // Function to remove the N-th node from the end of the list
    public Node4 removeNthFromEnd(Node4 head, int n) {
        Node4 dummy = new Node4(0);
        dummy.next = head;
        Node4 slow = dummy;
        Node4 fast = dummy;

        // Move fast pointer n steps ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(Node4 head) {
        Node4 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int size = scanner.nextInt();

        Node4 head = null, tail = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            int val = scanner.nextInt();
            Node4 newNode = new Node4(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        LinkedLists_RemoveNthNodeFromEndOfList solution = new LinkedLists_RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, n);

        System.out.println("Linked list after removing the N-th node from the end:");
        printList(head);

        scanner.close();
    }
}
