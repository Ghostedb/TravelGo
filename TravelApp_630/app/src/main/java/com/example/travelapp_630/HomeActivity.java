package com.example.travelapp_630;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView altMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        altMenu = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();

        altMenu.setOnItemSelectedListener(item -> {
            Fragment secilenFragment = null;
            int id = item.getItemId();

            if (id == R.id.tab_home) {
                secilenFragment = new HomeFragment();
            } else if (id == R.id.tab_search) {
                secilenFragment = new SearchFragment();
            } else if (id == R.id.tab_palm) {
                secilenFragment = new PalmFragment();
            } else if (id == R.id.tab_user) {
                secilenFragment = new UserFragment();
            }

            if (secilenFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, secilenFragment)
                        .commit();
                return true;
            }
            return false;
        });
    }
}