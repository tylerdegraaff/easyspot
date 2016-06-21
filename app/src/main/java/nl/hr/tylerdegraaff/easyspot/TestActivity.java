package nl.hr.tylerdegraaff.easyspot;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        DBHandler db = new DBHandler(this);
         ArrayList<Camping> campings = db.getAllCampings();

        ArrayList<String> campingNameList;

        db.addCamping(new Camping(1, "fdfsfsd", "Adress", 1));
        db.addCamping(new Camping(2, "Biervat", "Straatnaam", 2));
        db.addCamping(new Camping(3, "Indonesie", "Wegnaam", 3));
        db.addCamping(new Camping(3, "Indonesie", "Wegnaam", 4));

        // Get the reference of ListViewAnimals
        ListView campingList=(ListView)findViewById(R.id.listViewCampings);
        campingNameList = new ArrayList<String>();
        for (Camping camping : campings) {
            // Log for debug use
            String log = "Id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " + camping.getAddress() + " ,Image: " + camping.getImage();
            Log.d("------", log + "------");
            // Getting the name and adress
            String name = camping.getName();
            String adress = camping.getAddress();
            Integer image = camping.getImage();

            // Add the camping to the list
            campingNameList.add("Camping naam:" + name);
            campingNameList.add("Camping adress:" + adress);
            campingNameList.add("Camping image:" + image);
        }

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, campingNameList);
        // Set The Adapter
        campingList.setAdapter(arrayAdapter);
    }
}
