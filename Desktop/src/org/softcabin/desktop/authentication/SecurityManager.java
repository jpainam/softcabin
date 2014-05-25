package org.softcabin.desktop.authentication;

import org.softcabin.database.DataModel;
import org.softcabin.entities.users.Users;

public class SecurityManager {
    public static boolean login(String username, String password) {
        Users user = DataModel.getUser(username);
        if(user == null){
            return false;
        }else{
            if(password.equals(user.getPassword()))
                return true;
            else
                return false;
        }
      }
}
