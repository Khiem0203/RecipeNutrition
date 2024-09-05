package vn.edu.usth.recipenutrition;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.edu.usth.recipenutrition.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vn.edu.usth.recipenutrition.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_explore, R.id.navigation_favorite)
                .build();

        // Get NavController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Let NavigationUI handle the setup
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Setup ActionBar with NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }
}