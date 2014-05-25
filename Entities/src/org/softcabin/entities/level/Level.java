/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.entities.level;

/**
 *
 * @author jpainam
 */
public class Level {
    private String idlevel;
    private String description;
    public Level(String id, String des){
        this.idlevel = id;
        this.description = des;
    }

    @Override
    public String toString() {
        return description;
    }
    public String getDescription(){
        return this.description;
    }
    
    
}
