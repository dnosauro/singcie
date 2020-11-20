package com.parse;

import android.location.Criteria;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import bolts.Continuation;
import bolts.Task;
import java.util.Locale;

public class ParseGeoPoint implements Parcelable {
    public static final Parcelable.Creator<ParseGeoPoint> CREATOR = new Parcelable.Creator<ParseGeoPoint>() {
        public ParseGeoPoint createFromParcel(Parcel parcel) {
            return new ParseGeoPoint(parcel, ParseParcelDecoder.get());
        }

        public ParseGeoPoint[] newArray(int i) {
            return new ParseGeoPoint[i];
        }
    };
    static double EARTH_MEAN_RADIUS_KM = 6371.0d;
    static double EARTH_MEAN_RADIUS_MILE = 3958.8d;
    private double latitude;
    private double longitude;

    public ParseGeoPoint() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    public ParseGeoPoint(double d, double d2) {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        setLatitude(d);
        setLongitude(d2);
    }

    protected ParseGeoPoint(Parcel parcel) {
        this(parcel, ParseParcelDecoder.get());
    }

    ParseGeoPoint(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        setLatitude(parcel.readDouble());
        setLongitude(parcel.readDouble());
    }

    public ParseGeoPoint(ParseGeoPoint parseGeoPoint) {
        this(parseGeoPoint.getLatitude(), parseGeoPoint.getLongitude());
    }

    public static Task<ParseGeoPoint> getCurrentLocationInBackground(long j) {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        criteria.setPowerRequirement(0);
        return LocationNotifier.getCurrentLocationAsync(Parse.getApplicationContext(), j, criteria).onSuccess(new Continuation<Location, ParseGeoPoint>() {
            public ParseGeoPoint then(Task<Location> task) {
                Location result = task.getResult();
                return new ParseGeoPoint(result.getLatitude(), result.getLongitude());
            }
        });
    }

    public static Task<ParseGeoPoint> getCurrentLocationInBackground(long j, Criteria criteria) {
        return LocationNotifier.getCurrentLocationAsync(Parse.getApplicationContext(), j, criteria).onSuccess(new Continuation<Location, ParseGeoPoint>() {
            public ParseGeoPoint then(Task<Location> task) {
                Location result = task.getResult();
                return new ParseGeoPoint(result.getLatitude(), result.getLongitude());
            }
        });
    }

    public static void getCurrentLocationInBackground(long j, Criteria criteria, LocationCallback locationCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getCurrentLocationInBackground(j, criteria), locationCallback);
    }

    public static void getCurrentLocationInBackground(long j, LocationCallback locationCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getCurrentLocationInBackground(j), locationCallback);
    }

    public int describeContents() {
        return 0;
    }

    public double distanceInKilometersTo(ParseGeoPoint parseGeoPoint) {
        return distanceInRadiansTo(parseGeoPoint) * EARTH_MEAN_RADIUS_KM;
    }

    public double distanceInMilesTo(ParseGeoPoint parseGeoPoint) {
        return distanceInRadiansTo(parseGeoPoint) * EARTH_MEAN_RADIUS_MILE;
    }

    public double distanceInRadiansTo(ParseGeoPoint parseGeoPoint) {
        double d = this.latitude * 0.017453292519943295d;
        double latitude2 = parseGeoPoint.getLatitude() * 0.017453292519943295d;
        double sin = Math.sin((d - latitude2) / 2.0d);
        double sin2 = Math.sin(((this.longitude * 0.017453292519943295d) - (parseGeoPoint.getLongitude() * 0.017453292519943295d)) / 2.0d);
        return Math.asin(Math.sqrt(Math.min(1.0d, (sin * sin) + (Math.cos(d) * Math.cos(latitude2) * sin2 * sin2)))) * 2.0d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ParseGeoPoint)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ParseGeoPoint parseGeoPoint = (ParseGeoPoint) obj;
        return parseGeoPoint.getLatitude() == this.latitude && parseGeoPoint.getLongitude() == this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double d) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
        }
        this.latitude = d;
    }

    public void setLongitude(double d) {
        if (d > 180.0d || d < -180.0d) {
            throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
        }
        this.longitude = d;
    }

    public String toString() {
        return String.format(Locale.US, "ParseGeoPoint[%.6f,%.6f]", new Object[]{Double.valueOf(this.latitude), Double.valueOf(this.longitude)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, ParseParcelEncoder.get());
    }

    /* access modifiers changed from: package-private */
    public void writeToParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }
}
