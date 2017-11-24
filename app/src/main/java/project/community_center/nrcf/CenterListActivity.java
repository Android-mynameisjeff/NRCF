package project.community_center.nrcf;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CenterListActivity extends AppCompatActivity {

    private ListView lv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.list);

        String[] values = Center.nameslist;

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        ArrayAdapter<String> arrayAdapter = null;
        arrayAdapter = new ArrayAdapter<String>(CenterListActivity.this,
                android.R.layout.simple_list_item_1, list);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CenterListActivity.this, CenterInformationActivity.class);

                //String name = (String) lv.getAdapter().getItem(i);
                intent.putExtra("index", (int) l);
                startActivity(intent);
            }
        });
    }

}
