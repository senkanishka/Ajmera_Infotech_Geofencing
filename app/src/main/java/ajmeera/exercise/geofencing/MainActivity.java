package ajmeera.exercise.geofencing;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private List<Geofence> geofences;
    private static final String TAG = "Geofencing";
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private GeofencingClient geofencingClient;
    private final float radius = 100f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        geofencingClient = LocationServices.getGeofencingClient(this);
        requestLocationPermission();
    }

    private void startMonitoringGeofences() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            geofences = new ArrayList<>();
            geofences.add(createGeofence("Geofence1", 12.953013054035946, 77.5417514266668,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence2", 12.95428866232216, 77.5438757362066,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence3", 12.95558517552543, 77.54565672299249,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence4", 12.956442543452548, 77.54752354046686,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence5", 12.95675621390793, 77.54919723889215,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence6", 12.957069883968225, 77.55112842938287,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence7", 12.957711349517467, 77.55308710458465,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence8", 12.958464154110917, 77.55514704110809,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence9", 12.959656090062529, 77.5559409749765,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence10", 12.960814324441305, 77.5574167738546,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence11", 12.961253455257907, 77.5592192183126,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence12", 12.96156308861349, 77.56126500049922,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence13", 12.961814019848779, 77.56308890262935,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence14", 12.962775920574138, 77.56592131534907,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence15", 12.963340512746937, 77.5676379291186,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence16", 12.96411114676894, 77.56951526792183,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence17", 12.964382986146292, 77.5717254081501,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence18", 12.964584624077109, 77.57370388966811,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence19", 12.964542802687657, 77.57591402989638,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence20", 12.963795326167373, 77.57798997552734,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence21", 12.96358621848664, 77.58015720041138,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));
            geofences.add(createGeofence("Geofence22", 12.963481664580394, 77.58189527185303,  Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT));

            addGeofences(geofences);
        }
    }

    private Geofence createGeofence(String id, double latitude, double longitude, int transitionTypes) {
        return new Geofence.Builder()
                .setRequestId(id)
                .setCircularRegion(latitude, longitude, radius)
                .setTransitionTypes(transitionTypes)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .build();
    }

    private void addGeofences(List<Geofence> geofences) {
        GeofencingRequest geofencingRequest = new GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofences(geofences)
                .build();

        @SuppressLint("MissingPermission")
        Task<Void> task = geofencingClient.addGeofences(geofencingRequest, getGeofencePendingIntent());

        task.addOnSuccessListener(aVoid -> Log.d(TAG, "Geofences added successfully"));

        task.addOnFailureListener(e -> Log.e(TAG, "Error adding geofences", e));
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private PendingIntent getGeofencePendingIntent() {
        Intent intent = new Intent(this, GeofenceBroadcastReceiver.class);
        return PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startMonitoringGeofences();
            }
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        startMonitoringGeofences();

        mMap = googleMap;

        for (int i = 0; i < geofences.size(); i++) {
            System.out.println("Hello: "+geofences.get(i).getLatitude());

            // below line is use to add marker to each location of our array list.
            mMap.addMarker(new MarkerOptions().position(new LatLng(geofences.get(i).getLatitude(), geofences.get(i).getLongitude())));

            addCircle(new LatLng(geofences.get(i).getLatitude(), geofences.get(i).getLongitude()));
            // below line is use to move our camera to the specific location.
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(geofences.get(i).getLatitude(), geofences.get(i).getLongitude()), 16));
        }
    }

    private void addCircle(LatLng latLng) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(latLng);
        circleOptions.radius((float) 100);
        circleOptions.strokeColor(Color.argb(255, 255, 0,0));
        circleOptions.fillColor(Color.argb(64, 255, 0,0));
        circleOptions.strokeWidth(4);
        mMap.addCircle(circleOptions);
    }
}