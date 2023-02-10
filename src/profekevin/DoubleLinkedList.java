/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profekevin;

/**
 *
 * @author greg
 * @param <T>
 */
public class DoubleLinkedList<T> {
    private NodeDouble<T> Pfirst;
    private NodeDouble<T> Plast;
    private int Size;
    
    public DoubleLinkedList(){
        Pfirst = Plast = null;
        Size = 0;
    }

    /**
     * @return the Pfirst
     */
    public NodeDouble<T> getPfirst() {
        return Pfirst;
    }

    /**
     * @param Pfirst the Pfirst to set
     */
    public void setPfirst(NodeDouble<T> Pfirst) {
        this.Pfirst = Pfirst;
    }

    /**
     * @return the Plast
     */
    public NodeDouble<T> getPlast() {
        return Plast;
    }

    /**
     * @param Plast the Plast to set
     */
    public void setPlast(NodeDouble<T> Plast) {
        this.Plast = Plast;
    }

    /**
     * @return the Size
     */
    public int getSize() {
        return Size;
    }

    /**
     * @param Size the Size to set
     */
    public void setSize(int Size) {
        this.Size = Size;
    }
    
    public boolean isEmpty(){
        return Pfirst == null;
    }
    
    public void addFirst(NodeDouble<T> newnode){
        NodeDouble<T> aux = newnode;
        if(!isEmpty()){
            aux.setPnext(Pfirst);
            Pfirst.setPprev(aux);
            Pfirst = aux;
        }else{
            Pfirst = Plast = aux;
        }
        Size++;
    }
    
    public void addLast(T newnode){
        NodeDouble<T> aux = new NodeDouble(newnode);
        if(!isEmpty()){            
            Plast.setPnext(aux);
            aux.setPprev(Plast);
            Plast = Plast.getPnext(); 
        }else{
            Pfirst = Plast = aux;
        }
        Size++;
    }
    
    public void addSpecificPosition(int position, T newnode){
        NodeDouble<T> aux = new NodeDouble(newnode);
        if(position == 0 || isEmpty()){
            addFirst(aux);
        }else if(position >= Size - 1){
            addLast(newnode);
        }else if (position < 0){
            addSpecificPosition(Size + position, newnode);
        }else{
            int counter = 1;
            NodeDouble<T> aux2 = Pfirst.getPnext();
            while(true){                
                if(counter == position){
                    aux2.getPnext().setPprev(aux);
                    aux2.getPprev().setPnext(aux);
                    aux2.setPnext(null);
                    aux2.setPprev(null);
                    break;
                }
                aux2 = aux2.getPnext();
                counter++;
            }
        }
    }
    
    public void deleteFirst(){
        if(!isEmpty()){
            Pfirst = Pfirst.getPnext();
            Pfirst.getPprev().setPnext(null);
            Pfirst.setPprev(null);
        }
    }
    
    public void deleteLast(){
        if(!isEmpty()){
            Plast = Plast.getPprev();
            Plast.getPnext().setPprev(null);
            Plast.setPnext(null);
        }
    }
    
    public void deleteSelectedPosition(int position){
        if(!isEmpty() || position == 0){
            deleteFirst();
        }else if(position >= Size -1){
            deleteLast();
        }else if(position < 0){
            deleteSelectedPosition(Size + position);
        }else{
            int counter = 0;
            NodeDouble<T> aux = Pfirst.getPnext();
            while(true){
                counter++;
                if (counter == position){
                    aux.getPprev().setPnext(aux.getPnext());
                    aux.getPnext().setPprev(aux.getPprev());
                    aux.setPnext(null);
                    aux.setPprev(null);
                    break;
                }
                aux = aux.getPnext();
            }
        }
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            NodeDouble<T> aux = Pfirst;
            int i = 0;
            while (aux != null) {
                System.out.print(aux.getData() + "\n");
                aux = aux.getPnext();
                i++;
            }
            System.out.println("");
        }
    }
}
