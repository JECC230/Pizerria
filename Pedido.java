import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorId = 0;
    private int idPedido;
    private List<Producto> productos;

    public Pedido() {
        this.idPedido = ++contadorId;
        this.productos = new ArrayList<>();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Producto p : productos) {
            total = total.add(p.getPrecio());
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(idPedido).append("\n");
        sb.append("Productos:\n");
        for (Producto p : productos) {
            sb.append("  - ").append(p.getNombre()).append(" ($").append(p.getPrecio()).append(")\n");
        }
        sb.append("Total: $").append(getTotal());
        return sb.toString();
    }
}
