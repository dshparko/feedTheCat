package by.bsuir.dshparko.feedthecat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class GameActivity extends AppCompatActivity {

    Animation animation;
    private TextView satiety_textView;
    private int clicks = 0;
    private String personName;
    final String FILENAME = "achievements";
    private Animation animation_cat;
    private ImageView imageView;
    AnimationDrawable frameAnimation;

    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Game");
        setContentView(R.layout.activity_game);

        satiety_textView = findViewById(R.id.score);
        imageView=findViewById(R.id.cat);
        imageView.setBackgroundResource(R.drawable.animation);
        frameAnimation = (AnimationDrawable) imageView.getBackground();
        name = findViewById(R.id.name);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        String s = NickNameActivity.getNick();
        if(s!=""){
            personName =s;
            name.setText(s);
        }
        else if (acct != null) {
            personName = acct.getDisplayName();
            name.setText(personName);
        }
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


    public void shareClick(View view){
        String count = String.valueOf(clicks);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareRes = "Результат "+personName+" в FeedTheCat: " + count + " очков сытости.";

        shareIntent.putExtra(Intent.EXTRA_TEXT,shareRes);
        startActivity(Intent.createChooser(shareIntent,"SHARE"));
    }
    public void writeFile(String filename,String text) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(filename, MODE_APPEND)));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveScore(View view){

        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);
        writeFile("results",personName+"|"+format+"|" + clicks+"\n");
    }

    public void feed_button_click(View view) {
        clicks++;
        satiety_textView.setText(String.valueOf(clicks));
        if (clicks % 15 == 0) {
            if(!frameAnimation.isRunning()) {
                                frameAnimation.setVisible(true,true);
                frameAnimation.start();
            }
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);


        }
        else if(frameAnimation.isRunning()){
            frameAnimation.setVisible(false,false);
            frameAnimation.stop();
      }
    }

}
