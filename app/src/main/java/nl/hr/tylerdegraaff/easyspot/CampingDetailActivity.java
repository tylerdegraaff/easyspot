package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CampingDetailActivity extends AppCompatActivity {

    String  _campingName, _campingAddress, _campingImage, _campingEmail, _campingFacilities, _campingDescription;;
    int     _campingPhone, _campingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_camping_detail);

        Intent i = getIntent();
        _campingName = i.getStringExtra("name");
        _campingImage = i.getStringExtra("image");
        _campingAddress = i.getStringExtra("address");

        TextView tv = (TextView)findViewById(R.id.detail_camping_name);
        tv.setText(_campingName);

    }

    public void Back(View view) {
        finish();
    }

    public void bookNow(View v) {
        startActivity(new Intent(this, BookingGeneralActivity.class));
    }

}
