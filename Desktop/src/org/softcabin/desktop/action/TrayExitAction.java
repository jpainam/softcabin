/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.LifecycleManager;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "TrayMenu",
        id = "org.softcabin.desktop.action.TrayExitAction")
@ActionRegistration(
        iconBase = "org/softcabin/desktop/action/exit.png",
        displayName = "#CTL_TrayExitAction")
@ActionReference(path = "TrayMenu", position = 400)
@Messages("CTL_TrayExitAction=Exit the application")
public final class TrayExitAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LifecycleManager.getDefault().exit();
    }
}
