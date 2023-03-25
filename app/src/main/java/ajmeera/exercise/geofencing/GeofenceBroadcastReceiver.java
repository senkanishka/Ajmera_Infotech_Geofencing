package ajmeera.exercise.geofencing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "GeofenceBroadcastReceiv";

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        if (geofencingEvent.hasError()) {
            Log.d(TAG, "onReceive: Error receiving geofence event...");
            return;
        }

        List<Geofence> geofenceList = geofencingEvent.getTriggeringGeofences();
        for (Geofence geofence : geofenceList) {
            int transitionType = geofencingEvent.getGeofenceTransition();

            switch (transitionType) {
                case Geofence.GEOFENCE_TRANSITION_ENTER:
                    Log.d(TAG, "onReceive: " + geofence.getRequestId() + " GEOFENCE_TRANSITION_ENTER");
                    notificationHelper.sendHighPriorityNotification(geofence.getRequestId() + " GEOFENCE_TRANSITION_ENTER", "", MainActivity.class);
                    break;
                case Geofence.GEOFENCE_TRANSITION_DWELL:
                    Log.d(TAG, "onReceive: " + geofence.getRequestId() + " GEOFENCE_TRANSITION_DWELL");
                    Toast.makeText(context, geofence.getRequestId() + " GEOFENCE_TRANSITION_DWELL", Toast.LENGTH_SHORT).show();
                    notificationHelper.sendHighPriorityNotification(geofence.getRequestId() + " GEOFENCE_TRANSITION_DWELL", "", MainActivity.class);
                    break;
                case Geofence.GEOFENCE_TRANSITION_EXIT:
                    Log.d(TAG, "onReceive: " + geofence.getRequestId() + " GEOFENCE_TRANSITION_EXIT");
                    Toast.makeText(context, geofence.getRequestId() + " GEOFENCE_TRANSITION_EXIT", Toast.LENGTH_SHORT).show();
                    notificationHelper.sendHighPriorityNotification(geofence.getRequestId() + " GEOFENCE_TRANSITION_EXIT", "", MainActivity.class);
                    break;
            }
        }
    }
}
