package com.example.collabasket;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Navigation pour le Bottom Navigation View
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_list:  // Assure-toi que c'est bien le bon ID
                    startActivity(new Intent(this, ListActivity.class));
                    return true;
                case R.id.nav_inventory:  // Idem ici
                    startActivity(new Intent(this, InventoryActivity.class));
                    return true;
                case R.id.nav_connexion:  // Assure-toi que c'est bien le bon ID
                    startActivity(new Intent(this, MainActivity.class));  // Redirection vers la page de connexion
                    return true;
                default:
                    return false;
            }
        });


        // Logique pour le bouton "S'inscrire"
        findViewById(R.id.button3).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
