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
            int lastTouchX = (int) event.getX();
            int lastTouchY = (int) event.getY();
            int maxDimen = Math.max(view.getWidth(), view.getHeight());
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(view, lastTouchX, lastTouchY, maxDimen, 0);
            circularReveal.addListener(new SetVisiblityGoneWhenFinishedListener());
            circularReveal.start();
        }
        return false;
    }

    private class SetVisiblityGoneWhenFinishedListener implements Animator.AnimatorListener {
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
    }
}
