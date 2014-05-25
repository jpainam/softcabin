/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.student.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author jpainam
 */
@ActionID(
        category = "Edit/Softcabin/Student",
        id = "org.softcabin.desktop.action.StudentDisplayAction")
@ActionRegistration(
        iconBase = "org/softcabin/student/action/student_display.png",
        displayName = "#CTL_StudentDisplayAction")
@ActionReferences({
    @ActionReference(path = "Menu/Record", position = 100),
    @ActionReference(path = "Toolbars/Record", position = 100)
})
@Messages("CTL_StudentDisplayAction=Display students")
public final class StudentDisplayAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        TopComponent win = WindowManager.getDefault().findTopComponent("StudentDisplayTopComponent");
        win.open();
        win.requestActive();
    }
    
}
