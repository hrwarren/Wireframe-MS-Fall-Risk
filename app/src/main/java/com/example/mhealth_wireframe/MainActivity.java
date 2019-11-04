package com.example.mhealth_wireframe;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.mhealth_wireframe.ui.about.AboutFragment;
import com.example.mhealth_wireframe.ui.dashboard.DashboardFragment;
import com.example.mhealth_wireframe.ui.home.HomeFragment;
import com.example.mhealth_wireframe.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i("metawear", "MA: View created");

        // Attach layout to activity
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);


        // Attach and setup a bottom navigation bar
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_about)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); //originally nav_host_fragment; making it mobile_navigation or nav_view crashes app
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnNavigationItemSelectedListener(this);
    }


        // Loading the fragment that the user clicked ??? I think???
        private boolean loadFragment (Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }


        // The listener for navigating between items that the user selects from the bar
        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item){

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationsFragment();
                break;

            case R.id.navigation_about:
                fragment = new AboutFragment();
                break;

        }

        return loadFragment(fragment);
    }
}


