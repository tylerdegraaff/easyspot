package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class PayBookingActivity extends AppCompatActivity {

    DBHandler db;
    String getCampingId, getStartDate, getEndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pay_booking);
        Random rand = new Random();
        int random_days_price = rand.nextInt(20) + 1;
        int random_people_price = rand.nextInt(40) + 5;

        db = new DBHandler(this);

        Intent i = getIntent();
        getCampingId = i.getStringExtra("camping_id");
        getStartDate = i.getStringExtra("start_date");
        final Integer camping_id = Integer.parseInt(getCampingId);
        getEndDate = i.getStringExtra("end_date");

        ArrayList<Camping> campingData = db.getCamping(camping_id);
        // Set camping name text
        TextView pay_camping = (TextView) findViewById(R.id.pay_camping_name);
        TextView pay_address = (TextView) findViewById(R.id.pay_address);
        TextView pay_date = (TextView) findViewById(R.id.pay_date);
        TextView pay_day = (TextView) findViewById(R.id.price_day);
        TextView price_people = (TextView) findViewById(R.id.price_people);
        TextView price_total = (TextView) findViewById(R.id.price_total);
        TextView price_reservation = (TextView) findViewById(R.id.pay_reservation);

        for (Camping camping : campingData){
            pay_camping.setText(camping.getName());
            pay_date.setText("Period: " + getStartDate + " - " + getEndDate);
            pay_address.setText(camping.getAddress());


            int price = camping.getPrice() * random_days_price;
            int people = 4 * random_people_price;
            int total = price + people;
            int price_res = total / 10;

            pay_day.setText(random_days_price + " x " + camping.getPrice() + " = " + price + " euro");
            price_people.setText("4 x " + random_people_price + " = " + people + " euro");
            price_total.setText("Total: " + total + " euro");
            price_reservation.setText("Payment for reservation is " + price_res + ",00 euro");
        }

        Button bookNow = (Button) findViewById(R.id.button_pay);
        bookNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(PayBookingActivity.this, MainActivity.class);

                db.addReservation(new Reservation(1,camping_id, getStartDate, getEndDate));
                startActivity(intent);
            }
        });
    }
}
