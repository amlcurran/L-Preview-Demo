package uk.co.amlcurran.lpreviewdemo;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;

public class TransitionLargeImageActivity extends Activity {

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

    private static class HideRevealAtTouchListener implements View.OnTouchListener {

        private final View view;
        private float lastTouchX;
        private float lastTouchY;

        public HideRevealAtTouchListener(View view) {
            this.view = view;
        }

        @Override
        public boolean onTouch(final View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                lastTouchX = event.getX();
                lastTouchY = event.getY();
                int maxDimen = Math.max(view.getWidth(), view.getHeight());
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(view, (int) lastTouchX, (int) lastTouchY, maxDimen, 0);
                circularReveal.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                circularReveal.start();
            }
            return false;
        }
    }

    private class ShowRevealAtTouchListener implements View.OnTouchListener {
        private final View view;
        private float lastTouchX;
        private float lastTouchY;

        public ShowRevealAtTouchListener(View view) {
            this.view = view;
        }

        @Override
        public boolean onTouch(final View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                lastTouchX = event.getX();
                lastTouchY = event.getY();
                int maxDimen = Math.max(view.getWidth(), view.getHeight());
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(view, (int) lastTouchX, (int) lastTouchY, 0, maxDimen);
                circularReveal.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                circularReveal.start();
            }
            return false;
        }
    }
}
