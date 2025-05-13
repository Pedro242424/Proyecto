package mx.itson.proyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import mx.itson.proyecto.Pedido;
import mx.itson.proyecto.PedidoManager;

public class CancelarPedidoActivity extends AppCompatActivity {

    TextView txtDetallePedido;
    Button btnEliminar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelar_pedido);

        btnEliminar = findViewById(R.id.btnEliminar);
        btnCancelar = findViewById(R.id.btnCancelar);

        // Aquí deberías asignar un pedido seleccionado, por ejemplo, el primer pedido.
        // Simulamos que el pedido es el primero de la lista:
        Pedido pedidoSeleccionado = PedidoManager.pedidos.get(0);  // Asume que seleccionas el primero
        txtDetallePedido.setText(pedidoSeleccionado.toString());

        // Eliminar
        btnEliminar.setOnClickListener(v -> {
            if (PedidoManager.pedidos.size() > 0) {
                // Eliminar el primer pedido o el seleccionado
                PedidoManager.eliminarPedido(0);  // Asumiendo que el pedido a eliminar es el primero
                Toast.makeText(this, "Pedido eliminado.", Toast.LENGTH_SHORT).show();

                // Después de eliminar, cerrar la actividad
                finish();
            } else {
                Toast.makeText(this, "No hay pedidos para eliminar.", Toast.LENGTH_SHORT).show();
            }
        });

        // Cancelar
        btnCancelar.setOnClickListener(v -> finish());
    }
}
