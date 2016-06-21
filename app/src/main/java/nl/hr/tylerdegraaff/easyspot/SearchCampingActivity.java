package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchCampingActivity extends AppCompatActivity {

    private ArrayList<Camping> campings;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_search_camping);

        db = new DBHandler(this);
        campings = db.getAllCampings();

        db.addCamping(new Camping(1, "Camping Tyler", "Campingweg 23",));
        createListView();
        registerClickCallback();
    }

    public void Reservate(View v) {
        Intent intent = new Intent(this, BookingKaraokeActivity.class);
        startActivity(intent);
    }

    private void createListView() {
        ArrayAdapter<Camping> adapter = new myListAdapter();
        ListView list = (ListView) findViewById(R.id.lvCampings);
        list.setAdapter(adapter);
    }

    private void registerClickCallback(){
        ListView list = (ListView) findViewById(R.id.lvCampings);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Camping clickedCamping = campings.get(position);
                String message = "You clicked on camping " + clickedCamping.getName();
                Toast.makeText(SearchCampingActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void fillListViewWithCampings()
//    {
//        //db.addCamping(new Camping(1, "Camping Blue Sea", "France, Montpellier, Quteare zou 23"));
//        //db.addCamping(new Camping(2, "Camping Holland", "France, Nice, Zaig veg qou 717"));
//        //db.addCamping(new Camping(3, "Camping Karaoke", "France, Marseille, Kaloged-aouf 98"));
//
//        campingNameList = new ArrayList<String>();
//        for (Camping camping : campings) {
//
//            //db.deleteCamping(camping);
//
//            // Log for debug use
//            String log = "Id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " + camping.getAddress();
//
//            // Getting the name and adress
//            String name = camping.getName();
//            String adress = camping.getAddress();
//
//            // Add the camping to the list
//            //campingNameList.add("Camping Id:" + camping.getId());
//            campingNameList.add(name);
//            campingNameList.add(adress);
//        }
//
//        // Create The Adapter with passing ArrayList as 3rd parameter
//        ArrayAdapter<String> arrayAdapter =
//                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, campingNameList);
//        // Set The Adapter
//        campingList.setAdapter(arrayAdapter);
//    }

    public class myListAdapter extends ArrayAdapter<Camping> {
        public myListAdapter() {
            super(SearchCampingActivity.this, R.layout.camping_listview, campings);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.camping_listview, parent, false);
            }

            // Loop trough all Campings en fill the TextViews
            for (Camping camping : campings) {
                // Log for debug use
                String log = "Id: " + camping.getId() + " ,Name: " + camping.getName() + " ,Address: " + camping.getAddress();

                // Fill the view
                ImageView imageView = (ImageView)itemView.findViewById(R.id.camping_image);
                imageView.setImageResource(camping.getImage());

                // Getting the name and address
                String name = camping.getName();
                String address = camping.getAddress();

                // Set camping name text
                TextView tv_name = (TextView) itemView.findViewById(R.id.camping_name);
                tv_name.setText(name);

                // Set camping address text:
                TextView tv_address = (TextView) itemView.findViewById(R.id.camping_address);
                tv_address.setText(address);
            }
            return itemView;
        }
    }
}


