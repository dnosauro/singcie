package com.parse;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import bolts.Capture;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class LocationNotifier {
    private static Location fakeLocation;

    LocationNotifier() {
    }

    static Task<Location> getCurrentLocationAsync(Context context, long j, Criteria criteria) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final Capture capture = new Capture();
        final LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        final C26431 r8 = new LocationListener() {
            public void onLocationChanged(Location location) {
                if (location != null) {
                    ((ScheduledFuture) capture.get()).cancel(true);
                    taskCompletionSource.trySetResult(location);
                    locationManager.removeUpdates(this);
                }
            }

            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        capture.set(ParseExecutors.scheduled().schedule(new Runnable() {
            public void run() {
                taskCompletionSource.trySetError(new ParseException(124, "Location fetch timed out."));
                locationManager.removeUpdates(r8);
            }
        }, j, TimeUnit.MILLISECONDS));
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider != null) {
            locationManager.requestLocationUpdates(bestProvider, 0, 0.0f, r8);
        }
        Location location = fakeLocation;
        if (location != null) {
            r8.onLocationChanged(location);
        }
        return taskCompletionSource.getTask();
    }

    static void setFakeLocation(Location location) {
        fakeLocation = location;
    }
}
