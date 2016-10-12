package milosevic.m.sasa.supermarket.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import milosevic.m.sasa.supermarket.R;


public class CustomEditText extends EditText {


    public CustomEditText(Context context) {
        super(context);

    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    public void setTextColor(ColorStateList colors) {
        super.setTextColor(ColorStateList.valueOf(Color.WHITE));
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(null);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(createFont());
    }

    public Typeface createFont() {
        Typeface custom_font = Typeface.createFromAsset(getResources().getAssets(), "fonts/avenir_book.ttf");
        return custom_font;
    }

    @Override
    public void setCursorVisible(boolean visible) {
        super.setCursorVisible(true);
    }


    @Override
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        super.setFocusableInTouchMode(false);
    }





    @Override
    public void setTextColor(int color) {
        super.setTextColor(Color.WHITE);
        setHintTextColor(Color.GRAY);
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(Color.WHITE);
    }

    //not available below API 21
  /*  @Override
    public void setLetterSpacing(float letterSpacing) {
        super.setLetterSpacing(0.3f);
    }
    */
}
