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
        category = "Explorer",
        id = "org.softcabin.desktop.action.ExplorerStudentView")
@ActionRegistration(
        iconBase = "org/softcabin/desktop/explorerStudent.png",
        displayName = "#CTL_ExplorerStudentView")
@Messages("CTL_ExplorerStudentView=Student")
public final class ExplorerStudentView implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
