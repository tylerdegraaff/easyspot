package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReservationActivity extends AppCompatActivity {

    private ArrayList<Reservation> reservations;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reservation);

        db = new DBHandler(this);
        reservations = db.getAllReservations();

        createListView();
    }

    public void detailPage(View v){
        Intent intent = new Intent(this, ReservationDetailActivity.class);
        startActivity(intent);
    }

    private void createListView() {
        ArrayAdapter<Reservation> adapter = new myListAdapter();
        ListView list = (ListView) findViewById(R.id.lvReservations);
        list.setAdapter(adapter);
    }

    public class myListAdapter extends ArrayAdapter<Reservation> {

        public myListAdapter() {
            super(ReservationActivity.this, R.layout.reservations_listview, reservations);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.reservations_listview, parent, false);
            }
            Reservation currentReservation = reservations.get(position);

            Integer campingId = currentReservation.getCampingId();

            Log.d("", "id:  " + currentReservation.getId() + " camping id " + currentReservation.getCampingId() + " start and end " + currentReservation.getStart_date() + currentReservation.getEnd_date() );

            //ArrayList<Camping> campingData = db.getCamping(campingId);
            TextView tv_camping_name = (TextView)itemView.findViewById(R.id.reservation_camping_name);

            ArrayList<Camping> onecampong = db.getCamping(1);
            for (Camping camping : onecampong){
                String log = "id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " +
                        camping.getAddress() + " ,Image: " + camping.getImage() +
                        " ,Phone: " + camping.getPhone() + " ,Price: " + camping.getPrice() +
                        " ,Email: " + camping.getEmail() + " ,Description: " + camping.getDesc() +
                        " ,Facitilitiess: " + camping.getFac();
                Log.d("------", log + "------");

                tv_camping_name.setText(camping.getName());
            }

            // Set reservation datetime text:
            TextView tv_dateTime = (TextView) itemView.findViewById(R.id.reservation_time);
            tv_dateTime.setText("Start: " + currentReservation.getStart_date() + "  End: " + currentReservation.getEnd_date());

            return itemView;
        }
    }
}
