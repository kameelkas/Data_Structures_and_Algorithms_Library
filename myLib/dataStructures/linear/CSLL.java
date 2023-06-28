package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.SNode;

public class CSLL extends SLL {

    /**
     * CSLL() - No argument constructor
     * 
     */
    public CSLL() {
        super();
    }

    /**
     * CSLL(SNode data) - 1 argument constructor
     * 
     * @param data
     */
    public CSLL(SNode data) {
        super(data);
        data.setNext(this.head);
        tail.setNext(this.head);
    }

    /**
     * insertHead(SNode data) - inserting a node from the head of the SLL
     * 
     * @param data
     */
    public void insertHead(SNode data) {
        if (this.head == null) {
            this.head = data;
            data.setNext(this.head);
            this.tail = data;
            this.tail.setNext(this.head);
            size++;
        } else {
            data.setNext(this.head);
            this.head = data;
            this.tail.setNext(this.head);
            this.size++;

        }
    }

    /**
     * insertTail(SNode data) - inserting a node from the tail of the SLL
     * 
     * @param data
     */
    public void insertTail(SNode data) {
        if (this.tail == null) {
            this.head = data;
            data.setNext(this.head);
            this.tail = data;
            this.tail.setNext(this.head);
            size++;
        } else {
            this.tail.setNext(data);
            this.tail = data;
            this.tail.setNext(this.head);
            this.size++;
        }
    }

    /**
     * insert(SNode data, int position) - inserts a node at the specified position
     * in the list
     * 
     * @param data
     * @param position
     */
    public void insert(SNode data, int position) {
        SNode currentNode = this.head;

        if (position > this.size || position < 1) {
            System.out.println(
                    String.format("Invalid position value given. Cannot insert at position %s for list of lengh %s.\n",
                            position, this.size));
            return;
        }

        if (position == 1) {
            this.insertHead(data);
            return;
        }
        if (position == this.size) {
            this.insertTail(data);
            return;
        }

        for (int currentPosition = 1; currentPosition < (position - 1); currentPosition++) {
            currentNode = currentNode.getNext();
        }
        data.setNext(currentNode.getNext());
        currentNode.setNext(data);
        this.size++;
    }

    public boolean isSorted() {
        boolean sorted = true;
        if (this.size == 0 || this.size == 1) {
            return sorted;
        }

        SNode currentNode = this.head;
        boolean visitedHead = false;
        while (currentNode.getNext() != this.head) {
            int current = currentNode.getData();
            int next = currentNode.getNext().getData();
            if (current > next) {
                sorted = false;
                break;
            }
            currentNode = currentNode.getNext();
            if (currentNode == this.head) {
                if (visitedHead) {
                    break;
                }
                visitedHead = true;
            }
        }
        return sorted;
    }

    /**
     * sort() - sorts the list
     * 
     */
    public void sort() {
        if (this.size == 0 || this.size == 1) {
            return;
        }

        SNode sortedList = null;
        SNode current = this.head;
        SNode last = this.tail;
        last.setNext(null); // Breaking the circular link to prepare for sorting

        while (current != null) {
            SNode next = current.getNext();
            if (sortedList == null || current.getData() < sortedList.getData()) {
                current.setNext(sortedList);
                sortedList = current;
            } else {
                SNode temp = sortedList;
                while (temp.getNext() != null && temp.getNext().getData() < current.getData()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = next;
        }

        this.head = sortedList;
        this.tail = sortedList;
        while (this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
        }
        this.tail.setNext(sortedList); // Re-linking the last node to the head to create a circular link again
    }

    /**
     * sortedInsert(SNode data) - inserts a node at the correct position of a sorted
     * list
     * 
     * @param data
     */
    public void sortedInsert(SNode data) {
        boolean isSorted = this.isSorted();
        if (isSorted == false) {
            this.sort();
        }

        if (data.getData() <= head.getData()) {
            insertHead(data);
            return;
        }

        if (data.getData() >= tail.getData()) {
            insertTail(data);
            return;
        }

        int position = 1;
        SNode current = this.head;
        while (current.getNext() != this.head) {
            if (data.getData() <= current.getNext().getData()) {
                this.insert(data, (position + 1));
                break;
            } else {
                position++;
                current = current.getNext();
                if (current == this.tail && data.getData() >= current.getData()) {
                    this.insert(data, (position + 1));
                    break;
                }
            }
        }
    }

    /**
     * search(SNode node) - searches and returns a requested node in the list or
     * returns null
     * 
     * @param node
     * @return
     */
    public SNode search(SNode node) {
        if (this.size == 0) {
            return null;
        }

        SNode current = this.head;
        do {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        } while (current != this.head);
        return null;
    }

    /**
     * clear() - clears the list
     * 
     */
    public void clear() {
        this.tail.setNext(null);
        super.clear();
    }

    /**
     * deleteHead() - deletes the node at the head of the list
     * 
     */
    public void deleteHead() {
        if (this.size == 0) {
            System.out.println("Cannot delete a node from an empty list.\n");
            return;
        }

        if (this.size == 1) {
            this.head = null;
            this.tail.setNext(null);
            this.tail = null;
            this.size--;
            return;
        }

        SNode nodeToBeDeleted = this.head;
        SNode currentNode = this.tail;

        this.head = this.head.getNext();
        currentNode.setNext(this.head);
        nodeToBeDeleted.setNext(null);
        this.size--;
    }

    /**
     * deleteTail() - deletes the node at the tail of the list
     * 
     */
    public void deleteTail() {
        if (this.size == 0) {
            System.out.println("Cannot delete a node from an empty list.\n");
            return;
        }

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        SNode current = this.head;
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }

        current.setNext(this.head);
        this.tail = current;
        this.tail.setNext(this.head);
        this.size--;
    }

    public void delete(SNode delete) {
        if (this.size == 0) {
            System.out.println("Cannot delete requested node from an empty list.\n");
            return;
        }

        SNode current = this.head;
        SNode prev = this.tail;

        do {
            if (current == delete) {
                if (current == this.head) {
                    deleteHead();
                } else if (current == this.tail) {
                    deleteTail();
                } else {
                    prev.setNext(current.getNext());
                    current.setNext(null);
                    this.size--;
                }
                return;
            }
            prev = current;
            current = current.getNext();
        } while (current != this.head);

        System.out.println("Node was not found in the list. Cannot delete nonexistent node.\n");
    }

    /**
     * print() - prints all requested information concerning the list.
     * 
     */
    public void print() {
        System.out.println(String.format("List Length: %d", this.size));
        boolean sorted = this.isSorted();
        if (sorted == true) {
            System.out.println("Sorted Status: Sorted");
        } else if (sorted == false) {
            System.out.println("Sorted Status: Not Sorted");
        }
        System.out.print("List Content: ");
        if (this.size == 0) {
            System.out.print("null\n");
            System.out.println("");
        } else {
            System.out.print("-> ");
            SNode current = this.head;
            do {
                System.out.print(String.format("(%d) -> ", current.getData()));
                current = current.getNext();
            } while (current != this.head);
            System.out.println("");
        }
    }
}
