package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MySpotMapActivity extends AppCompatActivity {

    private PopupWindow facilityPopUp;
    private PopupWindow RestaurantPopup;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_my_spot_map);
        relativeLayout = (RelativeLayout) findViewById(R.id.my_spot_map);
    }

    public void ClickFacility(View view) {

        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container1 = (ViewGroup)layoutInflater.inflate(R.layout.facility_popup, null);

        facilityPopUp = new PopupWindow(container1, 400, 200, false);
        facilityPopUp.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);

        ImageView closeWindow = (ImageView)container1.findViewById(R.id.close_window);

        closeWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facilityPopUp.dismiss();
            }
        });
    }

    public void ClickRestaurant(View view) {

        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container  = (ViewGroup)layoutInflater.inflate(R.layout.restaurant_popup, null);

        RestaurantPopup = new PopupWindow(container, 600, 800, false);
        RestaurantPopup.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);

        ImageView closeWindow = (ImageView)container.findViewById(R.id.closeWindow2);

        closeWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantPopup.dismiss();
            }
        });
    }
}
