
package org.softcabin.student.rows;

import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.table.JTableHeader;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 *
 * @author jpainam
 */

/**
 * Table used to displays the row numbers next to the data table.
 */
public class RowStudentTable extends JTable{
    private JTable rowTable = new JTable();
    private RowStudentModel model = new RowStudentModel();
    private InstanceContent content = new InstanceContent();
    
    public RowStudentTable() {
        rowTable.setModel(model);
        LookAndFeel.installColorsAndFont(this, "TableHeader.background", "TableHeader.foreground", "TableHeader.font");

        rowTable.getColumnModel().getColumn(0).setHeaderValue("");
        rowTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        Dimension d = getPreferredScrollableViewportSize();
        d.width = getPreferredSize().width;
        rowTable.setPreferredScrollableViewportSize(d);
        rowTable.setRowHeight(this.getRowHeight());
        RowHeadersRenderer rowRenderer = new RowHeadersRenderer();
        rowTable.setDefaultRenderer(String.class, rowRenderer); // This doesn't work!
        rowTable.getColumnModel().getColumn(0).setCellRenderer(rowRenderer);
        rowTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
          
        rowTable.putClientProperty("print.printable", Boolean.TRUE);
        //associateLookup(new AbstractLookup(content));
        JTableHeader corner = rowTable.getTableHeader();
        corner.setReorderingAllowed(false);
        corner.setResizingAllowed(false);

        // Add listener for setRowHeight from the data table
        int rowCount = this.getRowCount();
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            int currentRowHeight = this.getRowHeight(rowIndex);
            if (currentRowHeight != getRowHeight(rowIndex)) {
                setRowHeight(rowIndex, currentRowHeight);
            }
        }

        // Listeners
        RowEventsListeners rowListeners = new RowEventsListeners(this);
        rowTable.addPropertyChangeListener("rowHeight", rowListeners);
        rowTable.addPropertyChangeListener("singleRowHeight", rowListeners);
        //new TableRowResizer(this);
        rowTable.getSelectionModel().addListSelectionListener(rowListeners);
        rowTable.getModel().addTableModelListener(rowListeners);
        rowTable.addMouseListener(rowListeners);
    }
    public JTable getRowTable(){
        return rowTable;
    }

}
