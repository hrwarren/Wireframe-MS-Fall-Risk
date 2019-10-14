package com.example.mhealth_wireframe;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.mhealth_wireframe.ui.about.AboutFragment;
import com.example.mhealth_wireframe.ui.history.HistoryFragment;
import com.example.mhealth_wireframe.ui.home.HomeFragment;
import com.example.mhealth_wireframe.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivityNav extends AppCompatActivity
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
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_notifications, R.id.navigation_about)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
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
                setContentView(R.layout.fragment_home);
                break;

            case R.id.navigation_history:
                fragment = new HistoryFragment();
                setContentView(R.layout.fragment_history);
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationsFragment();
                setContentView(R.layout.fragment_notifications);
                break;


            case R.id.navigation_about:
                fragment = new AboutFragment();
                setContentView(R.layout.fragment_about);
//                For some reason, adding an intent keeps the app stuck on the about screen
//                once you navigate there
//                Intent about = new Intent(MainActivityNav.this, AboutActivity.class);
//                startActivity(about);
                break;

        }

        return loadFragment(fragment);
    }

}


