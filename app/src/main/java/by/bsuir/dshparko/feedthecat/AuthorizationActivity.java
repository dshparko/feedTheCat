package by.bsuir.dshparko.feedthecat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class AuthorizationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Authorization");
        setContentView(R.layout.activity_auth);


    }

    public void signInG(View view){
          Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
           startActivity(intent);
    }

    public void signOut(View view){
        Intent intent = new Intent(getApplicationContext(), SignOutActivity.class);
        startActivity(intent);
    }


    public void inputName(View view){
        Intent intent = new Intent(getApplicationContext(), NickNameActivity.class);
        startActivity(intent);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent1  =new Intent(this,MenuActivity.class);
                startActivity(intent1);
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }


}
