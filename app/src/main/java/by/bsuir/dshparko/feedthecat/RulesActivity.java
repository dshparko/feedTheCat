package by.bsuir.dshparko.feedthecat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.Objects;

public class RulesActivity extends AppCompatActivity {
    ViewPager viewPager;
    DotsIndicator dots;
    SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        getSupportActionBar().setTitle("Rules");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewPager = findViewById(R.id.view_pager);
        dots = findViewById(R.id.dots);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        dots.setViewPager(viewPager);
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
