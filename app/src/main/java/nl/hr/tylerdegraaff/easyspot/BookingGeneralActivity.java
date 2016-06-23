package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BookingGeneralActivity extends AppCompatActivity {

    String getCampingId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_general_booking);

        Intent i = getIntent();
        getCampingId = i.getStringExtra("camping_id");

        Button bookNow = (Button) findViewById(R.id.reservate2);
        bookNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(BookingGeneralActivity.this, BookingCampingActivity.class);
                intent.putExtra("camping_id", getCampingId);
                Log.d("", "CampingID: " + getCampingId);
                startActivity(intent);
            }
        });
    }
}
