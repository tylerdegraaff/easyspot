package nl.hr.tylerdegraaff.easyspot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        DBHandler db = new DBHandler(this);

        // Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addCamping(new Camping(1, "Camping Tyler", "Campingweg 23"));
        db.addCamping(new Camping(2, "Camping Arno", "Wegweg"));
        db.addCamping(new Camping(3, "Camping Damian", "Straatstraat"));
        db.addCamping(new Camping(4, "Camping Chesney", "Megastraat"));

        // Reading all shops
        Log.d("Reading: ", "Reading all reservations..");
        List<Camping> campings = db.getAllCampings();

        for (Camping camping : campings) {
            String log = "Id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " + camping.getAddress();
            // Writing shops to log
            Log.d("Shop: : ", log);
        }
    }
}
