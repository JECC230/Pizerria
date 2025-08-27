import java.math.BigDecimal;

public class Producto {
    private int idProducto;
    private String nombre;
    private BigDecimal precio;

    public Producto(int idProducto, String nombre, BigDecimal precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "ID: " + idProducto + ", Nombre: " + nombre + ", Precio: $" + precio;
    }
}
