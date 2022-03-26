package by.bsuir.dshparko.feedthecat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AuthorizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Authorization");
        setContentView(R.layout.activity_auth);

    }

}
