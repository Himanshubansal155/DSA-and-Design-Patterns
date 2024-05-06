package linked_list;

public class DLL {
    private Node head;

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    void insertLast(int value) {
        Node node = new Node(value);
        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    Node find(int value) {
        Node node = head;
        while (node.next != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    void insertAfter(int after, int value) {
        Node node = find(after);
        if (node == null) {
            System.out.println("does not exist");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = node.next;
        node.next = newNode;
        newNode.prev = node;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }

    }

    void display() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.value + "  ->> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

class Main {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(10);
        dll.insertLast(35);
        dll.insertFirst(20);
        dll.insertLast(12);
        dll.display();
    }
}
