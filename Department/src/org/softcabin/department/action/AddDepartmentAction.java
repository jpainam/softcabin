/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.department.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit/Softcabin/Student",
        id = "org.softcabin.department.action.AddDepartmentAction")
@ActionRegistration(
        iconBase = "org/softcabin/department/action/add_department.png",
        displayName = "#CTL_AddDepartmentAction")
@ActionReferences({
    @ActionReference(path = "Menu/Record", position = 400),
    @ActionReference(path = "Toolbars/Record", position = 400)
})
@Messages("CTL_AddDepartmentAction=New Department")
public final class AddDepartmentAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
