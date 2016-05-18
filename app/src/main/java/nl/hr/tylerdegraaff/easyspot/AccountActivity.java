package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_account);
    }

    public void onSave(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast toast = Toast.makeText(this, "Account saved", Toast.LENGTH_SHORT);
        toast.show();
    }
}
