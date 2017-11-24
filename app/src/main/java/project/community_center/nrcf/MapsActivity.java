package project.community_center.nrcf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private int clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker for Fraserside_Community_Services and move the camera (from excel (Y,X))
        LatLng Fraserside_Community_Services = new LatLng(49.21221745, -122.9204555);
        Marker mFraserside_Community_Services;

        // Add a marker for New Westminster Community Schools
        LatLng Community_Schools = new LatLng(49.20047229, -122.9163643);
        Marker mCommunity_Schools;

        // Add a marker for Park Canada Games Pool
        LatLng Canada_Games_Pool = new LatLng(49.22158156, -122.9072388);
        Marker mCanada_Games_Pool;

        // Add a marker for Park Centennial Community Centre
        LatLng Centennial_Community_Centre = new LatLng(49.20047229, -122.9163643);
        Marker mCentennial_Community_Centre;

        // Add a marker for Park Century House
        LatLng Century_House = new LatLng(49.21175625, -122.9260286);
        Marker mCentury_House;

        // Add a marker for Park Hume Park Outdoor Pool
        LatLng Hume_Park_Outdoor_Pool = new LatLng(49.23318782, -122.8917456);
        Marker mHume_Park_Outdoor_Pool;

        // Add a marker for Park  Moody Park Outdoor Pool
        LatLng Moody_Park_Outdoor_Pool = new LatLng(49.21131824, -122.9281635);
        Marker mMoody_Park_Outdoor_Pool;

        // Add a marker for Park Moody Park Arena
        LatLng Moody_Park_Arena = new LatLng(49.21556332, -122.9261784);
        Marker mMoody_Park_Arena;

        // Add a marker for Park  Museum and Archives
        LatLng Museum_and_Archives = new LatLng(49.20179605, -122.9111991);
        Marker mMuseum_and_Archives;


        // Add a marker for Park Queens Park Arena
        LatLng Queens_Park_Arena = new LatLng(49.21482699, -122.9057725);
        Marker mQueens_Park_Arena;

        // Add a marker for Park Queens Park Arenex
        LatLng Queens_Park_Arenex = new LatLng(49.21447285, -122.9034521);
        Marker mQueens_Park_Arenex;

        // Add a marker for Queensborough Community Centre
        LatLng Queensborough_Community_Centre = new LatLng(49.18588393, -122.9436169);
        Marker mQueensborough_Community_Centre;

        // Add a marker for Park Youth Centre
        LatLng Youth_Centre = new LatLng(49.21175625, -122.9260286);
        Marker mYouth_Centre;

        // .showInfoWindow();

        // Add some markers to the map, and add a data object to each marker.
        mFraserside_Community_Services = mMap.addMarker(new MarkerOptions().position(Fraserside_Community_Services).title("Fraserside Community Services - Subsidy Programs"));
      //  mFraserside_Community_Services.showInfoWindow();
        mFraserside_Community_Services.setTag(0);

        mCommunity_Schools = mMap.addMarker(new MarkerOptions().position(Community_Schools).title("Community Schools"));
      //  mCommunity_Schools.showInfoWindow();
        mCommunity_Schools.setTag(0);

        mCanada_Games_Pool = mMap.addMarker(new MarkerOptions().position(Canada_Games_Pool).title("Canada Games Pool"));
      //  mCanada_Games_Pool.showInfoWindow();
        mCanada_Games_Pool.setTag(0);

        mYouth_Centre = mMap.addMarker(new MarkerOptions().position(Youth_Centre).title("New Westminster Youth Centre"));
       // mYouth_Centre.showInfoWindow();
        mYouth_Centre.setTag(0);

//        mMap.addMarker(new MarkerOptions().position(Centennial_Community_Centre).title("Centennial Community Centre"));
//        mMap.addMarker(new MarkerOptions().position(Century_House).title("Century House"));
//        mMap.addMarker(new MarkerOptions().position(Hume_Park_Outdoor_Pool).title("Hume Park Outdoor Pool"));
//        mMap.addMarker(new MarkerOptions().position(Moody_Park_Outdoor_Pool).title("Moody Park Outdoor Pool"));
//        mMap.addMarker(new MarkerOptions().position(Moody_Park_Arena).title("Moody Park Arena"));
//        mMap.addMarker(new MarkerOptions().position(Museum_and_Archives).title("Museum and Archives"));
//        mMap.addMarker(new MarkerOptions().position(Queens_Park_Arena).title("Queens Park Arena"));
//        mMap.addMarker(new MarkerOptions().position(Queens_Park_Arenex).title("Community Schools"));
//        mMap.addMarker(new MarkerOptions().position(Queensborough_Community_Centre).title("Queensborough Community Centre"));
//        mMap.addMarker(new MarkerOptions().position(Youth_Centre).title("Youth Centre"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Fraserside_Community_Services));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);
    }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();
/*
        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }*/

        clicked++;
        marker.showInfoWindow();

        if(clicked == 2) {
            clicked = 0;
            if (marker.getTitle().equals("New Westminster Youth Centre")){
                Intent intent = new Intent(MapsActivity.this, CenterInformationActivity.class);
                intent.putExtra("index", 0);
                startActivity(intent);
            }
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }
}
