package nl.hr.tylerdegraaff.easyspot;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MySpotCommunityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_spot_community);
    }

    public void seeDetailFrans(View v) {
        Intent intent = new Intent(this, FransBauerEvent.class);
        startActivity(intent);
    }

}
