package linked_list;

public class CLL {
    private Node head;
    private Node tail;
    int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
        size++;
    }

    void delete(int val) {
        Node temp = head;
        if (temp == null) {
            return;
        }
        if (temp.value == val) {
            head = head.next;
            tail.next = head;
            size--;
            return;
        }
        do {
            Node n = temp.next;
            if (n.value == val) {
                temp.next = n.next;
                size--;
                break;
            }
            temp = temp.next;
        } while (temp != head);

    }

    void display() {
        Node temp = head;
        do {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD " + size);
    }
}

class Main {
    public static void main(String[] args) {
        CLL cll = new CLL();
        cll.insert(10);
        cll.insert(12);
        cll.insert(20);
        cll.display();
        cll.delete(12);
        cll.display();
        cll.insert(15);
        cll.delete(10);
        cll.display();
        cll.insert(44);
        cll.display();
    }
}
