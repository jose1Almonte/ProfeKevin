/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profekevin;

import javax.swing.JOptionPane;

/**
 *
 * @author greg
 */
public class Profekevin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        DoubleLinkedList<PersonalIdentification> mydoublelist = new DoubleLinkedList<>();
        
        while(true){
            PersonalIdentification ObjectIdentification = new PersonalIdentification();

            ObjectIdentification.setName(JOptionPane.showInputDialog("please, a name"));
            ObjectIdentification.setAge(Integer.parseInt(JOptionPane.showInputDialog("please, an age")));
            ObjectIdentification.setId(Long.parseLong(JOptionPane.showInputDialog("please, an ID")));
            ObjectIdentification.setFavcolor(JOptionPane.showInputDialog("please, a Fav color"));

            mydoublelist.addSpecificPosition(Integer.parseInt(JOptionPane.showInputDialog("Position?")), ObjectIdentification);

            String bool = JOptionPane.showInputDialog("Finish? (y / n)");

            if ("y".equalsIgnoreCase(bool)) break;        
        }
        mydoublelist.print();
    }
    
}
