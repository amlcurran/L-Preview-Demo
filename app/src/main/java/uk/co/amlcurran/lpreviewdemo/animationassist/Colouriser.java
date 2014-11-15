package uk.co.amlcurran.lpreviewdemo.animationassist;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Colouriser {

    private final ImageView imageView;
    private final ColorMatrix colourMatrix;

    public Colouriser(ImageView imageView) {
        this.imageView = imageView;
        this.colourMatrix = new ColorMatrix();
    }

    public void colouriseIn() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1);
        alpha.start();
        ObjectAnimator saturation = ObjectAnimator.ofFloat(colourMatrix, "saturation", 0, 1);
        saturation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView.setColorFilter(new ColorMatrixColorFilter(colourMatrix));
            }
        });
        saturation.setInterpolator(AnimationUtils.loadInterpolator(imageView.getContext(), android.R.interpolator.linear_out_slow_in));
        saturation.setDuration(900);
        saturation.start();
    }

}
