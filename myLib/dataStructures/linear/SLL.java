package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.SNode;

public class SLL {
    protected SNode head;
    protected SNode tail = null;
    protected int size = 0;

    /**
     * getHead() - returns the head object - needed for testing purposes
     * 
     * @return
     */
    public SNode getHead() {
        return this.head;
    }

    /**
     * getTail() - returns the tail object - needed for testing purposes
     * 
     * @return
     */
    public SNode getTail() {
        return this.tail;
    }

    /**
     * SLL() - No argument constructor
     * 
     */
    public SLL() {
        this.head = null;
    }

    /**
     * SLL(SNode data) - 1 argument constructor
     * 
     * @param data
     */
    public SLL(SNode data) {
        this.head = data;
        this.tail = data;
        this.size++;
    }

    /**
     * insertHead(SNode data) - inserting a node from the head of the SLL
     * 
     * @param data
     */
    public void insertHead(SNode data) {
        if (this.head == null) {
            this.head = data;
            this.tail = data;
            this.size++;
        } else {
            data.setNext(this.head);
            this.head = data;
            this.size++;
        }
    }

    /**
     * insertTail(SNode data) - inserting a node from the tail of the SLL
     * 
     * @param data
     */
    public void insertTail(SNode data) {
        if (this.head == null || this.tail == null) {
            this.head = data;
            this.tail = data;
            this.size++;
        } else {
            this.tail.setNext(data);
            this.tail = data;
            this.size++;
        }
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
        while (current.getNext() != null) {
            if (data.getData() <= current.getNext().getData()) {
                this.insert(data, (position + 1));
                break;
            } else {
                position++;
                current = current.getNext();
            }
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

    /**
     * @return
     */
    public boolean isSorted() {
        boolean sorted = true;
        if (this.size == 0 || this.size == 1) {
            return sorted;
        }

        SNode currentNode = this.head;
        while (currentNode.getNext() != null) {
            int current = currentNode.getData();
            int next = currentNode.getNext().getData();
            if (current > next) {
                sorted = false;
                break;
            }
            currentNode = currentNode.getNext();
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

        SNode tailFinder = this.head;
        while (tailFinder.getNext() != null) {
            tailFinder = tailFinder.getNext();
        }

        this.tail = tailFinder;

    }

    /**
     * search(SNode find) - searches and returns a requested node in the list or
     * returns null
     * 
     * @param find
     * @return
     */
    public SNode search(SNode find) {
        SNode current = this.head;
        while (current != null) {
            if (current == find) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * clear() - clears the list
     * 
     */
    public void clear() {
        SNode toDelete = this.head;
        while (toDelete != null) {
            SNode deleted = toDelete;
            toDelete = toDelete.getNext();
            deleted.setNext(null);
            deleted = null;
            this.size--;
        }
        this.head.setNext(null);
        this.head = null;
        System.out.println("List/Stack/Queue has been cleared.\n");
    }

    /**
     * deleteHead() - deletes the node at the head of the list
     * 
     */
    public void deleteHead() {
        if (this.size == 0) {
            System.out.println("Cannot delete a node from an empty list/stack/queue.\n");
            return;
        }

        if (this.size == 1) {
            this.head.setNext(null);
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        SNode nodeToBeDeleted = this.head;
        this.head = this.head.getNext();
        nodeToBeDeleted.setNext(null);
        nodeToBeDeleted = null;
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
            this.head.setNext(null);
            this.tail.setNext(null);
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        SNode current = this.head;
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }
        this.tail = null;
        current.setNext(null);
        this.tail = current;
        this.size--;
    }

    /**
     * delete(SNode delete) - deletes the requested node from the list
     * 
     * @param delete
     */
    public void delete(SNode delete) {
        if (this.size == 0) {
            System.out.println("Cannot delete requested node from an empty list.\n");
            return;
        }

        SNode initialSearch = this.search(delete);

        if (initialSearch == null) {
            System.out.println("Node was not found in the list. Cannot delete nonexistent node.\n");
            return;
        }

        if (initialSearch == delete) {
            if (delete == this.head) {
                deleteHead();
                return;
            }

            if (delete == this.tail) {
                deleteTail();
                return;
            }

            SNode current = this.head;
            while (current.getNext() != delete) {
                current = current.getNext();
            }

            SNode toDelete = current.getNext();
            current.setNext(toDelete.getNext());
            toDelete.setNext(null);
            toDelete = null;
            this.size--;
        }
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
        SNode current = this.head;
        while (current != null) {
            System.out.print(String.format("(%d) -> ", current.getData()));
            current = current.getNext();
        }
        System.out.print("null\n");
        System.out.println("");
    }
}
