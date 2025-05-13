package mx.itson.proyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VerPedidoActivity extends AppCompatActivity {

    private boolean expandido = false;
    private int indiceActual = 0; // Siempre mostrará el primer pedido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido);

        LinearLayout header = findViewById(R.id.header_pizza_personalizada);
        LinearLayout contenido = findViewById(R.id.contenido_pizza_personalizada);
        TextView flecha = findViewById(R.id.flecha_pizza_personalizada);

        TextView txtNombre = findViewById(R.id.txtNombreCliente);
        TextView txtDireccion = findViewById(R.id.txtDireccionCliente);
        TextView txtTamano = findViewById(R.id.contenido_pizza_personalizada).findViewById(R.id.txtTamano);
        TextView txtIngredientes = findViewById(R.id.contenido_pizza_personalizada).findViewById(R.id.txtIngredientes);
        TextView txtComplementos = findViewById(R.id.contenido_pizza_personalizada).findViewById(R.id.txtComplementos);
        TextView txtOtraPizza = findViewById(R.id.txtOtraPizza);
        TextView txtCostoTotal = findViewById(R.id.txtCostoTotal);
        Button btnTerminar = findViewById(R.id.btnTerminarOrden);

        if (DatosPedidos.pedidos.size() > 0) {
            Pedido pedido = DatosPedidos.pedidos.get(indiceActual);

            txtNombre.setText("Cliente: " + pedido.nombreCliente);
            txtDireccion.setText("Dirección: " + pedido.direccion);
            txtTamano.setText("Tamaño: " + pedido.tamanoPersonalizada);
            txtIngredientes.setText("Ingredientes: " + pedido.ingredientes);
            txtComplementos.setText("Complementos: " + pedido.complementos);
            txtOtraPizza.setText("Pizza de " + pedido.pizzaMenu + " (1)\nTamaño: " + pedido.tamanoPizzaMenu);
            txtCostoTotal.setText("Costo total: $" + pedido.costoTotal);
        } else {
            Toast.makeText(this, "No hay pedidos", Toast.LENGTH_SHORT).show();
            finish();
        }

        header.setOnClickListener(v -> {
            expandido = !expandido;
            contenido.setVisibility(expandido ? View.VISIBLE : View.GONE);
            flecha.setText(expandido ? "↑" : "↓");
        });

        btnTerminar.setOnClickListener(v -> {
            if (DatosPedidos.pedidos.size() > 0) {
                DatosPedidos.pedidos.remove(indiceActual);
                Toast.makeText(this, "Orden eliminada", Toast.LENGTH_SHORT).show();
            }
            finish(); // Puedes redirigir si quieres
        });
    }
}
