package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        //db.addReservation(new Reservation(1, 1, "05 Aug 2016", "17 Aug 2016"));
        //db.addReservation(new Reservation(2, 2, "03 Aug 2016", "15 Aug 2016"));
        //db.addReservation(new Reservation(2, 3, "06 Aug 2016", "18 Aug 2016"));
    }

    public void onSearchCamping(View v){
        Intent intent = new Intent(this, SearchCampingActivity.class);
        startActivity(intent);
    }

    public void onAccount(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onReservations(View v){
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }

    public void onMySpot(View v){
        Intent intent = new Intent(this, MySpotMainActivity.class);
        startActivity(intent);
    }
}
