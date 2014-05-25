/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

import java.util.Arrays;
import java.util.List;
import org.openide.filesystems.FileObject;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author jpainam
 */
public class ExplorerFolderFactory extends ChildFactory<FileObject>{
    
    private FileObject folder = null;
    
    public ExplorerFolderFactory(FileObject f){
        this.folder = f;
    }
    @Override
    protected boolean createKeys(List<FileObject> list) {
        list.addAll(Arrays.asList(folder.getChildren()));
        return true;
    }

    @Override
    protected Node createNodeForKey(FileObject key) {
        return new ExplorerFolderNode(key, 
                Children.create(new ExplorerChildFactory(key), false));
    }
    
    
}
