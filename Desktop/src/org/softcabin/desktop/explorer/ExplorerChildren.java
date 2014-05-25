/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.softcabin.desktop.explorer.Category;

/**
 *
 * @author jpainam
 */
public class ExplorerChildren extends Children.Keys {
    private String[] categories = new String[] {"Students", "Departments", "Schools"};

    public ExplorerChildren() {
    }

    @Override
    protected Node[] createNodes(Object key) {
        Category cat = (Category)key;
        return new Node[] {new CategoryNode(cat)};
    }

    @Override
    protected void addNotify() {
        super.addNotify();
        Category[] objs = new Category[categories.length];
        for(int i = 0; i < objs.length; i++){
            Category cat = new Category(categories[i]);
            objs[i] = cat;
        }
        setKeys(objs);
    }
    
    
}
