package mx.itson.proyecto;

import java.util.ArrayList;
import java.util.List;

public class PedidoManager {

    public static List<Pedido> pedidos = new ArrayList<>();

    // Elimina el pedido en la posición indicada (si es válida)
    public static void eliminarPedido(int index) {
        if (index >= 0 && index < pedidos.size()) {
            pedidos.remove(index);
        }
    }
}
