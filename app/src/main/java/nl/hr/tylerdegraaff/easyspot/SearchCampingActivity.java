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

                String camping_id = String.valueOf(clickedCamping.getId());
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


