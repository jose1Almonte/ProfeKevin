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
public class CircularLinkedList<T> {
    private Node<T> tail;
    int Size;


    /**
     * Constructor for initially empty list
     */
    public CircularLinkedList() {
        tail = null;
        Size = 0;
    }

    /**
     * Constructor for list initially with one node
     * @param n
     */
    public CircularLinkedList(Node<T> n) {
        this.tail = n;
        tail.setNext(n);
    }

    
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    /**
     * Checks whether list is empty or not
     * @return 
     */
    private boolean isEmpty() {
        return getTail()== null;
    }
    
    /**
     *  Get the current size of the list
     * @return 
     */
    
    /**
     * Add datum to the first position of the list
     * @param datum Datum to be added
     */
    public void addFirst(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            tail = n;
            tail.setNext(tail);
        } else {
            n.setNext(tail);
            while(true){
                if(tail.getNext() == n.getNext()){
                    tail.setNext(n);
                    tail = n;
                    break;
                }
                tail = tail.getNext();
            }
        }
        Size++;
    }
    
    /**
     * Add datum to the last position of the list
     * @param datum Datum to be added
     */
    public void addLast(T datum) {
        Node<T> n = new Node(datum);
        n.setNext(tail);
        if (isEmpty()) {
            tail.setNext(n);
        } else {
            while(true){
                if(tail.getNext() == n.getNext()){
                    tail.setNext(n);
                    tail = n.getNext();
                    break;
                }
                tail = tail.getNext();
            }
        }
        Size++;
    }
    
    /**
     * Add datum to the specified position
     * @param datum Datum to be added
     * @param i Position to be added in
     */
    public void add(T datum, int i) {
        if (isEmpty() || i == 0) {
            addFirst(datum);
        } else if (i >= Size) {
            addLast(datum);
        } else if (i < 0) {
            add(datum, Size + i);
        }else {
            Node<T> n = new Node(datum);
            int counter = 0;
            while(true){
                if(counter + 1 == i){
                    n.setNext(tail.getNext());
                    tail.setNext(n);
                }
                if(counter == Size - 1){
                    break;
                }
                counter++;
                tail = tail.getNext();
            }
        }
    }

    /**
     * Deletes first element of the list
     * @return The data of the first element
     */
    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> mov = tail;
        Node<T> temp = tail;
        while(true){
            if(Size == 1){
                temp = tail;
                tail = null;
                break;
            }else if(mov.getNext() == tail){
                mov.setNext(tail.getNext());
                tail.setNext(null);
                temp = tail;
                tail = mov.getNext();
            }
            
            mov = mov.getNext();            
        }
        Size--;
        return temp.getData();
    }
    
    /**
     * Deletes last element of the list
     * @return The data of the last element
     */    
    //POR ARREGLAR (ARREGLADO)    
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> pre = this.tail;
        while(pre.getNext().getNext() != tail) {
            pre = pre.getNext();
        }
        Node<T> temp = pre.getNext();
        pre.setNext(tail);
        temp.setNext(null);
        Size--;
        return temp.getData();        
    }
    
    /**
     * Deletes the element at the specified position
     * @param i The position to be deleted
     * @return The data of the deleted element
     */
    //POR ARREGLAR (ARREGLADO)
    public T delete(int i) {
        if (isEmpty()) {
            return null;
        } else if (i == 0) {
            Size--;
            return deleteFirst();
        } else if (i >= Size - 1) {
            Size--;
            return deleteLast();
        } else if (i < 0)  {
            Size--;
            return delete(Size + i);
        } else {
            Size--;
            Node<T> aux = this.tail;
            int count = 0;
            while(count < i-1) {
                aux = aux.getNext();
                count++;
            }
            Node<T> del = aux.getNext();
            aux.setNext(del.getNext());
            del.setNext(null);
            return del.getData();
        }
    }
    
    /**
     * Prints the list in a pretty format
     */
    //POR ARREGLAR (ARREGLADO)
    public void print() {
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node aux = this.tail;
            int i = 0;
            while (aux.getNext() != tail) {
                System.out.print(aux.getData() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            }
            System.out.println("");
        }
    }
    
    //POR ARREGLAR
    public void reverse() {
        Node current = tail.getNext();
        Node prev = tail;
        Node next;
        do{
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }while(current != tail.getNext());
        
        
    }
    
//    public void completeList() {
//        Node current = this.head;
//        int index = 0;
//        // 7, 8, 10, 13
//        while (current != null) {
//            if (current.getData() + 1 != current.getNext().getData()) {
//                this.add(current.getData() + 1, index+1);
//            }
//            current = current.getNext();
//            index++;
//        }
//    }
//    
    
    //POR ARREGLAR    
//    public void completeList() {
//        Node current = this.head;
//        int index = 1;
//        // 7, 8, 10, 13
//        while (current.getNext() != null) {
//            if (Node.getValueAsInteger(current) + 1 != Node.getValueAsInteger(current.getNext())) {
//                Integer a = Node.getValueAsInteger(current) + 1;
//                this.add((T) a, index);
//            }
//            this.print();
//            current = current.getNext();
//            index++;
//        }
//    }
//    

    /**
     * @return the tail
     */
    public Node<T> getTail() {
        return tail;
    }
}

