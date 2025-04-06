package LinkedLists;

import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */
class Node5 {
    int val;
    Node5 next;

    Node5() {}

    Node5(int val) {
        this.val = val;
    }

    Node5(int val, Node5 next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedLists_AddTwoNumbers {

    // Method to add two numbers represented by linked lists
    public Node5 addTwoNumbers(Node5 l1, Node5 l2) {
        Node5 dummy = new Node5();
        Node5 temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            Node5 node = new Node5(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }

    // Helper method to create a linked list from an array
    public static Node5 createLinkedList(int[] digits) {
        Node5 dummy = new Node5();
        Node5 current = dummy;
        for (int digit : digits) {
            current.next = new Node5(digit);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printLinkedList(Node5 node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedLists_AddTwoNumbers solution = new LinkedLists_AddTwoNumbers();

        // Input first number
        System.out.print("Enter the number of digits in the first number: ");
        int n1 = scanner.nextInt();
        int[] digits1 = new int[n1];
        System.out.println("Enter digits of the first number in reverse order:");
        for (int i = 0; i < n1; i++) {
            digits1[i] = scanner.nextInt();
        }

        // Input second number
        System.out.print("Enter the number of digits in the second number: ");
        int n2 = scanner.nextInt();
        int[] digits2 = new int[n2];
        System.out.println("Enter digits of the second number in reverse order:");
        for (int i = 0; i < n2; i++) {
            digits2[i] = scanner.nextInt();
        }

        // Create linked lists
        Node5 l1 = createLinkedList(digits1);
        Node5 l2 = createLinkedList(digits2);

        // Add two numbers
        Node5 result = solution.addTwoNumbers(l1, l2);

        // Output result
        System.out.print("Sum in reverse order: ");
        printLinkedList(result);

        scanner.close();
    }
}
