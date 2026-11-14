import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        next = null;
    }
}

public class Main {

    static Node removeFirst(Node head, String booking) {

        if (head == null)
            return head;

        if (head.data.equals(booking))
            return head.next;

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data.equals(booking)) {
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        return head;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String booking = sc.next();

        boolean found = false;
        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(booking)) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
            head = removeFirst(head, booking);
            printList(head);
        } else {
            System.out.println(booking + " not found");
            printList(head);
        }
    }
}
