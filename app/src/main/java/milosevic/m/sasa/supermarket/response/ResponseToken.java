package milosevic.m.sasa.supermarket.response;

import milosevic.m.sasa.supermarket.data.DataToken;
import milosevic.m.sasa.supermarket.response.BaseResponse;


public class ResponseToken {

    public ResponseTokenPom data;


    public class ResponseTokenPom extends BaseResponse {

        public DataToken results;

    }
}
