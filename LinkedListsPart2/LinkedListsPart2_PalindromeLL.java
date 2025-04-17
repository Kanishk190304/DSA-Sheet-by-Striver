package LinkedListsPart2;

import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */
class Node24 {
    int val;
    Node24 next;
    Node24() {}
    Node24(int val) { this.val = val; }
    Node24(int val, Node24 next) { this.val = val; this.next = next; }
}

public class LinkedListsPart2_PalindromeLL {

    // Function to check if a linked list is a palindrome
    public boolean isPalindrome(Node24 head) {
        if (head == null || head.next == null) {
            return true; // Empty or single element list is a palindrome
        }

        // Find middle of the linked list
        Node24 slow = head;
        Node24 fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        Node24 newHead = reverse(slow.next);

        // Compare the first and second half
        Node24 first = head;
        Node24 second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead); // Restore list before returning
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverse(newHead); // Restore list before returning
        return true;
    }

    // Recursive function to reverse a linked list
    public Node24 reverse(Node24 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node24 newHead = reverse(head.next);
        Node24 front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    // Helper function to create a linked list from an array
    public static Node24 createList(int[] values) {
        if (values.length == 0) return null;
        Node24 head = new Node24(values[0]);
        Node24 current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node24(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print a linked list
    public static void printList(Node24 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function for user input and testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in the linked list: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        Node24 head = createList(values);
        LinkedListsPart2_PalindromeLL solution = new LinkedListsPart2_PalindromeLL();

        System.out.print("The linked list: ");
        printList(head);

        if (solution.isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }

        scanner.close();
    }
}
