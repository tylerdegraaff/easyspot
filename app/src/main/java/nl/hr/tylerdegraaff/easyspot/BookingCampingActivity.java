package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class BookingCampingActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> myArrayAdapter;
    String getCampingId;
    String startdate_input, enddate_input;
    EditText booking_startdate, booking_enddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_booking_camping);
        spinner = (Spinner)findViewById(R.id.plotOptions);
        myArrayAdapter = ArrayAdapter.createFromResource(this, R.array.dropdown_plot_options, android.R.layout.simple_spinner_dropdown_item);
        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(myArrayAdapter);

        Intent i = getIntent();
        getCampingId = i.getStringExtra("camping_id");

        booking_startdate = (EditText)findViewById(R.id.booking_start_date);
        booking_enddate = (EditText)findViewById(R.id.booking_end_date);


        Button bookNow = (Button) findViewById(R.id.reservate3);
        bookNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(BookingCampingActivity.this, BookingMapActivity.class);

                startdate_input = booking_startdate.getText().toString();
                enddate_input = booking_enddate.getText().toString();

                intent.putExtra("camping_id", getCampingId);
                intent.putExtra("start_date", startdate_input);
                intent.putExtra("end_date", enddate_input);
                Log.d("", "CampingID: " + getCampingId);
                Log.d("", "Start + End: " + startdate_input+ " - " + enddate_input);
                startActivity(intent);
            }
        });
    }
}
