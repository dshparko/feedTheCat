package by.bsuir.dshparko.feedthecat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SliderAdapter extends PagerAdapter {

    private final Context context;
    private LayoutInflater layoutInflater;
    private final Integer[] images = {R.drawable.auth,
            R.drawable.feed,
            R.drawable.cat3,
            R.drawable.share,
            R.drawable.save};
    private final String[] HEADERS = { "You can authorization with google account or input nickname",
            "Press the 'Feed' button",
            "Every 15 points you will watch animation",
                        "You can share score with your friends!",
            "You can save result",
    };

    SliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    private TextView text;
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.firstlayout, null);

        text = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(images[position]);
        text.setText(HEADERS[position]);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view= (View) object;
        viewPager.removeView(view);
    }
}
