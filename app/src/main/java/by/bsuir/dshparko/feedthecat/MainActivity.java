package by.bsuir.dshparko.feedthecat;

import static android.view.Window.FEATURE_NO_TITLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int progress = 0;
    private ProgressBar pbHorizontal;
    private TextView tvProgressHorizontal;
    private TextView tvProgressCircle;
    private final Handler handler = new Handler();
    private Timer timer = new Timer();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        pbHorizontal = (ProgressBar) findViewById(R.id.progress);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        checkAnimationEnding();
                    }
                });
            }
        }, 0, 20);
    }


    private void checkAnimationEnding(){
        if ( pbHorizontal.getProgress()==100 ){

            timer.cancel();
            timer = null;
            System.out.println("Completed");

        }
    }

}