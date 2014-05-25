/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

import java.util.ArrayList;
import java.util.List;
import org.softcabin.desktop.explorer.Category;
import org.openide.nodes.Index;
import org.openide.nodes.Node;
import org.softcabin.entities.student.Student;

/**
 *
 * @author jpainam
 */
class StudentChildren extends Index.ArrayChildren{
    private Category category;
    private String[][] items = new String[][]{
        {"0", "Student", "Student 1"},
        {"1", "Student", "Student 2"},
        {"2", "Department", "Department 1"},
        {"4", "Department", "Department 2"},
        {"5", "School", "School 1"},
        {"6", "School", "School 2"}
    };
    public StudentChildren(Category cat) {
        category = cat;
    }

    @Override
    protected List<Node> initCollection() {
        ArrayList children = new ArrayList(items.length);
        for(int i = 0; i < items.length; i++){
            if(category.getName().equals(items[i][1])){
                Student stud = new Student();
                stud.setNumber(new Integer(items[i][0]));
                stud.setCategory(items[i][1]);
                stud.setTitle(items[i][2]);
                children.add(new StudentNode(stud));
            }
        }
        return children;
    }
    
}
