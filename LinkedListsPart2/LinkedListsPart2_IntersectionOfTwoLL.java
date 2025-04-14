package LinkedListsPart2;

import java.util.*;

class Node21 {
    int val;
    Node21 next;

    Node21(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListsPart2_IntersectionOfTwoLL {

    // Function to get the intersection node of two linked lists
    public Node21 getIntersectionNode(Node21 headA, Node21 headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node21 t1 = headA;
        Node21 t2 = headB;

        while (t1 != t2) {
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }

        return t1;
    }

    // Helper method to create a linked list from an array of values
    public static Node21 createList(int[] values) {
        Node21 dummy = new Node21(0);
        Node21 current = dummy;
        for (int val : values) {
            current.next = new Node21(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Main method for user input and testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first list
        System.out.print("Enter number of nodes in List A: ");
        int n1 = sc.nextInt();
        int[] listA_vals = new int[n1];
        System.out.println("Enter elements of List A:");
        for (int i = 0; i < n1; i++) {
            listA_vals[i] = sc.nextInt();
        }

        // Input second list
        System.out.print("Enter number of nodes in List B: ");
        int n2 = sc.nextInt();
        int[] listB_vals = new int[n2];
        System.out.println("Enter elements of List B:");
        for (int i = 0; i < n2; i++) {
            listB_vals[i] = sc.nextInt();
        }

        // Create both lists
        Node21 headA = createList(listA_vals);
        Node21 headB = createList(listB_vals);

        // To simulate intersection, let's manually link the tail of list B to a node in list A
        // This part is optional and only for demo purposes
        if (n1 > 0 && n2 > 0) {
            Node21 tailB = headB;
            while (tailB.next != null) {
                tailB = tailB.next;
            }

            Node21 intersectionPoint = headA;
            for (int i = 0; i < Math.min(2, n1); i++) { // change 2 to any index < n1
                intersectionPoint = intersectionPoint.next;
            }

            tailB.next = intersectionPoint; // create an intersection
        }

        LinkedListsPart2_IntersectionOfTwoLL obj = new LinkedListsPart2_IntersectionOfTwoLL();
        Node21 intersection = obj.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }

        sc.close();
    }
}
