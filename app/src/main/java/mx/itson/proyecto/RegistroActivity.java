package mx.itson.proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private EditText edID, edNombres, edApellidos, edCorreo, edUsuario;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edID = findViewById(R.id.edID);
        edNombres = findViewById(R.id.edNombres);
        edApellidos = findViewById(R.id.edApellidos);
        edCorreo = findViewById(R.id.edCorreo);
        edUsuario = findViewById(R.id.edUsuario);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(v -> {
            String id = edID.getText().toString();
            String nombre = edNombres.getText().toString();
            String apellidos = edApellidos.getText().toString();
            String correo = edCorreo.getText().toString();
            String usuario = edUsuario.getText().toString();

            if (id.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || usuario.isEmpty()) {
                Toast.makeText(this, getString(R.string.msg_fill_all), Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("datos_usuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("id", id);
            editor.putString("nombre", nombre);
            editor.putString("apellidos", apellidos);
            editor.putString("correo", correo);
            editor.putString("usuario", usuario);
            editor.apply();

            Toast.makeText(this, getString(R.string.msg_registered), Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
