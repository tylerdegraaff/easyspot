package nl.hr.tylerdegraaff.easyspot;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MySpotMainActivity extends TabActivity {

    private TabWidget myTabWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost myTabHost = getTabHost();
        myTabWidget = myTabHost.getTabWidget();

        myTabHost.addTab(myTabHost.newTabSpec("profile").setIndicator("Profile").setContent(new Intent(this, MySpotProfileActivity.class)));
        myTabHost.addTab(myTabHost.newTabSpec("map").setIndicator("Map").setContent(new Intent(this, MySpotMapActivity.class)));
        myTabHost.addTab(myTabHost.newTabSpec("community").setIndicator("Community").setContent(new Intent(this, MySpotCommunityActivity.class)));

        changeTabs();
    }

    public void changeTabs() {
        for(int i=0; i < myTabWidget.getChildCount(); i++){
            myTabWidget.getChildAt(i).setBackgroundResource(R.drawable.tab_selector);
        }
    }
}
