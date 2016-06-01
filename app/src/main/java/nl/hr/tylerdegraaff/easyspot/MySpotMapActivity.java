package nl.hr.tylerdegraaff.easyspot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MySpotMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_my_spot_map);
    }
}
