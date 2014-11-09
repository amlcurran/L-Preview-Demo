package uk.co.amlcurran.lpreviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartActivity extends Activity {

    private static final String[] SELECTION_ITEMS = new String[] {
            "Widgets", "Themed widgets", "Transitions", "Circular reveal", "CardView"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ListView listView = ((ListView) findViewById(R.id.listView));
        listView.setAdapter(new FixedAdapter(this));
        listView.setOnItemClickListener(new MoveToNextListener());
    }

    private class FixedAdapter extends ArrayAdapter<String> {

        public FixedAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
            addAll(SELECTION_ITEMS);
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
                    startActivity(CardViewActivity.class);
                    break;
            }
        }

    }

    private void startActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
