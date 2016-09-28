package milosevic.m.sasa.supermarket.ui;

        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;

        import milosevic.m.sasa.supermarket.R;
        import milosevic.m.sasa.supermarket.constant.Constant;
        import milosevic.m.sasa.supermarket.data.DataContainer;
        import milosevic.m.sasa.supermarket.networking.DataLoader;
        import milosevic.m.sasa.supermarket.networking.GsonRequest;
        import milosevic.m.sasa.supermarket.response.ResponseCategory;
        import milosevic.m.sasa.supermarket.response.ResponseCity;
        import milosevic.m.sasa.supermarket.response.ResponseForgotPassword;
        import milosevic.m.sasa.supermarket.response.ResponseHomeProducts;
        import milosevic.m.sasa.supermarket.response.ResponseLogin;
        import milosevic.m.sasa.supermarket.response.ResponseReservation;
        import milosevic.m.sasa.supermarket.response.ResponseSignUp;
        import milosevic.m.sasa.supermarket.response.ResponseToken;
        import milosevic.m.sasa.supermarket.tools.BusProvider;
        import milosevic.m.sasa.supermarket.tools.MessageObject;


/**
 * Created by cubesschool5 on 9/7/16.
 */
public class StartActivity extends MessageActivity {


    private GsonRequest<ResponseToken> mRequestToken;
    private GsonRequest<ResponseCategory>mRequestCategory;
    private GsonRequest<ResponseCity>mRequestCity;
    private GsonRequest<ResponseReservation>mRequestReservation;
    private GsonRequest<ResponseForgotPassword>mRequestForgotPassword;
    private GsonRequest<ResponseSignUp>mRequestSignUp;
    private GsonRequest<ResponseLogin>mRequestLogin;
    private GsonRequest<ResponseHomeProducts>mRequestHomeProducts;

    private int serviceCounter;




    private final String REQUEST_TAG="Start_activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        serviceCounter=0;



        mRequestToken=new GsonRequest<ResponseToken>(Constant.GET_TOKEN_URL + "?username=" + Constant.APPLICATION_USERNAME + "&password=" + Constant.APPLICATION_PASSWORD, Request.Method.GET, ResponseToken.class, new Response.Listener<ResponseToken>() {
            @Override
            public void onResponse(ResponseToken response) {

                DataContainer.TOKEN=response.data.results.token;

                //    Toast.makeText(getApplicationContext(),response.data.results.token,Toast.LENGTH_LONG).show();
                incrementServiceCounter();

                DataLoader.addRequest(getApplicationContext(),mRequestCategory,REQUEST_TAG);
                //    incrementServiceCounter();

                DataLoader.addRequest(getApplicationContext(),mRequestCity,REQUEST_TAG);
                //    incrementServiceCounter();

                DataLoader.addRequest(getApplicationContext(),mRequestReservation,REQUEST_TAG);

                DataLoader.addRequest(getApplicationContext(),mRequestForgotPassword,REQUEST_TAG);

//                DataLoader.addRequest(getApplicationContext(),mRequestSignUp,REQUEST_TAG);

//                DataLoader.addRequest(getApplicationContext(),mRequestLogin,REQUEST_TAG);

                DataLoader.addRequest(getApplicationContext(),mRequestHomeProducts,REQUEST_TAG);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //  Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                BusProvider.getInstance().post(new MessageObject());

            }
        });


        mRequestCategory= new GsonRequest<ResponseCategory>(Constant.CATEGORY_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseCategory.class, new Response.Listener<ResponseCategory>() {
            @Override
            public void onResponse(ResponseCategory response) {

                DataContainer.categories=response.data.results;

                incrementServiceCounter();

                //     Toast.makeText(getApplicationContext(),DataContainer.categories.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mRequestCity= new GsonRequest<ResponseCity>(Constant.CITY_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseCity.class, new Response.Listener<ResponseCity>() {
            @Override
            public void onResponse(ResponseCity response) {

                DataContainer.cities=response.data.results.townships;

                incrementServiceCounter();

                //      Toast.makeText(getApplicationContext(),DataContainer.cities.toString(),Toast.LENGTH_LONG).show();




                //    Toast.makeText(getApplicationContext(),DataContainer.cities.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mRequestReservation=new GsonRequest<ResponseReservation>(Constant.RESERVATION_URL + "?token" + DataContainer.TOKEN, Request.Method.GET, ResponseReservation.class, new Response.Listener<ResponseReservation>() {
            @Override
            public void onResponse(ResponseReservation response) {

                DataContainer.reservations=response.data.results;

                //     Toast.makeText(getApplicationContext(),DataContainer.reservations.toString(),Toast.LENGTH_LONG).show();

                incrementServiceCounter();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //   Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mRequestForgotPassword=new GsonRequest<ResponseForgotPassword>(Constant.FORGOT_PASSWORD_URL + "?token" + DataContainer.TOKEN, Request.Method.GET, ResponseForgotPassword.class, new Response.Listener<ResponseForgotPassword>() {
            @Override
            public void onResponse(ResponseForgotPassword response) {

                DataContainer.forgottenPasswordEmail=response.data.results;
                incrementServiceCounter();
                //      Toast.makeText(getApplicationContext(),DataContainer.forgottenPasswordEmail.toString(),Toast.LENGTH_LONG).show(); */
                //      incrementServiceCounter();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

      /*  mRequestSignUp=new GsonRequest<ResponseSignUp>(Constant.SIGNUP_URL + "?token=" + DataContainer.TOKEN, Request.Method.POST, ResponseSignUp.class, new Response.Listener<ResponseSignUp>() {
            @Override
            public void onResponse(ResponseSignUp response) {

                DataContainer.dataSignUps=response.data.results;

                incrementServiceCounter();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        }); */







     /*   mRequestLogin=new GsonRequest<ResponseLogin>(Constant.LOGIN_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseLogin.class, new Response.Listener<ResponseLogin>() {
            @Override
            public void onResponse(ResponseLogin response) {

                DataContainer.dataLogins=response.data.results;
                incrementServiceCounter();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        }); */

        mRequestHomeProducts=new GsonRequest<ResponseHomeProducts>(Constant.HOME_PAGE_PRODUCT_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseHomeProducts.class, new Response.Listener<ResponseHomeProducts>() {
            @Override
            public void onResponse(ResponseHomeProducts response) {

                DataContainer.homeProducts=response.data.results;
                incrementServiceCounter();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });




        DataLoader.addRequest(getApplicationContext(),mRequestToken,REQUEST_TAG);
        //    DataLoader.addRequest(getApplicationContext(),mRequestCategory,REQUEST_TAG);
        //    DataLoader.addRequest(getApplicationContext(),mRequestCity,REQUEST_TAG);











      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        }).start(); */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        DataLoader.cancelRequest(getApplicationContext(),REQUEST_TAG);
    }

    private void incrementServiceCounter(){

        serviceCounter++;

        if (serviceCounter>=6){

            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();

        }

    }

}


