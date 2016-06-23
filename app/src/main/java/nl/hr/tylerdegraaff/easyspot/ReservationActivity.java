package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        registerClickCallback();
    }
    private void createListView() {
        ArrayAdapter<Reservation> adapter = new myListAdapter();
        ListView list = (ListView) findViewById(R.id.lvReservations);
        list.setAdapter(adapter);
    }

    private void registerClickCallback(){
        ListView list = (ListView) findViewById(R.id.lvReservations);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {
                Reservation clickedReservation = reservations.get(position);
                Intent intent = new Intent(ReservationActivity.this, ReservationDetailActivity.class);

                String reservation_id = String.valueOf(clickedReservation.getId());
                String camping_id = String.valueOf(clickedReservation.getCampingId());
                intent.putExtra("reservation_id", reservation_id);
                intent.putExtra("camping_id", camping_id);

                startActivity(intent);
                //String message = "You clicked on camping " + clickedReservation.getStart_date();
                //Toast.makeText(ReservationActivity.this, clickedReservation + message, Toast.LENGTH_LONG).show();
            }
        });
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

            TextView tv_camping_name = (TextView)itemView.findViewById(R.id.reservation_camping_name);

            ArrayList<Camping> campingData = db.getCamping(campingId);
            for (Camping camping : campingData){
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
