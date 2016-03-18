package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class servicio {
      
    public static Connection GetConnection()
    {
        Connection conexion=null;
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/izv_dawm","izv_dawm","123456");
            String sql = "CREATE TABLE EMComercio"+
                    "("
                    + "IDComercio INTEGER NOT NULL,"
                    +"Nombre VARCHAR(50),"+
                    "Direccion VARCHAR(50),"
                    +"tipo INTEGER,"
                    +"PRIMARY KEY (IDComercio))"
                    +"GO"
                    +"CREATE TABLE EMHorario"
                    +"("
                    +"IDHorario integer not null,"
                    +"IDComercio integer,"
                    +"Dia varchar(10) check (Dia in('Lunes','Martes','Miercoles','Jueves','Viernes','Sábado','Domingo'))"
                    +"HInicio time,"
                    +"HFin time,"
                    +"Estado check (Estado in('Abierto','Cerrado')),";
            
            String query = "select * from EMComercio;";
            
            Statement stmt=null;
            try {
                stmt = conexion.createStatement();
                stmt.executeUpdate(sql);
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    String first = rs.getString("first");
                    String second = rs.getString("last");
                    
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            } finally {
                stmt.close();
                conexion.close();
            }
           
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch ( Exception e){
            e.printStackTrace();
        }
        return conexion;
    }
}
