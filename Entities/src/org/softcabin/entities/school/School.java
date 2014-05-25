/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.entities.school;

/**
 *
 * @author jpainam
 */
public class School {
    private String idschool;
    private String description;
    
    public School(String id, String des){
        this.idschool = id;
        this.description = des;
    }

    @Override
    public String toString() {
        return description;
    }
    
}
