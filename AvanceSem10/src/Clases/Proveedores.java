/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author james
 */
public class Proveedores {
    private String NrRuc;
    private String nombre;
    private String direccion;
    private String telefono;

    public Proveedores() {

    }

    public String getNrRuc() {
        return NrRuc;
    }

    public void setNrRuc(String NrRuc) {
        this.NrRuc = NrRuc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
  
    
    public Object[] RegistrarProveedor(int contreg) {
        Object[] fila={NrRuc,nombre,direccion,telefono};
        return null;
    }
}
   