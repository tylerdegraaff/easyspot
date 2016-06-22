package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CampingDetailActivity extends AppCompatActivity {

    //Integer camping_id;
    //String  getCampingId, _campingName, _campingAddress, _campingEmail, _campingFacilities, _campingDescription;
    //int _campingImage, _campingPhone, _campingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_camping_detail);

        DBHandler db = new DBHandler(this);

        //Intent i = getIntent();
        //getCampingId = i.getStringExtra("camping_id");
        //camping_id = Integer.parseInt(getCampingId);
        //ArrayList<Camping> data = db.getCamping(1);

        ArrayList<Camping> onecampong = db.getCamping(1);
        for (Camping camping : onecampong){
            String log = "id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " +
                    camping.getAddress() + " ,Image: " + camping.getImage() +
                    " ,Phone: " + camping.getPhone() + " ,Price: " + camping.getPrice() +
                    " ,Email: " + camping.getEmail() + " ,Description: " + camping.getDesc() +
                    " ,Facitilitiess: " + camping.getFac();
            Log.d("------", log + "------");
        }


        //ImageView tv_campingImage = (ImageView)findViewById(R.id.detail_camping_image);

//        for (Camping camping : data) {
//            _campingName = camping.getName();
//            tv_campingImage.setImageResource(camping.getImage());
//            _campingImage = camping.getImage();
//            _campingAddress = camping.getAddress();
//            _campingPhone = camping.getPhone();
//            _campingEmail = camping.getEmail();
//            _campingFacilities = camping.getFac();
//            _campingDescription = camping.getDesc();
//            _campingPrice = camping.getPrice();
//
//            Log.d("", "onCreate: " + camping.getName());
//        }


//        ImageView tv_campingImage = (ImageView)findViewById(R.id.detail_camping_image);
//        tv_campingImage.setImageResource(_campingImage);
//
//        // NAME
//        TextView tv_campingName = (TextView)findViewById(R.id.detail_camping_name);
//        tv_campingName.setText( _campingName);
//
//        // PRICE
//        TextView tv_campingPrice = (TextView)findViewById(R.id.detail_camping_price);
//        tv_campingPrice.setText("€" + _campingPrice + " p.n");
//
//        // ADDRESS
//        TextView tv_campingAddress = (TextView)findViewById(R.id.detail_camping_address);
//        tv_campingAddress.setText(_campingAddress);
//
//        // PHONE
//        TextView tv_campingPhone = (TextView)findViewById(R.id.detail_camping_phone);
//        tv_campingPhone.setText("Tel: " + _campingPhone);
//
//        // EMAIL
//        TextView tv_campingEmail = (TextView)findViewById(R.id.detail_camping_email);
//        tv_campingEmail.setText("E-mail: " + _campingEmail);
//
//        // DESCRIPTION
//        TextView tv_campingDescription = (TextView)findViewById(R.id.detail_camping_description);
//        tv_campingDescription.setText( _campingDescription);
//
//        // FACILITIES
//        TextView tv_campingFacilities = (TextView)findViewById(R.id.detail_camping_facilities);
//        tv_campingFacilities.setText( _campingFacilities);

//        Log.d("", "onCreate: " + camping.getId() + camping.getName());
//
//        _campingName = i.getStringExtra("name");
//        _campingImage = i.getStringExtra("image");
//        _campingAddress = i.getStringExtra("address");
//        _campingPhone = i.getStringExtra("phone");
//        _campingEmail = i.getStringExtra("email");
//        _campingFacilities = i.getStringExtra("facilities");
//        _campingDescription = i.getStringExtra("description");
//        _campingPrice = i.getStringExtra("price");
    }

    public void Back(View view) {
        finish();
    }

    public void bookNow(View v) {
        startActivity(new Intent(this, BookingGeneralActivity.class));
    }

}
