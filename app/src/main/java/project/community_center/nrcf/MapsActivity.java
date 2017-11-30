package project.community_center.nrcf;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

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
    private int markerFlag = -1;
    private static boolean firstClick = true;
    DbHelper helper = new DbHelper(this);
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        db = helper.getReadableDatabase();
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

        // Add a marker for Park Canada Games Pool
        LatLng Canada_Games_Pool = new LatLng(49.22158156, -122.9072388);
        Marker mCanada_Games_Pool;

        // Add a marker for Park Centennial Community Centre
        LatLng Centennial_Community_Centre = new LatLng(49.20047229, -122.9163643);
        Marker mCentennial_Community_Centre;

        // Add a marker for Park Century House
        LatLng Century_House = new LatLng(49.21075625, -122.9250286);
        Marker mCentury_House;

        // Add a marker for Park Moody Park Arena
        LatLng Moody_Park_Arena = new LatLng(49.21556332, -122.9261784);
        Marker mMoody_Park_Arena;

        // Add a marker for Park Queens Park Arena
        LatLng Queens_Park_Arena = new LatLng(49.21482699, -122.9057725);
        Marker mQueens_Park_Arena;

        // Add a marker for Queensborough Community Centre
        LatLng Queensborough_Community_Centre = new LatLng(49.18588393, -122.9436169);
        Marker mQueensborough_Community_Centre;

        // Add a marker for Park Youth Centre
        LatLng Youth_Centre = new LatLng(49.21175625, -122.9270286);
        Marker mYouth_Centre;

        // .showInfoWindow();

        // Add some markers to the map, and add a data object to each marker.
        mYouth_Centre = mMap.addMarker(new MarkerOptions().position(Youth_Centre).
                title("New Westminster Youth Centre"));
        mYouth_Centre.setTag(0);

        mQueensborough_Community_Centre = mMap.addMarker(new MarkerOptions().position(Queensborough_Community_Centre)
                .title("Queensborough Community Centre"));
        mQueensborough_Community_Centre.setTag(1);

        mQueens_Park_Arena = mMap.addMarker(new MarkerOptions().position(Queens_Park_Arena)
                .title("Queens Park Arena"));
        mQueens_Park_Arena.setTag(2);

        mMoody_Park_Arena = mMap.addMarker(new MarkerOptions().position(Moody_Park_Arena)
               .title("Moody Park Arena"));
        mMoody_Park_Arena.setTag(3);

        mCentury_House = mMap.addMarker(new MarkerOptions().position(Century_House).
                title("Century House"));
        mCentury_House.setTag(4);

        mCentennial_Community_Centre = mMap.addMarker(new MarkerOptions().position(Centennial_Community_Centre).
                title("Centennial Community Centre"));
        mCentennial_Community_Centre.setTag(5);

        mCanada_Games_Pool = mMap.addMarker(new MarkerOptions().position(Canada_Games_Pool).
               title("Canada Games Pool"));
        mCanada_Games_Pool.setTag(6);



        mMap.moveCamera(CameraUpdateFactory.newLatLng(Century_House));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);
    }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        clicked++;

        if(clicked == 1 && firstClick) {
            markerFlag = (Integer) marker.getTag();
            firstClick = false;
        }

        if(markerFlag !=  (Integer) marker.getTag()) {
            firstClick = true;
            markerFlag = (Integer) marker.getTag();
            clicked = 0;
        }

        marker.showInfoWindow();

        if(clicked == 2 && (markerFlag ==  (Integer) marker.getTag()) ) {
            clicked = 0;
            firstClick = true;

            Center center = helper.getCenter(marker.getTitle());
            Intent intent = new Intent(MapsActivity.this, CenterInformationActivity.class);
            intent.putExtra("center", center);
            startActivity(intent);
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }
}
