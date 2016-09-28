package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;
import java.util.ResourceBundle;

import milosevic.m.sasa.supermarket.data.DataSignUp;
import milosevic.m.sasa.supermarket.response.BaseResponse;


public class ResponseSignUp {

    public ResponseSignUpPom data;



    public class ResponseSignUpPom extends BaseResponse {

        public String message;

        public ArrayList<DataSignUp> results;

    }
}
