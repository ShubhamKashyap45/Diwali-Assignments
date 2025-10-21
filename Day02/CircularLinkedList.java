class CircularLinkedList {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    private Node head = null;

    void insert(int data, int pos) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }
        if (pos == 1) {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void delete(int data) {
        if (head == null) return;
        Node curr = head, prev = null;
        if (head.data == data) {
            while (curr.next != head)
                curr = curr.next;
            if (curr == head) {
                head = null;
                return;
            }
            curr.next = head.next;
            head = head.next;
            return;
        }
        do {
            prev = curr;
            curr = curr.next;
            if (curr.data == data) {
                prev.next = curr.next;
                return;
            }
        } while (curr != head);
    }

    void modify(int oldData, int newData) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.data == oldData) {
                temp.data = newData;
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void display() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
