import myLib.dataStructures.nodes.*;
import myLib.dataStructures.linear.*;
import myLib.dataStructures.trees.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class AlgorithmsTest {
    public static void main(String[] args) {
        System.out.println("------MODULE 1 TESTS------");

        SNode node = new SNode(1);
        SNode node1 = new SNode(-3);
        SNode node2 = new SNode(-5);
        SNode node3 = new SNode(6);
        SNode node4 = new SNode(292);
        SNode node5 = new SNode(500);
        SNode node6 = new SNode(5024);
        SNode node7 = new SNode(292);
        SNode node8 = new SNode(-292);
        SNode node9 = new SNode(23);
        SNode node10 = new SNode(67);
        SNode node11 = new SNode(37);

        DNode node12 = new DNode(1);
        DNode node13 = new DNode(0);
        DNode node14 = new DNode(-553);
        DNode node15 = new DNode(523);
        DNode node16 = new DNode(233);
        DNode node17 = new DNode(3);
        DNode node18 = new DNode(-2);
        DNode node19 = new DNode(-5);
        DNode node20 = new DNode(233);
        DNode node21 = new DNode(46);
        DNode node22 = new DNode(22);
        DNode node23 = new DNode(2);

        System.out.println("*******BEGINNING OF TEST FOR SLL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");
        SLL SLLNoNode = new SLL();

        SLLNoNode.insertHead(node1);
        SLLNoNode.print();

        SLLNoNode.clear();
        SLLNoNode.print();

        System.out.println("***TESTING 1 ARGUMENT CONSTRUCTOR***");
        System.out.println("***TESTING INSERTHEAD, INSTERTTAIL, INSERT, SORTED INSERT***\n");

        SLL SLL = new SLL(node);
        SLL.print();

        SLL.insertHead(node1);
        SLL.print();

        SLL.insertHead(node2);
        SLL.print();

        SLL.insertTail(node3);
        SLL.print();

        SLL.insertTail(node4);
        SLL.print();

        SLL.insert(node5, 3);
        SLL.print();

        System.out.println("***TRYING TO INSERT AT NONEXISTENT POSITION***\n");
        SLL.insert(node6, 76);

        SLL.insertHead(node7);
        SLL.print();

        System.out.println("***TESTING SORT FUNCTION***\n");
        SLL.sort();
        SLL.print();

        SLL.sortedInsert(node8);
        SLL.print();

        SLL.sortedInsert(node9);
        SLL.print();

        System.out.println("***TESTING SEARCH FUNCTION***\n");
        System.out.println("Search for a node (is currently in list): " + SLL.search(node2));
        System.out.println("Search for a node (is currently not in list): " + SLL.search(node10) + "\n");

        System.out.println("***TESTING DELETEHEAD, DELETETAIL, DELETE***\n");
        SLL.deleteHead();
        SLL.print();

        SLL.deleteTail();
        SLL.print();

        SLL.delete(node3);
        SLL.print();

        System.out.println("***TRYING TO DELETE NODE THAT IS NOT IN LIST***\n");
        SLL.delete(node11);

        System.out.println("***TESTING CLEAR FUNCTION, OTHER FUNCTIONS TO SHOW RESPONSE TO AN EMPTY LIST***\n");
        SLL.clear();
        SLL.print();
        SLL.sort();
        SLL.deleteHead();
        SLL.deleteTail();
        SLL.delete(node10);
        System.out.println("Search for a node (after a clear): " + SLL.search(node10) + "\n");

        System.out.println("***TESTING INSERT AND DELETE AFTER A CLEAR***\n");
        SLL.insertHead(node1);
        SLL.print();

        SLL.deleteHead();
        SLL.print();

        SLL.insertTail(node2);
        SLL.print();

        SLL.deleteTail();
        SLL.print();

        System.out.println("*******BEGINNING OF TEST FOR DLL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");
        DLL DLLNoNode = new DLL();

        DLLNoNode.insertHead(node13);
        DLLNoNode.print();

        DLLNoNode.clear();
        DLLNoNode.print();

        System.out.println("***TESTING 1 ARGUMENT CONSTRUCTOR***");
        System.out.println("***TESTING INSERTHEAD, INSTERTTAIL, INSERT, SORTED INSERT***\n");

        DLL DLL = new DLL(node12);
        DLL.print();

        DLL.insertHead(node13);
        DLL.print();

        DLL.insertHead(node14);
        DLL.print();

        DLL.insertTail(node15);
        DLL.print();

        DLL.insertTail(node16);
        DLL.print();

        DLL.insert(node17, 3);
        DLL.print();

        System.out.println("***TRYING TO INSERT AT NONEXISTENT POSITION***\n");
        DLL.insert(node18, 76);

        DLL.insertHead(node19);
        DLL.print();

        System.out.println("***TESTING SORT FUNCTION***\n");
        DLL.sort();
        DLL.print();

        DLL.sortedInsert(node20);
        DLL.print();

        DLL.sortedInsert(node21);
        DLL.print();

        System.out.println("***TESTING SEARCH FUNCTION***\n");
        System.out.println("Search for a node (is currently in list): " + DLL.search(node14));
        System.out.println("Search for a node (is currently not in list): " + DLL.search(node22) + "\n");

        System.out.println("***TESTING DELETEHEAD, DELETETAIL, DELETE***\n");
        DLL.deleteHead();
        DLL.print();

        DLL.deleteTail();
        DLL.print();

        DLL.delete(node17);
        DLL.print();

        System.out.println("***TRYING TO DELETE NODE THAT IS NOT IN LIST***\n");
        DLL.delete(node23);

        System.out.println("***TESTING CLEAR FUNCTION, OTHER FUNCTIONS TO SHOW RESPONSE TO AN EMPTY LIST***\n");
        DLL.clear();
        DLL.print();
        DLL.sort();
        DLL.deleteHead();
        DLL.deleteTail();
        DLL.delete(node22);
        System.out.println("Search for a node (after a clear): " + DLL.search(node22) + "\n");

        System.out.println("***TESTING INSERT AND DELETE AFTER A CLEAR***\n");
        DLL.insertHead(node13);
        DLL.print();

        DLL.deleteHead();
        DLL.print();

        DLL.insertTail(node14);
        DLL.print();

        DLL.deleteTail();
        DLL.print();

        System.out.println("*******BEGINNING OF TEST FOR CSLL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");
        CSLL CSLLNoNode = new CSLL();

        CSLLNoNode.insertHead(node1);
        CSLLNoNode.print();

        CSLLNoNode.clear();
        CSLLNoNode.print();

        System.out.println("***TESTING 1 ARGUMENT CONSTRUCTOR***");
        System.out.println("***TESTING INSERTHEAD, INSTERTTAIL, INSERT, SORTED INSERT***\n");

        CSLL CSLL = new CSLL(node);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.insertHead(node1);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.insertHead(node2);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.insertTail(node3);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.insertTail(node4);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.insert(node5, 3);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        System.out.println("***TRYING TO INSERT AT NONEXISTENT POSITION***\n");
        CSLL.insert(node6, 15);

        CSLL.insertHead(node7);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        System.out.println("***TESTING SORT FUNCTION***\n");
        CSLL.sort();
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.sortedInsert(node8);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.sortedInsert(node9);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        System.out.println("***TESTING SEARCH FUNCTION***\n");
        System.out.println("Search for a node (is currently in list): " + CSLL.search(node7) + "\n");
        System.out.println("Search for a node (is currently not in list): " + CSLL.search(node9) + "\n");

        System.out.println("***TESTING DELETEHEAD, DELETETAIL, DELETE***\n");
        CSLL.deleteHead();
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.deleteTail();
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.delete(node3);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        System.out.println("***TRYING TO DELETE NODE THAT IS NOT IN LIST***\n");
        CSLL.delete(node11);

        System.out.println("***TESTING CLEAR FUNCTION, OTHER FUNCTIONS TO SHOW RESPONSE TO AN EMPTY LIST***\n");
        CSLL.clear();
        CSLL.print();
        CSLL.sort();
        CSLL.deleteHead();
        CSLL.deleteTail();
        CSLL.delete(node10);
        System.out.println("Search for a node (after a clear): " + CSLL.search(node10) + "\n");

        System.out.println("***TESTING INSERT AND DELETE AFTER A CLEAR***\n");
        CSLL.insertHead(node1);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.deleteHead();
        CSLL.print();

        CSLL.insertTail(node2);
        CSLL.print();
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CSLL.getTail().getData(),
                CSLL.getTail().getNext().getData()));

        CSLL.deleteTail();
        CSLL.print();

        System.out.println("*******BEGINNING OF TEST FOR CDLL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");
        CDLL CDLLNoNode = new CDLL();

        CDLLNoNode.insertHead(node13);
        CDLLNoNode.print();

        CDLLNoNode.clear();
        CDLLNoNode.print();

        System.out.println("***TESTING 1 ARGUMENT CONSTRUCTOR***");
        System.out.println("***TESTING INSERTHEAD, INSTERTTAIL, INSERT, SORTED INSERT***\n");

        CDLL CDLL = new CDLL(node12);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.insertHead(node13);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.insertHead(node14);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.insertTail(node15);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.insertTail(node16);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.insert(node17, 3);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        System.out.println("***TRYING TO INSERT AT NONEXISTENT POSITION***\n");
        CDLL.insert(node18, 33);

        CDLL.insertHead(node19);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        System.out.println("***TESTING SORT FUNCTION***\n");
        CDLL.sort();
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.sortedInsert(node20);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.sortedInsert(node21);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        System.out.println("***TESTING SEARCH FUNCTION***\n");
        System.out.println("Search for a node (is currently in list): " + CDLL.search(node14) + "\n");
        System.out.println("Search for a node (is currently not in list): " + CDLL.search(node22) + "\n");

        System.out.println("***TESTING DELETEHEAD, DELETETAIL, DELETE***\n");
        CDLL.deleteHead();
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.deleteTail();
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.delete(node17);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        System.out.println("***TRYING TO DELETE NODE THAT IS NOT IN LIST***\n");
        CDLL.delete(node23);

        System.out.println("***TESTING CLEAR FUNCTION, OTHER FUNCTIONS TO SHOW RESPONSE TO AN EMPTY LIST***\n");
        CDLL.clear();
        CDLL.print();
        CDLL.sort();
        CDLL.deleteHead();
        CDLL.deleteTail();
        CDLL.delete(node22);
        System.out.println("Search for a node (after a clear): " + CDLL.search(node22) + "\n");

        System.out.println("***TESTING INSERT AND DELETE AFTER A CLEAR***\n");
        CDLL.insertHead(node13);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.deleteHead();
        CDLL.print();

        CDLL.insertTail(node14);
        CDLL.print();
        System.out.println(String.format("Head Value: %d, Head.Prev Value: %d", CDLL.getHead().getData(),
                CDLL.getHead().getPrev().getData()));
        System.out.println(String.format("Tail Value: %d, Tail.Next Value: %d\n", CDLL.getTail().getData(),
                CDLL.getTail().getNext().getData()));

        CDLL.deleteTail();
        CDLL.print();

        System.out.println("*******BEGINNING OF TEST FOR StackLL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");
        StackLL stackNoNode = new StackLL();

        stackNoNode.push(node1);
        stackNoNode.print();

        stackNoNode.pop();
        stackNoNode.print();

        System.out.println("***TESTING 1 ARGUMENT CONSTRUCTOR***");
        System.out.println("***TESTING PUSH, POP, PEAK, EMPTY***\n");

        StackLL stack = new StackLL(node);
        stack.print();

        stack.push(node1);
        stack.print();

        stack.push(node2);
        stack.print();

        stack.push(node3);
        stack.print();

        stack.pop();
        stack.print();

        stack.push(node4);
        stack.print();

        stack.pop();
        stack.print();

        stack.pop();
        stack.print();

        stack.push(node5);
        stack.print();

        stack.peek();

        System.out.println("Is stack empty? " + stack.empty() + "\n");

        System.out.println("***TESTING SEARCH FUNCTION***\n");
        System.out.println(
                "Search (for value 500 - in stack) returned position : " + stack.search(500) + " in the stack.\n");
        System.out.println("Search (for value -989 - not in stack) returned position : " + stack.search(-989)
                + " in the stack.\n");

        System.out.println("***TESTING CLEAR FUNCTION, OTHER FUNCTIONS TO SHOW RESPONSE TO AN EMPTY STACK***\n");
        stack.clear();
        stack.print();
        stack.peek();
        stack.empty();
        stack.pop();
        System.out.println("Search (for value 500) returned position : " + stack.search(500) + " in the stack.\n");
        System.out.println("Is stack empty? " + stack.empty() + "\n");

        System.out.println("***TESTING PUSH AND POP AFTER A CLEAR***\n");
        stack.push(node6);
        stack.print();

        stack.pop();
        stack.print();

        System.out.println("*******BEGINNING OF TEST FOR QueueLL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");
        QueueLL queueNoNode = new QueueLL();

        queueNoNode.enqueue(node1);
        queueNoNode.print();

        queueNoNode.dequeue();
        queueNoNode.print();

        System.out.println("***TESTING 1 ARGUMENT CONSTRUCTOR***");
        System.out.println("***TESTING ENQUEUE, DEQUEUE, PEAK, EMPTY***\n");

        QueueLL queue = new QueueLL(node);
        queue.print();

        queue.enqueue(node1);
        queue.print();

        queue.enqueue(node2);
        queue.print();

        queue.enqueue(node3);
        queue.print();

        queue.dequeue();
        queue.print();

        queue.enqueue(node4);
        queue.print();

        queue.dequeue();
        queue.print();

        queue.dequeue();
        queue.print();

        queue.enqueue(node5);
        queue.print();

        queue.peek();

        System.out.println("Is queue empty? " + queue.empty() + "\n");

        System.out.println("***TESTING SEARCH FUNCTION***\n");
        System.out.println("Search (for value 6) returned position : " + queue.search(6) + " in the queue.\n");
        System.out.println("Search (for value -292) returned position : " + queue.search(-292) + " in the queue.\n");

        System.out.println("***TESTING CLEAR FUNCTION, OTHER FUNCTIONS TO SHOW RESPONSE TO AN EMPTY STACK***\n");
        queue.clear();
        queue.print();
        queue.peek();
        queue.empty();
        queue.dequeue();
        System.out.println(
                "Search (for value 500 - in queue) returned position : " + queue.search(500) + " in the queue.\n");
        System.out.println("Is queue empty? " + queue.empty() + "\n");

        System.out.println("***TESTING ENQUEUE AND DEQUEUE AFTER A CLEAR***\n");
        queue.enqueue(node6);
        queue.print();

        queue.dequeue();
        queue.print();

        System.out.println("------MODULE 2 TESTS------");
        //testing functions using data values to access nodes
        System.out.println("*******BEGINNING OF TEST FOR BST*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");

        BST treeNoArg = new BST();

        TNode rootNoArg = new TNode();
        rootNoArg.setDataMember(21);

        //testing setRoot function
        treeNoArg.setRoot(rootNoArg);

        // testing insert node(val) function
        // should insert nodes into trees using data values
        treeNoArg.insertNode(12);
        treeNoArg.insertNode(18);
        treeNoArg.insertNode(15);
        treeNoArg.insertNode(25);

        System.out.println("***TESTING INSERT NODE USING DATA VALUES***\n");
        // testing print in-order function
        // should print data values of nodes in the tree in ascending order
        System.out.println("Data In Ascending Order");
        treeNoArg.printInOrder();

        System.out.println();

        // testing print in breadth first function
        // should print data values of nodes in the tree in breadth first order
        System.out.println("Data In Breadth First Order");
        treeNoArg.printBf();

        // testing deleteNode(val) function
        // should delete node from tree given the data value of the node
        treeNoArg.deleteNode(12);
        System.out.println();

        // note, the successful operation of the deleteNode function
        // confirms that the search function also performs successfully
        // print tree to confirm node has been deleted
        System.out.println("***TESTING DELETE NODE USING DATA VALUES***\n");
        System.out.println("Data After Deleting Node ");
        treeNoArg.printBf();

        System.out.println();

        System.out.println("***TESTING INTEGER ARGUMENT (VAL) CONSTRUCTOR***\n");
        //creating new Binary Search Tree object with root set with data value of 5
        // testing Constructor with data value argument
        BST treeValArg = new BST(5);

        // testing insert node(val) function
        // should insert nodes into trees using data values
        treeValArg.insertNode(8);
        treeValArg.insertNode(3);
        treeValArg.insertNode(1);
        treeValArg.insertNode(6);
        treeValArg.insertNode(7);
        treeValArg.insertNode(2);
        treeValArg.insertNode(4);
        treeValArg.insertNode(9);

        System.out.println("***TESTING INSERT NODE USING DATA VALUES***\n");
        // testing print in-order function
        // should print data values of nodes in the tree in ascending order
        System.out.println("Data In Ascending Order");
        treeValArg.printInOrder();

        System.out.println();

        // testing print in breadth first function
        // should print data values of nodes in the tree in breadth first order
        System.out.println("Data In Breadth-First Order");
        treeValArg.printBf();

        // testing deleteNode(val) function
        // should delete node from tree given the data value of the node
        treeValArg.deleteNode(8);
        System.out.println();

        // note, the successful operation of the deleteNode function
        // confirms that the search function also performs successfully
        // print tree to confirm node has been deleted
        System.out.println("***TESTING DELETE NODE USING DATA VALUES***\n");
        System.out.println("Data After Deleting Node ");
        treeValArg.printInOrder();


        System.out.println();


        // testing functions using nodes as arguments to operate on the tree
        System.out.println("***TESTING TNODE OBJECT ARGUMENT CONSTRUCTOR***\n");

        //creating root node with data value of 2
        TNode rootArg = new TNode();
        rootArg.setDataMember(2);

        // creating a Binary Tree object with root node
        // testing Constructor with root argument
        BST treeObjArg = new BST(rootArg);

        // testing setData member functions and insert node function which takes a node as an argument.
        TNode tnode1 = new TNode();
        tnode1.setDataMember(4);
        treeObjArg.insertNode(tnode1);

        TNode tnode2 = new TNode();
        tnode2.setDataMember(3);
        treeObjArg.insertNode(tnode2);

        TNode tnode3 = new TNode();
        tnode3.setDataMember(1);
        treeObjArg.insertNode(tnode3);

        TNode tnode4 = new TNode();
        tnode4.setDataMember(5);
        treeObjArg.insertNode(tnode4);

        TNode tnode5 = new TNode();
        tnode5.setDataMember(7);
        treeObjArg.insertNode(tnode5);


        // testing print in-order function
        // should print data values of nodes in the tree in ascending order
        System.out.println("***TESTING INSERT NODE USING TNODE OBJECTS***\n");
        System.out.println("Data In Ascending Order");
        treeObjArg.printInOrder();

        System.out.println();

        // testing print in breadth first function
        // should print data values of nodes in the tree in breadth first order
        System.out.println("Data In Breadth-First Order");
        treeObjArg.printBf();

        System.out.println();

        System.out.println("***TESTING DELETE NODE USING TNODE OBJECTS***\n");
        System.out.println("Data After Deleting Node ");
        treeObjArg.deleteNode(2);
        treeObjArg.printInOrder();

        System.out.println();

        System.out.println("*******BEGINNING OF TEST FOR AVL*******\n");
        System.out.println("***TESTING NO ARGUMENT CONSTRUCTOR***\n");

        // testing Constructor with no arguments
        AVL treeAVLNoArg = new AVL();

        // testing insert node(val) function
        // should insert nodes into trees using data values
        TNode rootAVLNoArg = new TNode();
        rootAVLNoArg.setDataMember(31);

        //testing setRoot function
        treeAVLNoArg.setRoot(rootAVLNoArg);

        // testing insert node(val) function
        // should insert nodes into trees using data values
        treeAVLNoArg.insertNode(42);
        treeAVLNoArg.insertNode(58);
        treeAVLNoArg.insertNode(17);
        treeAVLNoArg.insertNode(27);
        treeAVLNoArg.insertNode(33);
        treeAVLNoArg.insertNode(46);
        treeAVLNoArg.insertNode(63);

        System.out.println("***TESTING INSERT NODE USING DATA VALUES***\n");
        // testing print in-order function
        // should print data values of nodes in the tree in ascending order
        System.out.println("Data In Ascending Order");
        treeAVLNoArg.printInOrder();

        System.out.println();

        // testing print in breadth first function
        // should print data values of nodes in the tree in breadth first order
        System.out.println("Data In Breadth First Order");
        treeAVLNoArg.printBf();

        // testing deleteNode(val) function
        // should delete node from tree given the data value of the node
        treeAVLNoArg.deleteNode(17);
        System.out.println();

        // note, the successful operation of the deleteNode function
        // confirms that the search function also performs successfully
        // print tree to confirm node has been deleted
        System.out.println("***TESTING DELETE NODE USING DATA VALUES***\n");
        System.out.println("Data After Deleting Node ");
        treeAVLNoArg.printBf();

        System.out.println();



        // testing functions using nodes as arguments to operate on the tree
        System.out.println("***TESTING TNODE OBJECT ARGUMENT CONSTRUCTOR***\n");

         //creating a root node with data value of 2
         TNode root = new TNode();
         root.setDataMember(2);
         //testing Constructor with TNode argument
         AVL treeNodeArg = new AVL(root);
 
         // testing setData member functions and insert node function which takes a node as an argument.
         TNode tnode6 = new TNode();
         tnode6.setDataMember(21);
         treeNodeArg.insertNode(tnode6);
 
         TNode tnode7 = new TNode();
         tnode7.setDataMember(3);
         treeNodeArg.insertNode(tnode7);
 
         TNode tnode8 = new TNode();
         tnode8.setDataMember(19);
         treeNodeArg.insertNode(tnode8);
 
         TNode tnode9 = new TNode();
         tnode9.setDataMember(5);
         treeNodeArg.insertNode(tnode9);
 
         TNode tnode10 = new TNode();
         tnode10.setDataMember(16);
         treeNodeArg.insertNode(tnode10);
 
         TNode tnode11 = new TNode();
         tnode11.setDataMember(7);
         treeNodeArg.insertNode(tnode11);
 
         TNode tnode12 = new TNode();
         tnode12.setDataMember(9);
         treeNodeArg.insertNode(tnode12);
 
         TNode tnode13 = new TNode();
         tnode13.setDataMember(15);
         treeNodeArg.insertNode(tnode13);
 
         TNode tnode14 = new TNode();
         tnode14.setDataMember(18);
         treeNodeArg.insertNode(tnode14);
 
         TNode tnode15 = new TNode();
         tnode15.setDataMember(14);
         treeNodeArg.insertNode(tnode15);
 
         // testing print in-order function
         // should print data values of nodes in the tree in ascending order
         System.out.println("***TESTING INSERT NODE USING TNODE OBJECTS***\n");
         System.out.println("Data In Ascending Order");
         treeNodeArg.printInOrder();
 
         System.out.println();
 
         // testing print in breadth first function
         // should print data values of nodes in the tree in breadth first order
         System.out.println("Data In Breadth-First Order");
         treeNodeArg.printBF();
 
         treeNodeArg.delete(16);
         System.out.println();
         System.out.println("***TESTING DELETE NODE USING TNODE OBJECTS***\n");
         System.out.println("Data After Deleting Node ");
         treeNodeArg.printBF();
 
    }
}
