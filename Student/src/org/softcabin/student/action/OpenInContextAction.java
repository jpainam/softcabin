/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.student.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.openide.NotifyDescriptor;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit/Record",
        id = "org.softcabin.student.action.OpenInContextAction")
@ActionRegistration(
        displayName = "#CTL_OpenInContextAction")
@ActionReference(path = "Loaders/content/unknown/Actions", position = 100)
@Messages("CTL_OpenInContextAction=Open")
public final class OpenInContextAction implements ActionListener {

    private final List<DataObject> context;

    public OpenInContextAction(List<DataObject> context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        /*for (DataObject dataObject : context) {
            // TODO use dataObject
        }*/
        NotifyDescriptor d = new NotifyDescriptor.Confirmation("Confirm right clic");
    }
}
