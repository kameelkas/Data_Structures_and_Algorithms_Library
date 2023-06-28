package myLib.dataStructures.nodes;

public class TNode {

    private int dataMember;

    private TNode left;

    private TNode right;

    private TNode parent;

    private int balance;

    public TNode(){
        this.dataMember = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R){
        this.dataMember = data;
        this.balance = balance;
        this.left = L;
        this.right = R;
        this.parent = P;
    }


    public void print(){
        System.out.println("Data: " + toString(this.dataMember));
    }

    public String toString(int dataMember){
        return Integer.toString(this.dataMember);
    }

    public int getDataMember() {
        return dataMember;
    }

    public void setDataMember(int dataMember) {
        this.dataMember = dataMember;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

