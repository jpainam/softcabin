/*
 *
 */
package org.softcabin.entities.student;

import java.util.ArrayList;
import java.util.Date;
import org.softcabin.entities.department.Department;
import org.softcabin.entities.level.Level;

/**
 *
 * @author Ainam Jean-Paul
 * Date of creation : 26 June 2013
 * Provides a description of a student. 
 * Defines a student and sends the information in the database
 */
public class Student {
    /**
     * The matric number which uniquely identifies the student
     */
    protected String matric;
    /**
     * The first name of the student
     */
    private String firstName;
    /**
     * The last name and other name of the student
     */
    private String lastName = new String();
    private String middleName = new String();
    /**
     * The sex of the student. Enumerative type {Male of Female only}
     */
    private String sex;
    /**
     * Date of the birth type is Date
     */
    private Date dateOfBirth;
    /**
     * The email of the Student
     */
    private String email;
    /**
     * The department to which belongs the Student, Store the department ID
     */
    private Department department;
    /* level */
    private Level level;
    private String image = new String();
    /* Constructor utiliser **/
    public Student(String matric, String fname, String lname, Department dpt, String sex){
        this.matric = matric;
        firstName = fname;
        lastName = lname;
        this.sex = sex;
        this.department = dpt;
    }
    public Student(String matric, String fname, String mname, String lname, Date dob, String sex, 
             String email, Department department, Level level, String img){
        this.matric = matric;
        this.firstName = fname;
        this.lastName = lname;
        this.middleName = mname;
        this.sex = sex;
        this.dateOfBirth = dob;
        this.email = email;
        this.department = department;
        this.level = level;
        this.image = img;
    }
    /**
     * Default constructor
     */
    public Student(){
        this.sex = new String();
        this.dateOfBirth = new Date();
        this.email = new String();
        
    }
    /**
     * Definitions of setter and getter for the private
     * and protected field. For encapsulation purpose
     */
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public void setFirstName(String fname){
        firstName = fname;
    }
    public void setLastName(String lname){
        firstName = lname;
    }
    public void setMiddleName(String oname){
        firstName = oname;
    }
    
    public String getMatric(){
        return this.matric;
    }
    public String getSex(){
        return this.sex;
    }
    public Department getDepartment(){
        return this.department;
    }
    public Date getDateOfBirth(){
        return this.dateOfBirth;
    }
    public String getEmail(){
        return this.email;
    }
    public Level getLevel(){
        return this.level;
    }
    private String category;
    private String title;
    private Integer number;
    public String getCategory(){
        return category;
    }
    public String getTitle(){
        return title;
    }
    public Integer getNumber(){
        return number;
    }
    public void setTitle(String s){
        title = s;
    }
    public void setCategory(String s){
        category = s;
    }
    public void setNumber(Integer n){
        number = n;
    }
}