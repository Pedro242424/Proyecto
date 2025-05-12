package mx.itson.proyecto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mx.itson.proyecto.db.DbHelper;

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
        edUsuario = findViewById(R.id.edUsuario); // Contraseña
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(v -> {
            String id = edID.getText().toString().trim();
            String nombre = edNombres.getText().toString().trim();
            String apellidos = edApellidos.getText().toString().trim();
            String correo = edCorreo.getText().toString().trim();
            String contrasena = edUsuario.getText().toString().trim();

            if (id.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, getString(R.string.msg_fill_all), Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int idInt = Integer.parseInt(id);

                DbHelper dbHelper = new DbHelper(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("id", idInt);
                values.put("nombre", nombre);
                values.put("apellidos", apellidos);
                values.put("correo", correo);
                values.put("contrasena", contrasena);

                long result = db.insert("usuarios", null, values);

                if (result != -1) {
                    Toast.makeText(this, getString(R.string.msg_registered), Toast.LENGTH_SHORT).show();
                    Log.d("Registro", "Usuario insertado con ID SQLite: " + result);
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Error al registrar usuario (¿ID duplicado?)", Toast.LENGTH_LONG).show();
                    Log.e("Registro", "Fallo en la inserción");
                }

                db.close();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "ID inválido", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error inesperado: " + e.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Registro", "Excepción: ", e);
            }
        });
    }
}
