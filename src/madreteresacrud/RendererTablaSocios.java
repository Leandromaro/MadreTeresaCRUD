/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author francis
 */
public class RendererTablaSocios extends DefaultTableCellRenderer{
    private int columna_patron ;

    public RendererTablaSocios(int columna_patron) {
        this.columna_patron = columna_patron;
    }
    
    @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {        
        table.setForeground(Color.BLACK);
        if( table.getValueAt(row,columna_patron) != null){
              table.setForeground(Color.RED);
        }
            
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        return this;
    }
}
