package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.DNode;

public class CDLL extends DLL {

    /**
     * CDLL() - No argument constructor
     * 
     */
    public CDLL() {
        super();
    }

    /**
     * CDLL(DNode data) - 1 argument constructor
     * 
     * @param data
     */
    public CDLL(DNode data) {
        super(data);
        data.setNext(this.head);
        this.tail.setNext(this.head);
        data.setPrev(this.tail);
        this.head.setPrev(this.tail);
    }

    /**
     * insertHead(DNode data) - inserting a node from the head of the CDLL
     * 
     * @param data
     */
    public void insertHead(DNode data) {
        if (this.head == null) {
            this.head = data;
            this.head.setNext(this.head);
            this.head.setPrev(this.head);
            this.tail = data;
            this.tail.setNext(this.head);
            this.tail.setPrev(this.head);
            size++;
        } else {
            data.setNext(this.head);
            this.head.setPrev(data);
            data.setPrev(this.tail);
            this.tail.setNext(data);
            this.head = data;
            size++;
        }
    }

    /**
     * insertTail(DNode data) - inserting a node from the tail of the CDLL
     * 
     * @param data
     */
    public void insertTail(DNode data) {
        if (this.tail == null) {
            this.head = data;
            this.head.setNext(this.head);
            this.head.setPrev(this.head);
            this.tail = data;
            this.tail.setNext(this.head);
            this.tail.setPrev(this.head);
            size++;
        } else {
            data.setPrev(this.tail);
            this.tail.setNext(data);
            this.tail = data;
            this.tail.setNext(this.head);
            this.head.setPrev(this.tail);
            size++;
        }
    }

    /**
     * @return
     */
    public boolean isSorted() {
        boolean sorted = true;
        if (this.size == 0 || this.size == 1) {
            return sorted;
        }

        DNode currentNode = this.head;
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
     * insert(DNode data, int position) - inserts a node at the specified position
     * in the list
     * 
     * @param data
     * @param position
     */
    public void insert(DNode data, int position) {
        if (position > this.size || position < 1) {
            System.out.println(
                    String.format("Invalid position value given. Cannot insert at position %s for list of length %s.\n",
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

        DNode currentNode = this.head;
        for (int currentPosition = 1; currentPosition < position; currentPosition++) {
            currentNode = currentNode.getNext();
        }
        DNode previousNode = currentNode.getPrev();
        previousNode.setNext(data);
        data.setPrev(previousNode);
        data.setNext(currentNode);
        currentNode.setPrev(data);
        this.size++;
    }

    /**
     * sort() - sorts the list
     * 
     */
    public void sort() {
        if (this.size == 0 || this.size == 1) {
            return;
        }

        DNode sortedList = null;
        DNode current = this.head;
        DNode last = this.tail;
        last.setNext(null); // Breaking the circular link to prepare for sorting

        while (current != null) {
            DNode next = current.getNext();
            if (sortedList == null || current.getData() <= sortedList.getData()) {
                current.setNext(sortedList);
                if (sortedList != null) {
                    sortedList.setPrev(current);
                }
                sortedList = current;
            } else {
                DNode temp = sortedList;
                while (temp.getNext() != null && temp.getNext().getData() < current.getData()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(current);
                }
                temp.setNext(current);
                current.setPrev(temp);
            }
            current = next;
        }

        this.head = sortedList;
        this.tail = sortedList;
        while (this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
        }
        this.tail.setNext(sortedList); // Re-linking the last node to the head to create a circular link again
        sortedList.setPrev(this.tail); // Setting the previous pointer of the head node to the tail
    }

    /**
     * sortedInsert(DNode data) - inserts a node at the correct position of a sorted
     * list
     * 
     * @param data
     */
    public void sortedInsert(DNode data) {
        boolean isSorted = this.isSorted();
        if (isSorted == false) {
            this.sort();
        }

        if (data.getData() <= this.head.getData()) {
            insertHead(data);
            return;
        }

        DNode current = this.head;
        while (current != this.tail) {
            if (data.getData() >= current.getData() && data.getData() <= current.getNext().getData()) {
                DNode nextNode = current.getNext();
                current.setNext(data);
                data.setPrev(current);
                data.setNext(nextNode);
                nextNode.setPrev(data);
                this.size++;
                return;
            }
            current = current.getNext();
        }

        if (data.getData() >= this.tail.getData()) {
            insertTail(data);
        }
    }

    /**
     * search(DNode node) - searches and returns a requested node in the list or
     * returns null
     * 
     * @param node
     * @return
     */
    public DNode search(DNode node) {
        if (this.size == 0) {
            return null;
        }

        DNode current = this.head;
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
        this.head.setPrev(null);
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

        DNode nodeToBeDeleted = this.head;
        if (this.size == 1) {
            this.tail.setNext(null);
            this.head.setPrev(null);
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }
        nodeToBeDeleted.setNext(null);
        nodeToBeDeleted.setPrev(null);
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
            this.tail.setNext(null);
            this.head.setPrev(null);
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        DNode nodeToBeDeleted = this.tail;
        DNode previous = this.tail.getPrev();
        previous.setNext(this.head);
        this.head.setPrev(previous);
        this.tail = previous;
        nodeToBeDeleted.setPrev(null);
        nodeToBeDeleted.setNext(null);
        this.size--;
    }

    /**
     * delete(DNode delete) - deletes the requested node from the list
     * 
     * @param delete
     */
    public void delete(DNode delete) {
        if (this.size == 0) {
            System.out.println("Cannot delete requested node from an empty list.\n");
            return;
        }

        DNode initialSearch = this.search(delete);

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

            DNode before = delete.getPrev();
            DNode after = delete.getNext();
            before.setNext(after);
            after.setPrev(before);
            delete.setNext(null);
            delete.setPrev(null);
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
        DNode current = this.head;
        String formatList = "";
        if (this.size == 0) {
            System.out.print("null\n");
        } else {
            System.out.print("<-> ");
            do {
                formatList += String.format("(%s) <-> ", current.getData());
                current = current.getNext();
            } while (current != this.head);
        }
        System.out.println(formatList);
        System.out.println("");
    }
}
