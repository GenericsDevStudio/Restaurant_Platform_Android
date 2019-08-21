package com.generics.restaurant;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.mainMenuTitle);
        main = findViewById(R.id.drawerLayout);
        NavigationView mainNavigation = findViewById(R.id.navigationView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                main,
                toolbar,
                R.string.openDrawer,
                R.string.closeDrawer);
        main.addDrawerListener(toggle);
        toggle.syncState();
        mainNavigation.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.mainMenuItem :
                    setTitle(R.string.mainMenuTitle);
                    //TODO
                    onBackPressed();
                    break;
                case R.id.cartMenuItem :
                    setTitle(R.string.cartMenuTitle);
                    //TODO
                    onBackPressed();
                    break;
                case R.id.optionsMenuItem :
                    //TODO
                    break;
                case R.id.exitItem :
                    finish();
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1 :
                //TODO
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(main.isDrawerOpen(Gravity.START)){
            main.closeDrawer(Gravity.START);
        }else{
            super.onBackPressed();
        }
    }
}
