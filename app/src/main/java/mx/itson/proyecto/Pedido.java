package mx.itson.proyecto;

public class Pedido {
    public String nombreCliente;
    public String direccion;
    public String tamanoPersonalizada;
    public String ingredientes;
    public String complementos;
    public String pizzaMenu;
    public String tamanoPizzaMenu;
    public double costoTotal;

    public Pedido(String nombreCliente, String direccion, String tamanoPersonalizada, String ingredientes, String complementos, String pizzaMenu, String tamanoPizzaMenu, double costoTotal) {
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.tamanoPersonalizada = tamanoPersonalizada;
        this.ingredientes = ingredientes;
        this.complementos = complementos;
        this.pizzaMenu = pizzaMenu;
        this.tamanoPizzaMenu = tamanoPizzaMenu;
        this.costoTotal = costoTotal;
    }
}
