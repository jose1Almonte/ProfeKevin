/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profekevin;

/**
 *
 * @author greg
 */
public class Queue<T>{
    private Node<T> head; // first / front
    private Node<T> tail; // last / rear
    private int size;
    
    /**
     *
     */
    public Queue() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    /**
     *
     * @param datum
     */
    public Queue(T datum) {
        Node<T> n = new Node(datum);
        this.head = this.tail = n;
        this.size = 1;
    }
    
    private boolean isEmpty() {
        return this.head == null;
    }
    
    /**
     * Puts a new element in the queue
     * @param datum The data to be added to the queue
     * @complexity O(1)
     */
    public void enqueue(T datum) {
        Node<T> n = new Node(datum);
        this.size++;
        if (isEmpty()) {
            this.head = this.tail = n;
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
    }
    
    /**
     * Deletes the first element in the queue and returns its data
     * @return The data contained in the first element of the Queue
     * @complexity O(1)
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        Node<T> temp = this.head;
        this.head = temp.getNext();
        temp.setNext(null);
        this.size--;
        return temp.getData();
    }
    
    /**
     * Gets the data contained in the first element in the Queue
     * @return the data contained in the first element of the Queue
     * @complexity O(1)
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        
        Node<T> temp = this.tail;
        return temp.getData();
    }

    /**
     * Returns the Head of the Queue
     * @return
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns the tail of the Queue
     * @return Node
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the Queue
     * @return
     */
    public int getSize() {
        return size;
    }
}
