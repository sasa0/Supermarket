package milosevic.m.sasa.supermarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.components.CustomEditText;
import milosevic.m.sasa.supermarket.components.CustomTextView;
import milosevic.m.sasa.supermarket.data.DataContainer;
import milosevic.m.sasa.supermarket.data.DataHomeProducts;
import milosevic.m.sasa.supermarket.ui.MainActivity;


public class CartAdapter extends ArrayAdapter {

    private Context mContext;
    private int mResource;
    private ArrayList<DataHomeProducts> mList;
    private LayoutInflater mInflater;



    public CartAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mList = objects;
        this.mResource = resource;
        this.mInflater = LayoutInflater.from(mContext);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = null;

        if(row==null){
            row = mInflater.inflate(mResource,parent,false);

            holder = new Holder();

            holder.cartImage = (ImageView) row.findViewById(R.id.image_cart);
            holder.product = (CustomTextView) row.findViewById(R.id.product);
            holder.price = (CustomTextView) row.findViewById(R.id.price);
            holder.amount = (CustomTextView) row.findViewById(R.id.amount);


            row.setTag(holder);


        }
        else{
            holder = (Holder) row.getTag();

        }

        DataHomeProducts data = mList.get(position);


        holder.product.setText(data.name);
        holder.price.setText("Cena: "+data.price);
        holder.amount.setText("Kolicina: "+data.amount);
        Picasso.with(getContext()).load(data.thumb).into(holder.cartImage);


        return row;
    }


    private class Holder{
        public ImageView cartImage;
        public CustomTextView product;
        public CustomTextView price;
        public CustomTextView amount;

    }
}