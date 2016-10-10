package milosevic.m.sasa.supermarket.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.adapters.NavigationDrawerAdapter;
import milosevic.m.sasa.supermarket.components.CustomEditText;

public class SearchActivity extends Activity {

    private ImageView mClear;
    private CustomEditText mSearchET;

    private ArrayList<String> drawerListViewItems;

    private ListView drawerListView;
    private ImageView mMenu;
    NavigationDrawerAdapter mAdapter;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initComp();

        mMenu = (ImageView)findViewById(R.id.menuBtn);

        mAdapter = new NavigationDrawerAdapter(getApplicationContext(),R.layout.drawer_listview_item1,drawerListViewItems);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout1);

        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });




        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = mSearchET.getText().toString();

                if (s.length() > 0) {


                    s = s.substring(0, s.length() - 1);

                    mSearchET.setText(s);


                } else {
                    finish();
                }

                if (s.length()==1){
                    mSearchET.setHint("Search...");
                }

            }
        });

        mClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mSearchET.setText("");
                return false;
            }
        });





    }

    public void initComp(){
        mClear = (ImageView)findViewById(R.id.btnClear);
        mSearchET = (CustomEditText)findViewById(R.id.searchET);
    }

}
