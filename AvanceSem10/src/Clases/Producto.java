package Clases;

public class Producto  {

    private String idProducto;
    private String Tipo;
    private String Modelo;
    private String Marca;
    private String Descripcion;
    private float Precio;
    private int Stock;

  
    public Producto(String idProducto, String Tipo, String Modelo, String Marca, String Descripcion, float Precio, int Stock) {
        this.idProducto = idProducto;
        this.Tipo = Tipo;
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Stock = Stock;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public Object[] RegistrarProducto(int contreg) {
        Object[] fila={idProducto,Tipo,Modelo,Marca,Descripcion,Precio,Stock};
        return fila;
    }

}



  