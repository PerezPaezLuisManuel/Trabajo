package Crud;

import Clases.Producto;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Formatos.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudProducto extends ConectarBD {
// Método para ordenar una lista de productos por su precio utilizando el algoritmo Quicksort

    public void ordenarProductosPorPrecio(List<Producto> listaProductos) {
        // Verificar si la lista de productos es válida y no está vacía
        if (listaProductos == null || listaProductos.isEmpty()) {
            return; // No se pueden ordenar productos si la lista está vacía
        }

        // Definir los índices bajo y alto para la ordenación
        int bajo = 0;
        int alto = listaProductos.size() - 1;

        // Llamar al método Quicksort para realizar la ordenación
        quickSortProductosPorPrecio(listaProductos, bajo, alto);
    }

    private void quickSortProductosPorPrecio(List<Producto> listaProductos, int bajo, int alto) {
        if (bajo < alto) {
            // Encontrar el índice del pivote para dividir la lista
            int indicePivote = particionPorPrecio(listaProductos, bajo, alto);

            // Ordenar recursivamente las sub-listas antes y después del pivote
            quickSortProductosPorPrecio(listaProductos, bajo, indicePivote - 1);
            quickSortProductosPorPrecio(listaProductos, indicePivote + 1, alto);
        }
    }

// Función privada que realiza la partición de la lista de productos durante la ordenación por precio
    private int particionPorPrecio(List<Producto> listaProductos, int bajo, int alto) {
        // Seleccionar un elemento como pivote (en este caso, el precio del producto)
        float pivote = listaProductos.get(alto).getPrecio();
        int i = bajo - 1;

        // Recorrer la lista y reorganizar los elementos: si el precio es menor que el pivote, intercambiar
        for (int j = bajo; j < alto; j++) {
            if (listaProductos.get(j).getPrecio() < pivote) {
                i++;
                // Intercambio de productos en la lista
                Producto temp = listaProductos.get(i);
                listaProductos.set(i, listaProductos.get(j));
                listaProductos.set(j, temp);
            }
        }

        // Intercambiar el pivote con el elemento en la posición correcta
        Producto temp = listaProductos.get(i + 1);
        listaProductos.set(i + 1, listaProductos.get(alto));
        listaProductos.set(alto, temp);

        // Devolver el índice del pivote
        return i + 1;
    }
    // Método público para obtener una lista de productos desde la base de datos

    public List<Producto> obtenerListaDeProductos() {
        // Crear una lista vacía para almacenar los productos
        List<Producto> listaProductos = new ArrayList<>();
        try {
            // Definir la consulta SQL para obtener todos los datos de la tabla de productos
            String query = "SELECT * FROM `producto`";
            rs = st.executeQuery(query); // Ejecutar la consulta en la base de datos

            // Recorrer los resultados de la consulta y crear objetos Producto
            while (rs.next()) {
                // Obtener los datos de cada producto desde la base de datos
                String codigo = rs.getString("idProducto");
                String tipo = rs.getString("tipo");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");

                // Crear un objeto Producto con los datos obtenidos de la base de datos
                Producto producto = new Producto(codigo, tipo, modelo, marca, descripcion, precio, stock);

                // Agregar el objeto Producto a la lista de productos
                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            Mensajes.M1("Error al obtener la lista de productos: " + ex);
        }

        // Devolver la lista de productos obtenida
        return listaProductos;
    }

    // Función para mostrar los productos en una tabla
    public void MostrarProductos(JTable tabla) {
        String[] titulo = {"IDPRODUCTO", "TIPO", "MODELO", "MARCA", "DESCRIPCION", "PRECIO", "STOCK"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);

        try {
            rs = st.executeQuery("SELECT * FROM producto");
            int contreg = 0;
            while (rs.next()) {
                contreg++;
                String codigo = rs.getString(1);
                String tipo = rs.getString(2);
                String modelo1 = rs.getString(3);
                String marca = rs.getString(4);
                String descripcion = rs.getString(5);
                float precio = rs.getFloat(6);
                int stock = rs.getInt(7);

                Producto producto = new Producto(codigo, tipo, modelo1, marca, descripcion, precio, stock);

                // Agregar la instancia de Producto a la tabla
                modelo.addRow(producto.RegistrarProducto(contreg));
            }

            conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se pueden mostrar los registros..!!" + ex);
        }
    }

    // Función para obtener los datos de un producto específico por su código
    public ResultSet obtenerDatosProductoPorCodigo(String codigo) {
        ResultSet datosProducto = null;

        try {
            // Consulta SQL para obtener los datos del producto por código
            String consulta = "SELECT * FROM producto WHERE idProducto = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, codigo);

            datosProducto = statement.executeQuery();

        } catch (SQLException ex) {
            Mensajes.M1("Error al buscar el producto: " + ex);
        }

        return datosProducto;
    }

    // Función para obtener los datos de todos los productos
    public ResultSet obtenerDatosProductos() {
        try {
            String query = "SELECT * FROM `producto`"; // Consulta SQL para obtener todos los datos de la tabla productos
            rs = st.executeQuery(query); // Ejecutar la consulta
            return rs;
        } catch (SQLException ex) {
            Mensajes.M1("Error al obtener los datos de productos: " + ex);
            return null;
        }
    }
}
