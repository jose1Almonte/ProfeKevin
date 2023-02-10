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
public class PersonalIdentification {
    private String name;
    private int age;
    private long id;
    private String favcolor;
    
    public PersonalIdentification(){
    }
    public PersonalIdentification(String name, int age, long id, String favcolor){
        this.name = name;
        this.age = age;
        this.id = id;
        this.favcolor = favcolor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the favcolor
     */
    public String getFavcolor() {
        return favcolor;
    }

    /**
     * @param favcolor the favcolor to set
     */
    public void setFavcolor(String favcolor) {
        this.favcolor = favcolor;
    }    
    
    @Override
    public String toString(){
        return this.name + ", " + this.age + ", " + this.id + ", " + this.favcolor;
    }
}
