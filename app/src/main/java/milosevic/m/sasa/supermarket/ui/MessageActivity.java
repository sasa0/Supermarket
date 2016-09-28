package milosevic.m.sasa.supermarket.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.components.CustomTextView;
import milosevic.m.sasa.supermarket.tools.BusProvider;
import milosevic.m.sasa.supermarket.tools.MessageObject;


public class MessageActivity extends AppCompatActivity {

    public View mMessage;

    private CustomTextView mTextViewMessage;

    private Object busEventListener;
    private LayoutInflater mInflater;

    private ViewGroup mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInflater=LayoutInflater.from(getApplicationContext());





        busEventListener= new Object(){

            @Subscribe
            public void onMessageShow(MessageObject messageObject){


                if (mMessage==null){

                    mMessage=mInflater.inflate(R.layout.activity_error,mRootView,false);

                    mTextViewMessage=(CustomTextView)mMessage.findViewById(R.id.errormessage);


                }

                mTextViewMessage.setText(messageObject.stringResource);


                mRootView.addView(mMessage);

                mRootView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mMessage.setVisibility(View.GONE);

                    }
                },messageObject.time);



            }



        };

    }



    @Override
    protected void onResume() {
        super.onResume();

        mRootView=(ViewGroup)findViewById(R.id.root);

        BusProvider.getInstance().register(busEventListener);


    }


    @Override
    protected void onPause() {
        super.onPause();

        BusProvider.getInstance().unregister(busEventListener);
    }

}
