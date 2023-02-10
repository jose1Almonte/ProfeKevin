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
public class NodeDouble<T> {
    private T Data;
    private NodeDouble<T> Pnext;
    private NodeDouble<T> Pprev;
    
    
    public NodeDouble(T datum){
        Data = datum;
        Pnext = null;
        Pprev = null;
    }
    /**
     * @return the Data
     */
    public T getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(T Data) {
        this.Data = Data;
    }

    /**
     * @return the Pnext
     */
    public NodeDouble<T> getPnext() {
        return Pnext;
    }

    /**
     * @param Pnext the Pnext to set
     */
    public void setPnext(NodeDouble<T> Pnext) {
        this.Pnext = Pnext;
    }

    /**
     * @return the Pprev
     */
    public NodeDouble<T> getPprev() {
        return Pprev;
    }

    /**
     * @param Pprev the Pprev to set
     */
    public void setPprev(NodeDouble<T> Pprev) {
        this.Pprev = Pprev;
    }
    
}
