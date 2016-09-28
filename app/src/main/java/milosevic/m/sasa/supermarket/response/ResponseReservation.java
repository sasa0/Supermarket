package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.data.DataReservation;


public class ResponseReservation {

    public ResponseReservationPom data;



    public class ResponseReservationPom extends BaseResponse{


        public ArrayList<DataReservation>results;



    }
}
