/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;
import org.softcabin.entities.student.Student;
import org.softcabin.entities.department.Department;
import org.softcabin.entities.level.Level;
import org.softcabin.entities.school.School;
import org.softcabin.entities.users.Users;
/**
 *
 * @author jpainam
 */
public class DataModel {
    private static ResultSetMetaData metaData;
    /* Connection to the database */
   private static Connection connection = null;
    public DataModel(){}
    public static Connection getConnection(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null || connection.isClosed()){
                Properties props = new Properties();
                props.put("user", "root");
                props.put("password", "");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcabin", props);
            }
            return connection;
         }catch(SQLException | ClassNotFoundException ex){
               Exceptions.printStackTrace(ex);
         }
         return connection;
    }
    public static ResultSetMetaData getMetaData(){
       return metaData;
      
    }
    public static List<Student> getStudents(){
        List<Student> student = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student ORDER BY MATRIC");
            metaData = rs.getMetaData();
            while(rs.next()){
                /* 
                 * Student(String matric, String fname, String mname, String lname, Date dob, String sex, 
                    String email, Department department, Level level, String img){
                */
                Student stud = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getDate(5), rs.getString(6), rs.getString(7), getDepartment(rs.getString(8)), 
                        getLevel(rs.getString(9)), rs.getString(10));
                
                student.add(stud);
            }
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return student;
    }
    /**
     * @param : matric  the matric of the student
     * @return return the student information
     */
    public static Student getStudent(String matric){
        Student stud = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM student WHERE MATRIC = ?");
            stmt.setString(1, matric);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                stud = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getDate(5), rs.getString(6), rs.getString(7), getDepartment(rs.getString(8)), 
                        getLevel(rs.getString(9)), rs.getString(10));
            }
            rs.close();
            stmt.close();
            return stud;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return stud;
    }
    public static List<Student> searchStudent(String keyword){
        List<Student> student = new ArrayList<>();
        String query = "SELECT MATRIC FROM student e "
                + "WHERE MATRIC LIKE ? OR FNAME LIKE ? OR MNAME LIKE ? "
                + "OR DOB LIKE ? OR EMAIL LIKE ? OR SEX LIKE ? OR "
                + "(SELECT DESCRIPTION FROM department d WHERE d.IDDEPARTMENT = e.DEPARTMENT) LIKE ? OR "
                + "(SELECT DESCRIPTION FROM level l WHERE l.IDLEVEL = e.LEVEL) LIKE ? ";
        try{
            //Query query = session.CreateQuery();
            PreparedStatement stmt = getConnection().prepareStatement(query);
            /* remplir les parametre */
            for(int i = 1; i <= 8; i++){
                stmt.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student st = getStudent(rs.getString(1));
                System.out.print("\n Matric: " + st.getFirstName() + "\t" + st.getLastName()+ "\n");
                student.add(st);
            }
            rs.close();
            stmt.close();
            return student;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return student;
    }
    public static void updateStudent(String query){
    
    }
    public static void deleteStudent(String id){
    
    }
    public static boolean insertStudent(Student stud){
        /*final ProgressHandle handle = ProgressHandleFactory.createHandle("Inserting student");
        Runnable work = new Runnable() {
            @Override
            public void run() {
                handle.start();
            }
        };
        /* Tester si le thread run deja avant de lancer new thread */
        
        /*new Thread(work).start();
        NotifyDescriptor d = new NotifyDescriptor.Confirmation(
                "The module Database is under devlopment, Finish the task",
                "Database Insertion",
                NotifyDescriptor.YES_NO_OPTION);
        if(DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.YES_OPTION){
            try {
                Thread.sleep(0);
                handle.finish();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
        }else
            try {
            Thread.sleep(0);
            handle.finish();
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
        return true;*/
        return true;
        
    }
    /*******
     * Department
     */
    public static List<Department> getDepartments(){
        List<Department> depart = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM department ORDER BY IDDEPARTMENT");
            while(rs.next()){
                School sh = getSchool(rs.getString("SCHOOL"));
                depart.add(new Department(rs.getString("IDDEPARTMENT"), rs.getString("DESCRIPTION"), sh));
            }
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return depart;
    }
    public static Department getDepartment(String id){
        Department depart = null;
        try{
            String query = "SELECT * FROM department WHERE IDDEPARTMENT = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                School sh = getSchool(rs.getString("SCHOOL"));
                depart = new Department(rs.getString("IDDEPARTMENT"), rs.getString("DESCRIPTION"), sh);
            }
            rs.close();
            stmt.close();
            return depart;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return depart;
    }
    /***********
     * School
     */
    public static School getSchool(String id){
        School sh = null;
        try{
            String query = "SELECT * FROM school WHERE IDSCHOOL = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                sh = new School(rs.getString(1), rs.getString(2));
            }
            rs.close();
            stmt.close();
            return sh;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return sh;
    }
    /**
     * Level
     */
    public static Level getLevel(String id){
        Level level = null;
        try{
            String query = "SELECT * FROM level WHERE IDLEVEL = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                level = new Level(rs.getString(1), rs.getString(2));
            }
            rs.close();
            stmt.close();
            return level;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return level;
    }
    public static List<Level> getLevels(){
        List<Level> list = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM level ORDER BY IDLEVEL");
            while(rs.next()){
                list.add(new Level(rs.getString(1), rs.getString(2)));
            }
            rs.close();
            stmt.close();
            return list;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return list;
    }
    public static void close() throws SQLException{
        connection.close();
    }
    /*public static void main(String args[]){
        List<Student> list = DataModel.getStudents();
        for(Student st : list){
            System.out.println(st.getMatric() + "\n");
        }
    }*/
    /**
     * Users Management
     */
    public static List<Users> getUsers(){
        List<Users> users = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY USERNAME");
            while(rs.next()){
                users.add(new Users(rs.getString(1), rs.getString(2)));
            }
            rs.close();
            stmt.close();
            return users;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return users;
    }
    public static Users getUser(String username){
        Users user = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM users WHERE USERNAME = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user = new Users(rs.getString(1), rs.getString(2));
            }
            rs.close();
            stmt.close();
            return user;
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
        return user;
    }
}
