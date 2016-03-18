package conexionbd;

import java.sql.*;
import javax.swing.JOptionPane;
import servicio.*;
public class ConexionBD {
    public static void main(String[] args)
    {
        Connection miConexion;
        
        miConexion=servicio.GetConnection();
      
        if(miConexion!=null)
        {
            JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
        }
    }
}