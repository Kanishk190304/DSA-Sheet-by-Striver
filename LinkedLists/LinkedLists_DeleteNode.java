package LinkedLists;

import java.util.Scanner;

public class LinkedLists_DeleteNode {

    // Definition for singly-linked list node
    static class Node6 {
        int val;
        Node6 next;

        Node6(int x) {
            val = x;
            next = null;
        }
    }

    // Method to delete a node (assuming node is not the tail)
    public void deleteNode(Node6 node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Can't delete the tail or null node using this method.");
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Helper method to print the linked list
    public static void printList(Node6 head) {
        Node6 current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Build the linked list from user input
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("List must have at least 2 elements to delete a non-tail node.");
            return;
        }

        System.out.println("Enter the elements of the linked list:");
        Node6 head = new Node6(scanner.nextInt());
        Node6 current = head;
        Node6 nodeToDelete = null;

        for (int i = 1; i < n; i++) {
            current.next = new Node6(scanner.nextInt());
            current = current.next;

            // Choose the second node as the one to delete (for demonstration)
            if (i == 1) {
                nodeToDelete = current;
            }
        }

        System.out.println("Original linked list:");
        printList(head);

        // Delete the selected node
        LinkedLists_DeleteNode solution = new LinkedLists_DeleteNode();
        solution.deleteNode(nodeToDelete);

        System.out.println("Linked list after deleting the node:");
        printList(head);
    }
}
