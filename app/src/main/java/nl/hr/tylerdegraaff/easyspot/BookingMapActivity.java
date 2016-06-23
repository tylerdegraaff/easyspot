package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BookingMapActivity extends AppCompatActivity {

    private PopupWindow selectedPlotPopUp;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;

    String getCampingId, getStartDate, getEndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_booking_map);
        relativeLayout = (RelativeLayout) findViewById(R.id.mapRelativeLayout);

        Intent i = getIntent();
        getCampingId = i.getStringExtra("camping_id");
        getStartDate = i.getStringExtra("start_date");
        getEndDate = i.getStringExtra("end_date");

        //Log.d("", "ID: " + getCampingId + " Start: " + getStartDate + " End: " + getEndDate  );
    }

    public void SpotSelected(View view) {

        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.selected_plot_popup, null);

        selectedPlotPopUp = new PopupWindow(container, 600, 300, true);
        selectedPlotPopUp.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);

        TextView cancel = (TextView) container.findViewById(R.id.cancel_plot);
        TextView save = (TextView) container.findViewById(R.id.save_plot);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPlotPopUp.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PayBookingActivity.class);
                intent.putExtra("camping_id", getCampingId);
                intent.putExtra("start_date", getStartDate);
                intent.putExtra("end_date", getEndDate);
                Log.d("", "CampingID: " + getCampingId + " Start: " + getStartDate + " End " + getEndDate);
                selectedPlotPopUp.dismiss();
                startActivity(intent);
            }
        });
    }
}
