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
        id = "org.softcabin.department.action.DepartmentDisplayAction")
@ActionRegistration(
        iconBase = "org/softcabin/department/action/department_display.png",
        displayName = "#CTL_DepartmentDisplayAction")
@ActionReferences({
    @ActionReference(path = "Menu/Record", position = 200, separatorAfter = 250),
    @ActionReference(path = "Toolbars/Record", position = 200)
})
@Messages("CTL_DepartmentDisplayAction=Dispaly Department")
public final class DepartmentDisplayAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
