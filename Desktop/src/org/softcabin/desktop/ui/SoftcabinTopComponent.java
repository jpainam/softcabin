
package org.softcabin.desktop.ui;

import org.openide.windows.TopComponent;

/**
 * Generic TopComponent to show the opened documents.
 *
 * @author Anthony Goubard - Japplis
 */
public abstract class SoftcabinTopComponent extends TopComponent {

    /*private JComponent mainComponent;
    private UndoRedo.Manager manager = new UndoRedo.Manager();
    private InstanceContent services;

    /**
     * Empty constructor used for (de)serialization.
     */
   /* public SoftcabinTopComponent() {
    }
    protected void init() {
        services = new InstanceContent();
        Lookup actionsLookup = ExplorerUtils.createLookup(new ExplorerManager(), getActionMap());
        Lookup lookup = new ProxyLookup(actionsLookup, getLookup(), new AbstractLookup(services));
        associateLookup(lookup);
        /* Init component */
       /*setLayout(new BorderLayout());
        JToolBar topToolbar = createToolbar();
        mainComponent = createMainComponent();
        if (mainComponent instanceof JScrollPane || mainComponent instanceof JTabbedPane) {
            add(mainComponent);
        } else {
            JScrollPane mainPane = new JScrollPane(mainComponent);
            mainPane.getVerticalScrollBar().setUnitIncrement(16);
            //ScrollPaneSelector.installScrollPaneSelector(mainPane);
            add(mainPane);
        }

        add(topToolbar, BorderLayout.NORTH);
    }

    protected JToolBar createToolbar() {
        JToolBar toolbar = new Toolbar(getShortName());
        String toolbarActionsPath = "Softcabin/" + getShortName() + "/Toolbar";
        List<? extends Action> toolbarActions = Utilities.actionsForPath(toolbarActionsPath);
        for (Action action : toolbarActions) {
            if (action == null) {
                toolbar.addSeparator();
            } else if (action instanceof Presenter.Toolbar) {
                Component actionComponent = ((Presenter.Toolbar) action).getToolbarPresenter();
                toolbar.add(actionComponent);
            } else {
                JButton newButton = toolbar.add(action);
                if (newButton.getToolTipText() == null) {
                    String label = (String) action.getValue("displayName");
                    newButton.setToolTipText(label);
                }
            }
        }
        return toolbar;
    }

    protected abstract JComponent createMainComponent();
    public void setMainComponent(JComponent comp){
        mainComponent = comp;
    }
    public JComponent getMainComponent() {
        return mainComponent;
    }
    public InstanceContent getServices() {
        return services;
    }

    public static <T> T getSelectedComponent(Class<T> expectedTopComponent) {
        TopComponent selected = TopComponent.getRegistry().getActivated();
        if (selected.getClass().isAssignableFrom(expectedTopComponent)) {
            return (T) selected;
        } else {
            return null;
        }
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    @Override
    public UndoRedo getUndoRedo() {
        return manager;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }*/
}