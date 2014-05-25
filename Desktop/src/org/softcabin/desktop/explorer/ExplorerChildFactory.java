/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

import java.util.List;
import javax.swing.Action;
import org.openide.filesystems.FileObject;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Ainam Jean Paul
 * Date of creation : 8 July 2013
 */
public class ExplorerChildFactory extends ChildFactory<Action>{
    private FileObject folder = null;
    
    /* Constructors */
    public ExplorerChildFactory(FileObject f){
        this.folder = f;
    }
    @Override
    protected boolean createKeys(List<Action> list) {
        for(Action action : Lookups.forPath(this.folder.getPath()).lookupAll(Action.class)){
            list.add(action);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Action key) {
        return new ExplorerLeafNode(key);
    }
}
