package nl.hr.tylerdegraaff.easyspot;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        DBHandler db = new DBHandler(this);

        // List for campings
        ArrayList<Camping> campings = db.getAllCampings();
        ArrayList<String> campingNameList;


        // Get one camping section
        ArrayList<Camping> onecampong = db.getCamping(1);
        for (Camping camping : onecampong){
            String log = "id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " +
                    camping.getAddress() + " ,Image: " + camping.getImage() +
                    " ,Phone: " + camping.getPhone() + " ,Price: " + camping.getPrice() +
                    " ,Email: " + camping.getEmail() + " ,Description: " + camping.getDesc() +
                    " ,Facitilitiess: " + camping.getFac();
            Log.d("------", log + "------");
        }
        

        /*
        db.addCamping(new Camping(1, "fdfsfsd", "Adress", 1, 123124234, 123, "fasfas@23.com", "heel veel ruimte", "bier, en nog meer bier"));
        db.addCamping(new Camping(2, "otrto", "DJSAD", 2, 98765454, 87, "opop@klfsd.com", "stoer,stoer", "wij willen alleen maar dronken zijn"));
        // Get the reference of ListViewCampings
        ListView campingList=(ListView)findViewById(R.id.listViewCampings);
        campingNameList = new ArrayList<String>();
        for (Camping camping : campings) {
            // Log for debug use
            String log = "Id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " +
                    camping.getAddress() + " ,Image: " + camping.getImage() +
                    " ,Phone: " + camping.getPhone() + " ,Price: " + camping.getPrice() +
                    " ,Email: " + camping.getEmail() + " ,Description: " + camping.getDesc() +
                    " ,Facitilitiess: " + camping.getFac();
            // Log.d("------", log + "------");

            // Getting the name and adress
            String name = camping.getName();
            String adress = camping.getAddress();
            Integer image = camping.getImage();
            Integer phone = camping.getPhone();
            Integer price = camping.getPrice();
            String email = camping.getEmail();
            String desc = camping.getDesc();
            String fac = camping.getFac();

            // Add the camping to the list
            campingNameList.add("Camping naam:" + name);
            campingNameList.add("Camping adress:" + adress);
            campingNameList.add("Camping image:" + image);
            campingNameList.add("Camping phone:" + phone);
            campingNameList.add("Camping price:" + price);
            campingNameList.add("Camping email:" + email);
            campingNameList.add("Camping desc:" + desc);
            campingNameList.add("Camping fac:" + fac);
        }

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, campingNameList);
        // Set The Adapter
        campingList.setAdapter(arrayAdapter);
        *.


        /* THIS IS FOR RESERVATIONS
         db.addReservation(new Reservation(1, 12));
         // List for reservations
         ArrayList<Reservation> reservations = db.getAllReservations();
         ArrayList<String> reservationCampingList;
         // List for reservation
        ListView reservationList=(ListView)findViewById(R.id.listViewCampings);
        reservationCampingList = new ArrayList<String>();
        for (Reservation reservation : reservations) {
            // Log for debug use
            String log = "Id: " + reservation.getId() + " ,camping_id: " + reservation.getCampingId();
            Log.d("------", log + "------");

            Integer campingid = reservation.getCampingId();

            // Add the camping to the list
            reservationCampingList.add("Camping id:" + campingid);
        }

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, reservationCampingList);
        // Set The Adapter
        reservationList.setAdapter(arrayAdapter);
        */

    }
}
