package milosevic.m.sasa.supermarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.R;


public class NavigationDrawerAdapter extends ArrayAdapter {

    private Context mContext;
    private int mResource;
    private ArrayList<String> mList;
    private LayoutInflater mInflater;

    public NavigationDrawerAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mList = objects;
        this.mResource = resource;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if (position == 0) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.navigation_item1, null);
        } else if ((position>0 && position<3)||(position>9)){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.navigation_item2, null);
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.navigation_item3, null);
        }



            holder = new Holder();


            convertView.setTag(holder);

        return convertView;
    }


    private class Holder{


    }
}