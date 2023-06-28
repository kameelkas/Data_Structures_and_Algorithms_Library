package myLib.dataStructures.linear;

import myLib.dataStructures.nodes.DNode;

public class DLL {
    protected DNode head;
    protected DNode tail = null;
    protected int size = 0;

    /**
     * getHead() - returns the head object. Needed for testing purposes
     * 
     * @return
     */
    public DNode getHead() {
        return this.head;
    }

    /**
     * getTail() - returns the tail object. Needed for testing purposes
     * 
     * @return
     */
    public DNode getTail() {
        return this.tail;
    }

    /**
     * DLL () - No argument constructor
     * 
     */
    public DLL() {
        this.head = null;
    }

    /**
     * DLL(DNode data) - 1 argument constructor
     * 
     * @param data
     */
    public DLL(DNode data) {
        this.head = data;
        this.tail = data;
        this.size++;
    }

    /**
     * insertHead(DNode data) - inserting a node from the head of the DLL
     * 
     * @param data
     */
    public void insertHead(DNode data) {
        if (this.head == null) {
            this.head = data;
            this.tail = data;
            this.size++;
        } else {
            data.setNext(this.head);
            this.head.setPrev(data);
            this.head = data;
            this.size++;
        }
    }

    /**
     * insertTail(DNode data) - inserting a node from the tail of the DLL
     * 
     * @param data
     */
    public void insertTail(DNode data) {
        if (this.tail == null) {
            this.head = data;
            this.tail = data;
            this.size++;
        } else {
            data.setPrev(this.tail);
            this.tail.setNext(data);
            this.tail = data;
            this.size++;
        }
    }

    /**
     * insert(DNode data, int position) - inserts a node at the specified position
     * in the list
     * 
     * @param data
     * @param position
     */
    public void insert(DNode data, int position) {
        DNode currentNode = this.head;
        DNode nextNode = currentNode.getNext();

        if (position > this.size || position < 1) {
            System.out.println(
                    String.format("Invalid position value given. Cannot insert at position %s for list of lengh %s.",
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
            nextNode = nextNode.getNext();
        }

        data.setPrev(currentNode);
        data.setNext(nextNode);
        currentNode.setNext(data);
        nextNode.setPrev(data);
        this.size++;

    }

    private boolean isSorted() {
        boolean sorted = true;
        if (this.size == 0 || this.size == 1) {
            return sorted;
        }

        DNode currentNode = this.head;
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

        DNode sortedList = null;
        DNode current = this.head;
        while (current != null) {
            DNode next = current.getNext();

            if (sortedList == null || current.getData() < sortedList.getData()) {
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

        DNode tailFinder = this.head;
        while (tailFinder.getNext() != null) {
            tailFinder = tailFinder.getNext();
        }

        this.tail = tailFinder;
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

        if (data.getData() <= head.getData()) {
            insertHead(data);
            return;
        }

        if (data.getData() >= tail.getData()) {
            insertTail(data);
            return;
        }

        int position = 1;
        DNode current = this.head;
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
     * search(DNode find) - searches and returns a requested node in the list or
     * returns null
     * 
     * @param find
     * @return
     */
    public DNode search(DNode find) {
        DNode current = this.head;
        while (current != null) {
            if (current == find) {
                return current;
            }
            current = current.getNext();
        }
        return null;
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
            this.head.setNext(null);
            this.tail.setNext(null);
            this.head.setPrev(null);
            this.tail.setPrev(null);
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        DNode nodeToBeDeleted = this.head;
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
            this.head.setPrev(null);
            this.tail.setPrev(null);
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        DNode trackNewLast = this.tail.getPrev();
        this.tail.getPrev().setNext(null);
        this.tail.setPrev(null);
        this.tail = trackNewLast;
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

            DNode current = this.head;
            while (current != delete) {
                current = current.getNext();
            }

            DNode before = current.getPrev();
            DNode after = current.getNext();
            before.setNext(after);
            after.setPrev(before);
            current.setNext(null);
            current.setPrev(null);
            this.size--;
        }
    }

    /**
     * clear() - clears the list
     * 
     */
    public void clear() {
        DNode toDelete = this.head;
        while (toDelete != null) {
            DNode deleted = toDelete;
            toDelete = toDelete.getNext();
            deleted.setPrev(null);
            deleted.setNext(null);
            deleted = null;
            size--;
        }
        this.head.setPrev(null);
        this.head.setNext(null);
        this.head = null;
        System.out.println("List has been cleared.\n");
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
        while (current != null) {
            formatList += String.format("(%s) -> <- ", current.getData());
            current = current.getNext();
        }
        if (formatList.length() == 0) {
            System.out.print("null\n");
        } else {
            formatList = formatList.substring(0, (formatList.length() - 3));
            System.out.print(formatList);
            System.out.print("null\n");
        }
        System.out.println("");
    }
}
