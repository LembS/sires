

package Sires;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conect {
    Connection conectar= null;
    public Connection conexion(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conectar =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sires", "root", "");
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e);
        }
        return conectar;
    }
}