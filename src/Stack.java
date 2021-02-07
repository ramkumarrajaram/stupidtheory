public class Stack {

    private int size;
    private Node topNode;

    private class Node {
        int data;
        Node next;


    }

    public void push(int data) {

        if (this.size >= 10) {
            throw new Error("Stack Over flow. Size greater than 10");
        }
        Node newNode = new Node();
        if (this.topNode == null) {
            newNode.data = data;
            newNode.next = null;
            this.topNode = newNode;
            this.size = 1;
            return;
        }

        newNode.data = data;
        newNode.next = this.topNode;
        this.topNode = newNode;
        this.size++;
    }

    public int peek() {
        return this.topNode.data;
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Node poppedNode = this.topNode;
        this.topNode = poppedNode.next;
        this.size--;
        return poppedNode.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
