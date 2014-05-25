/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softcabin.desktop.explorer;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.softcabin.desktop.explorer.Category;

/**
 *
 * @author jpainam
 */
class CategoryNode extends AbstractNode {

    public CategoryNode(Category cat) {
        super(new StudentChildren(cat), Lookups.singleton(cat));
        setDisplayName(cat.getName());
        setIconBaseWithExtension("");
    }
    
}
