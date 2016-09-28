package milosevic.m.sasa.supermarket.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by cubesschool4 on 9/7/16.
 */
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setTextColor(ColorStateList colors) {
        super.setTextColor(ColorStateList.valueOf(Color.WHITE));
    }



    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(createFont());
    }

    public Typeface createFont(){
        Typeface custom_font = Typeface.createFromAsset(getResources().getAssets(), "fonts/avenir_book.ttf");
        return custom_font;
    }


}
