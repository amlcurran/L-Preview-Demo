package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import uk.co.amlcurran.lpreviewdemo.animationassist.HideRevealAtTouchListener;
import uk.co.amlcurran.lpreviewdemo.animationassist.ShowRevealAtTouchListener;

public class CircularRevealImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_transition_large_image);

        View firstImage = findViewById(R.id.imageView);
        View secondImage = findViewById(R.id.imageView2);

        firstImage.setOnTouchListener(new HideRevealAtTouchListener(firstImage));
        secondImage.setOnTouchListener(new ShowRevealAtTouchListener(firstImage));
    }

}
