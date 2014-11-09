package uk.co.amlcurran.lpreviewdemo.animationassist;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;

public class HideRevealAtTouchListener implements View.OnTouchListener {

    private final View view;

    public HideRevealAtTouchListener(View view) {
        this.view = view;
    }

    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            float lastTouchX = event.getX();
            float lastTouchY = event.getY();
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
