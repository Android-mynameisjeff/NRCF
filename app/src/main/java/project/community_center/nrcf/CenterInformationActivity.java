package project.community_center.nrcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class CenterInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_information);
        //    //String name, String address, String phone, String website,
        // String activities, String hours, int picture
        //(ClassName) getIntent().getSerializableExtra("Editing");
        Intent intent = getIntent();
        Center center = (Center) getIntent().getSerializableExtra("center");
        //int centerIndex = (Integer) getIntent().getExtras().get("index");
        //String str = intent.getStringExtra("num");
        //Center center = Center.list[centerIndex];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(center.getName());

        TextView address = (TextView) findViewById(R.id.address);
        address.setText(center.getAddress());

        TextView phone = (TextView) findViewById(R.id.phone);
        phone.setText(center.getPhone());

        TextView website = (TextView) findViewById(R.id.website);
        website.setText(center.getWebsite());

        TextView activities = (TextView) findViewById(R.id.activities);
        activities.setText(center.getActivities());

        TextView hours = (TextView) findViewById(R.id.hours);
        hours.setText(center.getHours());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(center.getPicture());
    }
}
