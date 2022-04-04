package by.bsuir.dshparko.feedthecat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.Objects;

public class NickNameActivity extends AppCompatActivity {


    static String nick="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        EditText editText = findViewById(R.id.name);

        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s);
                String ss=""+s;
               nick =  ss;
            }
        });
    }

    public static String getNick(){
        return nick;
    }
    public void auth(View view){
        Intent intent1  =new Intent(this,GameActivity.class);
        startActivity(intent1);
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
