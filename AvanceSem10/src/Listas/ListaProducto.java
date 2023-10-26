/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;
import Nodos.NodoProducto;
import Clases.Producto;
/**
 *
 * @author james
 */public class ListaProducto {
    private NodoProducto inicio; // Puntero al primer nodo de la lista
    private NodoProducto fin;    // Puntero al último nodo de la lista

    public ListaProducto() {
        inicio = null; // Inicialmente, la lista está vacía
        fin = null;
    }

    // Método para agregar un producto al final de la lista
    public void agregarProducto(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto); // Crear un nuevo nodo con el producto
        if (inicio == null) { // Si la lista está vacía
            inicio = nuevoNodo; // El nuevo nodo se convierte en el primer nodo
            fin = nuevoNodo;    // También es el último nodo
        } else {
            fin.setSiguiente(nuevoNodo); // El último nodo apunta al nuevo nodo
            fin = nuevoNodo;             // El nuevo nodo se convierte en el último nodo
        }
    }

    // Método para insertar un producto al inicio de la lista
    public void insertarInicio(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto); // Crear un nuevo nodo con el producto
        if (inicio == null) { // Si la lista está vacía
            inicio = nuevoNodo; // El nuevo nodo se convierte en el primer nodo
            fin = nuevoNodo;    // También es el último nodo
        } else {
            nuevoNodo.setSiguiente(inicio); // El nuevo nodo apunta al actual primer nodo
            inicio = nuevoNodo;             // El nuevo nodo se convierte en el primer nodo
        }
    }

    // Método para eliminar el primer producto de la lista
    public void eliminarInicio() {
        if (inicio != null) {
            inicio = inicio.getSiguiente(); // El primer nodo se actualiza al siguiente nodo
            if (inicio == null) {
                fin = null; // Si el primer nodo era el último, la lista queda vacía
            }
        }
    }

    // Método para buscar un producto por su ID
    public Producto buscarPorId(String id) {
        NodoProducto nodoActual = inicio;
        while (nodoActual != null) {
            if (nodoActual.getProducto().getIdProducto().equals(id)) {
                return nodoActual.getProducto(); // Se encontró el producto
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null; // Producto no encontrado
    }

    // Método para imprimir la lista de productos
    public void imprimir() {
        NodoProducto nodoActual = inicio;
        while (nodoActual != null) {
            Producto producto = nodoActual.getProducto();
            System.out.println("ID: " + producto.getIdProducto() +
                               ", Tipo: " + producto.getTipo() +
                               ", Modelo: " + producto.getModelo() +
                               ", Marca: " + producto.getMarca() +
                               ", Descripción: " + producto.getDescripcion() +
                               ", Precio: " + producto.getPrecio() +
                               ", Stock: " + producto.getStock());
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
