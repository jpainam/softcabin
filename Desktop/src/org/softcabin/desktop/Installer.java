package org.softcabin.desktop;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.LifecycleManager;
import org.openide.NotifyDescriptor;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;
import org.openide.windows.WindowManager;
import org.softcabin.database.DataModel;
import org.softcabin.desktop.authentication.LoginPanel;
import org.softcabin.desktop.authentication.SecurityManager;

/**
 * 
 * Manages a module's life cycle. Remember that an installer is optional and
 * often not needed at all.
 */
/**
 * 
 * @author Ainam Jean-Paul
 * Date of creation : 8 July 2013
 */
public class Installer extends ModuleInstall{
    /* For login purpose */
   private LoginPanel panel = new LoginPanel();
   private DialogDescriptor d = null;
   /* For tray icon purpose */
   private TrayIcon trayIcon;
   
   /**
    * The default constructor
    */
   public Installer(){
       super();
       //Define an icon for the DialogDescriptor
   }
   /*
   * Handle the TrayIcon
   */
   private void handleTrayIcon(){
       if(SystemTray.isSupported()){
           try{
                SystemTray tray = SystemTray.getSystemTray();
                PopupMenu popup = new PopupMenu();
                for(Action a : Lookups.forPath("TrayMenu").lookupAll(Action.class)){
                    MenuItem item = new MenuItem((String)a.getValue(Action.NAME));
                    item.addActionListener(a);
                    popup.add(item);
                }
                /* Create the icon for the traymenu */
                Image image = ImageUtilities.loadImage("org/softcabin/desktop/trayIcon.png");
                trayIcon = new TrayIcon(image, "Softcabin Tray Icon", popup);
                /* 
                 * Display a message for the first launch 
                 */
                trayIcon.displayMessage("Caption", "This is Softcabin Tray System", TrayIcon.MessageType.INFO);
                 /* Add an action when clicked, display an information */
                trayIcon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /* prompt the about window */
                        trayIcon.displayMessage("Caption", "This is Softcabin Tray System", TrayIcon.MessageType.INFO);
                    }
                });
                /* add the created tray to the System tray */
                tray.add(trayIcon);
            }catch( IllegalArgumentException | SecurityException | UnsupportedOperationException  | AWTException ex){
                Exceptions.printStackTrace(ex);
            }
       }
       /* If the system do not support the Tray system */
       else{
           // Put here what must be done
       }
   }
   /*
   * To handle the connexion
   */
   private void handleConnection(){
      d = new DialogDescriptor(panel, "Login", true, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
               if(event.getSource() == DialogDescriptor.CANCEL_OPTION){
                    LifecycleManager.getDefault().exit();
                }else{
                    if(panel.getUsername().isEmpty() || panel.getPassword().isEmpty()){
                        panel.setInfo("Password or username must be provided");
                    }else{
                        if(!SecurityManager.login(panel.getUsername(), panel.getPassword())){
                            panel.setInfo("Username or password wrong");
                        }else{
                            d.setClosingOptions(null);
                        }
                    }
               }
           }
       });
      /* Add the two button Cancel and Ok to trigger a connexion */
      d.setClosingOptions(new Object[]{});
      d.addPropertyChangeListener(new PropertyChangeListener() {
         @Override
         public void propertyChange(PropertyChangeEvent event) {
            if(event.getPropertyName().equals(DialogDescriptor.PROP_VALUE)
               && event.getNewValue() == DialogDescriptor.CLOSED_OPTION) {
               LifecycleManager.getDefault().exit();
            }
         }
      });
      DialogDisplayer.getDefault().notifyLater(d);
      
      /*WindowManager.getDefault().invokeWhenUIReady(new Runnable(){
         public void run() {
            DialogDisplayer.getDefault().notify(d);
         }
      });*/
   }
   /*
    * This method is called when the app is launch
    * 
    */
   @Override
   public void restored() {
       /* Reset the size */
       /*SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               final Frame frame = WindowManager.getDefault().getMainWindow();
               frame.addWindowListener(new WindowAdapter() {
                   @Override
                   public void windowOpened(WindowEvent e) {
                       frame.setSize(800, 700); 
                   }
                });
           }
       });*/
       /*
        * Call the tray icon handler
        */
       this.handleTrayIcon();
       /*
        * call the connection handler
        */
       this.handleConnection();
   }
   /**
    * This method is always called when the application is closing
    * @return  true is the closing is successful, false if not
    */
    @Override
    public boolean closing() {
        NotifyDescriptor des = new NotifyDescriptor.Confirmation(
                "Do you really want to exit the application",
                "Exit",
                NotifyDescriptor.YES_NO_OPTION);
        if(DialogDisplayer.getDefault().notify(des) == NotifyDescriptor.YES_OPTION){
            return true;
        }else
            return false;
    }

    @Override
    public void close() {
        try{
            DataModel.close();
            DriverManager.getConnection("jdbc:mysql:softcabin;shutdown=true");
        }catch(SQLException ex){
            Exceptions.printStackTrace(ex);
        }
    }
}