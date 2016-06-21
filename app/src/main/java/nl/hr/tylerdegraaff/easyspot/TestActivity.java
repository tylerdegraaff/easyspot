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
        db.addShop(new Shop(1, "Camping 1", "Campingweg 23"));
        db.addShop(new Shop(2, "Camping 2", "Wegweg"));
        db.addShop(new Shop(3, "Camping 3", "Straatstraat"));
        db.addShop(new Shop(4, "Camping 4", "Megastraat"));

        // Reading all shops
        Log.d("Reading: ", "Reading all reservations..");
        List<Shop> shops = db.getAllShops();

        for (Shop shop : shops) {
            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
            // Writing shops to log
            Log.d("Shop: : ", log);
        }
    }
}
