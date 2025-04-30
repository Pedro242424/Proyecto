package mx.itson.proyecto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etCorreo;
    private EditText edContrasenia;
    private Button btnIniciar;

    private TextView btnRegistro;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etCorreo = findViewById(R.id.etCorreo);
        edContrasenia = findViewById(R.id.edContrasenia);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = etCorreo.getText().toString();
                String saludo = "Hola " + correo;
                Toast.makeText(MainActivity.this, saludo, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("CORREO", correo);
                startActivity(intent);
            }
        });

        btnRegistro.setPaintFlags(btnRegistro.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}