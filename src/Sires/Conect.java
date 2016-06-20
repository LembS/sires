

package Sires;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conect {
    Connection conectar= null;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sires2", "root", "");
            System.out.println("conexion establecida");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("error de conexion");
            JOptionPane.showMessageDialog(null, "error de conexion "+e);
        }
        return conectar;
    }
}