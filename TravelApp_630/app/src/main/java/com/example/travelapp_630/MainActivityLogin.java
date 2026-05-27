package com.example.travelapp_630;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.travelapp_630.databinding.ActivityLoginMainBinding;

public class MainActivityLogin extends AppCompatActivity {

    private ActivityLoginMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = binding.editTextMail.getText().toString().trim();
                String password =  binding.editTextPassword.getText().toString().trim();

                if(mail.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivityLogin.this, "Lütfen hesap bilgilerinizi giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if (mail.equals("admin") && password.equals("1234")){
                        Toast.makeText(MainActivityLogin.this, "Giriş Başarılı Ana sayfaya aktarılıyorsunuz", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivityLogin.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(MainActivityLogin.this, "Lütfen Hesap bilgilerinizin DOĞRU olduğuna dikkat edin", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        });

        binding.iconFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivityLogin.this, "Bu Özellik Kulanım Dışıdır", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        binding.iconGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivityLogin.this, "Bu Özellik Kulanım Dışıdır", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        binding.iconInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivityLogin.this, "Bu Özellik Kulanım Dışıdır", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        binding.tvForgotPassword.setOnClickListener(v -> {
            Toast.makeText(this, "Size Verilmiş Olan Kulanıcı Bilgileri İle Giriş Yapın", Toast.LENGTH_SHORT).show();
            return;
        });
    }
}