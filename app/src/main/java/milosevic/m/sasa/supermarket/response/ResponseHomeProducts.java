package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.data.DataHomeProducts;


public class ResponseHomeProducts {

    public ResponseHomeProductsPom data;



    public class ResponseHomeProductsPom extends BaseResponse{

        public ArrayList<DataHomeProducts> results;



    }
}
