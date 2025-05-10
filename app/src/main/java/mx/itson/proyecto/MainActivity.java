package mx.itson.proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etCorreo, edContrasenia;
    private Button btnIniciar, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCorreo = findViewById(R.id.etCorreo);
        edContrasenia = findViewById(R.id.edContrasenia);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnIniciar.setOnClickListener(view -> {
            String correo = etCorreo.getText().toString();

            SharedPreferences prefs = getSharedPreferences("datos_usuario", Context.MODE_PRIVATE);
            String correoRegistrado = prefs.getString("correo", "");

            if (correo.equals(correoRegistrado)) {
                Toast.makeText(this, getString(R.string.msg_login_success), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MenuActivity.class));
                finish();
            } else {
                Toast.makeText(this, getString(R.string.msg_login_error), Toast.LENGTH_SHORT).show();
            }
        });

        btnRegistro.setOnClickListener(view -> {
            startActivity(new Intent(this, RegistroActivity.class));
        });
    }
}
