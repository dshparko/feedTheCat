package by.bsuir.dshparko.feedthecat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

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

    public void exitPressed(View view){


        Intent intent = new Intent(getApplicationContext(), SignOutActivity.class);
        startActivity(intent);
        finishAffinity();
    }



    public void signOut(View view) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        if(mGoogleSignInClient!=null) {


            mGoogleSignInClient.signOut()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            //Toast.makeText(MenuActivity.this, "Signed out", Toast.LENGTH_LONG).show();
                            finishAffinity();
                        }
                    });
        }else{
            finishAffinity();
        }
    }

    public void authPressed(View view){
        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
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
