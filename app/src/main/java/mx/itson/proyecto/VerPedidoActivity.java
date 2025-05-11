package mx.itson.proyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerPedidoActivity extends AppCompatActivity {

    private boolean expandido = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_pedido);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout header = findViewById(R.id.header_pizza_personalizada);
        LinearLayout contenido = findViewById(R.id.contenido_pizza_personalizada);
        TextView flecha = findViewById(R.id.flecha_pizza_personalizada);

        header.setOnClickListener(v -> {
            expandido = !expandido;
            contenido.setVisibility(expandido ? View.VISIBLE : View.GONE);
            flecha.setText(expandido ? "↑" : "↓");
        });

        Button btnTerminar = findViewById(R.id.btnTerminarOrden);
        btnTerminar.setOnClickListener(v -> {
            Toast.makeText(this, "Orden finalizada. ¡Gracias!", Toast.LENGTH_SHORT).show();
            finish(); // o redirigir a otra pantalla
        });
    }
}
