package project.community_center.nrcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    private ListView lv = null;
    final private DbHelper helper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.list);
/*
        Intent intent = getIntent();
        ArrayList<EventMaster> eventList = (ArrayList<EventMaster>)intent.getSerializableExtra("search");
 */
        Intent intent = getIntent();
        final ArrayList<Center> centerList = (ArrayList<Center>) intent.getSerializableExtra("search");
        ArrayList<String> centerNames = new ArrayList<String>();

        for (Center c: centerList) {
            centerNames.add(c.getName());
        }
        /*for (int i = 0; i < centerList.size(); ++i) {
            names[i] = centerList.get(i).getName();
        }*/
        //String[] values = Center.nameslist;
        //String[] values = helper.getNames();

        /*final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }*/

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SearchResultsActivity.this,
                android.R.layout.simple_list_item_1, centerNames);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SearchResultsActivity.this, CenterInformationActivity.class);

                String name = (String) lv.getAdapter().getItem(i);
                //intent.putExtra("index", (int) l);
                //intent.putExtra("center", centerList.get((int) l));
                intent.putExtra("center", helper.getCenter(name));

                startActivity(intent);
            }
        });
    }
}
