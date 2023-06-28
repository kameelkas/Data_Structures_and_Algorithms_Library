
package myLib.dataStructures.nodes;

public class SNode {
    private int data;
    private SNode next;

    /**SNode(int data) - constructor for SNode. sets data member value
     * @param data
     */
    public SNode (int data){
        this.data = data;
        this.next = null;
    }

    /**getData - returns data member value
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
    public SNode getNext(){
        return this.next;
    }

    /**setNext(SNode next) - sets the next node in the list
     * @param next
     */
    public void setNext(SNode next){
        this.next = next;
    }
}
