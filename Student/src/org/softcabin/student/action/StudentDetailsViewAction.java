/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.student.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit/Softcabin/Student",
        id = "org.softcabin.student.action.StudentDetailsViewAction")
@ActionRegistration(
        iconBase = "org/softcabin/student/action/student_details.png",
        displayName = "#CTL_StudentDetailsViewAction")
@ActionReference(path = "Softcabin/Student/Rows/Popup", position = 100, separatorAfter = 150)
@Messages("CTL_StudentDetailsViewAction=Display details")
public final class StudentDetailsViewAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
