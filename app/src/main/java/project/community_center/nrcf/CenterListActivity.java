package project.community_center.nrcf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CenterListActivity extends AppCompatActivity {
    private ListView lv = null;
    final private DbHelper helper = new DbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.list);

        final ArrayList<Center> centerList = helper.getCenters();
        ArrayList<String> centerNames = new ArrayList<String>();

        /**
         * grabs all names of centers for the listview
         */
        for (Center c: centerList) {
            centerNames.add(c.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CenterListActivity.this,
                android.R.layout.simple_list_item_1, centerNames);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CenterListActivity.this, CenterInformationActivity.class);

                String name = (String) lv.getAdapter().getItem(i);
                intent.putExtra("center", helper.getCenter(name));
                startActivity(intent);
            }
        });
    }

}
