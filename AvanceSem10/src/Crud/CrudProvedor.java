package Crud;

import Clases.Proveedores;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Formatos.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudProvedor extends ConectarBD {

    public CrudProvedor() {
        //Metodo que muestra en una tabla los datos de Categoria
    }

    public void MostrarProoveedores(JTable tabla) {
        String[] titulo = {"NrRuc", "Nombre", "Dirección", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);
        try {
            rs = st.executeQuery("SELECT * FROM proveedores");
            int contreg = 0;
            while (rs.next()) {
                contreg++;
                Proveedores prov = new Proveedores();
                prov.setNrRuc(rs.getString(1));
                prov.setNombre(rs.getString(2));
                prov.setDireccion(rs.getString(3));
                prov.setTelefono(rs.getString(4));
                modelo.addRow(prov.RegistrarProveedor(contreg));
            }
            conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede mostrar los registros..!!" + ex);
        }
    }

    public ResultSet obtenerDatosProveedorPorRUC(String Nruc) {
        ResultSet datosProveedor = null;

        try {
            // Consulta SQL para obtener los datos del proveedor por RUC
            String consulta = "SELECT * FROM proveedores WHERE NrRuc = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, Nruc);

            datosProveedor = statement.executeQuery();
        } catch (SQLException ex) {
            // Manejo de excepciones: imprimir un mensaje de error y registrar la excepción
            Mensajes.M1("Error al buscar el proveedor: " + ex);
            // Registrar la traza de la excepción para depuración
        }
        return datosProveedor;
    }

    public ResultSet obtenerDatosProveedores() {
        try {
            String query = "SELECT * FROM `Proveedores`"; // Consulta SQL para obtener todos los datos de la tabla Proveedores
            rs = st.executeQuery(query); // Ejecutar la consulta
            return rs;
        } catch (SQLException ex) {
            Mensajes.M1("Error al obtener los datos de proveedores: " + ex);
            return null;
        }
    }

}
