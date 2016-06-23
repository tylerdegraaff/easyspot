package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CampingDetailActivity extends AppCompatActivity {

    Integer camping_id;
    String getCampingId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_camping_detail);

        DBHandler db = new DBHandler(this);

        Intent i = getIntent();
        getCampingId = i.getStringExtra("camping_id");
        camping_id = Integer.parseInt(getCampingId);
        ArrayList<Camping> onecamping = db.getCamping(camping_id);

        Button bookNow = (Button) findViewById(R.id.reservate);
        bookNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(CampingDetailActivity.this, BookingGeneralActivity.class);
                intent.putExtra("camping_id", getCampingId);
                Log.d("", "bookNow: " + getCampingId);
                startActivity(intent);
            }
        });

        TextView tv_campingName = (TextView)findViewById(R.id.detail_camping_name);
        ImageView tv_campingImage = (ImageView)findViewById(R.id.detail_camping_image);
        TextView tv_campingPrice = (TextView)findViewById(R.id.detail_camping_price);
        TextView tv_campingAddress = (TextView)findViewById(R.id.detail_camping_address);
        TextView tv_campingPhone = (TextView)findViewById(R.id.detail_camping_phone);
        TextView tv_campingEmail = (TextView)findViewById(R.id.detail_camping_email);
        TextView tv_campingDescription = (TextView)findViewById(R.id.detail_camping_description);
        TextView tv_campingFacilities = (TextView)findViewById(R.id.detail_camping_facilities);

        for (Camping camping : onecamping){
            String log = "id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " +
                    camping.getAddress() + " ,Image: " + camping.getImage() +
                    " ,Phone: " + camping.getPhone() + " ,Price: " + camping.getPrice() +
                    " ,Email: " + camping.getEmail() + " ,Description: " + camping.getDesc() +
                    " ,Facitilitiess: " + camping.getFac();
                    Log.d("------", log + "------");

                    tv_campingName.setText( camping.getName());
                    tv_campingImage.setImageResource(camping.getImage());
                    tv_campingPrice.setText("€" + camping.getPrice() + " p.n");
                    tv_campingAddress.setText(camping.getAddress());
                    tv_campingPhone.setText("Tel: " + camping.getPhone());
                    tv_campingEmail.setText("E-mail: " + camping.getEmail());
                    tv_campingDescription.setText(camping.getDesc());
                    tv_campingFacilities.setText( camping.getFac());
        }
    }

    public void Back(View view) {
        finish();
    }
}
