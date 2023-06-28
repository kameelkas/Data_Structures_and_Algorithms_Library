package myLib.dataStructures.nodes;

public class DNode {
    private int data;
    private DNode next;
    private DNode prev;

    /**DNode (int data) - constructor. sets data member value
     * @param data
     */
    public DNode (int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**getData() - returns data member value
     * @return
     */
    public int getData(){
        return this.data;
    }

    /**setData(int data) - sets data member value
     * @param data
     */
    public void setData(int data){
        this.data = data;
    }

    /**getNext() - returns the next node in the list
     * @return
     */
    public DNode getNext(){
        return this.next;
    }

    /**getPrev() - returns the previous node in the list
     * @return
     */
    public DNode getPrev(){
        return this.prev;
    }

    /**setNext(DNode next) - sets the next node in the list
     * @param next
     */
    public void setNext(DNode next){
        this.next = next;
    }

    /**setPrev(DNode prev) - sets the previous node in the list
     * @param prev
     */
    public void setPrev(DNode prev){
        this.prev = prev;
    }
}
