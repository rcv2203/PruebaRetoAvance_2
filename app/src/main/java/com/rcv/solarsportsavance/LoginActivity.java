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
            String url = "https://es-la.facebook.com/reg/";
            Uri uri = Uri.parse(url);
            Intent intentBtnFaceboock = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intentBtnFaceboock);
        });

        btn_google.setOnClickListener(v -> {
            String url = "https://accounts.google.com/InteractiveLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&osid=1&passive=1209600&service=mail&ifkv=AdF4I766L4YYkDsmSk-xsrgGwjQeha0nS2wdSr-bP8n28nS0tGrm9vRgYIOC0xu2jfhzpWGM6QSfnw&ddm=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
            Uri uri = Uri.parse(url);
            Intent intentBtnGoogle = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intentBtnGoogle);
        });

        btn_linkedIn.setOnClickListener(v -> {
            String url = "https://www.linkedin.com/signup?_l=es";
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