package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class TransitionLargeImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_single_large_image);
    }

}
