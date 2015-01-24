/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author francis
 */
public class ConexionBD {
    Connection conect = null;
   public Connection conexion()
    {
      try {             
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/circuloo_francisco","root","root");  //"jdbc:mysql://174.136.57.250/circuloo_francisco","circuloo_franci","1234franci1234"        "jdbc:mysql://www.db4free.net:3306/sistcalcuta","admincalcuta","sistCalcuta"
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
    }
}
