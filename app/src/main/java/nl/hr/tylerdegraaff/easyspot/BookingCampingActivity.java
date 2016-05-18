package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class BookingCampingActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_booking_camping);

        spinner = (Spinner)findViewById(R.id.plotOptions);
        myArrayAdapter = ArrayAdapter.createFromResource(this, R.array.dropdown_plot_options, android.R.layout.simple_spinner_dropdown_item);
        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(myArrayAdapter);
    }

    public void goToStepThree(View view){
        startActivity(new Intent(this, BookingMapActivity.class));
    }
}
