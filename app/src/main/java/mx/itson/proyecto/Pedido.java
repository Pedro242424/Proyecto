package mx.itson.proyecto;

import java.util.List;

public class Pedido {

    private String tipoPizza; // Ej: "Pizza Personalizada" o "Pizza de Menú"
    private String tamano;
    private List<String> ingredientes;
    private List<String> complementos;

    public Pedido(String tipoPizza, String tamano, List<String> ingredientes, List<String> complementos) {
        this.tipoPizza = tipoPizza;
        this.tamano = tamano;
        this.ingredientes = ingredientes;
        this.complementos = complementos;
    }

    public String getTipoPizza() {
        return tipoPizza;
    }

    public String getTamano() {
        return tamano;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public List<String> getComplementos() {
        return complementos;
    }

    @Override
    public String toString() {
        return tipoPizza + "\n" +
                "Tamaño: " + tamano + "\n" +
                "Ingredientes: " + String.join(", ", ingredientes) + "\n" +
                "Complementos: " + String.join(", ", complementos);
    }
}
