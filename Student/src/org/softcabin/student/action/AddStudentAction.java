/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.student.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Edit/Softcabin/Student",
        id = "org.softcabin.student.action.AddStudentAction")
@ActionRegistration(
        iconBase = "org/softcabin/student/action/add_student.png",
        displayName = "#CTL_AddStudentAction")
@ActionReferences({
    @ActionReference(path = "Softcabin/Student/Toolbar", position = 300),
    @ActionReference(path = "Menu/Record", position = 300),
    @ActionReference(path = "Toolbars/Record", position = 300)
})
@Messages("CTL_AddStudentAction=New Student")
public final class AddStudentAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TopComponent win = WindowManager.getDefault().findTopComponent("StudentAddTopComponent");
        win.open();
        win.requestActive();
    }
}
