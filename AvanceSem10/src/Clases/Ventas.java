package Clases;

import Crud.CrudVentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Stack;

/**
 *
 * @author james
 */
public class Ventas {

    
    private String idVenta;
    private String DNICliente;
    private String idProducto;
    private Date FechaVenta;
    private int Cantidad;
    private float PrecioTotal;


    public Ventas(String idVenta, String DNICliente, String idProducto, Date FechaVenta, int Cantidad, float PrecioTotal) {
        this.idVenta = idVenta;
        this.DNICliente = DNICliente;
        this.idProducto = idProducto;
        this.FechaVenta = FechaVenta;
        this.Cantidad = Cantidad;
        this.PrecioTotal = PrecioTotal;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getDNICliente() {
        return DNICliente;
    }

    public void setDNICliente(String DNICliente) {
        this.DNICliente = DNICliente;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(float PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    public Object[] RegistrarVenta(int contreg) {
        Object[] fila = {idVenta, DNICliente, idProducto, FechaVenta, Cantidad, PrecioTotal};
        return fila;
    }
}
