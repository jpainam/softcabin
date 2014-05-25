
package org.softcabin.desktop.explorer;

import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import org.openide.awt.Actions;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.Lookup;
import org.openide.util.Utilities;

/**
 *
 * @author Ainam Jean Paul
 * Date of creation : 8 July 2013
 * This class represents what a leaf is in the Explorer tree
 */
public class ExplorerLeafNode extends AbstractNode{
    
    private Action action = null;
    
    public ExplorerLeafNode(Action a){
        super(Children.LEAF);
        this.action = a;
        setDisplayName(Actions.cutAmpersand((String) action.getValue(Action.NAME)));
    }

    @Override
    public Action[] getActions(boolean context) {
        /*return new Action[]{new MyAction()};*/
        Action[] act = new Action[10];
        int i = 0;
        //JPopupMenu popup = new JPopupMenu();
        List<? extends Action> popupAction = Utilities.actionsForPath("Softcabin/Student/Rows/Popup");
        for(Action action : popupAction){
            act[i++] = action;
        }
        //return popup;
        return act;
        /*final JPopupMenu menu = Utilities.actionsToPopup(buildActions.toArray(new Action[buildActions.size()]), this);
        addMouseListerner spreadsheetcomp*/
    }
    
    //@Override
    /*public Action getPreferredAction() {
      return action;
   }*/
   
   @Override
   public Image getIcon(int type) {
      ImageIcon img = (ImageIcon) action.getValue(Action.SMALL_ICON);
      
      if(img != null) {
         return img.getImage();
      } else {
         return null;
      }
   }

    private static class MyAction extends AbstractAction {

        public MyAction() {
            putValue(NAME, "Do something");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Event obj = Lookup.getDefault().lookup(Event.class);
            JOptionPane.showConfirmDialog(null, "Hello from " + obj);
        }
    }
}
