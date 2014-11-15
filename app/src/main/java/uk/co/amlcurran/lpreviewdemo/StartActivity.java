package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StartActivity extends Activity {

    private static final String[] SELECTION_ITEMS = new String[] {
            "Widgets", "Themed widgets", "Transitions", "Circular reveal", "CardView"
    };
    private static final int[] SELECTION_ICONS = new int[] {
            R.drawable.ic_widgets,
            R.drawable.ic_create,
            R.drawable.ic_input,
            R.drawable.ic_circular,
            R.drawable.ic_cards };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ListView listView = ((ListView) findViewById(R.id.listView));
        listView.setAdapter(new FixedAdapter(this));
        listView.setOnItemClickListener(new MoveToNextListener());
    }

    private class FixedAdapter extends ArrayAdapter<String> {

        private final int drawablePadding;

        public FixedAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
            addAll(SELECTION_ITEMS);
            drawablePadding = getResources().getDimensionPixelOffset(R.dimen.padding);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) super.getView(position, convertView, parent);
            int selectionIconId = SELECTION_ICONS[position];
            if (selectionIconId != 0) {
                Drawable image = getResources().getDrawable(selectionIconId);
                image.setTint(getResources().getColor(R.color.primary));
                textView.setCompoundDrawablePadding(drawablePadding);
                textView.setCompoundDrawablesWithIntrinsicBounds(image, null, null, null);
            }
            return textView;
        }
    }

    private class MoveToNextListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    startActivity(DefaultThemeWidgetsActivity.class);
                    break;
                case 1:
                    startActivity(CustomThemeWidgetsActivity.class);
                    break;
                case 2:
                    startActivity(TransitionEntryActivity.class);
                    break;
                case 3:
                    startActivity(TransitionLargeImageActivity.class);
                    break;
                case 4:
                    startActivity(StateListAnimationActivity.class);
                    //startActivity(CardViewActivity.class);
                    break;
            }
        }

    }

    private void startActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
