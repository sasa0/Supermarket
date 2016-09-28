package milosevic.m.sasa.supermarket.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.R;


public class SignUpFragment extends Fragment {

    private View mRootView;
    Spinner citySpinner;
    ArrayList<String> cityList;


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
    }
}