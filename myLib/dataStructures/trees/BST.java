package myLib.dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import myLib.dataStructures.nodes.TNode;

public class BST {

    private TNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode();
        root.setDataMember(val);
    }

    public BST(TNode node) {
        this.root = node;
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    /**
     * @param val
     * @description creates a new node with data val to be inserted into the tree
     */
    public void insertNode(int val) {
        // create new node
        TNode newNode = new TNode();
        // set the data of new node to be val argument
        newNode.setDataMember(val);
        // if root is null set root to be new node with the argument value
        if (root == null) {
            this.root = newNode;
        } else {
            TNode currentNode = root;
            // traverse the tree to find the appropriate position to insert the newNode
            while (true) {
                // make the currentNode node the parent node to insert new node
                newNode.setParent(currentNode);
                // if the value of the new node is less than the currentNode node's data set
                // node to be on the left
                if (val < currentNode.getDataMember()) {
                    // if currentNode getLeft is null insert new node to the left
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                }
                // else set node to be on the right
                else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        return;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    /**
     * @param node
     * @description inserts the node passed as argument into the tree
     */
    public void insertNode(TNode node) {
        // if root is null, set the root node to be the new node
        if (root == null) {
            this.root = node;
        } else {
            TNode currentNode = root;
            // traverse the tree to find the appropriate position the newNode
            while (true) {
                // make the currentNode node the parent node to insert the new node
                node.setParent(currentNode);
                // if the data of the new node is less than the currentNode node's data set node
                // to be on the left
                if (node.getDataMember() < currentNode.getDataMember()) {
                    // if currentNode getLeft is null insert node to the left
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(node);
                        return;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                }
                // else set node to be on the left
                else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(node);
                        return;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }

            }
        }
    }

    /**
     * @param val
     * @description finds the node with val as data and deletes it, if not found
     *              prints
     *              a statement that the value is not in the tree
     */
    public void deleteNode(int val) {
        TNode nodeToDel;
        TNode parentNode;

        // if searchTree for value is not null
        if (searchTree(val) != null) {
            nodeToDel = searchTree(val);
            parentNode = nodeToDel.getParent();
            // CASE I: Node to be deleted has 0 children
            if (nodeToDel.getLeft() == null && nodeToDel.getRight() == null) {
                // if it is root
                if (nodeToDel == this.root) {
                    this.root = null;
                }
                // if node is left child
                else if (nodeToDel == parentNode.getLeft()) {
                    parentNode.setLeft(null);
                }
                // if node is right child
                else if (nodeToDel == parentNode.getRight()) {
                    parentNode.setRight(null);
                }
            }

            // CASE II: Node to be deleted has 1 child
            // PART A : Right Child Only
            else if (nodeToDel.getLeft() == null) {
                // if it is root
                if (nodeToDel == this.root) {
                    this.root = nodeToDel.getRight();
                }
                // if node to delete is left child
                else if (nodeToDel == parentNode.getLeft()) {
                    parentNode.setLeft(nodeToDel.getRight());
                }
                // if node to delete is right child
                else if (nodeToDel == parentNode.getRight()) {
                    parentNode.setRight(nodeToDel.getRight());
                }
            }
            // PART B : Left Child Only
            else if (nodeToDel.getRight() == null) {
                // if it is root
                if (nodeToDel == this.root) {
                    this.root = nodeToDel.getLeft();
                }
                // if node to delete is left child
                else if (nodeToDel == parentNode.getLeft()) {
                    parentNode.setLeft(nodeToDel.getLeft());
                }
                // if node to delete is right child
                else if (nodeToDel == parentNode.getRight()) {
                    parentNode.setRight(parentNode.getLeft());
                }
            }

            // CASE III: Node to be deleted has 2 children
            else if (nodeToDel.getRight() != null && nodeToDel.getLeft() != null) {
                // Find the inorder successor of that node
                TNode successor = nodeToDel.getRight();
                TNode succParent = nodeToDel;
                while (successor.getLeft() != null) {
                    succParent = successor;
                    successor = successor.getLeft();
                }
                // replace the node with the successor node
                nodeToDel.setDataMember(successor.getDataMember());

                // remove the successor from its original position
                if (succParent.getLeft() == successor) {
                    succParent.setLeft(successor.getRight());
                } else {
                    succParent.setRight(successor.getRight());
                }
            }
        }
        // if searchTree is null , print message
        else {
            System.out.println("Value Is Not A Member Of This Tree");
        }
    }

    /**
     * @param val
     * @return
     */
    public TNode searchTree(int val) {
        // start at the root node
        TNode currentNode = root;
        // find the Node with data == val
        // traverse through tree till you find node with data == val
        while (currentNode.getDataMember() != val) {
            if (val < currentNode.getDataMember()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public void printInOrder() {
        /**
         * prints the content data of the tree in ascending order
         */

        Stack<TNode> newStack = new Stack<>();
        TNode currentNode = root;

        while (currentNode != null || !newStack.empty()) {
            if (currentNode != null) {
                newStack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                currentNode = newStack.pop();
                currentNode.print();
                currentNode = currentNode.getRight();
            }
        }
    }

    public void printBf() {
        /**
         * prints the content of the tree in Breadth-First order, each level of the
         * tree will be printed on a separate line
         */

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TNode currentNode = queue.poll();
            currentNode.print();

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

    }
   
}
