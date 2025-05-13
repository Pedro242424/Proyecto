package mx.itson.proyecto;

import java.util.ArrayList;
import java.util.List;

public class DatosPedidos {
    public static List<Pedido> pedidos = new ArrayList<>();

    static {
        // Datos simulados (puedes poner más)
        pedidos.add(new Pedido("Juan Pérez", "Calle Falsa 123", "Grande", "Jamón, Piña, Extra queso", "Refresco", "Peperoni", "Mediana", 280));
        pedidos.add(new Pedido("Ana García", "Av. Siempre Viva 742", "Mediana", "Salami, Champiñones", "Pan de ajo", "Hawaiana", "Grande", 320));
    }
}
