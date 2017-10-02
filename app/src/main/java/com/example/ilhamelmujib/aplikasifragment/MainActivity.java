package com.example.ilhamelmujib.aplikasifragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilhamelmujib.aplikasifragment.fragment.DashboardFragment;
import com.example.ilhamelmujib.aplikasifragment.fragment.HomeFragment;
import com.example.ilhamelmujib.aplikasifragment.fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    addFragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    addFragment(new DashboardFragment());
                    return true;
                case R.id.navigation_notifications:
                    addFragment(new NotificationFragment());
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.content, new HomeFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void addFragment(android.support.v4.app.Fragment fragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
        }
}
