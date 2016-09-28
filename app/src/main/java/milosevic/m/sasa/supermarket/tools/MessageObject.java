package milosevic.m.sasa.supermarket.tools;


import milosevic.m.sasa.supermarket.R;


public class MessageObject {

    public static final int MESSAGE_ERROR=0,MESSAGE_SUCCESS=1,MESSAGE_INFO=2;


    public int stringResource;
    public int time;
    public int type;



    public OnMessageClickListener listener;






    public interface OnMessageClickListener{


        void onCLick();

    }


    public MessageObject() {

        time=5000;
        stringResource= R.string.Greska;

        type=MESSAGE_ERROR;

        listener=null;





    }


    public MessageObject(int stringResource, int time, int type, OnMessageClickListener listener) {
        this.stringResource = stringResource;
        this.time = time;
        this.type = type;
        this.listener = listener;

    }
}
