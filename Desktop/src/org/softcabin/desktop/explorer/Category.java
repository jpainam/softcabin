/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

/**
 *
 * @author jpainam
 */
public class Category {
    private String name;
    public Category(String n){
        name = n;
    }
    public Category(){}
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
}
