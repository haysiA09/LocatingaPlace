package com.example.a16022877.locatingaplace;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        SupportMapFragment mapFragment=(SupportMapFragment) fm.findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map=googleMap;


                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);

                UiSettings ui2 = map.getUiSettings();
                ui2.setZoomControlsEnabled(true);

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                    Toast.makeText(MainActivity.this,"fgds",Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("GMap", "GPS access has not been granted");
                    Toast.makeText(MainActivity.this,"dasd",Toast.LENGTH_SHORT).show();
                }

                LatLng poi_northHQ=new LatLng(1.447621, 103.781279);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_northHQ)
                        .title("HQ - North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_big_on)));

                LatLng poi_central = new LatLng(1.307432, 103.832482);
                Marker orchard = map.addMarker(new
                        MarkerOptions()
                        .position(poi_central)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng poi_east = new LatLng(1.352225, 103.946231);
                Marker tamp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_east)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                btn3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if (map!=null){
                            LatLng poi_east = new LatLng(1.352225, 103.946231);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_east,
                                    15));

                        }
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if (map!=null){
                            LatLng poi_central = new LatLng(1.307432, 103.832482);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_central,
                                    15));

                        }
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if (map!=null){
                            LatLng poi_northHQ=new LatLng(1.447621, 103.781279);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_northHQ,
                                    15));

                        }
                    }
                });


            }
        });

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);


    }
}
