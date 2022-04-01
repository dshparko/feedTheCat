package by.bsuir.dshparko.feedthecat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Menu");

        setContentView(R.layout.activity_menu);

    }

    public void aboutPressed(View view){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }



    public void authPressed(View view){
        Intent intent = new Intent(getApplicationContext(), AuthorizationActivity.class);
        startActivity(intent);
    }

    public void resultsPressed(View view){
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(intent);
    }

    public void rulesPressed(View view){
        Intent intent = new Intent(getApplicationContext(), RulesActivity.class);
        startActivity(intent);
    }
}
