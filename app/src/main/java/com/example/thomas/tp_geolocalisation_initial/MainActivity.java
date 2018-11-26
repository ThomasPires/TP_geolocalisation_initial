package com.example.thomas.tp_geolocalisation_initial;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //éléments visuels
    private TextView print_loc;
    private Button start;
    private Button stop;
    private TextView print_address;
    private Button get_address;
    private TextView print_distance;

    //verrou pour bouton START et STOP
    private boolean started;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print_loc = (TextView) findViewById(R.id.print_loc);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        get_address = (Button) findViewById(R.id.get_address);
        print_address = (TextView) findViewById(R.id.print_address);
        print_distance = (TextView) findViewById(R.id.print_distance);



        started = false;

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!started) {
                    started = true;
                    startLocationUpdates();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (started) {
                    started = false;

                }
            }
        });

        get_address.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });


    }

    //Déclenche une méthode de mise à jour de la position par intervalle
    protected void startLocationUpdates() {




    }

    //appelé à chaque réception de nouvelle coordonnées
    public void onLocationChanged(Location location) {

    }


    /**
     * Calculate distance between two points in latitude and longitude.
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        return distance;
    }

}