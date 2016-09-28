package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.data.DataCity;

/**
 * Created by User on 12.9.2016.
 */
public class ResponseCity {

    public ResponseCityPom2 data;


    public class ResponseCityPom1{

        public ArrayList<DataCity>townships;
    }

    public class ResponseCityPom2 extends BaseResponse{

        public ResponseCityPom1 results;

    }
}
