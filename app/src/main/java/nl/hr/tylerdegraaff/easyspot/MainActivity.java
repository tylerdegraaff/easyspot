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

//        DBHandler db = new DBHandler(this);
//
//        db.addReservation(new Reservation(1, 1, "05 Aug 2016", "17 Aug 2016"));
//        db.addReservation(new Reservation(2, 2, "03 Aug 2016", "15 Aug 2016"));
//        db.addReservation(new Reservation(2, 3, "06 Aug 2016", "18 Aug 2016"));
//
//
//        db.addCamping(new Camping(1, "Camping Blue Sea", "France, Montpellier", R.drawable.camping1,
//                90325252, 120, "campingbluesea@info.fr", "Relaxing place with an amazing blue sea. " +
//                "Come see the the beautiful fishes by yourself. Or are you afraid for the other creatures. The sharks won't eat you, we promise!",
//                "Amazing blue sea, Restaurants, Shops"));
//        db.addCamping(new Camping(2, "Camping Hollandia", "France, Nice", R.drawable.camping2,
//                90852675, 95, "campingholland@info.fr", "For all the Dutch people, who needs a really nice holiday but also wants some Dutchies around them. " +
//                "Come do lots of sport activity and join our own EK poule.", "Sport activity, Restaurants, Dutch events"));
//        db.addCamping(new Camping(3, "Camping Karaoke", "France, Marseille", R.drawable.camping3,
//                90295062, 80, "campingkaraoke@info.fr", "Screaming with your terrible voice, just come here en sing every song that you always wanted. " +
//                "Done with singing? Lets hangout out with some nice drinks!", "Karaoke bar, Kids place, Supermarket"));
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
