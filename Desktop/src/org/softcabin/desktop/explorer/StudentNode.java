/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;
import org.softcabin.entities.student.Student;

/**
 *
 * @author jpainam
 */
class StudentNode extends AbstractNode{
    private Student student;
    public StudentNode(Student stud) {
        super(Children.LEAF, Lookups.fixed(new Object[] {stud}));
        this.student = student;
        setDisplayName(stud.getTitle());
        setIconBaseWithExtension("");
    }
    
}
