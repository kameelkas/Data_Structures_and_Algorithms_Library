package myLib.dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import myLib.dataStructures.nodes.TNode;

public class AVL extends BST {

    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode();
        root.setDataMember(val);
    }

    public AVL(TNode node) {
        this.root = node;
        balanceTree();
    }

    private void balanceTree() {
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TNode node = queue.poll();

            node.setBalance(getBalanceFactor(node));
            if (node.getBalance() > 1) {
                if (getBalanceFactor(node.getLeft()) >= 0) {
                    node = rightRotate(node);
                } else {
                    node.setLeft(leftRotate(node.getLeft()));
                    node = rightRotate(node);
                }
            } else if (node.getBalance() < -1) {
                if (getBalanceFactor(node.getRight()) <= 0) {
                    node = leftRotate(node);
                } else {
                    node.setRight(rightRotate(node.getRight()));
                    node = leftRotate(node);
                }
            }

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        Queue<TNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TNode currNode = nodeQueue.poll();
                if (currNode.getLeft() != null) {
                    nodeQueue.offer(currNode.getLeft());
                }
                if (currNode.getRight() != null) {
                    nodeQueue.offer(currNode.getRight());
                }
            }
            height++;
        }

        return height - 1;
    }

    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.getLeft()) - getHeight(node.getRight());
        }
    }

    private TNode rightRotate(TNode nodeToRotate) {
        TNode x = nodeToRotate.getLeft();
        TNode y = x.getRight();

        x.setRight(nodeToRotate);
        nodeToRotate.setLeft(y);

        if (y != null) {
            y.setParent(nodeToRotate);
        }
        if (nodeToRotate.getParent() != null) {
            if (nodeToRotate.getParent().getRight() == nodeToRotate) {
                nodeToRotate.getParent().setRight(x);
            } else if (nodeToRotate.getParent().getLeft() == nodeToRotate) {
                nodeToRotate.getParent().setLeft(x);
            }
        }
        x.setParent(nodeToRotate.getParent());
        nodeToRotate.setParent(x);

        return x;
    }

    private TNode leftRotate(TNode nodeToRotate) {
        TNode x = nodeToRotate.getRight();
        TNode y = x.getLeft();

        x.setRight(nodeToRotate);
        nodeToRotate.setRight(y);

        if (y != null) {
            y.setParent(nodeToRotate);
        }
        if (nodeToRotate.getParent() != null) {
            if (nodeToRotate.getParent().getRight() == nodeToRotate) {
                nodeToRotate.getParent().setRight(x);
            } else if (nodeToRotate.getParent().getLeft() == nodeToRotate) {
                nodeToRotate.getParent().setLeft(x);
            }
        }
        x.setParent(nodeToRotate.getParent());
        nodeToRotate.setParent(x);

        return x;

    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode node) {
        this.root = node;

        if (root.getLeft() != null && root.getRight() != null) {
            balanceTree();
        }

    }

    public void insertNode(int val) {
        super.insertNode(val);
        balanceTree();
    }

    public void insertNode(TNode node) {
        super.insertNode(node);
        balanceTree();
    }

    public void delete(int val) {
        super.deleteNode(val);
        balanceTree();
    }

    public TNode search(int val) {
        return super.searchTree(val);
    }

    public void printInOrder() {
        super.printInOrder();
    }

    public void printBF() {
        super.printBf();
    }
}
