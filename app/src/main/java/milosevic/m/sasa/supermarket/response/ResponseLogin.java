package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.data.DataLogin;

public class ResponseLogin {

    public ResponseLoginPom data;



    public class ResponseLoginPom extends BaseResponse{

        public ArrayList<DataLogin> results;

        public String token;
        public String login_token;
        public String incorrect_logins;

    }
}
