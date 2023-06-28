package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.SNode;

public class QueueLL extends SLL {

    /**
     * QueueLL() - no argument constructor
     * 
     */
    public QueueLL() {
        super();
    }

    /**
     * QueueLL(SNode data) - 1 argument constructor
     * 
     * @param data
     */
    public QueueLL(SNode data) {
        super(data);
    }

    /**
     * enqueue(SNode data) - enqueues a node to the list
     * 
     * @param data
     */
    public void enqueue(SNode data) {
        super.insertTail(data);
    }

    /**
     * dequeue() - dequeues a node from the list and prints dequeued data value
     * 
     */
    public void dequeue() {
        if (this.size != 0) {
            int valueToDequeue = this.head.getData();
            System.out.println("Dequeued value: " + valueToDequeue);
        }
        super.deleteHead();
    }

    /**
     * peek() prints top element in the queue
     * 
     */
    public void peek() {
        if (this.size == 0) {
            System.out.println("There are no elements currently in the queue. Cannot peek.\n");
            return;
        }
        System.out.println("Top Element in Queue: " + this.head.getData() + "\n");
    }

    /**
     * search(int find) - searches and returns a requested value in the list or
     * returns -1
     * 
     * @param find
     * @return
     */
    public int search(int find) {
        int position = 1;
        SNode current = this.head;
        while (current != null) {
            if (current.getData() == find) {
                return position;
            }
            position++;
            current = current.getNext();
        }
        return -1;
    }

    /**
     * empty() - checks if queue is empty
     * 
     * @return
     */
    public boolean empty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /*
     * Cannot implement the 'full' operation
     * of a stack as a LinkedList does not
     * have a maximum size, thus Stack cannot be 'full'
     */

    // Inherited methods from SLL that are not used in a Queue implementation //
    public void insertHead(SNode data) {
    }

    public void sortedInsert(SNode data) {
    }

    public void insert(SNode data, int position) {
    }

    public boolean isSorted() {
        return false;
    }

    public void sort() {
    }

    public void deleteTail() {
    }

    public void delete(SNode delete) {
    }

    /**
     * print() - prints all requested information concerning the queue.
     * 
     */
    public void print() {
        System.out.println(String.format("Queue Length: %d", this.size));
        System.out.print("Queue Content: ");
        SNode current = this.head;
        while (current != null) {
            System.out.print(String.format("(%d) <- ", current.getData()));
            current = current.getNext();
        }
        System.out.print("null\n");
        System.out.println("");
    }
}
