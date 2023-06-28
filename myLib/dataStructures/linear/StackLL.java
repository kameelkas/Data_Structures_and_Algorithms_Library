package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.SNode;

public class StackLL extends SLL {

    /**
     * StackLL() - no argument constructor
     * 
     */
    public StackLL() {
        super();
    }

    /**
     * StackLL(SNode data) - 1 argument constructor
     * 
     * @param data
     */
    public StackLL(SNode data) {
        super(data);
        this.tail = null;
    }

    /**
     * push(SNode data) - pushes a node onto to the stack
     * 
     * @param data
     */
    public void push(SNode data) {
        super.insertHead(data);
        this.tail = null;
    }

    /**
     * pop() - pops the top element in the stack and prints the data value popped
     * 
     */
    public void pop() {
        if (this.size != 0) {
            int valueToPop = this.head.getData();
            System.out.println("Popped value: " + valueToPop);
        }

        super.deleteHead();
        this.tail = null;
    }

    /**
     * peek() prints top element in the stack
     * 
     */
    public void peek() {
        if (this.size == 0) {
            System.out.println("There are no elements currently in the stack. Cannot peek.\n");
            return;
        }
        System.out.println("Top Element in Stack: " + this.head.getData() + "\n");
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

    // Inherited methods from SLL that are not used in a Stack implementation //
    public void insertTail(SNode data) {
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
     * print() - prints all requested information concerning the stack.
     * 
     */
    public void print() {
        System.out.println(String.format("Stack Length: %d", this.size));
        System.out.print("Stack Content: ");
        SNode current = this.head;
        while (current != null) {
            System.out.print(String.format("(%d) -> ", current.getData()));
            current = current.getNext();
        }
        System.out.print("null\n");
        System.out.println("");
    }
}
