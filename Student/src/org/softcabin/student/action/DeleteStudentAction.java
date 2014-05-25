/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.student.action;

import java.awt.Component;
import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Edit/Softcabin/Student",
        id = "org.softcabin.student.action.DeleteStudentAction")
@ActionRegistration(
        iconBase = "org/softcabin/student/action/student_delete.png",
        displayName = "#CTL_DeleteStudentAction")
@ActionReferences(value = {
    @ActionReference(path = "Softcabin/Student/Toolbar", position = 300),
    @ActionReference(path = "Softcabin/Student/Rows/Popup", position = 300),
    @ActionReference(path = "Shortcuts", name = "D-Minus")
})
@Messages("CTL_DeleteStudentAction=Delete this student")
public final class DeleteStudentAction extends AbstractAction implements Presenter.Popup{
    JMenuItem jb = new JMenuItem("Delete");
    @Override
    public void actionPerformed(ActionEvent e) {
        Event obj = Lookup.getDefault().lookup(Event.class);
        JOptionPane.showConfirmDialog(null, "I'm deleting this student" + obj);
    }

    @Override
    public JMenuItem getPopupPresenter() {
        return jb;
    }
}
