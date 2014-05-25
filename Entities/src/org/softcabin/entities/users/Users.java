/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.entities.users;

import sun.security.util.Password;

/**
 *
 * @author jpainam
 */
public class Users {
    private String username;
    private String password;
    public Users(){}
    public Users(String user, String pwd){
        this.username = user;
        this.password = pwd;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String u){
        this.username = u;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String s){
        this.password = s;
    }
}
