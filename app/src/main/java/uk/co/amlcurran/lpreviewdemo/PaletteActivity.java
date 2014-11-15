package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_large_image);

        Drawable imageDrawable = ((ImageView) findViewById(R.id.largeImage)).getDrawable();
        Bitmap bitmap = ((BitmapDrawable) imageDrawable).getBitmap();
        Palette palette = Palette.generate(bitmap);

        int defaultNormal = getResources().getColor(R.color.primary);
        int defaultDark = getResources().getColor(R.color.primary_dark);

        int darkVibrantColor = palette.getDarkVibrantColor(defaultDark);
        int vibrantColor = palette.getVibrantColor(defaultNormal);

        getWindow().setStatusBarColor(darkVibrantColor);
        getActionBar().setBackgroundDrawable(new ColorDrawable(vibrantColor));
    }
}
