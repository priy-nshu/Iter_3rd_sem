public class q3 {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addAtStart(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.next = temp;
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes in the list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty, cannot delete from the start");
            return;
        }
        head = head.next;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty, cannot delete from the end");
            return;
        }

        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        tail = prev;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty, cannot delete from any position");
            return;
        }

        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        int count = 1;

        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return;
        }

        prev.next = current.next;
        if (current.next == null) {
            tail = prev;
        }
    }

    public static void main(String[] args) {
        q3 sList = new q3();
        sList.addAtStart(4);
        sList.addAtStart(3);
        sList.addAtStart(2);
        sList.addAtStart(1);
        sList.addAtEnd(5);
        sList.display();

        sList.deleteAtStart();
        sList.display();

        sList.deleteAtEnd();
        sList.display();

        sList.deleteAtPosition(2);
        sList.display();
    }
}
