package com.example.vipul.hireforwork;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener {
ImageButton button,button1;
ActionBarDrawerToggle mDrawerToggle;
DrawerLayout drawerLayout;
String module;
public String name1, phone1,age1,gender1,email1,country1,address1,use_as1;
    DatabaseHelper mDatabaseHelper;
private boolean mToolBarNavigationListenerIsRegistered =false;
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper =new DatabaseHelper(this);
        module= getIntent().getStringExtra("module");

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    AddData();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
      //  NavigationView navigationView =findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
         //navigationView.setNavigationItemSelectedListener(this);
        button1 = (ImageButton) findViewById(R.id.plumber);
        button1.setOnClickListener(this); // calling onClick() method
        button = (ImageButton) findViewById(R.id.housekeeping);
        button.setOnClickListener(this);
        }

    private void AddData() {

        Cursor res = mDatabaseHelper.getAllData();
        while (res.moveToNext()) {
            name1 = res.getString(1);
            phone1 = res.getString(2);
            age1 = res.getString(3);
            gender1 = res.getString(4);
            email1 = res.getString(5);
            country1 = res.getString(6);
            address1 = res.getString(7);
            use_as1 = res.getString(8);
        }
    }


        /*public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Surname :"+ res.getString(2)+"\n");
                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }*/

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){

            case R.id.action_Ch:
                Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
                break;

        }

        //noinspection SimplifiableIfStatement
        //   if (id == R.id.action_settings) {
        //     return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        // int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.nav_Pro:

                Intent h=new Intent(MainActivity.this,Profile.class);
                h.putExtra("mobile1", name1);
                h.putExtra("mobile2", phone1);
                h.putExtra("mobile3", age1);
                h.putExtra("mobile4", gender1);
                h.putExtra("mobile5", email1);
                h.putExtra("mobile6", country1);
                h.putExtra("mobile7", address1);
                h.putExtra("mobile8", use_as1);
                startActivity(h);
                break;
            case R.id.nav_Not:

                Intent n=new Intent(MainActivity.this,Notification.class);
                startActivity(n);
                break;
            case R.id.nav_Setting:

                Intent v=new Intent(MainActivity.this,Setting.class);
                startActivity(v);
                break;

            case R.id.nav_share:
               // Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                Intent x=new Intent(Intent.ACTION_SEND);
                x.setType("text/plain");
                x.putExtra(Intent.EXTRA_TEXT,"https://vipulpawar.000webhostapp.com/");
                //x.setData(Uri.parse("https://vipulpawar.000webhostapp.com/"));
                startActivity(Intent.createChooser(x,"Share using"));
                break;
            case R.id.nav_contact:
                //Toast.makeText(this,"Contact",Toast.LENGTH_SHORT).show();
                Uri uri =Uri.parse("https://vipulpawar.000webhostapp.com/");
                Intent w=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(w);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.plumber:
                Intent ve=new Intent(MainActivity.this,Plumber.class);
               ve.putExtra("module","vowels");
                startActivity(ve);
                break;

            case R.id.housekeeping:
               Intent i=new Intent(MainActivity.this,Plumber.class);
              i.putExtra("module","consonants");
               startActivity(i);
                break;
            default:
                break;
        }

    }
}
