package project.community_center.nrcf;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * User can search for centres that offer an activity.
 * This retrieves an ArrayList to send to SearchResultsActivity.
 */
public class SearchActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private DbHelper helper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new DbHelper(this);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchView = (EditText) findViewById(R.id.search);
                TextView messageView = (TextView) findViewById(R.id.message);

                String search = searchView.getText().toString();
                ArrayList<Center> searchList = null;

                if(search.length() != 0) {
                    db = helper.getReadableDatabase();
                    searchList = helper.getSearch(search);
                    if(!searchList.isEmpty()) {
                        Intent i = new Intent(SearchActivity.this, SearchResultsActivity.class);
                        i.putExtra("search", searchList);
                        startActivity(i);
                    } else {
                        messageView.setText("Search again");
                    }
                }
            }
        });
    }
}
