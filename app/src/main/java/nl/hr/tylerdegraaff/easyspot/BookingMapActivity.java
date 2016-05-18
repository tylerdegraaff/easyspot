package nl.hr.tylerdegraaff.easyspot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BookingMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_booking_map);
    }

    public void SpotSelected(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.spot_selected, Toast.LENGTH_SHORT);
        toast.show();
    }
}
