package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

public class TransitionLargeImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_transition_large_image);
    }
}
