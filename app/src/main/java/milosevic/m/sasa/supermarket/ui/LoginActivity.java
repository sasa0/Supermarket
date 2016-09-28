package milosevic.m.sasa.supermarket.ui;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import milosevic.m.sasa.supermarket.R;
import milosevic.m.sasa.supermarket.components.RoundedImageView;


public class LoginActivity extends MessageActivity implements TabLayout.OnTabSelectedListener {


final int RESULT_LOAD_IMAGE = 100;

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private ViewFlipper mViewFlipper;

    private CircleImageView mPersonPhoto;

    private ImageView mAddPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);



        mPersonPhoto = (CircleImageView) findViewById(R.id.person_photo);

        mAddPhoto = (ImageView)findViewById(R.id.addPhoto);




        mAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });






        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        tabLayout.addTab(tabLayout.newTab().setText(R.string.login));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sign_up));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);


        viewPager = (ViewPager) findViewById(R.id.pager);


        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());


        viewPager.setAdapter(adapter);


        tabLayout.setOnTabSelectedListener(this);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                tabLayout.setScrollPosition(position, positionOffset, true);
                mViewFlipper.setDisplayedChild(position);



            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {


        viewPager.setCurrentItem(tab.getPosition());
        mViewFlipper.setDisplayedChild(tab.getPosition());


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {


        viewPager.setCurrentItem(tab.getPosition());
        mViewFlipper.setDisplayedChild(tab.getPosition());


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            mPersonPhoto.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }

    }

    private Animation inFromLeftAnimation()
    {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);

        inFromLeft.setDuration(400);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }




}




