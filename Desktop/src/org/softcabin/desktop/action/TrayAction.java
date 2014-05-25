package org.softcabin.desktop.action;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.LifecycleManager;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
/**
 * 
 * @author Ainam Jean-Paul
 * Date of creation : 8 July 2013
 * This class handle the icon in the System tray
 */
@ActionID(
        category = "TrayMenu",
        id = "org.softcabin.desktop.action.TrayAction")
@ActionRegistration(
        iconBase = "org/softcabin/desktop/action/about.png",
        displayName = "#CTL_TrayAction")
@ActionReferences({
   @ActionReference(path = "TrayMenu", position = 200)
})
@Messages("CTL_TrayAction=About")
public final class TrayAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Launch the About window when clicked */
        System.out.println("How to launch the About window");
        NotifyDescriptor d = new NotifyDescriptor.Confirmation(
                "Launch the About window", 
                "Tray Icon", NotifyDescriptor.YES_NO_OPTION);
        
    }
}