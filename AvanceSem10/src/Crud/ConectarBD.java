package Crud;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import Formatos.Mensajes;

public class ConectarBD implements Parametros{
   public Connection conexion;
    public Statement st;
    public ResultSet rs;
   public PreparedStatement ps;    
    public ConectarBD(){
              try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA,USUARIO,CLAVE);
            st = conexion.createStatement();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede conectar a la BD..."+ex);
        }
    }
    
}

    



