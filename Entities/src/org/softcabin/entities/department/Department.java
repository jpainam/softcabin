/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.entities.department;

import org.softcabin.entities.school.School;

/**
 *
 * @author jpainam
 */
public class Department {
    private String iddepartment;
    private String description;
    private School school;
    public Department(String id, String des, School sh){
        this.iddepartment = id;
        this.description = des;
        this.school = sh;
    }
    @Override
    public String toString() {
        return this.description;
    }
       public String getIddepartment() {
        return iddepartment;
    }

    public String getDescription() {
        return description;
    }

    public School getSchool() {
        return school;
    }

    public void setIddepartment(String iddepartment) {
        this.iddepartment = iddepartment;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
}
