package mx.itson.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Botones "Ver pedido"
        Button btnVerPedido1 = findViewById(R.id.btnVerPedido1);
        Button btnVerPedido2 = findViewById(R.id.btnVerPedido2);
        Button btnVerPedido3 = findViewById(R.id.btnVerPedido3);
        Button btnVerPedido4 = findViewById(R.id.btnVerPedido4);
        Button btnVerPedido5 = findViewById(R.id.btnVerPedido5);
        Button btnVerPedido6 = findViewById(R.id.btnVerPedido6);

        // Botones "Eliminar pedido"
        Button btnEliminarPedido1 = findViewById(R.id.btnEliminarPedido1);
        Button btnEliminarPedido2 = findViewById(R.id.btnEliminarPedido2);
        Button btnEliminarPedido3 = findViewById(R.id.btnEliminarPedido3);
        Button btnEliminarPedido4 = findViewById(R.id.btnEliminarPedido4);
        Button btnEliminarPedido5 = findViewById(R.id.btnEliminarPedido5);
        Button btnEliminarPedido6 = findViewById(R.id.btnEliminarPedido6);

        // Listener genérico para ver pedidos
        View.OnClickListener verPedidoListener = v -> {
            Intent intent = new Intent(MenuActivity.this, VerPedidoActivity.class);
            // Puedes usar extras si deseas enviar el número de pedido
            // intent.putExtra("pedidoIndex", 0);
            startActivity(intent);
        };

        btnVerPedido1.setOnClickListener(verPedidoListener);
        btnVerPedido2.setOnClickListener(verPedidoListener);
        btnVerPedido3.setOnClickListener(verPedidoListener);
        btnVerPedido4.setOnClickListener(verPedidoListener);
        btnVerPedido5.setOnClickListener(verPedidoListener);
        btnVerPedido6.setOnClickListener(verPedidoListener);

        // Listener genérico para eliminar pedidos
        btnEliminarPedido1.setOnClickListener(v -> eliminarPedido(0));
        btnEliminarPedido2.setOnClickListener(v -> eliminarPedido(1));
        btnEliminarPedido3.setOnClickListener(v -> eliminarPedido(2));
        btnEliminarPedido4.setOnClickListener(v -> eliminarPedido(3));
        btnEliminarPedido5.setOnClickListener(v -> eliminarPedido(4));
        btnEliminarPedido6.setOnClickListener(v -> eliminarPedido(5));
    }

    private void eliminarPedido(int index) {
        Intent intent = new Intent(MenuActivity.this, CancelarPedidoActivity.class);
        intent.putExtra("pedidoIndex", index);
        startActivity(intent);
    }
}
