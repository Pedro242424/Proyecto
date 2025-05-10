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

        // Botones de ver pedido
        Button btnVerPedido1 = findViewById(R.id.btnVerPedido1);
        Button btnVerPedido2 = findViewById(R.id.btnVerPedido2);
        Button btnVerPedido3 = findViewById(R.id.btnVerPedido3);
        Button btnVerPedido4 = findViewById(R.id.btnVerPedido4);
        Button btnVerPedido5 = findViewById(R.id.btnVerPedido5);
        Button btnVerPedido6 = findViewById(R.id.btnVerPedido6);

        // Botón de cancelar pedido
        Button btnCancelarPedido = findViewById(R.id.btnCancelarPedido);

        // Mismo intent para todos los pedidos, puedes personalizarlo si necesitas mostrar detalles distintos
        View.OnClickListener verPedidoListener = v -> {
            Intent intent = new Intent(MenuActivity.this, VerPedidoActivity.class);
            startActivity(intent);
        };

        btnVerPedido1.setOnClickListener(verPedidoListener);
        btnVerPedido2.setOnClickListener(verPedidoListener);
        btnVerPedido3.setOnClickListener(verPedidoListener);
        btnVerPedido4.setOnClickListener(verPedidoListener);
        btnVerPedido5.setOnClickListener(verPedidoListener);
        btnVerPedido6.setOnClickListener(verPedidoListener);

        // Cancelar pedido
        btnCancelarPedido.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CancelarPedidoActivity.class);
            startActivity(intent);
        });
    }
}
