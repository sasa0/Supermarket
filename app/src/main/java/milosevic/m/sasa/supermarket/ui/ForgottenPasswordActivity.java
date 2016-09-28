package milosevic.m.sasa.supermarket.ui;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.components.CustomEditText;

/**
 * Created by User on 13.9.2016.
 */
public class ForgottenPasswordActivity extends Activity {

    private ImageView mIconBackImageView;

    private CustomEditText mEmail;

    private Button mEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        initComponents();

        addListeners();
    }

    private void initComponents(){

        mEmail=(CustomEditText) findViewById(R.id.forgottenpassword_email);

        mEmailButton=(Button) findViewById(R.id.forgottenpassword_button);

        mIconBackImageView=(ImageView)findViewById(R.id.iconbackforgottenpassword);

        mEmail.setText(getResources().getString(R.string.forgotpassword));



    }

    private void addListeners(){

        mIconBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }
}
