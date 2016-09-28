package milosevic.m.sasa.supermarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


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
        return super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = null;

        if(row==null){
            row = mInflater.inflate(mResource,parent,false);

            holder = new Holder();


            row.setTag(holder);


        }
        else{
            holder = (Holder) row.getTag();

        }



        return row;
    }


    private class Holder{
        public TextView sample;


    }
}