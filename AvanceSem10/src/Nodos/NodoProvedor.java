/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;
import Clases.Proveedores;

public class NodoProvedor {
    private Proveedores provedor;
    private NodoProvedor siguiente;

    public NodoProvedor(Proveedores provedor) {
        this.provedor = provedor;
        this.siguiente = null; // Inicialmente, no hay siguiente nodo
    }

    public Proveedores getProvedor() {
        return provedor;
    }

    public void setProvedor(Proveedores provedor) {
        this.provedor = provedor;
    }

    public NodoProvedor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProvedor siguiente) {
        this.siguiente = siguiente;
    }



}