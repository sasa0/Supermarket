package milosevic.m.sasa.supermarket.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.components.CustomEditText;


public class SignUpFragment extends Fragment {

    private View mRootView;
    Spinner citySpinner;
    ArrayList<String> cityList;

    private CustomEditText mPassword;
    private CustomEditText mRepeatPassword;
    private ImageView mCheckPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mRootView = inflater.inflate(R.layout.sign_up_fragment_layout, container, false);

        return mRootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cityList = new ArrayList<>();
        cityList.add(getString(R.string.select_city));
        cityList.add("Beograd");
        cityList.add("Novi Sad");
        cityList.add("Nis");

        citySpinner = (Spinner) mRootView.findViewById(R.id.city_spinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),
                R.layout.city_spinner_item, cityList);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.city_spinner_item);

        citySpinner.setAdapter(spinnerArrayAdapter);


        mPassword = (CustomEditText)mRootView.findViewById(R.id.password1);
        mRepeatPassword = (CustomEditText)mRootView.findViewById(R.id.password2);
        mCheckPassword = (ImageView)mRootView.findViewById(R.id.check_password);
      //  mCheckPassword.setVisibility(View.INVISIBLE);


        mRepeatPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (mPassword.getText().toString().equalsIgnoreCase(mRepeatPassword.getText().toString())){

                    mCheckPassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_check_circle_white_24dp));
                    mCheckPassword.setColorFilter(Color.GREEN);

                } else {

                    mCheckPassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_highlight_off_white_24dp));
                    mCheckPassword.setColorFilter(Color.RED);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (mPassword.getText().toString().equalsIgnoreCase(mRepeatPassword.getText().toString())){

                    mCheckPassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_check_circle_white_24dp));
                    mCheckPassword.setColorFilter(Color.GREEN);

                } else {

                    mCheckPassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_highlight_off_white_24dp));
                    mCheckPassword.setColorFilter(Color.RED);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });
    }
}