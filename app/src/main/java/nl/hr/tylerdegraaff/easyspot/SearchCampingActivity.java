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

//        db.addCamping(new Camping(1, "Camping Blue Sea", "France, Montpellier", R.drawable.camping1,
//                90325252, 120, "campingbluesea@info.fr","Relaxing place with an amazing blue sea. Come see the the beautiful fishes by yourself. Or are you afraid for the other creatures. The sharks won't eat you, we promise!", "Amazing blue sea, Restaurants, Shops"));
//        db.addCamping(new Camping(2, "Camping Holland", "France, Nice", R.drawable.camping2,
//                90852675, 95, "campingholland@info.fr", "For all the Dutch people, who needs a really nice holiday but also wants some Dutchies around them. Come do lots of sport activity and join our own EK poule.", "Sport activity, Restaurants, Dutch events"));
//        db.addCamping(new Camping(3, "Camping Karaoke", "France, Marseille", R.drawable.camping3,
//                90295062, 80, "campingkaraoke@info.fr","Screaming with your terrible voice, just come here en sing every song that you always wanted. Done with singing? Lets hangout out with some nice drinks!", "Karaoke bar, Kids place, Supermarket"));

        createListView();
        registerClickCallback();
    }

    public void Reservate(View v) {
        Intent intent = new Intent(this, CampingDetailActivity.class);
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
                Intent intent = new Intent(SearchCampingActivity.this, CampingDetailActivity.class);

                String imageId = String.valueOf(clickedCamping.getImage());
                String camping_id = String.valueOf(clickedCamping.getId());
                String phone = String.valueOf(clickedCamping.getPhone());
                String price = String.valueOf(clickedCamping.getPrice());

                intent.putExtra("name", clickedCamping.getName());
                intent.putExtra("image", imageId);
                intent.putExtra("address", clickedCamping.getAddress());
                intent.putExtra("description", clickedCamping.getDesc());
                intent.putExtra("phone", phone);
                intent.putExtra("email", clickedCamping.getEmail());
                intent.putExtra("facilities", clickedCamping.getFac());
                intent.putExtra("price", price);
                intent.putExtra("camping_id", camping_id);

                startActivity(intent);
                //String message = "You clicked on camping " + clickedCamping.getImage();
                //Toast.makeText(SearchCampingActivity.this, clickedCamping + message, Toast.LENGTH_LONG).show();
            }
        });
    }

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
                Camping currentCamping = campings.get(position);

                // Fill the view
                ImageView imageView = (ImageView)itemView.findViewById(R.id.camping_image);
                imageView.setImageResource(currentCamping.getImage());

                // Set camping name text
                TextView tv_name = (TextView) itemView.findViewById(R.id.camping_name);
                tv_name.setText(currentCamping.getName());

                // Set camping address text:
                TextView tv_address = (TextView) itemView.findViewById(R.id.camping_address);
                tv_address.setText(currentCamping.getAddress());

            return itemView;
        }
    }
}


