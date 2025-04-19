package LinkedListsPart2;

import java.util.*;

class Node26 {
    int data;
    Node26 next;
    Node26 bottom;

    Node26(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

public class LinkedListsPart2_FlatteningLL {

    Node26 mergeTwoLists(Node26 a, Node26 b) {
        Node26 temp = new Node26(0);
        Node26 res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
        }

        if (a != null) temp.bottom = a;
        else temp.bottom = b;

        return res.bottom;
    }

    Node26 flatten(Node26 root) {
        if (root == null || root.next == null)
            return root;

        root.next = flatten(root.next);
        root = mergeTwoLists(root, root.next);
        return root;
    }

    void printList(Node26 node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListsPart2_FlatteningLL obj = new LinkedListsPart2_FlatteningLL();

        System.out.print("Enter number of linked lists (columns): ");
        int n = sc.nextInt();

        Node26 head = null, prevList = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of nodes in list " + (i + 1) + ": ");
            int m = sc.nextInt();

            System.out.println("Enter " + m + " sorted values:");
            Node26 listHead = null, listTail = null;

            for (int j = 0; j < m; j++) {
                int val = sc.nextInt();
                Node26 newNode = new Node26(val);
                if (listHead == null) {
                    listHead = listTail = newNode;
                } else {
                    listTail.bottom = newNode;
                    listTail = newNode;
                }
            }

            if (head == null) {
                head = listHead;
            } else {
                prevList.next = listHead;
            }
            prevList = listHead;
        }

        Node26 flat = obj.flatten(head);
        System.out.println("Flattened linked list:");
        obj.printList(flat);

        sc.close();
    }
}
