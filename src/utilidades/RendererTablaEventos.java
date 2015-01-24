/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author francis
 */
public class RendererTablaEventos extends DefaultTableCellRenderer{
    
        private int columna_patron ;

    public RendererTablaEventos(int columna_patron) {
        this.columna_patron = columna_patron;
    }
    
    @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {        
//        table.setForeground(Color.BLACK);
//        if( table.getValueAt(row,columna_patron) != null){
//              table.setForeground(Color.RED);
//        }
        Double publicidad,rifas,tarjetas,total;  
        
//        for (int i = 0; i < table.getRowCount(); i++) {
//            publicidad= Double.valueOf(table.getValueAt(i, 1).toString());
//            rifas= Double.valueOf(table.getValueAt(i, 2).toString());
//            tarjetas=Double.valueOf(table.getValueAt(i, 3).toString());
//            total=publicidad+rifas+tarjetas;            
//            table.setValueAt(total.toString(), i, columna_patron);
//            
//            System.out.println(table.getValueAt(i, columna_patron));
//            System.out.println(total);
//        }
        
        publicidad= Double.valueOf(table.getValueAt(row, 1).toString());
            rifas= Double.valueOf(table.getValueAt(row, 2).toString());
            tarjetas=Double.valueOf(table.getValueAt(row, 3).toString());
            total=publicidad+rifas+tarjetas;     
            System.out.println(total);
            table.setValueAt(total.toString(), row, columna_patron);
            System.out.println(table.getValueAt(row, columna_patron));
        
        
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        return this;
    }
    
}
