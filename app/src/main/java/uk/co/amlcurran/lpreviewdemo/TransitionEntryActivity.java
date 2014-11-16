package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class TransitionEntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //getWindow().setExitTransition(new Explode());
//        getWindow().setAllowEnterTransitionOverlap(true);
//        getWindow().setAllowReturnTransitionOverlap(true);

        setContentView(R.layout.activity_transition_entry);
        findViewById(R.id.imageView).setOnClickListener(
                new TransitionClickListener(this));
    }

    private class TransitionClickListener implements View.OnClickListener {

        private final Activity activity;

        public TransitionClickListener(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, TransitionLargeImageActivity.class);
            ActivityOptions activityOptions = ActivityOptions
                    .makeSceneTransitionAnimation(activity, view, "kitten");
            startActivity(intent, activityOptions.toBundle());
        }
    }
}
