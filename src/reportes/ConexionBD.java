/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author francis
 */
public class ConexionBD {

    Connection conect = null;

    public Connection conexion() {
        try {
            //Cargamos el Driver MySQL
            Class.forName("com.mysql.jdbc.Driver");
            //coneccion
            conect = DriverManager.getConnection("jdbc:mysql://localhost/madreTeresa", "calcuta", "calcuta");
            //Local Leandro
            //"jdbc:mysql://localhost:3306/circuloo_francisco","root","l34ndr0",
            //Local Violita
            //"jdbc:mysql://localhost/circuloo_francisco","root","root"
            //Online
            //"jdbc:mysql://174.136.57.250/circuloo_francisco","circuloo_franci","1234franci1234"
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
        return conect;

    }
}
