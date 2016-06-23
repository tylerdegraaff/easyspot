package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReservationDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reservation_detail);

        DBHandler db = new DBHandler(this);

        Intent i = getIntent();
        String getCampingId = i.getStringExtra("camping_id");
        String getReservationId = i.getStringExtra("reservation_id");

        Integer camping_id = Integer.parseInt(getCampingId);
        Integer reservation_id = Integer.parseInt(getReservationId);

        ArrayList<Camping> campingData = db.getCamping(camping_id);
        ArrayList<Reservation> reservationData = db.getReservation(reservation_id);

        TextView res_detail_name = (TextView)findViewById(R.id.res_detail_campingName);
        TextView res_detail_address = (TextView)findViewById(R.id.res_detail_campingAddress);
        TextView res_detail_date = (TextView)findViewById(R.id.res_detail_date);
        ImageView res_detail_image = (ImageView)findViewById(R.id.res_detail_image);
        TextView res_detail_price = (TextView)findViewById(R.id.res_detail_price);
        TextView res_detail_phone = (TextView)findViewById(R.id.res_detail_tel);
        TextView res_detail_email = (TextView)findViewById(R.id.res_detail_email);
        TextView res_detail_desc = (TextView)findViewById(R.id.res_detail_desc);
        TextView res_detail_fac = (TextView)findViewById(R.id.res_detail_facilities);

        for (Camping camping : campingData){
            res_detail_name.setText( camping.getName());
            res_detail_image.setImageResource(camping.getImage());
            res_detail_price.setText("€ " + camping.getPrice() + " p.n");
            res_detail_address.setText(camping.getAddress());
            res_detail_phone.setText("Tel: 0" + camping.getPhone());
            res_detail_email.setText("E-mail: " + camping.getEmail());
            res_detail_desc.setText(camping.getDesc());
            res_detail_fac.setText( camping.getFac());
        }

        for (Reservation reservation : reservationData) {
            res_detail_date.setText(reservation.getStart_date() + " - " + reservation.getEnd_date());
        }

    }

    public void onAskEdit(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast toast = Toast.makeText(this, "The camping has been contacted and they will contact you shortly about your request", Toast.LENGTH_LONG);
        toast.show();
    }
}
