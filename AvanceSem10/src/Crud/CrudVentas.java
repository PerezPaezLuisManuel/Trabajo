package Crud;

import Clases.Ventas;
import Formatos.Mensajes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import vista.*;

public class CrudVentas extends ConectarBD {

    public CrudVentas() {

    }

    public void MostrarVentas(JTable tabla) {
        String[] titulo = {"IDVENTA", "DNICLIENTE", "IDPRODUCTO", "FECHAVENTA", "CANTIDAD", "PRECIOTOTAL"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);

        try {
            rs = st.executeQuery("SELECT * FROM Ventas");
            int contreg = 0;
            while (rs.next()) {
                contreg++;
                String codigoVenta = rs.getString(1);
                String DniCliente = rs.getString(2);
                String Idproducto = rs.getString(3);
                Date fechaVenta = rs.getDate(4);
                int cantidad = rs.getInt(5);
                float precioTotal = rs.getFloat(6);

                Ventas venta = new Ventas(codigoVenta, DniCliente, Idproducto, fechaVenta, cantidad, precioTotal);

                modelo.addRow(new Object[]{codigoVenta, DniCliente, Idproducto, fechaVenta, cantidad, precioTotal});
            }

            conexion.close();
        } catch (SQLException ex) {
            Mensajes.M1("ERROR no se pueden mostrar los registros..!!" + ex);
        }
    }

    public ResultSet obtenerVentaPorCodigo(String codigoVenta) {
           ResultSet datosVentas = null;

    try {
        // Asegúrate de que la conexión a la base de datos se haya establecido correctamente
        if (conexion != null && !conexion.isClosed()) {
            // Consulta SQL para obtener los datos del cliente por DNI
            String consulta = "SELECT * FROM ventas WHERE idVenta = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, codigoVenta);

            datosVentas = statement.executeQuery();
        } else {
            Mensajes.M1("Error: La conexión a la base de datos no está disponible.");
        }

    } catch (SQLException ex) {
        Mensajes.M1("Error al buscar la venta: " + ex);
    }    
        return datosVentas;
    }

    
    public ResultSet obtenerDatosVentas() {
        try {
            String query = "SELECT * FROM  `ventas`";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Mensajes.M1("Error al obtener los datos de ventas: " + ex);
            return null;
        }
    }

    public boolean eliminarVentaPorID(String codigoVenta) {
    try {
        String consulta = "DELETE FROM ventas WHERE idVenta = ?";
        PreparedStatement statement = conexion.prepareStatement(consulta);
        statement.setString(1, codigoVenta);

        int filasAfectadas = statement.executeUpdate();
        return filasAfectadas > 0; // Devuelve true si se eliminó al menos una fila
    } catch (SQLException ex) {
        // Manejar posibles errores de la eliminación
        return false;
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
