package milosevic.m.sasa.supermarket.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import milosevic.m.sasa.supermarket.R;


public class LoginFragment extends Fragment {

    private View mRootView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mRootView = inflater.inflate(R.layout.login_fragment_layout, container, false);

        return mRootView;
    }




}