package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.amlcurran.lpreviewdemo.animationassist.Colouriser;

public class DesaturateActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_large_image);
        imageView = (ImageView) findViewById(R.id.largeImage);
        imageView.setAlpha(0f);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                new Colouriser(imageView).colouriseIn();
            }
        }, 300);
    }

}
