package com.rcv.solarsportsavance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rcv.solarsportsavance.helper.Encrypt;
import com.rcv.solarsportsavance.helper.FileManager;
import com.rcv.solarsportsavance.ui.models.User;

public class LoginActivity extends AppCompatActivity {

    User user;
    EditText email;
    EditText password;
    Button btn_registrarse, btn_login;
    ImageView btn_linkedIn, btn_google, btn_facebock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_registrarse = findViewById(R.id.btn_registrarse);
        btn_login = findViewById(R.id.btn_login);
        btn_linkedIn = findViewById(R.id.btn_linkedIn);
        btn_google = findViewById(R.id.btn_google);
        btn_facebock = findViewById(R.id.btn_faceboock);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);

        btn_login.setOnClickListener(v -> {
            login();

        });

        btn_registrarse.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });


        btn_facebock.setOnClickListener(v -> {
            String url = "https://es-la.facebook.com/login/device-based/regular/login/";
            Uri uri = Uri.parse(url);
            Intent intentBtnFaceboock = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intentBtnFaceboock);
        });

        btn_google.setOnClickListener(v -> {
            String url = "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Faccounts.google.com%2F&followup=https%3A%2F%2Faccounts.google.com%2F&ifkv=AdF4I76BwfZ8eSsCNLUOG1UuNuV6-5niwx24S2Dg05sUzcK867fzrDiVlJ-rAWa-zF8e-OBc2oIG9A&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S1159488193%3A1723324778969131&ddm=0";
            Uri uri = Uri.parse(url);
            Intent intentBtnGoogle = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intentBtnGoogle);
        });

        btn_linkedIn.setOnClickListener(v -> {
            String url = "https://www.linkedin.com/home";
            Uri uri = Uri.parse(url);
            Intent intentBtnIn = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intentBtnIn);
        });

    }

    private void login() {
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        //Guardamos el usuario GLOBAL de la aplicación
        user = ((User) getApplicationContext());
        user.email = email;
        user.password = Encrypt.encryptPassword(password); //Encriptamos la constraseña ingresada

        if (!email.isEmpty() && !password.isEmpty()) {

            FileManager fileManager = new FileManager(this);

            //Validar credenciales en base de datos
            if (fileManager.findUserByEmailAndPassword(user)) {

                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }

}