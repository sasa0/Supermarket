package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.data.DataForgotPassword;



public class ResponseForgotPassword {

    public ResponseForgotPasswordPom data;

    public class ResponseForgotPasswordPom extends BaseResponse {

        public String message;

        public ArrayList <DataForgotPassword> results;

    }
}
