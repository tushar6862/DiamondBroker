package com.example.diamondbroker;

import android.view.Menu;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public class Dashboard_activity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard_activity);
            toolbar = (Toolbar) findViewById(R.id.home_toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            onNavigationItemSelected(navigationView.getMenu().getItem(0));
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.toolbar_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.logout) {
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();
            getSupportActionBar().setTitle(item.getTitle());
            Fragment fragment = null;

            if (id == R.id.Dashboard) {
                // Handle the camera action
                fragment = new Dashboard_fragment();
                Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.Pending) {
                fragment = new Pending_Fragment();
                Toast.makeText(this, "Pending", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.Return) {
                fragment = new Return_Fragment();
                Toast.makeText(this, "Return", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.Commission) {
                fragment = new Commission_Fragment();
                Toast.makeText(this, "Commission", Toast.LENGTH_SHORT).show();
            }
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit(); // save the changes

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
}
