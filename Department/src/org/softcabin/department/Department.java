/*
 *
 */
package org.softcabin.department;

/**
 *
 * @author Ainam Jean-Paul
 * Date of creation : 28 June 2013
 * Represent a department in memory
 */
public class Department {
    /**
     * The unique identifier of the department
     */
    private String identifier;
    /**
     * The label of the department
     */
    private String name;
    /**
     * Getters and setters
     */
    public String getName(){
        return name;
    }
    public String getIdentifier(){
        return identifier;
    }
    public void setName(String n){
        name = n;
    }
    public void setIdentifier(String i){
        identifier = i;
    }
}
