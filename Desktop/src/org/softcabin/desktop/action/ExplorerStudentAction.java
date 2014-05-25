/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "org.softcabin.desktop.action.ExplorerStudentAction")
@ActionRegistration(
       /* iconBase = "org/softcabin/desktop/explorerStudent.png",*/
        displayName = "#CTL_ExplorerStudentAction")
@Messages("CTL_ExplorerStudentAction=Student Explorer")
public final class ExplorerStudentAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
