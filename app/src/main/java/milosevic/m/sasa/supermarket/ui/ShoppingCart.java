package milosevic.m.sasa.supermarket.ui;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.adapters.CartAdapter;
import milosevic.m.sasa.supermarket.data.DataContainer;

public class ShoppingCart extends Activity{

    private ImageView mBackButton;
    private ListView mlistView;
    private CartAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mlistView = (ListView)findViewById(R.id.list_view);

        mAdapter = new CartAdapter(getApplicationContext(),R.layout.list_item, DataContainer.reservations);

        mlistView.setAdapter(mAdapter);

        mBackButton = (ImageView)findViewById(R.id.backButton);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
