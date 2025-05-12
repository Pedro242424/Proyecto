package mx.itson.proyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mx.itson.proyecto.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    private EditText etCorreo, edContrasenia;
    private Button btnIniciar, btnRegistro, btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCorreo = findViewById(R.id.etCorreo);
        edContrasenia = findViewById(R.id.edContrasenia);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnCrear = findViewById(R.id.btnCrear); // <- Agregamos el botón de crear BD

        btnIniciar.setOnClickListener(view -> {
            String correo = etCorreo.getText().toString();
            String contrasena = edContrasenia.getText().toString();

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, getString(R.string.msg_fill_all), Toast.LENGTH_SHORT).show();
                return;
            }

            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery(
                    "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?",
                    new String[]{correo, contrasena}
            );

            if (cursor.moveToFirst()) {
                Toast.makeText(this, getString(R.string.msg_login_success), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MenuActivity.class));
                finish();
            } else {
                Toast.makeText(this, getString(R.string.msg_login_error), Toast.LENGTH_SHORT).show();
            }

            cursor.close();
            db.close();
        });

        btnRegistro.setOnClickListener(view -> {
            startActivity(new Intent(this, RegistroActivity.class));
        });

        btnCrear.setOnClickListener(view -> {
            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if (db != null) {
                Toast.makeText(this, "Base de datos creada correctamente", Toast.LENGTH_SHORT).show();
                db.close();
            } else {
                Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
