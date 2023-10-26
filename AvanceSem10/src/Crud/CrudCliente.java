/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

import Clases.Cliente;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Formatos.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudCliente extends ConectarBD {

    public CrudCliente() {

    }

    public void MostrarClientes(JTable tabla) {
        String[] titulo = {"DNICliente", "Nombre", "Apellido", "Direccion", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);
        try {
            rs = st.executeQuery("SELECT * FROM cliente");
            int contreg = 0;
            while (rs.next()) {
                contreg++;
                Cliente cli = new Cliente();
                cli.setDNICliente(rs.getString(1));
                cli.setNombre(rs.getString(2));
                cli.setApellido(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setTelefono(rs.getString(5));
                modelo.addRow(cli.RegistrarCliente(contreg));
            }
        } catch (SQLException ex) {
            Mensajes.M1("ERROR no se puede mostrar los registros..!!" + ex);

        }
    }

public ResultSet obtenerDatosClientePorDNI(String dni) {
    ResultSet datosCliente = null;

    try {
        // Asegúrate de que la conexión a la base de datos se haya establecido correctamente
        if (conexion != null && !conexion.isClosed()) {
            // Consulta SQL para obtener los datos del cliente por DNI
            String consulta = "SELECT * FROM cliente WHERE DNICliente = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, dni);

            datosCliente = statement.executeQuery();
        } else {
            Mensajes.M1("Error: La conexión a la base de datos no está disponible.");
        }

    } catch (SQLException ex) {
        Mensajes.M1("Error al buscar el cliente por DNI: " + ex);
    }

    return datosCliente;
}

// En la clase CrudCliente
    public ResultSet obtenerDatosClientes() {
        try {
            String query = "SELECT * FROM cliente"; // Consulta SQL para obtener todos los datos de la tabla clientes
            rs = st.executeQuery(query); // Ejecutar la consulta
            return rs;
        } catch (SQLException ex) {
            Mensajes.M1("Error al obtener los datos de clientes: " + ex);
            return null;
        }
    }

}
