package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);
    }

    public void onLogin(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void SignUp(View view){
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}
