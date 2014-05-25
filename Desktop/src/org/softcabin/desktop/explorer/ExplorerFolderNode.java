
package org.softcabin.desktop.explorer;

import org.openide.filesystems.FileObject;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author Ainam Jean Paul
 * Date of creation 8 July 2013
 * This class represent what a folder is in the explorer window
 */
public class ExplorerFolderNode extends AbstractNode{
    public ExplorerFolderNode(FileObject folder, Children children){
        super(children);
        setDisplayName(folder.getName());
        String iconBase = (String)folder.getAttribute("icon");
        if(iconBase != null)
            setIconBaseWithExtension(iconBase);
    }
}
