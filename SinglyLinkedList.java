class SinglyLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // INSERTION :

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAfter(int key, int data) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertBefore(int key, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Node not found");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // DELETION : 

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }

        temp.next = temp.next.next;
    }

    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    public void deleteEntireList() {
        head = null;
        System.out.println("Entire list deleted");
    }

    // LENGTH :

    public int getLength() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // SEARCH : 

    public boolean search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // PRINT :

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // MAIN : 

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.insertAtPosition(25,2);
        list.insertBefore(30, 29);
        list.insertAfter(30, 35);
        
        System.out.println("Abdul Samad-EB25210006005");
        System.out.println("Initial List:");
        list.printList();

        System.out.println("Length: " + list.getLength());

        int key = 30;
        if (list.search(key)) {
            System.out.println("Element " + key + " found");
        } else {
            System.out.println("Element not found");
        }

        // Deletions
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteByValue(20);

        System.out.println("After Deletions:");
        list.printList();

        System.out.println("Final Length: " + list.getLength());
    }
}