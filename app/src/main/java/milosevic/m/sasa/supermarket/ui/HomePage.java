package milosevic.m.sasa.supermarket.ui;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.adapters.NavigationDrawerAdapter;

public class HomePage extends Activity{

    LinearLayout mProduct1, mProduct2,mProduct3,mProduct4,mProduct5,mProduct6;
    private ArrayList<String> drawerListViewItems;
    DrawerLayout drawerLayout;
    private ListView drawerListView;
    private ImageView mMenu;
    NavigationDrawerAdapter mAdapter;
    private ImageView btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initComp();

        populateList();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, SearchActivity.class);
                startActivity(i);
            }
        });

        mMenu = (ImageView)findViewById(R.id.menuBtn);

        mAdapter = new NavigationDrawerAdapter(getApplicationContext(),R.layout.drawer_listview_item1,drawerListViewItems);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerListView = (ListView) findViewById(R.id.left_drawer);

        drawerListView.setAdapter(mAdapter);

        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        drawerListView.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //some action
            drawerLayout.closeDrawer(drawerListView);

        }
    }

    public void populateList(){
        drawerListViewItems = new ArrayList<>();
        for (int i=0;i<10;i++){
            drawerListViewItems.add("text"+i);
        }
    }





    public void initComp(){
        mProduct1 = (LinearLayout)findViewById(R.id.product1);
        mProduct2 = (LinearLayout)findViewById(R.id.product2);
        mProduct3 = (LinearLayout)findViewById(R.id.product3);
        mProduct4 = (LinearLayout)findViewById(R.id.product4);
        mProduct5 = (LinearLayout)findViewById(R.id.product5);
        mProduct6 = (LinearLayout)findViewById(R.id.product6);
        btnSearch = (ImageView)findViewById(R.id.btnSearch);
    }
}
