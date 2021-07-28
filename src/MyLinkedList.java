
public class MyLinkedList {
    /** Initialize your data structure here. */
    int size;
    Node head;  // sentinel node as pseudo-head
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;
        int count = 0;
        Node curr = head;
        while (count < index + 1){ // + 1 is added here because of the sentinel node added at the beginning
            curr = curr.next;
            count++;
        }
        return curr.val;
    }

    public int getTail() {
        Node cur = head;
        int count = 0;
        while (count < size) {
            cur = cur.next;
            count++;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index < 0) index = 0;
        ++size;

        int count = 0;
        Node curr = head;
        while (count < index) {
            curr = curr.next;
            count++;
        }
        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        size--;

        Node curr = head;
        Node toDelete = null;
        int count = 0;

        while (count < index){
            count++;
            curr = curr.next;
        }
        toDelete = curr.next;
        curr.next = toDelete.next;
        toDelete.next = null;
    }

}
