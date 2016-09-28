package milosevic.m.sasa.supermarket.response;

import java.util.ArrayList;

import milosevic.m.sasa.supermarket.data.DataCategory;



public class ResponseCategory {

    public ResponseCategoryPom data;

    public class ResponseCategoryPom extends BaseResponse {

        public ArrayList<DataCategory>results;


    }
}
