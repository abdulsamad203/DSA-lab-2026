class DoublyLinkedList {

    // Node structure
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
    }

    // Forward Traversal
    public void forwardTraversal() {
        Node temp = head;

        System.out.print("Forward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Backward Traversal
    public void backwardTraversal() {
        Node temp = head;

        while (temp != null && temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("ABDUL SAMAD-EB25210006005");
        // Insert data
        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);
        dll.insertAtBeginning(30);

        // Traversals
        dll.forwardTraversal();
        dll.backwardTraversal();
    }
}