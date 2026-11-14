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

    static String find(Node head, String id) {
        Node temp = head;
        int pos = 1, first = 0, count = 0;

        while (temp != null) {
            if (temp.data.equals(id)) {
                if (first == 0)
                    first = pos;
                count++;
            }

            temp = temp.next;
            pos++;
        }

        if (count == 0)
            return id + " not found";

        return id + " first at position " + first +
            ", copies: " + count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String id = sc.next();

        System.out.println(find(head, id));
    }
}
