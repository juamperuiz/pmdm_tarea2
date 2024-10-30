package com.ruizrabadan.pmdm_tarea2;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ruizrabadan.pmdm_tarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

    }

    // Método para manejar el clic en un juego
    public void characterClicked(CharacterData character, View view) {

        // Creación de Bundle para pasar datos entre fragmentos
        Bundle bundle = new Bundle();

        // Obtenemos los datos
        bundle.putString("image", character.getImage());
        bundle.putString("name", character.getName());
        bundle.putString("role", character.getRole());
        bundle.putString("description", character.getDescription());
        bundle.putString("skill", character.getSkill());

        // Navegar al characterDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

}