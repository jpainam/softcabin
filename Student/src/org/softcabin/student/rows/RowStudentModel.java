
package org.softcabin.student.rows;

import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import org.softcabin.database.DataModel;
import org.softcabin.entities.student.Student;

/**
 *
 * @author Ainam Jean Paul
 * Date of creation : 15 July 2013
 */
public class RowStudentModel extends AbstractTableModel{
    private String[] columns = {"N°", "Matric Number", "First Name", "Last Name", "Date of Birth", "Sex" , "Email", 
        "Department", "Level"};
    private ArrayList<Student> data = new ArrayList<>();
    /**
     * Constructor
     */
    public RowStudentModel() {
        /*for(int i = 0; i < 50; i++){
            if(i % 2 == 0){
                data.add(new Student("21236".concat(String.valueOf(i)), 
                        "Ainam".concat(String.valueOf(i)), 
                        "Jean Paul" + String.valueOf(i),"Computer Science" + String.valueOf(i), 
                        "Masculin" + String.valueOf(i)));
            }else{
                data.add(new Student("PG/125/0".concat(String.valueOf(i)), 
                        "Okoro".concat(String.valueOf(i)), 
                        "Raymond" + String.valueOf(i),"Computer Science" + String.valueOf(i), 
                        "Masculin" + String.valueOf(i)));
            }
        }*/
        ArrayList<Student> ls = (ArrayList<Student>) DataModel.getStudents();
        data.addAll(ls);
        
    }
    public RowStudentModel(ArrayList<Student> list){
        data.addAll(list);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        super.addTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }
    public Student getRow(int i){
        return this.data.get(i);
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student st = data.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return "" + (rowIndex + 1);
            case 1 : return st.getMatric();
            case 2 : return st.getFirstName();
            case 3 : return st.getLastName();
            case 4 : return st.getDateOfBirth().toString();
            case 5 : return st.getEmail();
            case 6 : return st.getSex();
            case 7 : return st.getDepartment().getDescription();
            case 8 : return st.getLevel().getDescription();
        }
        return "";
    }

    @Override
    public String getColumnName(int col) {
        return this.columns[col];
    }
}
